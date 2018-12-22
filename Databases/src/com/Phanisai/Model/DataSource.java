package com.Phanisai.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION = "jdbc:sqlite:/home/user/Desktop/" +
            "programs/javaPrograms/Databases/" + DB_NAME;

    public static final String TABLE_ARTISTS = "artists";
    public static final String TABLE_ALBUMS = "albums";
    public static final String TABLE_SONGS = "songs";

    public static final String ARTIST_NAME = "name";
    public static final String ARTIST_ID = "_id";

    public static final String ALBUM_ID = "_id";
    public static final String ALBUM_NAME = "name";
    public static final String ALBUM_ARTIST = "artist";

    public static final String SONGS_ID = "_id";
    public static final String SONGS_TRACK = "track";
    public static final String SONGS_TITLE = "title";
    public static final String SONGS_ALBUM = "album";

    public static final int ORDER_BY_NONE = 0;
    public static final int ORDER_BY_ASC = 1;
    public static final int ORDER_BY_DESC = 2;

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";

//    Constants for sqlite statements .

    //    SELECT * FROM ARTISTS
    public static final String QUERY_ARTISTS_START =
            "SELECT * FROM " + TABLE_ARTISTS;

    //    ORDER BY ARTIST_NAME COLLATE NO CASE ASC/DESC
    public static final String QUERY_ARTISTS_SORT =
            " ORDER BY " + ARTIST_NAME + " COLLATE NOCASE ";

    //    SELECT ALBUMS.NAME FROM ALBUMS INNER JOIN ARTISTS ON ALBUMS.ARTIST = ARTISTS._ID
//    WHERE ARTISTS.NAME = "artistName
    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + "." + ALBUM_NAME + " FROM " + TABLE_ALBUMS + " INNER JOIN "
                    + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + ALBUM_ARTIST + " = "
                    + TABLE_ARTISTS + "." + ARTIST_ID + " WHERE " + TABLE_ARTISTS + "." + ARTIST_NAME
                    + " = \"";

    //    ORDER BY ALBUMS.NAME COLLATE NOCASE  ASC/DESC
    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            "\" ORDER BY " + TABLE_ALBUMS + "." + ALBUM_NAME + " COLLATE NOCASE ";

//    SELECT ARTIST.NAME, ALBUM.NAME, SONGS.TRACK FROM SONGS INNER JOIN ALBUMS ON SONGS.ALBUM = ALBUM._ID
//    INNER JOIN ARTISTS ON ALBUMS.ARTISTS = ARTISTS._ID WHERE SONGS.TITLE = "

    public static final String QUERY_ARTISTS_OF_SONG_START =
            "SELECT " + TABLE_ARTISTS + "." + ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + ALBUM_NAME + ", " +
                    TABLE_SONGS + "." + SONGS_TRACK +
                    " FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " +
                    TABLE_SONGS + "." + SONGS_ALBUM + " = " +
                    TABLE_ALBUMS + "." + ALBUM_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " +
                    TABLE_ALBUMS + "." + ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + ARTIST_ID +
                    " WHERE " + TABLE_SONGS + "." + SONGS_TITLE + " = \"";

//    " ORDER BY ARTIST.NAME, ALBUM.NAME COLLATE NOCASE ASC/DESC

    public static final String QUERY_ARTISTS_OF_SONG_SORT =
            "\" ORDER BY " + TABLE_ARTISTS + "." + ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + ALBUM_NAME + " COLLATE NOCASE ";

    //    CREATE VIEW IF NOT EXITS ARTIST_LIST AS SELECT ARTISTS.NAME, ALBUMS.NAME AS
//    ALBUM, SONGS.TRACK, SONGS.TITLE FROM SONGS
//    INNER JOIN ALBUMS ON SONGS.ALBUM = ALBUM._ID
//    INNER JOIN ARTISTS ON ALBUMS.ARTIST = ARTISTS._ID
//    ORDER BY ARTISTS.NAME, ALBUMS.NAME, SONGS.TRACK
    public static final String CREATE_ARTIST_SONG_VIEW =
            "CREATE VIEW IF NOT EXISTS " + TABLE_ARTIST_SONG_VIEW + " AS SELECT " +
                    TABLE_ARTISTS + "." + ARTIST_NAME + ", " +
                    TABLE_ALBUMS + "." + ALBUM_NAME + " AS " + SONGS_ALBUM + ", " +
                    TABLE_SONGS + "." + SONGS_TRACK + ", " +
                    TABLE_SONGS + "." + SONGS_TITLE + " FROM " + TABLE_SONGS +
                    " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + SONGS_ALBUM + " = " +
                    TABLE_ALBUMS + "." + ALBUM_ID +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + ALBUM_ARTIST + " = " +
                    TABLE_ARTISTS + "." + ARTIST_ID +
                    " ORDER BY " +
                    TABLE_ARTISTS + "." + ARTIST_NAME + " , " +
                    TABLE_ALBUMS + "." + ALBUM_NAME + " , " +
                    TABLE_SONGS + "." + SONGS_TRACK;

