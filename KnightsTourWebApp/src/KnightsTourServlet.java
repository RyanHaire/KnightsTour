

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KnightsTourServlet
 */
@WebServlet("/KnightsTourServlet")
public class KnightsTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KnightsTourServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			if (request.getParameter("method").equals("Heuristic Method")) {
				RequestDispatcher rd = request.getRequestDispatcher("HeuristicMethodServlet");
				rd.forward(request, response);
			} else if (request.getParameter("method").equals("Non Intelligent Method")) {
				RequestDispatcher rd = request.getRequestDispatcher("NonIntelligentMethodServlet");
				rd.forward(request, response);
			} else if (request.getParameter("method").equals("Select Method")) {
				response.sendRedirect("error.jsp");
			}
		} finally {
			out.close();
		}

	}

}
