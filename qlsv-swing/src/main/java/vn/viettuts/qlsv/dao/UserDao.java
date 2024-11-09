package vn.viettuts.qlsv.dao;

import vn.viettuts.qlsv.entity.User;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class UserDao {
    private static final String USER_XML_FILE = System.getProperty("java.io.tmpdir") + File.separator + "userXML.xml";


    // Lưu đối tượng User vào file XML
    public void saveUserToXML(User user) {
        try {
            JAXBContext context = JAXBContext.newInstance(User.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(user, new File(USER_XML_FILE));
            //System.out.println("User data saved to " + USER_XML_FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    // Đọc đối tượng User từ file XML
    public User loadUserFromXML() {
        try {
            File file = new File(USER_XML_FILE);
            if (!file.exists()) {
                return null; // Nếu file không tồn tại, trả về null
            }
            JAXBContext context = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (User) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Kiểm tra tài khoản User từ file XML
    public boolean checkUser(User inputUser) {
        User storedUser = loadUserFromXML();
        if (storedUser != null && storedUser.getUserName().equals(inputUser.getUserName())
                && storedUser.getPassword().equals(inputUser.getPassword())) {
            return true;
        }
        return false;
    }
    /*public void initializeDefaultUser() {
        File file = new File(USER_XML_FILE);
        if (!file.exists()) {
            User defaultUser = new User("admin", "admin");
            saveUserToXML(defaultUser);
        }
    }*/
    
}
