package org.example.summerpractice.service.track;

import org.example.summerpractice.dto.TrackDTO;

import java.util.List;

public interface TrackService {
    public List<TrackDTO> getTracks();

    public TrackDTO getTrackById(Long id);

    public TrackDTO addTrack(TrackDTO trackDTO);

    public TrackDTO updateTrack(Long id, TrackDTO trackDTO);

    public void deleteTrackById(Long id);
}
