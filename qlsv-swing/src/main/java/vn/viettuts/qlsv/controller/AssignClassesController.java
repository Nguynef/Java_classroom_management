package vn.viettuts.qlsv.controller;

import vn.viettuts.qlsv.view.AssignClassesView;
import vn.viettuts.qlsv.dao.ClassScheduleDao;
import vn.viettuts.qlsv.dao.RoomDao;
import vn.viettuts.qlsv.entity.ClassSchedule;
import vn.viettuts.qlsv.entity.Room;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class AssignClassesController {
    private AssignClassesView assignClassesView;
    private RoomDao roomDao;
    private ClassScheduleDao classScheduleDao;

    public AssignClassesController(AssignClassesView view, RoomDao roomDao, ClassScheduleDao classScheduleDao) {
        this.assignClassesView = view;
        this.roomDao = roomDao;
        this.classScheduleDao = classScheduleDao;

        // Lấy danh sách tên các phòng từ RoomDao và hiển thị trong roomComboBox
        List<String> roomNames = roomDao.getListRooms().stream()
                                          .map(Room::getRoomName)
                                          .collect(Collectors.toList());
        assignClassesView.setRoomOptions(roomNames);

        // Hiển thị danh sách lịch lớp học
        assignClassesView.setClassSchedules(classScheduleDao.getClassSchedules());
        assignClassesView.addClassListener(new AddClassListener());
    }

    private class AddClassListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String className = assignClassesView.getClassName();
            String room = assignClassesView.getSelectedRoom();
            String day = assignClassesView.getSelectedDay();
            String startTime = assignClassesView.getStartTime();
            String endTime = assignClassesView.getEndTime();

            if (isDuplicateClassName(className)) {
                assignClassesView.showMessage("Class name already exists. Please use a different name.");
                return;
            }

            if (!isValidTimeFormat(startTime) || !isValidTimeFormat(endTime)) {
                assignClassesView.showMessage("Invalid time format. Please use HH:mm format.");
                return;
            }
            if (!isTimeOrderValid(startTime, endTime)) {
                assignClassesView.showMessage("End time must be after start time.");
                return;
            }

            ClassSchedule newSchedule = new ClassSchedule(className, room, day, startTime, endTime);
            classScheduleDao.addClassSchedule(newSchedule);
            assignClassesView.setClassSchedules(classScheduleDao.getClassSchedules());
            assignClassesView.showMessage("Class added successfully.");
        }

        private boolean isDuplicateClassName(String className) {
            for (ClassSchedule schedule : classScheduleDao.getClassSchedules()) {
                if (schedule.getClassName().equalsIgnoreCase(className)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isValidTimeFormat(String time) {
            return time.matches("([01]?\\d|2[0-3]):[0-5]\\d");
        }

        private boolean isTimeOrderValid(String startTime, String endTime) {
            String[] start = startTime.split(":");
            String[] end = endTime.split(":");

            int startHour = Integer.parseInt(start[0]);
            int startMinute = Integer.parseInt(start[1]);
            int endHour = Integer.parseInt(end[0]);
            int endMinute = Integer.parseInt(end[1]);

            if (endHour > startHour) {
                return true;
            } else if (endHour == startHour) {
                return endMinute > startMinute;
            } else {
                return false;
            }
        }
    }
}
