package org.example.summerpractice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.List;

public class AlbumDto {
    private final Long id;

    @NotBlank(message = "Название альбома не должно быть пустым")
    private final String title;

    private final String description;

    @NotNull(message = "Дата релиза не должна быть null")
    @PastOrPresent(message = "Дата релиза должна быть в настоящем или прошлом")
    private final LocalDate releaseDate;

    @NotNull(message = "Список треков не может быть null")
    @NotEmpty(message = "В альбоме должен быть хотя бы 1 трек")
    private final List<Long> tracksId;

    public AlbumDto(Long id, String title, String description, LocalDate releaseDate, List<Long> tracksId) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.description = description;
        this.tracksId = tracksId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public List<Long> getTracksId() {
        return tracksId;
    }
}
