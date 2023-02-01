import javax.swing.JFrame;

public class TrivialClass extends JFrame{
	public TrivialClass() {
		super("Pito");
		setSize(1200, 380);
		setLocationRelativeTo(null);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
