package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Persona;

@WebServlet("/ListarPersonaController")
public class ListarPersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Ingreso a Listar Controller por GET");
		//1.- Obtener datos que me envían en la solicitud
		
		//2.- Llamo al Modelo para obtener datos
		Persona modeloPersona = new Persona();
		List<Persona> lista = modeloPersona.getPersonas();
				
		//3.- Llamo a la Vista
		
		request.setAttribute("personas", lista);
		request.getRequestDispatcher("jsp/listarpersona.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
