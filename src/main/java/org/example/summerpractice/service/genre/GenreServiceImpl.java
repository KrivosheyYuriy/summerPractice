package org.example.summerpractice.service.genre;

import jakarta.persistence.EntityNotFoundException;
import org.example.summerpractice.dto.GenreDTO;
import org.example.summerpractice.mappers.GenreConverter;
import org.example.summerpractice.repository.GenreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<GenreDTO> getGenres() {
        return genreRepository.findAll().stream().map(GenreConverter::toGenreDTO).toList();
    }

    @Override
    public GenreDTO getGenreById(Long id) {
        return GenreConverter.toGenreDTO(genreRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Жанр с id " + id + " не существует")));
    }
}
