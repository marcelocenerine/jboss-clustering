package com.cenerino.exampleapp.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cenerino.exampleapp.ejb.ClusteredStatefulBean;

@WebServlet("/stateful/hello")
public class HelloStatefulServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private ClusteredStatefulBean statefulBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(statefulBean.hello());
        response.getWriter().flush();
        response.getWriter().close();
    }
}
