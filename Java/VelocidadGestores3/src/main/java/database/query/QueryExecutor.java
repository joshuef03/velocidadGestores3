package database.query;

import database.connections.ConexionBD;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecutor {
    private ConexionBD conexionBD;

    public QueryExecutor(ConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }

    public void ejecutarSql(String sql){
        try (Statement stmt = conexionBD.getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public CallableStatement procedureCall(String sql){
        try {
            return conexionBD.getConexion().prepareCall(sql);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
