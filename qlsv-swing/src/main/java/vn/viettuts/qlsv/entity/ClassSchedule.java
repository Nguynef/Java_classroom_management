package vn.viettuts.qlsv.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "classSchedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassSchedule {
    @XmlElement
    private String className;

    @XmlElement
    private String room;

    @XmlElement
    private String day;

    @XmlElement
    private String startTime;

    @XmlElement
    private String endTime;

    public ClassSchedule() {}

    public ClassSchedule(String className, String day, String startTime, String endTime) {
        this.className = className;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and setters
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
