package se.yrgo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKey;
import jakarta.persistence.OneToMany;

@Entity
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String tutorId;
    private String name;
    private int salary;

    @OneToMany
    @JoinColumn(name = "TUTOR_FK")
    private List<Student> teachingGroup;

    public Tutor() {

    }

    public Tutor(String tutorId, String name, int salary) {
        this.tutorId = tutorId;
        this.name = name;
        this.salary = salary;
        this.teachingGroup = new ArrayList<Student>();
    }

    public void addStudentToTeachingGroup(Student newStudent) {
        this.teachingGroup.add(newStudent);
    }

    public List<Student> getTeachingGroup() {
        return Collections.unmodifiableList(this.teachingGroup);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Tutor: %s with id: %s has a salary of: %d", name, tutorId, salary);
    }

}
