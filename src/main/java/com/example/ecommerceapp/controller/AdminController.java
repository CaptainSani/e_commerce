package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.dao.AdminDao;
import com.example.ecommerceapp.dao.UserDao;
import com.example.ecommerceapp.model.Admin;
import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.util.ConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "admin", value = "/admin-signup")
public class AdminController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String adminToken = req.getParameter("adminToken");

        Admin newAdmin = new Admin(fullName,email,password,adminToken);
        AdminDao adminDao = new AdminDao(ConnectionUtil.getConnection());
        adminDao.addAdmin(newAdmin);

        resp.sendRedirect("adminLogin.jsp");
    }
}
