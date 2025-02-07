/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.connections;

import java.sql.*;

/**
 *
 * @author MCROBERTW
 */
public class ConexionOracle extends ConexionBase {

    private static final String DEFAULT_URL = "jdbc:oracle:thin:@localhost/xepdb1";
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

    private static final class ConexionOracleHolder {
        private static final ConexionOracle instance = new ConexionOracle();
    }

    // Retorna la instancia singleton
    public static ConexionOracle getInstance() {
        return ConexionOracleHolder.instance;
    }
}


/*
public class ConexionOracle extends ConexionBase{
    private static ConexionOracle instance;
    private Connection conexionBD;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    private static final String DEFAULT_URL = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    private static final String DEFAULT_USER = "C##UDB";
    private static final String DEFAULT_PASSWORD = "1234567";

    private ConexionOracle() {
        dbUrl = DEFAULT_URL;
        dbUser = DEFAULT_USER;
        dbPassword = DEFAULT_PASSWORD;
    }

    @Override
    protected void cargarDriver() throws ClassNotFoundException {
        Class.forName("oracle.jdbc.OracleDriver");
    }

    public static ConexionOracle getInstance(){
        if (instance == null) {
            instance = new ConexionOracle();
        }
        return instance;
    }

    @Override
    public Connection crearConexion() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    */
/*@Override
    public boolean conectar() {
        try {
            cargarDriver(); // Carga el driver específico de la base de datos
            conexionBD = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            JOptionPane.showMessageDialog(null, "¡OK ORACLE!");
            return true; // Indica que la conexión fue exitosa
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el driver: " + e.getMessage());
            return false; // Indica que ocurrió un error al cargar el driver
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
            return false; // Indica que ocurrió un error al conectar a la base de datos
        }
    }*//*


    public Connection getConexion() {
        return conexionBD;
    }

    public boolean ejecutar(String sql) {
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.execute(sql); // Usa execute en lugar de executeUpdate
            sentencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ejecutando SQL: " + sql + "\n" + e.getMessage());
            return false;
        }
        return true;
    }


    
}
*/
