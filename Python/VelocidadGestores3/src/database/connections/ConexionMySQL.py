import threading
from typing import Optional
from mysql.connector import Error
import mysql.connector
from tkinter import messagebox

from src.database.connections.ConexionBase import ConexionBase


class ConexionMySQL(ConexionBase):
    _instance = None
    _lock = threading.RLock()

    DEFAULT_HOST = "localhost"
    DEFAULT_PORT = 3306
    DEFAULT_DB = "BDPRODUCTO"
    DEFAULT_USER = "root"
    DEFAULT_PASSWORD = "MQL123"

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
        self._conexion_bd: Optional[mysql.connector.MySQLConnection] = None

    def crear_conexion(self):
        """Crea la conexión con MySQL."""
        try:
            self._conexion_bd = mysql.connector.connect(
                host=self.db_host,
                port=self.db_port,
                database=self.db_name,
                user=self.db_user,
                password=self.db_password
            )
            # Retornamos la conexión en lugar de asignarla directamente
            return self._conexion_bd
        except Error as e:
            self.manejar_error(f"Error en la conexión con MySQL: {e}")
            return None

    def show_connec(self):
        messagebox.showinfo("Conexión", "¡Conexión exitosa con MySQL Server!")

    def is_connected(self) -> bool:
        """Verifica si la conexión con MySQL sigue activa."""
        try:
            return self._conexion_bd is not None and self._conexion_bd.is_connected()
        except:
            return False  # Si hay un error, asumimos que no está conectada

    def manejar_error(self, mensaje: str):
        """Método especializado para manejar errores en MySQL"""
        messagebox.showerror("Error de Conexión", mensaje)
        super().manejar_error(mensaje)
