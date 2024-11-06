package vn.viettuts.qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import vn.viettuts.qlsv.dao.RoomDao;
import vn.viettuts.qlsv.dao.ClassScheduleDao; // Import ClassScheduleDao
import vn.viettuts.qlsv.entity.Room;
import vn.viettuts.qlsv.view.AssignClassesView;
import vn.viettuts.qlsv.view.RoomView;

public class RoomController {
    private RoomDao roomDao;
    private ClassScheduleDao classScheduleDao; // Thêm ClassScheduleDao
    private RoomView roomView;

    public RoomController(RoomView view) {
        this.roomView = view;
        this.roomDao = new RoomDao();
        this.classScheduleDao = new ClassScheduleDao(); // Khởi tạo ClassScheduleDao

        view.addAddRoomListener(new AddRoomListener());
        view.editRoomListener(new EditRoomListener());
        view.deleteRoomListener(new DeleteRoomListener());
        view.clearRoomListener(new ClearRoomListener());
        view.addListRoomSelectionListener(new ListRoomSelectionListener());
        view.addAssignClassesListener(new AssignClassesListener());
    }

    public void showRoomView() {
        List<Room> roomList = roomDao.getListRooms();
        roomView.setVisible(true);
        roomView.showListRooms(roomList);
    }

    class AddRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Room room = roomView.getRoomInfo();
            if (room != null) {
                // Kiểm tra tính duy nhất của roomName
                if (isDuplicateRoomName(room.getRoomName())) {
                    roomView.showMessage("Room number already exists. Please use a different number.");
                    return;
            }

            roomDao.add(room);
            roomView.showListRooms(roomDao.getListRooms());
            roomView.showMessage("Room added successfully!");
        }
    }

    // Kiểm tra xem roomName có trùng hay không
    private boolean isDuplicateRoomName(String roomName) {
        for (Room existingRoom : roomDao.getListRooms()) {
            if (existingRoom.getRoomName().equalsIgnoreCase(roomName)) {
                    return true;
                }
            }
            return false;
        }
    }


    class EditRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Room room = roomView.getRoomInfo();
            if (room != null) {
                roomDao.edit(room);
                roomView.showListRooms(roomDao.getListRooms());
                roomView.showMessage("Room updated successfully!");
            }
        }
    }

    class DeleteRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Room room = roomView.getRoomInfo();
            if (room != null) {
                roomDao.delete(room);
                roomView.clearRoomInfo();
                roomView.showListRooms(roomDao.getListRooms());
                roomView.showMessage("Room deleted successfully!");
            }
        }
    }

    class ClearRoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            roomView.clearRoomInfo();
        }
    }

    class ListRoomSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            roomView.fillRoomFromSelectedRow();
        }
    }

    class AssignClassesListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AssignClassesView assignClassesView = new AssignClassesView();
            // Truyền cả roomDao và classScheduleDao
            new AssignClassesController(assignClassesView, roomDao, classScheduleDao); 
            assignClassesView.setVisible(true);
        }
    }
    
}
