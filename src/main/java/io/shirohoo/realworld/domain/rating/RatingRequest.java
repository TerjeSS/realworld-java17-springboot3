package io.shirohoo.realworld.domain.rating;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("rating")
public class RatingRequest {

    private int articleId;
    private Integer rating;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
