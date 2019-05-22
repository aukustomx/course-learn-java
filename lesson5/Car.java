public class Car {

	//Estos fields o atributos representan el estado (state) del objeto
	private final String brand;
	private final int gears;
	private final String transmission;
	private final String hp;

	public Car(String aBrand, int aGear, String aTr, String aHp) {
		this.brand = aBrand;
		this.gears = aGear;
		this.transmission = aTr;
		this.hp = aHp;
	}

	//Y el comportamiento se representa a través métodos
	public String stop() {
		return "Frenando...";
	}

	public String accelerate() {
		return "Acelerando...";
	}

	public String showState() {
		return "Marca: " + brand + " Velocidades: " + gears + "HP: " + hp;
	}
}

