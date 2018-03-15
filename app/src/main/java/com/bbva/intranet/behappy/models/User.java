package com.bbva.intranet.behappy.models;

/**
 * Created by gesformexico on 22/02/18.
 */

public class User {
    private String userM;
    private String firstname;
    private String lastname;
    private String email;
    private String registration_id;
    private String photo_url;

    public User(String userM, String firstname, String lastname, String email) {
        this.userM = userM;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getUserM() {
        return userM;
    }

    public void setUserM(String userM) {
        this.userM = userM;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(String registration_id) {
        this.registration_id = registration_id;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }


    @Override
    public String toString() {
        return "UserVO{" +
                ", userM='" + userM + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", registration_id='" + registration_id + '\'' +
                ", photo_url='" + photo_url + '\'' +
                '}';
    }
}
