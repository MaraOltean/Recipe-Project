package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.ConnectDataBase.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        connect();
    }

    public static double calculateBMI(User user) {
        double BMI = user.getWeight() / (user.getHeight() * user.getHeight());
        return BMI;
    }

    public static void caloriesNeeded(User user) {
        double BMR = 0;
        if (user.getGender().equals(Gender.M)) {
            BMR = 88.362 + (13.397 * user.getWeight()) + (4.799 * user.getHeight() * 100) - (5.677 * user.getAge());
        } else {
            BMR = 447.593 + (9.247 * user.getWeight()) + (3.098 * user.getHeight() * 100) - (4.330 * user.getAge());
        }
        user.setNecessaryCalories(BMR* user.getActivityFactor());
        System.out.println(user.getNecessaryCalories());
    }

    public static void diseaseSelection(User user) {
        System.out.println("Choose a disease: ");
        System.out.println("1.Diabetes; 2.Hypothyroidism; 3.Hyperthyroidism; 4.Atherosclerosis; 5.Hypertension");
        Scanner scanner = new Scanner(System.in);
        int diseaseNumber = scanner.nextInt();
        switch (diseaseNumber) {
            case 1:
                user.setDiseaseName("Diabetes");
                break;
            case 2:
                user.setDiseaseName("Hypothyroidism");
                break;
            case 3:
                user.setDiseaseName("Hyperthyroidism");
                break;
            case 4:
                user.setDiseaseName("Atherosclerosis");
                break;
            case 5:
                user.setDiseaseName("Hypertension");
                break;
            default:
                System.out.println("Healthy User");
        }
    }

    public static void menu(Connection conn) throws SQLException {
        System.out.println("1.Adaugati un nou utilizator -> intrebari despre utilizator -> recomandare plan alimentar\n" +
                "2.Stergeti un utilizator din baza de date\n" +
                "3.Afisati toti utilizatorii\n" +
                "4.Afisati planul alimentar recomandat pentru utilizatorul respectiv + afisati toti utilizatorii si fiecare plan alimentar?\n" +
                "5.Afisati toti utilizatorii care au un plan alimentar < 2000 kcal\n" +
                "6.Afisati toti utilizatorii care au un plan alimentar intre 2000 si 3000 kcal\n" +
                "7.Afisati toti utilizatorii care au un plan alimentar > 3000 kcal\n" +
                "8.Afisati toti utilizatorii care sunt bolnavi\n" +
                "9.Afisati toti utilizatorii care au un plan alimentar pe baza unei boli\n" +
                "9.Adaugati un nou plan alimentar\n" +
                "10.Stergeti un plan alimentar\n" +
                "11.Afisati toate planurile alimentare\n" +
                "12.Afisati toate planuriile alimentare < 2000 kcal\n" +
                "13.Afisati toate planuriile alimentare intre 2000 si 3000 kcal\n" +
                "14.Afisati toate planuriile alimentare > 3000 kcal\n" +
                "15.Afisati toate planuriile alimentare pentru boli");

        Scanner scanner = new Scanner(System.in);
        int selectionNumber = scanner.nextInt();

        switch (selectionNumber) {
            case 1:
                userMenu(conn);
                // case 2: deleteData(conn, "user", 2);
                // case 3: displayDatabase(conn, "user");
        }

    }

    public static void userMenu(Connection connection) throws SQLException {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        int idNumber = scanner.nextInt();
        user.setID(idNumber);

        scanner.nextLine();

        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();
        user.setFirstName(firstName);

        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();
        user.setLastName(lastName);

        System.out.println("Enter Height (in meters, format 1.7):");
        double height = scanner.nextDouble();
        user.setHeight(height);

        System.out.println("Enter Weight:");
        double weight = scanner.nextDouble();
        user.setWeight(weight);

        System.out.println("Select Gender (1 for Male / 2 for Female):");
        int gender = scanner.nextInt();
        if (gender == 1) {
            user.setGender(Gender.M);
        } else if (gender == 2) {
            user.setGender(Gender.F);
        } else {
            System.out.println("Invalid input. Assuming gender as Female.");
            user.setGender(Gender.F);
        }

        System.out.println("Enter Age:");
        int age = scanner.nextInt();
        user.setAge(age);

        System.out.println("Select Activity Factor: (1 - Sedentary; 2 - Moderate; 3 - Active)");
        int activitySelection = scanner.nextInt();
        double activityFactor;
        switch (activitySelection) {
            case 1:
                activityFactor = 1.3;
                break;
            case 2:
                activityFactor = 1.5;
                break;
            case 3:
                activityFactor = 1.8;
                break;
            default:
                System.out.println("Invalid input. Assuming activity factor as 1.3 (Sedentary).");
                activityFactor = 1.3;
                break;
        }
        user.setActivityFactor(activityFactor);

        diseaseSelection(user);

        System.out.println("BMI:");
        double BMI = calculateBMI(user);
        user.setBmi(BMI);
        System.out.println(user.getBmi());

        caloriesNeeded(user);


        searchByDisease(connection, user);
        if(user.getDiseaseName() == null){
            recommendMealPlan(connection,user);
        }

        insertData(connection, "user", user);
    }

    public static void searchByDisease(Connection connection, User user) throws SQLException {
        List<Integer> list = new ArrayList<>();
        String selectquerys = "SELECT id FROM mealPlan WHERE type = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectquerys);
        preparedStatement.setString(1, user.getDiseaseName());
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            list.add(id);

        }
        user.setMealPlanIDs(list);
    }

    public static void recommendMealPlan(Connection connection, User user) throws SQLException{
         double userkcal = user.getNecessaryCalories();
        String selectquery = "SELECT id,totalKcal FROM mealPlan where totalKcal BETWEEN ? AND ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectquery);
        preparedStatement.setDouble(1, userkcal-100);
        preparedStatement.setDouble(2, userkcal+100);
        ResultSet rs = preparedStatement.executeQuery();
        List<Integer> list = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("id");
            list.add(id);
        }
        user.setMealPlanIDs(list);
    }
}
