package InsercaoServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexao.UsuarioRepositorio;
import Usuario.Usuario;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            UsuarioRepositorio repositorio = new UsuarioRepositorio();
            Usuario usuario = repositorio.consultarUsuarioPorId(id);
            
            if (usuario != null) {
                req.setAttribute("usuario", usuario);
                req.getRequestDispatcher("editUser.jsp").forward(req, resp);
                
                // Registro de atividade
                repositorio.registrarAtividade(usuario.getId(), "Ediçao de Usuario");
            } else {
                resp.sendRedirect("listUsers");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect("listUsers");
        }
    }
}
