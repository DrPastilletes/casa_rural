package hotel;

public class Habitacio {
	private int numHabitacio, numPersones;

	public Habitacio(int numHabitacio, int numPersones) {
		super();
		this.numHabitacio = numHabitacio;
		this.numPersones = numPersones;
	}

	public Habitacio() {
		super();
	}

	public int getNumHabitacio() {
		return numHabitacio;
	}

	public void setNumHabitacio(int numHabitacio) {
		this.numHabitacio = numHabitacio;
	}

	public int getNumPersones() {
		return numPersones;
	}

	public void setNumPersones(int numPersones) {
		this.numPersones = numPersones;
	}
	
	
}
