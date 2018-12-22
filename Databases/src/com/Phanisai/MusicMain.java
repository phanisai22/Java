package com.Phanisai;

import com.Phanisai.Model.Artist;
import com.Phanisai.Model.DataSource;
import com.Phanisai.Model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class MusicMain {

    public static void main(String[] args) {

        DataSource dataSource = new DataSource();
        dataSource.open();

//        List<Artist> artists = dataSource.queryArtists(DataSource.ORDER_BY_DESC);
//
//        for (Artist a : artists) {
//            System.out.println("Id : "+a.getId()+", \tName : "+a.getName());
//        }
//
//
//        List<String> albumsForArtist  =
//                dataSource.queryAlbumsByArtist("Carole King", DataSource.ORDER_BY_DESC) ;
//
//        for (String album : albumsForArtist) {
//            System.out.println(album);
//        }
//
//        List<SongArtist> songArtists =
//                dataSource.queryArtistOfSong("Go Your Own Way", DataSource.ORDER_BY_DESC) ;
//        for (SongArtist artist : songArtists) {
//            System.out.println("Artist name : "+artist.getArtistName()+
//                    "\nAlbum name : "+artist.getAlbumName()+
//                    "\nSong track : "+artist.getTrack()+"\n");
//        }
//
//        dataSource.querySongsMetaData();
//
//        System.out.println(dataSource.getCount(DataSource.TABLE_SONGS)) ;


//        System.out.println(dataSource.createViewForSongArtists());

//        Scanner scanner= new Scanner(System.in) ;
//        System.out.println("Enter the song name : ");
//        String song = scanner.nextLine();
////        songname" or 1=1 or "
//
//        List<SongArtist> songArtists = dataSource.querySongInfo(song) ;
//
//        for (SongArtist artist : songArtists) {
//            System.out.println("From view - Artist name : "+artist.getArtistName()+
//                    "Album name : "+artist.getAlbumName()+
//                    "Song track : "+artist.getTrack());
//        }
//

        dataSource.insertSong("Touch Of Grey", "Grateful Dead", "In The Dark", 1);

        dataSource.close();

    }

}
