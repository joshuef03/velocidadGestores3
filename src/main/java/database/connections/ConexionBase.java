package database.connections;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConexionBase implements ConexionBD {
    @Setter @Getter
    protected String dbUrl;
    @Setter @Getter
    protected String dbUser;
    @Setter @Getter
    protected String dbPassword;

    protected Connection conexionBD;

    // Método abstracto para que las subclases implementen su propio driver
    protected abstract void cargarDriver() throws ClassNotFoundException;

    // Método abstracto para que cada subclase cree su conexión
    protected abstract Connection crearConexion() throws SQLException;

    // Conexión general, reutilizable en todas las subclases
    public void conectar() {
        try {
            getConexion();
            mostrarMensajeConexion();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método abstracto para mostrar un mensaje personalizado en cada subclase
    protected abstract void mostrarMensajeConexion();

    // Actualiza credenciales y reconecta
    public void actualizarCredenciales(String dbUrl, String dbUser, String dbPassword) {
        try {
            desconectar();
            this.dbUrl = dbUrl;
            this.dbUser = dbUser;
            this.dbPassword = dbPassword;
            conectar();
        } catch (SQLException e) {
            System.err.println("Error al actualizar credenciales: " + e.getMessage());
            this.dbUrl = null;
            this.dbUser = null;
            this.dbPassword = null;
        }
    }

    // Desconecta la conexión
    public void desconectar() throws SQLException {
        if (conexionBD != null && !conexionBD.isClosed()) {
            conexionBD.close();
            conexionBD = null;
        }
    }

    // Obtiene la conexión, la crea si es necesario
    public Connection getConexion() throws SQLException {
        if (conexionBD != null && !conexionBD.isClosed()) {
            return conexionBD;
        }

        try {
            cargarDriver();
            conexionBD = crearConexion();
            return conexionBD;
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al cargar el driver de la base de datos.", e);
        }
    }
}


/*
public abstract class ConexionBase {

    protected Connection conexionBD;

    // Método abstracto que deben implementar las subclases para cargar el driver
    protected abstract void cargarDriver() throws ClassNotFoundException;

    public boolean conectar() throws SQLException, ClassNotFoundException {
        if (conexionBD != null && !conexionBD.isClosed()) {
            return true;
        }
        cargarDriver();
        conexionBD = crearConexion();
        return true;
    }

    public abstract Connection crearConexion() throws SQLException;

    public void desconectar() throws SQLException {
        if (conexionBD != null && !conexionBD.isClosed()) {
            conexionBD.close();
        }
    }

    // Método para conectar a la base de datos
    */
/*public void conectar() {
        try {
            cargarDriver(); // Carga el driver específico de la base de datos
            conexionBD = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            JOptionPane.showMessageDialog(null, "¡Conexión exitosa a la base de datos!");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
        }
    }*//*


    // Método para desconectar de la base de datos
    */
/*public void desconectar() {
        try {
            if (conexionBD != null && !conexionBD.isClosed()) {
                conexionBD.close();
                JOptionPane.showMessageDialog(null, "Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
        }
    }*//*

}
*/
