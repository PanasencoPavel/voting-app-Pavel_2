package com.usmteam3.votingapp.model;

import com.usmteam3.votingapp.model.enums.Note;
import com.usmteam3.votingapp.util.NoteConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "rate")
public class Rating implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="coffee_shop_id")
    private CoffeeShop coffeeShop;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "food_note")
    @Convert(converter = NoteConverter.class)
    private Note foodNote;

    @Column(name = "coffee_note")
    @Convert(converter = NoteConverter.class)
    private Note coffeeNote;

    @Column(name = "service_note")
    @Convert(converter = NoteConverter.class)
    private Note serviceNote;

    @Column(name = "atmosphere_note")
    @Convert(converter = NoteConverter.class)
    private Note atmosphereNote;

    public Rating() {
    }

    public Rating(Long id, CoffeeShop coffeeShop, User user,
                  Note foodNote, Note coffeeNote, Note serviceNote, Note atmosphereNote) {
        this.id = id;
        this.coffeeShop = coffeeShop;
        this.user = user;
        this.foodNote = foodNote;
        this.coffeeNote = coffeeNote;
        this.serviceNote = serviceNote;
        this.atmosphereNote = atmosphereNote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoffeeShop getCoffeeShop() {
        return coffeeShop;
    }

    public void setCoffeeShop(CoffeeShop coffeeShop) {
        this.coffeeShop = coffeeShop;
    }

    public Note getFoodNote() {
        return foodNote;
    }

    public void setFoodNote(Note foodNote) {
        this.foodNote = foodNote;
    }

    public Note getCoffeeNote() {
        return coffeeNote;
    }

    public void setCoffeeNote(Note coffeeNote) {
        this.coffeeNote = coffeeNote;
    }

    public Note getServiceNote() {
        return serviceNote;
    }

    public void setServiceNote(Note serviceNote) {
        this.serviceNote = serviceNote;
    }

    public Note getAtmosphereNote() {
        return atmosphereNote;
    }

    public void setAtmosphereNote(Note atmosphereNote) {
        this.atmosphereNote = atmosphereNote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return id.equals(rating.id) &&
                Objects.equals(coffeeShop, rating.coffeeShop) &&
                Objects.equals(user, rating.user) &&
                foodNote == rating.foodNote &&
                coffeeNote == rating.coffeeNote &&
                serviceNote == rating.serviceNote &&
                atmosphereNote == rating.atmosphereNote;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coffeeShop, user, foodNote,
                coffeeNote, serviceNote, atmosphereNote);
    }

}
