package ru.sulem.spring.models;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Notes")
@Entity
public class Note implements Serializable  {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "dateCreation")
    private String dateCreation;

    @Column(name = "dateLastEdit")
    private String dateLastEdit;



    @Column(name = "title")
    private String title;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="user_id",nullable = false)
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateLastEdit() {
        return dateLastEdit;
    }

    public void setDateLastEdit(String dateLastEdit) {
        this.dateLastEdit = dateLastEdit;
    }





}
