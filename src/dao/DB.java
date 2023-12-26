package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
    //pour la connexion;
    private Connection cnx;

    //pour les requetes preparees
    private PreparedStatement pstm;

    //pour les resultat des requettes;
    private ResultSet rs;

    //pour les resultats des requette de type mise a jour
    private int ok;

    public void getConnexion(){
        String host = "localhost";
        String dataBase = "java";
        int port = 3306;
        String user = "root";
        String mdp = "";
        String url = "jdbc:mysql://"+host+":"+port+"/"+dataBase;

        try {
            cnx = (Connection) DriverManager.getConnection(url, user, mdp);
            System.out.println("la connexion est reussi :"+cnx);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void initPrepare(String sql){
        try {
            getConnexion();
            pstm = (PreparedStatement) cnx.prepareStatement(sql);
            System.out.println("succes pstm");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public ResultSet executeRequet(){
        rs = null;
        try {
            rs = pstm.executeQuery();
            System.out.println("succes resultat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeMaj(){
        try {
            ok = pstm.executeUpdate();
            System.out.println("succes executeMaj");
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    public void closeConnexion(){
        try {
            if(cnx != null){
                cnx.close();
                System.out.println("succes close cnx");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public PreparedStatement getPstm() {
        return pstm;
    }
}
