package vn.viettuts.qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import vn.viettuts.qlsv.dao.UserDao;
import vn.viettuts.qlsv.entity.User;
import vn.viettuts.qlsv.view.LoginView;
import vn.viettuts.qlsv.view.RoomView;

public class LoginController {
    private UserDao userDao;
    private LoginView loginView;
    private RoomView RoomView;
    
    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserDao();
        //this.userDao.initializeDefaultUser();
        view.addLoginListener(new LoginListener());
        view.addRegisterListener(new RegisterListener());
    }
    
    public void showLoginView() {
        loginView.setVisible(true);
        loginView.setLocationRelativeTo(null);
    }
    
    /**
     * Lớp LoginListener 
     * chứa cài đặt cho sự kiện click button "Login"
     * 
     * @author viettuts.vn
     */
    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                RoomView = new RoomView();
                RoomController studentController = new RoomController(RoomView);
                studentController.showRoomView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoặc password không đúng.");
                /*RoomView = new RoomView();
                RoomController studentController = new RoomController(RoomView);
                studentController.showRoomView();
                loginView.setVisible(false);*/
            }
        }
    }
    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = JOptionPane.showInputDialog("Enter new username:");
            String password = JOptionPane.showInputDialog("Enter new password:");

            if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {
                User newUser = new User(username, password);
                userDao.saveUserToXML(newUser);
                loginView.showMessage("User registered successfully!");
            } else {
                loginView.showMessage("Registration failed. Username and password cannot be empty.");
            }
        }
    }  
}
