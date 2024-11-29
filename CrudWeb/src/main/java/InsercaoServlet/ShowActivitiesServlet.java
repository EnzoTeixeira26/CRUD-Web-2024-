package InsercaoServlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexao.UsuarioRepositorio;
import Usuario.Atividade;

@WebServlet("/showActivities")
public class ShowActivitiesServlet extends AutenticadoServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		ArrayList<Atividade> atividades = repositorio.buscarTodasAtividadesCompletas();

		req.setAttribute("atividades", atividades);
		req.getRequestDispatcher("atividadesUsuario.jsp").forward(req, resp);
	}
}
