package com.cognizant.ormlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "attempt_option")
public class AttemptOption {

    @Id
    @Column(name = "ao_id")
    private int id;

    @Column(name = "ao_selected")
    private boolean selected;

    @ManyToOne
    @JoinColumn(name = "ao_aq_id")
    private AttemptQuestion attemptQuestion;

    @ManyToOne
    @JoinColumn(name = "ao_op_id")
    private Options option;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public boolean isSelected() { return selected; }
    public void setSelected(boolean selected) { this.selected = selected; }
    public AttemptQuestion getAttemptQuestion() { return attemptQuestion; }
    public void setAttemptQuestion(AttemptQuestion aq) { this.attemptQuestion = aq; }
    public Options getOption() { return option; }
    public void setOption(Options option) { this.option = option; }
}