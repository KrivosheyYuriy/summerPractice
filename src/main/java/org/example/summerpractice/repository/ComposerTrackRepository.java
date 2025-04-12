package org.example.summerpractice.repository;

import org.example.summerpractice.entity.composerTrack.ComposerTrack;
import org.example.summerpractice.entity.composerTrack.ComposerTrackId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComposerTrackRepository extends JpaRepository<ComposerTrack, ComposerTrackId> {
}
