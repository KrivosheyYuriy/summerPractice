package org.example.summerpractice.entity;

import jakarta.persistence.*;
import org.example.summerpractice.entity.playListTrack.PlayListTrack;

import java.util.List;
import java.util.Objects;

@Entity
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @OneToMany(mappedBy = "playList", orphanRemoval = true)
    private List<PlayListTrack> tracks = List.of();

    public PlayList() {}

    public PlayList(String title, String description) {
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

    public List<PlayListTrack> getTracks() {
        return tracks;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PlayList playList)) return false;
        return Objects.equals(id, playList.id) && Objects.equals(title, playList.title) && Objects.equals(description, playList.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }
}
