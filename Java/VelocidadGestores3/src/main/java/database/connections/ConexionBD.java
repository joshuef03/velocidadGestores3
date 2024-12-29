package database.connections;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConexionBD {
    Connection getConexion() throws SQLException, ClassNotFoundException;
    void desconectar() throws SQLException;
}
