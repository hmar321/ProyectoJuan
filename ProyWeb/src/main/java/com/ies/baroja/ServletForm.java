package com.ies.baroja;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletForm
 */
@WebServlet("/ServletForm")
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/** 1- recogida de datos */
			String sNombre = request.getParameter("nombre");
			String sApellidos = request.getParameter("apellidos");
			String sDirec = request.getParameter("direc");
			String sNumero = request.getParameter("numero");
			String sPiso = request.getParameter("piso");
			String sCodpostal = request.getParameter("codpostal");
			String sCiudad = request.getParameter("ciudad");
			String sProvincia = request.getParameter("provincia");
			/** 1- Mostrar datos por pantalla */
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<HTML>\n" + "<HEAD><TITLE>Página de JAGD</TITLE>" + " <meta charset=\"utf-8\">\r\n"
					+ " <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\r\n"
					+ " <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"rel=\"stylesheet\">\r\n"
					+ " <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
					+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
					+ "<h2 class=\"text-success\">Lectura correcta de los	datos<h2>\n"
					+ "<ul class=\"list-group\"> \n" + " <LI class=\"list-group-item\">nombre: " + sNombre + "</li>\n"
					+ " <LI class=\"list-group-item\">apellidos: " + sApellidos + "</li>\n"
					+ " <LI class=\"list-group-item\">direc: " + sDirec + "</li>\n"
					+ " <LI class=\"list-group-item\">numero: " + sNumero + "</li>\n"
					+ " <LI class=\"list-group-item\">piso: " + sPiso + "</li>\n"
					+ " <LI class=\"list-group-item\">codpostal: " + sCodpostal + "</li>\n"
					+ " <LI class=\"list-group-item\">ciudad: " + sCiudad + "</li>\n"
					+ " <LI class=\"list-group-item\">provincia: " + sProvincia + "</li>\n" + "</UL>\n"
					+ "</div></BODY></HTML>");
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
