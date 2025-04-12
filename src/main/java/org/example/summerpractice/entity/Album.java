package org.example.summerpractice.entity;

import jakarta.persistence.*;
import org.example.summerpractice.entity.albumTrack.AlbumTrack;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate releaseDate;

    private String description;

    @OneToMany(mappedBy = "album", orphanRemoval = true)
    private List<AlbumTrack> tracks;

    public Album() {}

    public Album(String title, LocalDate releaseDate, String description) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AlbumTrack> getTracks() {
        return tracks;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Album album)) return false;
        return Objects.equals(id, album.id) && Objects.equals(title, album.title) && Objects.equals(releaseDate, album.releaseDate) && Objects.equals(description, album.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, description);
    }
}
