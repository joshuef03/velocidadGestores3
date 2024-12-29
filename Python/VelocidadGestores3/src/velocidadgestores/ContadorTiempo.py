import datetime


class ContadorTiempo:
    def __init__(self):
        self.tiempo_inicio = datetime.datetime.now()
        self.tiempo_fin = self.tiempo_inicio + datetime.timedelta(minutes=1)

    def tiempo_expirado(self):
        """Verifica si el minuto ha pasado"""
        return datetime.datetime.now() >= self.tiempo_fin

    # def __init__(self):
    #     self.tiempo = datetime.datetime.now()
    #     self.hora_ahora = self.tiempo.hour
    #     self.minuto_ahora = self.tiempo.minute
    #     self.segundo_ahora = self.tiempo.second
    #
    #     self.tiempo = self.tiempo + datetime.timedelta(minutes=1)
    #
    #     self.hora_despues = self.tiempo.hour
    #     self.minuto_despues = self.tiempo.minute
    #     self.segundo_despues = self.tiempo.second
    #
    # def print_valores(self):
    #     print("Hora actual:", self.hora_ahora)
    #     print("Minuto actual:", self.minuto_ahora)
    #     print("Segundo actual:", self.segundo_ahora)
    #     print("Hora después:", self.hora_despues)
    #     print("Minuto después:", self.minuto_despues)
    #     print("Segundo después:", self.segundo_despues)
