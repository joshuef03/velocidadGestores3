import tkinter as tk
from tkinter import ttk, messagebox
from src.database.connections import ConexionOracle, ConexionMySQL, ConexionPostgresql, ConexionSqlserver


class DBConfigD(tk.Toplevel):
    def __init__(self, parent):
        super().__init__(parent)
        self.title("Configuración de Base de Datos")

        self.db_host = ""
        self.db_port = ""
        self.db_name = ""
        self.db_user = ""
        self.db_password = ""

        ttk.Label(self, text="Tipo de Base de Datos:").grid(row=0, column=0, padx=10, pady=5)
        self.db_type_combo = ttk.Combobox(self, values=["Oracle", "MySQL", "PostgreSQL", "SQL Server"])
        self.db_type_combo.grid(row=0, column=1, padx=10, pady=5)
        self.db_type_combo.bind("<<ComboboxSelected>>", self.actualizar_campos_por_tipo)

        self.host_field = self.add_text_field("Host:", 1)
        self.port_field = self.add_text_field("Puerto:", 2)
        self.db_name_field = self.add_text_field("Base de Datos:", 3)
        self.user_field = self.add_text_field("Usuario:", 4)

        ttk.Label(self, text="Contraseña:").grid(row=5, column=0, padx=10, pady=5)
        self.password_field = ttk.Entry(self, show="*")
        self.password_field.grid(row=5, column=1, padx=10, pady=5)

        self.save_button = ttk.Button(self, text="Guardar", command=self.guardar_credenciales)
        self.save_button.grid(row=6, column=0, columnspan=2, pady=10)

        self.inicializar_credenciales()

    def add_text_field(self, label, row):
        ttk.Label(self, text=label).grid(row=row, column=0, padx=10, pady=5)
        entry = ttk.Entry(self)
        entry.grid(row=row, column=1, padx=10, pady=5)
        return entry

    def inicializar_credenciales(self):
        db_type = self.db_type_combo.get()
        instancias = {
            "Oracle": ConexionOracle.ConexionOracle.get_instance(),
            "MySQL": ConexionMySQL.ConexionMySQL.get_instance(),
            "PostgreSQL": ConexionPostgresql.ConexionPostgresql.get_instance(),
            "SQL Server": ConexionSqlserver.ConexionSqlserver.get_instance()
        }
        instancia = instancias.get(db_type)
        if instancia:
            self.cargar_credenciales_desde_instancia(instancia)

    def cargar_credenciales_desde_instancia(self, instancia):
        self.db_host = instancia.db_host
        self.db_port = instancia.db_port
        self.db_user = instancia.db_user
        self.db_name = instancia.db_name
        self.db_password = instancia.db_password
        self.host_field.insert(0, self.db_host)
        self.port_field.insert(0, self.db_port)
        self.user_field.insert(0, self.db_user)
        self.db_name_field.insert(0, self.db_name)
        self.password_field.insert(0, self.db_password)

    def guardar_credenciales(self):
        db_type = self.db_type_combo.get()
        self.db_host = self.host_field.get()
        self.db_port = self.port_field.get()
        self.db_password = self.password_field.get()
        self.db_name = self.db_name_field.get()
        self.db_user = self.user_field.get()
        self.db_password = self.password_field.get()

        if db_type in ["Oracle", "MySQL", "PostgreSQL", "SQL Server"]:
            instancias = {
                "Oracle": ConexionOracle.ConexionOracle.get_instance(),
                "MySQL": ConexionMySQL.ConexionMySQL.get_instance(),
                "PostgreSQL": ConexionPostgresql.ConexionPostgresql.get_instance(),
                "SQL Server": ConexionSqlserver.ConexionSqlserver.get_instance()
            }
            instancia = instancias[db_type]
            messagebox.showinfo("Éxito", "Credenciales guardadas correctamente.")
            instancia.actualizar_credenciales(self.db_host, self.db_port, self.db_name, self.db_user, self.db_password)
        else:
            messagebox.showerror("Error", "Seleccione un tipo de base de datos válido.")

    def actualizar_campos_por_tipo(self, event=None):
        self.host_field.delete(0, tk.END)
        self.password_field.delete(0, tk.END)
        self.db_name_field.delete(0, tk.END)
        self.user_field.delete(0, tk.END)
        self.port_field.delete(0, tk.END)
        self.inicializar_credenciales()
