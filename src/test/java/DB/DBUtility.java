package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {

    public static Statement statement;
    public static Connection connection;

    public static ArrayList<ArrayList<String>> getListData(String query) {
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();
        // DB den bütün satırları ve kolonları okuyup liste atıcam

        //1- db bağlantısını aç
        DBConnectionOpen();

        //2- sorguyu calistir
        try {
            ResultSet rs = statement.executeQuery(query);
            int kolonSayisi = rs.getMetaData().getColumnCount();

            //3- bütün satırları ve o satırlardaki sütunları oku Tabloya ekle
            while (rs.next()) {

                ArrayList<String> satir = new ArrayList<>();
                for (int i = 1; i <= kolonSayisi; i++)
                    satir.add(rs.getString(i));

                tablo.add(satir);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //4- db bağlantısını kapat
        DBConnectionClose();
        return tablo;
    }

    public static void DBConnectionOpen() {
        String url = "url for DB";
        String username = "username";
        String password = "password";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void DBConnectionClose() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}