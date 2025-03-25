<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Modifier Livre</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Modifier Livre</h1>
    <div class="form-container">
        <form action="ServletAjout" method="post">
            <input type="hidden" name="id" value="${livre.id}">
            <div class="form-group">
                <label for="isbn">ISBN:</label>
                <input type="text" id="isbn" name="isbn" value="${livre.isbn}" required>
            </div>
            <div class="form-group">
                <label for="titre">Titre:</label>
                <input type="text" id="titre" name="titre" value="${livre.titre}" required>
            </div>
            <div class="form-group">
                <label for="auteur">Auteur:</label>
                <input type="text" id="auteur" name="auteur" value="${livre.auteur}" required>
            </div>
            <div class="form-group">
                <label for="pages">Pages:</label>
                <input type="number" id="pages" name="pages" value="${livre.pages}" required>
            </div>
            <button type="submit" class="btn">Modifier</button>
        </form>
    </div>
</div>
</body>
</html>