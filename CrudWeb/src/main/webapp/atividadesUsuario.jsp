<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Atividades</title>
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Lista de Atividades</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID do Usuário</th>
                    <th>Ação</th>
                    <th>Data/Hora</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="atividade" items="${atividades}">
                    <tr>
                        <td>${atividade.usuarioId}</td>
                        <td>${atividade.acao}</td>
                        <td><fmt:formatDate value="${atividade.dataHora}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="listUsers" method="get">
				<button class="btn btn-primary w-100 py-2" type="submit">Voltar</button>
		</form>
    </div>
    <script src="assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
