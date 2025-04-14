package org.example.summerpractice.mappers;

import org.example.summerpractice.dto.AlbumDto;
import org.example.summerpractice.entity.Album;

public class AlbumConverter {
    public static AlbumDto toAlbumDTO(Album album) {
        AlbumDto albumDto = new AlbumDto(
                album.getId(),
                album.getTitle(),
                album.getDescription(),
                album.getReleaseDate(),
                album.getTracks().stream().map(it -> it.getTrack().getId()).toList()
        );
        return albumDto;
    }
}
