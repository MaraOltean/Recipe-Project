package org.example;

public class User {

    private long ID;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private double height;
    private double weight;
    private double activityFactor;

    public User (long ID, String firstName, String lastName, Gender gender, int age, double height, double weight, double activityFactor) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.activityFactor = activityFactor;
    }

    public User(){

    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName( String firstName){
        this.firstName = firstName;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getActivityFactor() {
        return activityFactor;
    }

    public void setActivityFactor(double activityFactor) {
        this.activityFactor = activityFactor;
    }


}
