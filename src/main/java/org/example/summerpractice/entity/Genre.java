package org.example.summerpractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.summerpractice.entity.trackGenre.TrackGenre;

import java.util.List;
import java.util.Objects;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @OneToMany(mappedBy = "genre", cascade =  CascadeType.ALL,  orphanRemoval = true)
    private List<TrackGenre> tracks;

    public Genre() {}

    public Genre(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TrackGenre> getTracks() {
        return tracks;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Genre genre)) return false;
        return Objects.equals(id, genre.id) && Objects.equals(title, genre.title) && Objects.equals(description, genre.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }
}
