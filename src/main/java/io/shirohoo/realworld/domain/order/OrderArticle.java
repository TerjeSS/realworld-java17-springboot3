package io.shirohoo.realworld.domain.order;


import io.shirohoo.realworld.domain.article.Article;
import jakarta.persistence.*;

@Entity
public class OrderArticle {
    @EmbeddedId
    private OrderArticleId id;

    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @MapsId("articleId")
    @JoinColumn(name = "article_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;

    public Order getArticleOrder() {
        return order;
    }

    public void setArticleOrder(Order order) {
        this.order = order;
    }

    public OrderArticle(Order order, Article article) {
        this.id = new OrderArticleId(order.getId(), article.getId());
        this.order = order;
        this.article = article;
    }

    public OrderArticle() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public OrderArticleId getId() {
        return id;
    }

    public void setId(OrderArticleId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrderArticle{" +
            "article=" + article +
            '}';
    }
}
