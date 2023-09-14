package io.shirohoo.realworld.domain.rating;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Integer> {

    List<Rating> findAllRatingsByArticleId(Integer id);

}
