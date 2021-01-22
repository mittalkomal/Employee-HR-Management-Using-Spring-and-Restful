<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
<style type="text/css">
#logoutBtn, #downloadBtn, #submitBtn, #resetBtn {
	float: right;
}

#table, th, td {
	border-collapse: collapse;
	border: 1px solid black;
	text-align: center;
}

table {
	width: 90%;
}

.editLink {
	color: blue;
	text-decoration: underline;
	cursor: pointer;
}

#editSec {
	position: fixed;
	display: none;
	top: 20%;
	left: 35%;
	width: 350px;
	z-index: 5;
}

/* #overlay {
	position: fixed;
	display: none;
	background-color: darkgray;
	width: 100%;
	height: 100%;
	opacity: 0.9;
	z-index: 1;
} */
#overlay {
	width: 100%;
	height: 100%;
	background-color: #AFEDFC;
	opacity: 1.0;
	position: fixed;
	display: none;
}

.editForm {
	float: right;
	margin-right: 20px;
	border: 0.5px solid black;
}

.fixed-header, .fixed-footer {
	width: 100%;
	position: fixed; 
	background: #333;
 	padding: 0 0; 
	color: #fff;
	text-align: center;
}

.fixed-header {
	top: 0;
}

.fixed-footer {
	bottom: 0;
}

legend {
  background-color: gray;
  color: white;
  padding: 5px 10px;
}
</style>
</head>
<body  style="background-color:#AFEDFC;">
<h4 class="fixed-header">Employee Management Tool</h4> 

	<div id="overlay"></div>

	<div id="header">
<br> <br>
		<h3 style="float: right;">
			Welcome ${loginedUser}  <a href="logout"><img width='15px'
				height='15px' style="margin-left: 15px;"
				src="C:\Users\komalmittal\eclipse-workspace\ImageManagement\images\cross-mark.png"
				id='logoutBtn'></a>
		</h3>

	</div>
	<br>
	<br>
	<br>
	<div id="uploadSec">
		
			<form action="uploadEmployeeDetails" method="post"
				enctype="multipart/form-data">
				<input type="file" name="csvFile" accept=".csv" required/>
				<button type="submit" class="btn btn-primary">Submit</button>
				<input type="reset">
			</form>
			<a href="downloadEmployeeData" id="downloadBtn">
		<button>Download CSV</button>	</a>
		
		
		

	</div>
	<br>


	

	<br>
	<br>
<fieldset>
			<legend>Employee Listings</legend>
	<table id="table">
		<tr  style="background-color:#33D5FF;">
			<th>Employee Code</th>
			<th>Name</th>
			<th>Location</th>
			<th>Email</th>
			<th>Date of Birth</th>
			<th>Action</th>
		</tr>
		<s:forEach var="listValue" items="${list}" varStatus="status">
			<tr>
				<td class="employeeCode">${listValue.employeeCode}</td>
				<td class="name1">${listValue.name}</td>
				<td class="location">${listValue.location}</td>
				<td class="email">${listValue.email}</td>
				<td class="dob">${listValue.dob}</td>
				<td><span class="editLink">Edit</span></td>
			</tr>
		</s:forEach>
	</table>
	<H4>${successMsg}</H4>
	</fieldset>

	<div id="editSec">
		<fieldset>
			<legend>Edit Employee Details</legend>
			<form action="employeeUpdate" method="post">
				<label>Employee Code<input class="editForm" type="text"
					name="employeeCode" id="employeeCode"></label> <br> <br>
				<label>Name <input class="editForm" type="text" name="name"
					required id="name"  maxlength="100" required></label> <br> <br> <label>Location <textarea
						class="editForm" name="location" id="location" required >type your text</textarea>
				</label> <br> <br> <label>Email <input class="editForm"
					 type="email" name="email" id="email"  maxlength="100" required></label> <br> <br> <label>Date
					Of Birth <input type="date" class="editForm"  name="dob" id="dob" required>
				</label> <br> <br> <input type="submit" id="editBtn">
			</form>
		</fieldset>
	</div>
	

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
	<script>
		$(function() {
			var glObj = null;
			var editSec = $("#editSec");
			var overlay = $("#overlay");
			var editBtn = $("#editBtn");
			var editLink = $(".editLink");
			var employeeCode = $("#employeeCode");
			var eCode = $("#eCode");
			var name = $("#name");
			var location = $("#location");
			var email = $("#email");
			var dob = $("#dob");

			overlay.on("click", toggleView);
			editLink.on("click", openUpdateEmpView);

			function openUpdateEmpView() {
				toggleView();
			}

			$(".editLink").on("click", function() {
				glObj = $(this).parents("tr");
				toggleView();
				var str = glObj.children("td.employeeCode").html();
				employeeCode.val(glObj.children("td.employeeCode").html());
				name.val(glObj.children("td.name1").html());
				location.val(glObj.children("td.location").html());
				dob.val(glObj.children("td.dob").html());
				email.val(glObj.children("td.email").html());
				toggleView();
			});

			function toggleView() {
				overlay.toggle();
				editSec.toggle();
			}

		});
	</script>
	
	<h4 class="fixed-footer">Copyright @Nagarro</h4> 
</body>
</html>