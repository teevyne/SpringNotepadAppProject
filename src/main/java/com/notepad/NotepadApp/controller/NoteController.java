package com.notepad.NotepadApp.controller;

import com.notepad.NotepadApp.model.Note;
import com.notepad.NotepadApp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("anewnote")
    public ResponseEntity<?> createNote(@Valid @RequestBody Note note){
        Note result = noteService.saveNote(note);
        return new ResponseEntity<Note>(result, HttpStatus.CREATED);
    }

    @GetMapping("/getnotes")
    public List<Note> getAllNotes(Note note){
        return noteService.findAllNotes(note);
    }

    @GetMapping("/getnote/{id}")
    public ResponseEntity<Note> getANote(@PathVariable long id){
        Note result = noteService.findNoteById(id);
        return new ResponseEntity<Note>(result, HttpStatus.CREATED);
    }

    @PutMapping("/newnote")
    public ResponseEntity<?> updateNote(@Valid @RequestBody Note note){
        Note result = noteService.updateNote(note);
        return new ResponseEntity<Note>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("getnote/{id}")
    public void deleteNote(@PathVariable long id){
        noteService.deleteNote(id);
    }
}
