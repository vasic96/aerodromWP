package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AerodromDAO;
import dao.ConnectionManager;
import dao.LetDAO;
import model.Aerodrom;
import model.Let;

/**
 * Servlet implementation class AerodromServlet
 */
@WebServlet("/aerodrom")
public class AerodromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AerodromServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionManager.open();
		List<Aerodrom> aerodromi = AerodromDAO.getAll();
		String responseString = "";
		for(Aerodrom aerodrom : aerodromi) {
			responseString += aerodrom.toString() + "  ";
		}
		
		Let let = new Let();
		let.setBroj("ASDAS27777");
		let.setBrojSedista(50);
		let.setCena((float) 136.4);
		let.setDolazniAerodrom(aerodromi.get(0));
		let.setPolazniAerodrom(aerodromi.get(1));
		let.setDatumPolaska(new Date());
		let.setDatumDolaska(new Date());
		
		if(LetDAO.dodajLet(let)) {
			responseString += "\n OCE DA CUVA";
		} else {
			responseString += "\n NECE DA CUVA";
		}

		
		
		response.getWriter().write(responseString);
	
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
