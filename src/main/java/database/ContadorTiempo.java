/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.Calendar;

/**
 *
 * @author MCROBERTW
 */
public class ContadorTiempo {
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

		/*System.out.println(horaAhora);
		System.out.println(minutoAhora);
		System.out.println(segundoAhora);

		System.out.println(horaDespues);
		System.out.println(minutoDespues);
		System.out.println(segundoDespues);*/
}
}
