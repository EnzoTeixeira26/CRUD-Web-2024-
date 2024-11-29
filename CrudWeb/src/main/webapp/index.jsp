<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head><script src="assets/js/color-modes.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.122.0">
    
    <title>Formulário</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
	<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link href="sign-in.css" rel="stylesheet">
    
  </head>
  <body class="d-flex align-items-center py-4 bg-body-tertiary">
    <div class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle">
      <button class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center"
              id="bd-theme"
              type="button"
              aria-expanded="false"
              data-bs-toggle="dropdown"
              aria-label="Toggle theme (auto)">
        <svg class="bi my-1 theme-icon-active" width="1em" height="1em"><use href="#circle-half"></use></svg>
        <span class="visually-hidden" id="bd-theme-text">Mudar o tema</span>
      </button>
      <ul class="dropdown-menu dropdown-menu-end shadow" aria-labelledby="bd-theme-text">
        <li>
          <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light" aria-pressed="false">
            <svg class="bi me-2 opacity-50" width="1em" height="1em"><use href="#sun-fill"></use></svg>
            Claro
            <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
          </button>
        </li>
        <li>
          <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark" aria-pressed="false">
            <svg class="bi me-2 opacity-50" width="1em" height="1em"><use href="#moon-stars-fill"></use></svg>
            Escuro
            <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
          </button>
        </li>
        <li>
          <button type="button" class="dropdown-item d-flex align-items-center active" data-bs-theme-value="auto" aria-pressed="true">
            <svg class="bi me-2 opacity-50" width="1em" height="1em"><use href="#circle-half"></use></svg>
            Automático
            <svg class="bi ms-auto d-none" width="1em" height="1em"><use href="#check2"></use></svg>
          </button>
        </li>
      </ul>
    </div>
    
<c:if test="${mostrarFalha}">
	<div class="alert alert-danger position-absolute top-0 start-0 w-100 p-3 text-center" role="alert">Todos os campos são obrigatórios!
	 Verifique se o email possui "@gmail" ou "@ifgoiano"</div>
</c:if> 

<main class="form-signin w-100 m-auto">
  <form action="register" method="post">
  
    <img class="mb-4" src="assets/brand/user.png" alt="" width="72" height="67">
    <h1 class="h3 mb-3 fw-normal">Registrar-se</h1>
    
    <div class="form-floating">
    	<input type="text" class="form-control" id="floatingNameInput" name="nome" placeholder="Escreva seu nome" value="<%= request.getParameter("nome") != null ? request.getParameter("nome") : "" %>">
      	<label for="floatingNameInput">Nome</label>
    </div>
    <div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" name="email" placeholder="nome@example.com" value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>">
      <label for="floatingInput">Email</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Senha"> <!-- //apague o comentario
      em caso de querer desativar o salvamento de senha ao recarregar a pagina// value="<%= request.getParameter("password") != null ? request.getParameter("password") : "" %>"> -->
      <label for="floatingPassword">Senha</label>
    </div>

    <div class="form-check text-start my-3">
      <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
      <label class="form-check-label" for="flexCheckDefault">
        Lembre-se de mim
      </label>
    </div>
    <button class="btn btn-primary w-100 py-2" type="submit">Salvar</button>
  </form>
</main>
<script src="assets/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
