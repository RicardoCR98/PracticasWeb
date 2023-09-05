package controlador.autenticacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.entidades.Persona;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso por GET");
		this.ruteador(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.ruteador(request, response);
		
	}
	
	private void ruteador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.print("Entra al ruteador");
		
		String ruta = (request.getParameter("ruta") == null) ? "inicio":request.getParameter("ruta");
		
		switch(ruta) {
		case "inicio":
			this.inicio(request, response);
			break;
		case "ingresar":
			this.ingresar(request, response);
			break;
		case "salir":
			this.salir(request, response);
			break;
		case "error":
			
			break;
		default:
			break;
		}
		
		
	}

	private void inicio(HttpServletRequest request, HttpServletResponse response) throws IOException {

		//1.- Obtener Datos	que me envian en la solicitud
		
		//2.- Llamo al modelo  para obtener los datos (¿necesito lamar al modelo?)
		
		//3.- LLamo a la vista (2 formas: dispatcher o sendredirequet)
		//Preguntarse ¿debo llamar datos? -> no -> entonces uso sendredirequet
		//si-> usar dispatcher
		
		response.sendRedirect("jsp/login.jsp");
	}

	private void salir(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("jsp/login.jsp");
	}
	
	private void ingresar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//1.- Obtener Datos	que me envian en la solicitud
		
		String nombre=request.getParameter("usuario");
		String clave=request.getParameter("password");
		
		
		//2.- Llamo al modelo  para obtener los datos (¿necesito lamar al modelo?)		
		Persona personaAutenticada = modelo.dao.DAOFactory.getFactory().getPersonaDAO().autorizar(nombre, clave);
		
		if(personaAutenticada != null) {
			
			//Creamos la sesion
			HttpSession session = request.getSession();
			session.setAttribute("Usuario logeado", personaAutenticada);
			
			//Llamamos a la vista
			response.sendRedirect("GestorPersonaController?ruta=listar");
			
			//request.getRequestDispatcher("ListarPersonaController").forward(request, response);
			return;
		}else {
			String mensaje = "ingresaste mal el usuario y clave";
			
			//Enviar datos a la vista
			request.setAttribute("mensaje", mensaje);
			
			//redireccionar a la vista
			request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
		}
		//3.- LLamo a la vista (2 formas: dispatcher o sendredirequet)
		//Preguntarse ¿debo llamar datos? -> no -> entonces uso sendredirequet
		//si-> usar dispatcher
	}
	
}