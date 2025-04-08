import tkinter as tk
from tkinter import messagebox
from tkinter import ttk

from ContadorTiempo import ContadorTiempo
from src.database.connections.ConexionMySQL import ConexionMySQL
from src.database.connections.ConexionOracle import ConexionOracle
from src.database.connections.ConexionPostgresql import ConexionPostgresql
from src.database.connections.ConexionSqlserver import ConexionSqlserver
from src.database.query.QueryExecutor import QueryExecutor
from src.velocidadgestores.ConfigDatabase import DBConfigD

oraConexion = ConexionOracle()
psgConexion = ConexionPostgresql()
mysqlConexion = ConexionMySQL()
sqlConexion = ConexionSqlserver()

oraEx = QueryExecutor(oraConexion)
psgEx = QueryExecutor(psgConexion)
mysqlEx = QueryExecutor(mysqlConexion)
sqlEx = QueryExecutor(sqlConexion)

def conectar_con_oracle():
    oraConexion.conectar()


def conectar_con_postgres():
    psgConexion.conectar()


def conectar_con_sqlserver():
    sqlConexion.conectar()


def conectar_con_mysql():
    mysqlConexion.conectar()


def BTNinsercion_oracle_lmd():
    contador_tiempo = ContadorTiempo()
    conectar_con_oracle()

    contador = 0
    id_producto = str(entries["Id"].get())
    descripcion_valor = str(entries["Descripcion"].get())
    costo_valor = float(entries["Costo"].get())
    precio_valor = float(entries["Precio"].get())
    while not contador_tiempo.tiempo_expirado():

        query = f"""
                        INSERT INTO PRODUCTO (PK_ID, ID_PRODUCTO, DESCRIPCION, COSTO, PRECIO) 
                        VALUES (PRODUCTO_SEQ.NEXTVAL, '{id_producto}', '{descripcion_valor}', {costo_valor}, {precio_valor})
                    """
        oraEx.ejecutar_sql(query)
        contador += 1

    texto = f"Se insertaron {contador} registros en un minuto"
    entrada = result_entries["ORACLE_LMD"]
    entrada.config(state="normal")
    entrada.delete(0, tk.END)
    entrada.insert(0, texto)
    entrada.config(state="readonly")

    messagebox.showinfo("SQL", "¡DATOS INSERTADOS CORRECTAMENTE!")

def BTNinsercion_oracle_sp():
    contador_tiempo = ContadorTiempo()
    conectar_con_oracle()

    contador = 0
    id_producto = str(entries["Id"].get())
    descripcion_valor = str(entries["Descripcion"].get())
    costo_valor = float(entries["Costo"].get())
    precio_valor = float(entries["Precio"].get())

    while not contador_tiempo.tiempo_expirado():

        oraEx.ejecutar_procedimiento("PA_INSERTARPRODUCTO", (id_producto, descripcion_valor, costo_valor, precio_valor))

        contador+=1

    texto = f"Se insertaron {contador} registros en un minuto"
    entrada = result_entries["ORACLE_SP"]
    entrada.config(state="normal")
    entrada.delete(0, tk.END)
    entrada.insert(0, texto)
    entrada.config(state="readonly")

    messagebox.showinfo("SQL", "¡DATOS INSERTADOS CORRECTAMENTE!")


def BTNinsercion_Postgresql_lmd():
    contador_tiempo = ContadorTiempo()
    conectar_con_postgres()

    contador = 0
    id_producto = str(entries["Id"].get())
    descripcion_valor = str(entries["Descripcion"].get())
    costo_valor = float(entries["Costo"].get())
    precio_valor = float(entries["Precio"].get())

    while not contador_tiempo.tiempo_expirado():

        query = f"""INSERT INTO producto(id_producto, descripcion, costo, precio)  VALUES ('{id_producto}','{descripcion_valor}', {costo_valor}, {precio_valor})"""
        psgEx.ejecutar_sql(query)
        contador += 1

    texto = f"Se insertaron {contador} registros en un minuto"
    entrada = result_entries["POSTGRES_LMD"]
    entrada.config(state="normal")
    entrada.delete(0, tk.END)
    entrada.insert(0, texto)
    entrada.config(state="readonly")

    messagebox.showinfo("SQL", "¡DATOS INSERTADOS CORRECTAMENTE!")

