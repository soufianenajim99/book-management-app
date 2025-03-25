package org.book.booksdemo.Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.book.booksdemo.metier.Livre;
import org.book.booksdemo.services.LivreService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletAjout", urlPatterns = {"/ServletAjout"})
public class ServletAjout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String idParam = request.getParameter("id");
        LivreService livreService = new LivreService();

        if (action != null && idParam != null) {
            int id = Integer.parseInt(idParam);
            switch (action) {
                case "supprimer":
                    livreService.supprimerLivre(id);
                    break;
                case "modifier":
                    Livre livre = livreService.getLivreById(id);
                    request.setAttribute("livre", livre);
                    request.getRequestDispatcher("modifierLivre.jsp").forward(request, response);
                    return;
            }
        }

        List<Livre> livres = livreService.getAllLivres();
        request.setAttribute("livres", livres);
        request.getRequestDispatcher("livres.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String isbn = request.getParameter("isbn");
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        int pages = Integer.parseInt(request.getParameter("pages"));

        LivreService livreService = new LivreService();

        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            livreService.modifierLivre(id, isbn, titre, auteur, pages);
        } else {
            livreService.ajouterLivre(isbn, titre, auteur, pages);
        }

        response.sendRedirect("ServletAjout");
    }
}