import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FiDeJoc extends JFrame {
	

	private JLabel textoNombre = new JLabel("");



		public FiDeJoc() {

			setSize(500, 300);
			setLocationRelativeTo(null);
			setVisible(true);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			JPanel panel = new JPanel();
			Container cp = getContentPane();
			
			cp.setLayout(new GridBagLayout());
			cp.setBackground(Color.decode("#E2F99D"));
			
			panel.setLayout(new GridBagLayout());
			
			GridBagConstraints posicionTextoFinal = new GridBagConstraints();
			posicionTextoFinal.gridx = 0;
			posicionTextoFinal.gridy = 0;
			posicionTextoFinal.insets = new Insets(0, 0, -200, 0);
			
			panel.add(textoNombre);
			cp.add(panel, posicionTextoFinal);
			
		}

		public void setText(String nombre) {
			textoNombre.setText(nombre);
		}


}
