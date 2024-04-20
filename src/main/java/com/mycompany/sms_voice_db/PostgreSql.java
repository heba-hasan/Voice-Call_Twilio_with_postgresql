/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sms_voice_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 20121
 */
public class PostgreSql {

    Connection ConneectToPostgresql() throws SQLException {
        String jdcURL = "jdbc:postgresql://localhost:5432/twilio";
        String username = "postgres";
        String password = "root";

        Connection connection = DriverManager.getConnection(jdcURL, username, password);

        return connection;
    }

    String[] SelectfromPostgresql() throws SQLException {
        String[] info = new String[3];

        String sql = "SELECT * FROM credentials";
        Statement statement = ConneectToPostgresql().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String auth_token = resultSet.getString("auth_token");
            String auth_sid = resultSet.getString("auth_sid");
            String twilio_number = resultSet.getString("twilio_number");
            info[0] = auth_token;
            info[1] = auth_sid;
            info[2] = twilio_number;
            System.out.println(auth_token);
            System.out.println(auth_sid);
            System.out.println(twilio_number);
        }
        ConneectToPostgresql().close();
        return info;
    }
    void insertToDB(String msg_id, String sender_number, String receiver_number, String msg_body, String msg_time, String msg_status) throws SQLException {
        String sql = "INSERT INTO msg_details (msg_id, sender_number, reciever_number, msg_body, msg_time, msg_status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConneectToPostgresql(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, msg_id);
            preparedStatement.setString(2, sender_number);
            preparedStatement.setString(3, receiver_number);
            preparedStatement.setString(4, msg_body);
            preparedStatement.setString(5, msg_time);
            preparedStatement.setString(6, msg_status);

            int DataAffected = preparedStatement.executeUpdate();

            if (DataAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
