package io.shirohoo.realworld.domain.article;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import io.shirohoo.realworld.domain.rating.Rating;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import io.shirohoo.realworld.domain.user.User;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id
    @Column(name = "article_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(length = 50, nullable = false)
    private String description;

    @Column(length = 50, unique = true, nullable = false)
    private String title;

    @Column(length = 50, unique = true, nullable = false)
    private String slug;

    @Column(length = 1_000, nullable = false)
    private String content = "";

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ArticleFavorite> favoriteUsers = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rating> ratings = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ArticleTag> includeTags = new HashSet<>();

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    private Article(Integer id, User author, String description, String title, String content) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.title = title;
        this.slug = createSlugBy(title);
        this.content = content;
        this.favoriteUsers = new HashSet<>();
        this.includeTags = new HashSet<>();
        this.ratings = new HashSet<>();
        this.createdAt = LocalDateTime.now();
    }


    public void addRating(Rating rating){
        this.ratings.add(rating);
    }
    public void deleteRating(Rating rating){
        this.ratings.remove(rating);
    }
    public void updateTitle(String title) {
        if (title == null || title.isBlank()) {
            return;
        }

        this.title = title;
        this.slug = createSlugBy(title);
    }

    public void updateDescription(String description) {
        if (description == null || description.isBlank()) {
            return;
        }

        this.description = description;
    }

    public void updateContent(String content) {
        if (content == null || content.isBlank()) {
            return;
        }

        this.content = content;
    }

    public boolean isNotWritten(User user) {
        return !this.author.equals(user);
    }

    public int numberOfLikes() {
        return this.favoriteUsers.size();
    }

    public void addTag(Tag tag) {
        if (tag == null) {
            throw new IllegalArgumentException("tag must not be null");
        }

        ArticleTag articleTag = new ArticleTag(this, tag);

        if (this.includeTags.stream().anyMatch(articleTag::equals)) {
            return;
        }

        this.includeTags.add(articleTag);
    }

    public List<Tag> getTags() {
        return this.includeTags.stream().map(ArticleTag::getTag).toList();
    }

    public List<Rating> getRatings() {
        return this.ratings.stream().toList();
    }

    public String[] getTagNames() {
        return this.getTags().stream().map(Tag::getName).sorted().toArray(String[]::new);
    }

    public boolean equalsArticle(ArticleFavorite articleFavorite) {
        if (articleFavorite == null) {
            throw new IllegalArgumentException("articleFavorite must not be null");
        }

        return Objects.equals(this, articleFavorite.getArticle());
    }

    private String createSlugBy(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be null or blank");
        }

        return title.toLowerCase().replaceAll("\\s+", "-");
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Article other && Objects.equals(this.id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);

    }

    @Override
    public String toString() {
        return "Article{" +
            "id=" + id +
            ", author=" + author +
            ", title='" + title + '\'' +
            ", updatedAt=" + updatedAt +
            '}';
    }
}
