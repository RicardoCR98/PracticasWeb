package controlador.gestionpersonas;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.DAOFactory;
import modelo.entidades.Persona;

@WebServlet("/GestorPersonaController")
public class GestorPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestorPersonaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.ruteador(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.ruteador(request, response);
	}

	private void ruteador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("Entra al ruteador");

		String ruta = (request.getParameter("ruta") == null) ? "inicio" : request.getParameter("ruta");

		switch (ruta) {
		case "listar":
			this.listar(request, response);
			break;
		case "nuevo":
			this.nuevo(request, response);
			break;
		case "guardarnuevo":
			this.guardarNuevo(request, response);
			break;
		default:
			break;
		}

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso a Listar Controller por GET");
		// 1.- Obtener datos que me envían en la solicitud

		// 2.- Llamo al Modelo para obtener datos	
		
		List<Persona> lista = DAOFactory.getFactory().getPersonaDAO().getPersonas();

		// 3.- Llamo a la Vista

		request.setAttribute("personas", lista);
		request.getRequestDispatcher("jsp/listarpersona.jsp").forward(request, response);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.- Obtener datos que me envian en la solicitud

		// 2.- Llamo al modelo para obtener los datos

		// 3.- LLamo a la vista

		response.sendRedirect("jsp/insertarpersona.jsp");
	}

	private void guardarNuevo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.- Obtener datos que me envian en la solicitud

		Integer id = Integer.parseInt(request.getParameter("txtId"));
		String nombre = request.getParameter("txtNombre");
		String password = request.getParameter("txtClave");
		// 2.- Llamo al modelo para obtener los datos
		Persona persona = new Persona();
		persona.setId(id);
		persona.setNombre(nombre);
		persona.setPassword(password);
		
		
		DAOFactory.getFactory().getPersonaDAO().create(persona);

		// 3.- LLamo a la vista

		response.sendRedirect("GestorPersonaController?ruta=listar");
	}
}