def BTNinsercion_Postgresql_sp():
    contador_tiempo = ContadorTiempo()
    conectar_con_postgres()

    contador = 0
    id_producto = str(entries["Id"].get())
    descripcion_valor = str(entries["Descripcion"].get())
    costo_valor = float(entries["Costo"].get())
    precio_valor = float(entries["Precio"].get())

    while not contador_tiempo.tiempo_expirado():
        psgEx.ejecutar_procedimiento("PA_INSERTARPRODUCTO", (id_producto, descripcion_valor, costo_valor, precio_valor))

        contador += 1

    texto = f"Se insertaron {contador} registros en un minuto"
    entrada = result_entries["POSTGRES_SP"]
    entrada.config(state="normal")
    entrada.delete(0, tk.END)
    entrada.insert(0, texto)
    entrada.config(state="readonly")

    messagebox.showinfo("SQL", "¡DATOS INSERTADOS CORRECTAMENTE!")


def BTNinsercion_sqlserver_lmd():
    contador_tiempo = ContadorTiempo()
    conectar_con_sqlserver()

    contador = 0
    id_producto = str(entries["Id"].get())
    descripcion_valor = str(entries["Descripcion"].get())
    costo_valor = float(entries["Costo"].get())
    precio_valor = float(entries["Precio"].get())

    while not contador_tiempo.tiempo_expirado():
        query = f"""INSERT INTO producto (id_producto, descripcion, costo, precio) VALUES ('{id_producto}','{descripcion_valor}', {costo_valor}, {precio_valor})"""
        sqlEx.ejecutar_sql(query)
        contador += 1

    texto = f"Se insertaron {contador} registros en un minuto"
    entrada = result_entries["SQL SERVER_LMD"]
    entrada.config(state="normal")
    entrada.delete(0, tk.END)
    entrada.insert(0, texto)
    entrada.config(state="readonly")

    messagebox.showinfo("SQL", "¡DATOS INSERTADOS CORRECTAMENTE!")


def BTNinsercion_sqlserver_sp():
    contador_tiempo = ContadorTiempo()
    conectar_con_sqlserver()

    contador = 0
    id_producto = str(entries["Id"].get())
    descripcion_valor = str(entries["Descripcion"].get())
    costo_valor = float(entries["Costo"].get())
    precio_valor = float(entries["Precio"].get())

    while not contador_tiempo.tiempo_expirado():
        sqlEx.ejecutar_procedimiento("PA_INSERTARPRODUCTO", (id_producto, descripcion_valor, costo_valor, precio_valor))

        contador += 1

    texto = f"Se insertaron {contador} registros en un minuto"
    entrada = result_entries["SQL SERVER_SP"]
    entrada.config(state="normal")
    entrada.delete(0, tk.END)
    entrada.insert(0, texto)
    entrada.config(state="readonly")

    messagebox.showinfo("SQL", "¡DATOS INSERTADOS CORRECTAMENTE!")


def BTNinsercion_mysql_lmd():
    contador_tiempo = ContadorTiempo()
    conectar_con_mysql()

    contador = 0
    id_producto = str(entries["Id"].get())
    descripcion_valor = str(entries["Descripcion"].get())
    costo_valor = float(entries["Costo"].get())
    precio_valor = float(entries["Precio"].get())

    while not contador_tiempo.tiempo_expirado():
        query = f"""INSERT INTO producto (id_producto, descripcion, costo, precio) VALUES ({id_producto},'{descripcion_valor}', {costo_valor}, {precio_valor})"""
        mysqlEx.ejecutar_sql(query)
        contador +=1

    texto = f"Se insertaron {contador} registros en un minuto"
    entrada = result_entries["MYSQL_LMD"]
    entrada.config(state="normal")
    entrada.delete(0, tk.END)
    entrada.insert(0, texto)
    entrada.config(state="readonly")

    messagebox.showinfo("SQL", "¡DATOS INSERTADOS CORRECTAMENTE!")


