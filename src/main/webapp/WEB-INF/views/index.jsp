<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/>" />
</head>
  <body>
  <div class="">
    <h3>Adicionar tarefas</h3>
    <form action="login" method="post">
    <label>Login:</label>  
    <input type="text" name="login"/>  
    <label>Senha:</label>
    <input type="password" name="senha"/>   
      <input type="submit" value="Adicionar">
    </form>
    </div>
  </body>
</html>