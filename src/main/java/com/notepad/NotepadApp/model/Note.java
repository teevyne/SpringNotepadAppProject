package com.notepad.NotepadApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
//    @GeneratedValue(Strategy = GeneratedValue.)
    private long id;

    private String title;

    private String body;

    private Instant postDate;
}
