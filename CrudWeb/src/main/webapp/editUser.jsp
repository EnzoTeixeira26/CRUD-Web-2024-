<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuário</title>
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Editar Usuário</h1>
        <form action="updateUser" method="post">
            <input type="hidden" name="id" value="${usuario.id}">
            <div class="form-floating">
                <input type="text" class="form-control" id="floatingNameInput" name="nome" placeholder="Escreva seu nome" value="${usuario.nome}" required>
                <label for="floatingNameInput">Nome</label>
            </div>
            <div class="form-floating">
                <input type="email" class="form-control" id="floatingInput" name="email" placeholder="nome@example.com" value="${usuario.email}" required>
                <label for="floatingInput">Email</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Senha" value="${usuario.senha}" required>
                <label for="floatingPassword">Senha</label>
            </div>
            <button class="btn btn-primary w-100 py-2 mt-3" type="submit">Salvar</button>
        </form>
    </div>
    <script src="assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
