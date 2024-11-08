package vn.viettuts.qlsv.controller;

import vn.viettuts.qlsv.dao.ClassScheduleDao;
import vn.viettuts.qlsv.dao.RoomDao;
import vn.viettuts.qlsv.entity.ClassSchedule;
import vn.viettuts.qlsv.view.AssignClassesView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Controller for managing the assignment of classes to rooms.
 */
public class AssignClassesController {
    private AssignClassesView assignClassesView;
    private RoomDao roomDao;
    private ClassScheduleDao classScheduleDao;
    private Map<String, List<ClassSchedule>> roomSchedules;

    public AssignClassesController(AssignClassesView view, RoomDao dao, ClassScheduleDao classScheduleDao) {
        this.assignClassesView = view;
        this.roomDao = dao;
        this.classScheduleDao = classScheduleDao;
        this.roomSchedules = new HashMap<>();
        
        view.addClassListener(new AddClassListener());
        view.addRemoveClassListener(new RemoveClassListener()); // Add listener for removing classes
        view.setClassSchedules(classScheduleDao.getClassSchedules());
        
        loadRoomData();
    }

    private void loadRoomData() {
        List<String> roomNames = new ArrayList<>();
        roomDao.getListRooms().forEach(room -> roomNames.add(room.getRoomName()));
        assignClassesView.setRoomOptions(roomNames);
    }

    class AddClassListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String className = assignClassesView.getClassName();
            String roomName = assignClassesView.getSelectedRoom();
            String day = assignClassesView.getSelectedDay();
            String startTime = assignClassesView.getStartTime();
            String endTime = assignClassesView.getEndTime();

            if (className.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
                assignClassesView.showMessage("All fields are required.");
                return;
            }

            // Check for time conflicts
            if (!isTimeSlotAvailable(roomName, day, startTime, endTime)) {
                assignClassesView.showMessage("The time slot is already taken.");
                return;
            }

            // Add the new class
            ClassSchedule newClassSchedule = new ClassSchedule(className, day, startTime, endTime);
            newClassSchedule.setRoom(roomName);
            roomSchedules.computeIfAbsent(roomName, k -> new ArrayList<>()).add(newClassSchedule);
            classScheduleDao.addClassSchedule(newClassSchedule);
            updateClassesTable();

            assignClassesView.showMessage("Class added successfully.");
        }
    }

    class RemoveClassListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = assignClassesView.getSelectedClassIndex();

            if (selectedIndex == -1) {
                assignClassesView.showMessage("Please select a class to remove.");
                return;
            }

            // Get the selected class schedule and remove it
            List<ClassSchedule> allSchedules = classScheduleDao.getClassSchedules();
            if (selectedIndex < allSchedules.size()) {
                ClassSchedule scheduleToRemove = allSchedules.get(selectedIndex);
                classScheduleDao.removeClassSchedule(scheduleToRemove);
                roomSchedules.get(scheduleToRemove.getRoom()).remove(scheduleToRemove);

                updateClassesTable();
                assignClassesView.showMessage("Class removed successfully.");
            } else {
                assignClassesView.showMessage("Error: Selected class not found.");
            }
        }
    }

    private boolean isTimeSlotAvailable(String room, String day, String startTime, String endTime) {
        List<ClassSchedule> schedules = roomSchedules.getOrDefault(room, Collections.emptyList());
        for (ClassSchedule schedule : schedules) {
            if (schedule.getDay().equals(day) && isOverlapping(schedule.getStartTime(), schedule.getEndTime(), startTime, endTime)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOverlapping(String start1, String end1, String start2, String end2) {
        return !(end1.compareTo(start2) <= 0 || start1.compareTo(end2) >= 0);
    }

    private void updateClassesTable() {
        List<ClassSchedule> allSchedules = classScheduleDao.getClassSchedules();
        allSchedules.sort(Comparator.comparing(ClassSchedule::getDay).thenComparing(ClassSchedule::getStartTime));
        Object[][] data = new Object[allSchedules.size()][5];
        for (int i = 0; i < allSchedules.size(); i++) {
            ClassSchedule schedule = allSchedules.get(i);
            data[i][0] = schedule.getClassName();
            data[i][1] = schedule.getRoom();
            data[i][2] = schedule.getDay();
            data[i][3] = schedule.getStartTime();
            data[i][4] = schedule.getEndTime();
        }
        assignClassesView.updateClassesTable(data);
    }
}
