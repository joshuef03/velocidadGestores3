from abc import ABC, abstractmethod


class ConexionBD(ABC):
    @abstractmethod
    def get_conexion(self):
        """Método abstracto para obtener la conexión a la BD."""
        pass

    @abstractmethod
    def desconectar(self):
        """Método abstracto para cerrar la conexión."""
        pass

    @abstractmethod
    def manejar_error(self, mensaje: str):
        pass
