package org.example.summerpractice.service.album;

import jakarta.persistence.EntityNotFoundException;
import org.example.summerpractice.dto.AlbumDto;
import org.example.summerpractice.entity.Album;
import org.example.summerpractice.entity.Track;
import org.example.summerpractice.entity.albumTrack.AlbumTrack;
import org.example.summerpractice.mappers.AlbumConverter;
import org.example.summerpractice.repository.AlbumRepository;
import org.example.summerpractice.repository.TrackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final TrackRepository trackRepository;

    public  AlbumServiceImpl(AlbumRepository albumRepository, TrackRepository trackRepository) {
        this.albumRepository = albumRepository;
        this.trackRepository = trackRepository;
    }

    @Override
    public List<AlbumDto> getAlbums() {
        return albumRepository.findAll().stream().map(AlbumConverter::toAlbumDTO).toList();
    }

    @Override
    public AlbumDto getAlbumById(Long id) {
        return albumRepository.findById(id).map(AlbumConverter::toAlbumDTO).orElseThrow
                (() -> new EntityNotFoundException("Альбом с id " + id + " не существует"));
    }

    @Override
    public AlbumDto addAlbum(AlbumDto albumDTO) {
        Album album = toAlbum(albumDTO);
        return AlbumConverter.toAlbumDTO(albumRepository.save(album));
    }

    @Override
    public AlbumDto updateAlbum(Long id, AlbumDto albumDTO) {
        Album updateAlbum = toAlbum(albumDTO);

        Album album = albumRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Альбом с id " + id + " не найден"));

        album.setTitle(updateAlbum.getTitle());
        album.setDescription(updateAlbum.getDescription());
        album.setReleaseDate(updateAlbum.getReleaseDate());

        album.getTracks().clear();
        album.getTracks().addAll(updateAlbum.getTracks()
                .stream()
                .map(it -> new AlbumTrack(album, it.getTrack()))
                .toList());

        return AlbumConverter.toAlbumDTO(albumRepository.save(album));
    }

    @Override
    public void deleteAlbumById(Long id) {
        albumRepository.deleteById(id);
    }

    private Album toAlbum(AlbumDto albumDto) {
        Album album = new Album(
                albumDto.getTitle(),
                albumDto.getDescription(),
                albumDto.getReleaseDate()
        );

        album.setTracks(getAlbumTracks(albumDto, album));

        return album;
    }

    private List<AlbumTrack> getAlbumTracks(AlbumDto albumDto, Album album) {
        return albumDto.getTracksId().stream()
                .map(albumId -> {
                    Track track = trackRepository.findById(albumId)
                            .orElseThrow(() -> new
                                    EntityNotFoundException("Альбом с id " + albumId + " не найден"));
                    return new AlbumTrack(album, track);
                })
                .toList();
    }
}
