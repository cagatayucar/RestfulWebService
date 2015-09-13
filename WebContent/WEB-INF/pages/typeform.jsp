<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Yeni Personel Tipi</title>
<link href="../resources/css/main.css" rel="stylesheet" type="text/css"/>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
   
    $(document).ready(function() {
      
      $('#newPersonelType').submit(function(event) {
    	  
    	
    	  var type_name = $('#type_name').val();
    	  var json = { "type_name" : type_name};
    	  
        $.ajax({
        	url: $("#newPersonelType").attr( "action"),
        	data: JSON.stringify(json),
        	type: "POST",
        	
        	beforeSend: function(xhr) {
        		xhr.setRequestHeader("Accept", "application/json");
        		xhr.setRequestHeader("Content-Type", "application/json");
        	},
        	success: function(personelType) {
        		var respContent = "";
        		
		  		respContent += "<span class='success'>Yeni Personel Tipi Olusturuldu";
		  		
		  		
        		
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
<h1>Yeni Personel Tipi Olustur</h1>
<div>
<div id="typeFromResponse"></div>
</div>
<form:form id="newPersonelType" action="${pageContext.request.contextPath}/testcontroller/registerType.json" commandName="pType">
<table>
<tbody>

<td> <h4>Tip Adi: </h4></td>
<td><form:input path="type_name" /></td>
</tr>
<tr>

<td><input type="submit" value="Kaydet" /></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/testcontroller/list">Personel Tip Listesi</a>
</div>
</body>
</html>