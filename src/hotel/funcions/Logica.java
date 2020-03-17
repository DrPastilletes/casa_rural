package hotel.funcions;

import java.awt.Component;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Logica {
	public static boolean nomesLletres(String text) {
		if (text.matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean nomesNumeros(String text) {
		if (text.isBlank()) {
			return false;
		}else {
			if (text.matches("^[0-9]*$")) {
				return true;
			}else {
				return false;
			}	
		}
		
	}
	
	public static LocalDate calcularLocalDateAmbDate(Date data) {
		long millisDate = data.getTime();
		LocalDate dia = Instant.ofEpochMilli(millisDate).atZone(ZoneId.systemDefault()).toLocalDate();
		return dia;
	}
}
