package org.example.summerpractice.service.track;

import jakarta.persistence.EntityNotFoundException;
import org.example.summerpractice.dto.TrackDTO;
import org.example.summerpractice.entity.*;
import org.example.summerpractice.entity.albumTrack.AlbumTrack;
import org.example.summerpractice.entity.composerTrack.ComposerTrack;
import org.example.summerpractice.entity.playListTrack.PlayListTrack;
import org.example.summerpractice.entity.trackGenre.TrackGenre;
import org.example.summerpractice.mappers.TrackConverter;
import org.example.summerpractice.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepository;
    private final ComposerRepository composerRepository;
    private final GenreRepository genreRepository;
    private final PlayListRepository playListRepository;
    private final AlbumRepository albumRepository;

    public TrackServiceImpl(TrackRepository trackRepository, ComposerRepository composerRepository,
                            GenreRepository genreRepository, PlayListRepository playListRepository,
                            AlbumRepository albumRepository) {
        this.trackRepository = trackRepository;
        this.composerRepository = composerRepository;
        this.genreRepository = genreRepository;
        this.playListRepository = playListRepository;
        this.albumRepository = albumRepository;
    }


    @Override
    public List<TrackDTO> getTracks() {
        return trackRepository.findAll().stream().map(TrackConverter::toTrackDTO).toList();
    }

    @Override
    public TrackDTO getTrackById(Long id) {
        Track track = trackRepository.findById(id).orElseThrow
                (() -> new EntityNotFoundException("Жанр с id " + id + " не существует"));

        return TrackConverter.toTrackDTO(track);
    }

    @Override
    public TrackDTO addTrack(TrackDTO trackDTO) {
        Track track = toTrack(trackDTO);
        return TrackConverter.toTrackDTO(trackRepository.save(track));
    }

    @Override
    public TrackDTO updateTrack(Long id, TrackDTO trackDTO) {
        Track updateTrack = toTrack(trackDTO);

        Track track = trackRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Трек с id " + id + " не найден"));

        track.setTitle(updateTrack.getTitle());
        track.setFilename(updateTrack.getFilename());
        track.setDescription(updateTrack.getDescription());
        track.setDurationSeconds(updateTrack.getDurationSeconds());

        track.getComposers().clear();
        track.getComposers().addAll(updateTrack.getComposers().
                stream()
                .map(it ->
                        new ComposerTrack(it.getComposer(), track))
                .toList());

        track.getGenres().clear();
        track.getGenres().addAll(updateTrack.getGenres().
                stream()
                .map(it ->
                        new TrackGenre(track, it.getGenre()))
                .toList());

        track.getPlayLists().clear();
        track.getPlayLists().addAll(updateTrack.getPlayLists().
                stream()
                .map(it ->
                        new PlayListTrack(it.getPlayList(), track))
                .toList());

        track.getAlbums().clear();
        track.getAlbums().addAll(updateTrack.getAlbums().
                stream()
                .map(it ->
                        new AlbumTrack(it.getAlbum(), track))
                .toList());

        return TrackConverter.toTrackDTO(trackRepository.save(track));
    }

    @Override
    public void deleteTrackById(Long id) {
        trackRepository.deleteById(id);
    }

    private Track toTrack(TrackDTO trackDTO) {
        Track track = new Track(
                trackDTO.getTitle(),
                trackDTO.getFilename(),
                trackDTO.getDescription(),
                trackDTO.getDurationSeconds()
        );

        List<ComposerTrack> composerTracks = getComposerTracks(trackDTO, track);
        track.setComposers(composerTracks);

        List<TrackGenre> trackGenres = getTrackGenres(trackDTO, track);
        track.setGenres(trackGenres);

        List<AlbumTrack> albumTracks = getAlbumTracks(trackDTO, track);
        track.setAlbums(albumTracks);

        List<PlayListTrack> playListTracks = getPlayListTracks(trackDTO, track);
        track.setPlayLists(playListTracks);

        return track;
    }

    private List<ComposerTrack> getComposerTracks(TrackDTO trackDTO, Track track) {
        return trackDTO.getComposersId().stream()
                .map(composerId -> {
                    Composer composer = composerRepository.findById(composerId)
                            .orElseThrow(() -> new
                                    EntityNotFoundException("Композитор с id " + composerId + " не найден"));
                    return new ComposerTrack(composer, track);
                })
                .toList();
    }

    private List<TrackGenre> getTrackGenres(TrackDTO trackDTO, Track track) {
        return trackDTO.getGenresId().stream()
                .map(genreId -> {
                    Genre genre = genreRepository.findById(genreId)
                            .orElseThrow(() -> new
                                    EntityNotFoundException("Жанр с id " + genreId + " не найден"));
                    return new TrackGenre(track, genre);
                })
                .toList();
    }

    private List<AlbumTrack> getAlbumTracks(TrackDTO trackDTO, Track track) {
        return trackDTO.getAlbumsId().stream()
                .map(albumId -> {
                    Album album = albumRepository.findById(albumId)
                            .orElseThrow(() -> new
                                    EntityNotFoundException("Альбом с id " + albumId + " не найден"));
                    return new AlbumTrack(album, track);
                })
                .toList();
    }

    private List<PlayListTrack> getPlayListTracks(TrackDTO trackDTO, Track track) {
        return trackDTO.getPlayListsId().stream()
                .map(playListId -> {
                    PlayList playList = playListRepository.findById(playListId)
                            .orElseThrow(() -> new
                                    EntityNotFoundException("Плейлист с id " + playListId + " не найден"));
                    return new PlayListTrack(playList, track);
                })
                .toList();
    }
}
