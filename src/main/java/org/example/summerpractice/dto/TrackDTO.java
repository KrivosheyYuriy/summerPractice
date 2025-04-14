package org.example.summerpractice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class TrackDTO {
    private final Long id;

    @NotBlank(message = "название трека не должно быть пустым")
    private final String title;

    @NotBlank(message = "название файла трека не должно быть пустым")
    private final String filename;

    private final String description;

    @NotNull(message = "продолжительность не должна быть null")
    @Min(value = 1, message = "продолжительность в секундах должна быть > 0")
    private final int durationSeconds;

    @NotNull(message = "список id жанров не должен быть null")
    private final List<Long> genresId;

    @NotNull(message = "список id композиторов не должен быть null")
    private final List<Long> composersId;

    @NotNull(message = "список id альбомов не должен быть null")
    private final List<Long> albumsId;

    @NotNull(message = "список id плейлистов не должен быть null")
    private final List<Long> playListsId;

    public TrackDTO(Long id, String title, String filename, String description,
                    int durationSeconds,
                    List<Long> composersId, List<Long> genresId,
                    List<Long> albumsId, List<Long> playListsId) {
        this.id = id;
        this.title = title;
        this.filename = filename;
        this.description = description;
        this.durationSeconds = durationSeconds;
        this.composersId = composersId;
        this.genresId = genresId;
        this.albumsId = albumsId;
        this.playListsId = playListsId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFilename() {
        return filename;
    }

    public String getDescription() {
        return description;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public List<Long> getGenresId() {
        return genresId;
    }

    public List<Long> getAlbumsId() {
        return albumsId;
    }

    public List<Long> getPlayListsId() {
        return playListsId;
    }

    public List<Long> getComposersId() {
        return composersId;
    }
}
