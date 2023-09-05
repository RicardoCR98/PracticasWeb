package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Persona;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso por GET");
		
		//1.- Obtener Datos	que me envian en la solicitud
		
		//2.- Llamo al modelo  para obtener los datos (¿necesito lamar al modelo?)
		
		//3.- LLamo a la vista (2 formas: dispatcher o sendredirequet)
		//Preguntarse ¿debo llamar datos? -> no -> entonces uso sendredirequet
		//si-> usar dispatcher
		
		response.sendRedirect("jsp/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.- Obtener Datos	que me envian en la solicitud
		
		String nombre=request.getParameter("usuario");
		String clave=request.getParameter("password");
		
		
		//2.- Llamo al modelo  para obtener los datos (¿necesito lamar al modelo?)		
		Persona modeloPersona= new Persona();
		Persona personaAutenticada = modeloPersona.autorizar(nombre, clave);
		
		if(personaAutenticada != null) {
			
			//Creamos la sesion
			HttpSession session = request.getSession();
			session.setAttribute("Usuario logeado", personaAutenticada);
			
			//Llamamos a la vista
			response.sendRedirect("ListarPersonaController");
			
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
