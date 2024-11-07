package vn.viettuts.qlsv.service;

import vn.viettuts.qlsv.entity.Room;
import java.util.List;

public class StatisticsService {

    public int getTotalRooms(List<Room> rooms) {
        return rooms.size();
    }

    public int getTotalMachines(List<Room> rooms) {
        return rooms.stream().mapToInt(Room::getMachineCount).sum();
    }

    public int getRoomsWithProjectors(List<Room> rooms) {
        return (int) rooms.stream().filter(Room::hasProjector).count();
    }

    public int getRoomsWithWhiteboards(List<Room> rooms) {
        return (int) rooms.stream().filter(Room::hasWhiteboard).count();
    }

    public int getRoomsWithInternet(List<Room> rooms) {
        return (int) rooms.stream().filter(Room::hasInternet).count();
    }
}
