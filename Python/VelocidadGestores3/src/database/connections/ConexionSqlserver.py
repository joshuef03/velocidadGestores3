import threading
from typing import Optional
import pyodbc
from tkinter import messagebox

from src.database.connections.ConexionBase import ConexionBase


class ConexionSqlserver(ConexionBase):
    _instance = None
    _lock = threading.RLock()

    DEFAULT_HOST = "localhost"
    DEFAULT_PORT = 1433
    DEFAULT_DB = "BDPRODUCTO"
    DEFAULT_USER = "sa"
    DEFAULT_PASSWORD = "MS3123"

    @classmethod
    def get_instance(cls):
        """Método para obtener la instancia única de la conexión."""
        with cls._lock:
            if cls._instance is None:
                cls._instance = cls()
        return cls._instance

    def __new__(cls):
        """Implementación del patrón Singleton"""
        with cls._lock:
            if cls._instance is None:
                cls._instance = super().__new__(cls)
                cls._instance._init_connection()
        return cls._instance

    def __init__(self):
        if not hasattr(self, "_initialized"):
            super().__init__(self.DEFAULT_HOST, self.DEFAULT_PORT, self.DEFAULT_DB, self.DEFAULT_USER, self.DEFAULT_PASSWORD)
            self._initialized = True

    def _init_connection(self):
        """Inicializa la conexión con los valores por defecto."""
        self.db_host = self.DEFAULT_HOST
        self.db_port = self.DEFAULT_PORT
        self.db_name = self.DEFAULT_DB
        self.db_user = self.DEFAULT_USER
        self.db_password = self.DEFAULT_PASSWORD
        self._conexion_bd: Optional[pyodbc.Connection] = None

    def crear_conexion(self):
        """Crea la conexión con SQL Server."""
        try:
            connection_string = f"DRIVER={{ODBC Driver 17 for SQL Server}};SERVER={self.db_host},{self.db_port};DATABASE={self.db_name};UID={self.db_user};PWD={self.db_password}"
            self._conexion_bd = pyodbc.connect(connection_string)

            return self._conexion_bd
        except pyodbc.Error as e:
            self.manejar_error(f"Error en la conexión con SQL Server: {e}")
            return None

    def show_connec(self):
        messagebox.showinfo("Conexión", "¡Conexión exitosa con SQL Server!")

    def is_connected(self) -> bool:
        """Verifica si la conexión a la base de datos sigue activa."""
        try:
            if self._conexion_bd:
                cursor = self._conexion_bd.cursor()
                cursor.execute("SELECT 1")  # Consulta simple para verificar conexión
                cursor.close()
                return True
        except Exception:
            return False

    def manejar_error(self, mensaje: str):
        """Método especializado para manejar errores en SQL Server"""
        messagebox.showerror("Error de Conexión", mensaje)
        super().manejar_error(mensaje)
