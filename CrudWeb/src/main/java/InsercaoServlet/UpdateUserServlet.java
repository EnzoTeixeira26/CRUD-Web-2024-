package InsercaoServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexao.UsuarioRepositorio;
import Usuario.Usuario;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String nome = req.getParameter("nome");
            String email = req.getParameter("email");
            String senha = req.getParameter("password");

            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            UsuarioRepositorio repositorio = new UsuarioRepositorio();
            repositorio.atualizarUsuario(usuario);

            resp.sendRedirect("listUsers");
            
            // Registro de atividade
            repositorio.registrarAtividade(usuario.getId(), "Atualizaçao de Usuario");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            req.setAttribute("error", "Invalid user ID.");
            req.getRequestDispatcher("editUser.jsp").forward(req, resp);
        }
    }
}
