package org.book.booksdemo.dao;

import jakarta.persistence.*;
import org.book.booksdemo.metier.Livre;

import java.util.List;

public class GestionLivre {
    private EntityManagerFactory emf;
    private EntityManager em;

    public GestionLivre() {
        try {
            emf = Persistence.createEntityManagerFactory("Biblio");
            em = emf.createEntityManager();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize JPA", e);
        }
    }

    public void ajouterLivre(Livre livre) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(livre);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            throw e;
        }
    }

    public List<Livre> tousLesLivres() {
        Query query = em.createQuery("SELECT l FROM Livre l", Livre.class);
        return query.getResultList();
    }

    public Livre rechercherParId(int id) {
        return em.find(Livre.class, id);
    }

    public void supprimerLivre(int id) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Livre livre = em.find(Livre.class, id);
            if (livre != null) {
                em.remove(livre);
            }
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            throw e;
        }
    }

    public void modifierLivre(Livre livre) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(livre);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            throw e;
        }
    }

    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
}
