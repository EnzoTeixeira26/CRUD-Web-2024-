package InsercaoServlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Conexao.UsuarioRepositorio;
import Usuario.Usuario;

@WebServlet("/searchUsers")
public class SearchUsersServlet extends AutenticadoServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");

        UsuarioRepositorio repositorio = new UsuarioRepositorio();
        ArrayList<Usuario> listaC = repositorio.pesquisarUsuarios(query);

        req.setAttribute("usuarios", listaC); 
        req.getRequestDispatcher("listaUsuarios.jsp").forward(req, resp);
    }
}
