package ua.kahamlyk.models;

import javax.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min=2, max = 30, message="Name size should be from 2 to 30")
    private String name;

    @Min(value = 0, message = "Age must be greater then 0")
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should contain properly format")
    private String email;

    // Country, City, postcode(5 digits)
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{5}", message = "Your address should be valid")
    private String address;

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

    public Person(){}

    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
