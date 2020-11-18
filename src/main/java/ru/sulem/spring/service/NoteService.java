package ru.sulem.spring.service;

import ru.sulem.spring.models.Note;

import java.util.List;

public interface NoteService {
    List<Note> allNotes();
    void addNote(Note note);
    void deleteNote(Note note);
    void editNote(Note note);
    Note getNoteById(int id);
}
