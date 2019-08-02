<%@page import="com.ps.entity.Product"%>
<%@page import="java.util.Collection"%>
<%@ include file="header.txt"%>

<h3>${requestScope.title}</h3>

<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>Product name</th>
			<th>Quantity per unit</th>
			<th>Unit price</th>
			<th>Discontinued?</th>
		</tr>
	</thead>
	<tbody>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<c:forEach items="${products}" var="p">
			<tr>
				<td>${p.productName}</td>
				<td>${p.quantityPerUnit }</td>
				<td>${p.unitPrice}</td>
				<td>${p.discontinued?"Yes":"No"}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="footer.txt"%>


