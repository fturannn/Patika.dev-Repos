package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Registered {
    private int id;
    private int course_id;
    private Course course;
    private int content_id;
    private Content content;
    private String comment;
    private int rating;

    public Registered(int id, int course_id, int content_id, String comment, int rating) {
        this.id = id;
        this.course_id = course_id;
        this.course = Course.getFetch(course_id);
        this.content_id = content_id;
        this.content = Content.getFetch(content_id);
        this.comment = comment;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public static boolean add(int course_id, String course, int content_id, String content) {
        String query = "INSERT INTO registered  (course_id, course, content_id, content) VALUES (?,?,?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,course_id);
            pr.setString(2,course);
            pr.setInt(3,content_id);
            pr.setString(4,content);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Registered> getList() {
        ArrayList<Registered> registeredList = new ArrayList<>();
        Registered obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM registered");
            while (rs.next()) {
                int id = rs.getInt("id");
                int course_id = rs.getInt("course_id");
                int content_id = rs.getInt("content_id");
                String content = rs.getString("content");
                String comment = rs.getString("comment");
                int rating = rs.getInt("rating");
                obj = new Registered(id, course_id, Content.getFetch(content_id).getId(), comment, rating);
                registeredList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return registeredList;
    }

    public static boolean drop(int courseId) {
        String query = "DELETE FROM registered WHERE course_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,courseId);

            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update(String comment, int selectedId) {
        String query = "UPDATE registered SET comment=? WHERE id=?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,comment);
            pr.setInt(2, selectedId);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
