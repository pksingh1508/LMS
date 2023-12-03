
package gui.com;

import java.util.ArrayList;
import java.util.HashMap;

class Book {
    String bookNo;
    String bookName;
    String bookAuthor;
    int bookQuantity;
    
    Book(String bookNo, String bookName, String bookAuthor, int bookQuantity) {
       this.bookNo = bookNo;
       this.bookName = bookName;
       this.bookAuthor = bookAuthor;
       this.bookQuantity = bookQuantity;
    }
    @Override
    public String toString() {
        return bookName + " by " + bookAuthor + " ( Book No - " + bookNo + ") - Quantity: " + bookQuantity;
    }
    
}

class Librarian {
    String name;
    HashMap<Book, Integer> issuedBooks;

    public Librarian(String name) {
        this.name = name;
        this.issuedBooks = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void issueBook(Book book, int quantity) {
        int currentQuantity = issuedBooks.getOrDefault(book, 0);
        issuedBooks.put(book, currentQuantity + quantity);
    }

    public HashMap<Book, Integer> getIssuedBooks() {
        return issuedBooks;
    }
}

class Library {
    public ArrayList<Book> books;
    public ArrayList<Librarian> librarians;

    public Library() {
        this.books = new ArrayList<>();
        this.librarians = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Librarian> getLibrarians() {
        return librarians;
    }

    public Librarian findLibrarianByName(String name) {
        for (Librarian librarian : librarians) {
            if (librarian.getName().equals(name)) {
                return librarian;
            }
        }
        return null;
    }

    public ArrayList<Book> searchBooksByName(String name) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.bookName.toLowerCase().contains(name.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }
}

public class Database {
    public static void main(String[] args) {
        Library l = new Library();
        ArrayList<Book> result = l.getBooks();
        System.out.println("Hello database");
        for (Book bks : result) {
            System.out.println(bks);
        }
    }
}
