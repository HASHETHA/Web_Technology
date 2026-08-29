
package com.itservice;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServiceRequestServlet")
public class ServiceRequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Read form values
        String employeeId = request.getParameter("employeeId");
        String employeeName = request.getParameter("employeeName");
        String department = request.getParameter("department");
        String problemCategory = request.getParameter("problemCategory");
        String problemDescription = request.getParameter("problemDescription");
        String priority = request.getParameter("priority");

        // Validate mandatory fields
        if (isEmpty(employeeId) ||
            isEmpty(employeeName) ||
            isEmpty(department) ||
            isEmpty(problemCategory) ||
            isEmpty(problemDescription) ||
            isEmpty(priority)) {

            request.setAttribute("error",
                    "All fields are mandatory. Please fill in all details.");

            request.getRequestDispatcher("serviceRequest.jsp")
                   .forward(request, response);

            return;
        }

        // Create Model object
        ServiceRequest serviceRequest =
                new ServiceRequest(
                        employeeId,
                        employeeName,
                        department,
                        problemCategory,
                        problemDescription,
                        priority
                );

        // Generate request number
        Random random = new Random();
        String requestNumber = "SR-" + (1001 + random.nextInt(8999));

        // Store data as request attributes
        request.setAttribute("serviceRequest", serviceRequest);
        request.setAttribute("requestNumber", requestNumber);

        // Forward to acknowledgement page
        request.getRequestDispatcher("acknowledgement.jsp")
               .forward(request, response);
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}