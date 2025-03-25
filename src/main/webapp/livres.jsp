<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Liste des Livres</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Liste des Livres</h1>
    <div class="table-container">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>ISBN</th>
                <th>Titre</th>
                <th>Auteur</th>
                <th>Pages</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${livres}" var="livre">
                <tr>
                    <td>${livre.id}</td>
                    <td>${livre.isbn}</td>
                    <td>${livre.titre}</td>
                    <td>${livre.auteur}</td>
                    <td>${livre.pages}</td>
                    <td class="action-links">
                        <a href="./ServletAjout?action=supprimer&id=${livre.id}">Supprimer</a>
                        <a href="./ServletAjout?action=modifier&id=${livre.id}">Modifier</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="ajouterLivre.jsp" class="nav-link">Ajouter un nouveau livre</a>
</div>
</body>
</html>