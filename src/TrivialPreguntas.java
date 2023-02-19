import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@SuppressWarnings("serial")
public class TrivialPreguntas {
	private int time = 30, eRand, numPregunta=0;
	private boolean selected = false;
	private AbstractButton btn;
	private JPanel panel = new JPanel();
	private JPanel subPanel = new JPanel();
	private JPanel respuestasPanel = new JPanel();
	private JPanel tiempo = new JPanel();
	private JLabel pregunta = new JLabel();
	private JLabel tiempoLabel = new JLabel();
	private JToggleButton respuesta1 = new JToggleButton("holaa");
	private JToggleButton respuesta2 = new JToggleButton("hola2");
	private JToggleButton respuesta3 = new JToggleButton("hola3");
	private JToggleButton respuesta4 = new JToggleButton("hola4");
	ButtonGroup grupoBtn = new ButtonGroup();
	private JToggleButton enviar = new JToggleButton("Enviar respuesta");
	private JLabel mensajeAcierto_Falso = new JLabel("");
	private ArrayList<String> respuestas = new ArrayList<String>();
	private ArrayList<String> respuestasOrdSorted = new ArrayList<String>();
	private ArrayList<Integer> preguntas = new ArrayList<Integer>();
	private ArrayList<Integer> preguntasRespondidas = new ArrayList<Integer>();
	TrivialClass trivialClass = new TrivialClass();
	
	
//	private ArrayList<PreguntasRespondidas> preguntasRespondidas = new ArrayList<PreguntasRespondidas>();

	Random random = new Random();
	boolean encontrado = true;
	JFrame frame = new JFrame("Class");
	
	@SuppressWarnings("unlikely-arg-type")
	TrivialPreguntas() throws ParserConfigurationException, SAXException, IOException {
//		super("Pregunta");
//		setSize(1200, 600);
//		setLocationRelativeTo(null);
//		setVisible(true);
//		setResizable(false);
////		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		frame.setSize(1200, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		Container cp = frame.getContentPane();
		cp.setLayout(new GridBagLayout());
		cp.setBackground(Color.decode("#EEF9CD"));

		panel.setLayout(new GridBagLayout());
		tiempo.setLayout(new GridBagLayout());
		subPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 15));
		respuestasPanel.setLayout(new GridBagLayout());

		GridBagConstraints espacioRespuestas = new GridBagConstraints();
		espacioRespuestas.gridx = 0;
		espacioRespuestas.gridy = 1;
		espacioRespuestas.insets = new Insets(-540, 0, 0, 0);

		GridBagConstraints espacioPregunta = new GridBagConstraints();
		espacioPregunta.gridx = 0;
		espacioPregunta.gridy = 0;
		espacioPregunta.insets = new Insets(0, 0, 460, 0);

		GridBagConstraints espacioSubPanel = new GridBagConstraints();
		espacioSubPanel.insets = new Insets(0, 0, 460, 0);

		GridBagConstraints espacioTiempo = new GridBagConstraints();
		espacioTiempo.gridx = 1;
		espacioTiempo.insets = new Insets(0, 20, 460, 0);

		GridBagConstraints pregEsp = new GridBagConstraints();
		pregEsp.insets = new Insets(0, -760, 0, -300);

		GridBagConstraints pr1 = new GridBagConstraints();
		pr1.insets = new Insets(0, 0, 100, 100);

		GridBagConstraints pr2 = new GridBagConstraints();
		pr2.gridx = 1;
		pr2.insets = new Insets(0, 0, 100, 0);

		GridBagConstraints pr3 = new GridBagConstraints();
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

				if (time < 0 && selected != true) {
					for (Enumeration<AbstractButton> buttons = grupoBtn.getElements(); buttons.hasMoreElements();) {
			            btn = buttons.nextElement();
			            if(btn.getText().equals(respuestas.get(0))) {
			            	btn.setBackground(Color.GREEN);
			            } else {
			            	btn.setBackground(Color.decode("#F2A181"));
			            }
					}
					deshabilitar();
					clear();
					timer.cancel();
					mensajeAcierto_Falso.setForeground(Color.RED);
        			mensajeAcierto_Falso.setText("Tiempo acabado, la respuesta correcta era: " + respuestas.get(0));
					tiempoLabel.setText("0");
				}
				
				if(selected == true) {
					timer.cancel();
				}
				
				if (time < 0) {
					timer.cancel();
				}

			}
		}, 0, 1000);



		subPanel.add(pregunta);

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

		enviar.setBackground(Color.decode("#CDFA4A"));

		tiempoLabel.setFont(new Font("Sans-Serif", Font.BOLD, 18));
		mensajeAcierto_Falso.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		enviar.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		pregunta.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		respuesta1.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		respuesta2.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		respuesta3.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		respuesta4.setFont(new Font("Sans-Serif", Font.BOLD, 14));

		enviar.setFocusPainted(false);
		respuesta1.setFocusPainted(false);
		respuesta2.setFocusPainted(false);
		respuesta3.setFocusPainted(false);
		respuesta4.setFocusPainted(false);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("preguntesEaltozanoHvallve.xml"));

		NodeList pregNodo = document.getElementsByTagName("pregunta");
		for(int i = 0; i < pregNodo.getLength(); i++) {
			preguntas.add(i);
		}
		
		
		eRand = random.nextInt(preguntas.size());
		if(!preguntasRespondidas.contains(eRand)) {
			preguntasRespondidas.add(eRand);
			numPregunta = preguntas.get(eRand);
//			trivialClass.setId(eRand);
//			trivialClass.dispose();
        }
