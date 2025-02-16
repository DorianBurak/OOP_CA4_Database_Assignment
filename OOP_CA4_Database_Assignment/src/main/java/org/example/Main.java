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

            System.out.println("Expenses:");
            printExpenses(conn);

            System.out.println("Income:");
            printIncome(conn);

            System.out.println("Disconnected from database");
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

    private void printExpenses(Connection conn) throws SQLException {
        String selectAll = "SELECT * FROM expenses";
        String addExpense = "INSERT INTO oop_ca4_database_assignment.expenses Values (null,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(addExpense)) {
//            pstmt.setString(1, "Leap Card");
//            pstmt.setString(2, "Travel");
//            pstmt.setDouble(3, 12.50);
//            pstmt.setDate(4, new Date(2025-01-24));
//            pstmt.executeUpdate();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(selectAll);
            while (rs.next()) {
                int expenseId = rs.getInt("expenseId");
                String title = rs.getString("title");
                String category = rs.getString("category");
                double amount = rs.getDouble("amount");
                Date dateIncurred = rs.getDate("dateIncurred");

                System.out.printf("ID: %d | Title: %s | Category: %s | Amount: €%.2f | Date: %s\n", expenseId, title, category, amount, dateIncurred);
            }
        }
    }

    private void printIncome(Connection conn) throws SQLException {
        String selectAll = "SELECT * FROM income";
        String addIncome = "INSERT INTO oop_ca4_database_assignment.income Values (null,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(addIncome)) {
//            pstmt.setString(1, "Money Found");
//            pstmt.setDouble(2, 10);
//            pstmt.setDate(3, new Date(2025-01-11));
//            pstmt.executeUpdate();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(selectAll);
            while (rs.next()) {
                int incomeId = rs.getInt("incomeId");
                String title = rs.getString("title");
                double amount = rs.getDouble("amount");
                Date dateEarned = rs.getDate("dateEarned");

                System.out.printf("ID: %d | Title: %s | Amount: €%.2f | Date: %s\n", incomeId, title, amount, amount, dateEarned);
            }
        }
    }
}