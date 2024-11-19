package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public abstract class ConexionBase {

    protected String dbUrl;
    protected String dbUser;
    protected String dbPassword;
    protected Connection conexionBD;

    // Constructor por defecto
    public ConexionBase() {}

    // Constructor con parámetros
    public ConexionBase(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    // Método abstracto que deben implementar las subclases para cargar el driver
    protected abstract void cargarDriver() throws ClassNotFoundException;

    public abstract boolean conectar();

    // Método para conectar a la base de datos
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
    }*/

    // Método para desconectar de la base de datos
    public void desconectar() {
        try {
            if (conexionBD != null && !conexionBD.isClosed()) {
                conexionBD.close();
                JOptionPane.showMessageDialog(null, "Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
        }
    }

    // Método para actualizar las credenciales dinámicamente
    public void actualizarCredenciales(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        JOptionPane.showMessageDialog(null, "Credenciales actualizadas.");
    }

    // Getters y Setters
    public String getDbUrl() {
        return dbUrl;
    }

    public String getUser() {
        return dbUser;
    }

    public String getPassword() {
        return dbPassword;
    }

}
