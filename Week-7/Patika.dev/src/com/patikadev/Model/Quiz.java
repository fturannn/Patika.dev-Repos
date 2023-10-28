package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Quiz {
    private int id;
    private int content_id;
    private Content content;
    private String question;

    public Quiz(int id, int content_id, String content, String question) {
        this.id = id;
        this.content_id = content_id;
        this.content = Content.getFetch(content_id);
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

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public static boolean add(int content_id, String content, String question) {
        String query = "INSERT INTO quiz  (content_id, content, question) VALUES (?,?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, content_id);
            pr.setString(2,content);
            pr.setString(3,question);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Quiz> getList() {
        ArrayList<Quiz> quizList = new ArrayList<>();
        Quiz obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM quiz");
            while (rs.next()) {
                int id = rs.getInt("id");
                int content_id = rs.getInt("content_id");
                String content = rs.getString("content");
                String question = rs.getString("question");
                obj = new Quiz(id, content_id, content, question);
                quizList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quizList;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM quiz WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);

            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update(int id, int content_id, String content) {
        String query = "UPDATE quiz SET content_id=?, content=? WHERE id=?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,content_id);
            pr.setString(2, content);
            pr.setInt(3,id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update(int id, int content_id, String content, String question) {
        String query = "UPDATE quiz SET content_id=?, content=?, question=? WHERE id=?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,content_id);
            pr.setString(2, content);
            pr.setString(3, question);
            pr.setInt(4,id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}