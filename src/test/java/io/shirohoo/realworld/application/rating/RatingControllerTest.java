package io.shirohoo.realworld.application.rating;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.shirohoo.realworld.IntegrationTest;
import io.shirohoo.realworld.domain.article.Article;
import io.shirohoo.realworld.domain.article.ArticleRepository;
import io.shirohoo.realworld.domain.rating.Rating;

import io.shirohoo.realworld.domain.rating.RatingRequest;

import io.shirohoo.realworld.domain.rating.RatingRepository;

import io.shirohoo.realworld.domain.user.User;
import io.shirohoo.realworld.domain.user.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.Map;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
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
    @Autowired
    RatingRepository ratingRepository;

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
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ratings/{slug}", "wrong-slug"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    public void givenExistingArticleShouldReturnListOfRatings() throws Exception {
        Rating rating = new Rating();
        rating.setArticle(effectiveJava);
        rating.setUser(james);
        rating.setRating(4);
        ratingRepository.save(rating);
        effectiveJava.addRating(rating);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/ratings/{slug}", "effective-java"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].rating").value(4))
                .andDo(MockMvcResultHandlers.print())                                       ;
       //         .andExpect(jsonPath("$.rating.rating").value(10));
    }

    @Test
    public void testCreateRating() throws Exception {



        RatingRequest request = new RatingRequest();
        request.setArticleId(effectiveJava.getId());
        request.setRating(4);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/ratings")
            .content(objectMapper.writeValueAsString(Map.of("rating", request)))
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().is2xxSuccessful());
    }
}


