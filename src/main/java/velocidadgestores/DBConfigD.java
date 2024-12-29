package velocidadgestores;

import database.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DBConfigD extends JDialog {

    private JComboBox<String> dbTypeCombo;
    private JTextField hostField, portField, dbNameField, userField;
    private JPasswordField passwordField;
    private JButton saveButton;

    // Variables para almacenar las credenciales dinámicas
    private String dbUrl, dbUser, dbPassword;

    public DBConfigD(JFrame parent) {
        super(parent, "Configuración de Base de Datos", true);
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Etiqueta y combo box para el tipo de base de datos
        JLabel dbTypeLabel = new JLabel("Tipo de Base de Datos:");
        dbTypeLabel.setBounds(30, 30, 150, 25);
        add(dbTypeLabel);

        dbTypeCombo = new JComboBox<>(new String[]{"Oracle", "MySQL", "PostgreSQL", "SQL Server"});
        dbTypeCombo.setBounds(180, 30, 150, 25);
        dbTypeCombo.addActionListener(e -> actualizarCamposPorTipo());
        add(dbTypeCombo);

        // Campos de entrada para credenciales
        addTextField("Host:", 70, hostField = new JTextField());
        addTextField("Puerto:", 110, portField = new JTextField());
        addTextField("Base de Datos:", 150, dbNameField = new JTextField());
        addTextField("Usuario:", 190, userField = new JTextField());

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(30, 230, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 230, 150, 25);
        add(passwordField);

        // Botón para guardar las credenciales
        saveButton = new JButton("Guardar");
        saveButton.setBounds(150, 270, 100, 30);
        add(saveButton);

        // Acción al hacer clic en "Guardar"
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCredenciales();
                actualizarConexion();
            }
        });

        // Inicializar con las credenciales de la base de datos activa
        inicializarCredenciales();
    }

    // Método para inicializar los campos con las credenciales de la instancia activa
    private void inicializarCredenciales() {
        String dbType = (String) dbTypeCombo.getSelectedItem();
        switch (dbType) {
            case "Oracle":
                cargarCredencialesDesdeInstancia(ConexionOracle.getInstance());
                break;
            case "MySQL":
                cargarCredencialesDesdeInstancia(ConexionMySqlserver.getInstance());
                break;
            case "PostgreSQL":
                cargarCredencialesDesdeInstancia(ConexionPostgresql.getInstance());
                break;
            case "SQL Server":
                cargarCredencialesDesdeInstancia(ConexionSqlserver.getInstance());
                break;
            default:
                JOptionPane.showMessageDialog(this, "Tipo de base de datos no soportado.");
        }
    }

    // Método auxiliar para cargar credenciales de la instancia activa
    private void cargarCredencialesDesdeInstancia(ConexionBase instancia) {
        dbUrl = instancia.getDbUrl();
        dbUser = instancia.getUser();
        dbPassword = instancia.getPassword();

        hostField.setText(getHostFromUrl(dbUrl));
        portField.setText(getPortFromUrl(dbUrl));
        dbNameField.setText(getDbNameFromUrl(dbUrl));
        userField.setText(dbUser);
        passwordField.setText(dbPassword);
    }

    // Agrega un campo de texto con etiqueta a la ventana
    private void addTextField(String label, int y, JTextField field) {
        JLabel jLabel = new JLabel(label);
        jLabel.setBounds(30, y, 100, 25);
        add(jLabel);

        field.setBounds(180, y, 150, 25);
        add(field);
    }

    // Guardar las credenciales ingresadas por el usuario
    private void guardarCredenciales() {
        String dbType = (String) dbTypeCombo.getSelectedItem();
        String host = hostField.getText();
        String port = portField.getText();
        String dbName = dbNameField.getText();
        String user = userField.getText();
        String password = new String(passwordField.getPassword());

        // Crear la URL de conexión según el tipo de base de datos
        switch (dbType) {
            case "Oracle":
                dbUrl = "jdbc:oracle:thin:@" + host + ":" + port + "/" + dbName;
                break;
            case "MySQL":
                dbUrl = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
                break;
            case "PostgreSQL":
                dbUrl = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;
                break;
            case "SQL Server":
                dbUrl = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dbName;
                break;
            default:
                JOptionPane.showMessageDialog(this, "Seleccione un tipo de base de datos válido.");
                return;
        }

        dbUser = user;
        dbPassword = password;
    }

    // Actualizar la conexión en tiempo de ejecución
    private void actualizarConexion() {
        String dbType = (String) dbTypeCombo.getSelectedItem();
        switch (dbType) {
            case "Oracle":
                ConexionOracle.getInstance().actualizarCredenciales(dbUrl, dbUser, dbPassword);
                break;
            case "MySQL":
                ConexionMySqlserver.getInstance().actualizarCredenciales(dbUrl, dbUser, dbPassword);
                break;
            case "PostgreSQL":
                ConexionPostgresql.getInstance().actualizarCredenciales(dbUrl, dbUser, dbPassword);
                break;
            case "SQL Server":
                ConexionSqlserver.getInstance().actualizarCredenciales(dbUrl, dbUser, dbPassword);
                break;
            default:
                JOptionPane.showMessageDialog(this, "No se reconoció el tipo de base de datos.");
        }
    }

    // Actualizar campos predeterminados según el tipo de base de datos seleccionado
    private void actualizarCamposPorTipo() {
        String dbType = (String) dbTypeCombo.getSelectedItem();
        switch (dbType) {
            case "Oracle":
                portField.setText("1521");
                break;
            case "MySQL":
                portField.setText("3306");
                break;
            case "PostgreSQL":
                portField.setText("5432");
                break;
            case "SQL Server":
                portField.setText("1433");
                break;
            default:
                portField.setText("");
        }
        inicializarCredenciales();
    }

    // Métodos auxiliares para extraer partes de la URL
    private String getHostFromUrl(String url) {
        try {
            return url.split("@")[1].split(":")[0];
        } catch (Exception e) {
            return "localhost";
        }
    }

    private String getPortFromUrl(String url) {
        try {
            return url.split(":")[2].split("/")[0];
        } catch (Exception e) {
            return "";
        }
    }

    private String getDbNameFromUrl(String url) {
        try {
            return url.split("/")[1];
        } catch (Exception e) {
            return "";
        }
    }
}
