import jaco.mp3.player.MP3Player;

import java.io.File;

public class Musica {
	public MP3Player player = new MP3Player();
	public MP3Player player2 = new MP3Player();
	public MP3Player player3 = new MP3Player();
	public void lobbyStart() {
		player.addToPlayList(new File("musica_kahoot.mp3"));
		player.setRepeat(true);
		player.play();
	}
	
	public void lobbyStop() {
		player.stop();
	}
}
