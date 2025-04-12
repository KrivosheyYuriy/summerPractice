package org.example.summerpractice.entity.composerTrack;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ComposerTrackId implements Serializable {
    @Column
    private Long composerId;

    @Column
    private Long trackId;

    public ComposerTrackId() {}

    public ComposerTrackId(Long composerId, Long trackId) {
        this.composerId = composerId;
        this.trackId = trackId;
    }

    public Long getTrackId() {
        return trackId;
    }

    public Long getComposerId() {
        return composerId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ComposerTrackId that)) return false;
        return Objects.equals(trackId, that.trackId) && Objects.equals(composerId, that.composerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackId, composerId);
    }
}
