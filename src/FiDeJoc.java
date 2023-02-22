import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FiDeJoc extends JFrame {
	
	
	private JLabel ganador = new JLabel("El ganador del Trivial es...");
	private JLabel titulo = new JLabel("FI DEL JOC!");
	private Button boton = new Button("Volver a jugar");
	
	
		public FiDeJoc() {

			setSize(1200, 380);
			setLocationRelativeTo(null);
			setVisible(true);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			
			Container cp = getContentPane();
			
			cp.setLayout(new GridBagLayout());
			cp.setBackground(Color.decode("#E2F99D"));
			
			
			
			GridBagConstraints posicionTextoFinal = new GridBagConstraints();
			posicionTextoFinal.gridx = 0;
			posicionTextoFinal.gridy = 0;
			posicionTextoFinal.insets = new Insets(0, 0, 0, 0);
			
			GridBagConstraints posicionTitulo = new GridBagConstraints();
			posicionTitulo.gridx = 0;
			posicionTitulo.gridy = 0;
			posicionTitulo.insets = new Insets(0, 0, 200, 0);
			
			GridBagConstraints posicionBoton = new GridBagConstraints();
			posicionBoton.gridx = 0;
			posicionBoton.gridy = 0;
			posicionBoton.insets = new Insets(200, 0, 0, 0);
			
			JPanel panelTitulo = new JPanel();
			JPanel panelGanador = new JPanel();
			JPanel panelBoton = new JPanel();
			
			
			titulo.setFont(new Font("Sans-Serif", Font.BOLD, 30));
			panelTitulo.setBackground(Color.decode("#CDFA4A"));
			panelGanador.setBackground(Color.decode("#CDFA4A"));
			panelBoton.setBackground(Color.decode("#E2F99D"));
			
			boton.setPreferredSize(new Dimension(200, 50));
			boton.setBackground(Color.decode("#CDFA4A"));
			boton.setFont(new Font("Sans-Serif", Font.BOLD, 18));
			
			panelBoton.add(boton);
			panelGanador.add(ganador);
			panelTitulo.add(titulo);
			cp.add(panelGanador, posicionTextoFinal);
			cp.add(panelTitulo, posicionTitulo);
			cp.add(panelBoton, posicionBoton);
			
		}

		public void setText(String nombre) {
			ganador.setText("El ganador del Trivial es... " + nombre);
		}


}
