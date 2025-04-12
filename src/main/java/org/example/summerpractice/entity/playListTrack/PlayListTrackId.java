package org.example.summerpractice.entity.playListTrack;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlayListTrackId implements Serializable {
    @Column
    private Long playListId;

    @Column
    private Long trackId;

    public PlayListTrackId() {}

    public PlayListTrackId(Long playListId, Long trackId) {
        this.playListId = playListId;
        this.trackId = trackId;
    }

    public Long getPlayListId() {
        return playListId;
    }

    public Long getTrackId() {
        return trackId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PlayListTrackId that)) return false;
        return Objects.equals(playListId, that.playListId) && Objects.equals(trackId, that.trackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playListId, trackId);
    }
}
