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
public class ConexionOracle extends ConexionBase {

    private static final String DEFAULT_URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    private static final String DEFAULT_USER = "C##UDB";
    private static final String DEFAULT_PASSWORD = "1234567";

    // Constructor privado para Singleton
    private ConexionOracle() {
        this.dbUrl = DEFAULT_URL;
        this.dbUser = DEFAULT_USER;
        this.dbPassword = DEFAULT_PASSWORD;
    }

    // Implementación de cargar el driver específico
    @Override
    protected void cargarDriver() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.OracleDriver");
    }

    // Implementación de crear la conexión específica
    @Override
    protected Connection crearConexion() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    @Override
    protected void mostrarMensajeConexion() {
        JOptionPane.showMessageDialog(null, "Conectado a Oracle exitosamente.", "Conexión Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    private static final class ConexionOracleHolder {
        private static final ConexionOracle instance = new ConexionOracle();
    }

    // Retorna la instancia singleton
    public static ConexionOracle getInstance() {
        return ConexionOracleHolder.instance;
    }
}