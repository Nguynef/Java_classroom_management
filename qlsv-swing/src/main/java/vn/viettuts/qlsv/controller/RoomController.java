package vn.viettuts.qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vn.viettuts.qlsv.dao.RoomDao;
import vn.viettuts.qlsv.entity.Room;
import vn.viettuts.qlsv.view.RoomView;

public class RoomController {
    private RoomDao roomDao;
    private RoomView roomView;

    public RoomController(RoomView view) {
        this.roomView = view;
        roomDao = new RoomDao();

        view.addAddRoomListener(new AddRoomListener());
        view.editRoomListener(new EditRoomListener());
        view.deleteRoomListener(new DeleteRoomListener());
        view.clearRoomListener(new ClearRoomListener());
        view.addListRoomSelectionListener(new ListRoomSelectionListener());
    }

    public void showRoomView() {
        List<Room> roomList = roomDao.getListRooms();
        roomView.setVisible(true);
        roomView.showListRooms(roomList);
    }

    /**
     * Inner class AddRoomListener
     * Handles the "Add" button click event
     */
    class AddRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Room room = roomView.getRoomInfo();
            if (room != null) {
                roomDao.add(room);
                roomView.showListRooms(roomDao.getListRooms());
                roomView.showMessage("Room added successfully!");
            }
        }
    }

    /**
     * Inner class EditRoomListener
     * Handles the "Edit" button click event
     */
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

    /**
     * Inner class DeleteRoomListener
     * Handles the "Delete" button click event
     */
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

    /**
     * Inner class ClearRoomListener
     * Handles the "Clear" button click event
     */
    class ClearRoomListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            roomView.clearRoomInfo();
        }
    }

    /**
     * Inner class ListRoomSelectionListener
     * Handles the event when a room is selected in the table
     */
    class ListRoomSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            roomView.fillRoomFromSelectedRow();
        }
    }
}
