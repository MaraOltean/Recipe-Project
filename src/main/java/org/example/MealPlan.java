package org.example;

public class MealPlan {
    private long id;
    private String type;
    private String breakfastHour;
    private double breakfastQuantity;
    private double breakfastProteins;
    private double breakfastCarbohydrates;
    private double breakfastLipid;
    private String lunchHour;
    private double lunchQuantity;
    private double lunchProteins;
    private double lunchCarbohydrates;
    private double lunchLipid;
    private String dinnerHour;
    private double dinnerQuantity;
    private double dinnerProteins;
    private double dinnerCarbohydrates;
    private double dinnerLipid;
    private double totalKcal;

    public MealPlan(long id, String type, String breakfastHour, double breakfastQuantity, double breakfastProteins, double breakfastCarbohydrates, double breakfastLipid,
                    String lunchHour, double lunchQuantity, double lunchProteins, double lunchCarbohydrates, double lunchLipid, String dinnerHour, double dinnerQuantity,
                    double dinnerProteins, double dinnerCarbohydrates, double dinnerLipid, double totalKcal) {
        this.id = id;
        this.type = type;
        this.breakfastHour = breakfastHour;
        this.breakfastQuantity = breakfastQuantity;
        this.breakfastProteins = breakfastProteins;
        this.breakfastCarbohydrates = breakfastCarbohydrates;
        this.breakfastLipid = breakfastLipid;
        this.lunchHour = lunchHour;
        this.lunchQuantity = lunchQuantity;
        this.lunchProteins = lunchProteins;
        this.lunchCarbohydrates = lunchCarbohydrates;
        this.lunchLipid = lunchLipid;
        this.dinnerHour = dinnerHour;
        this.dinnerQuantity = dinnerQuantity;
        this.dinnerProteins = dinnerProteins;
        this.dinnerCarbohydrates = dinnerCarbohydrates;
        this.dinnerLipid = dinnerLipid;
        this.totalKcal = totalKcal;
    }
    public MealPlan(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreakfastHour() {
        return breakfastHour;
    }

    public void setBreakfastHour(String breakfastHour) {
        this.breakfastHour = breakfastHour;
    }

    public double getBreakfastQuantity() {
        return breakfastQuantity;
    }

    public void setBreakfastQuantity(double breakfastQuantity) {
        this.breakfastQuantity = breakfastQuantity;
    }

    public double getBreakfastProteins() {
        return breakfastProteins;
    }

    public void setBreakfastProteins(double breakfastProteins) {
        this.breakfastProteins = breakfastProteins;
    }

    public double getBreakfastCarbohydrates() {
        return breakfastCarbohydrates;
    }

    public void setBreakfastCarbohydrates(double breakfastCarbohydrates) {
        this.breakfastCarbohydrates = breakfastCarbohydrates;
    }

    public double getBreakfastLipid() {
        return breakfastLipid;
    }

    public void setBreakfastLipid(double breakfastLipid) {
        this.breakfastLipid = breakfastLipid;
    }

    public String getLunchHour() {
        return lunchHour;
    }

    public void setLunchHour(String lunchHour) {
        this.lunchHour = lunchHour;
    }

    public double getLunchQuantity() {
        return lunchQuantity;
    }

    public void setLunchQuantity(double lunchQuantity) {
        this.lunchQuantity = lunchQuantity;
    }

    public double getLunchProteins() {
        return lunchProteins;
    }

    public void setLunchProteins(double lunchProteins) {
        this.lunchProteins = lunchProteins;
    }

    public double getLunchCarbohydrates() {
        return lunchCarbohydrates;
    }

    public void setLunchCarbohydrates(double lunchCarbohydrates) {
        this.lunchCarbohydrates = lunchCarbohydrates;
    }

    public double getLunchLipid() {
        return lunchLipid;
    }

    public void setLunchLipid(double lunchLipid) {
        this.lunchLipid = lunchLipid;
    }

    public String getDinnerHour() {
        return dinnerHour;
    }

    public void setDinnerHour(String dinnerHour) {
        this.dinnerHour = dinnerHour;
    }

    public double getDinnerQuantity() {
        return dinnerQuantity;
    }

    public void setDinnerQuantity(double dinnerQuantity) {
        this.dinnerQuantity = dinnerQuantity;
    }

    public double getDinnerProteins() {
        return dinnerProteins;
    }

    public void setDinnerProteins(double dinnerProteins) {
        this.dinnerProteins = dinnerProteins;
    }

    public double getDinnerCarbohydrates() {
        return dinnerCarbohydrates;
    }

    public void setDinnerCarbohydrates(double dinnerCarbohydrates) {
        this.dinnerCarbohydrates = dinnerCarbohydrates;
    }

    public double getDinnerLipid() {
        return dinnerLipid;
    }

    public void setDinnerLipid(double dinnerLipid) {
        this.dinnerLipid = dinnerLipid;
    }

    public double getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(double totalKcal) {
        this.totalKcal = totalKcal;
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", breakfastHour='" + breakfastHour + '\'' +
                ", breakfastQuantity=" + breakfastQuantity +
                ", breakfastProteins=" + breakfastProteins +
                ", breakfastCarbohydrates=" + breakfastCarbohydrates +
                ", breakfastLipid=" + breakfastLipid +
                ", lunchHour='" + lunchHour + '\'' +
                ", lunchQuantity=" + lunchQuantity +
                ", lunchProteins=" + lunchProteins +
                ", lunchCarbohydrates=" + lunchCarbohydrates +
                ", lunchLipid=" + lunchLipid +
                ", dinnerHour='" + dinnerHour + '\'' +
                ", dinnerQuantity=" + dinnerQuantity +
                ", dinnerProteins=" + dinnerProteins +
                ", dinnerCarbohydrates=" + dinnerCarbohydrates +
                ", dinnerLipid=" + dinnerLipid +
                ", totalKcal=" + totalKcal +
                '}';
    }
}
