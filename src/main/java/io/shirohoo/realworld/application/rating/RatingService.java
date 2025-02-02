package io.shirohoo.realworld.application.rating;
import io.shirohoo.realworld.domain.rating.Rating;
import io.shirohoo.realworld.domain.rating.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;

    }


    public Rating createRating(Rating rating){

        if (rating.getRating() > 5 || rating.getRating() < 0) {
             throw new IllegalArgumentException("Rating out of bounds");
        }
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsByArticleId(Integer id){
        return ratingRepository.findAllRatingsByArticleId(id);
    }

}
