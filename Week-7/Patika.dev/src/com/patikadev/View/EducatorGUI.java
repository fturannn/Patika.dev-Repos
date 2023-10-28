package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class EducatorGUI extends JFrame{
    private JPanel wrapper;
    private JTabbedPane tab_educator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_course_list;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JPanel pnl_course_content;
    private JTable tbl_course_content;
    private JScrollPane scrl_course_content;
    private JComboBox cmb_course;
    private JTextField fld_content_name;
    private JTextField fld_content_desc;
    private JTextField fld_content_link;
    private JButton btn_add_content;
    private JTextField fld_sh_course;
    private JTextField fld_sh_content;
    private JButton btn_sh_content;
    private JTextField fld_content_id;
    private JButton btn_content_delete;
    private JTable tbl_quiz_list;
    private JPanel pnl_sh_add;
    private JPanel pnl_quiz_list;
    private JScrollPane scrl_quiz_list;
    private JComboBox cmb_content;
    private JTextField fld_quiz;
    private JButton btn_quiz_add;
    private JTextField fld_quiz_id;
    private JButton btn_quiz_delete;
    private DefaultTableModel mdl_course_list;
    private Object [] row_course_list;
    private DefaultTableModel mdl_content_list;
    private Object [] row_content_list;
    private DefaultTableModel mdl_quiz_list;
    private Object [] row_quiz_list;

    private final Educator educator;

    public EducatorGUI(Educator educator) {
        this.educator = educator;

        add(wrapper);
        setSize(1000,500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        lbl_welcome.setText("Hoşgeldin " + educator.getName());

        // Course List
        mdl_course_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_course_list = {"ID", "Ders Adı", "Programlama Dili", "Patika", "Eğitmen"};
        mdl_course_list.setColumnIdentifiers(col_course_list);

        row_course_list = new Object[col_course_list.length];
        loadCourseModel();

        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);

        // ## Course List

        // Content List
        mdl_content_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 4) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_content_list = {"ID", "İçerik Adı", "Açıklama", "Link", "Ders"};
        mdl_content_list.setColumnIdentifiers(col_content_list);

        row_content_list = new Object[col_content_list.length + 1];

        tbl_course_content.setModel(mdl_content_list);
        tbl_course_content.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_course_content.getTableHeader().setReorderingAllowed(false);
        loadCourseCombo();
        loadContentModel();

        tbl_course_content.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_content_id = tbl_course_content.getValueAt(tbl_course_content.getSelectedRow(), 0).toString();
                fld_content_id.setText(select_content_id);
            } catch (Exception ignored){
            }
        });

        tbl_course_content.getModel().addTableModelListener(e -> {
            if(e.getType() == TableModelEvent.UPDATE) {
                int content_id = Integer.parseInt(tbl_course_content.getValueAt(tbl_course_content.getSelectedRow(), 0).toString());
                String content_name = tbl_course_content.getValueAt(tbl_course_content.getSelectedRow(), 1).toString();
                String content_description = tbl_course_content.getValueAt(tbl_course_content.getSelectedRow(), 2).toString();
                String content_link = tbl_course_content.getValueAt(tbl_course_content.getSelectedRow(), 3).toString();
                String course_name = tbl_course_content.getValueAt(tbl_course_content.getSelectedRow(), 4).toString();
                loadCourseModel();
                if(Content.update(content_id, content_name, content_description, content_link, course_name)) {
                    Helper.showMsg("done");
                }
                loadContentModel();
                loadCourseCombo();
                loadQuizModel();
                loadContentCombo();
            }
        });

        // ## Content List

        // Quiz List
        mdl_quiz_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || column == 1 || column == 2) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_quiz_list = {"ID", "İçerik ID", "İçerik", "Soru"};
        mdl_quiz_list.setColumnIdentifiers(col_quiz_list);

        row_quiz_list = new Object[col_quiz_list.length];

        tbl_quiz_list.setModel(mdl_quiz_list);
        tbl_quiz_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_quiz_list.getColumnModel().getColumn(1).setMaxWidth(75);
        tbl_quiz_list.getTableHeader().setReorderingAllowed(false);
        loadContentCombo();
        loadQuizModel();

        tbl_quiz_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_quiz_id = tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 0).toString();
                fld_quiz_id.setText(select_quiz_id);
            } catch (Exception ignored){
            }
        });

        tbl_quiz_list.getModel().addTableModelListener(e -> {
            if(e.getType() == TableModelEvent.UPDATE) {
                int quiz_id = Integer.parseInt(tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 0).toString());
                int content_id = Integer.parseInt(tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 1).toString());
                String content_name = tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 2).toString();
                String question = tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 3).toString();
                loadContentModel();
                if(Quiz.update(quiz_id, content_id, content_name, question)) {
                    Helper.showMsg("done");
                }
                loadQuizModel();
                loadContentCombo();
            }
        });

        // ## Quiz List

        btn_add_content.addActionListener(e -> {
            Item courseItem = (Item) cmb_course.getSelectedItem();
            if(Helper.isFieldEmpty(fld_content_name) || Helper.isFieldEmpty(fld_content_desc) || Helper.isFieldEmpty(fld_content_link)) {
                Helper.showMsg("fill");
            } else {
                if (Content.add(courseItem.getKey(),fld_content_name.getText(), fld_content_desc.getText(), fld_content_link.getText(), courseItem.getValue())) {
                    Helper.showMsg("done");
                    loadContentModel();
                    loadQuizModel();
                    loadContentCombo();
                    fld_content_name.setText(null);
                    fld_content_desc.setText(null);
                    fld_content_link.setText(null);
                } else {
                    Helper.showMsg("error");
                }
            }
        });

        btn_sh_content.addActionListener(e -> {
            String course = fld_sh_course.getText();
            String  name= fld_sh_content.getText();
            String query = Content.searchQuery(course, name);
            loadContentModel(Content.searchContentList(query));
        });

        btn_content_delete.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_content_id)) {
                Helper.showMsg("fill");
            } else {
                if (Helper.confirm("sure")) {
                    int content_id = Integer.parseInt(fld_content_id.getText());
                    if(Content.delete(content_id)) {
                        Helper.showMsg("done");
                        loadContentModel();
                        loadCourseCombo();
                        loadQuizModel();
                        fld_content_id.setText(null);
                    } else {
                        Helper.showMsg("error");
                    }
                }
            }
        });

        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI login = new LoginGUI();
        });

        btn_quiz_add.addActionListener(e -> {
            Item contentItem = (Item) cmb_content.getSelectedItem();
            if(Helper.isFieldEmpty(fld_quiz)) {
                Helper.showMsg("fill");
            } else {
                if (Quiz.add(contentItem.getKey(),contentItem.getValue(), fld_quiz.getText())) {
                    Helper.showMsg("done");
                    loadQuizModel();
                    fld_quiz.setText(null);
                } else {
                    Helper.showMsg("error");
                }
            }
        });
        btn_quiz_delete.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_quiz_id)) {
                Helper.showMsg("fill");
            } else {
                if (Helper.confirm("sure")) {
                    int quiz_id = Integer.parseInt(fld_quiz_id.getText());
                    if(Quiz.delete(quiz_id)) {
                        Helper.showMsg("done");
                        loadQuizModel();
                        loadContentCombo();
                        fld_quiz_id.setText(null);
                    } else {
                        Helper.showMsg("error");
                    }
                }
            }
        });
    }

    private void loadQuizModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_quiz_list.getModel();
        clearModel.setRowCount(0);
        for (Quiz obj : Quiz.getList()) {
            if(obj.getContent().getCourse().getEducater().getName().equals(educator.getName())) {
                int i = 0;
                row_quiz_list[i++] = obj.getId();
                row_quiz_list[i++] = obj.getContent_id();
                row_quiz_list[i++] = obj.getContent().getName();
                row_quiz_list[i++] = obj.getQuestion();
                mdl_quiz_list.addRow(row_quiz_list);
            }
        }
    }

    private void loadContentModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_content.getModel();
        clearModel.setRowCount(0);
        for (Content obj : Content.getList()) {
            if(obj.getCourse().getEducater().getName().equals(educator.getName())) {
                int i = 0;
                row_content_list[i++] = obj.getId();
                row_content_list[i++] = obj.getName();
                row_content_list[i++] = obj.getDescription();
                row_content_list[i++] = obj.getLink();
                row_content_list[i++] = obj.getCourse().getName();
                mdl_content_list.addRow(row_content_list);
            }
        }
    }

    private void loadContentModel(ArrayList<Content> list) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_content.getModel();
        clearModel.setRowCount(0);
        for (Content obj : list) {
            if(obj.getCourse().getEducater().getName().equals(educator.getName())) {
                int i = 0;
                row_content_list[i++] = obj.getId();
                row_content_list[i++] = obj.getName();
                row_content_list[i++] = obj.getDescription();
                row_content_list[i++] = obj.getLink();
                row_content_list[i++] = obj.getCourse().getName();
                mdl_content_list.addRow(row_content_list);
            }
        }
    }

    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        for (Course obj : Course.getList()) {
            if (obj.getEducater().getName().equals(educator.getName())) {
                int i = 0;
                row_course_list[i++] = obj.getId();
                row_course_list[i++] = obj.getName();
                row_course_list[i++] = obj.getLang();
                row_course_list[i++] = obj.getPatika().getName();
                row_course_list[i++] = obj.getEducater().getName();
                mdl_course_list.addRow(row_course_list);
            }
        }
    }

    public void loadCourseCombo() {
        cmb_course.removeAllItems();
        for(Course obj : Course.getList()) {
            if(obj.getEducater().getName().equals(educator.getName())) {
                cmb_course.addItem(new Item(obj.getId(), obj.getName()));
            }
        }
    }

    public void loadContentCombo() {
        cmb_content.removeAllItems();
        for(Content obj : Content.getList()) {
            if(obj.getCourse().getEducater().getName().equals(educator.getName())) {
                cmb_content.addItem(new Item(obj.getId(), obj.getName()));
            }
        }
    }

    public static void main(String[] args) {
        Helper.setLayout();
        Educator ed = new Educator();
        ed.setId(1);
        ed.setName("Furkan Turan");
        ed.setUname("fturan");
        ed.setPass("1234");
        ed.setType("educater");

        EducatorGUI edGUI = new EducatorGUI(ed);
    }

}