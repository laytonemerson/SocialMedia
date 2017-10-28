package edu.matc.controller;

import edu.matc.entity.Friend;
import edu.matc.entity.Movie;
import edu.matc.entity.User;
import edu.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * This is the ShowEmployeeSearchServlet. It will set the page title and forward
 * to the employeeSearch.jsp page.
 *
 *@author lemerson
 */
@WebServlet(
        name = "deleteFriend",
        urlPatterns = {"/deleteFriend"}
) public class DeleteFriend extends HttpServlet {
    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpRequest
     * @param response the HttpResponse
     * @throws ServletException if there is a general servlet exception
     * @throws IOException      if there is a general I/O exception
     */

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getRemoteUser();
        String friendUserName = request.getParameter("friend");

        UserDao dao = new UserDao();
        User user = dao.getUser(userName);

        //TODO override equals so I dont have to mess with this
        Set<Friend> userFriends = user.getUserFriends();
        Friend deleteFriend = new Friend();

        for(Friend current : userFriends) {
            if (current.getFriendUserName().equals( friendUserName)) {
                deleteFriend = current;
            }

        }

        user.getUserFriends().remove(deleteFriend);
        dao.updateUser(user);
        request.setAttribute("movies",user.getUserMovies());

        String url = "/myMovies.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);


    }
}