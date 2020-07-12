package edu.plohoy.spitter.api.domain;

import java.util.Objects;

public class Spitter {
    private long id;
    private String userName;
    private String password;
    private String fullName;
    private String email;

    public Spitter() {
    }
//    public Spitter(String name) {
//        this.userName = name;
//    }

    public Spitter(String userName, String password, String fullName, String email) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spitter)) return false;
        Spitter spitter = (Spitter) o;
        return id == spitter.id &&
                userName.equals(spitter.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName);
    }

    @Override
    public String toString() {
        return "Spitter{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
