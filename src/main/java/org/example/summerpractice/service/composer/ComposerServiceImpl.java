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

    private Composer toComposer(ComposerDTO composerDTO) {
        if (composerDTO.getId() != null)
            return composerRepository.findById(composerDTO.getId()).orElseThrow(
                    () -> new EntityNotFoundException("Композитор с id " + composerDTO.getId() + " не найден")
            );

        Composer composer = new Composer(
                composerDTO.getName(),
                composerDTO.getSurname(),
                composerDTO.getFatherName(),
                composerDTO.getBirthday()
        );

        if (composerDTO.getTracksId() != null) {
            List<ComposerTrack> composerTracks = composerDTO.getTracksId().stream()
                    .map(trackId -> {
                        Track track = trackRepository.findById(trackId)
                                .orElseThrow(() -> new EntityNotFoundException("Трек с id " + trackId + " не найден"));
                        return new ComposerTrack(composer, track);
                    })
                    .toList();
            composer.getTracks().addAll(composerTracks);
        }

        return composer;
    }
}
