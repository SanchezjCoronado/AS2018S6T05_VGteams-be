package com.vallegrande.vgteams.controller;

import com.vallegrande.vgteams.dto.TutoringSessionDto;
import com.vallegrande.vgteams.model.TutoringSession;
import com.vallegrande.vgteams.service.TutoriasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/")
@CrossOrigin
public class TutoringSessionController {

    @Autowired
    private TutoriasService service;

    @GetMapping()
    public List<TutoringSession> findAll() {
        return service.getTutorias();
    }

    @GetMapping("{tutoringSessionId}")
    public TutoringSession findById(@PathVariable UUID tutoringSessionId){
        return service.getTutoriasById(tutoringSessionId);
    }

//    @GetMapping("tutoring-team/{tutoringTeamId}")
//    public List<TutoringSession> findByTutorId(@PathVariable String tutoringTeamId) {
//        return service.findByTutoringTeamId(tutoringTeamId);
//    }

    @GetMapping("tutoring-team/{tutoringTeamId}")
    public ResponseEntity<?> findByTutorId(@PathVariable Integer tutoringTeamId) {
        System.out.println(tutoringTeamId);
        List<TutoringSession> tutoringSession = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();

        try {
            tutoringSession = service.findByTutoringTeamId(tutoringTeamId);
        } catch (DataAccessException e){
            response.put("messages", "Error al consultar en la DB");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

//        if (tutoringSession.isEmpty()){
//            response.put("messages", "El ID: " .concat(tutoringTeamId.toString() .concat(" No existe en la DB")));
//            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//        }

        return new ResponseEntity<>(tutoringSession, HttpStatus.OK);
    }


//    @GetMapping("{tutoringSessionId}")
//    public ResponseEntity<?> findByIdDos(@PathVariable UUID tutoringSessionId) {
//
//        TutoringSession tutoringSession = null;
//        Map<String, Object> response = new HashMap<>();
//        try {
//            tutoringSession = service.getTutoriasById(tutoringSessionId);
//        } catch (DataAccessException e) {
//            response.put("mensaje", "Error al consultar en la DB");
//            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        if (tutoringSession == null) {
//            response.put("mensaje", "La tutoria ID:".concat(tutoringSessionId.toString().concat(" No existe la tutoria!! ")));
//            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<TutoringSession>(tutoringSession, HttpStatus.OK);
//    }


    @PostMapping()
    public TutoringSessionDto save(@RequestBody TutoringSessionDto tutoringSession) {
        return service.save(tutoringSession);
    }

    @PutMapping()
    public TutoringSessionDto update(@RequestBody TutoringSessionDto tutoringSession) {
        return service.update(tutoringSession);
    }

    @DeleteMapping("{tutoringSessionId}")
    public ResponseEntity<Void> delete(@PathVariable UUID tutoringSessionId) {
        service.deleteTutorias(tutoringSessionId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
