package io.shirohoo.realworld.application.rating;


import io.shirohoo.realworld.domain.rating.Rating;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService){
        this.ratingService = ratingService;
    }

    @GetMapping("/api/ratings/{slug}")
    public List<String> getSingleArticle(@PathVariable String slug) {
        return List.of();
    }


    @PostMapping("/api/ratings")
        public Rating createRating(@RequestBody Rating rating){

        return ratingService.createRating(rating);
        }

}
