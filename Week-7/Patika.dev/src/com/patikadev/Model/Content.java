package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Content {
    private int id;
    private int course_id;
    private String name;
    private String description;
    private String link;
    private Course course;

    public Content() {}

    public Content(int id, int course_id, String name, String description, String link) {
        this.id = id;
        this.course_id = course_id;
        this.name = name;
        this.description = description;
        this.link = link;
        this.course = Course.getFetch(course_id);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static ArrayList<Content> getList() {
        ArrayList<Content> contentList = new ArrayList<>();
        Content obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM content");
            while (rs.next()) {
                int id = rs.getInt("id");
                int course_id = rs.getInt("course_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String link = rs.getString("link");
                obj = new Content(id, course_id, name, description, link);
                contentList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contentList;
    }

    public static boolean add(int course_id, String name,String description, String link, String course) {
        String query = "INSERT INTO content  (course_id, name, description, link, course) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, course_id);
            pr.setString(2,name);
            pr.setString(3,description);
            pr.setString(4,link);
            pr.setString(5,course);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String searchQuery(String course, String name) {
        String query = "SELECT * FROM content WHERE course LIKE '%{{course}}%' AND name LIKE '%{{name}}%'";
        query = query.replace("{{course}}", course);
        query = query.replace("{{name}}", name);
        return query;
    }

    public static ArrayList<Content> searchContentList (String query) {
        ArrayList<Content> contentList = new ArrayList<>();
        Content obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new Content();
                obj.setId(rs.getInt("id"));
                obj.setCourse_id(rs.getInt("course_id"));
                obj.setName(rs.getString("name"));
                obj.setDescription(rs.getString("description"));
                obj.setLink(rs.getString("link"));
                obj.setCourse(Course.getFetch(rs.getInt("course_id")));
                contentList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contentList;
    }

    public static boolean delete(int contentId) {
        String query = "DELETE FROM content WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,contentId);

            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
