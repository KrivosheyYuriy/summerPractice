package org.example.summerpractice.service.composer;

import org.example.summerpractice.dto.ComposerDTO;
import org.example.summerpractice.entity.Composer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComposerService {
    public List<ComposerDTO> getComposers();

    public ComposerDTO getComposer(Long id);

    public ComposerDTO addComposer(ComposerDTO composerDTO);

    public ComposerDTO updateComposer(Long id, ComposerDTO composerDTO);

    public void deleteComposerByID(Long id);
}
