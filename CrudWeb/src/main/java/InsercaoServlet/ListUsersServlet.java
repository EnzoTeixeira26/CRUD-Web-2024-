package InsercaoServlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexao.UsuarioRepositorio;
import Usuario.Usuario;

@WebServlet("/listUsers")
public class ListUsersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioRepositorio repositorio = new UsuarioRepositorio();
        ArrayList<Usuario> listaUsuarios = repositorio.consultarTodosUsuarios();
        req.setAttribute("usuarios", listaUsuarios);
        req.getRequestDispatcher("listaUsuarios.jsp").forward(req, resp);
        
    }
}
