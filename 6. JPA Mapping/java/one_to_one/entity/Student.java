package one_to_one.entity;

import jakarta.persistence.*;

import one_to_one.entity.Certificate;

@Entity
@Table(name = "jpa_students")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sid;

    @Column(length = 100 , nullable = false)
    String name;

    @Column(length = 20)
    String email;

    @OneToOne(mappedBy = "student")
    Certificate certificate;

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return sid;
    }

    public void setId(int id) {
        this.sid = id;
    }


}
