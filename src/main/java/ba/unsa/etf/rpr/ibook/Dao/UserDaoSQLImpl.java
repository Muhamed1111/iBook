package ba.unsa.etf.rpr.ibook.Dao;

import ba.unsa.etf.rpr.ibook.Domain.User;
import ba.unsa.etf.rpr.ibook.Exceptions.BookException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{
    private static UserDaoSQLImpl instance = null;
    private UserDaoSQLImpl() {
        super("User");
    }

    public static UserDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new UserDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public User row2object(ResultSet rs) throws BookException {
        try {
            User auth = new User();
            auth.setId(rs.getInt("id"));
            auth.setUsername(rs.getString("username"));
            auth.setPassword(rs.getString("password"));
            return auth;
        } catch (SQLException e) {
            throw new BookException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("username", object.getUsername());
        row.put("password",object.getPassword());
        return row;
    }
}
