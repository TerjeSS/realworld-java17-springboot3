package io.shirohoo.realworld.application.rating;


import io.shirohoo.realworld.IntegrationTest;
import io.shirohoo.realworld.domain.article.Article;
import io.shirohoo.realworld.domain.article.ArticleRepository;
import io.shirohoo.realworld.domain.rating.Rating;
import io.shirohoo.realworld.domain.rating.RatingRepository;
import io.shirohoo.realworld.domain.user.User;
import io.shirohoo.realworld.domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IntegrationTest
@DisplayName("RatingService should")
public class RatingServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;
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
    @DisplayName("add rating to exisitng article to check relation")
    public void addRatingToArticle(){
        Rating rating = new Rating();
        rating.setArticle(effectiveJava);
        rating.setUser(james);
        rating.setRating(4);

        ratingRepository.save(rating);
        effectiveJava.addRating(rating);
        Article ratedArticle = articleRepository.findById(effectiveJava.getId()).get();

        assertTrue(ratedArticle.getRatings().size() > 0);
    }

    @Test
    @DisplayName("delete rating from article")
    public void deleteRatingFromArticle(){
        Rating rating = new Rating();
        rating.setArticle(effectiveJava);
        rating.setUser(james);
        rating.setRating(4);

        ratingRepository.save(rating);
        effectiveJava.addRating(rating);
        ratingRepository.delete(rating);
        effectiveJava.deleteRating(rating);
        Article ratedArticle = articleRepository.findById(effectiveJava.getId()).get();

        assertTrue(ratedArticle.getRatings().isEmpty());
    }
}
