/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MCROBERTW
 */
public class ConexionMySqlserver extends ConexionBase {
    private static ConexionMySqlserver instance;
    private Connection conexionBD;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

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

    public static ConexionMySqlserver getInstance(){
        if (instance == null) {
            instance = new ConexionMySqlserver();
        }
        return instance;
    }

    @Override
    public boolean conectar() {
        try {
            cargarDriver();
            conexionBD = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            JOptionPane.showMessageDialog(null, "¡OK MYSQL!");
            return true; // Indica que la conexión fue exitosa
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el driver: " + e.getMessage());
            return false; // Indica que ocurrió un error al cargar el driver
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
            return false; // Indica que ocurrió un error al conectar a la base de datos
        }
    }

    public Connection getConexion() {
        return conexionBD;
    }
    
    public boolean ejecutar(String sql) { //
        try {
            Statement sentencia; // objetos para sentencias de oracle 
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); // crea l0s parametros de embio y r
            sentencia.executeUpdate(sql); //ejecuta el insert delete y el updte
            getConexion().setAutoCommit(false);
            getConexion().commit();
            //sentencia.close();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }        return true;
    }

}
