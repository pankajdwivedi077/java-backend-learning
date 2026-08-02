package org.example.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.User;
import org.example.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

       Integer id = Integer.parseInt(request.getParameter("id"));
       String name = request.getParameter("name");
       String mobile = request.getParameter("mobile");
       String email = request.getParameter("email");

       if(id == null || email == null || name == null || mobile == null){
           response.setStatus(404);
           response.setContentType("application/json");
           response.getWriter().write(
                   "{\n" +
                           " \"message\" : \"Some fileds are missing\"\n" +
                           "}"
           );
       }
        User user = new User(id,name,email,mobile);
        User createdUser = userService.createUser(user);
        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write(
                "{\n" +
                        " \"message\" : \"User Added successfully\"\n" +
                        "}"
        );
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idParam = request.getParameter("id");
        if(idParam == null){
            List<User> users = userService.getAllUsers();
            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(usersToJson(users));
            return;
        }
        Integer id = Integer.parseInt(idParam);

        User user = userService.getUserById(id);

        if(user == null){
            response.setStatus(404);
            response.setContentType("application/json");
        }
        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(userToJson(user));
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response){

    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response){

    }

    private String userToJson(User user){
      return  "{\n" +
                " \"id\" : " + user.getId() + ",\n" +
                " \"name\": " + user.getName() + ",\n" +
                " \"email\": " + user.getEmail() + ",\n" +
                " \"mobile\": " + user.getMobile() + ",\n" +
                "}";
    }

    private String usersToJson(List<User> users){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i=0; i<users.size(); i++){
            builder.append(userToJson(users.get(i)));
            if(i<users.size() -1){
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

}
