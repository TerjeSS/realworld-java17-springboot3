package io.shirohoo.realworld.domain.order;


import io.shirohoo.realworld.domain.user.User;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private String email;
    private String snailMailAddress;
    private boolean processed = false;
    private ErrorType errorType;
    private Integer price;
    @OneToMany(mappedBy = "article" )
    private Set<OrderArticle> orderArticles = new HashSet<>();

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getSnailMailAddress() {
        return snailMailAddress;
    }

    public boolean isProcessed() {
        return processed;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSnailMailAddress(String snailMailAddress) {
        this.snailMailAddress = snailMailAddress;
    }

    public void addOrderArticle(OrderArticle orderArticle) {
        this.orderArticles.add(orderArticle);

    }
    public Set<OrderArticle> getOrderArticles() {
        return orderArticles;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }



    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    enum ErrorType{
        UNKNOWN, INVALID_ADDRESS
    }

    @Override
    public String toString() {
        return "Orders{" +
            "id=" + id +
            ", user_id=" + user +
            ", email='" + email + '\'' +
            ", snailMailAddress='" + snailMailAddress + '\'' +
            ", processed=" + processed +
            ", errorType=" + errorType +
            ", price=" + price +
            ", orderArticles=" + orderArticles +
            '}';
    }
}

