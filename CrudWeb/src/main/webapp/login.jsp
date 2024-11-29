<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Login</h1>
        <form action="login" method="post">
            <div class="form-floating">
                <input type="email" class="form-control" id="floatingInput" name="email" placeholder="nome@example.com" required>
                <label for="floatingInput">Email</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Senha" required>
                <label for="floatingPassword">Senha</label>
            </div>
            <button class="btn btn-primary w-100 py-2 mt-3" type="submit">Login</button>
        </form>
        <form action="index.jsp" method="post">
        	<button class="btn btn-info w-100 py-2 mt-5" type="submit">Cadastrar-se</button>
        </form>
    </div>
    <script src="assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
