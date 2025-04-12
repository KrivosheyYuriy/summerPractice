package org.example.summerpractice.entity.trackGenre;

import jakarta.persistence.*;
import org.example.summerpractice.entity.Genre;
import org.example.summerpractice.entity.Track;

import java.util.Objects;

@Entity
public class TrackGenre {
    @EmbeddedId
    private TrackGenreId id;

    @ManyToOne
    @MapsId("trackId")
    @JoinColumn
    private Track track;

    @ManyToOne
    @MapsId("genreId")
    @JoinColumn
    private Genre genre;

    public TrackGenre() {}

    public TrackGenre(Track track, Genre genre) {
        this.id = new TrackGenreId(track.getId(), genre.getId());
        this.track = track;
        this.genre = genre;
    }

    public TrackGenreId getId() {
        return id;
    }

    public Track getTrack() {
        return track;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TrackGenre that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
