package com.sda.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hospital")
public class Hospital {
    @Id
    @Column(name = "hospital_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;

    @Column(name = "hospital_name", length = 50)
    private String hospitalName;


    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctors;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public Hospital() {
    }

    @Override
    public String toString() {
        return "hospitalName=" + hospitalName;
    }
}
