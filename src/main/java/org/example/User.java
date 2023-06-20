package org.example;

import java.util.List;

public class User {

    private long ID;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private double height;
    private double weight;
    private double activityFactor;
    private String diseaseName;

    private double bmi;
    private double necessaryCalories;
    private List<Integer> mealPlanIDs;


    public User (long ID, String firstName, String lastName, Gender gender, int age, double height, double weight, double activityFactor,String diseaseName,
                 double bmi, double necessaryCalories, List<Integer> mealPlanIDs) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.activityFactor = activityFactor;
        this.diseaseName = diseaseName;
        this.bmi = bmi;
        this.necessaryCalories = necessaryCalories;
        this.mealPlanIDs = mealPlanIDs;

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
    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getNecessaryCalories() {
        return necessaryCalories;
    }

    public void setNecessaryCalories(double necessaryCalories) {
        this.necessaryCalories = necessaryCalories;
    }

    public List<Integer> getMealPlanIDs() {
        return mealPlanIDs;
    }

    public void setMealPlanIDs(List<Integer> mealPlanIDs) {
        this.mealPlanIDs = mealPlanIDs;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", activityFactor=" + activityFactor +
                ", diseaseName='" + diseaseName + '\'' +
                ", bmi=" + bmi +
                ", necessaryCalories=" + necessaryCalories +
                ", mealPlanIDs=" + mealPlanIDs +
                '}';
    }
}
