package model;

public class Student {

    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) { this.marks = marks; }

    public String getGrade() {
    if (marks >= 90) return "A";
    else if (marks >= 75) return "B";
    else if (marks >= 50) return "C";
    else return "Fail";
    }

    // Print format
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Grade: " + getGrade();
    }
}