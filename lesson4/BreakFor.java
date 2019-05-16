class BreakFor {

    public static void main(String[] args) {
        
        int[] randomNumbers = generateRandomNumbers();

	for (int i = 0; i < randomNumbers.length; i++) {
	    
	    if (randomNumbers[i] == 5) {
	    	System.out.println("El 5 aparece en la posición: " + i);
		break;
	    }
	}
    }


    //No poner mucha atención a este método. Es para simular el arreglo
    // de número aleatorios de entrada.
    private static int[] generateRandomNumbers() {
		
        int[] randomNumbers = new int[10];
	System.out.println("El arreglo random generado es: ");
	for (int i = 0; i < randomNumbers.length; i++) {
	    randomNumbers[i] = (int) (Math.random() * 10 + 1);
	    System.out.print(randomNumbers[i]);
	}
	
	System.out.println();
	return randomNumbers;
    }
}