def BTNinsercion_mysql_sp():
    contador_tiempo = ContadorTiempo()
    conectar_con_mysql()

    contador = 0
    id_producto = str(entries["Id"].get())
    descripcion_valor = str(entries["Descripcion"].get())
    costo_valor = float(entries["Costo"].get())
    precio_valor = float(entries["Precio"].get())

    while not contador_tiempo.tiempo_expirado():
        mysqlEx.ejecutar_procedimiento("PA_INSERTARPRODUCTO", (id_producto, descripcion_valor, costo_valor, precio_valor))

        contador += 1

    texto = f"Se insertaron {contador} registros en un minuto"
    entrada = result_entries["MYSQL_SP"]
    entrada.config(state="normal")
    entrada.delete(0, tk.END)
    entrada.insert(0, texto)
    entrada.config(state="readonly")

    messagebox.showinfo("SQL", "¡DATOS INSERTADOS CORRECTAMENTE!")


def borrar_registros_oracle():
    conectar_con_oracle()
    oraEx.ejecutar_sql("DELETE FROM producto")
    oraEx.ejecutar_sql("DROP SEQUENCE PRODUCTO_SEQ")
    oraEx.ejecutar_sql("CREATE SEQUENCE PRODUCTO_SEQ START WITH 1 INCREMENT BY 1")
    # Limpiar los campos de resultado en la interfaz
    messagebox.showinfo("Éxito", "Registros borrados de Oracle")
    entradalmp = result_entries["ORACLE_LMD"]
    entradasp = result_entries["ORACLE_SP"]
    entradalmp.config(state="normal")
    entradasp.config(state="normal")
    entradalmp.delete(0, tk.END)
    entradasp.delete(0, tk.END)
    entradalmp.config(state="readonly")
    entradasp.config(state="readonly")


def borrar_registros_postgresql():
    conectar_con_postgres()
    psgEx.ejecutar_sql("DELETE FROM producto")
    psgEx.ejecutar_sql("ALTER SEQUENCE PRODUCTO_PK_ID_seq RESTART WITH 1")
    # Limpiar los campos de resultado en la interfaz
    messagebox.showinfo("Éxito", "Registros borrados de Postgres")
    entradalmp = result_entries["POSTGRES_LMD"]
    entradasp = result_entries["POSTGRES_SP"]
    entradalmp.config(state="normal")
    entradasp.config(state="normal")
    entradalmp.delete(0, tk.END)
    entradasp.delete(0, tk.END)
    entradalmp.config(state="readonly")
    entradasp.config(state="readonly")


def borrar_registros_sqlserver():
    conectar_con_sqlserver()
    sqlEx.ejecutar_sql("DELETE FROM producto")
    sqlEx.ejecutar_sql("DBCC CHECKIDENT ('PRODUCTO', RESEED, 0)")
    # Limpiar los campos de resultado en la interfaz
    messagebox.showinfo("Éxito", "Registros borrados de SQL Server")
    entradalmp = result_entries["SQL SERVER_LMD"]
    entradasp = result_entries["SQL SERVER_SP"]
    entradalmp.config(state="normal")
    entradasp.config(state="normal")
    entradalmp.delete(0, tk.END)
    entradasp.delete(0, tk.END)
    entradalmp.config(state="readonly")
    entradasp.config(state="readonly")


def borrar_registros_mysql():
    conectar_con_mysql()
    mysqlEx.ejecutar_sql("DELETE FROM PRODUCTO")
    mysqlEx.ejecutar_sql("TRUNCATE TABLE PRODUCTO")
    # Limpiar los campos de resultado en la interfaz
    messagebox.showinfo("Éxito", "Registros borrados de MySQL Server")
    entradalmp = result_entries["MYSQL_LMD"]
    entradasp = result_entries["MYSQL_SP"]
    entradalmp.config(state="normal")
    entradasp.config(state="normal")
    entradalmp.delete(0, tk.END)
    entradasp.delete(0, tk.END)
    entradalmp.config(state="readonly")
    entradasp.config(state="readonly")

