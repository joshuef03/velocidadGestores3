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
public class ConexionMySqlserver {
    private Connection conexionBD;
    public Connection getConexion() {
        return conexionBD;
    }       
    public void setConexion(Connection conexionBD) {
        this.conexionBD = conexionBD;
    }
    public ConexionMySqlserver conectar() {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");// carga el driver y oracle 

//          String BaseDeDatos = "jdbc:sqlserver://DESKTOP-FLG8F71\\PRUEBA:1433;databaseName=BDPRODUCTO;integratedSecurity=true;user=sa;password=admin123;"; //
          //tring BaseDeDatos = "jdbc:mysql://localhost:3308/dbproducto"; //
          String BaseDeDatos = "jdbc:mysql://localhost:3306/BDPRODUCTO"; //
          String user = "root";
          String password = "MQL123";
         conexionBD = DriverManager.getConnection(BaseDeDatos, user, password);  // carga la conexion (usuario contraseña)

         if (conexionBD != null) {
             JOptionPane.showMessageDialog(null, "¡OK MySQL Server!");
         } else {
             JOptionPane.showMessageDialog(null, "Error en la Conexión..");
         }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage()+" Error en la Conexión..");
        }
        return this;
    }
    
    public boolean ejecutar(String sql) { //
        try {
            Statement sentencia; // objetos para sentencias de oracle 
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); // crea l0s parametros de embio y r
            sentencia.executeUpdate(sql); //ejecuta el insert delete y el updte
            getConexion().setAutoCommit(false);
            getConexion().commit();
            //sentencia.close();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }        return true;
    }

}
