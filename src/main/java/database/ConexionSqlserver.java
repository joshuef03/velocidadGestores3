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
public class ConexionSqlserver extends ConexionBase {
    private static ConexionSqlserver instance;
    private Connection conexionBD;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

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

    public static ConexionSqlserver getInstance(){
        if (instance == null) {
            instance = new ConexionSqlserver();
        }
        return instance;
    }

    @Override
    public boolean conectar() {
        try {
            cargarDriver();
            String URI_MSSQLS = dbUrl + ";user=" + dbUser + ";password=" + dbPassword + ";encrypt=false";
            conexionBD = DriverManager.getConnection(URI_MSSQLS);
            JOptionPane.showMessageDialog(null, "¡OK SQLSERVER!");
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
            getConexion().commit();
            //sentencia.close();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }        return true;
    }
}
