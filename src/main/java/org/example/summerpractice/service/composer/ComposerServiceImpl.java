package org.example.summerpractice.service.composer;

import jakarta.persistence.EntityNotFoundException;
import org.example.summerpractice.dto.ComposerDTO;
import org.example.summerpractice.entity.Composer;
import org.example.summerpractice.entity.Track;
import org.example.summerpractice.entity.composerTrack.ComposerTrack;
import org.example.summerpractice.mappers.ComposerConverter;
import org.example.summerpractice.repository.ComposerRepository;
import org.example.summerpractice.repository.TrackRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComposerServiceImpl implements ComposerService {
    private final ComposerRepository composerRepository;
    private final TrackRepository trackRepository;

    public ComposerServiceImpl(ComposerRepository composerRepository, TrackRepository trackRepository) {
        this.composerRepository = composerRepository;
        this.trackRepository = trackRepository;
    }

    @Override
    public List<ComposerDTO> getComposers() {
        return composerRepository.findAll().stream().map(ComposerConverter::toComposerDTO).toList();
    }

    @Override
    public ComposerDTO getComposer(Long id) {
        return composerRepository.findById(id).map(ComposerConverter::toComposerDTO).
                orElseThrow(() -> new EntityNotFoundException("Композитор с id " + id + " не существует"));
    }

    @Override
    public ComposerDTO addComposer(ComposerDTO composerDTO) {
        Composer composer = toComposer(composerDTO);
        return ComposerConverter.toComposerDTO(composerRepository.save(composer));
    }

    @Override
    public ComposerDTO updateComposer(Long id, ComposerDTO composerDTO) {
        Composer updateComposer = toComposer(composerDTO);

        Composer composer = composerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Композитор с id " + id + " не найден"));

        composer.setName(updateComposer.getName());
        composer.setSurname(updateComposer.getSurname());
        composer.setFatherName(updateComposer.getFatherName());
        composer.setBirthday(updateComposer.getBirthday());

        composer.getTracks().clear();
        composer.getTracks().addAll(updateComposer.getTracks().
                stream()
                .map(it ->
                        new ComposerTrack(composer, it.getTrack())).
                toList());

        return ComposerConverter.toComposerDTO(composerRepository.save(composer));
    }

    @Override
    public void deleteComposerByID(Long id) {
        composerRepository.deleteById(id);
    }

    private Composer toComposer(ComposerDTO composerDTO) {
        Composer composer = new Composer(
                composerDTO.getName(),
                composerDTO.getSurname(),
                composerDTO.getFatherName(),
                composerDTO.getBirthday()
        );

        List<ComposerTrack> composerTracks = getComposerTracks(composerDTO, composer);
        composer.setTracks(composerTracks);

        return composer;
    }

    private List<ComposerTrack> getComposerTracks(ComposerDTO composerDTO, Composer composer) {
        return composerDTO.getTracksId().stream()
                .map(trackId -> {
                    Track track = trackRepository.findById(trackId)
                            .orElseThrow(() -> new EntityNotFoundException("Трек с id " + trackId + " не найден"));
                    return new ComposerTrack(composer, track);
                })
                .toList();
    }
}
