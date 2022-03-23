<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> </script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"> </script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"> </script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"> </script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
<title>Order Management</title>


<div id="addTab" style="margin-top: 3rem">
    <form:form id="saveOrder" action="/saveOrder" method="post" modelAttribute="order">
        <div style="margin: auto" class="form-group col-md-12">
            <div style="margin-left: 10rem; margin-right: 10rem" class="form-group row required">

                <div class="col-md-4">
                    <label class="form-label control-label" >Product Name<span style="color: red">*</span></label>
                    <form:select path="product_Id" class="form-select" aria-label="Default select example" id="product_Id">

                        <option value="Select">Select</option>
                        <c:forEach items="${productList}" var="e">
                            <option value="${e.product_Id}">${e.name}</option>
                        </c:forEach>
                    </form:select>
                </div>

                <div class="col-md-4">
                    <label class="form-label control-label" >Order Date<span style="color: red">*</span></label>
                    <form:input path="order_date" value="${order.order_date}" type="date" class="form-control" id="orderDate"/>
                </div>

                <div class="col-md-4">
                    <label class="form-label control-label" >Quantity<span style="color: red">*</span></label>
                    <form:input path="order_qty" type="number" value="${order.order_qty}" class="form-control" id="qty"/>
                </div>


            <form:hidden path="order_Id" value="${order.order_Id}"/>

            <div style="margin: auto; margin-top: 20px" class="form-group row col-md-6">

                <div class="form-group row col-md-3">
                    <button id="submit"   class="btn btn-success">Submit</button>
                </div>

                <div style="margin-left: 10px" class="form-group row col-md-3">
                    <button onclick="window.location.href='${pageContext.request.contextPath}/orderManagement'"class="btn btn-danger">Cancel</button>
                </div>

            </div>

            <div id="display"></div>

        </div>
    </form:form>
</div>

<div id="viewTab" style="margin: 10rem" >
    <h4 style="text-align: center">Order Details</h4>
    <table border = "1" align="center" class="table table-striped table-bordered" cellspacing="0">
        <thead>
        <tr>
            <th>Sl No</th>
            <th>Product Name</th>
            <th>Order Date</th>
            <th>Order Quantity</th>
            <th>Unit Price</th>
            <th>Order Value</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${orderList}" var="e">
            <tr>
                <td>${e.order_Id}</td>
                <td>${e.product_Id}</td>
                <td>${e.order_date}</td>
                <td>${e.order_qty}</td>
                <td>price</td>
                <td>total</td>
                <td>
                    <a href = "/editOrder/${e.order_Id}">Edit</a>
                    |
                    <a href = "/deleteOrder/${e.order_Id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>


        <tfoot>
        <tr>
            <td colspan="7" style="text-align: center;">
                <button class="btn btn-info btn-lg" onclick="window.location.href='${pageContext.request.contextPath}/orderManagement'">Place Order</button>
            </td>
        </tr>
        </tfoot>

    </table>
</div>

