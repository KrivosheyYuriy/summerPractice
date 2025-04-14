package org.example.summerpractice.service.track;

import org.example.summerpractice.dto.TrackDTO;

import java.util.List;

public interface TrackService {
    List<TrackDTO> getTracks();

    TrackDTO getTrackById(Long id);

    TrackDTO addTrack(TrackDTO trackDTO);

    TrackDTO updateTrack(Long id, TrackDTO trackDTO);

    void deleteTrackById(Long id);
}
