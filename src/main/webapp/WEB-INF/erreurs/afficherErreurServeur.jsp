<%-- Cette page JSP est d�finie comme une page erreur en positionnant � true 
l'attribut isErrorPage de la directive page 
Possibilit� de manipuler l'exception qui a �t� lanc�e par l'objet implicite exception (exception)
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="fr">
<head>
  	<meta charset="utf-8">
	<title>Page d'erreur</title>
</head>

<body>
<h1>Il y a eu un probl�me ! </h1>

<a href="controleur?action=accueil">Cliquez ici pour retourner � la page d'accueil</a>
</body>
</html>