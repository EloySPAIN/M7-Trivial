import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FiDeJoc extends JFrame {
	
	
	private JLabel ganador = new JLabel("Nombre");
	private JLabel textoGanador = new JLabel("El ganador del Trivial es...");
	private JLabel titulo = new JLabel("¡FIN DEL JUEGO!");
	
	
		public FiDeJoc() {

			setSize(1200, 500);
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
			
			GridBagConstraints posicionTextoGanador = new GridBagConstraints();
			posicionTextoGanador.gridx = 0;
			posicionTextoGanador.gridy = 0;
			posicionTextoGanador.insets = new Insets(0, 0, 200, 0);
			
			GridBagConstraints posicionTitulo = new GridBagConstraints();
			posicionTitulo.gridx = 0;
			posicionTitulo.gridy = 0;
			posicionTitulo.insets = new Insets(0, 0, 400, 0);
			
			JPanel panelTitulo = new JPanel();
			JPanel panelGanador = new JPanel();
			JPanel panelTextoGanador = new JPanel();

			titulo.setFont(new Font("Sans-Serif", Font.BOLD, 30));
			panelTitulo.setBackground(Color.decode("#CDFA4A"));
			panelGanador.setBackground(Color.decode("#CDFA4A"));
			
			textoGanador.setFont(new Font("Sans-Serif", Font.BOLD, 15));
			panelTextoGanador.setBackground(Color.decode("#CDFA4A"));
			
			ganador.setFont(new Font("Sans-Serif", Font.BOLD, 50));
			panelGanador.setBackground(Color.decode("#E2F99D"));
			
			
			panelTextoGanador.add(textoGanador);
			panelGanador.add(ganador);
			panelTitulo.add(titulo);
			cp.add(panelGanador, posicionTextoFinal);
			cp.add(panelTitulo, posicionTitulo);
			cp.add(panelTextoGanador, posicionTextoGanador);
			
			
		}

		public void setText(String nombre) {
			ganador.setText(nombre);
		}



}
