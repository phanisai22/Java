package MusicApplication;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.ListIterator;

class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("StormBringer", "Deep Purple");
        album.addSong("stormbringer", 3.33);
        album.addSong("love don't mean a thing", 4.34);
        album.addSong("holyman", 4.43);
        album.addSong("hold on", 4.56);
        album.addSong("lady double dealer", 3.33);
        album.addSong("you can't do it right", 3.33);
        album.addSong("high ball shooter", 3.33);
        album.addSong("the gypsy", 3.33);
        album.addSong("soldier of fortune", 3.33);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();

        albums.get(0).addPlaylist("holyman", playlist);
        albums.get(0).addPlaylist("speed king", playlist); // doesnot exist .

        albums.get(0).addPlaylist(5, playlist);
        albums.get(0).addPlaylist(1, playlist);
        albums.get(0).addPlaylist(7, playlist);
        albums.get(0).addPlaylist(23, playlist); // doesnot exist .

        play(playlist);

    }

    private static void play(LinkedList<Song> playlist) {
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("No songs to play .");
        } else {
            while (listIterator.hasNext()) {
                System.out.println("now playing " + listIterator.next().toString());
            }
        }
    }

}