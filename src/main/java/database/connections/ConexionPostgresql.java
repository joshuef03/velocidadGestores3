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
public class ConexionPostgresql extends ConexionBase implements ConexionBD {

    private static final String DEFAULT_URL = "jdbc:postgresql://localhost:5432/BDPRODUCTO";
    private static final String DEFAULT_USER = "postgres";
    private static final String DEFAULT_PASSWORD = "PSG123";

    private ConexionPostgresql(){
        dbUrl = DEFAULT_URL;
        dbUser = DEFAULT_USER;
        dbPassword = DEFAULT_PASSWORD;
    }

    @Override
    protected void cargarDriver() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }

    @Override
    protected Connection crearConexion() throws SQLException {
        String URI_PSGSQL = dbUrl + "?autoReconnect=true&relaxAutoCommit=true";
        return DriverManager.getConnection(URI_PSGSQL, dbUser, dbPassword);
    }

    @Override
    protected void mostrarMensajeConexion() {
        JOptionPane.showMessageDialog(null, "Conectado a PostgreSQL exitosamente.", "Conexión Exitosa", JOptionPane.INFORMATION_MESSAGE);
    }

    private static final class ConexionPostgreSqlHolder {
        private static final ConexionPostgresql instance = new ConexionPostgresql();
    }

    public static ConexionPostgresql getInstance(){
        return ConexionPostgreSqlHolder.instance;
    }


}
    /*public static ConexionPostgresql getInstance(){
        if (instance == null){
            instance = new ConexionPostgresql();
        }
        return instance;
    }

    @Override
    public boolean conectar() {
        try {
            cargarDriver();

            JOptionPane.showMessageDialog(null, "¡OK POSTGRESQL!");
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
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
            sentencia.executeUpdate(sql); //ejecuta el insert delete y el updte 
            
            getConexion().commit();
            
            
            
            //sentencia.getConnection().setAutoCommit(false);
        
        } catch (SQLException e) {
            if (e.getErrorCode()==0) return false; //Por error "Cannot commit when autocommit is enabled"
            JOptionPane.showMessageDialog(null, e.getErrorCode());
            return false;
        }        return true;
    }*/
