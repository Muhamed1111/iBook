package ba.unsa.etf.rpr.ibook.Dao;

import ba.unsa.etf.rpr.ibook.Domain.Author;
import ba.unsa.etf.rpr.ibook.Exceptions.BookException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class AuthorDaoSQLImpl extends AbstractDao<Author> implements AuthorDao {
    private static AuthorDaoSQLImpl instance = null;
    private AuthorDaoSQLImpl() {
        super("Author");
    }

    public static AuthorDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new AuthorDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Author row2object(ResultSet rs) throws BookException {
        try {
            Author auth = new Author();
            auth.setId(rs.getInt("id"));
            auth.setName(rs.getString("name"));
            return auth;
        } catch (SQLException e) {
            throw new BookException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Author object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        return row;
    }
}
