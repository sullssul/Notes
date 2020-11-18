package ru.sulem.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sulem.spring.service.NoteService;

public class NoteController {
    private NoteService noteService;

    @Autowired
    public void setUserService(NoteService noteService) {
        this.noteService = noteService;
    }

}
