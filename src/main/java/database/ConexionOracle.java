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
public class ConexionOracle {
    private Connection conexionBD;
    public Connection getConexion() {
        return conexionBD;
    }       
    public void setConexion(Connection conexionBD) {
        this.conexionBD = conexionBD;
    }
    public ConexionOracle conectar() {
        try {
          Class.forName("oracle.jdbc.OracleDriver");// carga el driver y oracle 

         String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521/xepdb1"; //crea una variable con la direccion el puerto y la instancia (express)
         String Usuario = "C##UDB";
         String Password = "1234567";
         //String BaseDeDatos = "jdbc:oracle:thin:@192.168.5.6:1521:XE"; //crea una variable con la direccion el puerto y la instancia (express)
         conexionBD = DriverManager.getConnection(BaseDeDatos, Usuario, Password);  // carga la conexion (usuario contraseña)

         if (conexionBD != null) {
             JOptionPane.showMessageDialog(null, "¡OK oracle!");
             
         } else {
             JOptionPane.showMessageDialog(null, "Error en la Conexión..");
         }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage()+"Error en la Conexión..");
        }
        return this;
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
