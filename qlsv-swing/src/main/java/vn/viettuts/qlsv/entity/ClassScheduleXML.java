package vn.viettuts.qlsv.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "classSchedules")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassScheduleXML {

    @XmlElement(name = "classSchedule")
    private List<ClassSchedule> classSchedules;

    public List<ClassSchedule> getClassSchedules() {
        return classSchedules;
    }

    public void setClassSchedules(List<ClassSchedule> classSchedules) {
        this.classSchedules = classSchedules;
    }
}
