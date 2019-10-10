package ru.javawebinar.clients.model;

import java.sql.Blob;
import java.time.LocalDateTime;

public class Client extends AbstractBaseEntity {
    private String firstName;

    private String lastName;

    private LocalDateTime dateTime;

    private String status;

    private String satisfaction;

    private String address;

    private String email;

    private String telephoneNumber;

    private String imagePath;


    public Client(String firstName, String lastName, LocalDateTime dateTime, String status, String satisfaction, String address, String email, String telephoneNumber) {
        this.id = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateTime = dateTime;
        this.status = status;
        this.satisfaction = satisfaction;
        this.address = address;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }

    public Client(Integer id, String firstName, String lastName, LocalDateTime dateTime, String status, String satisfaction, String address, String email, String telephoneNumber) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateTime = dateTime;
        this.status = status;
        this.satisfaction = satisfaction;
        this.address = address;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }

    public Client( String firstName, String lastName, LocalDateTime dateTime, String status, String satisfaction, String address, String email, String telephoneNumber, String imagePath) {
        this.id = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateTime = dateTime;
        this.status = status;
        this.satisfaction = satisfaction;
        this.address = address;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.imagePath = imagePath;
    }

    public Client() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateTimeLastContact=" + dateTime +
                ", status='" + status + '\'' +
                ", satisfaction='" + satisfaction + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
