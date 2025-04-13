package org.example.summerpractice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class GenreDTO {
    private Long id;

    @NotNull(message = "Название жанра не должно быть null")
    @NotBlank(message = "Название жанра не может быть пустым")
    @Size(max = 64, message = "Название жанра не должно превышать 64 символа")
    private String title;

    @Size(max = 256, message = "Описание жанра превышает 256 символов")
    private String description;

    public GenreDTO(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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
}
