/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velocidadgestores;
import database.*;

import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.awt.EventQueue;
import java.util.logging.*;
import java.awt.event.*;


/**
 *
 * @authors MCROBERTW
 * joshuef03
 */
public class VentanaPrincipal extends JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }

    /**
     * Inicializa los componentes de la interfaz gráfica de usuario.
     */
    private void initComponents() {

        // Etiquetas de texto para los campos
        jLabel1 = new JLabel("id:");
        jLabel2 = new JLabel("descripción:");
        jLabel3 = new JLabel("costo:");
        jLabel4 = new JLabel("precio:");
        jLabel5 = new JLabel("Número de Inserciones:");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Campos de texto para entrada de datos
        TXTid = new JTextField("1");
        TXTdescripcion = new JTextField("Computadora");
        TXTcosto = new JTextField("600");
        TXTprecio = new JTextField("1000");
        TXTnumInserciones = new JTextField("4");

        // Campos de texto para mostrar resultados de las operaciones
        TXTresultado_lmd_oracle = new JTextField();
        TXTresultado_sp_oracle = new JTextField();
        TXTresultado_lmd_postgresql = new JTextField();
        TXTresultado_sp_postgresql = new JTextField();
        TXTresultado_lmd_sqlserver = new JTextField();
        TXTresultado_sp_sqlserver = new JTextField();
        TXTresultado_lmd_mysqlserver = new JTextField();
        TXTresultado_sp_mysqlserver = new JTextField();

        // Configurar campos de texto de resultado como no editables
        TXTresultado_lmd_oracle.setEditable(false);
        TXTresultado_sp_oracle.setEditable(false);
        TXTresultado_lmd_postgresql.setEditable(false);
        TXTresultado_sp_postgresql.setEditable(false);
        TXTresultado_lmd_sqlserver.setEditable(false);
        TXTresultado_sp_sqlserver.setEditable(false);
        TXTresultado_lmd_mysqlserver.setEditable(false);
        TXTresultado_sp_mysqlserver.setEditable(false);

        // Botones para conexiones a las bases de datos
        BTNconexionoracle = new JButton("Oracle 21c");
        BTNconexionoracle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNconexionoracleActionPerformed(evt);
            }
        });

        BTNconexionpostgresql = new JButton("PostgreSQL16");
        BTNconexionpostgresql.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNconexionpostgresqlActionPerformed(evt);
            }
        });

        BTNconexionsqlserver = new JButton("SqlServer2022");
        BTNconexionsqlserver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNconexionsqlserverActionPerformed(evt);
            }
        });

        BTNconexionmysqlserver = new JButton("Mysql8");
        BTNconexionmysqlserver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNconexionmysqlserverActionPerformed(evt);
            }
        });

        // Botones para realizar inserciones con Lenguaje de Manipulación de Datos (LMD)
        BTNinsercion_oracle_lmd = new JButton("Inserciones en Oracle con LMD");
        BTNinsercion_oracle_lmd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNinsercion_oracle_lmdActionPerformed(evt);
            }
        });

        BTNinsercion_postgresql_lmd = new JButton("Inserciones en PostgreSQL con LMD");
        BTNinsercion_postgresql_lmd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNinsercion_postgresql_lmdActionPerformed(evt);
            }
        });

        BTNinsercion_sqlserver_lmd = new JButton("Inserciones en SQL Server");
        BTNinsercion_sqlserver_lmd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNinsercion_sqlserver_lmdActionPerformed(evt);
            }
        });

        BTNinsercion_mysqlserver_lmd1 = new JButton("Inserciones en MySQL Server");
        BTNinsercion_mysqlserver_lmd1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNinsercion_mysqlserver_lmd1ActionPerformed(evt);
            }
        });

        // Botones para realizar inserciones con Procedimientos Almacenados (SP)
        BTNinsercion_oracle_sp = new JButton("Inserciones en Oracle con SP");
        BTNinsercion_oracle_sp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNinsercion_oracle_spActionPerformed(evt);
            }
        });

        BTNinsercion_postgresql_sp = new JButton("Inserciones en PostgreSQL con SP");
        BTNinsercion_postgresql_sp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNinsercion_postgresql_spActionPerformed(evt);
            }
        });

        BTNinsercion_sqlserver_sp = new JButton("Inserciones en SQL Server con SP");
        BTNinsercion_sqlserver_sp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNinsercion_sqlserver_spActionPerformed(evt);
            }
        });

        BTNinsercion_mysqlserver_sp = new JButton("Inserciones en MySQL Server con SP");
        BTNinsercion_mysqlserver_sp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNinsercion_mysqlserver_spActionPerformed(evt);
            }
        });

        // Botones para borrar registros de las bases de datos
        BTNborrarOracle = new JButton("Borrar registros en Oracle");
        BTNborrarOracle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNborrarOracleActionPerformed(evt);
            }
        });

        BTNborrarpostgresql = new JButton("Borrar registros en PostgreSQL");
        BTNborrarpostgresql.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNborrarpostgresqlActionPerformed(evt);
            }
        });

        BTNborrarsqlserver = new JButton("Borrar registros en SQL Server");
        BTNborrarsqlserver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNborrarsqlserverActionPerformed(evt);
            }
        });

        BTNborrarmysqlserver = new JButton("Borrar registros en MySQL");
        BTNborrarmysqlserver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTNborrarmysqlserverActionPerformed(evt);
            }
        });

        // Botones para realizar inserciones en todas las bases de datos
        BTNInsertarOracle = new JButton("Insertar en Oracle");
        BTNInsertarOracle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                realizarInserciones("Oracle");
            }
        });

        BTNInsertarPostgreSQL = new JButton("Insertar en PostgreSQL");
        BTNInsertarPostgreSQL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                realizarInserciones("PostgreSQL");
            }
        });

        BTNInsertarSQLServer = new JButton("Insertar en SQL Server");
        BTNInsertarSQLServer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                realizarInserciones("SQLServer");
            }
        });

        BTNInsertarMySQL = new JButton("Insertar en MySQL");
        BTNInsertarMySQL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                realizarInserciones("MySQL");
            }
        });

        // Botón de "DB Config"
        dbConfigButton = new JButton("DB Config");
