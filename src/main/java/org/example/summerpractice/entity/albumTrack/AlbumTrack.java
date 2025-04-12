package org.example.summerpractice.entity.albumTrack;

import jakarta.persistence.*;
import org.example.summerpractice.entity.Album;
import org.example.summerpractice.entity.Track;

import java.util.Objects;

@Entity
public class AlbumTrack {
    @EmbeddedId
    private AlbumTrackId id;

    @ManyToOne
    @MapsId("albumId")
    @JoinColumn
    private Album album;

    @ManyToOne
    @MapsId("trackId")
    @JoinColumn
    private Track track;

    public AlbumTrack() {}

    public AlbumTrack(Album album, Track track) {
        this.id = new AlbumTrackId(album.getId(), track.getId());
        this.album = album;
        this.track = track;
    }

    public AlbumTrackId getId() {
        return id;
    }

    public Album getAlbum() {
        return album;
    }

    public Track getTrack() {
        return track;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AlbumTrack that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}