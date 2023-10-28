package com.patikadev.Model;

public class Quiz {
    private int id;
    private int content_id;
    private String content;
    private String question;

    public Quiz(int id, int content_id, String content, String question) {
        this.id = id;
        this.content_id = content_id;
        this.content = content;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
