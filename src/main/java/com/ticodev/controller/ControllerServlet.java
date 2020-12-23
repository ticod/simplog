package com.ticodev.controller;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@WebServlet(urlPatterns = {"*.do"},
        initParams = {
                @WebInitParam(name = "properties",
                        value= "action.properties")
        })
public class ControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Map<String, Action> commandMap = new HashMap<>();

    public ControllerServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        String props = config.getInitParameter("properties");
        Properties pr = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(config.getServletContext().getRealPath("/") + "WEB-INF/" + props);
            pr.load(fis);
        } catch (IOException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {}
        }

        for (Object key : pr.keySet()) {
            String command = (String) key;
            String className = pr.getProperty(command);
            try {
                Object commandObject = Class.forName(className.trim()).newInstance();
                commandMap.put(command, (Action) commandObject);
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        Action action = null;
        ActionForward forward = null;
        String command = null;

        try {
            command = request.getRequestURI().substring(request.getContextPath().length());
            action = commandMap.get(command);
            forward = action.execute(request, response);
        } catch (NullPointerException e) {
            forward = new ActionForward();
        } catch (Exception e) {
            throw new ServletException();
        }

        if (forward != null && forward.isRedirect()) {
            response.sendRedirect(forward.getView());
        } else {
            if (forward.getView() == null) {
                forward.setView(command.replace(".do", ".jsp"));
            }
            RequestDispatcher dip = request.getRequestDispatcher(forward.getView());
            dip.forward(request, response);
        }

    }

}
