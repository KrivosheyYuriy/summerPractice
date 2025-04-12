package org.example.summerpractice.controller;

import org.example.summerpractice.entity.Track;
import org.example.summerpractice.repository.TrackRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackController {
    private final TrackRepository trackRepository;

    public  TrackController(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @GetMapping
    public List<Track> getTracks() {
        return trackRepository.findAll();
    }


}
