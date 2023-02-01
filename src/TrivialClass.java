import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TrivialClass extends JFrame{
	public TrivialClass() {
	
		super("Pito");
		setSize(1200, 380);
		setLocationRelativeTo(null);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		Container cp = getContentPane();
		
		panel.setLayout(new GridBagLayout());

		GridBagConstraints posicionPuntuacion = new GridBagConstraints();
		posicionPuntuacion.gridx = 0;
		posicionPuntuacion.gridy = 0;
		posicionPuntuacion.insets = new Insets(0, 0, 320, 700);

		GridBagConstraints posicionTurno = new GridBagConstraints();
		posicionTurno.gridx = 0;
		posicionTurno.gridy = 0;
		posicionTurno.insets = new Insets(10, 0, 0, 0);
		
		GridBagConstraints posicionJugador = new GridBagConstraints();
		posicionJugador.gridx = 0;
		posicionJugador.gridy = 0;
		posicionJugador.insets = new Insets(0, 0, 320, 1100);
		
		JPanel panelTextoJugador = new JPanel();
		
		
		
		JLabel textoJugador = new JLabel("Jugador: ");
		JLabel textoTurno = new JLabel("Turno: ");
		JLabel textoPuntuacion = new JLabel("Puntuacion: ");
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		panelTextoJugador.setBackground(Color.CYAN);
		panelTextoJugador.setBorder(blackline);
		panelTextoJugador.add(textoJugador);
		
		panel.add(panelTextoJugador);
		panel.add(textoTurno, posicionTurno);
		panel.add(textoJugador, posicionJugador);
		panel.add(textoPuntuacion, posicionPuntuacion);

		
		cp.add(panel);
		
	
	}

}
