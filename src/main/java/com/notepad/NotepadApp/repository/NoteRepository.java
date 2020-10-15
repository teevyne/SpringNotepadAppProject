package com.notepad.NotepadApp.repository;

import com.notepad.NotepadApp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

//    Note findByDate(long id);
}
