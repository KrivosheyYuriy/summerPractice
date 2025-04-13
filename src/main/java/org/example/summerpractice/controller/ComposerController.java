package org.example.summerpractice.controller;

import jakarta.validation.Valid;
import org.example.summerpractice.dto.ComposerDTO;
import org.example.summerpractice.service.composer.ComposerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.validation.Validator;
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

    @GetMapping("/{id}")
    public ComposerDTO getComposer(@PathVariable Long id) {
        return composerService.getComposer(id);
    }

    @PostMapping
    public ResponseEntity<ComposerDTO> createComposer(@RequestBody @Valid ComposerDTO composerDTO) {
        ComposerDTO result = composerService.addComposer(composerDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComposerDTO> updateComposer(@PathVariable Long id,
                                                      @RequestBody @Valid ComposerDTO composerDTO) {
        ComposerDTO updated = composerService.updateComposer(id, composerDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ComposerDTO> deleteComposer(@PathVariable Long id) {
        composerService.deleteComposer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
