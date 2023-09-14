package io.shirohoo.realworld.application.rating;
import io.shirohoo.realworld.application.article.service.ArticleService;
import io.shirohoo.realworld.domain.rating.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;
    private final ArticleService articleService;

    @GetMapping("/api/ratings/{slug}")
    public List<Rating> getRatings(@PathVariable String slug) {
        Integer articleId = articleService.getArticleId(slug);
        return ratingService.getRatingsByArticleId(articleId);
    }

}
