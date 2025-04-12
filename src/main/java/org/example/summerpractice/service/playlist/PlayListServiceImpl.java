package org.example.summerpractice.service.playlist;

import org.example.summerpractice.repository.PlayListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlayListServiceImpl implements PlayListService {
    private final PlayListRepository playListRepository;

    public PlayListServiceImpl(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
    }
}
