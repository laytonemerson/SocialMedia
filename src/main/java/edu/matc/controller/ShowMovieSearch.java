package edu.matc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This is the ShowMovieSearch servlet. It will set the page title and forward to the movieSearch.jsp page.
 *
 *@author lemerson
 */
@WebServlet(
        name = "showMovieSearch",
        urlPatterns = {"/showMovieSearch"}
) public class ShowMovieSearch extends HttpServlet {

    /**
    *  Handles HTTP GET requests.
    *
    *@param  request               the HttpRequest
    *@param  response              the HttpResponse
    *@exception  ServletException  if there is a general servlet exception
    *@exception  IOException       if there is a general I/O exception
    */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Forward to movieSearch.jsp page
        request.setAttribute("title", "Movie Search");
        String url = "/movieSearch.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}