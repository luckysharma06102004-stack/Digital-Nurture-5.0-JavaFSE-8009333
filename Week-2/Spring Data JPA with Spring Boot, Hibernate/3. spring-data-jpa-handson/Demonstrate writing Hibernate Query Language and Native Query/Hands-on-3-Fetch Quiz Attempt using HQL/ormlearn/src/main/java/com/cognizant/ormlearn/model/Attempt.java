package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Attempt {

    @Id
    @Column(name = "at_id")
    private int id;

    @Column(name = "at_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private User user;

    @OneToMany(mappedBy = "attempt")
    private Set<AttemptQuestion> attemptQuestionList;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Set<AttemptQuestion> getAttemptQuestionList() { return attemptQuestionList; }
    public void setAttemptQuestionList(Set<AttemptQuestion> list) { this.attemptQuestionList = list; }
}