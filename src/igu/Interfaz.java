package igu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logica.Juego;
import java.awt.Font;
import java.awt.Color;

public class Interfaz implements ActionListener {

	private static JPanel panel;
	private static JFrame frame;

	private static JLabel Title;
	private static JLabel mensajeFinal;
	private static JLabel[] labels;

	private static JTextField textoIngresado;
	private static Juego juego;

	public static void main(String[] args) throws FileNotFoundException {
		panel = new JPanel();
		frame = new JFrame();
		frame.setSize(220, 300);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("GUI");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		Title = new JLabel("Wordle: ");
		Title.setFont(new Font("Tahoma", Font.BOLD, 11));
		Title.setBounds(10, 20, 80, 25);
		panel.add(Title);

		mensajeFinal = new JLabel("Escriba una palabra de cinco letras");
		mensajeFinal.setFont(new Font("Tahoma", Font.BOLD, 10));
		mensajeFinal.setBounds(10, 50, 180, 30);
		panel.add(mensajeFinal);

		textoIngresado = new JTextField();
		textoIngresado.addActionListener(new Interfaz());
		textoIngresado.setBounds(40, 80 + (0 * 25), 80, 25);
		panel.add(textoIngresado);
		textoIngresado.setColumns(10);

		JButton btnEnter = new JButton("Enter");
		btnEnter.setForeground(Color.DARK_GRAY);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnter.setBounds(100, 20, 80, 25);
		btnEnter.addActionListener(new Interfaz());
		panel.add(btnEnter);

		// Dibuja las lineas donde van los caracteres
		labels = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			labels[i] = new JLabel("<html><font size='6' color=blue> - - - - - </font> <font");
			labels[i].setBounds(44, 80 + (i * 26), 80, 25);
			panel.add(labels[i]);
		}

		frame.setVisible(true);

		// Inicio de juego
		juego = new Juego();

		// Palabras validas
		System.out.println(juego.getPalabra().toString());

	}

	public static void finWordle() {
		String palabraSecreta = juego.getPalabra().getPalabraSecreta();
		long duracionDelJuego = juego.tiempoDeJuego();
		int intentos = juego.getIntentos();
		String palabraIngresada = textoIngresado.getText();

		textoIngresado.setEnabled(false);
		textoIngresado.setVisible(false);

		if (palabraIngresada.equalsIgnoreCase(palabraSecreta)) {
			mensajeFinal.setText("<html><font size='1' color=green> " + "Encontraste la respuesta en \n "
					+ duracionDelJuego + " segundos y " + intentos + " intentos." + "</font> <font");
		} else {
			mensajeFinal.setText("<html><font size='1' color=red> " + "la palabraSecreta fue: " + palabraSecreta
					+ ". desperdiciastes \n " + duracionDelJuego + " segundos" + " y " + intentos + " intentos"
					+ "</font> <font");
		}
	}

	public static void enterWord() { // si es valido, en realidad envía la palabra para verificar
		boolean esValidoTexto = juego.getPalabra().esValidaPalabra(textoIngresado.getText());
		if (esValidoTexto) {
			botonPresionado();
		}
	}

	private static void botonPresionado() {
		int intentos = juego.getIntentos();
		boolean terminado = juego.isTerminado();
		String palabraSecreta = juego.getPalabra().getPalabraSecreta();
		char[] caracterSecretos = juego.getPalabra().getCaracterSecretos();

		String userInput = textoIngresado.getText(); // Obtengo lo tecleado por el user
		int[] colorOfLetters = juego.validarCaracter(userInput);

		//Mueve y cambia el tamaño de este componente. La nueva ubicación de la parte superior
		//izquierda la esquina está especificada por {@code x} y {@code y}, y el nuevo tamaño se 
		//especifica mediante {@code width} y {@code height}.
		textoIngresado.setBounds(40, 80 + ((intentos + 1) * 25), 80, 25);
		terminado = true;
		for (int i : colorOfLetters) {
			if (i != 2) {
				terminado = false;
			}
			if (terminado || intentos > 4) {
				finWordle();
			}
		}
			// Selecciona el color del caracter
		String[] numsToColors = new String[5];
		for (int i = 0; i < 5; i++) {
	            if (colorOfLetters[i] == 0) 
			    numsToColors[i] = "black";
	            else if (colorOfLetters[i] == 1) 
			    numsToColors[i] = "orange";
	            else if (colorOfLetters[i] == 2) 
			    numsToColors[i] = "green";
	        }

			System.out.println("Establecer colores para " + numsToColors[0] + " " + numsToColors[1] + " "
					+ numsToColors[2] + " " + numsToColors[3] + " " + numsToColors[4] + " La entrada del usuario fue "
					+ userInput + " la respuesta fue " + palabraSecreta + " prueba con estas palabras "
					+ new String(caracterSecretos));

			String finalString = (
			        "<html><font size='5' color=" + numsToColors[0] + "> " + userInput.charAt(0) + "</font> <font            " + 
			                "<html><font size='5' color=" + numsToColors[1] + "> " + userInput.charAt(1) + "</font> <font            " + 
			                "<html><font size='5' color=" + numsToColors[2] + "> " + userInput.charAt(2) + "</font> <font            " + 
			                "<html><font size='5' color=" + numsToColors[3] + "> " + userInput.charAt(3) + "</font> <font            " + 
			                "<html><font size='5' color=" + numsToColors[4] + "> " + userInput.charAt(4) + "</font> <font            ");

			siguienteLabel(finalString);
			textoIngresado.setText(""); // establece el cuadro de texto en "" después de que se haya //realizado toda la lógica
		
	}

	//Escribe la palabra en el siguiente intento
	public static void siguienteLabel(String palabraConColor) {
		int intentos = juego.getIntentos();
		labels[intentos - 1].setText(palabraConColor);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		enterWord();
	}

}
