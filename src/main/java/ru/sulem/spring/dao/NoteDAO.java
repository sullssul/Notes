package ru.sulem.spring.dao;

import ru.sulem.spring.models.Note;

import java.util.List;

public interface NoteDAO {
    List<Note> allNotes();
    void addNote(Note note);
    void deleteNote(Note note);
    void editNote(Note note);
    Note getNoteById(int id);
}
