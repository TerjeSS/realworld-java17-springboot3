package io.shirohoo.realworld.application.rating;

import io.shirohoo.realworld.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@IntegrationTest
public class RatingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenArticleIdShouldReturnListOfRatings() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ratings/{slug}", "effective-java"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
