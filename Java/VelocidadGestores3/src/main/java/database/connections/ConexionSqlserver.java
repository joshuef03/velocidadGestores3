/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.connections;

import javax.swing.*;
import java.sql.*;

/**
 *
 * @author MCROBERTW
 */
public class ConexionSqlserver extends ConexionBase {

    private static final String DEFAULT_URL = "jdbc:sqlserver://localhost:1433;databaseName=BDPRODUCTO";
    private static final String DEFAULT_USER = "sa";
    private static final String DEFAULT_PASSWORD = "MS3123";

    private ConexionSqlserver(){
        dbUrl = DEFAULT_URL;
        dbUser = DEFAULT_USER;
        dbPassword = DEFAULT_PASSWORD;
    }

    @Override
    protected void cargarDriver() throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    @Override
    protected Connection crearConexion() throws SQLException {
        String URI_MSSQLS = dbUrl + ";user=" + dbUser + ";password=" + dbPassword + ";encrypt=false";
        return DriverManager.getConnection(URI_MSSQLS);
    }

    @Override
    protected void mostrarMensajeConexion() {
        JOptionPane.showMessageDialog(null, "Conectado a SQL Server exitosamente.", "Conexión Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    private static final class ConexionSqlServerHolder{
        private static final ConexionSqlserver instance = new ConexionSqlserver();
    }

    public static ConexionSqlserver getInstance(){
        return ConexionSqlServerHolder.instance;
    }
}