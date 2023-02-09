import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class TrivialPreguntas extends JFrame {
	private int time = 60;
	private JPanel panel = new JPanel();
	private JPanel subPanel = new JPanel();
	private JPanel respuestasPanel = new JPanel();
	private JPanel tiempo = new JPanel();
	private JLabel pregunta = new JLabel();
	private JLabel tiempoLabel = new JLabel();
	private JButton respuesta1 = new JButton("holaa");
	private JButton respuesta2 = new JButton("hola2");
	private JButton respuesta3 = new JButton("hola3");
	private JButton respuesta4 = new JButton("hola4");
	private JButton enviar = new JButton("Enviar respuesta");
	private JLabel mensajeAcierto_Falso = new JLabel("acierto");

	TrivialPreguntas() {
		super("Pregunta");
		setSize(1200, 600);
		setLocationRelativeTo(null);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container cp = getContentPane();
		cp.setLayout(new GridBagLayout());
		cp.setBackground(Color.decode("#EEF9CD"));

		panel.setLayout(new GridBagLayout());
		tiempo.setLayout(new GridBagLayout());
		subPanel.setLayout(new GridBagLayout());
		respuestasPanel.setLayout(new GridBagLayout());

		GridBagConstraints espacioRespuestas = new GridBagConstraints();
		espacioRespuestas.gridx = 0;
		espacioRespuestas.gridy = 1;
		espacioRespuestas.insets = new Insets(-540, 0, 0, 150);

		GridBagConstraints espacioPregunta = new GridBagConstraints();
		espacioPregunta.gridx = 0;
		espacioPregunta.gridy = 0;
		espacioPregunta.insets = new Insets(0, 0, 460, 150);

		GridBagConstraints espacioSubPanel = new GridBagConstraints();
		espacioSubPanel.gridx = 0;
		espacioSubPanel.gridy = 0;
		espacioSubPanel.insets = new Insets(0, 0, 460, 150);

		GridBagConstraints espacioPregunta2 = new GridBagConstraints();
		espacioPregunta2.gridx = 1;
		espacioPregunta2.gridy = 0;
		espacioPregunta2.insets = new Insets(0, -150, 460, 0);

		GridBagConstraints pregEsp = new GridBagConstraints();
		pregEsp.gridx = 0;
		pregEsp.gridy = 0;
		pregEsp.insets = new Insets(0, 0, 0, 900);

		GridBagConstraints pr1 = new GridBagConstraints();
		pr1.gridx = 0;
		pr1.gridy = 0;
		pr1.insets = new Insets(0, 0, 100, 100);

		GridBagConstraints pr2 = new GridBagConstraints();
		pr2.gridx = 1;
		pr2.gridy = 0;
		pr2.insets = new Insets(0, 0, 100, 0);

		GridBagConstraints pr3 = new GridBagConstraints();
		pr3.gridx = 0;
		pr3.gridy = 1;
		pr3.insets = new Insets(0, 0, 0, 100);

		GridBagConstraints pr4 = new GridBagConstraints();
		pr4.gridx = 1;
		pr4.gridy = 1;
		pr4.insets = new Insets(0, 0, 0, 0);

		GridBagConstraints espacioUtilities = new GridBagConstraints();
		espacioUtilities.gridx = 0;
		espacioUtilities.gridy = 0;
		espacioUtilities.insets = new Insets(350, 0, 0, 0);

		GridBagConstraints espacioMessage = new GridBagConstraints();
		espacioMessage.gridx = 0;
		espacioMessage.gridy = 0;
		espacioMessage.insets = new Insets(450, 0, 0, 0);

		pregunta = new JLabel("asdsadsa");
		Border blackline = BorderFactory.createLineBorder(Color.black);

		panel.setBorder(blackline);
		panel.setBackground(Color.decode("#CDFA4A"));
		panel.setPreferredSize(new Dimension(1000, 70));

		subPanel.setBorder(blackline);
		subPanel.setPreferredSize(new Dimension(985, 55));
		subPanel.setBackground(Color.decode("#E2F99D"));

		tiempo.setBorder(blackline);
		tiempo.setPreferredSize(new Dimension(60, 60));
		tiempo.setBackground(Color.decode("#E2F99D"));
		tiempo.add(tiempoLabel);

		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				tiempoLabel.setText("" + time);
				time--;

				if (time < 0) {
					timer.cancel();
					tiempoLabel.setText("0");
				}

			}
		}, 0, 1000);

		// Se utilizara mas adelante

//		timer.scheduleAtFixedRate(new TimerTask() {
//			public void run() {
//				if(time < 0) {
//					timer.cancel();
//					System.out.println("hoa");
//					tiempoLabel.setText("0");
//				}
//				
//			}
//		}, 0, 1000);

		subPanel.add(pregunta, pregEsp);

		respuestasPanel.setBorder(blackline);
		respuestasPanel.setPreferredSize(new Dimension(985, 300));
		respuestasPanel.setBackground(Color.decode("#E2F99D"));

		respuestasPanel.add(respuesta1, pr1);
		respuesta1.setPreferredSize(new Dimension(400, 40));
		respuesta1.setBackground(Color.decode("#EEF9CD"));

		respuestasPanel.add(respuesta2, pr2);
		respuesta2.setPreferredSize(new Dimension(400, 40));
		respuesta2.setBackground(Color.decode("#EEF9CD"));

		respuestasPanel.add(respuesta3, pr3);
		respuesta3.setPreferredSize(new Dimension(400, 40));
		respuesta3.setBackground(Color.decode("#EEF9CD"));

		respuestasPanel.add(respuesta4, pr4);
		respuesta4.setPreferredSize(new Dimension(400, 40));
		respuesta4.setBackground(Color.decode("#EEF9CD"));
		
		mensajeAcierto_Falso.setForeground(Color.decode("#00BB08"));
		enviar.setBackground(Color.decode("#CDFA4A"));
		
		tiempoLabel.setFont(new Font("Sans-Serif", Font.BOLD, 18));
		mensajeAcierto_Falso.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		enviar.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		pregunta.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		respuesta1.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		respuesta2.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		respuesta3.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		respuesta4.setFont(new Font("Sans-Serif", Font.BOLD, 14));

		cp.add(subPanel, espacioSubPanel);
		cp.add(panel, espacioPregunta);
		cp.add(tiempo, espacioPregunta2);
		cp.add(respuestasPanel, espacioRespuestas);
		cp.add(enviar, espacioUtilities);
		cp.add(mensajeAcierto_Falso, espacioMessage);

		// Recarga los jpanel (se utiliza para eliminar fallos de visualizacion)
		revalidate();
		repaint();

	}

}
