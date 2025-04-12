package org.example.summerpractice.entity.composerTrack;

import jakarta.persistence.*;
import org.example.summerpractice.entity.Composer;
import org.example.summerpractice.entity.Track;

import java.util.Objects;

@Entity
public class ComposerTrack {
    @EmbeddedId
    private ComposerTrackId id;

    @ManyToOne
    @MapsId("composerId")
    @JoinColumn
    private Composer composer;

    @ManyToOne
    @MapsId("trackId")
    @JoinColumn
    private Track track;

    public ComposerTrack(Composer composer, Track track) {
        this.id = new ComposerTrackId(composer.getId(), track.getId());
        this.composer = composer;
        this.track = track;
    }

    public ComposerTrack() {}

    public ComposerTrackId getId() {
        return id;
    }

    public Track getTrack() {
        return track;
    }

    public Composer getComposer() {
        return composer;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ComposerTrack that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
