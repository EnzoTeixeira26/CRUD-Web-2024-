package InsercaoServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexao.UsuarioRepositorio;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                UsuarioRepositorio repositorio = new UsuarioRepositorio();
                    repositorio.deletarUsuario(id);
                    
                    resp.sendRedirect("listUsers");
  
            } catch (NumberFormatException e) {
                e.printStackTrace();
                resp.sendRedirect("listUsers");
            }
        } else {
            resp.sendRedirect("listUsers");
        }
    }
}
