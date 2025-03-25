package org.book.booksdemo.dao;
import org.book.booksdemo.metier.Livre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class LivreDAO {

    private String dbURL = "jdbc:postgresql://localhost:5432/bookeapp";
    private String dbUser = "admin";
    private String dbPassword = "admin";

    public LivreDAO() {
        loadDriver();
    }

    // Load PostgreSQL JDBC Driver
    public void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Open database connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }

    public void addLivre(Livre livre) throws ClassNotFoundException {
        try (Connection con = getConnection();
             PreparedStatement ps = con
                     .prepareStatement("insert into books (isbn,titre,auteur,pages) values(?,?,?,?)")) {
            ps.setString(1, livre.getIsbn());
            ps.setString(2, livre.getTitre());
            ps.setString(3, livre.getAuteur());
            ps.setInt(4, livre.getPages());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error adding livre: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Livre> getBooks() throws SQLException {
        List<Livre> booksList = new ArrayList<Livre>();
        try (Connection con = getConnection(); Statement ps = con.createStatement()) {
            ResultSet rs = ps.executeQuery("select * from books");

            while (rs.next()) {
                String isbn = rs.getString("isbn");
                String titre = rs.getString("titre");
                String auteur = rs.getString("auteur");
                int pages = rs.getInt("pages");
                booksList.add(new Livre(isbn, titre, auteur, pages));
            }

        }
        return booksList;
    }
}
