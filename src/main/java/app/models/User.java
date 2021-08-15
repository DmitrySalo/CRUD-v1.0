package app.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name length should be between 2 and 30 characters!")
    private String name;

    @Column(name = "age")
    @Min(value = 0, message = "Age should be greater than 0!")
    @Max(value = 125, message = "Age should not be greater than 100!")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Email should be valid!")
    @Size(min = 6, max = 46, message = "Email length should be between 7 and 46 characters!")
    private String email;

    public User() {
    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                && age == user.age
                && name.equals(user.name)
                && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(id, name, age, email);
    }
}