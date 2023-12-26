package dao;

import entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersImpl implements IUsers{

    private DB db = new DB();
    private ResultSet rs;
    private int ok;

    @Override
    public int add(Users users) {
        String sql = "INSERT INTO USERyy(id, nom, email, mdp) VALUES(null, ?, ?, ?)";
        try {
            //initialisation de la requette
            db.initPrepare(sql);


            //passage des valeurs dans la requette;
            db.getPstm().setString(1, users.getNom());
            db.getPstm().setString(2, users.getEmail());
            db.getPstm().setString(3, users.getMdp());
            System.out.println("succes ajout");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ok;
    }

    @Override
    public int update(Users users) {


        return 0;
    }

    @Override
    public int delete(Users users) {
        return 0;
    }

    @Override
    public List<Users> list() {
        return null;
    }

    @Override
    public Users get(int id) {
        return null;
    }
}
