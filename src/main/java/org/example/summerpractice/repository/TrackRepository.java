package org.example.summerpractice.repository;

import org.example.summerpractice.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {
}
