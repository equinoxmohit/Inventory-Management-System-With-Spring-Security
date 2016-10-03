<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <div class="h3 text-center">Products Listing</div>
            <table class="table table-hover">
                    <tr>
                        <th>Product Name</th>
                        <th>Cost Price</th>
                        <th>Selling Price</th>
                        <th>Quantity Available</th>
                        <th>Added Date</th>
                        <th>Availability Status</th>
                        <th>Action</th>
                    </tr>   
                    <c:forEach var="pr" items="${product}">
                        <tr>
                            <td>${pr.productName}</td>
                            <td>${pr.costPrice}</td>
                            <td>${pr.sellingPrice}</td>
                            <td>${pr.quantityAvailable}</td>
                            <td>${pr.addedDate}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${pr.status}">
                                        Available
                                    </c:when>
                                    <c:otherwise>
                                        Unavailable
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/updateproduct/${pr.id}" class="btn btn-success"><span class="glyphicon glyphicon-pencil"></span></a>
                                <a href="${pageContext.request.contextPath}/deleteproduct/${pr.id}" class="btn btn-danger"><span class="glyphicon glyphicon-trash" onclick="return confirm('Are you sure you want to delete?')"></span></a>
                            </td>
                        </tr>
                    </c:forEach>
    



            </table>

        </div>
    </body>
</html>
