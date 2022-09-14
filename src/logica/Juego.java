package logica;

import java.util.Scanner;

public class Juego {

	public static Scanner s = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
	
	private Palabra palabra;
	private int tries;
	private long startTime;
	private boolean terminado;

	public Juego() {
		this.palabra = new Palabra();
		this.tries = 0;
		this.terminado = false;
		this.startTime = System.currentTimeMillis();
		System.out.println("Wordle: Escriba una palabra de 5 letras");
		
	}

	public long tiempoDeJuego() {
		
		return ((System.currentTimeMillis() - startTime) / 1000);
	}
	
	public int[] PlayWordle(String InputWordleWord) {
		terminado = false;
		tries++;
		char[] input = palabra.getInput();
		char[] caracterSecretos = palabra.getCaracterSecretos();

		String R1 = InputWordleWord.toLowerCase();// String R1 = s.nextLine().toLowerCase();

		// comprueba si son 5 letras y si es una palabra posible
		if (!palabra.esValidaPalabra(R1)) {
			System.out.println("no fue una buena palabra");
		} else {
			for (int i = 0; i < 5; i++) { // pone el inputWord en un char[]
				input[i] = R1.charAt(i);
			}
		}
		// solo reinicia la respuesta cada vez palabraSecreta
		for (int i = 0; i < 5; i++) {
			caracterSecretos[i] = palabra.getPalabraSecreta().charAt(i);
		}
		return returnColorOfLeters(input, caracterSecretos);
	}

	private int[] returnColorOfLeters(char[] inputWord, char[] correctWord) {
		char[] answerTemp = correctWord;
		
		int[] colorForLetter = new int[5]; 	// 0 is grey, yellow is 1, green is 2

		for (int i = 0; i < 5; i++) { 		// comprueba si hay alguna posición correcta + letra (verde)
			if (inputWord[i] == answerTemp[i]) {
				answerTemp[i] = '-';
				colorForLetter[i] = 2;
			}
		}

		for (int j = 0; j < 5; j++) { // comprueba si hay alguna letra correcta (amarillo)
			for (int k = 0; k < 5; k++) {
				if (inputWord[j] == answerTemp[k] && colorForLetter[j] != 2) {
					// si esa letra no es ya verde y coincide con alguna otra letra
					colorForLetter[j] = 1;
					answerTemp[k] = '-';
				}
			}
		}

		for (int m = 0; m < 5; m++) {
			if (colorForLetter[m] == 0)
				System.out.print(inputWord[m]);
			if (colorForLetter[m] == 1)
				System.out.print(ANSI_YELLOW + inputWord[m] + ANSI_RESET);
			if (colorForLetter[m] == 2)
				System.out.print(ANSI_GREEN + inputWord[m] + ANSI_RESET);
		}

		System.out.println("");
		return colorForLetter;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	public Palabra getPalabra() {
		return palabra;
	}

	public void setPalabra(Palabra palabra) {
		this.palabra = palabra;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

//	public static void main(String[] args) {
//	Juego juego = new Juego();
//	System.out.println(juego.toString());
//}

}
