<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/4/2025
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter Livre</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Ajouter un nouveau livre</h1>
    <div class="form-container">
        <form action="ServletAjout" method="post">
            <div class="form-group">
                <label for="isbn">ISBN:</label>
                <input type="text" id="isbn" name="isbn" required>
            </div>
            <div class="form-group">
                <label for="titre">Titre:</label>
                <input type="text" id="titre" name="titre" required>
            </div>
            <div class="form-group">
                <label for="auteur">Auteur:</label>
                <input type="text" id="auteur" name="auteur" required>
            </div>
            <div class="form-group">
                <label for="pages">Pages:</label>
                <input type="number" id="pages" name="pages" required>
            </div>
            <button type="submit" class="btn">Ajouter</button>
        </form>
    </div>
    <a href="ServletAjout" class="nav-link">Voir la liste des livres</a>
</div>
</body>
</html>



