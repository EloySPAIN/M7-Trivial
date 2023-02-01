import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TrivialPreguntas extends JFrame{
	private JPanel panel = new JPanel();
	private JPanel espacioPanelP = new JPanel();
	private JLabel pregunta = new JLabel();
	
	TrivialPreguntas(){
		super("Pregunta");
		setSize(1200, 500);
		setLocationRelativeTo(null);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container cp = getContentPane();
		cp.setLayout(new GridBagLayout());
		
		panel.setLayout(new GridBagLayout());
		espacioPanelP.setLayout(new GridBagLayout());


		GridBagConstraints espacioPregunta = new GridBagConstraints();
		espacioPregunta.gridx = 0;
		espacioPregunta.gridy = 0;
		espacioPregunta.insets = new Insets(0, 0, 360, 150);
		
		GridBagConstraints espacioPregunta1 = new GridBagConstraints();
		espacioPregunta1.gridx = 0;
		espacioPregunta1.gridy = 0;
		espacioPregunta1.insets = new Insets(0, 0, 360, 150);
		
		pregunta = new JLabel("asdsadsa");
		Border blackline = BorderFactory.createLineBorder(Color.black);
		espacioPanelP.setBorder(blackline);
		espacioPanelP.add(pregunta);
		
		espacioPanelP.add(pregunta, espacioPregunta);
		
		panel.setBorder(blackline);
		panel.setPreferredSize(new Dimension(1000, 70));

		cp.add(panel, espacioPregunta);
		
	}

}
