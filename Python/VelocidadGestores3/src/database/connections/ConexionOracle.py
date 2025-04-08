import threading
from typing import Optional

import cx_Oracle
from tkinter import messagebox

from src.database.connections.ConexionBase import ConexionBase


class ConexionOracle(ConexionBase):
    _instance = None
    _lock = threading.RLock()

    DEFAULT_HOST = "localhost"
    DEFAULT_PORT = 1521
    DEFAULT_DB = "xepdb1"
    DEFAULT_USER = "C##UDB"
    DEFAULT_PASSWORD = "1234567"

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
        self._conexion_bd: Optional[cx_Oracle.Connection] = None

    def crear_conexion(self):
        """Crea la conexión con Oracle."""
        try:
            dsn = cx_Oracle.makedsn(self.db_host, self.db_port, service_name=self.db_name)
            self._conexion_bd = cx_Oracle.connect(self.db_user, self.db_password, dsn)
            return self._conexion_bd
        except cx_Oracle.DatabaseError as e:
            self.manejar_error(f"Error en la conexión con Oracle: {e}")
            return None

    def show_connec(self):
        messagebox.showinfo("Conexión", "¡Conexión exitosa con Oracle!")

    def is_connected(self) -> bool:
        try:
            return self._conexion_bd and self._conexion_bd.ping() is None
        except:
            return False

    def manejar_error(self, mensaje: str):
        """Método especializado para manejar errores en Oracle"""
        messagebox.showerror("Error de Conexión", mensaje)
        super().manejar_error(mensaje)