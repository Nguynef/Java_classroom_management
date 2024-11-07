package vn.viettuts.qlsv.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vn.viettuts.qlsv.entity.Room;
import vn.viettuts.qlsv.entity.RoomXML;
import vn.viettuts.qlsv.utils.FileUtils;

/**
 * RoomDao class
 * 
 * Manages operations for Room objects.
 */
public class RoomDao {
    private static final String ROOM_FILE_NAME = "room.xml";
    private List<Room> listRooms;

    public RoomDao() {
        this.listRooms = readListRooms();
        if (listRooms == null) {
            listRooms = new ArrayList<Room>();
        }
        if(listRooms.isEmpty()){
            writeListRooms(listRooms);
        }
    }

    /**
     * Saves the list of Room objects to the file room.xml
     * 
     * @param rooms the list of Room objects to be saved
     */
    public void writeListRooms(List<Room> rooms) {
        RoomXML roomXML = new RoomXML();
        roomXML.setRoom(rooms);
        FileUtils.writeXMLtoFile(ROOM_FILE_NAME, roomXML);
    }

    /**
     * Reads the list of Room objects from the file room.xml
     * 
     * @return the list of Room objects
     */
    public List<Room> readListRooms() {
        List<Room> list = new ArrayList<Room>();
        File file = new File(ROOM_FILE_NAME);
        if(!file.exists()){
            return list;
        }
        RoomXML roomXML = (RoomXML) FileUtils.readXMLFile(ROOM_FILE_NAME, RoomXML.class);
        if (roomXML != null) {
            list = roomXML.getRoom();
        }
        return list;
    }

    /**
     * Adds a new Room to the listRooms and saves the listRooms to the file
     * 
     * @param room the Room object to be added
     */
    public void add(Room room) {
        listRooms.add(room);
        writeListRooms(listRooms);
    }

    /**
     * Updates a Room in the listRooms and saves the listRooms to the file
     * 
     * @param room the Room object to be updated
     */
    public void edit(Room room) {
        int size = listRooms.size();
        for (int i = 0; i < size; i++) {
            if (listRooms.get(i).getRoomName().equals(room.getRoomName())) {
                listRooms.get(i).setMachineCount(room.getMachineCount());
                listRooms.get(i).setProjector(room.hasProjector());
                listRooms.get(i).setWhiteboard(room.hasWhiteboard());
                listRooms.get(i).setInternet(room.hasInternet());
                writeListRooms(listRooms);
                break;
            }
        }
    }

    /**
     * Deletes a Room from the listRooms and saves the listRooms to the file
     * 
     * @param room the Room object to be deleted
     * @return true if the Room was found and deleted, false otherwise
     */
    public boolean delete(Room room) {
        boolean isFound = false;
        int size = listRooms.size();
        for (int i = 0; i < size; i++) {
            if (listRooms.get(i).getRoomName().equals(room.getRoomName())) {
                room = listRooms.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listRooms.remove(room);
            writeListRooms(listRooms);
            return true;
        }
        return false;
    }

    /**
     * Sorts the list of Rooms by name in ascending order
     */
    public void sortRoomByName() {
        Collections.sort(listRooms, new Comparator<Room>() {
            public int compare(Room room1, Room room2) {
                return room1.getRoomName().compareTo(room2.getRoomName());
            }
        });
    }

    /**
     * Sorts the list of Rooms by the number of machines in ascending order
     */
    public void sortRoomByMachineCount() {
        Collections.sort(listRooms, new Comparator<Room>() {
            public int compare(Room room1, Room room2) {
                return Integer.compare(room1.getMachineCount(), room2.getMachineCount());
            }
        });
    }

    public List<Room> getListRooms() {
        return listRooms;
    }

    public void setListRooms(List<Room> listRooms) {
        this.listRooms = listRooms;
    }
    public Room findRoomByName(String roomName) {
        return getListRooms().stream()
                         .filter(room -> room.getRoomName().equals(roomName))
                         .findFirst()
                         .orElse(null);
    }
}
