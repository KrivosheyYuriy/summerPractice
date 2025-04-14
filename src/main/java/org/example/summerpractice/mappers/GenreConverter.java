package org.example.summerpractice.mappers;

import org.example.summerpractice.dto.GenreDTO;
import org.example.summerpractice.entity.Genre;

public class GenreConverter {
    public static GenreDTO toGenreDTO(Genre genre) {
        return new GenreDTO(genre.getId(), genre.getTitle(), genre.getDescription());
    }

//    public static Genre toGenre(GenreDTO genreDTO) {
//        return new Genre(genreDTO.getTitle(), genreDTO.getDescription());
//    }
}
