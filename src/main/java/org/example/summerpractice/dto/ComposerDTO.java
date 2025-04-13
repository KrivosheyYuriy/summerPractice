package org.example.summerpractice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;

public class ComposerDTO {
    private final Long id;

    @NotBlank(message = "Имя не может быть пустым")
    @Pattern(regexp = "^[А-яЁё]+$", message = "Некорректный формат имени")
    private final String name;

    @NotBlank(message = "Фамилия не может быть пустой")
    @Pattern(regexp = "^[А-яЁё'’-]+$", message = "Некорректный формат фамилии")
    private final String surname;

    @Pattern(regexp = "^(?:[А-ЯЁ][а-яё]+(?:[- ]?[А-ЯЁ][а-яё]+)?)?$")
    private final String fatherName;

    @NotNull(message = "Дата рождения не должна быть null")
    @Past(message = "Дата рождения должна быть в прошлом")
    private final LocalDate birthday;

    private final List<Long> tracksId;

    public ComposerDTO(Long id, String name, String surname, String fatherName,
                       LocalDate birthday, List<Long> tracksId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.birthday = birthday;
        this.tracksId = tracksId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public List<Long> getTracksId() {
        return tracksId;
    }
}
