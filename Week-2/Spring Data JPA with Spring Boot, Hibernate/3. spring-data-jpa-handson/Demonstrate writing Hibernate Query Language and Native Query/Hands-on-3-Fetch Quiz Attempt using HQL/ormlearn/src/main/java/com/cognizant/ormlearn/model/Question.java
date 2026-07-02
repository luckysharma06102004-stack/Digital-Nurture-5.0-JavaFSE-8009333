package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @Column(name = "qu_id")
    private int id;

    @Column(name = "qu_text")
    private String text;

    @Column(name = "qu_score")
    private double score;

    @OneToMany(mappedBy = "question")
    private List<Options> optionList;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
    public List<Options> getOptionList() { return optionList; }
    public void setOptionList(List<Options> optionList) { this.optionList = optionList; }
}