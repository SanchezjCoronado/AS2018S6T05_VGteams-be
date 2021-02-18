package com.vallegrande.vgteams.mapper;

import com.vallegrande.vgteams.dto.TutoringSessionDto;
import com.vallegrande.vgteams.model.TutoringSession;

public class TutoringSessionMapper {

   public static TutoringSessionDto entityToDto(TutoringSession entity){
      return new TutoringSessionDto(
              entity.getTutoringSessionId(),
              entity.getTutoringTeamId(),
              entity.getTitle(),
              entity.getDescription(),
              entity.getStartTime(),
              entity.getEndTime(),
              entity.getState(),
              entity.getArchived(),
              entity.getSessionUrl()
      );
   }

   public static TutoringSession dtoToEntity (TutoringSessionDto dto){
      return new TutoringSession(
              dto.getTutoringSessionId(),
              dto.getTutoringTeamId(),
              dto.getTitle(),
              dto.getDescription(),
              dto.getStartTime(),
              dto.getEndTime(),
              dto.getState(),
              dto.getArchived(),
              dto.getSessionUrl()
      );
   }

}
