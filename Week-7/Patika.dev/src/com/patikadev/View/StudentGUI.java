package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentGUI  extends JFrame{
    private JPanel wrapper;
    private JTabbedPane tab_student;
    private JButton btn_logout;
    private JTable tbl_patika_list;
    private JPanel pnl_top;
    private JPanel pnl_patika_list;
    private JLabel lbl_welcome;
    private JScrollPane scrl_patika_list;
    private JPanel pnl_register;
    private JTable tbl_register;
    private JScrollPane scrl_register;
    private JTextField fld_course_id;
    private JButton btn_register;
    private JPanel pnl_registered_courses;
    private JTable tbl_registered_course;
    private JScrollPane scrl_registered_course;
    private JTextField fld_chose;
    private JTextField fld_comment;
    private JButton btn_comment;
    private JComboBox cmb_rate;
    private JButton btn_rate;
    private JButton btn_drop;
    private JComboBox cmb_drop;
    private JTextField fld_drop;
    private DefaultTableModel mdl_patika_list;
    private Object [] row_patika_list;
    private DefaultTableModel mdl_register;
    private Object [] row_register;
    private DefaultTableModel mdl_registered_courses;
    private Object [] row_registered_courses;

    private final Student student;

    public StudentGUI(Student student) {
        this.student = student;

        add(wrapper);
        setSize(1000,500);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        lbl_welcome.setText("Hoşgeldin " + student.getName());

        // Patika List
        mdl_patika_list = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_patika_list = {"ID", "Patika Adı"};
        mdl_patika_list.setColumnIdentifiers(col_patika_list);

        row_patika_list = new Object[col_patika_list.length];
        loadPatikaModel();

        tbl_patika_list.setModel(mdl_patika_list);
        tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        // ## Patika List

        // Register
        mdl_register = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_register = {"ID", "Patika Adı", "Ders Adı", "Programlama Dili", "Eğitmen"};
        mdl_register.setColumnIdentifiers(col_register);

        row_register = new Object[col_register.length];


        tbl_register.setModel(mdl_register);
        tbl_register.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_register.getTableHeader().setReorderingAllowed(false);
        loadRegisterModel();

        tbl_register.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_course_id = tbl_register.getValueAt(tbl_register.getSelectedRow(), 0).toString();
                fld_course_id.setText(select_course_id);
            } catch (Exception ignored){
            }
        });

        // ## Register

        // Registered Courses
        mdl_registered_courses = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_registered_courses = {"ID", "Ders Adı", "İçerik", "Yorum", "Değerlendirme"};
        mdl_registered_courses.setColumnIdentifiers(col_registered_courses);

        row_registered_courses = new Object[col_registered_courses.length];


        tbl_registered_course.setModel(mdl_registered_courses);
        tbl_registered_course.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_registered_course.getTableHeader().setReorderingAllowed(false);
        loadRegisteredCoursesModel();
        loadCourseCombo();

        tbl_registered_course.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_id = tbl_registered_course.getValueAt(tbl_registered_course.getSelectedRow(), 0).toString();
                fld_chose.setText(select_id);
            } catch (Exception ignored){
            }
        });

        // ## Registered Courses

        btn_register.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_course_id)) {
                Helper.showMsg("fill");
            } else {
                if (Helper.confirm("sure")) {
                    int course_id = Integer.parseInt(fld_course_id.getText());
                    for (Content obj : Content.getList()) {
                        if(obj.getCourse().getName().equals(Course.getFetch(course_id).getName())) {
                            int content_id = obj.getId();
                            Registered.add(course_id, Course.getFetch(course_id).getName(), content_id, Content.getFetch(content_id).getName());
                        }
                    }
                    Helper.showMsg("done");
                    fld_course_id.setText(null);
                    loadRegisteredCoursesModel();
                    loadCourseCombo();
                }
            }
        });

        btn_drop.addActionListener(e -> {
            Item selectedItem = (Item) cmb_drop.getSelectedItem();
            if (Helper.confirm("sure")) {
                int course_id = selectedItem.getKey();
                if(Registered.drop(course_id)) {
                    Helper.showMsg("done");
                    loadRegisteredCoursesModel();
                    loadCourseCombo();
                    fld_chose.setText(null);
                } else {
                    Helper.showMsg("error");
                }
            }

        });

        btn_comment.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_comment) || Helper.isFieldEmpty(fld_chose)) {
                Helper.showMsg("fill");
            } else {
                int selected_id = Integer.parseInt(fld_chose.getText());
                if (Registered.update(fld_comment.getText(), selected_id)) {
                    Helper.showMsg("done");
                    loadRegisteredCoursesModel();
                    loadCourseCombo();
                    fld_comment.setText(null);
                } else {
                    Helper.showMsg("error");
                }
            }
        });
    }

    private void loadRegisteredCoursesModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_registered_course.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Registered obj : Registered.getList()) {
            i = 0;
            row_registered_courses[i++] = obj.getId();
            row_registered_courses[i++] = obj.getCourse().getName();
            row_registered_courses[i++] = obj.getContent().getName();
            row_registered_courses[i++] = obj.getComment();
            row_registered_courses[i++] = obj.getRating();
            mdl_registered_courses.addRow(row_registered_courses);
        }
    }

    private void loadRegisterModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_register.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Course obj : Course.getList()) {
            i = 0;
            row_register[i++] = obj.getId();
            row_register[i++] = obj.getPatika().getName();
            row_register[i++] = obj.getName();
            row_register[i++] = obj.getLang();
            row_register[i++] = obj.getEducater().getName();
            mdl_register.addRow(row_register);
        }
    }

    private void loadPatikaModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika_list.getModel();
        clearModel.setRowCount(0);
        for (Patika obj : Patika.getList()) {
            int i = 0;
            row_patika_list[i++] = obj.getId();
            row_patika_list[i++] = obj.getName();
            mdl_patika_list.addRow(row_patika_list);
        }
    }

    public void loadCourseCombo() {
        cmb_drop.removeAllItems();
        for(Course obj : Course.getList()) {
            int count = 0;
            for(Registered obj2 : Registered.getList()) {
                if(obj.getId() == obj2.getCourse_id()) {
                    if (count == 0) {
                        cmb_drop.addItem(new Item(obj.getId(), obj.getName()));
                    } else {
                        break;
                    }
                    count += 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Helper.setLayout();
        Student st = new Student();
        st.setId(1);
        st.setName("Emine Yıldız");
        st.setUname("eyildiz");
        st.setPass("1234");
        st.setType("student");

        StudentGUI stGUI = new StudentGUI(st);
    }
}
