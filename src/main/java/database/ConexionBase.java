package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
    /*public void desconectar() {
        try {
            if (conexionBD != null && !conexionBD.isClosed()) {
                conexionBD.close();
                JOptionPane.showMessageDialog(null, "Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
        }
    }*/
}
