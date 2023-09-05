package com.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonaController")
public class PersonaController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Ingresó por GET");
		String nombre = req.getParameter("nombre");
		
		if(nombre.equals("carlos")){
			//Tenemos que llamar al JSP repsonder
			//Le voy a mandar la variable nombre pero en el lado de la vista lo voy a llamar dato
			req.setAttribute("dato", nombre);
			req.getServletContext().getRequestDispatcher("/jsp/responder.jsp").forward(req, resp);
		}else {
			//error.jsp
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Ingresó por POST");
		String nombre = req.getParameter("nombre");
		
		if(nombre.equals("carlos")){
			PrintWriter out= resp.getWriter();
			out.print("<HTML>");
			out.print("<head>");
			out.print("</head>");
			out.print("<body>");
			out.print("<h1> hola" + nombre +"!(POR POST)</h1>");
			out.print("</body>");
			out.print("</HTML>");
			out.close();
			
		}else {
			PrintWriter out= resp.getWriter();
			out.print("<HTML>");
			out.print("<head>");
			out.print("</head>");
			out.print("<body>");
			out.print("<h1> Sorry! Error capa 8 </h1>");
			out.print("</body>");
			out.print("</HTML>");
			out.close();
		}
		
	}
	
}
