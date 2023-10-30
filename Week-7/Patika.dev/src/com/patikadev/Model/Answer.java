package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Answer {
    private int id;
    private int quiz_id;
    private Quiz quiz;
    private String content;
    private String question;
    private String answer;
    private int student_id;
    private User student;

    public Answer(int id, int student_id, int quiz_id, String content, String question, String answer) {
        this.id = id;
        this.student_id = student_id;
        this.student = User.getFetch(student_id);
        this.quiz_id = quiz_id;
        this.quiz = Quiz.getFetch(quiz_id);
        this.content = content;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public static ArrayList<Answer> getList() {
        ArrayList<Answer> answerList = new ArrayList<>();
        Answer obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM answer");
            while (rs.next()) {
                int id = rs.getInt("id");
                int student_id = rs.getInt("student_id");
                int quiz_id = rs.getInt("quiz_id");
                String content = rs.getString("content");
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                obj = new Answer(id, student_id, quiz_id, content, question, answer);
                answerList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return answerList;
    }

    public static boolean add(int student_id, int quiz_id, String content, String question, String answer) {
        String query = "INSERT INTO answer  (student_id, quiz_id, content, question, answer) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,student_id);
            pr.setInt(2,quiz_id);
            pr.setString(3,content);
            pr.setString(4,question);
            pr.setString(5,answer);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update(String answer, int selectedId) {
        String query = "UPDATE answer SET answer=? WHERE quiz_id=?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1,answer);
            pr.setInt(2, selectedId);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Answer getFetch(int quizId) {
        Answer obj = null;
        String query = "SELECT * FROM answer WHERE quiz_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, quizId);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new Answer(rs.getInt("id"), rs.getInt("student_id"), rs.getInt("quiz_id"), rs.getString("content"), rs.getString("question"), rs.getString("answer"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
}
