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
  <form:form id="addEmployee" action="/saveEmployee" method="post" modelAttribute="employee">
    <div style="margin: auto" class="form-group col-md-12">
      <div style="margin-left: 10rem; margin-right: 10rem" class="form-group row required">

        <div class="col-md-4">
          <label class="form-label control-label" >Employee Name<span style="color: red">*</span></label>
          <form:input path="empName" type="text" class="form-control" id="empName" placeholder="Enter Your Name"/>
        </div>

        <div class="col-md-4">
          <label class="form-label control-label" >Hire Date<span style="color: red">*</span></label>
          <form:input path="hireDate" type="date" class="form-control" id="hireDate"/>
        </div>

        <div class="col-md-4">
          <label class="form-label control-label" >Salary<span style="color: red">*</span></label>
          <form:input path="salary" type="number" class="form-control" id="salary"/>
        </div>

      </div>
      <div style="margin-left: 10rem" class="form-group col-md-12 row">
        <div class="col-md-4">
          <label class="form-label control-label" >Select Department<span style="color: red">*</span></label>
          <form:select path="dept" class="form-select" aria-label="Default select example" id="deptId">

            <option value="Select">Select</option>
            <c:forEach items="${departmentList}" var="e">
              <option value="${e.deptId}">${e.deptName}</option>
            </c:forEach>
          </form:select>
        </div>


        <div style="margin-top: 35px" class="col-md-4">
          <label class="form-label control-label" >Employee Type<span style="color: red">*</span></label>
          <form:radiobutton  path="empType" value = "Contractual"/>  Contractual&emsp;&emsp;
          <form:radiobutton  path="empType" value = "Permanenet"/>  Permanenet
        </div>
      </div>

      <form:hidden path="empId"/>

      <div style="margin: auto; margin-top: 20px" class="form-group row col-md-6">

        <div class="form-group row col-md-3">
          <button id="submit"   class="btn btn-success">Submit</button>
        </div>

        <div style="margin-left: 10px" class="form-group row col-md-3">
          <button onclick="window.location='Home'; return false;" class="btn btn-danger">Cancel</button>
        </div>

      </div>

      <div id="display"></div>

    </div>
  </form:form>
</div>

<div id="viewTab" style="margin: 10rem" >
  <h4 style="text-align: center">Department Details</h4>
  <table border = "1" align="center" class="table table-striped table-bordered" cellspacing="0">
    <thead>
    <tr>
      <th>Sl No</th>
      <th>Employee Name</th>
      <th>Salary</th>
      <th>Dept ID</th>
      <th>Type</th>
      <th>Action</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${employeeList}" var="e">
      <tr>
        <td>${e.empId}</td>
        <td>${e.empName}</td>
        <td>${e.salary}</td>
        <td>${e.dept}</td>
        <td>${e.empType}</td>
        <td>
          <a href = "/edit/${e.empId}">Edit</a>
          |
          <a href = "/delete/${e.empId}">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>


    <tfoot>
    <tr>
      <td colspan="7" style="text-align: center;">
        <button class="btn btn-info btn-lg" onclick="window.location.href='${pageContext.request.contextPath}/employeeManagement'">Add Employee</button>
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
