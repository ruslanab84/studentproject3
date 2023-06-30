package model;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Info {
    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    private List<Student> students;
    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    private List<University> universities;
    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statistics;
    @XmlElement(name = "processedAt")
    private Date createDate;

    public Info() {
    }

    public List<Student> getStudents() {
        return students;
    }

    public Info setStudents(List<Student> students) {
        this.students = students;
        return this;
    }
    public List<University> getUniversities() {
        return universities;
    }

    public Info setUniversities(List<University> universities) {
        this.universities = universities;
        return this;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public Info setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Info setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }
}
