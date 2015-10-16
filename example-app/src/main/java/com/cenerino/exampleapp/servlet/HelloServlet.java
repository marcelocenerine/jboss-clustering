package com.cenerino.exampleapp.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cenerino.exampleapp.ejb.ClusteredStatefulBean;
import com.cenerino.exampleapp.ejb.ClusteredStatelessBean;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Inject
    private ClusteredStatelessBean statelessBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(getMessage(request));
        response.getWriter().flush();
        response.getWriter().close();
    }

    private String getMessage(HttpServletRequest request) {
        String from = request.getParameter("from");

        if (from != null && from.equals("stateful")) {
            ClusteredStatefulBean statefull = (ClusteredStatefulBean) request.getSession().getAttribute("stateful");

            if (statefull == null) {
                logger.info("Stateful bean reference was not found in the current session");

                try {
                    Context context = new InitialContext();
                    statefull = (ClusteredStatefulBean) context.lookup("java:module/ClusteredStatefulBean");
                    request.getSession().setAttribute("stateful", statefull);
                } catch (NamingException e) {
                    throw new RuntimeException(e);
                }
            }

            return statefull.hello();
        }

        return statelessBean.hello();
    }
}
