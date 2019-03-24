package com.sda.model;
import javax.persistence.*;

@Entity
@Table(name = "email")
public class Email {
    @Id
    @Column(name = "email_id", length = 50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "email_address", length = 40)
    private String emailAddress;

    public Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
