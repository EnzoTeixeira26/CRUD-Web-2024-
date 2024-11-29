package InsercaoServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexao.UsuarioRepositorio;
import Usuario.Usuario;

@WebServlet("/register")
public class ServetMain extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("password");

        if(nome.trim().isEmpty() || email.trim().isEmpty() || senha.trim().isEmpty()) {
            req.setAttribute("mostrarFalha", Boolean.TRUE);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else if(email.contains("@ifgoiano") || email.contains("@gmail") || email.contains("@hotmail")) {
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            UsuarioRepositorio repositorio = new UsuarioRepositorio();
            repositorio.salvarUsuario(usuario);
            
            resp.sendRedirect("login.jsp");
        }
    }
}