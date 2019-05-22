public class SmallCar extends Car {

	private final int seats;

	public SmallCar(int paramSeats) {
		super("Renault", 5, "Manual", "100");
		this.seats = paramSeats;
	}

	public String seatsNumber() {
		return "Este auto tiene espacio para " + seats + " personas.";
	}
}

