package org.example.summerpractice.entity.playListTrack;

import jakarta.persistence.*;
import org.example.summerpractice.entity.PlayList;
import org.example.summerpractice.entity.Track;

import java.util.Objects;

@Entity
public class PlayListTrack {
    @EmbeddedId
    private PlayListTrackId id;

    @ManyToOne
    @MapsId("playListId")
    @JoinColumn
    private PlayList playList;

    @ManyToOne
    @MapsId("trackId")
    @JoinColumn
    private Track track;

    public PlayListTrack() {}

    public PlayListTrack(PlayList playList, Track track) {
        this.id = new PlayListTrackId(playList.getId(), track.getId());
        this.playList = playList;
        this.track = track;
    }

    public PlayListTrackId getId() {
        return id;
    }

    public PlayList getPlayList() {
        return playList;
    }

    public Track getTrack() {
        return track;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PlayListTrack that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
