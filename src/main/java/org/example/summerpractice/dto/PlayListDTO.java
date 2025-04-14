package org.example.summerpractice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class PlayListDTO {
    private final Long id;

    @NotBlank(message = "Название плейлиста не может быть null")
    private final String title;

    private final String description;

    @NotNull(message = "Список треков не может быть null")
    private final List<Long> tracksId;

    public PlayListDTO(Long id, String title, String description, List<Long> tracksId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tracksId = tracksId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Long> getTracksId() {
        return tracksId;
    }
}
