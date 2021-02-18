package com.vallegrande.vgteams.repository;

import com.vallegrande.vgteams.model.TutoringSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TutoringSessionRepository extends JpaRepository <TutoringSession, UUID> {

    List<TutoringSession> findByTutoringTeamIdOrderByStartTimeAsc(Integer teamId);
}
