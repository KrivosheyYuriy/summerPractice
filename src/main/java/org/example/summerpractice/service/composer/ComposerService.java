package org.example.summerpractice.service.composer;

import org.example.summerpractice.dto.ComposerDTO;

import java.util.List;

public interface ComposerService {
    List<ComposerDTO> getComposers();

    ComposerDTO getComposer(Long id);

    ComposerDTO addComposer(ComposerDTO composerDTO);

    ComposerDTO updateComposer(Long id, ComposerDTO composerDTO);

    void deleteComposerByID(Long id);
}
