package com.sda.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_name", length = 50)
    private String doctorName;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    Hospital hospital;

    public Doctor(String doctorName, Hospital hospital) {
        this.doctorName = doctorName;
        this.hospital = hospital;
    }

    public Doctor() {
    }

    @Override
    public String toString() {
        return "doctorName='" + doctorName;
    }
}
