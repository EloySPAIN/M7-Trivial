import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class TrivialMain {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		TrivialClass trivial = new TrivialClass();
		trivial.setVisible(true);
	}
  
}