//    SELECT NAME, ALBUM , TRACK FROM ARTIST_LIST WHERE TITLE = "

    public static final String QUERY_SONG_INFO = "SELECT " + ARTIST_NAME + ", "
            + SONGS_ALBUM + ", " + SONGS_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " +
            SONGS_TITLE + " = \"";

    public static final String QUERY_SONG_INFO_PREP = "SELECT " + ARTIST_NAME + ", "
            + SONGS_ALBUM + ", " + SONGS_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " +
            SONGS_TITLE + " = ?";

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS +
            "(" + ARTIST_NAME + ") VALUES(?)";

    public static final String INSERT_ALBUM = "INSERT INTO " + TABLE_ALBUMS +
            "(" + ALBUM_NAME + ", " + ALBUM_ARTIST + ") VALUES(?, ?)";

    public static final String INSERT_SONG = "INSERT INTO " + TABLE_SONGS +
            "(" + SONGS_TRACK + ", " + SONGS_TITLE + ", " + SONGS_ALBUM + ") VALUES(?, ?, ?)";

    public static final String QUERY_ARTISTS = "SELECT " + ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + ARTIST_NAME + " = ?";

    public static final String QUERY_ALBUMS = "SELECT " + ALBUM_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + ALBUM_NAME + " = ?";

    public static final String QUERY_SONGS = "SELECT " + SONGS_ID + " FROM " +
            TABLE_SONGS + " WHERE " + SONGS_TITLE + " = ?";


    private Connection connection;

    private PreparedStatement insertIntoArtist;
    private PreparedStatement insertIntoAlbum;
    private PreparedStatement insertIntoSong;

    private PreparedStatement queryArtists;
    private PreparedStatement queryAlbums;
    private PreparedStatement querySongs;

    public boolean open() {
        try {
            connection = DriverManager.getConnection(CONNECTION);

            insertIntoArtist = connection.prepareStatement
                    (INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbum = connection.prepareStatement
                    (INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
            insertIntoSong = connection.prepareStatement
                    (INSERT_SONG);

            queryAlbums = connection.prepareStatement(QUERY_ALBUMS);
            queryArtists = connection.prepareStatement(QUERY_ARTISTS);
            querySongs = connection.prepareStatement(QUERY_SONGS);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to the data base :" + e.getMessage());
            return false;
        }
    }


    public boolean close() {
        try {

            if (insertIntoSong != null) {
                insertIntoSong.close();
            }

            if (insertIntoAlbum != null) {
                insertIntoAlbum.close();
            }

            if (insertIntoArtist != null) {
                insertIntoArtist.close();
            }

            if (queryArtists != null) {
                queryArtists.close();
            }

            if (queryAlbums != null) {
                queryAlbums.close();
            }

            if (querySongs != null) {
                querySongs.close();
            }

            if (connection != null)
                connection.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Couldn't close connection :" + e.getMessage());
            return false;
        }
    }


    private void addSortOrder(StringBuilder sb, String statement, int sortOrder) {
        if (ORDER_BY_NONE != sortOrder) {
            sb.append(statement);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("desc");
            } else {
                sb.append("asc");
            }

        }
    }


    public List<Artist> queryArtists(int sortOrder) {

        StringBuilder sb = new StringBuilder(QUERY_ARTISTS_START);
        System.out.println("Sql Statement : " + sb);

        addSortOrder(sb, QUERY_ARTISTS_SORT, sortOrder);

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {


            List<Artist> artists = new ArrayList<>();
            while (results.next()) {
                Artist artist = new Artist();
                artist.setId(results.getInt(ARTIST_ID));
                artist.setName(results.getString(ARTIST_NAME));
                artists.add(artist);
            }

            return artists;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
//            e.printStackTrace();
            return null;
        }
    }


    public List<String> queryAlbumsByArtist(String artistName, int sortOrder) {
        StringBuilder sb = new StringBuilder();
        sb.append(QUERY_ALBUMS_BY_ARTIST_START);
        sb.append(artistName);

        addSortOrder(sb, QUERY_ALBUMS_BY_ARTIST_SORT, sortOrder);

        System.out.println("Sql statement : " + sb.toString());

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<String> albums = new ArrayList<>();
            while (results.next()) {
                albums.add(results.getString(1));
            }

            return albums;
        } catch (SQLException e) {
            System.out.println("Error occur while query albums by artist name " + artistName + " : "
                    + e.getMessage());
//            e.printStackTrace();
            return null;
        }
    }


    public List<SongArtist> queryArtistOfSong(String songName, int sortOrder) {

        StringBuilder sb = new StringBuilder(QUERY_ARTISTS_OF_SONG_START);
        sb.append(songName);

        addSortOrder(sb, QUERY_ARTISTS_OF_SONG_SORT, sortOrder);

        System.out.println("Sql statement : " + sb.toString());

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())) {

            List<SongArtist> songArtists = new ArrayList<>();
            while (results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songArtists.add(songArtist);
            }

            return songArtists;

        } catch (SQLException e) {
            System.out.println("Error occured while query : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void querySongsMetaData() {
        String sql = "SELECT * FROM " + TABLE_ARTIST_SONG_VIEW;

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            ResultSetMetaData meta = results.getMetaData();
            int numColumns = meta.getColumnCount();
            for (int i = 1; i <= numColumns; i++) {
                System.out.format("Column %d in the songs table is %s\n",
                        i, meta.getColumnName(i));
            }

        } catch (SQLException e) {
            System.out.println("query Failed : " + e.getMessage());
        }
    }

    public int getCount(String table) {
        String sql = "SELECT COUNT(*) FROM " + table;

        try (Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            int count = results.getInt(1);
            return count;
        } catch (SQLException e) {
            System.out.println("query failed : " + e.getMessage());
            return -1;
        }
    }

    public boolean createViewForSongArtists() {

        System.out.println(CREATE_ARTIST_SONG_VIEW);

        try (Statement statement = connection.createStatement()) {
            statement.execute(CREATE_ARTIST_SONG_VIEW);
            return true;
        } catch (SQLException e) {
            System.out.println("Create view failed : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<SongArtist> querySongInfo(String songTitle) {

        StringBuilder sb = new StringBuilder(QUERY_SONG_INFO);
        sb.append(songTitle);
        sb.append("\"");

        System.out.println("Sql statement : " + sb.toString());


        try {

            PreparedStatement querySongInfo = connection.prepareStatement(QUERY_SONG_INFO_PREP);
            querySongInfo.setString(1, songTitle);
            ResultSet results = querySongInfo.executeQuery();

            List<SongArtist> songArtists = new ArrayList<>();
            while (results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songArtists.add(songArtist);
            }

            querySongInfo.close();

            return songArtists;

        } catch (SQLException e) {
            System.out.println("Error occured while query : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private int insertArtist(String name) throws SQLException {
        queryArtists.setString(1, name);
        ResultSet results = queryArtists.executeQuery();

        if (results.next()) {
            return results.getInt(1);
        } else {
//            Insert the artist .
            insertIntoArtist.setString(1, name);
            int affecedRow = insertIntoArtist.executeUpdate();

            if (affecedRow != 1) {
                throw new SQLException("Couldn't insert artist");
            }
        }
        ResultSet generatedKeys = insertIntoArtist.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        } else {
            throw new SQLException("Cannot get id for artist");
        }
    }

    private int insertAlbum(String name, int artistId) throws SQLException {
        queryAlbums.setString(1, name);
        ResultSet results = queryAlbums.executeQuery();

        if (results.next()) {
            return results.getInt(1);
        } else {
//            Insert the album .
            insertIntoAlbum.setString(1, name);
            insertIntoAlbum.setInt(2, artistId);
            int affecedRow = insertIntoAlbum.executeUpdate();

            if (affecedRow != 1) {
                throw new SQLException("Couldn't insert album");
            }
        }
        ResultSet generatedKeys = insertIntoAlbum.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        } else {
            throw new SQLException("Cannot get id for artist");
        }
    }


    public void insertSong(String title, String artist, String album, int track) {
        try {
            querySongs.setString(1, title);
            ResultSet results = querySongs.executeQuery();

            if (results.next()) {
                System.out.println("Query already exits");
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error while quiering song " + e.getMessage());
            e.printStackTrace();
            return;
        }

        try {
            connection.setAutoCommit(false);

            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);
            insertIntoSong.setInt(1, track);
            insertIntoSong.setString(2, title);
            insertIntoSong.setInt(3, albumId);

            int affecedRow = insertIntoSong.executeUpdate();

            if (affecedRow == 1) {
                connection.commit();
            } else {
                throw new SQLException("The song insertion failed");
            }

        } catch (Exception e) {
            System.out.println("Error while inserting song : " + e.getMessage());
            e.printStackTrace();
            try {
                System.out.println("performing rollback");
                connection.rollback();
            } catch (SQLException p) {
                System.out.println("Ho boy ! Roll back error : " + p.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting commit");
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Cannot reset commit.");
            }

        }
    }
}

