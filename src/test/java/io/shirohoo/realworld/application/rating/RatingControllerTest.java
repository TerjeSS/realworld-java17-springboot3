package io.shirohoo.realworld.application.rating;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.shirohoo.realworld.IntegrationTest;
import io.shirohoo.realworld.domain.article.Article;
import io.shirohoo.realworld.domain.article.ArticleRepository;
import io.shirohoo.realworld.domain.rating.Rating;
import io.shirohoo.realworld.domain.user.User;
import io.shirohoo.realworld.domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
public class RatingControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ObjectMapper objectMapper;


    Article effectiveJava;
    User james;

    @BeforeEach
    void setup(){
        james = User.builder()
            .email("james@example.com")
            .username("james")
            .password("password")
            .build();
        userRepository.save(james);

        effectiveJava = Article.builder()
            .description("description")
            .title("Effective Java")
            .author(james)
            .content("content")
            .build();
        articleRepository.save(effectiveJava);
    }

    @Test
    public void givenNonExistingArticleIdShouldReturn404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ratings/{slug}", "effective-java"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    public void givenExistingArticleShouldReturnListOfRating() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ratings/{slug}", "existing-slug"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.rating").value( 10));

    }

    @Test
    public void testCreateRating() throws Exception {

        Rating rating = new Rating();
        rating.setRating(4);
        rating.setArticle(effectiveJava);
        rating.setUser(james);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/ratings")
            .content(objectMapper.writeValueAsString(rating))
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().is2xxSuccessful());

    }
}


