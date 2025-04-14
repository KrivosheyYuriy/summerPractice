package org.example.summerpractice.mappers;

import org.example.summerpractice.dto.ComposerDTO;
import org.example.summerpractice.entity.Composer;
import org.example.summerpractice.entity.composerTrack.ComposerTrack;
import org.example.summerpractice.entity.composerTrack.ComposerTrackId;

public class ComposerConverter {
    public static ComposerDTO toComposerDTO(Composer composer) {
        return new ComposerDTO(
                composer.getId(),
                composer.getName(),
                composer.getSurname(),
                composer.getFatherName(),
                composer.getBirthday(),
                composer.getTracks().stream().map(ComposerTrack::getId).map(ComposerTrackId::getTrackId).toList()
        );
    }
}
