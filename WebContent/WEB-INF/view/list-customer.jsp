<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<title>list of customer</title>
<link
		type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css "/>

</head>

<body>

<div id ="wrapper">
    <div id ="header">
    <h2>Customer relationship  manager</h2>
    </div>
</div>

<div  id ="container">
     <div id ="content">
     
     <!-- Button to add new Student -->
     <input type="button" onclick="window.location.href='showFormForAdd'"
     class="add-button" value="Add Customer">
     
     <!--  add your table -->
     <table>
     		<tr>
     			<th>first name</th>
     			<th>last name</th>
     			<th>email</th>
     			<th>Action</th>
     		</tr>
     		 <!--  loop over and print the customer -->
     		<c:forEach var="tempCustomer" items="${customers}">
     		
     		<c:url var="updateLink" value="/customer/showFormForUpdate">
     			<c:param name="customerId" value="${tempCustomer.id}"></c:param>
     		</c:url>
     		
     		<c:url var="deleteLink" value="/customer/delete">
     			<c:param name="customerId" value="${tempCustomer.id}"></c:param>
     		</c:url>
     		
     		
     				<tr>
     				    <td>${tempCustomer.firstName}</td>
     				    <td>${tempCustomer.lastName}</td>
     				    <td>${tempCustomer.email}</td>
     				    <td>
     				    <a href="${updateLink}">update</a>
     				    |    
     		     		<a href="${deleteLink }"
     		     		onclick="if(!(confirm('are you sure want to delete?')))return false"> delete</a>		    
     				    </td>
     				</tr>
     		</c:forEach>
     </table>
     </div>

</div>

</body>



</html>