package com.sda.model;
//se importa din javax fiindca java ofera interfata iar hibernate implementarea
import javax.persistence.*;

@Entity
@Table(name= "patient")
public class Patient {
    @Id
    @Column(name = "patient_id")
    @GeneratedValue
    private Long Id;

    @Column(name = "patinet_name", length = 40)
    private String patientName;

    @Column(name = "patient_age", nullable = false)
    private long patientAge;

    @OneToOne(cascade = CascadeType.ALL)
    private Email email;

    public Patient(String patientName, long patientAge, Email email) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.email = email;
    }
}
