package io.shirohoo.realworld.application.rating;


import io.shirohoo.realworld.domain.rating.Rating;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService){
        this.ratingService = ratingService;
    }

    private final RatingService ratingService;
    private final ArticleService articleService;

    @GetMapping("/api/ratings/{slug}")
    public List<Rating> getRatings(@PathVariable String slug) {
        Integer articleId = articleService.getArticleId(slug);
        return ratingService.getRatingsByArticleId(articleId);
    }


    @PostMapping("/api/ratings")
        public Rating createRating(@RequestBody Rating rating){

        return ratingService.createRating(rating);
        }

}
