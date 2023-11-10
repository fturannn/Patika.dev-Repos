package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentSignUp extends JFrame{
    private JTextField fld_signup_name;
    private JTextField fld_signup_uname;
    private JTextField fld_signup_pass;
    private JButton btn_signup;
    private JPanel wrapper;

    public StudentSignUp() {
        add(wrapper);
        setSize(200,350);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        Helper.setLayout();

        btn_signup.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_signup_name) || Helper.isFieldEmpty(fld_signup_uname) || Helper.isFieldEmpty(fld_signup_pass)) {
                Helper.showMsg("fill");
            } else {
                String name = fld_signup_name.getText();
                String uname = fld_signup_uname.getText();
                String pass = fld_signup_pass.getText();
                if (User.add(name,uname,pass,"student")) {
                    Helper.showMsg("done");
                    dispose();
                }
            }
        });
    }
}
