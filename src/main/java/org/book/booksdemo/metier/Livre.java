package org.book.booksdemo.metier;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Livre {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String isbn;
    private String titre;
    private String auteur;
    private int pages;

    public Livre(String isbn, String titre, String auteur, int pages) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.pages = pages;
    }

    public Livre() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}

