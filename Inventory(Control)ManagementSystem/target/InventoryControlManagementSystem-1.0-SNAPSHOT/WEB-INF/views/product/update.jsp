<%-- 
    Document   : update
    Created on : Oct 3, 2016, 8:51:00 AM
    Author     : Mohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
               <a href="${pageContext.request.contextPath}" class="btn btn-success"><span class="glyphicon glyphicon-home"></span></a>
               <a href="${pageContext.request.contextPath}/displayproduct" class="btn btn-success">Products</a>
         
               <div class="h1 text-center">Update Products</div>
            <form action="" method="post">
                <div>
                    <label>Product Name</label>
                    <input type="text" name="productName" required="required" value="${product.productName}" class="form-control"/>
                </div>
                <div>
                    <label>Cost Price</label>
                    <input type="text" name="costPrice" required="required" value="${product.costPrice}" class="form-control"/>
                </div>
                <div>
                    <label>Selling Price</label>
                    <input type="text" name="sellingPrice" required="required" value="${product.sellingPrice}" class="form-control"/>
                </div>
                <div>
                    <label>Quantity Available</label>
                    <input type="text" name="quantityAvailable" required="required" value="${product.quantityAvailable}" class="form-control"/>
                </div>
                <div>
                    <label>Select Availability Status</label>
                    <select name="status" class="form-control" required="required">
                        <option value="">Select Any Option</option>
                        <option value="0">Unavailable</option>
                        <option value="1">Available</option>
                    </select>
                </div>
                <div>
                    <br>
                    <button type="submit" class="btn btn-success">Submit</button>
                    <button type="reset" class="btn btn-danger">Clear</button>
                </div>
            </form>
        </div>
    </body>
</html>
