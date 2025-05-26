package one_to_one.entity;

import jakarta.persistence.*;

@Entity
@Table(name="jpa_certificates")
public class Certificate
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cid;

    String title;

    @Column(length = 150)
    String description;

    @OneToOne
    @JoinColumn(name = "student_id")
    Student student;


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
