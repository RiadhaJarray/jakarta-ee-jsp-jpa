<jsp:useBean id="customer" class="beans.Client" scope="request" />
<jsp:setProperty name="customer" property="firstName" />
<jsp:setProperty name="customer" property="lastName" />
<jsp:setProperty name="customer" property="address" />
<jsp:setProperty name="customer" property="id" />


<body>
<form action="controleur" method="post">
<table cellspacing="3" cellpadding="3" border="1" width="60%">
<input type="hidden" name="id" value=${requestScope.customer.id}>	
<input type="hidden" name="action" value="editcustomerexe" />
<tr>
<td><b>Pr�nom :</b> 
  <td><input type="text" name="firstname" value="${requestScope.customer.firstName}" />
  </td>
</tr>
<tr>
	<td><b>Nom :</b> 
  <td><input type="text" name="lastname" value="${requestScope.customer.lastName}"/></td>
</tr>
<tr>
	<td><b>Adresse :</b> 
  <td><input type="text" size="50" name="address" value="${requestScope.customer.address}" /></td>
</tr>
<tr>
	<td><b>Code Postal :</b> 
  <td><input type="text" size="50" name="codePostal" value="${requestScope.customer.codePostal}" /></td>
</tr>
<tr>
	<td><b>Ville :</b> 
  <td><input type="text" size="50" name="ville" value="${requestScope.customer.ville}" /></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="Valider"></td>
</tr>
</table>
</form>

<jsp:include page="/WEB-INF/jspf/piedDePage.jsp" flush="true" />