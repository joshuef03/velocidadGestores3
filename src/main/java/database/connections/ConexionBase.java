package database.connections;

import lombok.Getter;
import lombok.Setter;

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

    public void actualizarCredenciales(String dbUrl, String dbUser, String dbPassword){
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    protected Connection conexionBD;

    // Carga el controlador específico de la base de datos
    protected abstract void cargarDriver() throws ClassNotFoundException;

    // Crea una conexión con la base de datos específica
    protected abstract Connection crearConexion() throws SQLException;

    // Conexión general, reutilizable en todas las subclases
    public void conectar(String dbName) {
        try {
            getConexion();
            JOptionPane.showMessageDialog(null, dbName+". OK!");
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, dbName+" Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Desconecta la conexión
    public void desconectar() throws SQLException {
        if (conexionBD != null && !conexionBD.isClosed()) {
            conexionBD.close();
        }
    }

    // Retorna la conexión activa
    public Connection getConexion() {
        try {
            if (conexionBD != null && !conexionBD.isClosed()){
                return conexionBD;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error De Estado.", e);
        }
        try {
            cargarDriver();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error cargando el Controlador", e);
        }
        try {
            return conexionBD = crearConexion();
        } catch (SQLException e) {
            throw new RuntimeException("Error de Conexion." ,e);
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
