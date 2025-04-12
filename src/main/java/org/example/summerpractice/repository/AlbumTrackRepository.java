package org.example.summerpractice.repository;

import org.example.summerpractice.entity.albumTrack.AlbumTrack;
import org.example.summerpractice.entity.albumTrack.AlbumTrackId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumTrackRepository extends JpaRepository<AlbumTrack, AlbumTrackId> {
}
