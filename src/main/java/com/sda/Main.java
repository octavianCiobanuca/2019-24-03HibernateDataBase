package com.sda;

import com.sda.dao.DoctorDao;
import com.sda.dao.HospitalDao;
import com.sda.dao.PatientDao;
import com.sda.model.Doctor;
import com.sda.model.Email;
import com.sda.model.Hospital;
import com.sda.model.Patient;
import com.sda.util.HibernateUtil;
import org.hibernate.Hibernate;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

//Vlad Mihalcea explicare hibernate
public class Main {

    public static void main(String[] args) {
        try {
//            createPatientWithMail();
//            createHospital();
//            createDoctor();
            displayDoctorsAndTheirHospital();

        } finally {
            HibernateUtil.close();
        }
    }

    public static void createPatientWithMail() {
        PatientDao patientDao = new PatientDao();
        Email email = new Email("popescu@gmail.com");
        Patient patient = new Patient("Popescu", 20, email);
        patientDao.createEntity(patient);
    }

    public static void createHospital() {
        HospitalDao hospitalDao = new HospitalDao();
        Hospital hospital = new Hospital("ElenaDoamna");
        hospitalDao.createEntity(hospital);
    }

    public static void createDoctor() {
        HospitalDao hospitalDao = new HospitalDao();
        DoctorDao doctorDao = new DoctorDao();
        Doctor doctor1 = new Doctor("Doctorescu", hospitalDao.getEntityById(Hospital.class, 1l));
        Doctor doctor2 = new Doctor("Medicescu", hospitalDao.getEntityById(Hospital.class, 1l));
        doctorDao.createEntity(doctor1);
        doctorDao.createEntity(doctor2);
    }
    public static void displayDoctorsAndTheirHospital(){
        HospitalDao hospitalDao = new HospitalDao();
        //DoctorDao doctorDao = new DoctorDao();
        //List<Doctor> doctors= new ArrayList<Doctor>();
        Hospital hospital = hospitalDao.getEntityById(Hospital.class,1l);
        for (Doctor doctor: hospital.getDoctors()) {
            System.out.println(doctor.toString()+" "+ hospital.toString());
        }
    }
}