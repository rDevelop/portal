package user.portal.model;


import java.io.Serializable;

public class UserCopy implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private UserRole role = UserRole.USER;
    public UserCopy(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName ='" + firstName + '\'' +
                ", lastName=" + lastName +
                ", email=" + email +
                '}';
    }

    public enum UserRole {
        ADMIN, USER
    }
}