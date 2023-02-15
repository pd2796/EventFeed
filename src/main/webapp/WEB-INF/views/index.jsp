<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>

<title>Start Spring MVC</title>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<h1 class="text-center mb-3">welcome to Product App</h1>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">S. No</th>
						<th scope="col">Product Name</th>
						<th scope="col">Product Description</th>
						<th scope="col">Price</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${products }" var="p">
					<tr>
						<th scope="row">Prod ${p.id }</th>
						<td>${p.name}</td>
						<td>${p.description }</td>
						<td class ="font-weight-bold">&#8377; &#x20B9;${p.price }</td>
						<td><a href="delete/${p.id }"><i class="fas fa-trash text-danger style="font-size:35px"></i></a>
						<a href="update/${p.id }"><i class="fas fa-pen-nib text-primary style="font-size:35px"></i></a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="container text-center">
			<a href="add" class="btn btn-outline-success">Add Product</a>
</div>
		</div>
	</div>
</body>
</html>