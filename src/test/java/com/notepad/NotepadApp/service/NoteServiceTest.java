package com.notepad.NotepadApp.service;

import com.notepad.NotepadApp.model.Note;
import com.notepad.NotepadApp.repository.NoteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class NoteServiceTest {

    @Mock
    private NoteRepository noteMockRepository;

    @InjectMocks
    private NoteServiceImpl noteService;

    @Autowired
    private NoteRepository noteRepository;

    Logger logger = Logger.getLogger(getClass().getName());

    Note testNote;

    @BeforeEach
    void setUp(){
        noteService = new NoteServiceImpl();
        testNote = new Note();

        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

//    @Test
//    @DisplayName("Test save service")
//    void saveMethod() {
//        when(noteService.saveNote(testNote)).thenReturn(new Note());
//        noteService.saveNote(testNote);
//
//        verify(noteMockRepository, times(1)).save(testNote);
//    }

//    @Test
//    @DisplayName("Find All Service Test")
//    void findById() {
//
//        when(noteService.findNoteById(2)).thenReturn(testNote);
//        noteService.findNoteById(2);
//        verify(noteMockRepository, times(1)).findById(2);
//    }

//    @Test
//    void findAll() {
//        List<Note> noteList = new ArrayList<>();
//        when(noteService.findAllNotes()).thenReturn(noteList);
//        noteService.findAllNotes();
//
//        verify(noteMockRepository, times(1)).findAll();
//    }
}