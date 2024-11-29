<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="assets/js/color-modes.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lista de Usuários</title>
<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<!-- IGNORE ESSA PARTE -->
	<!-- ----------------------------------------------------------------------------------------------------------- -->

	<div
		class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle">
		<button
			class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center"
			id="bd-theme" type="button" aria-expanded="false"
			data-bs-toggle="dropdown" aria-label="Toggle theme (auto)">
			<svg class="bi my-1 theme-icon-active" width="1em" height="1em">
				<use href="#circle-half"></use></svg>
			<span class="visually-hidden" id="bd-theme-text">Mudar o tema</span>
		</button>
		<ul class="dropdown-menu dropdown-menu-end shadow"
			aria-labelledby="bd-theme-text">
			<li>
				<button type="button"
					class="dropdown-item d-flex align-items-center"
					data-bs-theme-value="light" aria-pressed="false">
					<svg class="bi me-2 opacity-50" width="1em" height="1em">
						<use href="#sun-fill"></use></svg>
					Claro
					<svg class="bi ms-auto d-none" width="1em" height="1em">
						<use href="#check2"></use></svg>
				</button>
			</li>
			<li>
				<button type="button"
					class="dropdown-item d-flex align-items-center"
					data-bs-theme-value="dark" aria-pressed="false">
					<svg class="bi me-2 opacity-50" width="1em" height="1em">
						<use href="#moon-stars-fill"></use></svg>
					Escuro
					<svg class="bi ms-auto d-none" width="1em" height="1em">
						<use href="#check2"></use></svg>
				</button>
			</li>
			<li>
				<button type="button"
					class="dropdown-item d-flex align-items-center active"
					data-bs-theme-value="auto" aria-pressed="true">
					<svg class="bi me-2 opacity-50" width="1em" height="1em">
						<use href="#circle-half"></use></svg>
					Automático
					<svg class="bi ms-auto d-none" width="1em" height="1em">
						<use href="#check2"></use></svg>
				</button>
			</li>
		</ul>
	</div>
	<!-- ----------------------------------------------------------------------------------------------------------- -->

	<div class="container">
		<h1 class="mt-5">Lista de Usuários</h1>
		<form action="searchUsers" method="get" class="mb-3">
			<input type="text" name="query" class="form-control"
				placeholder="Pesquisar usuários por nome ou email">
			<button type="submit" class="btn btn-primary mt-2">Pesquisar</button>
		</form>
		<div class="d-flex justify-content-end">
    		<form action="login" method="post">
        	<button class="btn btn-danger w-100 p-1" type="submit">Sair</button>
    	</form>
		</div>
		<form action="showActivities" method="get" style="display:inline;">
            <input type="hidden" name="id" value="${usuario.id}">
            <button type="submit" class="btn btn-info">Mostrar Atividades</button>
        </form>
		<table class="table table-striped mt-3">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios}">
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.nome}</td>
						<td>${usuario.email}</td>
						<td>
							<form action="editUser" method="get" style="display: inline;">
								<input type="hidden" name="id" value="${usuario.id}">
								<input type="submit" value="Editar" class="btn btn-primary">
							</form>
							<form action="deleteUser" method="post" style="display: inline;"onsubmit="return confirm('Tem certeza que deseja excluir este usuário?');">
								<input type="hidden" name="id" value="${usuario.id}">
								<input type="submit" value="Excluir" class="btn btn-danger">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
