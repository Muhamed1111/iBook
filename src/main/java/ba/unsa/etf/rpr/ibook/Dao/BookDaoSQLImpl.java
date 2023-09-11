package ba.unsa.etf.rpr.ibook.Dao;

import ba.unsa.etf.rpr.ibook.Domain.Book;
import ba.unsa.etf.rpr.ibook.Domain.Book;
import ba.unsa.etf.rpr.ibook.Exceptions.BookException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class BookDaoSQLImpl extends AbstractDao<Book> implements BookDao {
    private static BookDaoSQLImpl instance = null;
    private BookDaoSQLImpl() {
        super("Book");
    }

    public static BookDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new BookDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Book row2object(ResultSet rs) throws BookException {
        try {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setGenre(rs.getString("genre"));
            book.setLeased(rs.getBoolean("leased"));
            book.setAuthor(DaoFactory.authorDao().getById(rs.getInt("id")));
            book.setUser(DaoFactory.userDao().getById(rs.getInt("id")));
            return book;
        } catch (SQLException e) {
            throw new BookException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Book object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("title", object.getTitle());
        row.put("genre", object.getGenre());
        row.put("leased", object.getLeased());
        row.put("authorid", object.getAuthor().getId());
        row.put("userid", object.getUser().getId());
        return row;
    }
}
