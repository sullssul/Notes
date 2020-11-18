package ru.sulem.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.sulem.spring.dao.NoteDAO;
import ru.sulem.spring.models.Note;

import java.util.List;

public class NoteServiceImpl implements NoteService {

    private NoteDAO noteDAO;

    @Autowired
    public void setUserDAO(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @Override
    @Transactional
    public List<Note> allNotes() {
        return noteDAO.allNotes();
    }

    @Override
    @Transactional
    public void addNote(Note note) {
        noteDAO.addNote(note);

    }

    @Override
    @Transactional
    public void deleteNote(Note note) {
        noteDAO.deleteNote(note);
    }

    @Override
    @Transactional
    public void editNote(Note note) {
        noteDAO.editNote(note);
    }

    @Override
    @Transactional
    public Note getNoteById(int id) {
        return noteDAO.getNoteById(id);
    }
}
