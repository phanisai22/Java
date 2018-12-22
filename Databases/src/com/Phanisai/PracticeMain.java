package com.Phanisai;

import java.sql.*;

public class PracticeMain {

    private static final String DB_NAME = "testjava.db";
    private static final String CONNECTION = "jdbc:sqlite:/home/user/Desktop/programs" +
            "/javaPrograms/Databases/" + DB_NAME;

    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ONE = "name";
    private static final String COLUMN_TWO = "phone";
    private static final String COLUMN_THREE = "email";

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(CONNECTION);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_NAME);
            statement.execute("create table if not exists " + TABLE_NAME +
                    " (" + COLUMN_ONE + " text," +
                    COLUMN_TWO + " integer, " +
                    COLUMN_THREE + " text)");

            insertContact(statement, "phani sai", 12345, "psquare@gmail.com");
            insertContact(statement, "sree hari", 98745, "sreehari@gmail.com");
            insertContact(statement, "sivaranjani", 54685, "sivaranjani@gmail.com");

            updateContactNumber(statement, 54654, "sree hari");

            deleteContact(statement, "phani sai");

            ResultSet results = statement.executeQuery("select * from " + TABLE_NAME);
            showTable(results);

            results.close();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("insert into " + TABLE_NAME +
                " (" + COLUMN_ONE + " ," + COLUMN_TWO + " ," + COLUMN_THREE + " ) values" +
                "('" + name + "' ," + phone + " ,'" + email + "' )");
    }

    private static void updateContactNumber(Statement statement, int number, String name) throws SQLException {
        statement.execute("update " + TABLE_NAME + " set " +
                COLUMN_TWO + " = " + number +
                " where " + COLUMN_ONE + "='" + name + "'");
    }

    private static void deleteContact(Statement statement, String name) throws SQLException {
        statement.execute("delete from " + TABLE_NAME +
                " where " + COLUMN_ONE + " ='" + name + "'");
    }

    private static void showTable(ResultSet results) throws SQLException {

        while (results.next()) {
            System.out.println(results.getString(COLUMN_ONE) + " "
                    + results.getInt(COLUMN_TWO) + " "
                    + results.getString(COLUMN_THREE));
        }

    }
}
