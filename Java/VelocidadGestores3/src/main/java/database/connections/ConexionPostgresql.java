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