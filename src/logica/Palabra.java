package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Palabra {

	private String[] posiblesPalabras;
	private String[] palabrasAleatorias;
	private String palabraSecreta;
	private char[] caracterSecretos;
	private char[] input;

	public Palabra() {
		this.posiblesPalabras = cargarPalabras();
		this.palabraSecreta = crearPalabraAleatoria();
		this.caracterSecretos = new char[5];
		this.cargaCaraterSecretos();
		this.input = new char[5];
	}

	public boolean esValidaPalabra(String palabra) {
		if (palabra.length() < 5) {
			System.out.println("Wordle: La palabra que ingresó no era lo suficientemente larga");
			return false;
		}
		for (String p : posiblesPalabras) {
			if (p.equals(palabra)) {
				return true;
			}
		}
		return false;
	}

	private void cargaCaraterSecretos() {
		for (int i = 0; i < 5; i++) {
			caracterSecretos[i] = palabraSecreta.charAt(i);
		}
	}

	private String[] cargarPalabras() {
		// hace una matriz de las palabras posibles (12947 lines long)
		posiblesPalabras = new String[12947];
		try { // La direccion donde esta el txt que tiene las palabras cargadas
			File myObj = new File("D:\\Programacion 3\\TP\\src\\logica\\wordleWords.txt");
			Scanner myReader = new Scanner(myObj);
			int indexCounter = 0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				// add data to the array
				posiblesPalabras[indexCounter] = data;
				indexCounter++;
			}

			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return posiblesPalabras;
	}

	private String crearPalabraAleatoria() {
		palabrasAleatorias = new String[2315];
		try { // La direccion donde esta el txt que tiene las palabras aleatorias
			File myObj = new File("D:\\Programacion 3\\TP\\src\\logica\\wordleAnswers.txt");
			Scanner myReader = new Scanner(myObj);
			int indexCounter = 0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				// add data to the array
				palabrasAleatorias[indexCounter] = data;
				indexCounter++;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		// devuelve una palabra aleatoria del tamaño de la lista
		return palabrasAleatorias[(int) (Math.random() * (palabrasAleatorias.length - 1))];

	}
	
	

	public String[] getPosiblesPalabras() {
		return posiblesPalabras;
	}

	public void setPosiblesPalabras(String[] posiblesPalabras) {
		this.posiblesPalabras = posiblesPalabras;
	}

	public String[] getPalabrasAleatorias() {
		return palabrasAleatorias;
	}

	public void setPalabrasAleatorias(String[] palabrasAleatorias) {
		this.palabrasAleatorias = palabrasAleatorias;
	}

	public String getPalabraSecreta() {
		return palabraSecreta;
	}

	public void setPalabraSecreta(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
	}

	public char[] getCaracterSecretos() {
		return caracterSecretos;
	}

	public void setCaracterSecretos(char[] caracterSecretos) {
		this.caracterSecretos = caracterSecretos;
	}

	public char[] getInput() {
		return input;
	}

	public void setInput(char[] input) {
		this.input = input;
	}

	@Override
	public String toString() {
		return "Palabra [posiblesPalabras=" + Arrays.toString(posiblesPalabras) + "]";
	}

	public static void main(String[] args) {
		Palabra p = new Palabra();
		System.out.println(p.toString());
	}

}
