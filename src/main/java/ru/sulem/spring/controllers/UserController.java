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

import java.util.List;


@Controller
public class UserController {
    private NoteService noteService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    // для вывода всех пользователей
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUsers(){
        List<User> users=userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }

    // если переходим на на редачить пользователя
    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
    public ModelAndView editPageUser(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    // когда отредаяили и нажали submit отправит обратно ко всем пользователям
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.editUser(user);
        return modelAndView;
    }

    //когда нажали на создать нового пользователя открываем нужное окно
    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createUser");
        return modelAndView;
    }

    //создаем нового пользователя и открвываем всех пользователей
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.addUser(user);
        return modelAndView;
    }

    //если пришел запрос на удаление,то удаляем и открываем всех пользователей
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        User user = userService.getUserById(id);
        List<Note> noteList=noteService.allNotes(id);
        for(Note note: noteList){
            noteService.deleteNote(note);
        }
        userService.deleteUser(user);
        return modelAndView;
    }





}
