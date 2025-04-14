package org.example.summerpractice.controller;

import jakarta.validation.Valid;
import org.example.summerpractice.dto.AlbumDto;
import org.example.summerpractice.service.album.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<AlbumDto> getAlbums() {
        return albumService.getAlbums();
    }

    @GetMapping("/{id}")
    public AlbumDto getAlbumById(@PathVariable Long id) {
        return albumService.getAlbumById(id);
    }

    @PostMapping
    public ResponseEntity<AlbumDto> createAlbum(@RequestBody @Valid AlbumDto albumDto) {
        AlbumDto result = albumService.addAlbum(albumDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumDto> updateAlbum(@PathVariable Long id, @RequestBody @Valid AlbumDto albumDto) {
        AlbumDto result = albumService.updateAlbum(id, albumDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlbumDto> deleteAlbumById(@PathVariable Long id) {
        albumService.deleteAlbumById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
