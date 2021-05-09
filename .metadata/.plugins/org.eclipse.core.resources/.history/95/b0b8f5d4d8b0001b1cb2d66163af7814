package com.mag.webstore.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mag.webstore.business.CatalogBrowser;

/**
 * Servlet implementation class ViewArticle
 */
@WebServlet("/viewArticle")
public class ViewArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewArticle() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession( true );
		System.out.print(session.getAttribute( "connectedUser" ));
		if ( session.getAttribute( "connectedUser" ) == null ) {
			response.sendRedirect( "login" );
			return;
		}
		
		request.getRequestDispatcher( "/viewArticle.jsp" ).forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession( true );
		System.out.print(session.getAttribute( "connectedUser" ));
		System.out.print(request.getParameter( "btnPrevious"  ));
		System.out.print(request.getParameter( "btnNext" ));
		
		if ( session.getAttribute( "connectedUser" ) == null ) {
			response.sendRedirect( "login" );
			return;
		}
		
		CatalogBrowser browser = ( CatalogBrowser ) session.getAttribute( "catalogBrowser");
		
		if ( request.getParameter( "btnPrevious" ) != null ) {
			browser.goPrevious();
		} else if ( request.getParameter( "btnNext" ) != null ) {
			browser.goNext();
		} 
		/*
		else if ( request.getParameter( "btnAdd" ) != null ) {
			browser.addCurrentArticle();
		}
		*/
		request.getRequestDispatcher( "/viewArticle.jsp" ).forward( request, response );
		
	}

}
