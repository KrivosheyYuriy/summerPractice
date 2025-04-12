package org.example.summerpractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.summerpractice.entity.composerTrack.ComposerTrack;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Composer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column
    private String fatherName;

    @Column
    private LocalDate birthday;

    @OneToMany(mappedBy = "composer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComposerTrack> tracks;

    public Composer() {}

    public Composer(String name, String surname, String fatherName, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public List<ComposerTrack> getTracks() {
        return tracks;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Composer composer)) return false;
        return Objects.equals(id, composer.id) && Objects.equals(name, composer.name) && Objects.equals(surname, composer.surname) && Objects.equals(fatherName, composer.fatherName) && Objects.equals(birthday, composer.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, fatherName, birthday);
    }
}
