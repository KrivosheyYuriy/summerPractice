package org.example.summerpractice.service.playlist;

import jakarta.persistence.EntityNotFoundException;
import org.example.summerpractice.dto.PlayListDTO;
import org.example.summerpractice.entity.PlayList;
import org.example.summerpractice.entity.Track;
import org.example.summerpractice.entity.playListTrack.PlayListTrack;
import org.example.summerpractice.mappers.PlayListConverter;
import org.example.summerpractice.repository.PlayListRepository;
import org.example.summerpractice.repository.TrackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayListServiceImpl implements PlayListService {
    private final PlayListRepository playListRepository;
    private final TrackRepository trackRepository;

    public PlayListServiceImpl(PlayListRepository playListRepository,  TrackRepository trackRepository) {
        this.playListRepository = playListRepository;
        this.trackRepository = trackRepository;
    }

    @Override
    public List<PlayListDTO> getPlayLists() {
        return playListRepository.findAll().stream().map(PlayListConverter::toPlayListDTO).toList();
    }

    @Override
    public PlayListDTO getPlayListById(Long id) {
        PlayList playList = playListRepository.findById(id).orElseThrow
                (() -> new EntityNotFoundException("Плейлист с id " + id + " не существует"));

        return PlayListConverter.toPlayListDTO(playList);
    }

    @Override
    public PlayListDTO addPlayList(PlayListDTO playListDTO) {
        PlayList playList = toPlayList(playListDTO);
        return PlayListConverter.toPlayListDTO(playListRepository.save(playList));
    }

    @Override
    public PlayListDTO updatePlayList(Long id, PlayListDTO playListDTO) {
        PlayList updatePlayList = toPlayList(playListDTO);

        PlayList playList = playListRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Плейлист с id " + id + " не найден"));

        playList.setTitle(updatePlayList.getTitle());
        playList.setDescription(updatePlayList.getDescription());

        playList.getTracks().clear();
        playList.getTracks().addAll(updatePlayList.getTracks()
                .stream()
                .map(it -> new PlayListTrack(playList, it.getTrack()))
                .toList());

        return PlayListConverter.toPlayListDTO(playListRepository.save(playList));
    }

    @Override
    public void deletePlayListById(Long id) {
        playListRepository.deleteById(id);
    }

    private PlayList toPlayList(PlayListDTO playListDTO) {
        PlayList playList = new PlayList(
                playListDTO.getTitle(),
                playListDTO.getDescription()
        );

        playList.setTracks(getAlbumTracks(playListDTO, playList));

        return playList;
    }

    private List<PlayListTrack> getAlbumTracks(PlayListDTO playListDTO, PlayList playList) {
        return playListDTO.getTracksId().stream()
                .map(albumId -> {
                    Track track = trackRepository.findById(albumId)
                            .orElseThrow(() -> new
                                    EntityNotFoundException("Альбом с id " + albumId + " не найден"));
                    return new PlayListTrack(playList, track);
                })
                .toList();
    }
}
