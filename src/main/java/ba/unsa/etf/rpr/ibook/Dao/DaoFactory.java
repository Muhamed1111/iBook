package ba.unsa.etf.rpr.ibook.Dao;

public class DaoFactory {
    private static final BookDao bookDao = BookDaoSQLImpl.getInstance();
    private static final AuthorDao authorDao = AuthorDaoSQLImpl.getInstance();
    private static final UserDao userDao = UserDaoSQLImpl.getInstance();
    private DaoFactory(){
    }

    public static BookDao bookDao(){
        return bookDao;
    }

    public static AuthorDao authorDao(){
        return authorDao;
    }

    public static UserDao userDao(){
        return userDao;
    }
}
