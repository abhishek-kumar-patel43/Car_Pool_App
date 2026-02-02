package com.carpool;

public class TestDB {
    public static void main(String[] args) {
        try {
            System.out.println(DBConnection.getConnection());
            System.out.println("Connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
