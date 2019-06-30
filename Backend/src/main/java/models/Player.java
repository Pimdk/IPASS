package models;

import java.util.Date;

public class Player {
    private int id;
    private String forname;
    private String surname;
    private String gender;
    private Date birthday;
    private String username;
    private String email;

    public Player(int id, String forname, String surname, String gender, Date birthday, String username, String email) {
        this.id = id;
        this.forname = forname;
        this.surname = surname;
        this.gender = gender;
        this.birthday = birthday;
        this.username = username;
        this.email = email;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public String getForname() {
        return forname;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
