package sample.util;


import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import sample.model.Client;
import sample.model.User;

import java.io.*;
import java.sql.*;

public class DatabaseHandler {




    public static Connection GetDatabaseConnection() {
        Connection connection = null;


        String dbUrl = "jdbc:mysql://localhost:3306/agence_voyage";
        String user = "root";
        String pass = "";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, user, pass);

//            System.out.println("connection successful");

        } catch (ClassNotFoundException e) {
            e.getLocalizedMessage();
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getLocalizedMessage();
        }

        return connection;
    }
    public static boolean retreiveIdadm(int idadm)
    {
        Connection connection = GetDatabaseConnection();
        String checkQuery = "select * from admin where id_user=?";
        boolean status=false;
        PreparedStatement preparedStatement = null;


        try {
            preparedStatement = connection.prepareStatement(checkQuery);
            preparedStatement.setInt(1,idadm);
            ResultSet resultSet = preparedStatement.executeQuery();



            status = resultSet.next();
            preparedStatement.close();


        } catch (SQLException e) {
//
            e.printStackTrace();
        }
        return status;
    }
    public static boolean confirmadm(String mat)
    {
        Connection connection = GetDatabaseConnection();
        String checkQuery = "select * from admin where matricul=?";
        boolean status=false;
        PreparedStatement preparedStatement = null;


        try {
            preparedStatement = connection.prepareStatement(checkQuery);
            preparedStatement.setString(1,mat);
            ResultSet resultSet = preparedStatement.executeQuery();



            status = resultSet.next();
            preparedStatement.close();


        } catch (SQLException e) {
//
            e.printStackTrace();
        }
        return status;
    }
    public static boolean CheckLoginUser(String email, String pass) { 
        Connection connection = GetDatabaseConnection();
//       boolean
        String checkQuery = "select * from user where email_user = ? and password_user = ? "; //


        PreparedStatement preparedStatement = null;
        boolean status = false;

        try {
            preparedStatement = connection.prepareStatement(checkQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();

          

            status = resultSet.next();
            preparedStatement.close();
            return status;

        } catch (SQLException e) {
//          
            e.printStackTrace();
        }
        return status;
    }

  /*  public static boolean ChecksignupUser(String email, String pass)   {
        Connection con = GetDatabaseConnection();
//
        String checkQuery = "INSERT INTO user (email_user, password_user) VALUES (?,?)";

        PreparedStatement preparedStatemen = null;
        boolean status = false;

        try {
            preparedStatemen = con.prepareStatement(checkQuery);
            preparedStatemen.setString(1, email);
            preparedStatemen.setString(2, pass);
            preparedStatemen.executeUpdate();

            preparedStatemen.close();
            return status;

        } catch (SQLException e) {
//
            e.printStackTrace();
        }
        return status;
    }
*/
    public static void ChecksignupUser(String email, String pass) {
        String sql =  "INSERT INTO user (email_user, password_user) VALUES (?,?)";

        try (Connection conn = GetDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, pass);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void  updatepassword(String current, String newPass ,String email)
    {
        String sql =  "UPDATE user SET password_user = ? WHERE password_user = ? and email_user=?";
        try (Connection conn = GetDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newPass);
            pstmt.setString(2, current);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void  Deleteaccount(int use)
    {
        String sql =  "DELETE FROM client where id_user=?;";

        try (Connection conn = GetDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, use);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Deletefromuser(use);

    }
    public static void  Deletefromuser(int use)
    {
        String sql =  "DELETE FROM client where id_user=?;";

        try (Connection conn = GetDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, use);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static int ChecksignupUserbo(String email, String pass , String cin, String numtel,String nom) {
        inserttouser(email,pass);
       int id_usr=retrieveIdUser(email);
        String sql =  "INSERT INTO client (nom_client,prenom_client,CIN,adresse_client,tel_client,cp_client,id_user) VALUES (?,null,?,null,?,null,"+id_usr+")";
        int status=0;
        try (Connection conn = GetDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nom);
            pstmt.setString(2, cin);
            pstmt.setString(3, numtel);


           status= pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
    public static void inserttouser(String email, String pass ) {
        String sql =  "INSERT INTO user (email_user, password_user) VALUES (?,?);";

        try (Connection conn = GetDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, pass);


            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static int retrieveIdUser(String email)
    {
        String selectStmt = "SELECT id_user FROM user WHERE email_user= ?";

        int i=0;
        //Execute SELECT statement
        //Get ResultSet from dbExecuteQuery method
        try (Connection conn = GetDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectStmt)) {
            pstmt.setString(1, email);
            ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next()) {
                i = resultSet.getInt("id_user");
            }
          System.out.println(i);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return i;
    }
    public static int udloadimage(int id, FileInputStream image , File select)
    {
        String sql =  "UPDATE user set image=? where id_user = ?";
        int status=0;
        try (Connection conn = GetDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(2, id);
            pstmt.setBinaryStream(1, (InputStream) image ,(int)select.length());
            status= pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
    private static Client getClientResultset(ResultSet rs) throws SQLException {
        Client cl=null;
        if (rs.next()) {
            cl = new Client();
            cl.setNom_client(rs.getString("nom_client"));
            cl.setAdresse_client(rs.getString("adresse_client"));
            cl.setPrenom_client(rs.getString("prenom_client"));
            cl.setTel_client(rs.getString("tel_client"));
            cl.setCp_client(rs.getString("cp_client"));
            cl.setCin(rs.getString("cin"));

        }
        return cl;
    }
    public static Client clientprofile(int userId)
    {
        String selectStmt = "SELECT * FROM client WHERE id_user= ?";
        Client cl=null;

        try (Connection conn = GetDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectStmt)) {
            pstmt.setInt(1, userId);
            ResultSet resultSet = pstmt.executeQuery();
           cl= getClientResultset(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return cl;
    }
    private static User getUserFromResultSet(ResultSet rs) throws SQLException
    {

        User us=null;
        if (rs.next()) {
            us = new User();
            us.setEmail_user(rs.getString("email_user"));
            us.setPassword_user(rs.getString("password_user"));


        }
        return us;
    }
    public static User userprofile (int userId) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM user WHERE id_user= ?";
        User us=null;
        //Execute SELECT statement

        try (Connection conn = GetDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectStmt)) {
            pstmt.setInt(1, userId);
            ResultSet resultSet = pstmt.executeQuery();
             us = getUserFromResultSet(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return us;
    }
    public static int image(int userId) throws SQLException, IOException {
        String selectStmt = "SELECT * FROM user WHERE id_user= ?";
        int status=0;
        InputStream is = null;
        try (Connection conn = GetDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectStmt)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
              is = rs.getBinaryStream("image");


            }
            if(is!=null) {
                status=1;
            OutputStream os =new FileOutputStream(new File("photo.jpg"));
            byte [] content = new byte[1024];
            int size=0;
            while((size=is.read(content))!=-1)
            {
                os.write(content,0,size);

            } }
        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return status;


    }
    public static void updateInfo( String nom_client,String prenom_client,String CIN,String adresse_client,String tel_client,String cp_client,int id_) {
        String sql =  "UPDATE client set  nom_client=?,prenom_client=?,CIN=?,adresse_client=?,tel_client=?,cp_client=? where id_user=? ;";

        try (Connection conn = GetDatabaseConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,nom_client );
            pstmt.setString(2, prenom_client);
            pstmt.setString(3, CIN);
            pstmt.setString(4, adresse_client);
            pstmt.setString(5, tel_client);
            pstmt.setString(6, cp_client);
            pstmt.setInt(7, id_);


            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
