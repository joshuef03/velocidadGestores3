from abc import abstractmethod
from typing import Optional

from src.database.connections.ConexionBD import ConexionBD


class ConexionBase(ConexionBD):
    _conexion_bd: Optional[object] = None

    def __init__(self, db_host: str, db_port: int, db_name: str, db_user: str, db_password: str):
        self.db_host = db_host
        self.db_port = db_port
        self.db_name = db_name
        self.db_user = db_user
        self.db_password = db_password

    def actualizar_credenciales(self, db_url: str, db_port: int, db_name: str, db_user: str, db_password: str):
        """Actualiza los parámetros de conexión y reconecta la instancia activa."""
        self.desconectar()  # Cerramos la conexión anterior si existe
        self.db_host = db_url
        self.db_port = db_port
        self.db_name = db_name
        self.db_user = db_user
        self.db_password = db_password
        self.conectar()  # Reestablecemos la conexión con las nuevas credenciales

    @abstractmethod
    def crear_conexion(self):
        """Cada subclase debe implementar cómo crear la conexión."""
        pass

    @abstractmethod
    def is_connected(self):
        pass

    @abstractmethod
    def show_connec(self):
        pass

    def conectar(self):
        """Establece la conexión a la base de datos y muestra el mensaje."""
        try:
            conexion = self.get_conexion()
            self.show_connec()  # Muestra mensaje gráfico si la conexión fue exitosa
            return conexion
        except Exception as e:
            print(e)

    def desconectar(self):
        """Cerrar la conexión si está abierta."""
        if self._conexion_bd:
            try:
                self._conexion_bd.close()
            except Exception as e:
                print(f"Error al cerrar la conexión: {e}")
            finally:
                self._conexion_bd = None

    def get_conexion(self):
        """Retorna la conexión actual o la crea si es necesario."""
        if self._conexion_bd and self.is_connected():
            return self._conexion_bd  # Retorna la conexión actual si está activa

        try:
            self._conexion_bd = self.crear_conexion()  # Crea una nueva conexión
            return self._conexion_bd
        except Exception as e:
            raise RuntimeError(f"Error al establecer conexión: {e}")

    def manejar_error(self, mensaje: str):
        """Manejo de errores común a todas las clases."""
        print(mensaje)  # Puedes cambiarlo por logging
        raise RuntimeError(mensaje)
