package student.management.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String dob;
    private String address;
    private double gpa;
    private boolean isDeleted = false;

    public Student() {
    }

    public Student(int id, String name, String email, String dob, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.gpa = gpa;
    }

    public Student(String name, String email, String dob, String address) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.address = address;
    }

    public Student(int id, String name, String email, String dob, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.address = address;
    }

    public Student(String name, String email, String dob, String address, boolean isDeleted) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.isDeleted = isDeleted;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDelete(boolean delete) {
        isDeleted = delete;
    }
}
