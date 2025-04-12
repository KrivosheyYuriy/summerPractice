package org.example.summerpractice.repository;

import org.example.summerpractice.entity.playListTrack.PlayListTrack;
import org.example.summerpractice.entity.playListTrack.PlayListTrackId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListTrackRepository extends JpaRepository<PlayListTrack, PlayListTrackId> {
}
