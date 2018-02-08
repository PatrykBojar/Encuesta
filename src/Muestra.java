import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostrar")
public class Muestra extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Muestra() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Leemos todos los parámetros que nos pasan del formulario.
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String estudios = request.getParameter("estudios");

		String[] preferencias = request.getParameterValues("preferencias");

		// Configuramos la salida de datos hacia el navegador del usuario.

		// Establacemos que la respuesta del servlet va a ser un archivo HTML.
		response.setContentType("text/html");

		// Creamos un objeto que nos permita ir escribiendo la respuesta del
		// servlet.
		PrintWriter out = response.getWriter();

		// Enviamos mediante el objeto out la respuesta al navegador del
		// cliente.
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Parámetros del formulario</title>");
		out.println("<meta charset='UTF-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Resultados de la encusta</h1>");
		out.println("Nombre: " + nombre + "<br>");
		out.println("Apellidos: " + apellidos + "<br>");
		out.println("Estudios: " + estudios + "<br>");
		out.println("Preferencias:<br>");
		// Si el usuario no ha seleccionado ninguna preferencia, el array
		// preferencias sería null y obtendríamos una excepción al intentar
		// leerlo.
		if (preferencias != null) {
			for (int i = 0; i < preferencias.length; i++) {
				out.println("- " + preferencias[i] + "<br>");
			}
		}
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
