<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  	<meta charset="utf-8">
	<title>Magasin de CDs</title>
</head>

<body>
	<h1>
	Il y a eu un probl�me ! <br>
	<%= exception.toString() %>
	<% exception.printStackTrace(); %>
	<a href="controleur?action=accueil">Cliquez ici pour retourner � la page d'accueil</a>.
	</h1>
</body>
</html>