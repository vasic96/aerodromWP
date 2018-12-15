package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KorisnikDAO;
import model.Korisnik;

/**
 * Servlet implementation class UnblockUserServlet
 */
@WebServlet("/unblock")
public class UnblockUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnblockUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Korisnik korisnik = (Korisnik) session.getAttribute("ulogovanKorisnik");
		String user = request.getParameter("user");
		try {
			if(korisnik == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				throw new Exception("Morate biti ulogovani");
	
			}
			if(!korisnik.isAdmin()) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
				throw new Exception("Morate biti admin");

			}
			
			
			if(!KorisnikDAO.unblockUser(user)) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				throw new Exception("Korisnik ne postoji");

			} else {
				response.setStatus(200);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
