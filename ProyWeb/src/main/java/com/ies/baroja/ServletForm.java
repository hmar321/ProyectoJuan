package com.ies.baroja;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Jugadores;

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
		response.getWriter().append("Error: la llamadas GET no están permitidas").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			if (request.getParameter("email") != null) {
				loginUsuario(request, response);
			} else if (request.getParameter("nombre") != null) {
				altaJugador(request, response);
			}else if (request.getParameter("buscaNombre") != null) {
				buscaJugador(request, response);
			}else {
				
			}

		} catch (Exception ex) {
			System.out.println("Error en servlet");
			ex.printStackTrace();
			mostrarError(response,"Error al dar de alta al jugador");
		}
	}

	private static void buscaJugador(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**1-recogida de datos de la página */
		String sNombre=request.getParameter("buscaNombre");
		/** */
		Jugadores jugador=Controller.getJugador(sNombre);
		if(jugador!=null) {
			HttpSession sesion=request.getSession();
			sesion.setAttribute("jugador", jugador);
			response.sendRedirect("listaJugador.jsp");
		}else {
			mostrarError(response,"Jugador "+sNombre+" no encontrado.");
		}
		/** */
		
	}

	private static void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession sesion = request.getSession();
		String usu, pass;
		String sEmail = request.getParameter("email");
		String sPwd = request.getParameter("pwd");
		// deberíamos buscar el usuario en la base de datos, pero
		// ponemos un ejemplo en el mismo código
		if (sEmail.equals("micorreo@gmail.com") && sPwd.equals("password") && sesion.getAttribute("email") == null) {
			// si coincide email y password y además no hay sesión iniciada
			sesion.setAttribute("email", sEmail);
			// redirijo a página con información de login exitoso
			response.sendRedirect("loginExito.jsp");
		} else {
			// lógica para login inválido
			mostrarError(response,"El usuario "+sEmail+" no tiene acceso");
		}

	}

	private static void altaJugador(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/** 1- recogida de datos */
		Jugadores jugador = new Jugadores(request.getParameter("nombre"), request.getParameter("procedencia"),
				request.getParameter("altura"), request.getParameter("peso"), request.getParameter("posicion"),
				request.getParameter("nombre_equipo"));

		/** 2- Insertar jugador en la base de datos */
		boolean bRes = Controller.insertarJugador(jugador);

		/** 3- Mostrar resultado por pantalla */
		if (bRes) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<HTML>\n" + "<HEAD><TITLE>Página de JAGD</TITLE>" + "  <meta charset=\"utf-8\">\r\n"
					+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
					+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
					+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
					+ "<h2 class=\"text-success\">Jugador insertado correctamente<h2>\n"
					+ "<ul class=\"list-group\"> \n" + "  <LI class=\"list-group-item\">nombre: " + jugador.getNombre()
					+ "</li>\n" + "  <LI class=\"list-group-item\">procedencia: " + jugador.getProcedencia() + "</li>\n"
					+ "  <LI class=\"list-group-item\">altura: " + jugador.getAltura() + "</li>\n"
					+ "  <LI class=\"list-group-item\">peso: " + jugador.getPeso() + "</li>\n"
					+ "  <LI class=\"list-group-item\">posicion: " + jugador.getPosicion() + "</li>\n"
					+ "  <LI class=\"list-group-item\">nombre_equipo: " + jugador.getNombre_equipo() + "</li>\n"
					+ "</UL>\n" + "</div></BODY></HTML>");
			out.close();

		} else {
			// Mostramos que se ha producido un error
			mostrarError(response,"Error por definir");

		}
	}

	private static void mostrarError(HttpServletResponse response, String sMensaje) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>\n" + "<HEAD><TITLE>Página de JAGD</TITLE>" + "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "</HEAD>\n" + "<BODY>\n" + "<div class=\"container mt-3\">\n"
				+ "<h1 class=\"text-danger\">Error interno<h1>\n"
				+ "<h2 class=\"text-danger\">"+sMensaje+"<h2>\n"
				+ "<img src=\"img/error.jpg\" class=\"rounded\" alt=\"error interno\">" + "</div></BODY></HTML>");
		out.close();
	}

}
