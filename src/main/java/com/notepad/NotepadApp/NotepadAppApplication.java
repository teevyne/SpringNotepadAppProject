package com.notepad.NotepadApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = {"hello","com.notepad.NotepadApp.controller", "com.notepad.NotepadApp.service"})
@EntityScan("com.notepad.NotepadApp.model")
@EnableJpaRepositories("com.notepad.NotepadApp.repository")
@SpringBootApplication
@EnableSwagger2
public class NotepadAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotepadAppApplication.class, args);
	}

}
