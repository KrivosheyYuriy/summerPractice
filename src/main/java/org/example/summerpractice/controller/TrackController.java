package org.example.summerpractice.controller;

import jakarta.validation.Valid;
import org.example.summerpractice.dto.TrackDTO;
import org.example.summerpractice.service.track.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackController {
    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public List<TrackDTO> getTracks() {
        return trackService.getTracks();
    }

    @GetMapping("/{id}")
    public TrackDTO getTrackById(@PathVariable Long id) {
        return trackService.getTrackById(id);
    }

    @PostMapping
    public ResponseEntity<TrackDTO> createTrack(@RequestBody @Valid TrackDTO trackDTO) {
        TrackDTO result = trackService.addTrack(trackDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrackDTO> updateTrack(@PathVariable Long id, @RequestBody @Valid TrackDTO trackDTO) {
        TrackDTO updated = trackService.updateTrack(id, trackDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrackDTO> deleteTrackById(@PathVariable Long id) {
        trackService.deleteTrackById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
