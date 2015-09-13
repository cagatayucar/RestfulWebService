<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit Types</title>
<link href="../resources/css/main.css" rel="stylesheet" type="text/css"/>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
   
    $(document).ready(function() {
      
      $('#editTypeForm').submit(function(event) {
    	  
    	  var type_name = $('#type_name').val();
    	  var json = { "type_name" : type_name};
    	  
        $.ajax({
        	url: $("#editTypeForm").attr( "action"),
        	data: JSON.stringify(json),
        	type: "PUT",
        	
        	beforeSend: function(xhr) {
        		xhr.setRequestHeader("Accept", "application/json");
        		xhr.setRequestHeader("Content-Type", "application/json");
        	},
        	success: function(personelType) {
        		var respContent = "";
        		
		  		respContent += "<span class='success'>Type was edited: ";
		  		
        		
        		$("#typeFromResponse").html(respContent);   		
        	}
        });
        
        event.preventDefault();
      });
       
    });   
  </script>

</head>
<body>
<div id="container">
<h1>Edit Type</h1>
<div id="typeFromResponse">
<p>Here you can edit Type info:</p>
<div id="typeFromResponse"></div>
</div>
<form:form id="editTypeForm" commandName="pType" 
action="${pageContext.request.contextPath}/testcontroller/editType/${pType.type_id}">
<table>
<tbody>
<tr>
<td>Type Name:</td>
<td><form:input path="type_name" /></td>
</tr>
<tr>
<td><input type="submit" value="Edit" /></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/testcontroller/list">Personel Tip Listesi</a>
</div>
</body>
</html>