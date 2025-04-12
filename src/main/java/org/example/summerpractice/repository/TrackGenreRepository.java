package org.example.summerpractice.repository;

import org.example.summerpractice.entity.trackGenre.TrackGenre;
import org.example.summerpractice.entity.trackGenre.TrackGenreId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackGenreRepository extends JpaRepository<TrackGenre, TrackGenreId> {
}