//        dbConfigButton.addActionListener(e -> abrirDBConfig());


        // Configuración del diseño del contenedor principal
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(73, 73, 73)
                                                                .addComponent(TXTid, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(73,73,73)
                                                                .addComponent(dbConfigButton)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(TXTdescripcion)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TXTcosto, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TXTprecio, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TXTnumInserciones, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(BTNconexionoracle)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(BTNconexionpostgresql)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(BTNconexionsqlserver)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(BTNconexionmysqlserver))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(BTNInsertarOracle)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(BTNInsertarPostgreSQL)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(BTNInsertarSQLServer)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(BTNInsertarMySQL)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(BTNinsercion_oracle_lmd)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TXTresultado_lmd_oracle))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(BTNinsercion_postgresql_lmd)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TXTresultado_lmd_postgresql))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(BTNinsercion_sqlserver_lmd)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TXTresultado_lmd_sqlserver))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(BTNinsercion_mysqlserver_lmd1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TXTresultado_lmd_mysqlserver))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(BTNinsercion_oracle_sp)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TXTresultado_sp_oracle))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(BTNinsercion_postgresql_sp)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TXTresultado_sp_postgresql))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(BTNinsercion_sqlserver_sp)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TXTresultado_sp_sqlserver))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(BTNinsercion_mysqlserver_sp)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TXTresultado_sp_mysqlserver))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(BTNborrarOracle)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(BTNborrarpostgresql)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(BTNborrarsqlserver)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(BTNborrarmysqlserver)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(TXTid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(dbConfigButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(TXTdescripcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(TXTcosto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(TXTprecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(TXTnumInserciones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNconexionoracle)
                                        .addComponent(BTNconexionpostgresql)
                                        .addComponent(BTNconexionsqlserver)
                                        .addComponent(BTNconexionmysqlserver))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNInsertarOracle)
                                        .addComponent(BTNInsertarPostgreSQL)
                                        .addComponent(BTNInsertarSQLServer)
                                        .addComponent(BTNInsertarMySQL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNinsercion_oracle_lmd)
                                        .addComponent(TXTresultado_lmd_oracle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNinsercion_postgresql_lmd)
                                        .addComponent(TXTresultado_lmd_postgresql, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNinsercion_sqlserver_lmd)
                                        .addComponent(TXTresultado_lmd_sqlserver, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNinsercion_mysqlserver_lmd1)
                                        .addComponent(TXTresultado_lmd_mysqlserver, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNinsercion_oracle_sp)
                                        .addComponent(TXTresultado_sp_oracle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNinsercion_postgresql_sp)
                                        .addComponent(TXTresultado_sp_postgresql, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNinsercion_sqlserver_sp)
                                        .addComponent(TXTresultado_sp_sqlserver, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNinsercion_mysqlserver_sp)
                                        .addComponent(TXTresultado_sp_mysqlserver, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNborrarOracle)
                                        .addComponent(BTNborrarpostgresql)
                                        .addComponent(BTNborrarsqlserver)
                                        .addComponent(BTNborrarmysqlserver))
                                .addContainerGap())
        );
        pack();
    }



    /**
     * Maneja la acción del botón para conectar con la base de datos Oracle.
     * Este método establece una conexión con la base de datos Oracle.
     */
    private void BTNconexionoracleActionPerformed(ActionEvent evt) {
        conexionOracle.conectar();
    }

    /**
     * Inserta múltiples registros en una base de datos PostgreSQL hasta que se cumple un tiempo específico.
     * Se insertan registros en la tabla "producto" utilizando una sentencia SQL.
     */
    private void BTNinsercion_postgresql_lmdActionPerformed(ActionEvent evt) {
        ContadorTiempo contadorTiempo = new ContadorTiempo();
        contadorTiempo.ContadorTiempo();

        conexionPostgresql.conectar();
        int contador = 0;

        while (true) {
            Calendar tiempoActual = Calendar.getInstance();
            int hora = tiempoActual.get(Calendar.HOUR);
            int minuto = tiempoActual.get(Calendar.MINUTE);
            int segundo = tiempoActual.get(Calendar.SECOND);

            if (hora == contadorTiempo.horaDespues && minuto == contadorTiempo.minutoDespues && segundo == contadorTiempo.segundoDespues) {
                break;
            } else {
                conexionPostgresql.ejecutar("INSERT INTO producto VALUES (" +
                        Integer.parseInt(TXTid.getText()) + ", '" +
                        TXTdescripcion.getText() + "', " +
                        Float.parseFloat(TXTcosto.getText()) + ", " +
                        Float.parseFloat(TXTprecio.getText()) + ");");
            }

            contador++;
        }

        TXTresultado_lmd_postgresql.setText("Se insertaron " + contador + " registros en un minuto");
    }

    /**
     * Maneja la acción del botón para conectar con la base de datos PostgreSQL.
     * Este método establece una conexión con la base de datos PostgreSQL.
     */
    private void BTNconexionpostgresqlActionPerformed(ActionEvent evt) {
        conexionPostgresql.conectar();
    }

