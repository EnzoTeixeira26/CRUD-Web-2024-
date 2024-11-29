package InsercaoServlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Conexao.UsuarioRepositorio;
import Usuario.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("password");

        UsuarioRepositorio repositorio = new UsuarioRepositorio();
        Usuario usuario = repositorio.autenticarUsuario(email, senha);

        if (usuario != null) {
            HttpSession session = req.getSession();
            session.setAttribute("usuarioLogado", usuario);

            ArrayList<Usuario> listaUsuarios = repositorio.consultarTodosUsuarios();
            req.setAttribute("usuarios", listaUsuarios);
            req.getRequestDispatcher("listaUsuarios.jsp").forward(req, resp);           
            repositorio.registrarAtividade(usuario.getId(), "Login");
        } else {
            req.setAttribute("mostrarFalha", Boolean.TRUE);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
