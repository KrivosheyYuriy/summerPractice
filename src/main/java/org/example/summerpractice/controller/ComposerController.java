package org.example.summerpractice.controller;

import org.example.summerpractice.dto.ComposerDTO;
import org.example.summerpractice.entity.Composer;
import org.example.summerpractice.service.composer.ComposerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/composers")
public class ComposerController {
    private final ComposerService composerService;

    ComposerController(ComposerService composerService) {
        this.composerService = composerService;
    }

    @GetMapping("")
    public List<ComposerDTO> getComposers() {
        return composerService.getComposers();
    }
}
