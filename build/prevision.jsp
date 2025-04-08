<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style1.css">
    <title>Prevision</title>
</head>
<body>
<div class="container">
            <div class="form-container">
    <% String erreur = (String) request.getAttribute("erreur"); %>
<% if (erreur != null) { %>
    <p style="color:red;"><%= erreur %></p>
<% } %>

<% String succes = (String) request.getAttribute("succes"); %>
<% if (succes != null) { %>
    <p style="color:green;"><%= succes %></p>
<% } %>

    <form method="post" action="insertCredit">
        <div class="form-group">
            <label>libelle :</label>
            <input type="text" name="libelle" required><br>
        </div>
        <div class="form-group">
            <label>montant :</label>
            <input type="text" name="montant" required><br>
        </div>
        <div class="flex justify-between items-center">
            <input type="submit" value="valider">
            <div class="nav-links">
                <a href="dashboard">dashboard</a>
            </div>
        </div>
    </form>
</div>
    </div>
</body>
</html>
