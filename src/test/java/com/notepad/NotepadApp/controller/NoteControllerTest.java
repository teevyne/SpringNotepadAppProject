package com.notepad.NotepadApp.controller;

import com.notepad.NotepadApp.model.Note;
import com.notepad.NotepadApp.service.NoteService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private NoteController noteController;

    @MockBean
    private NoteService noteService;

    private List<Note> notelist;

    private Note note;

    NoteControllerTest() {
    }

    @BeforeEach
    void setUp(){
        this.notelist = new ArrayList<>();

        this.notelist.add(new Note(1, "Mid", "The best time"));
        this.notelist.add(new Note(2, "Top", "this is the top"));
        this.notelist.add(new Note(3, "Low", "this is the low end"));
        this.notelist.add(new Note(4, "skp", "this should be skipped"));

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(noteController).build();
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    @DisplayName("Get All Notes Test")
    void getAllNotesTest() throws Exception {
        given(noteService.findAllNotes(note)).willReturn(notelist);

        this.mockMvc.perform(get("/getnotes"))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.size()", is(notelist.size())));
    }

    @Test
    public void getNoteTest() throws Exception {
        this.mockMvc.perform(get("/api/getnotes")).andExpect(status().isOk());
    }
}