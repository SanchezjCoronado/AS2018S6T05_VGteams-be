package com.vallegrande.vgteams.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class TutoringSessionDto {

   private UUID tutoringSessionId;
   private Integer tutoringTeamId;
   private String title;
   private String description;
   private Date startTime;
   private Date endTime;
   private String state;
   private Boolean archived;
   private String sessionUrl;

   public TutoringSessionDto(UUID tutoringSessionId, Integer tutoringTeamId, String title, String description, Date startTime, Date endTime, String state, Boolean archived, String sessionUrl) {
      this.tutoringSessionId = tutoringSessionId;
      this.tutoringTeamId = tutoringTeamId;
      this.title = title;
      this.description = description;
      this.startTime = startTime;
      this.endTime = endTime;
      this.state = state;
      this.archived = archived;
      this.sessionUrl = sessionUrl;
   }
}
