package com.notepad.NotepadApp.service;

import com.notepad.NotepadApp.model.Note;
import com.notepad.NotepadApp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note saveNote(Note note){
        return noteRepository.save(note);
    }

    public Note updateNote(Note note){
        return noteRepository.save(note);
    }

    public List<Note> findAllNotes(Note note){
        return noteRepository.findAll();
    }

    public void deleteNote(long noteId){
        noteRepository.deleteById(noteId);
    }

    public Note findNoteById(long noteId){
        return noteRepository.findById(noteId).orElse(null);
    }
}