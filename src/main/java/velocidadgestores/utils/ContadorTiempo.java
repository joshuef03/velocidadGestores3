/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velocidadgestores.utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Calendar;

/**
 *
 * @author MCROBERTW
 */

public class ContadorTiempo {
	private LocalDateTime ahora;
	private LocalDateTime unMinutoDespues;

	// Constructor para inicializar los tiempos
	public ContadorTiempo() {
		this.ahora = LocalDateTime.now();
		this.unMinutoDespues = ahora.plusMinutes(1);
	}

	// Métodos para obtener la hora, minuto y segundo actuales
	public int getHoraAhora() {
		return ahora.getHour();
	}

	public int getMinutoAhora() {
		return ahora.getMinute();
	}

	public int getSegundoAhora() {
		return ahora.getSecond();
	}

	// Métodos para obtener la hora, minuto y segundo después de un minuto
	public int getHoraDespues() {
		return unMinutoDespues.getHour();
	}

	public int getMinutoDespues() {
		return unMinutoDespues.getMinute();
	}

	public int getSegundoDespues() {
		return unMinutoDespues.getSecond();
	}

	// Método para formatear el tiempo en una cadena de texto
	public String getFormattedTiempoAhora() {
		return ahora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	public String getFormattedTiempoDespues() {
		return unMinutoDespues.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}


/*public class ContadorTiempo {
    int horaAhora, minutoAhora, segundoAhora;
	int horaDespues, minutoDespues, segundoDespues;
	Calendar tiempo =Calendar.getInstance();


	public void ContadorTiempo()
	{

		horaAhora=tiempo.get(Calendar.HOUR);
		minutoAhora=tiempo.get(Calendar.MINUTE);
		segundoAhora=tiempo.get(Calendar.SECOND);

		tiempo.roll(Calendar.MINUTE, true);

		horaDespues=tiempo.get(Calendar.HOUR);
		minutoDespues=tiempo.get(Calendar.MINUTE);
		segundoDespues=tiempo.get(Calendar.SECOND);

		*//*System.out.println(horaAhora);
		System.out.println(minutoAhora);
		System.out.println(segundoAhora);

		System.out.println(horaDespues);
		System.out.println(minutoDespues);
		System.out.println(segundoDespues);*//*
}
}*/
