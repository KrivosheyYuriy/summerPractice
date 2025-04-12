package org.example.summerpractice.entity.trackGenre;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TrackGenreId implements Serializable {
    @Column
    private Long trackId;

    @Column
    private Long genreId;

    public TrackGenreId() {}

    public TrackGenreId(Long trackId, Long genreId) {
        this.trackId = trackId;
        this.genreId = genreId;
    }

    public Long getTrackId() {
        return trackId;
    }

    public Long getGenreId() {
        return genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TrackGenreId that)) return false;
        return Objects.equals(trackId, that.trackId) && Objects.equals(genreId, that.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackId, genreId);
    }
}
