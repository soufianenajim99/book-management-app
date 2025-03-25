package org.book.booksdemo.services;


import org.book.booksdemo.dao.GestionLivre;
import org.book.booksdemo.metier.Livre;

import java.util.List;

public class LivreService {
    private GestionLivre gestionLivre;

    public LivreService() {
        this.gestionLivre = new GestionLivre();
    }

    public void ajouterLivre(String isbn, String titre, String auteur, int pages) {
        Livre livre = new Livre(isbn, titre, auteur, pages);
        gestionLivre.ajouterLivre(livre);
    }

    public List<Livre> getAllLivres() {
        return gestionLivre.tousLesLivres();
    }

    public Livre getLivreById(int id) {
        return gestionLivre.rechercherParId(id);
    }

    public void supprimerLivre(int id) {
        gestionLivre.supprimerLivre(id);
    }

    public void modifierLivre(int id, String isbn, String titre, String auteur, int pages) {
        Livre livre = gestionLivre.rechercherParId(id);
        if (livre != null) {
            livre.setIsbn(isbn);
            livre.setTitre(titre);
            livre.setAuteur(auteur);
            livre.setPages(pages);
            gestionLivre.modifierLivre(livre);
        }
    }
}