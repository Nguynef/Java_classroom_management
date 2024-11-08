package vn.viettuts.qlsv;

import java.awt.EventQueue;

import vn.viettuts.qlsv.controller.LoginController;
import vn.viettuts.qlsv.view.LoginView;

public class App {
    public static void main(String[] args) {
        System.setProperty("com.sun.xml.bind.v2.runtime.reflect.opt.Injector.noOptimize", "true");
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginView view = new LoginView();
                LoginController controller = new LoginController(view);
                // hiển thị màn hình login
                controller.showLoginView();
            }
        });
    }
}