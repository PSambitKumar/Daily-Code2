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
<title>Employee Management</title>

    <div style="margin: 3rem">
        <div class="top_tab_container">
            <ul class="nav nav-pills">
                <li class="active"><a  data-toggle="pill" class="btn btn-info" href="#add_tab" onclick="showAddTab()">Add</a></li>
                <li style="margin-left: 5px"><a  data-toggle="pill" class="btn btn-info" href="#view_tab" onclick="showViewTab()">View</a></li>
            </ul>
        </div>
    </div>

    <div id="addTab" style="margin-top: 3rem">
            <form:form id="addDepartment" action="/saveDepartment" method="post" modelAttribute="department">
                  <div style="margin: auto" class="form-group col-md-8">

                      <div class="form-group row required">
                          <div style="margin-left: 8rem" class="col-md-4">
                              <label class="form-label control-label" >Department Name</label>
                              <form:input path="deptName" type="text" class="form-control" id="inputName"  placeholder="Enter Department Name"/>
                              <div id="alert"></div>
                          </div>
                          <form:hidden path="deptId"/>
                          <div id="display"></div>

                          <div style="margin: auto; margin-top: 20px" class="form-group row col-md-8">

                              <div class="form-group row col-md-3">
                                  <button id="submit"   class="btn btn-success">Submit</button>
                              </div>

                              <div style="margin-left: 10px" class="form-group row col-md-3">
                                  <button type="reset" class="btn btn-danger">Reset</button>
                              </div>

                          </div>
                      </div>
                  </div>
          </form:form>
    </div>

    <div id="viewTab" style="margin: 10rem" >
        <h4 style="text-align: center">Department Details</h4>
        <table border = "1" align="center" class="table table-striped table-bordered" cellspacing="0">
            <thead>
            <tr>
                <th>Sl No</th>
                <th>Department Name</th>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${departmentList}" var="e">
                <tr>
                    <td>${e.deptId}</td>
                    <td>${e.deptName}</td>
                    <td>
                        <a href = "/edit/${e.deptId}">Edit</a>
                        |
                        <a href = "/delete/${e.deptId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>


            <tfoot>
            <tr>
                <td colspan="7" style="text-align: center;">
                    <button class="btn btn-info btn-lg" onclick="window.location.href='${pageContext.request.contextPath}/departmentManagement'">Add Department</button>
                </td>
            </tr>
            </tfoot>

        </table>
    </div>

    <script>
        $(document).ready(function (){
            $('.table').DataTable({
            });
        });

        $(document).ready(function (){
            $("#viewTab").hide();
        });

        function showAddTab()
        {
            $("#addTab").show();
            $("#viewTab").hide();
        }
        function showViewTab()
        {
            $("#addTab").hide();
            $("#viewTab").show();
        }
    </script>
