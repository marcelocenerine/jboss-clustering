package com.cenerino.exampleapp.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cenerino.exampleapp.ejb.ClusteredStatefulBean;
import com.cenerino.exampleapp.ejb.ClusteredStatelessBean;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private ClusteredStatelessBean statelessBean;

    @Inject
    private ClusteredStatefulBean statefulBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(getMessage(request));
        response.getWriter().flush();
        response.getWriter().close();
    }

    private String getMessage(HttpServletRequest request) {
        String from = request.getParameter("from");

        if (from != null && from.equals("stateful")) {
            return statefulBean.hello();
        }

        return statelessBean.hello();
    }
}
