package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/studentform")
public class Formservlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String fname   = request.getParameter("fname");
        String lname   = request.getParameter("lname");
        String dob     = request.getParameter("dob");
        String gender  = request.getParameter("gender");
        String mobile  = request.getParameter("mobile");
        String email   = request.getParameter("email");
        String address = request.getParameter("address");
        String course  = request.getParameter("course");
        int sem        = Integer.parseInt(request.getParameter("sem"));

        String sql = "INSERT INTO studentdetail "
                + "(first_name, last_name, dob, gender, mobile, email, address, course, semester) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        boolean success = false;
        String errorMsg = "";

        // 2. Store in MySQL
        try {
            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, fname);
                ps.setString(2, lname);
                ps.setDate(3, Date.valueOf(dob));   
                ps.setString(4, gender);
                ps.setString(5, mobile);
                ps.setString(6, email);
                ps.setString(7, address);
                ps.setString(8, course);
                ps.setInt(9, sem);

                success = ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorMsg = e.getMessage();
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'>");
            out.println("<title>Result</title>");
            out.println("<link rel='stylesheet' href='css/style.css'></head><body>");
            out.println("<div class='container message'>");
            if (success) {
                out.println("<h2 class='ok'>Data saved successfully!</h2>");
                out.println("<p>Thank you, " + escape(fname) + " " + escape(lname) + ".</p>");
            } else {
                out.println("<h2 class='err'>Something went wrong</h2>");
                out.println("<p>" + escape(errorMsg) + "</p>");
            }
            out.println("<p><a href='index.html'>&larr; Back to form</a></p>");
            out.println("</div></body></html>");
        }
    }

    // Basic HTML escaping to prevent XSS in the response page
    private String escape(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;");
    }
}