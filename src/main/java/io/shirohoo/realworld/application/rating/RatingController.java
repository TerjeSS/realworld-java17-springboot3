package io.shirohoo.realworld.application.rating;


import io.shirohoo.realworld.application.article.service.ArticleService;
import io.shirohoo.realworld.domain.article.ArticleRepository;
import io.shirohoo.realworld.domain.rating.Rating;
import io.shirohoo.realworld.domain.rating.RatingRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    private final RatingService ratingService;
    private final ArticleService articleService;
    private final ArticleRepository articleRepository;

    public RatingController(RatingService ratingService, ArticleService articleService, ArticleRepository articleRepository){
        this.ratingService = ratingService;
        this.articleService = articleService;
        this.articleRepository = articleRepository;
    }


    @GetMapping("/api/ratings/{slug}")
    public List<Rating> getRatings(@PathVariable String slug) {
        Integer articleId = articleService.getArticleId(slug);
        return ratingService.getRatingsByArticleId(articleId);
    }


    @PostMapping("/api/ratings")
        public Rating createRating(@RequestBody RatingRequest request){

        Rating rating = new Rating();
        rating.setRating(request.getRating());
        rating.setArticle(articleRepository.findById(request.getArticleId()).get());
        return ratingService.createRating(rating);
        }

}
