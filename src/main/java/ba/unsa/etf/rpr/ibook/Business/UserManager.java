package ba.unsa.etf.rpr.ibook.Business;
import ba.unsa.etf.rpr.ibook.Dao.DaoFactory;
import ba.unsa.etf.rpr.ibook.Domain.User;

import java.util.List;

public class UserManager {
    public Boolean validUsername(String username){
        if (username.isEmpty())return false;
        try{
            List<User> users = DaoFactory.userDao().getAll();
            System.out.println(users);
            for(User u : users){
                if (u.getUsername().equals(username)){
                    return false;
                }
            }
            return true;
        }
        catch(Exception e){
            System.out.println(e.getCause());
        }
        return false;
    }

    public Boolean authenticate(String username, String password){
        try{
            List<User> users = DaoFactory.userDao().getAll();
            for (User u : users){
                if (u.getUsername().equals(username)){
                    if (u.getPassword().equals(password))
                        return true;
                    else return false;
                }
            }
            return false;
        }
        catch(Exception e){
            System.out.println(e.getCause());
        }
        return false;
    }

    public Boolean fieldsEmpty(String ... fields){
        for(String f : fields){
            if (f.isEmpty())return true;
        }
        return false;
    }

    public Boolean passwordsMatch(String pass, String repeat){
        return pass.equals(repeat);
    }


}
