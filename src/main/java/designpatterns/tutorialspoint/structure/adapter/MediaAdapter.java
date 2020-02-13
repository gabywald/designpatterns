package designpatterns.tutorialspoint.structure.adapter;

public class MediaAdapter implements MediaPlayer {

	private AdvancedMediaPlayer advancedMusicPlayer;

	public MediaAdapter(String audioType) {
		if (audioType.equalsIgnoreCase("vlc") ) {
			this.advancedMusicPlayer = new VlcPlayer();			
		} else if (audioType.equalsIgnoreCase("mp4")) {
			this.advancedMusicPlayer = new Mp4Player();
		}	
	}

	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("vlc")) {
			this.advancedMusicPlayer.playVlc(fileName);
		} else if (audioType.equalsIgnoreCase("mp4")) {
			this.advancedMusicPlayer.playMp4(fileName);
		}
	}
}
