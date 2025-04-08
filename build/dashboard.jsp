<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style1.css">
    <title>Document</title>
</head>
<body>
<div class="container">
            <div class="form-container">

        <% 
        List<Dashboard> dash = (List<Dashboard>) request.getAttribute("listDash"); 
        
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>credit</th>
                    <th>Total</th>
                    <th>reste</th>
                </tr>
            </thead>
            <tbody>
            <% for (Dashboard db : dash) { %>
            <tr>
                <td><%= db.getCreditLibelle() %></td>
                <td><%= db.getMontantDepense() %></td>
                <td><%= db.getReste() %></td>
            </tr>
            <% } %>
            </tbody>

        </table>

        <div class="nav-links" style="margin-top: 2rem;">
            <a href="formPrevision"><button>prevision</button></a>
            <a href="formDepense"><button>depense</button></a> 
        </div>

    </div>
    </div>
</div>
</body>
</html>