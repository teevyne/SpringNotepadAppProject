package com.notepad.NotepadApp.service;
import com.notepad.NotepadApp.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NoteService {

    Note saveNote(Note note);

    Note updateNote(Note note);

    List<Note> findAllNotes(Note note);

    void deleteNote(Integer NoteId);

    Note findNoteById(Integer noteId);
}
