package com.moshkova.elena.files.read_and_writer_file.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManadger {

    private static final String url = "jdbc:postgresql://localhost:5432/Shop_on_the_sofa";
    private static final  String usename = "postgres";
    private static final String password = "Jz2SYU5x4d";
;

    public static Connection getConnection () throws SQLException {
        return DriverManager.getConnection( url, usename, password);
    }
}
