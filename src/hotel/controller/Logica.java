package hotel.controller;

import java.security.DrbgParameters.Capability;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;


import model.*;

public class Logica {
	private Hotel hotel;
	public Logica() {
		hotel = new Hotel();
	}
	
	public Client crearClient(JTextField nom, JTextField cognoms, JTextField dni) {
		Client cli = new Client(nom.getText(),cognoms.getText(),dni.getText());	
		return cli;
	}
	
	public Reserva crearReserva(Client cli, LocalDate diaEntrada, LocalDate diaSortida, JTextField numPersones) {
		Reserva res = new Reserva(cli, diaEntrada, diaSortida, Integer.parseInt(numPersones.getText()));
		return res;
	}
	
	public void crearHabitacio(JTextField numHabitacio, JTextField numPersones) {
		int numHab = Integer.parseInt(numHabitacio.getText());
		int numPers = Integer.parseInt(numPersones.getText());

		for(Habitacio habi : hotel.getLlistaHab()) {
			if(habi.getNumHabitacio()==numHab) {
				String[] options = {"Si","No"};
                int opcio = JOptionPane.showOptionDialog(null, "Estas segur que vols modificar de "+habi.getNumPersones()+" persones a "+ numHab+"?", "Avís", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options, options[0]);
				switch (opcio) {
				case 0:
					String[] options2 = {"Ok"};
					JOptionPane.showOptionDialog(null, "S'ha modificat la habitació!", "Avís", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options2, options2[0]);
					habi.setNumPersones(numPers);
					afegirHabitacioHotel(habi);
					break;

				case 1:
					String[] options1 = {"Ok"};
					JOptionPane.showOptionDialog(null, "No s'ha modificat la habitació!", "Avís", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, options1, options1[0]);
					break;
				}
                
			}
		}
		
		Habitacio hab = new Habitacio(numHab, numPers);
		afegirHabitacioHotel(hab);
	}
	
	public void afegirClientHotel(Client cli) {
		hotel.getLlistaClients().add(cli);
	}
	
	public void afegirReservaHotel(Reserva res) {
		hotel.getLlistaReservesPendents().add(res);
	}
	
	public void afegirHabitacioHotel(Habitacio habitacio) {
		hotel.getLlistaHab().add(habitacio);
	}
	
	public boolean nomesLletres(String text) {
		if (text.matches("^[A-Za-z\\s]{2,}[\\.]{0,1}[A-Za-z\\s]{0,}$")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean nomesNumeros(String text) {
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
	
	public boolean comprovarSiClientExisteix(JTextField dni, JTextField nom, JTextField cognoms) {
		boolean clientExistent = false;
		for (Client cli : hotel.getLlistaClients()) {
			if(cli.getDni().equalsIgnoreCase(dni.getText())) {
				clientExistent = true;
				if(cli.getNom().equalsIgnoreCase(nom.getText())) {
					if(cli.getCognoms().equalsIgnoreCase(cognoms.getText())) {
						clientExistent = false;
					}
				}
			}
		}
		return clientExistent;
	}
	
	public static LocalDate calcularLocalDateAmbDate(Date data) {
		long millisDate = data.getTime();
		LocalDate dia = Instant.ofEpochMilli(millisDate).atZone(ZoneId.systemDefault()).toLocalDate();
		return dia;
	}
	
	public Reserva comprovarCapacitatHabitacio(Reserva res) {
		for(int i=0;i<2;i++) {
			for(Habitacio hab : hotel.getLlistaHab()) {
				Integer numHab = hab.getNumHabitacio();
				if((hab.getNumPersones()-i)==res.getNumPersones()) {
					if(hotel.getLlistaReservesPendents().size()==0) {
						Habitacio h = new Habitacio();
						res.setHabitacio(h);
						res.getHabitacio().setNumHabitacio(hab.getNumHabitacio());
						afegirReservaHotel(res);
						return res;
					}
					if(comprovarDisponibilitatHabitacio(res, hab.getNumHabitacio())) {
						System.out.println("He afegit una reserva!");
						Habitacio h = new Habitacio();
						res.setHabitacio(h);
						res.getHabitacio().setNumHabitacio(hab.getNumHabitacio());
						System.out.println("Habitacio: "+res.getHabitacio());
						afegirReservaHotel(res);
						return res;
					}
				}
			}
			if(i==1) {
				return null;
			}
		}
		return res;
	}
	
	public boolean comprovarDisponibilitatHabitacio(Reserva res, Integer numHabitacio) {
		boolean comprovarData = false;
		LocalDate diaEntrada = res.getDiaEntrada();
		LocalDate diaSortida = res.getDiaSortida();
		for(Reserva resIterador : hotel.getLlistaReservesPendents()) {
			System.out.println(resIterador.toString());
			if(numHabitacio==resIterador.getHabitacio().getNumHabitacio()) {
				System.out.println("Titan");
				comprovarData = true;
				if (diaEntrada.isAfter(resIterador.getDiaSortida()) || diaSortida.isBefore(resIterador.getDiaEntrada()) || diaEntrada.equals(resIterador.getDiaSortida())) {
					System.out.println("Data fora de rang");
					return true;
				}
			}
		}
		System.out.println("Abans del IF");
		if(comprovarData) {
			System.out.println("Dintre If");
			return false;
		}
		System.out.println("Despres del If");
		return true;
	}
	
}
