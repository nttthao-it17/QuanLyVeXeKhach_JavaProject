/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhb.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author T430s
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    private static long serialVersionUID = 3L;
    private static String USER = "ROLE_USER";
    private static String ADMIN = "ROLE_ADMIN";
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "fullname")
    @Size(min = 1, max=100, message = "{user.fullname.error.sizeMsg}")
    private String fullname;
    
    @Column(name = "username")
    @Size(min = 1, max = 20, message = "{user.username.error.sizeMsg}")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "{user.password.error.sizeMsg}")
    private String password;
    
    @Column(name = "email")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "{user.email.error.invalidMsg}")
    private String email;
    
    @Column(name = "phone")
    @Pattern(regexp = "\\d{10}", message = "{user.phone.error.invalidMsg}")
    private String phone;
    
    @OneToMany(mappedBy = "user")
    private List<Feedback> feedback;
    
    @OneToMany(mappedBy = "user")
    private List<BookingTicket> bookings;
    
    @Column(name = "userRole")
    private String userRole;
    
    @Transient
    private String confirmPassword;
    {
        setUserRole(getUSER());
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the USER
     */
    public static String getUSER() {
        return USER;
    }

    /**
     * @param aUSER the USER to set
     */
    public static void setUSER(String aUSER) {
        USER = aUSER;
    }

    /**
     * @return the ADMIN
     */
    public static String getADMIN() {
        return ADMIN;
    }

    /**
     * @param aADMIN the ADMIN to set
     */
    public static void setADMIN(String aADMIN) {
        ADMIN = aADMIN;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the bookings
     */
    public List<BookingTicket> getBookings() {
        return bookings;
    }

    /**
     * @param bookings the bookings to set
     */
    public void setBookings(List<BookingTicket> bookings) {
        this.bookings = bookings;
    }

    /**
     * @return the feedback
     */
    public List<Feedback> getFeedback() {
        return feedback;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }
}
