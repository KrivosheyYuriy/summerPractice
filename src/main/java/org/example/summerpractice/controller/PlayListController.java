package org.example.summerpractice.controller;

import jakarta.validation.Valid;
import org.example.summerpractice.dto.PlayListDTO;
import org.example.summerpractice.service.playlist.PlayListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
public class PlayListController {
    private final PlayListService playListService;

    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }

    @GetMapping
    public List<PlayListDTO> getPlayLists() {
        return playListService.getPlayLists();
    }

    @GetMapping("/{id}")
    public PlayListDTO getPlayListById(@PathVariable Long id) {
        return playListService.getPlayListById(id);
    }

    @PostMapping
    public ResponseEntity<PlayListDTO> createPlayList(@RequestBody @Valid PlayListDTO playListDTO) {
        PlayListDTO result = playListService.addPlayList(playListDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayListDTO> updatePlayList(@PathVariable Long id,
                                                      @RequestBody @Valid PlayListDTO playListDTO) {
        PlayListDTO result = playListService.updatePlayList(id, playListDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlayListDTO> deletePlayListById(@PathVariable Long id) {
        playListService.deletePlayListById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
