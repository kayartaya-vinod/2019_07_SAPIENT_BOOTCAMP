<%@page import="com.ps.entity.Product"%>
<%@page import="java.util.Collection"%>
<%@ include file="header.txt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${requestScope.category!=null}">
	<h1>${category.categoryName }</h1>
	<p>${category.description}
	<div>
		<img src="./category-picture?cat_id=${category.categoryId}"
			alt="${category.categoryName}">
	</div>
</c:if>

<h3>${requestScope.title}</h3>

<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th>Product name</th>
			<th>Category</th>
			<th>Supplied by</th>
			<th>Unit price</th>
			<th>Discontinued?</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${products}" var="p">
			<tr>
				<td>${p.productName}</td>
				<td><a
					href="./get-category-info?cat_id=${ p.category.categoryId }">
						${p.category.categoryName} </a></td>
				<td>${p.supplier.companyName} (${p.supplier.contactDetails.city})</td>
				<td>${p.unitPrice}</td>
				<td>${p.discontinued?"Yes":"No"}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<%@ include file="footer.txt"%>


