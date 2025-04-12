package org.example.summerpractice.service.composer;

import org.example.summerpractice.dto.ComposerDTO;
import org.example.summerpractice.entity.Composer;

import java.util.List;

public interface ComposerService {
    public List<ComposerDTO> getComposers();

    public ComposerDTO getComposer(Long id);
}
