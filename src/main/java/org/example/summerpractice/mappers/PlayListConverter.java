package org.example.summerpractice.mappers;

import org.example.summerpractice.dto.PlayListDTO;
import org.example.summerpractice.entity.PlayList;

public class PlayListConverter {
    public static PlayListDTO toPlayListDTO(PlayList playList) {
        PlayListDTO playListDTO = new PlayListDTO(
                playList.getId(),
                playList.getTitle(),
                playList.getDescription(),
                playList.getTracks().stream().map(it -> it.getTrack().getId()).toList()
        );
        return playListDTO;
    }
}
