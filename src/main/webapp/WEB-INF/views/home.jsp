<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Pedidos Músicas</title>
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.css'/>"
	media="screen" title="no title">
<script src="<c:url value='/assets/js/bootstrap.js'/>"></script>

<style media="screen">
a {
	color: white !important;
	margin-right: 20px;
	font-weight: bold;
	font-size: 15px;
}

.search {
	font-size: 10px;
}

small {
	font-size: 25px;
}

.navbar {
	padding-top: 10px;
}
</style>
</head>
<body>
	<div class="navbar navbar-dark bg-primary">
		<div class="col-lg-offset-6 col-md-6 text-right">
			<a href="#"><small class="glyphicon glyphicon-tasks"></small>
				Backup</a> <a href="/radio/pedidos"><small
				class="glyphicon glyphicon-music"></small> Pedido de Músicas</a> <a
				href="/radio/ouvinte"><small
				class="glyphicon glyphicon-headphones"></small> Ouvintes</a> <a href="#"><small
				class="glyphicon glyphicon-user"></small> Usuários</a> <a href="#"><small
				class="glyphicon glyphicon-log-out"></small> Sair</a>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<h2>
				<small class="glyphicon glyphicon-home"></small>
			</h2>

			<div class="col-lg-7 col-md-6">
				<h4>Pedidos de Músicas</h4>
				<table class="table">
					<tr>
						<td>#</td>
						<td>Nome da Música</td>
						<td>Nome do Ouvinte</td>
						<td>Oferecimento</td>
						<td>Ações</td>
					</tr>
					<c:forEach items='${pedidos.currentList}' var='pedido'>
					<tr>
						<td>${pedido.idPedido}</td>
						<td>Nome da Música</td>
						<td>Nome do Ouvinte</td>
						<td>Oferecimento</td>
						<td>Ações</td>
					</tr>
					</c:forEach>
				</table>
			</div>

			<div class="col-lg-5 col-md-6">
				<h4>Aniversariantes</h4>
				<table class="table">
					<tr>
						<td>#</td>
						<td>Nome do Aniversariante</td>
						<td>Data de Nascimento</td>
						<td>Ações</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
