package org.example.summerpractice.entity.albumTrack;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AlbumTrackId implements Serializable {
    @Column
    private Long albumId;

    @Column
    private Long trackId;

    public AlbumTrackId() {}

    public AlbumTrackId(Long albumId, Long trackId) {
        this.albumId = albumId;
        this.trackId = trackId;
    }

    public Long getTrackId() {
        return trackId;
    }

    public Long getAlbumId() {
        return albumId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AlbumTrackId that)) return false;
        return Objects.equals(albumId, that.albumId) && Objects.equals(trackId, that.trackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumId, trackId);
    }
}
