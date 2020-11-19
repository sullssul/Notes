package ru.sulem.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sulem.spring.models.Note;

import java.util.List;

@Repository
public class NoteDAOImpl implements NoteDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Note> allNotes(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (List<Note>) session.createQuery("select n from ru.sulem.spring.models.Note n WHERE user.id="+id).list();
    }

    @Override
    public void addNote(Note note) {
        Session session=sessionFactory.getCurrentSession();
        session.persist(note);
    }

    @Override
    public void deleteNote(Note note) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(note);
    }

    @Override
    public void editNote(Note note) {
        Session session = sessionFactory.getCurrentSession();
        session.update(note);
    }

    @Override
    public Note getNoteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Note.class, id);
    }
}
