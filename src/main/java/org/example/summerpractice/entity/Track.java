package org.example.summerpractice.entity;

import jakarta.persistence.*;
import org.example.summerpractice.entity.albumTrack.AlbumTrack;
import org.example.summerpractice.entity.composerTrack.ComposerTrack;
import org.example.summerpractice.entity.playListTrack.PlayListTrack;
import org.example.summerpractice.entity.trackGenre.TrackGenre;

import java.util.List;
import java.util.Objects;

@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String filename;

    @Column
    private String description;

    @Column(nullable = false)
    private int durationSeconds;

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrackGenre> genres = List.of();

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComposerTrack> composers = List.of();

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlbumTrack> albums = List.of();

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayListTrack> playLists = List.of();

    public Track() {}

    public Track(String title, String filename, String description, int durationSeconds) {
        this.title = title;
        this.description = description;
        this.filename = filename;
        this.durationSeconds = durationSeconds;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public String getFilename() {
        return filename;
    }

    public List<TrackGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<TrackGenre> genres) {
        this.genres = genres;
    }

    public List<ComposerTrack> getComposers() {
        return composers;
    }

    public void setComposers(List<ComposerTrack> composers) {
        this.composers = composers;
    }

    public List<AlbumTrack> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumTrack> albums) {
        this.albums = albums;
    }

    public List<PlayListTrack> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(List<PlayListTrack> playLists) {
        this.playLists = playLists;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Track track)) return false;
        return durationSeconds == track.durationSeconds && Objects.equals(id, track.id) && Objects.equals(title, track.title) && Objects.equals(description, track.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, durationSeconds);
    }
}
