import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TrivialClass extends JFrame {
	private int turno = 0, posicionJugador1 = 0, posicionJugador2 = 0, puntuacionJugador1 = 0, puntuacionJugador2 = 0;
	private JPanel tablero = new JPanel();
	private BufferedImage jugador1 = null;
	private BufferedImage jugador2 = null;
	private BufferedImage jugadorMeta1 = null;
	private BufferedImage jugadorMeta2 = null;
	private BufferedImage pasto = null;
	private BufferedImage meta = null;

	private JLabel imagenesJugador1[] = new JLabel[8];
	private JLabel imagenesJugador2[] = new JLabel[8];

	public TrivialClass() {

		super("Trivial");
		setSize(1200, 380);
		setLocationRelativeTo(null);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		Container cp = getContentPane();

		cp.setLayout(new GridBagLayout());
		cp.setBackground(Color.decode("#E2F99D"));

		tablero.setLayout(new GridLayout(2, 1));
		panel.setLayout(new GridBagLayout());

		GridBagConstraints posicionBoton = new GridBagConstraints();
		posicionBoton.gridx = 0;
		posicionBoton.gridy = 0;
		posicionBoton.insets = new Insets(0, 0, -200, 0);

		GridBagConstraints tableroConstraint = new GridBagConstraints();
		tableroConstraint.gridx = 0;
		tableroConstraint.gridy = 0;
		tableroConstraint.insets = new Insets(100, 200, 10, 200);

		GridBagConstraints posicionPuntuacion = new GridBagConstraints();
		posicionPuntuacion.gridx = 0;
		posicionPuntuacion.gridy = 0;
		posicionPuntuacion.insets = new Insets(0, 700, 320, 0);

		GridBagConstraints posicionTurno = new GridBagConstraints();
		posicionTurno.gridx = 0;
		posicionTurno.gridy = 0;
		posicionTurno.insets = new Insets(0, 0, 320, 700);

		GridBagConstraints posicionJugador = new GridBagConstraints();
		posicionJugador.gridx = 0;
		posicionJugador.gridy = 0;
		posicionJugador.insets = new Insets(0, 0, 320, 110);

		GridBagConstraints posicionTablero = new GridBagConstraints();
		posicionTablero.gridx = 0;
		posicionTablero.gridy = 0;
		posicionTablero.insets = new Insets(0, 0, 0, 0);

		GridBagConstraints posicionPanel = new GridBagConstraints();
		posicionPanel.gridx = 0;
		posicionPanel.gridy = 0;
		posicionPanel.insets = new Insets(0, 0, 320, 150);

		JLabel textoJugador = new JLabel(" Jugador: asdasd ");
		JLabel textoTurno = new JLabel("Turno: " + turno);
		JLabel textoPuntuacion = new JLabel(
				"Puntuacion: Jugador1 " + puntuacionJugador1 + " Jugador2 " + puntuacionJugador2);

		textoJugador.setFont(new Font("Sans-Serif", Font.BOLD, 18));
		textoTurno.setFont(new Font("Sans-Serif", Font.BOLD, 18));
		textoPuntuacion.setFont(new Font("Sans-Serif", Font.BOLD, 18));

		JPanel panelTextoJugador = new JPanel();
		panelTextoJugador.setBackground(Color.decode("#CDFA4A"));

		Border borde = BorderFactory.createLineBorder(Color.black);
		panelTextoJugador.setLayout(new GridBagLayout());
		panelTextoJugador.setBorder(borde);

		try {
			jugador1 = ImageIO.read(new File("caballo.PNG"));
			jugador2 = ImageIO.read(new File("caballo2.PNG"));
			jugadorMeta1 = ImageIO.read(new File("caballoMeta.PNG"));
			jugadorMeta2 = ImageIO.read(new File("caballoMeta2.PNG"));
			pasto = ImageIO.read(new File("pasto.jpg"));
			meta = ImageIO.read(new File("meta.jpg"));
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JPanel panelTextoTurno = new JPanel();

		panelTextoTurno.setBackground(Color.decode("#CDFA4A"));
		panelTextoTurno.setBorder(borde);
		panelTextoTurno.add(textoTurno);

		JPanel panelTextoPuntuacion = new JPanel();

		panelTextoPuntuacion.setBackground(Color.decode("#CDFA4A"));
		panelTextoPuntuacion.setBorder(borde);
		panelTextoPuntuacion.add(textoPuntuacion);

		Border bordeTablero = BorderFactory.createLineBorder(Color.black);

		imagenesJugador1[0] = new JLabel(new ImageIcon(jugador1));
		imagenesJugador2[0] = new JLabel(new ImageIcon(jugador2));

		for (int i = 1; i < (imagenesJugador1.length - 1); i++) {

			imagenesJugador1[i] = new JLabel(new ImageIcon(pasto));
			imagenesJugador2[i] = new JLabel(new ImageIcon(pasto));

		}
		imagenesJugador1[7] = new JLabel(new ImageIcon(meta));
		imagenesJugador2[7] = new JLabel(new ImageIcon(meta));

		Button botonPregunta = new Button("Preguntas");
		botonPregunta.setPreferredSize(new Dimension(10, 10));
		botonPregunta.setBackground(Color.decode("#CDFA4A"));
		botonPregunta.setFont(new Font("Sans-Serif", Font.BOLD, 18));
		botonPregunta.addActionListener(new EventAumentarPosicioJugador());

		for (int i = 0; i < imagenesJugador1.length; i++) {
			imagenesJugador1[i].setPreferredSize(new Dimension(100, 40));
			tablero.add(imagenesJugador1[i], tableroConstraint);
		}
		for (int i = 0; i < imagenesJugador1.length; i++) {
			imagenesJugador2[i].setPreferredSize(new Dimension(100, 40));
			tablero.add(imagenesJugador2[i], tableroConstraint);
		}
		panel.add(botonPregunta, posicionBoton);
		tablero.setBorder(bordeTablero);
		tablero.setPreferredSize(new Dimension(100, 100));

		panelTextoJugador.add(textoJugador);
		panel.add(panelTextoTurno, posicionTurno);
		panel.add(panelTextoJugador, posicionJugador);
		panel.add(panelTextoPuntuacion, posicionPuntuacion);

		cp.add(panelTextoJugador, posicionJugador);
		cp.add(panelTextoPuntuacion, posicionPuntuacion);
		cp.add(panelTextoTurno, posicionTurno);
		cp.add(tablero, posicionTablero);
		cp.add(botonPregunta, posicionBoton);

	}

	// Recoger
	class EventAumentarPosicioJugador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (turno % 2 == 0) {
				imagenesJugador1[posicionJugador1].setIcon(new ImageIcon(pasto));
				posicionJugador1++;
				imagenesJugador1[posicionJugador1].setIcon(new ImageIcon(jugador1));
				System.out.println(posicionJugador1);
			} else {
				imagenesJugador2[posicionJugador2].setIcon(new ImageIcon(pasto));
				posicionJugador2++;
				imagenesJugador2[posicionJugador2].setIcon(new ImageIcon(jugador2));
				System.out.println(posicionJugador2);
			}
			turno++;
			if (posicionJugador1 == 7) {

				imagenesJugador1[posicionJugador1].setIcon(new ImageIcon(jugadorMeta1));

			}else if(posicionJugador2 == 7) {
				imagenesJugador2[posicionJugador2].setIcon(new ImageIcon(jugadorMeta2));

			}

		}

	}

}
