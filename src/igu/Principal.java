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

public class Principal implements ActionListener {

	private static JPanel panel;
	private static JFrame frame;

	private static JLabel Title;
	private static JLabel stats;
	private static JLabel[] labels;

	private static JTextField userText1;
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
		Title.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		Title.setBounds(10, 20, 80, 25);
		panel.add(Title);

		panel.setLayout(null);
		stats = new JLabel("Escriba una palabra de cinco letras");
		stats.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		stats.setBounds(10, 50, 180, 25);
		panel.add(stats);

		userText1 = new JTextField();
		userText1.addActionListener(new Principal());
		userText1.setBounds(40, 80 + (0 * 25), 80, 25);
		panel.add(userText1);
		userText1.setColumns(10);

		JButton btnEnter = new JButton("Enter");
		btnEnter.setForeground(Color.DARK_GRAY);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnter.setBounds(100, 20, 80, 25);
		btnEnter.addActionListener(new Principal());
		panel.add(btnEnter);

		// JLabel winScreen = new JLabel("Good Luck Have Fun Mate!");
		// winScreen.setBounds(10, 50, 350, 25);

		labels = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			labels[i] = new JLabel("<html><font size='6' color=blue> ----- </font> <font");
			labels[i].setBounds(44, 80 + (i * 25), 80, 25);
			panel.add(labels[i]);
		}

		frame.setVisible(true);

		juego = new Juego();

		// Palabras validas 
		System.out.println(juego.getPalabra().toString());

	}

	public static void EndWordle() {
		String palabraSecreta = juego.getPalabra().getPalabraSecreta();
		long duracionDelJuego = juego.tiempoDeJuego();
		int intentos = juego.getTries();
		String palabraIngresada = userText1.getText();

		System.out.println("Wordle: la palabraSecreta fue: " + new String(palabraSecreta));
		System.out.println("Wordle: Encontraste la respuesta en "
				+ duracionDelJuego + " segundos y " + intentos + " intentos.");

		userText1.setEnabled(false);
		userText1.setVisible(false);

		if (palabraIngresada.equalsIgnoreCase(palabraSecreta)) {
			stats.setText("<html><font size='1' color=green> " + "Encontraste la respuesta en \n "
					+ duracionDelJuego + " segundos y " + intentos + " intentos."
					+ "</font> <font");
		} else {
			stats.setText("<html><font size='1' color=red> " + "la palabraSecreta fue: " + new String(palabraSecreta)
					+ ". desperdiciastes \n " + duracionDelJuego
					+ " segundos (:" + "</font> <font");
		}
	}

	public static void enterWord() {// si es valido, en realidad envía la palabra para verificar
		boolean esValidoTexto = juego.getPalabra().esValidaPalabra(userText1.getText());
		if (esValidoTexto) {
			ButtonPressed();
		}
	}

	private static void ButtonPressed() {
		int intentos = juego.getTries();
		boolean terminado = juego.isTerminado();
		String palabraSecreta = juego.getPalabra().getPalabraSecreta();
		char[] caracterSecretos = juego.getPalabra().getCaracterSecretos();

		String userInput = userText1.getText(); // Obtengo lo tecleado por el user
		int[] colorOfLetters = juego.PlayWordle(userInput);

		userText1.setBounds(40, 80 + ((intentos + 1) * 25), 80, 25);

		terminado = true;
		for (int i : colorOfLetters) {
			if (i != 2)
				terminado = false;
		}
		if (terminado || intentos > 4) {
			EndWordle();
		}

		String[] numsToColors = new String[5];
		for (int i = 0; i < 5; i++) {
			if (colorOfLetters[i] == 0)
				numsToColors[i] = "gray";
			else if (colorOfLetters[i] == 1)
				numsToColors[i] = "yellow";
			else if (colorOfLetters[i] == 2)
				numsToColors[i] = "green";
		}

		System.out.println("Establecer colores para " + numsToColors[0] + " " + numsToColors[1] + " " + numsToColors[2]
				+ " " + numsToColors[3] + " " + numsToColors[4] + " La entrada del usuario fue " + userInput
				+ " la respuesta fue " + palabraSecreta + " prueba con estas palabras " + new String(caracterSecretos));
		
		String finalString = ("<html><font size='5' color=" + numsToColors[0] + "> " + userInput.charAt(0)
				+ "</font> <font            " + "<html><font size='5' color=" + numsToColors[1] + "> "
				+ userInput.charAt(1) + "</font> <font            " + "<html><font size='5' color=" + numsToColors[2]
				+ "> " + userInput.charAt(2) + "</font> <font            " + "<html><font size='5' color="
				+ numsToColors[3] + "> " + userInput.charAt(3) + "</font> <font            "
				+ "<html><font size='5' color=" + numsToColors[4] + "> " + userInput.charAt(4)
				+ "</font> <font            ");
		setNextLabel(finalString);

		userText1.setText(""); // establezca el cuadro de texto en "" después de que se haya realizado toda la lógica
							

	}

	public static void setNextLabel(String string) {
		int intentos = juego.getTries();
		labels[intentos - 1].setText(string);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		enterWord();
	}

}
