package bmiCalculation;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.Format;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/BmiServlet")
public class BmiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BmiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		double weight = Double.parseDouble(request.getParameter("weight"));
		double height = Double.parseDouble(request.getParameter("height"));

		double final_height = (height / 100);
		double bmi = weight / (final_height * final_height);

		String str = "";
		if (bmi < 18.5) {
			str = "Underweight";
		}
		if (bmi >= 18.5 && bmi <= 24.9) {
			str = "Healthy";
		}
		if (bmi >= 25 && bmi <= 29.9) {
			str = "Overweight";
		}
		if (bmi >= 30) {
			str = "Overweight";
		}
		PrintWriter pw = response.getWriter();
		DecimalFormat f = new DecimalFormat("##.00");
		pw.print("<center>Your BMI is: " + f.format(bmi) + "</center>");
		pw.print("<center><br>You are " + str + ".</center>");
	}
}
