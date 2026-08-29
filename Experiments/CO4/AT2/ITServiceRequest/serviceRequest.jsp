<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>IT Service Request</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 40px;
        }

        .container {
            width: 600px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
        }

        h1 {
            text-align: center;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input, select, textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            box-sizing: border-box;
        }

        textarea {
            height: 100px;
        }

        .radio-group {
            margin-top: 8px;
        }

        .radio-group input {
            width: auto;
        }

        .submit-btn {
            margin-top: 25px;
            width: 100%;
            padding: 12px;
            background-color: #333;
            color: white;
            border: none;
            cursor: pointer;
        }

        .error {
            color: red;
            margin-bottom: 15px;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>IT Service Request</h1>

    <% if (request.getAttribute("error") != null) { %>
        <div class="error">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>

    <form action="ServiceRequestServlet" method="post">

        <label>Employee ID</label>
        <input type="text" name="employeeId" required>

        <label>Employee Name</label>
        <input type="text" name="employeeName" required>

        <label>Department</label>
        <input type="text" name="department" required>

        <label>Problem Category</label>
        <select name="problemCategory" required>
            <option value="">-- Select Category --</option>
            <option value="Network">Network</option>
            <option value="Software">Software</option>
            <option value="Hardware">Hardware</option>
            <option value="Account">Account</option>
            <option value="Other">Other</option>
        </select>

        <label>Problem Description</label>
        <textarea name="problemDescription"
                  placeholder="Describe your problem..."
                  required></textarea>

        <label>Priority</label>

        <div class="radio-group">
            <input type="radio" name="priority" value="Low" required>
            Low

            <input type="radio" name="priority" value="Medium">
            Medium

            <input type="radio" name="priority" value="High">
            High
        </div>

        <button type="submit" class="submit-btn">
            Submit Service Request
        </button>

    </form>

</div>

</body>
</html>