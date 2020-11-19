package ru.sulem.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.sulem.spring.models.Note;
import ru.sulem.spring.models.User;
import ru.sulem.spring.service.NoteService;
import ru.sulem.spring.service.UserService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class NoteController {
    private NoteService noteService;
    private UserService userService;
    private int user_id;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    // если нажали показать заметки открываем список заметок пользователя
    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
    public ModelAndView allUsers(@PathVariable("id") int id){
        user_id=id;
        List<Note> notes=noteService.allNotes(user_id);
        System.out.println(notes.size());
        User user = userService.getUserById(user_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notes");
        modelAndView.addObject("noteList", notes);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value="/deleteNote/{id}", method = RequestMethod.GET)
    public ModelAndView deleteNote(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/notes/"+user_id);
        Note note = noteService.getNoteById(id);
        noteService.deleteNote(note);
        return modelAndView;
    }


    // если переходим на на редачить пользователя
    @RequestMapping(value = "/editNote/{id}", method = RequestMethod.GET)
    public ModelAndView editPageNote(@PathVariable("id") int id) {
        Note note = noteService.getNoteById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editNote");
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    // когда отредаяили и нажали submit отправит обратно ко всем пользователям
    @RequestMapping(value = "/editNote", method = RequestMethod.POST)
    public ModelAndView editNote(@ModelAttribute("note") Note note) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/notes/"+user_id);
        note.setUser(userService.getUserById(user_id));
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);
        note.setDateLastEdit(strDate);
        noteService.editNote(note);
        return modelAndView;
    }

    //когда нажали на создать нового пользователя открываем нужное окно
    @RequestMapping(value = "/createNote", method = RequestMethod.GET)
    public ModelAndView addPageNote() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createNote");
        return modelAndView;
    }

    //создаем нового пользователя и открвываем всех пользователей
    @RequestMapping(value = "/createNote", method = RequestMethod.POST)
    public ModelAndView addNote(@ModelAttribute("note") Note note) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/notes/"+user_id);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        String strDate = dateFormat.format(date);
        note.setDateLastEdit(strDate);
        note.setDateCreation(strDate);
        note.setUser(userService.getUserById(user_id));
        noteService.addNote(note);
        return modelAndView;
    }

    // переход на просмотр заметки
    @RequestMapping(value = "/showNote/{id}", method = RequestMethod.GET)
    public ModelAndView showPageNote(@PathVariable("id") int id) {
        Note note = noteService.getNoteById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editNote");
        modelAndView.addObject("note", note);
        return modelAndView;
    }


}
