<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
	<title>Welcome!</title>
	
	
	<spring:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"	var="jquery_url" />
	<spring:url value="https://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js" var="bootstrap_url" />
	<spring:url	value="https://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" var="bootstrap_css_url" />
	
	<link rel="stylesheet" type="text/css" media="screen" href="${bootstrap_css_url}" />
	<script src="${jquery_url}" type="text/javascript "><jsp:text/></script>
	<script src="${bootstrap_url}" type="text/javascript"><jsp:text/></script>
	
	<spring:theme code="styleSheet" var="app_css" />
	<spring:url value="/${app_css}" var="app_css_url" />
	<link rel="stylesheet"  href="${app_css_url}" />
	
	
	<spring:url value="/resources/images" var="images" />
	
</head>
	<body>
	   <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	      <div class="container">
	        <div class="navbar-header">
	            <a class="navbar-brand" href="#"><spring:message code="label.items_category" /></a>
	        </div>
	      	<c:if test="${!empty itemsCategory}">
	          	<div class="collapse navbar-collapse">
	         		 <ul class="nav navbar-nav">
						<c:forEach items="${itemsCategory}" var="item">
							<li class="${item.id == category ? 'active' : ''}"><a href="${pageContext.request.contextPath}/category/${item.id}">${item.name}</a></li>
						</c:forEach>
					</ul>
	       		</div><!--/.nav-collapse -->
			</c:if>
	      </div>
	    </div>
	    <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
	   		<c:if test="${!empty brands}">
	          <div class="list-group">
	          	<c:forEach items="${brands}" var="b">
		            <a href="${pageContext.request.contextPath}/category/${category}/brand/${b.id}" 
		            	class="${b.id == brand.id ? 'list-group-item active' : 'list-group-item' }">${b.name}</a>
		        </c:forEach>
	          </div>
          	</c:if>
        </div>
	    <div class="container">
	    	<div class="row row-offcanvas row-offcanvas-left">
				<div class="col-xs-12 col-sm-9">
				    <c:if test="${brand.description != null}">
				    	<div class="jumbotron">
				            <p>${brand.description}</p>
				        </div>
			        </c:if>
		    		<div class="row">
					  	<c:if test="${!empty items}">
						  <c:forEach items="${items}" var="item">
						  	<div class="col-sm-6 col-md-3">
							    <div class="thumbnail">
							      <img width="300" height="200" src="${images}/${item.image}" alt="...">
							      <div class="caption">
							        <h3>${item.name}</h3>
							        <p>${item.description}</p>
							      </div>
							    </div>
							</div>
						</c:forEach>
					</c:if>
				  </div>
				</div>
			</div>
	  </div>
	</body>
</html>
