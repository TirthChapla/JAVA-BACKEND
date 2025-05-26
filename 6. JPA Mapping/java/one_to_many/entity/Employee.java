package one_to_many.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jpa_employee")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sid;

    @Column(length = 100 , nullable = false)
    String name;

    @Column(length = 20)
    String email;

    @ManyToOne
    @JoinColumn(name = "deparment_id")
    Deparment deparment;

    int Salary;


    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Deparment getDeparment() {
        return deparment;
    }

    public void setDeparment(Deparment deparment) {
        this.deparment = deparment;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
