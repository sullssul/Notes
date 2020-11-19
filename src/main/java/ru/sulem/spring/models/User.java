package ru.sulem.spring.models;


import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Users")
@Entity
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "Users", fetch=FetchType.EAGER)
//    private List<Note> notes = new ArrayList<>();
//
//    public List<Note>getNotes() {
//        return this.notes;
//    }
//
//    public void addNotes(Note note){
//        note.setUser(this);
//        getNotes().add(note);
//    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return id + " " + name;
    }
}