def inserciones_consecutivas() -> int:
    numero_inserciones = int(entries["Número de Inserciones"].get())
    return numero_inserciones

def oracle_inser():
    conectar_con_oracle()
    contador = inserciones_consecutivas()

    id_producto = str(entries["Id"].get())
    descripcion_valor = str(entries["Descripcion"].get())
    costo_valor = float(entries["Costo"].get())
    precio_valor = float(entries["Precio"].get())

    for i in range (contador):
        oraEx.ejecutar_procedimiento("PA_INSERTARPRODUCTO", (id_producto, descripcion_valor, costo_valor, precio_valor))

    messagebox.showinfo("Exito", f"Se insertaron {contador} en la base de datos")

def postgres_inser():
    conectar_con_postgres()
    contador = inserciones_consecutivas()

    id_producto = str(entries["Id"].get())
    descripcion_valor = str(entries["Descripcion"].get())
    costo_valor = float(entries["Costo"].get())
    precio_valor = float(entries["Precio"].get())

    for i in range(contador):
        psgEx.ejecutar_procedimiento("PA_INSERTARPRODUCTO", (id_producto, descripcion_valor, costo_valor, precio_valor))

    messagebox.showinfo("Exito", f"Se insertaron {contador} en la base de datos")


def sqlserver_inser():
    conectar_con_sqlserver()
    contador = inserciones_consecutivas()

    id_producto = str(entries["Id"].get())
    descripcion_valor = str(entries["Descripcion"].get())
    costo_valor = float(entries["Costo"].get())
    precio_valor = float(entries["Precio"].get())

    for i in range(contador):
        sqlEx.ejecutar_procedimiento("PA_INSERTARPRODUCTO", (id_producto, descripcion_valor, costo_valor, precio_valor))

    messagebox.showinfo("Exito", f"Se insertaron {contador} en la base de datos")


def mysql_inser():
    conectar_con_mysql()
    contador = inserciones_consecutivas()

    id_producto = str(entries["Id"].get())
    descripcion_valor = str(entries["Descripcion"].get())
    costo_valor = float(entries["Costo"].get())
    precio_valor = float(entries["Precio"].get())

    for i in range(contador):
        mysqlEx.ejecutar_procedimiento("PA_INSERTARPRODUCTO", (id_producto, descripcion_valor, costo_valor, precio_valor))

    messagebox.showinfo("Exito", f"Se insertaron {contador} en la base de datos")


# Ventana principal
root = tk.Tk()
root.title("Gestión de Base de Datos")
root.geometry("810x750")

# Frame contenedor con Scrollbar
main_frame = tk.Frame(root)
main_frame.pack(fill=tk.BOTH, expand=True)

canvas = tk.Canvas(main_frame)
scrollbar = ttk.Scrollbar(main_frame, orient=tk.VERTICAL, command=canvas.yview)
scrollable_frame = ttk.Frame(canvas)

scrollable_frame.bind(
    "<Configure>",
    lambda e: canvas.configure(
        scrollregion=canvas.bbox("all")
    )
)

canvas.create_window((0, 0), window=scrollable_frame, anchor="nw")
canvas.configure(yscrollcommand=scrollbar.set)

canvas.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
scrollbar.pack(side=tk.RIGHT, fill=tk.Y)

# --- Contenido dentro del frame scrollable ---
scrollable_frame.columnconfigure(0, weight=1)

info_frame = ttk.LabelFrame(scrollable_frame, text="INFORMACIÓN")
info_frame.grid(row=0, column=0, columnspan=3, pady=10, padx=10, sticky="ew")
info_frame.columnconfigure(2, weight=1)

