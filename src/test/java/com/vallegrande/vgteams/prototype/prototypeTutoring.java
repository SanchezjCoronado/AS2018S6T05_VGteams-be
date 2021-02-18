package com.vallegrande.vgteams.prototype;

import com.vallegrande.vgteams.dto.TutoringSessionDto;

import java.util.UUID;

public class prototypeTutoring {
    public static TutoringSessionDto uTutoring(){
        TutoringSessionDto tutoringSessionDto = new TutoringSessionDto(
                UUID.randomUUID(),
                1,
                "demo",
                "es una prueba",
                new java.util.Date(),
                new java.util.Date(),
                "A",
                true,
                "lkj"
        );
        return tutoringSessionDto;
    }
}
