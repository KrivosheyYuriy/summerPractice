package org.example.summerpractice.service.album;

import org.example.summerpractice.dto.AlbumDto;

import java.util.List;

public interface AlbumService {
    List<AlbumDto> getAlbums();

    AlbumDto getAlbumById(Long id);

    AlbumDto addAlbum(AlbumDto albumDTO);

    AlbumDto updateAlbum(Long id, AlbumDto albumDTO);

    void deleteAlbumById(Long id);
}
