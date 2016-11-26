
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form name='loginForm'
	action="<c:url value='singup' />" method='POST'>

	<table>
		<tr>
			<td>User:</td>
			<td><input type='text' name='nomeUsuario' value=''></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='senha' /></td>
		</tr>
		<tr>
			<td colspan='2'><input name="submit" type="submit"
				value="submit" /></td>
		</tr>
	</table>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />

</form>