/**
 * Inserta múltiples registros en una base de datos Oracle hasta que se cumple un tiempo específico.
 * Se insertan registros en la tabla "producto" utilizando una sentencia SQL.
 */
private void BTNinsercion_oracle_lmdActionPerformed(ActionEvent evt) {
    ContadorTiempo contadorTiempo = new ContadorTiempo();
    contadorTiempo.ContadorTiempo();


    int contador = 0;

    while (true) {
        Calendar tiempoActual = Calendar.getInstance();
        int hora = tiempoActual.get(Calendar.HOUR);
        int minuto = tiempoActual.get(Calendar.MINUTE);
        int segundo = tiempoActual.get(Calendar.SECOND);

        if (hora == contadorTiempo.horaDespues && minuto == contadorTiempo.minutoDespues && segundo == contadorTiempo.segundoDespues) {
            break;
        } else {
            conexionOracle.ejecutar("INSERT INTO producto (PK_ID, ID_PRODUCTO, DESCRIPCION, COSTO, PRECIO) VALUES (" +
                    "PRODUCTO_SEQ.NEXTVAL, " +  // Genera el valor autoincremental para PK_ID
                    Integer.parseInt(TXTid.getText()) + ", '" +
                    TXTdescripcion.getText() + "', " +
                    Float.parseFloat(TXTcosto.getText()) + ", " +
                    Float.parseFloat(TXTprecio.getText()) + ")");
        }

        contador++;
    }

    TXTresultado_lmd_oracle.setText("Se insertaron " + contador + " registros en un minuto");
}



    /**
     * Maneja la acción del botón para conectar con la base de datos SQL Server.
     * Este método establece una conexión con la base de datos SQL Server.
     */
    private void BTNconexionsqlserverActionPerformed(ActionEvent evt) {
        conexionSqlserver.conectar();
    }

    /**
     * Inserta múltiples registros en una base de datos SQL Server hasta que se cumple un tiempo específico.
     * Se insertan registros en la tabla "PRODUCTO" utilizando una sentencia SQL.
     */
    private void BTNinsercion_sqlserver_lmdActionPerformed(ActionEvent evt) {
        ContadorTiempo contadorTiempo = new ContadorTiempo();
        contadorTiempo.ContadorTiempo();

        conexionSqlserver.conectar();
        int contador = 0;

        while (true) {
            Calendar tiempoActual = Calendar.getInstance();
            int hora = tiempoActual.get(Calendar.HOUR);
            int minuto = tiempoActual.get(Calendar.MINUTE);
            int segundo = tiempoActual.get(Calendar.SECOND);

            if (hora == contadorTiempo.horaDespues && minuto == contadorTiempo.minutoDespues && segundo == contadorTiempo.segundoDespues) {
                break;
            } else {
                conexionSqlserver.ejecutar("INSERT INTO PRODUCTO VALUES (" +
                        Integer.parseInt(TXTid.getText()) + ", '" +
                        TXTdescripcion.getText() + "', " +
                        Float.parseFloat(TXTcosto.getText()) + ", " +
                        Float.parseFloat(TXTprecio.getText()) + ")");
            }

            contador++;
        }

        TXTresultado_lmd_sqlserver.setText("Se insertaron " + contador + " registros en un minuto");
    }

    /**
     * Maneja la acción del botón para borrar todos los registros en la base de datos PostgreSQL.
     * Este método elimina todos los registros de la tabla "producto".
     */
    private void BTNborrarpostgresqlActionPerformed(ActionEvent evt) {
        conexionPostgresql.conectar();
        conexionPostgresql.ejecutar("DELETE FROM producto");
        conexionPostgresql.ejecutar("ALTER SEQUENCE PRODUCTO_PK_ID_seq RESTART WITH 1");

        TXTresultado_lmd_postgresql.setText("");
        TXTresultado_sp_postgresql.setText("");
        JOptionPane.showMessageDialog(null, "Registros borrados de PostgreSQL");
    }

    /**
     * Maneja la acción del botón para borrar todos los registros en la base de datos Oracle.
     * Este método elimina todos los registros de la tabla "producto".
     */
    private void BTNborrarOracleActionPerformed(ActionEvent evt) {
        conexionOracle.conectar();
        conexionOracle.ejecutar("DELETE FROM producto");
        conexionOracle.ejecutar("DROP SEQUENCE PRODUCTO_SEQ");
        conexionOracle.ejecutar("CREATE SEQUENCE PRODUCTO_SEQ START WITH 1 INCREMENT BY 1");
        
        TXTresultado_lmd_oracle.setText("");
        TXTresultado_sp_oracle.setText("");
        JOptionPane.showMessageDialog(null, "Registros borrados de Oracle");
    }

    /**
     * Maneja la acción del botón para borrar todos los registros en la base de datos SQL Server.
     * Este método elimina todos los registros de la tabla "producto".
     */
    private void BTNborrarsqlserverActionPerformed(ActionEvent evt) {
        conexionSqlserver.conectar();
        conexionSqlserver.ejecutar("DELETE FROM producto");
        conexionSqlserver.ejecutar("DBCC CHECKIDENT ('PRODUCTO', RESEED, 0)");

        TXTresultado_lmd_sqlserver.setText("");
        TXTresultado_sp_sqlserver.setText("");
        JOptionPane.showMessageDialog(null, "Registros borrados de SQL Server 2022");
    }

    /**
     * Inserta múltiples registros en una base de datos Oracle utilizando un procedimiento almacenado.
     * Se insertan registros en la base de datos Oracle utilizando el procedimiento almacenado "PA_INSERTARPRODUCTO".
     */
    private void BTNinsercion_oracle_spActionPerformed(ActionEvent evt) {
        try {

            ContadorTiempo contadorTiempo = new ContadorTiempo();
            contadorTiempo.ContadorTiempo();

            CallableStatement cst = conexionOracle.getConexion().prepareCall("{call PA_INSERTARPRODUCTO (?,?,?,?)}");
            int contador = 0;

            cst.setString(1, TXTid.getText());
            cst.setString(2, TXTdescripcion.getText());
            cst.setDouble(3, Double.parseDouble(TXTcosto.getText()));
            cst.setDouble(4, Double.parseDouble(TXTprecio.getText()));

            while (true) {
                Calendar tiempoActual = Calendar.getInstance();
                int hora = tiempoActual.get(Calendar.HOUR);
                int minuto = tiempoActual.get(Calendar.MINUTE);
                int segundo = tiempoActual.get(Calendar.SECOND);

                if (hora == contadorTiempo.horaDespues && minuto == contadorTiempo.minutoDespues && segundo == contadorTiempo.segundoDespues) {
                    break;
                } else {
                    cst.execute();
                    contador++;
                }
            }

            TXTresultado_sp_oracle.setText("Se insertaron " + contador + " registros en un minuto");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }


    /**
     * Maneja la acción del botón para insertar registros en la base de datos SQL Server usando un procedimiento almacenado.
     * Los registros se insertan en la base de datos SQL Server hasta que se cumple un tiempo específico.
     */
    private void BTNinsercion_sqlserver_spActionPerformed(ActionEvent evt) {
        try {
            conexionSqlserver.conectar();
            ContadorTiempo contadorTiempo = new ContadorTiempo();
            contadorTiempo.ContadorTiempo();

            CallableStatement cst = conexionSqlserver.getConexion().prepareCall("{call PA_INSERTARPRODUCTO (?,?,?,?)}");
            int contador = 0;

            cst.setString(1, TXTid.getText());
            cst.setString(2, TXTdescripcion.getText());
            cst.setDouble(3, Double.parseDouble(TXTcosto.getText()));
            cst.setDouble(4, Double.parseDouble(TXTprecio.getText()));

            while (true) {
                Calendar tiempoActual = Calendar.getInstance();
                int hora = tiempoActual.get(Calendar.HOUR);
                int minuto = tiempoActual.get(Calendar.MINUTE);
                int segundo = tiempoActual.get(Calendar.SECOND);

                if (hora == contadorTiempo.horaDespues && minuto == contadorTiempo.minutoDespues && segundo == contadorTiempo.segundoDespues) {
                    break;
                } else {
                    cst.execute();
                    contador++;
                }
            }

            TXTresultado_sp_sqlserver.setText("Se insertaron " + contador + " registros en un minuto");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Maneja la acción del botón para insertar registros en la base de datos PostgreSQL usando un procedimiento almacenado.
     * Los registros se insertan en la base de datos PostgreSQL hasta que se cumple un tiempo específico.
     */
    private void BTNinsercion_postgresql_spActionPerformed(ActionEvent evt) {
        try {
            conexionPostgresql.conectar();
            ContadorTiempo contadorTiempo = new ContadorTiempo();
            contadorTiempo.ContadorTiempo();

            CallableStatement cst = conexionPostgresql.getConexion().prepareCall("{call PA_INSERTARPRODUCTO (?,?,?,?)}");
            int contador = 0;

            cst.setString(1, TXTid.getText());
            cst.setString(2, TXTdescripcion.getText());
            cst.setFloat(3, Float.parseFloat(TXTcosto.getText()));
            cst.setFloat(4, Float.parseFloat(TXTprecio.getText()));

            while (true) {
                Calendar tiempoActual = Calendar.getInstance();
                int hora = tiempoActual.get(Calendar.HOUR);
                int minuto = tiempoActual.get(Calendar.MINUTE);
                int segundo = tiempoActual.get(Calendar.SECOND);

                if (hora == contadorTiempo.horaDespues && minuto == contadorTiempo.minutoDespues && segundo == contadorTiempo.segundoDespues) {
                    break;
                } else {
                    cst.execute();
                    contador++;
                }
            }

            TXTresultado_sp_postgresql.setText("Se insertaron " + contador + " registros en un minuto");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Maneja la acción del botón para borrar todos los registros de la base de datos MySQL.
     * Este método elimina todos los registros de la tabla "PRODUCTO".
     */
    private void BTNborrarmysqlserverActionPerformed(ActionEvent evt) {
        conexionMySqlserver.conectar();
        conexionMySqlserver.ejecutar("DELETE FROM PRODUCTO");
        conexionMySqlserver.ejecutar("TRUNCATE TABLE PRODUCTO");

        TXTresultado_lmd_mysqlserver.setText("");
        TXTresultado_sp_mysqlserver.setText("");
        JOptionPane.showMessageDialog(null, "Registros borrados de MySQL 8");
    }


    /**
     * Maneja la acción del botón para insertar registros en la base de datos MySQL Server usando un procedimiento almacenado.
     * Los registros se insertan en la base de datos MySQL Server hasta que se cumple un tiempo específico.
     */
    private void BTNinsercion_mysqlserver_spActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            conexionMySqlserver.conectar();
            ContadorTiempo contadorTiempo = new ContadorTiempo();
            contadorTiempo.ContadorTiempo();

            CallableStatement cst = conexionMySqlserver.getConexion().prepareCall("{call PA_INSERTARPRODUCTO (?,?,?,?)}");
            int contador = 0;

            cst.setString(1, TXTid.getText());
            cst.setString(2, TXTdescripcion.getText());
            cst.setDouble(3, Double.parseDouble(TXTcosto.getText()));
            cst.setDouble(4, Double.parseDouble(TXTprecio.getText()));

            while (true) {
                Calendar tiempoActual = Calendar.getInstance();
                int hora = tiempoActual.get(Calendar.HOUR);
                int minuto = tiempoActual.get(Calendar.MINUTE);
                int segundo = tiempoActual.get(Calendar.SECOND);

                if (hora == contadorTiempo.horaDespues && minuto == contadorTiempo.minutoDespues && segundo == contadorTiempo.segundoDespues) {
                    break;
                } else {
                    cst.execute();
                    contador++;
                }
            }

            TXTresultado_sp_mysqlserver.setText("Se insertaron " + contador + " registros en un minuto");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Maneja la acción del botón para insertar registros en la base de datos MySQL Server usando una sentencia SQL directa.
    * Los registros se insertan en la base de datos MySQL Server hasta que se cumple un tiempo específico.
    */
    private void BTNinsercion_mysqlserver_lmd1ActionPerformed(ActionEvent evt) {
        ContadorTiempo contadorTiempo = new ContadorTiempo();
        contadorTiempo.ContadorTiempo();
        conexionMySqlserver.conectar();
        int contador = 0;

        while (true) {
            Calendar tiempoActual = Calendar.getInstance();
            int hora = tiempoActual.get(Calendar.HOUR);
            int minuto = tiempoActual.get(Calendar.MINUTE);
            int segundo = tiempoActual.get(Calendar.SECOND);

            if (hora == contadorTiempo.horaDespues && minuto == contadorTiempo.minutoDespues && segundo == contadorTiempo.segundoDespues) {
                break;
            } else {
            // La columna PK_ID no se incluye en la sentencia INSERT ya que es autoincremental
                conexionMySqlserver.ejecutar("INSERT INTO PRODUCTO (ID_PRODUCTO, DESCRIPCION, COSTO, PRECIO) VALUES (" +
                        "'" + TXTid.getText() + "', '" +  // Usar comillas simples para valores de texto
                        TXTdescripcion.getText() + "', " +
                        Float.parseFloat(TXTcosto.getText()) + ", " +
                        Float.parseFloat(TXTprecio.getText()) + ")");
                contador++;
            }
        }

    TXTresultado_lmd_mysqlserver.setText("Se insertaron " + contador + " registros en un minuto");
    }


    /**
     * Maneja la acción del botón para conectar a la base de datos MySQL Server.
     */
    private void BTNconexionmysqlserverActionPerformed(ActionEvent evt) {
        conexionMySqlserver.conectar();
    }


    /**
     * Realiza inserciones en la base de datos especificada usando un procedimiento almacenado.
     *
     * @param dbType Tipo de base de datos (Oracle, PostgreSQL, SQLServer, MySQL)
     */
    private void realizarInserciones(String dbType) {
        Connection conexion = null;
        CallableStatement cst = null;

        try {
            int numInserciones = Integer.parseInt(TXTnumInserciones.getText());

            // Establecer conexión y preparar el CallableStatement según el tipo de base de datos
            if ("Oracle".equals(dbType)) {
                conexionOracle.conectar();
                conexion = conexionOracle.getConexion();
                cst = conexion.prepareCall("{call PA_INSERTARPRODUCTO(?,?,?,?)}");

                for (int i = 0; i < numInserciones; i++) {
                    insertarProductoOracle(cst);
                }
                JOptionPane.showMessageDialog(this, "Se completaron " + numInserciones + " inserciones en Oracle.");

            } else if ("PostgreSQL".equals(dbType)) {
                conexionPostgresql.conectar();
                conexion = conexionPostgresql.getConexion();
                cst = conexion.prepareCall("{call PA_INSERTARPRODUCTO(?,?,?,?)}");

                for (int i = 0; i < numInserciones; i++) {
                    insertarProductoPostgreSQL(cst);
                }
                JOptionPane.showMessageDialog(this, "Se completaron " + numInserciones + " inserciones en PostgreSQL.");

            } else if ("SQLServer".equals(dbType)) {
                conexionSqlserver.conectar();
                conexion = conexionSqlserver.getConexion();
                cst = conexion.prepareCall("{call PA_INSERTARPRODUCTO(?,?,?,?)}");

                for (int i = 0; i < numInserciones; i++) {
                    insertarProductoSQLServer(cst);
                }
                JOptionPane.showMessageDialog(this, "Se completaron " + numInserciones + " inserciones en SQL Server.");

            } else if ("MySQL".equals(dbType)) {
                conexionMySqlserver.conectar();
                conexion = conexionMySqlserver.getConexion();
                cst = conexion.prepareCall("{call PA_INSERTARPRODUCTO(?,?,?,?)}");

                for (int i = 0; i < numInserciones; i++) {
                    insertarProductoMySQL(cst);
                }
                JOptionPane.showMessageDialog(this, "Se completaron " + numInserciones + " inserciones en MySQL.");

            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido de inserciones.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error en la conexión o en la inserción: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (cst != null) cst.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    /**
     * Inserta un producto en la base de datos Oracle usando el CallableStatement proporcionado.
     *
     * @param cst CallableStatement preparado para la inserción
     */
    private void insertarProductoOracle(CallableStatement cst) {
        try {
            cst.setString(1, TXTid.getText());
            cst.setString(2, TXTdescripcion.getText());
            cst.setDouble(3, Double.parseDouble(TXTcosto.getText()));
            cst.setDouble(4, Double.parseDouble(TXTprecio.getText()));

            cst.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la inserción Oracle: " + ex.getMessage());
        }
    }

    /**
     * Inserta un producto en la base de datos MySQL usando el CallableStatement proporcionado.
     *
     * @param cst CallableStatement preparado para la inserción
     */
    private void insertarProductoMySQL(CallableStatement cst) {
        try {
            cst.setString(1, TXTid.getText());
            cst.setString(2, TXTdescripcion.getText());
            cst.setDouble(3, Double.parseDouble(TXTcosto.getText()));
            cst.setDouble(4, Double.parseDouble(TXTprecio.getText()));

            cst.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la inserción MySQL: " + ex.getMessage());
        }
    }

    /**
     * Inserta un producto en la base de datos PostgreSQL usando el CallableStatement proporcionado.
     *
     * @param cst CallableStatement preparado para la inserción
     */
    private void insertarProductoPostgreSQL(CallableStatement cst) {
        try {
            cst.setString(1, TXTid.getText());
            cst.setString(2, TXTdescripcion.getText());
            cst.setFloat(3, Float.parseFloat(TXTcosto.getText()));
            cst.setFloat(4, Float.parseFloat(TXTprecio.getText()));

            cst.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la inserción PostgreSQL: " + ex.getMessage());
        }
    }

    /**
     * Inserta un producto en la base de datos SQL Server usando el CallableStatement proporcionado.
     *
     * @param cst CallableStatement preparado para la inserción
     */
    private void insertarProductoSQLServer(CallableStatement cst) {
        try {
            cst.setString(1, TXTid.getText());
            cst.setString(2, TXTdescripcion.getText());
            cst.setDouble(3, Double.parseDouble(TXTcosto.getText()));
            cst.setDouble(4, Double.parseDouble(TXTprecio.getText()));

            cst.execute();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la inserción SQL Server: " + ex.getMessage());
        }
    }


    // Método que abre la ventana de configuración de bases de datos
    private void abrirDBConfig() {
        if (dbConfigDialog == null) {
            // Pasar las credenciales predeterminadas de la conexión

            dbConfigDialog = new DBConfigD(this);
        }
        dbConfigDialog.setVisible(true);  // Mostrar la ventana de configuración
    }


    /**
     * Método principal que configura el aspecto visual de la aplicación y muestra la ventana principal.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este caso)
     */
    public static void main(String[] args) {
        /* Configurar el aspecto visual Nimbus */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }



        /* Crear y mostrar la ventana principal */
        EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }

    // Declaración de variables de interfaz gráfica
    private JButton BTNborrarOracle;
    private JButton BTNborrarmysqlserver;
    private JButton BTNborrarpostgresql;
    private JButton BTNborrarsqlserver;
    private JButton BTNconexionmysqlserver;
    private JButton BTNconexionoracle;
    private JButton BTNconexionpostgresql;
    private JButton BTNconexionsqlserver;
    private JButton BTNinsercion_mysqlserver_lmd1;
    private JButton BTNinsercion_mysqlserver_sp;
    private JButton BTNinsercion_oracle_lmd;
    private JButton BTNinsercion_oracle_sp;
    private JButton BTNinsercion_postgresql_lmd;
    private JButton BTNinsercion_postgresql_sp;
    private JButton BTNinsercion_sqlserver_lmd;
    private JButton BTNinsercion_sqlserver_sp;
    private JButton BTNInsertarOracle;
    private JButton BTNInsertarMySQL;
    private JButton BTNInsertarPostgreSQL;
    private JButton BTNInsertarSQLServer;
    private JTextField TXTcosto;
    private JTextField TXTdescripcion;
    private JTextField TXTid;
    private JTextField TXTprecio;
    private JTextField TXTresultado_lmd_mysqlserver;
    private JTextField TXTresultado_lmd_oracle;
    private JTextField TXTresultado_lmd_postgresql;
    private JTextField TXTresultado_lmd_sqlserver;
    private JTextField TXTresultado_sp_mysqlserver;
    private JTextField TXTresultado_sp_oracle;
    private JTextField TXTresultado_sp_postgresql;
    private JTextField TXTresultado_sp_sqlserver;
    private JTextField TXTnumInserciones;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JButton dbConfigButton;

    private DBConfigD dbConfigDialog;

    private ConexionOracle conexionOracle = ConexionOracle.getInstance();
    private ConexionMySqlserver conexionMySqlserver = ConexionMySqlserver.getInstance();
    private ConexionPostgresql conexionPostgresql = ConexionPostgresql.getInstance();
    private ConexionSqlserver conexionSqlserver = ConexionSqlserver.getInstance();
}
