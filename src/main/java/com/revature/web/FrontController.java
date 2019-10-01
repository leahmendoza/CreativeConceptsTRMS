package com.revature.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// FRONT CONTROLLER...My ONE Servlet :)

		// LOGIN SECTION
		// Using Employee Service to retrieve all the employees from our DB.
		EmployeeService es = new EmployeeService();
		/*
		 * Accessing these parameters by their "name" attribute.
		 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// using EmployeeService to get the employees
		List<Employee> userCredentials = es.getAllEmployees();
		HttpSession session = request.getSession();
		if (username != null && !username.equals("") && password != null && !password.equals("")) {

			for (Employee userCred : userCredentials) {

				String x = userCred.getUsername();

				if (username.equals(userCred.getUsername()) && password.contentEquals(userCred.getPassword())) {

					switch (x) {

					case "emp_username":
						// Give my user a session if they provide the
						// correct credentials.
						session = request.getSession();

						// session attribute for regular employee
						session.setAttribute("username", username);

						// Redirecting to employee's home page
						response.sendRedirect("./views/employee/homepage.html");

						String employee = session.getAttribute("username").toString();
						System.out.println(employee);

						break;

					case "super_username":
						// Give my user a session if they provide the
						// correct credentials.
						session = request.getSession();

						// session attribute for supervisor
						session.setAttribute("username", username);

						// Redirecting to supervisor's home page
						response.sendRedirect("./views/direct_supervisor/homepage.html");
						String supervisor = session.getAttribute("username").toString();
						System.out.println(supervisor);

						break;

					case "directhead_username":
						// Give my user a session if they provide the
						// correct credentials.
						session = request.getSession();

						// session attribute for direct head
						session.setAttribute("username", username);

						// Redirecting to direct head's home page
						response.sendRedirect("./views/department_head/homepage.html");

						String department_head = session.getAttribute("username").toString();
						System.out.println(department_head);

						break;

					case "benco_username":
						// Give my user a session if they provide the
						// correct credentials.
						session = request.getSession();

						// session attribute for benefits coordinator
						session.setAttribute("username", username);

						// Redirecting to benefits coordinator's home page
						response.sendRedirect("./views/benifits_coordinator/homepage.html");

						String benco = session.getAttribute("username").toString();
						System.out.println(benco);

						break;

					}

				}
			}
		}

		// Process Posts
		if (request.getMethod().equals("GET")) {
			ObjectMapper mappy = new ObjectMapper();

			response.getOutputStream().write(mappy.writeValueAsBytes(RequestHelper.processGet(request, response)));
		}
		if (request.getMethod().contentEquals("POST")) {

			ObjectMapper mappy = new ObjectMapper();

			response.getOutputStream().write(mappy.writeValueAsBytes(RequestHelper.processGet(request, response)));

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}