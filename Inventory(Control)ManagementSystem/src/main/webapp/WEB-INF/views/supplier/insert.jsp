<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </head>
    <body>
        <div class="container">
            <div class="h3 text-center">Add Suppliers Details</div>
            <form action="" method="post">
                <div>
                    <label>First Name</label>
                    <input type="text" class="form-control" required="required" name="firstName">
                </div>
                <div>
                    <label>Last Name</label>
                    <input type="text" class="form-control" required="required" name="lastName">
                </div>
                <div>
                    <label>Contact Number</label>
                    <input type="text" class="form-control" required="required" name="contactNumber">
                </div>
                <div>
                    <label>Address</label>
                    <input type="text" class="form-control" required="required" name="address">
                </div>
                <div>
                    <label>Product</label>
                    <select class="form-control" required="required" name="product.id">
                        <c:forEach var="product" items="${products}">
                            <option value=""></option>
                            <option value="${product.id}">${product.productName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <br>
                    <button type="submit" class="btn btn-success">Submit</button>
                </div>
            </form>
        </div>
    </body>
</html>
