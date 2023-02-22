import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PantallaInicio extends JFrame {

	private JTextField nombre1 = new JTextField(10);
	private JTextField nombre2 = new JTextField(10);
	private JLabel titulo = new JLabel("Bienvenido al Trivial de M7!");
	private JLabel tituloJugador1 = new JLabel("Nombre Jugador 1");
	private JLabel tituloJugador2 = new JLabel("Nombre Jugador 2");
	private JButton boton = new JButton("Empezar");
	

	public PantallaInicio() {

		setSize(1200, 380);
		setLocationRelativeTo(null);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container cp = getContentPane();

		cp.setLayout(new GridBagLayout());
		cp.setBackground(Color.decode("#E2F99D"));

		GridBagConstraints posicionNombre1 = new GridBagConstraints();
		posicionNombre1.gridx = 0;
		posicionNombre1.gridy = 0;
		posicionNombre1.insets = new Insets(45, 0, 0, 500);

		GridBagConstraints posicionNombre2 = new GridBagConstraints();
		posicionNombre2.gridx = 0;
		posicionNombre2.gridy = 0;
		posicionNombre2.insets = new Insets(45, 500, 0, 0);

		GridBagConstraints posicionTituloNombre1 = new GridBagConstraints();
		posicionTituloNombre1.gridx = 0;
		posicionTituloNombre1.gridy = 0;
		posicionTituloNombre1.insets = new Insets(0, 0, 30, 500);

		GridBagConstraints posicionTituloNombre2 = new GridBagConstraints();
		posicionTituloNombre2.gridx = 0;
		posicionTituloNombre2.gridy = 0;
		posicionTituloNombre2.insets = new Insets(0, 500, 30, 0);

		GridBagConstraints posicionTitulo = new GridBagConstraints();
		posicionTitulo.gridx = 0;
		posicionTitulo.gridy = 0;
		posicionTitulo.insets = new Insets(-250, 0, 0, 0);

		GridBagConstraints posicionBoton = new GridBagConstraints();
		posicionBoton.gridx = 0;
		posicionBoton.gridy = 0;
		posicionBoton.insets = new Insets(200, 0, 0, 0);

		JPanel panelTitulo = new JPanel();
		JPanel panelJugador1 = new JPanel();
		JPanel panelJugador2 = new JPanel();
		JPanel panelTituloJugador1 = new JPanel();
		JPanel panelTituloJugador2 = new JPanel();

		JPanel panelBoton = new JPanel();

		panelTitulo.setPreferredSize(new Dimension(1000, 40));
		titulo.setFont(new Font("Sans-Serif", Font.BOLD, 20));
		panelTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelTitulo.setBackground(Color.decode("#CDFA4A"));
		
		panelTituloJugador1.setPreferredSize(new Dimension(500, 30));
		tituloJugador1.setFont(new Font("Sans-Serif", Font.BOLD, 18));
		panelTituloJugador1.setBackground(Color.decode("#CDFA4A"));
		
		panelTituloJugador2.setPreferredSize(new Dimension(500, 30));
		tituloJugador2.setFont(new Font("Sans-Serif", Font.BOLD, 18));
		panelTituloJugador2.setBackground(Color.decode("#CDFA4A"));

		panelJugador1.setBackground(Color.decode("#CDFA4A"));
		panelJugador1.setPreferredSize(new Dimension(500, 45));
		nombre1.setFont(new Font("Sans-Serif", Font.ITALIC, 17));
		
		panelJugador2.setBackground(Color.decode("#CDFA4A"));
		panelJugador2.setPreferredSize(new Dimension(500, 45));
		nombre2.setFont(new Font("Sans-Serif", Font.ITALIC, 17));
		
		boton.setPreferredSize(new Dimension(200, 50));
		boton.setBackground(Color.decode("#CDFA4A"));
		boton.setFont(new Font("Sans-Serif", Font.BOLD, 18));
		

		panelTituloJugador1.add(tituloJugador1);
		panelJugador1.add(nombre1);
		
		panelTituloJugador2.add(tituloJugador2);
		panelJugador2.add(nombre2);
		
		panelTitulo.add(titulo);
		panelBoton.add(boton);

		cp.add(panelTituloJugador1, posicionTituloNombre1);
		cp.add(panelTituloJugador2, posicionTituloNombre2);
		cp.add(panelJugador1, posicionNombre1);
		cp.add(panelJugador2, posicionNombre2);
		cp.add(panelTitulo, posicionTitulo);
		cp.add(boton, posicionBoton);
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				test2();		
			}
		});

	}
	

		public void test2() {
			TrivialClass trivial = new TrivialClass();
			trivial.setText1(nombre1.getText().toString());
			trivial.setText2(nombre2.getText().toString());
			trivial.setVisible(true);
			this.dispose();
			
		}


		public JTextField getNombre1() {
			return nombre1;
		}


		public void setNombre1(JTextField nombre1) {
			this.nombre1 = nombre1;
		}


		public JTextField getNombre2() {
			return nombre2;
		}


		public void setNombre2(JTextField nombre2) {
			this.nombre2 = nombre2;
		}
		
		
		
		
		
	
	
	

}
