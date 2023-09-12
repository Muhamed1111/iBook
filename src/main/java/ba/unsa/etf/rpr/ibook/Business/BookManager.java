package ba.unsa.etf.rpr.ibook.Business;

import ba.unsa.etf.rpr.ibook.Dao.DaoFactory;
import ba.unsa.etf.rpr.ibook.Domain.Author;
import ba.unsa.etf.rpr.ibook.Domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    public List<Book> getAllBooks(){
        try{
            List<Book> b = DaoFactory.bookDao().getAll();
            return b;
        }catch(Exception e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());

        }
        return new ArrayList<Book>();
    }
    public List<Book> getByTitle(List<Book> books, String title){
        List<Book> result=new ArrayList<Book>();
        for(Book i: books){
            if(i.getTitle().toUpperCase().contains(title.toUpperCase())){
                result.add(i);
            }
        }
        return result;
    }
    public List<Book> getByAuthorName(List<Book> books,String author){
        List<Book> result=new ArrayList<>();
        for(Book i: books){
            if(i.getAuthor().getName().toUpperCase().contains(author.toUpperCase())){
                result.add(i);
            }
        }
        return result;
    }
    public List<Book> getByGenre(List<Book> books,String genre){
        List<Book> result =new ArrayList<>();
        for(Book i: books){
            if(i.getGenre().toUpperCase().contains(genre.toUpperCase())){
                result.add(i);
            }
        }
        return result;
    }
}
