<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style1.css">
    <title>login</title>
</head>
<body>
<div class="container">
            <div class="form-container">
    <% String erreur = (String) request.getAttribute("erreur"); %>
    <% if (erreur != null) { %>
        <p style="color:red;"><%= erreur %></p>
    <% } %>
        <form method="post" action="login">
            <div class="form-group">
                <label>Nom d'utilisateur :</label>
                <input type="text" name="username" value = "user1@gmail.com" required><br>
            </div>
            <div class="form-group">
                <label>Mot de passe :</label>
                <input type="password" name="password" value = "1234" required><br>
            </div>
            <div class="flex justify-between items-center">
                <input type="submit" value="Se connecter">
            </div>
        </form>
</div>
    </div>
</body>
</html>
