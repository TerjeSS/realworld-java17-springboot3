package io.shirohoo.realworld.application.rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RatingController {
    @GetMapping("/api/ratings/{slug}")
    public List<String> getSingleArticle(@PathVariable String slug) {
        return List.of();
    }
}
