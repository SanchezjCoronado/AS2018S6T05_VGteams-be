package com.vallegrande.vgteams.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Entity(name = "tutoring_sessions")
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TutoringSession {

    public TutoringSession() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tutoring_session_id", updatable = false, nullable = false)
    private UUID tutoringSessionId;

    @Column(name = "tutoring_team_id")
    private Integer tutoringTeamId;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name= "start_time")
    private Date startTime;

    @Column(name= "end_time")
    private Date endTime;

    @Column(name="state", columnDefinition="bpchar", length = 1)
    private String state;

    @Column(name="archived")
    private Boolean archived;

    @Column(name="session_url")
    private String sessionUrl;

}
