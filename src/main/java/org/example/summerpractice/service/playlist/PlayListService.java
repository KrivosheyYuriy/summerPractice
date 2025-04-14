package org.example.summerpractice.service.playlist;

import org.example.summerpractice.dto.PlayListDTO;

import java.util.List;

public interface PlayListService {
    List<PlayListDTO> getPlayLists();

    PlayListDTO getPlayListById(Long id);

    PlayListDTO addPlayList(PlayListDTO playListDTO);

    PlayListDTO updatePlayList(Long id, PlayListDTO playListDTO);

    void deletePlayListById(Long id);
}
