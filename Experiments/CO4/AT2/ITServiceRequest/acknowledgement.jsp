<%@ page import="com.itservice.ServiceRequest" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Service Request Submitted</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            padding: 40px;
        }

        .container {
            width: 700px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
        }

        h1 {
            text-align: center;
        }

        .success {
            text-align: center;
            padding: 15px;
            background-color: #d4edda;
            color: #155724;
            margin-bottom: 25px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #333;
            color: white;
        }

        .request-number {
            text-align: center;
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 20px;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Service Request Acknowledgement</h1>

    <div class="success">
        Your service request has been submitted successfully!
    </div>

    <div class="request-number">
        Request Number:
        <%= request.getAttribute("requestNumber") %>
    </div>

    <%
        ServiceRequest serviceRequest =
            (ServiceRequest) request.getAttribute("serviceRequest");
    %>

    <table>

        <tr>
            <th>Employee ID</th>
            <td><%= serviceRequest.getEmployeeId() %></td>
        </tr>

        <tr>
            <th>Employee Name</th>
            <td><%= serviceRequest.getEmployeeName() %></td>
        </tr>

        <tr>
            <th>Department</th>
            <td><%= serviceRequest.getDepartment() %></td>
        </tr>

        <tr>
            <th>Problem Category</th>
            <td><%= serviceRequest.getProblemCategory() %></td>
        </tr>

        <tr>
            <th>Priority</th>
            <td><%= serviceRequest.getPriority() %></td>
        </tr>

        <tr>
            <th>Problem Description</th>
            <td><%= serviceRequest.getProblemDescription() %></td>
        </tr>

    </table>

</div>

</body>
</html>