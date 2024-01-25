<%@ page errorPage = "/erreurs/afficherErreurServeur.jsp" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<body>
<table cellspacing="3" cellpadding="3" border="1" width="500">
<tr>
	<td colspan="4"><b>Liste des clients avec JSTL</b></td>
</tr>
<tr>
	<td><b>Identifiant</b></td>
	<td><b>Prénom</b></td>
	<td><b>Nom</b></td>
	<td><b>Adresse</b></td>
	<td><b>Code Postal</b></td>
	<td><b>Ville</b></td>
</tr>
<c:forEach var="customer" items="${requestScope.customers}">
<tr>
	<td>
		<a href="controleur?action=displaycustomer&id=${customer.id}">
			${customer.id}
		</a>
		
		<form action="controleur?action=supprimercustomer&id=${customer.id}" method="post">
			<img src="${pageContext.request.contextPath}/images/delete.jpg" style="width: 50px; height: 50px;"/>
            <input type="submit" value="Supprimer" />
        </form>
	</td>
	<td>${customer.firstName}</td>
	<td>${customer.lastName}</td>
	<td>${customer.address}</td>
	<td>${customer.codePostal}</td>
	<td>${customer.ville}</td>
</tr>
</c:forEach>
</table>
<a href="controleur?action=addcustomerexe">Ajouter un client</a>
<a href="controleur?action=accueil">Retour à la page d'accueil</a>
<jsp:include page="/WEB-INF/jspf/piedDePageAvecParametre.jsp" flush="true" >
	<jsp:param name="titre" value="Afficher la liste des clients"/>
</jsp:include>