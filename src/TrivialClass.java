import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class TrivialClass {
//	private ArrayList<PreguntasRespondidas> trivial = new PreguntasRespondidas();
//	private ArrayList<Integer> idPreguntas = new ArrayList<Integer>();
	private int idPreguntas[] = new int[10];
	JFrame frame = new JFrame("Class");
	public TrivialClass() {
		
//		super("Pito");
//		setSize(1200, 380);
//		setLocationRelativeTo(null);
//		setVisible(true);
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1200, 380);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton a = new JButton("asas");
		a.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				TrivialClass trivial;
//				if(!trivial.isActive()) {
				try {
//					frame.dispose();
					TrivialPreguntas pregunta = new TrivialPreguntas();
					frame.dispose();
					
//					pregunta.getIds(idPreguntas);
//					pregunta.setVisible(true);

				} catch (ParserConfigurationException | SAXException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				}else {
//					trivial.dispose();
//				}
				
			}
		});
		Container cp = frame.getContentPane();
		cp.setLayout(new GridBagLayout());
		cp.add(a);
//		frame.add(cp);
	}
	
//	public ArrayList<Integer> getIdPreguntas() {
//		return idPreguntas;
//	}
//
//	public void setIdPreguntas(ArrayList<Integer> idPreguntas) {
//		this.idPreguntas = idPreguntas;
//	}

	public void setId(int id) {
//		idPreguntas.add(id);
		for(int i = 0 ; i < idPreguntas.length; i++) {
			if(i==id) {
				idPreguntas[i] = id;
			}
			System.out.println(idPreguntas[i]);
			
		}
		
	}
	
	

}
