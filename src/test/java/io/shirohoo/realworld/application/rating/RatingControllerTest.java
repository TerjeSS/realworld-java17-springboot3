package io.shirohoo.realworld.application.rating;

import io.shirohoo.realworld.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@IntegrationTest
public class RatingControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
}
