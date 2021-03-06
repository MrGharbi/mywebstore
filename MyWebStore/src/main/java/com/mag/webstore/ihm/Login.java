package com.mag.webstore.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mag.webstore.business.CatalogBrowser;
import com.mag.webstore.business.User;
import com.mag.webstore.dao.DAOContext;
import com.mag.webstore.dao.UserDAO;


@WebServlet(urlPatterns ="/login", loadOnStartup = 1)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	DAOContext.init(this.getServletContext());
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("login", "");
		request.setAttribute("password", "");
		request.setAttribute("errorMessage", "");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		request.setAttribute("login", login);
		request.setAttribute("password", password);
		  
		User connectedUser = UserDAO.isValidLogin(login, password);
		
		if ( connectedUser != null ) {
			HttpSession session = request.getSession( true );
			session.setAttribute("connectedUser", connectedUser);
			session.setAttribute("catalogBrowser", new CatalogBrowser() );
			request.getRequestDispatcher("/viewArticle.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Bad identity");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
