package com.vallegrande.vgteams.service;

import com.vallegrande.vgteams.dto.TutoringSessionDto;
import com.vallegrande.vgteams.mapper.TutoringSessionMapper;
import com.vallegrande.vgteams.model.TutoringSession;
import com.vallegrande.vgteams.repository.TutoringSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TutoriasService {

    @Autowired
    private TutoringSessionRepository repository;

    public TutoringSessionDto save(TutoringSessionDto tutoringSession){
        TutoringSession entity =  repository.save(TutoringSessionMapper.dtoToEntity(tutoringSession));
        return TutoringSessionMapper.entityToDto(entity);
    }

    public TutoringSessionDto update(TutoringSessionDto tutoringSession){
        TutoringSession entity =  repository.save(TutoringSessionMapper.dtoToEntity(tutoringSession));
        return TutoringSessionMapper.entityToDto(entity);
    }

    public List<TutoringSession> getTutorias(){
        return  repository.findAll();
    }

    public TutoringSession getTutoriasById(UUID tutoringSessionId){
        return  repository.findById(tutoringSessionId).orElse(null);
    }

    public List<TutoringSession> findByTutoringTeamId(Integer tutoringSessionId){
        return  repository.findByTutoringTeamIdOrderByStartTimeAsc(tutoringSessionId);
    }

    public String deleteTutorias(UUID tutoringSessionId){
        repository.deleteById(tutoringSessionId);
        return "tutoria removed! "+tutoringSessionId;
    }

}
