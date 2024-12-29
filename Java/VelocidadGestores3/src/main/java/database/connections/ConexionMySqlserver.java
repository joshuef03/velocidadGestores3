/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.connections;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MCROBERTW
 */
public class ConexionMySqlserver extends ConexionBase {

    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/BDPRODUCTO";
    private static final String DEFAULT_USER = "root";
    private static final String DEFAULT_PASSWORD = "MQL123";

    private ConexionMySqlserver(){
        dbUrl = DEFAULT_URL;
        dbUser = DEFAULT_USER;
        dbPassword = DEFAULT_PASSWORD;
    }

    @Override
    protected void cargarDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Override
    protected Connection crearConexion() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    @Override
    protected void mostrarMensajeConexion() {
        JOptionPane.showMessageDialog(null, "Conectado a MySQL exitosamente.", "Conexión Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    private static final class ConexionMySqlServerHolder {
        private static final ConexionMySqlserver instance = new ConexionMySqlserver();
    }

    public static ConexionMySqlserver getInstance() {
        return ConexionMySqlServerHolder.instance;
    }

}