package org.example.summerpractice.service.album;

import org.example.summerpractice.repository.AlbumRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    public  AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


}
