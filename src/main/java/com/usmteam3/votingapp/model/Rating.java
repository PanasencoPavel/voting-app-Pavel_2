package com.usmteam3.votingapp.model;

import com.usmteam3.votingapp.model.enums.Note;
import com.usmteam3.votingapp.util.NoteConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rate")
public class Rating implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coffee_shop_id")
    private CoffeeShop coffeeShop;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

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

    @Column(name = "filename")
    private String filename;

}
