package ba.unsa.etf.rpr.ibook.Domain;

import ba.unsa.etf.rpr.ibook.Dao.Idable;

import java.util.Objects;

public class Book implements Idable {
    private int id;
    private String title;
    private String genre;
    private Author author;
    private Boolean leased;
    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Boolean getLeased() {
        return leased;
    }

    public void setLeased(Boolean leased) {
        this.leased = leased;
    }

    public User getUser() {
        return user;
    }

    @Override
    public int getId() {
        return id;
    }

    public Book() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getId() == book.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public Book(String title, String genre, Author author, Boolean leased, User user) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.leased = leased;
        this.user = user;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
