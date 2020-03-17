package hotel;

public class Reserva {
	private Habitacio habitacio;
	private Client client;
	public Reserva(Habitacio habitacio, Client client) {
		super();
		this.habitacio = habitacio;
		this.client = client;
	}
	public Reserva() {
		super();
	}
	public Habitacio getHabitacio() {
		return habitacio;
	}
	public void setHabitacio(Habitacio habitacio) {
		this.habitacio = habitacio;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
