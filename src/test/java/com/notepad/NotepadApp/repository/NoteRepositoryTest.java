package com.notepad.NotepadApp.repository;

import com.notepad.NotepadApp.model.Note;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
@Sql(scripts = {"classpath:db\\insert-note.sql"} , executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD )
class NoteRepositoryTest {

    Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private NoteRepository noteRepository;

    Note testNoteData;

    @BeforeEach
    void setUp() {

        testNoteData = noteRepository.findById(2).orElse(null);
        assertThat(testNoteData).isNotNull();
        logger.info("Test note data retrieved from the database --->" + testNoteData);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Create Note Test")
    void createNoteObject_thenSavetoDBTest(){
        Note note = new Note();
//        note.setId(null);
        note.setTitle("Conclusion");
        note.setBody("This concludes the first test");

        logger.info("Created note object --> " + note);
        assertThat(note.getId()).isNull();

        note = noteRepository.save(note);
        logger.info("After saving the note object ---> " + note);
        assertThat(note.getId()).isNotNull();
    }

    @Test
    @DisplayName("Get all notes test")
    void whenFindAllNotesIsCalled_thenRetrieveNotesListTest(){

        List<Note> allNotes = noteRepository.findAll();
        assertThat(allNotes.size()).isEqualTo(3);
        logger.info("All notes retrieved from the database --> "+ allNotes);
    }

    @Test
    @DisplayName("Update Notes Details test")
    void whenNoteDetailsIsUpdated_thenUpdateDatabaseDetails(){

        //update Note title
        assertThat(testNoteData.getTitle()).isEqualTo("Body");
        testNoteData.setTitle("New Body");

        testNoteData = noteRepository.save(testNoteData);
        assertThat(testNoteData.getTitle()).isEqualTo("New Body");
    }

    @Test
    @DisplayName("Delete Note Test")
    void whenDeleteisCalled_thenDeleteNoteDataTest(){
        List<Note> allNotes = noteRepository.findAll();
        assertThat(allNotes).isNotNull();

        assertThat(allNotes.size()).isEqualTo(3);

        Note savedNote = noteRepository.findById(3).orElse(null);
        assertThat(savedNote).isNotNull();
        noteRepository.deleteById(3);

        allNotes = noteRepository.findAll();
        assertThat(allNotes).isNotNull();
        assertThat(allNotes.size()).isEqualTo(2);
    }
}