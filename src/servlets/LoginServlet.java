package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.KorisnikDAO;
import model.Korisnik;
import model.LoginData;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String body = request.getReader().lines()
			    .reduce("", (accumulator, actual) -> accumulator + actual);
		LoginData logindata = gson.fromJson(body, LoginData.class);
		System.out.println(logindata.toString());
		try {
			Korisnik korisnik = KorisnikDAO.login(logindata.getUsername());
			if(korisnik == null) {  
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				throw new Exception("Neispravno korisnicko ime i/ili lozinka!");
			}
			System.out.println(korisnik.toString());
			System.out.println(logindata.getPassword());
			if(!korisnik.getPassword().equals(logindata.getPassword())) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
				throw new Exception("Neispravno korisnicko ime i/ili lozinka!");
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("ulogovanKorisnik", korisnik);
			String userJson = gson.toJson(korisnik);
			response.setContentType("application/json");
			response.getWriter().write(userJson);
			System.out.println("Login successful!");
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
