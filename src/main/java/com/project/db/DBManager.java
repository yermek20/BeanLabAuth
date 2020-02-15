package com.project.db;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
@Scope("singleton")
public class DBManager {

    private Connection connection;

    public DBManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://remotemysql.com:3306/UOiKi1ZtNw?useUnicode=true&serverTimezone=UTC", "UOiKi1ZtNw", "MHBziq1AQH");
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    public Users getUserByLoginAndPassword(String login, String password){
        Users user = null;

        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM users WHERE login = ?, password = ? ");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new Users(resultSet.getLong(0),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString(null),
                        resultSet.getInt(0)
                );
            }

            statement.close();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return user;
    }

    public Users getUser(Long id) {
        Users user = null;

        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM books WHERE id = ? ");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new Users(resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("user_full_name"),
                        resultSet.getInt("age")
                );
            }

            statement.close();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return user;
    }

//    public boolean addBooks(Books book) {
//        boolean result = false;
//
//        try {
//            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO books (name, author, price) VALUES (?, ?, ?)");
//            statement.setString(1, book.getName());
//            statement.setString(2, book.getAuthor());
//            statement.setInt(3, book.getPrice());
//            result = statement.executeUpdate() > 0;
//            statement.close();
//        } catch (Exception var4) {
//            var4.printStackTrace();
//        }
//
//        return result;
//    }
//
//    public ArrayList<Books> getAllBooks() {
//        ArrayList books = new ArrayList();
//
//        try {
//            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM books");
//            ResultSet resultSet = statement.executeQuery();
//
//            while(resultSet.next()) {
//                books.add(new Books(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("author"), resultSet.getInt("price")));
//            }
//
//            statement.close();
//        } catch (Exception var4) {
//            var4.printStackTrace();
//        }
//
//        return books;
//    }
}
