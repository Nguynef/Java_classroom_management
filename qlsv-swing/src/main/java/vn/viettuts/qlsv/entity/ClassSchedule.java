package vn.viettuts.qlsv.entity;

public class ClassSchedule {
    private String className;
    private String room;
    private String day;
    private String startTime;
    private String endTime;

    public ClassSchedule(String className, String day, String startTime, String endTime) {
        this.className = className;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
