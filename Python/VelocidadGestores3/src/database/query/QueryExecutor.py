import pyodbc

from src.database.connections.ConexionBD import ConexionBD


class QueryExecutor:
    def __init__(self, conexion_bd: ConexionBD):
        self.conexion_bd = conexion_bd

    def ejecutar_sql(self, sql: str):
        conn = self.conexion_bd.get_conexion()
        if conn:  # Verificamos que la conexión esté establecida
            try:
                cursor = conn.cursor()
                cursor.execute(sql)
                conn.commit()
            except Exception as e:
                self.conexion_bd.manejar_error(f"Error al ejecutar SQL: {e}")

    def ejecutar_procedimiento(self, nombre_proc, parametros=()):
        """Ejecuta un procedimiento almacenado en cualquier base de datos."""
        conn = self.conexion_bd.get_conexion()
        if not conn:
            raise RuntimeError("No hay conexión activa.")

        try:
            cursor = conn.cursor()

            if hasattr(cursor, "callproc"):
                # Para Oracle y MySQL
                cursor.callproc(nombre_proc, parametros)
            else:
                # Diferentes sintaxis para SQL Server y PostgreSQL
                if isinstance(conn, pyodbc.Connection):
                    # SQL Server usa EXEC en lugar de CALL
                    param_placeholders = ", ".join(["?" for _ in parametros])
                    query = f"EXEC {nombre_proc} {param_placeholders}"
                else:
                    # PostgreSQL usa CALL
                    param_placeholders = ", ".join(["%s"] * len(parametros))
                    query = f"CALL {nombre_proc}({param_placeholders})"

                cursor.execute(query, parametros)

            conn.commit()
            return cursor.fetchall() if cursor.description else None

        except Exception as e:
            raise RuntimeError(f"Error al ejecutar procedimiento {nombre_proc}: {e}")