fields = {
    "Id": "1",
    "Descripcion": "Computadoras",
    "Costo": "170.50",
    "Precio": "200.75",
    "Número de Inserciones": "4"
}

entries = {}

for i, (field, default_value) in enumerate(fields.items()):
    ttk.Label(info_frame, text=f"{field}:").grid(row=i, column=1, padx=2, pady=2)
    entry = ttk.Entry(info_frame, width=70)
    entry.grid(row=i, column=2, padx=2, pady=2, sticky="ew")
    entry.insert(0, default_value)
    entries[field] = entry

info_conne = ttk.LabelFrame(scrollable_frame, text="CONEXIÓN")
info_conne.grid(row=1, column=0, columnspan=4, pady=10, padx=10, sticky="ew")

db_buttons = [
    ("Oracle", conectar_con_oracle),
    ("PostgreSQL", conectar_con_postgres),
    ("SQL Server", conectar_con_sqlserver),
    ("MySQL", conectar_con_mysql)
]

for i, (label, command) in enumerate(db_buttons):
    tk.Button(info_conne, text=f"Conectar a {label}", command=command, width=25).grid(row=0, column=i, padx=5, pady=2)

config_btn = tk.Button(scrollable_frame, text="Configurar Credenciales", width=40, command=lambda: DBConfigD(root))
config_btn.grid(row=2, column=0, columnspan=4, pady=(0,10), padx=10)

inser_db = ttk.LabelFrame(scrollable_frame, text="Realizar inserciones")
inser_db.grid(row=3, column=0, columnspan=4, pady=10, padx=10, sticky="ew")

inser_btn = [
    ("Oracle", oracle_inser),
    ("PostgreSQL", postgres_inser),
    ("SQL Server", sqlserver_inser),
    ("MySQL", mysql_inser)
]

for i, (label1, command1) in enumerate(inser_btn):
    tk.Button(inser_db, text=f"Insertar en {label1}", command=command1, width=25).grid(row=0, column=i, padx=5, pady=2)

result_entries = {}

sections = {
    "ORACLE": (BTNinsercion_oracle_lmd, borrar_registros_oracle, BTNinsercion_oracle_sp),
    "POSTGRES": (BTNinsercion_Postgresql_lmd, borrar_registros_postgresql, BTNinsercion_Postgresql_sp),
    "SQL SERVER": (BTNinsercion_sqlserver_lmd, borrar_registros_sqlserver, BTNinsercion_sqlserver_sp),
    "MYSQL": (BTNinsercion_mysql_lmd, borrar_registros_mysql, BTNinsercion_mysql_sp)
}

start_row = 4

for i, (section, (lmd, delete, sp)) in enumerate(sections.items(), start=start_row):
    frame = ttk.LabelFrame(scrollable_frame, text=section)
    frame.grid(row=i, column=0, columnspan=2, pady=10, padx=10, sticky="ew")
    frame.columnconfigure(1, weight=1)

    tk.Button(frame, text="Inserciones con LMD", command=lmd, width=25).grid(row=0, column=0, padx=5, pady=2)
    result_entry = ttk.Entry(frame, width=70, state="readonly")
    result_entry.grid(row=0, column=1, padx=2, pady=2, sticky="ew")
    result_entries[f"{section}_LMD"] = result_entry

    tk.Button(frame, text="Borrar Registros", command=delete, width=25).grid(row=1, column=0, padx=5, pady=2)

    tk.Button(frame, text="Inserciones con SP", command=sp, width=25).grid(row=2, column=0, padx=5, pady=2)
    result_entry_sp = ttk.Entry(frame, width=70, state="readonly")
    result_entry_sp.grid(row=2, column=1, padx=2, pady=2, sticky="ew")
    result_entries[f"{section}_SP"] = result_entry_sp

# Activar scroll con rueda del ratón
def _on_mousewheel(event):
    canvas.yview_scroll(int(-1 * (event.delta / 120)), "units")

canvas.bind_all("<MouseWheel>", _on_mousewheel)  # para Windows

root.mainloop()
