package com.usmteam3.votingapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "heading_text")
    private String headingText;

    @Column(name = "feedback_text")
    private String feedbackText;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="coffee_shop_id")
    private CoffeeShop coffeeShop;

    public Feedback() {
    }

    public Feedback(Long id, String headingText, String feedbackText, User user,
                    CoffeeShop coffeeShop) {
        this.id = id;
        this.headingText = headingText;
        this.feedbackText = feedbackText;
        this.user = user;
        this.coffeeShop = coffeeShop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeadingText() {
        return headingText;
    }

    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CoffeeShop getCoffeeShop() {
        return coffeeShop;
    }

    public void setCoffeeShop(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", headingText='" + headingText + '\'' +
                ", user=" + user +
                ", coffeeShop=" + coffeeShop +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return id.equals(feedback.id) &&
                Objects.equals(headingText, feedback.headingText) &&
                Objects.equals(feedbackText, feedback.feedbackText) &&
                Objects.equals(user, feedback.user) &&
                Objects.equals(coffeeShop, feedback.coffeeShop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, headingText, feedbackText, user, coffeeShop);
    }
}