//		System.out.println(preguntasRespondidas);
		
		
//		eRand = random.nextInt(preguntas.size());
//		if(!preguntasRespondidas.contains(eRand)) {
////			for(int i = 0; i<preguntasRespondidas.size();i++) {
//				preguntasRespondidas.add(new PreguntasRespondidas(eRand));
//				numPregunta = preguntas.get(eRand);
//				TrivialClass trivialClass = new TrivialClass();
//				
////	        }
////			System.out.println(preguntasRespondidas.get(i).getCont());
//		}

		if (pregNodo.item(numPregunta).getNodeType() == Node.ELEMENT_NODE) {
			Element elm = (Element) pregNodo.item(numPregunta);
			String pregXml = getNodo("texto", elm);
			pregunta.setText(pregXml);

            respuestas.add(elm.getElementsByTagName("correcta").item(0).getTextContent());
            respuestas.add(elm.getElementsByTagName("incorrecta").item(0).getTextContent());
            respuestas.add(elm.getElementsByTagName("incorrecta").item(1).getTextContent());
            respuestas.add(elm.getElementsByTagName("incorrecta").item(2).getTextContent());

			System.out.println(respuestas);
				
			// Ordena las preguntas aleatoriamente al array de respuestasOrdSorted cogiendolo del array de respuestas
				for (int i = 0; i < respuestas.size(); i++) {
					eRand = random.nextInt(respuestas.size());
					String res = respuestas.get(eRand);
					if(!respuestasOrdSorted.contains(res)) {
						respuestasOrdSorted.add(res);
	                }else {
	                	i--;
	                }
				}
			
			System.out.println(respuestasOrdSorted);

			// Sete
            respuesta1.setText(respuestasOrdSorted.get(0));
            respuesta2.setText(respuestasOrdSorted.get(1));
            respuesta3.setText(respuestasOrdSorted.get(2));
            respuesta4.setText(respuestasOrdSorted.get(3));

		}
		
		grupoBtn.add(respuesta1);
		grupoBtn.add(respuesta2);
		grupoBtn.add(respuesta3);
		grupoBtn.add(respuesta4);
		
		
		respuesta1.addItemListener(actionListener);
		respuesta2.addItemListener(actionListener);
		respuesta3.addItemListener(actionListener);
		respuesta4.addItemListener(actionListener);
		enviar.addItemListener(actionListener);

		cp.add(subPanel, espacioSubPanel);
		cp.add(panel, espacioPregunta);
		cp.add(tiempo, espacioTiempo);
		cp.add(respuestasPanel, espacioRespuestas);
		cp.add(enviar, espacioUtilities);
		cp.add(mensajeAcierto_Falso, espacioMessage);

		// Recarga los jpanel (se utiliza para eliminar fallos de visualizacion)
		frame.revalidate();
		frame.repaint();

	}
	
	
	ItemListener actionListener = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent ev) {

			// Recorre cada elemento del grupo indicado y se le asigna al boton abstracto
			for (Enumeration<AbstractButton> buttons = grupoBtn.getElements(); buttons.hasMoreElements();) {
	            btn = buttons.nextElement();

	            // Coge el boton selecionado y comprueba si es el correcto
	            if (ev.getSource()==enviar) {
	            	if(btn.isSelected()) {
	            		if(btn.getText().equals(respuestas.get(0))) {
	            			mensajeAcierto_Falso.setForeground(Color.decode("#00BB08"));
	            			mensajeAcierto_Falso.setText("Correcto");
	            			selected = true;
	            		} else {
	            			mensajeAcierto_Falso.setForeground(Color.RED);
	            			mensajeAcierto_Falso.setText("Fallo, la respuesta correcta es: " + respuestas.get(0));
	            			selected = true;
	            		}
	            		if(!btn.getText().equals(respuestas.get(0))) {
		 	            	btn.setBackground(Color.decode("#F2A181"));
		 	            }
	            		clear();
	    			}
	            	
	            	if(!btn.isSelected()) {
	            		if(btn.getText().equals(respuestas.get(0))) {
	            			btn.setBackground(Color.GREEN);
		 	            } 
	            	}
	            	
	            	deshabilitar();
	            	dormir();
	            }
	        }
		}
	};
	
	private void clear() {
		grupoBtn.clearSelection();
		enviar.setSelected(false);
	}
	
	private void deshabilitar() {
		btn.setEnabled(false);
		enviar.setEnabled(false);
	}
	
	private void dormir() {
//		Timer timer = new Timer();
//		time = 5;
//
//		timer.scheduleAtFixedRate(new TimerTask() {
//			public void run() {
//				time--;
//				if (time < 0) {
//					timer.cancel();
//				}
//
//			}
//		}, 0, 1000);
//		this.dispose();
		
//		frame.setVisible(false);
		
		frame.dispose();

	}
	
	public void getIds(int array[]) {
		
//		for(int i = 0; i <array.size(); i++) {
//			preguntasRespondidas.add(array.get(i));	
//		}
		for(int i = 0; i <array.length; i++) {
			System.out.println(array);
			preguntasRespondidas.add(array[i]);	
		}
	}

	private static String getNodo(String etiqueta, Element elem) {
		NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node valNodo = (Node) nodo.item(0);
		return valNodo.getNodeValue();
	}
	

}
