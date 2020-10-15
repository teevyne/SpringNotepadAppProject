package com.notepad.NotepadApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"hello","com.notepad.NotepadApp.controller", "com.notepad.NotepadApp.service"})
@EntityScan("com.notepad.NotepadApp.model")
@EnableJpaRepositories("com.notepad.NotepadApp.repository")
@SpringBootApplication
public class NotepadAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotepadAppApplication.class, args);
	}

}
