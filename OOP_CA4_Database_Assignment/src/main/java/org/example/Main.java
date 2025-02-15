package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
    public void start() {

        String url = "jdbc:mysql://localhost:3306/oop_ca4_database_assignment";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password))
        {
            System.out.println("Successfully connected to database");
        }
        catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
    }

    class Expenses{

        private int expenseId;
        private String title;
        private String category;
        private double amount;
        private Date daiteIncurred;

        public Expenses(int expenseId, String title, String category, double amount, Date daiteIncurred) {
            this.expenseId = expenseId;
            this.title = title;
            this.category = category;
            this.amount = amount;
            this.daiteIncurred = daiteIncurred;
        }

        public int getExpenseId() {
            return expenseId;
        }
        public void setExpenseId(int expenseId) {
            this.expenseId = expenseId;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }
        public double getAmount() {
            return amount;
        }
        public void setAmount(double amount) {
            this.amount = amount;
        }
        public Date getDaiteIncurred() {
            return daiteIncurred;
        }
        public void setDaiteIncurred(Date daiteIncurred) {
            this.daiteIncurred = daiteIncurred;
        }
    }

    class Income{
        private int incomeId;
        private String title;
        private double amount;
        private Date dateEarned;

        public Income(int incomeId, String title, double amount, Date dateEarned) {
            this.incomeId = incomeId;
            this.title = title;
            this.amount = amount;
            this.dateEarned = dateEarned;
        }

        public int getIncomeId() {
            return incomeId;
        }
        public void setIncomeId(int incomeId) {
            this.incomeId = incomeId;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public double getAmount() {
            return amount;
        }
        public void setAmount(double amount) {
            this.amount = amount;
        }
        public Date getDateEarned() {
            return dateEarned;
        }
        public void setDateEarned(Date dateEarned) {
            this.dateEarned = dateEarned;
        }
    }
}