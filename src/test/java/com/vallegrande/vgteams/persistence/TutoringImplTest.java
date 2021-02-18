package com.vallegrande.vgteams.persistence;

import com.vallegrande.vgteams.repository.TutoringSessionRepository;
import com.vallegrande.vgteams.service.TutoriasService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static com.vallegrande.vgteams.prototype.prototypeTutoring.uTutoring;

@SpringBootTest
@AutoConfigureMockMvc
public class TutoringImplTest {
    @Autowired
    TutoriasService tutoriasService;

    @Test
    void list() { tutoriasService.getTutorias(); }

    @Test
    void save() {tutoriasService.save(uTutoring());}
}
