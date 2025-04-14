package org.example.summerpractice.mappers;

import org.example.summerpractice.dto.TrackDTO;
import org.example.summerpractice.entity.Track;

import java.util.List;

public class TrackConverter {
    public static TrackDTO toTrackDTO(Track track) {
        List<Long> genresId = track.getGenres().stream()
                .map(it -> it.getGenre().getId())
                .toList();

        List<Long> composersId = track.getComposers().stream()
                .map(it -> it.getComposer().getId())
                .toList();

        List<Long> playListsId = track.getPlayLists().stream()
                .map(it -> it.getPlayList().getId())
                .toList();

        List<Long> albumsId = track.getAlbums().stream()
                .map(it -> it.getAlbum().getId())
                .toList();

        TrackDTO trackDTO = new TrackDTO(
                track.getId(),
                track.getTitle(),
                track.getFilename(),
                track.getDescription(),
                track.getDurationSeconds(),
                composersId,
                genresId,
                albumsId,
                playListsId
        );

        return trackDTO;
    }
}
