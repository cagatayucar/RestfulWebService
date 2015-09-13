<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personel Type Details</title>
</head>
<body>

 <center>  
  
  <div style="color: teal; font-size: 30px">Personel Type List</div>  
  
  <c:if test="${!empty typelist}">  
   <table border="2" bgcolor="black" width="300px">  
    <tr  
     style="background-color: teal; color: white; text-align: center;"  
     height="40px">   
     <td>Type Name</td>   
    </tr>  
    <c:forEach items="${typelist}" var="type">  
     <tr  
      style="background-color: white; color: black; text-align: center;"  
      height="30px">    
      <td><c:out value="${type.type_name}" />  
      </td>
      <td>   
      <a href="${pageContext.request.contextPath}/testcontroller/editType/${type.type_id}">Edit</a><br/>
      </td>
      <td>
	  <a href="${pageContext.request.contextPath}/testcontroller/delete/${type.type_id}">Delete</a><br/>
     </td>
     
     </tr>  
    </c:forEach>  
   </table>  
  </c:if>  
  <a href="${pageContext.request.contextPath}/testcontroller/registerType">Yeni Personel Ekle</a>
 </center>  

</body>
</html>