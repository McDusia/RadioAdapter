import java.util.List;

public class CD {
    private String title;
    private List<Song> songList;
    private int currentSong;

    public void CD(String title, List <Song> songList)
    {
        this.title = title;
        this.songList = songList;
        currentSong = 0;
    }

    public String getTitle() {
        return title;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public int getCurrentSong(){
        return currentSong;
    }
    public void nextSong(){
        if(currentSong + 1 < songList.size())
            currentSong ++;
        else
            currentSong = 0;
    }

}
