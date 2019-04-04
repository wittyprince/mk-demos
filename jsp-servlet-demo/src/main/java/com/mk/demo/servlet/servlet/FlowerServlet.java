package com.mk.demo.servlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * flower servlet
 * Created by WangChen on 2019/4/3 21:02.
 */
@WebServlet("/flower")
public class FlowerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/aa.jsp").forward(req, resp);
        resp.getWriter().write("hello servlet!");
        System.out.println("flower servlet running...");
    }
}
