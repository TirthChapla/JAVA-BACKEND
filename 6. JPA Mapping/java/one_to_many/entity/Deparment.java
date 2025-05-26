package one_to_many.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="jpa_deparments")
public class Deparment
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cid;

    String title;

    int code;

    @OneToMany(mappedBy = "deparment", cascade = CascadeType.ALL)
    List<Employee> employee;


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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
