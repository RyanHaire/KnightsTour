

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.KnightsTour;

/**
 * Servlet implementation class NonIntelligentMethodServlet
 */
@WebServlet("/NonIntelligentMethodServlet")
public class NonIntelligentMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NonIntelligentMethodServlet() {
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
			String username = request.getParameter("userName");
			String path = String.format("C:\Users\%s\Desktop\ryanhaireHeuristicMethod.txt", username);
      WriteFile wf = new WriteFile(path, true);
			ArrayList<Integer> tourMoves = new ArrayList<Integer>();
			int numOfTours = Integer.parseInt(request.getParameter("numOfTours"));
			// initialize with null to avoid initialization error
			KnightsTour kt = null;
			int[] knightStartingPos = new int[] {
					Integer.parseInt(request.getParameter("knightRow")),
					Integer.parseInt(request.getParameter("knightCol"))
			};
			boolean posChosenByUser = false;

			out.println("Heuristic Method Chosen<br/>");

			if (Integer.parseInt(request.getParameter("knightRow")) >= 0
					&& Integer.parseInt(request.getParameter("knightCol")) >= 0) {
				posChosenByUser = true;
			}


			for (int i = 0; i < numOfTours; i++) {
				int trialNum = i + 1;
				if (posChosenByUser)
					kt = new KnightsTour(out, knightStartingPos);
				else
					kt = new KnightsTour(out);
				kt.runNonIntelligentMethod();
				tourMoves.add(kt.getTourMoves());
				if (numOfTours == 1) {
					kt.printBoard();
					out.println("Knight successfully touched " + kt.getTourMoves() + " squares. <br/>");
					wf.writeToFile("Knight successfully touched " + kt.getTourMoves() + " squares.");
				} else {
					out.println("Trial " + trialNum + ": Knight was able to successfully touch " + kt.getTourMoves()
							+ " squares. <br/>");
					wf.writeToFile("Trial " + trialNum + ": Knight was able to successfully touch " + kt.getTourMoves()
							+ " squares.");
				}
			}

			int sum = 0;
			int size = tourMoves.size();

			for (int i = 0; i < tourMoves.size(); i++) {
				sum += tourMoves.get(i);
			}

			int average = sum / size;

			if (numOfTours > 1) {
				out.println("Average Squares Touched: " + average + " squares");
				wf.writeToFile("Average Squares Touched: " + average + " squares");
			}

			out.println("Starting position of knight was: " + kt.getKnightStartingPos());
		} catch(Exception ex) {
			response.sendRedirect("unexpectedError.jsp");
			System.out.println(ex.getMessage());
		} finally {
			out.close();
		}
	}

}
