package com.student;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/studentResult")
public class StudentResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Read values from the HTML form
        String name = request.getParameter("name");
        String regNo = request.getParameter("regNo");

        String mark1Text = request.getParameter("mark1");
        String mark2Text = request.getParameter("mark2");
        String mark3Text = request.getParameter("mark3");

        // Validate missing values
        if (name == null || name.trim().isEmpty() ||
            regNo == null || regNo.trim().isEmpty() ||
            mark1Text == null || mark1Text.trim().isEmpty() ||
            mark2Text == null || mark2Text.trim().isEmpty() ||
            mark3Text == null || mark3Text.trim().isEmpty()) {

            out.println("<h2>Error</h2>");
            out.println("<p>Please fill in all the fields.</p>");
            return;
        }

        try {

            // Convert marks into integers
            int mark1 = Integer.parseInt(mark1Text);
            int mark2 = Integer.parseInt(mark2Text);
            int mark3 = Integer.parseInt(mark3Text);

            // Validate marks
            if (mark1 < 0 || mark1 > 100 ||
                mark2 < 0 || mark2 > 100 ||
                mark3 < 0 || mark3 > 100) {

                out.println("<h2>Invalid Marks</h2>");
                out.println("<p>Marks must be between 0 and 100.</p>");
                return;
            }

            // Calculate total
            int total = mark1 + mark2 + mark3;

            // Calculate average
            double average = total / 3.0;

            // Find highest mark
            int highest = Math.max(mark1,
                            Math.max(mark2, mark3));

            // Determine Pass / Fail
            boolean pass =
                    mark1 >= 40 &&
                    mark2 >= 40 &&
                    mark3 >= 40;

            String result;

            if (pass) {
                result = "PASS";
            } else {
                result = "FAIL";
            }

            // Generate result page
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Student Result</title>");

            out.println("<style>");

            out.println("body {");
            out.println("font-family: Arial;");
            out.println("background: #eef2f7;");
            out.println("padding: 40px;");
            out.println("}");

            out.println(".result {");
            out.println("width: 550px;");
            out.println("margin: auto;");
            out.println("background: white;");
            out.println("padding: 30px;");
            out.println("border-radius: 12px;");
            out.println("box-shadow: 0 5px 20px rgba(0,0,0,0.15);");
            out.println("}");

            out.println("h1 {");
            out.println("text-align: center;");
            out.println("color: #1e3a8a;");
            out.println("}");

            out.println(".detail {");
            out.println("padding: 12px;");
            out.println("border-bottom: 1px solid #ddd;");
            out.println("}");

            out.println(".result-status {");
            out.println("text-align: center;");
            out.println("font-size: 24px;");
            out.println("font-weight: bold;");
            out.println("margin-top: 20px;");
            out.println("}");

            out.println("</style>");
            out.println("</head>");

            out.println("<body>");

            out.println("<div class='result'>");

            out.println("<h1>Student Result</h1>");

            out.println("<div class='detail'>");
            out.println("<b>Name:</b> " + name);
            out.println("</div>");

            out.println("<div class='detail'>");
            out.println("<b>Register Number:</b> " + regNo);
            out.println("</div>");

            out.println("<div class='detail'>");
            out.println("<b>Subject 1:</b> " + mark1);
            out.println("</div>");

            out.println("<div class='detail'>");
            out.println("<b>Subject 2:</b> " + mark2);
            out.println("</div>");

            out.println("<div class='detail'>");
            out.println("<b>Subject 3:</b> " + mark3);
            out.println("</div>");

            out.println("<div class='detail'>");
            out.println("<b>Total:</b> " + total);
            out.println("</div>");

            out.println("<div class='detail'>");
            out.println("<b>Average:</b> " +
                        String.format("%.2f", average));
            out.println("</div>");

            out.println("<div class='detail'>");
            out.println("<b>Highest Mark:</b> " + highest);
            out.println("</div>");

            out.println("<div class='result-status'>");
            out.println("Result: " + result);
            out.println("</div>");

            out.println("</div>");

            out.println("</body>");
            out.println("</html>");

        } catch (NumberFormatException e) {

            out.println("<h2>Invalid Input</h2>");
            out.println("<p>Please enter valid numeric marks.</p>");
        }
    }
}