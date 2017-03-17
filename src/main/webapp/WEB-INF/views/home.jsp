<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html ng-app="storeApp">
	<head>
		<title>Store</title>
		
		
		<spring:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"	var="jquery_url" />
		<spring:url value="https://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js" var="bootstrap_url" />
		<spring:url	value="https://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" var="bootstrap_css_url" />
		
		<spring:url	value="/resources/styles/standard.css" var="standard_css_url" />
		<spring:url	value="/resources/scripts/jscripts.js" var="jscripts_url" />
			
		<spring:url	value="/resources/scripts/angular.min.js" var="angular_url" />
 		<spring:url	value="/resources/scripts/angular-route.min.js" var="angular_route_url" /> 
		<spring:url	value="/resources/scripts/angular-ui-router.js" var="angular_ui_router_url" />
		
		<spring:url	value="/resources/scripts/app/app.module.js" var="app_url" />
        <spring:url	value="/resources/scripts/app/app.config.js" var="app_config_url" /> 
		<spring:url	value="/resources/scripts/app/category-list/category-list.component.js" var="category_list_component_url" />
		<spring:url	value="/resources/scripts/app/category-list/category-list.module.js" var="category_list_module_url" />
		<spring:url	value="/resources/scripts/app/brand-list/brand-list.component.js" var="brand_list_component_url" />
		<spring:url	value="/resources/scripts/app/brand-list/brand-list.module.js" var="brand_list_module_url" />
		
		
		<link rel="stylesheet" type="text/css" media="screen" href="${bootstrap_css_url}" />
		<link rel="stylesheet" type="text/css" media="screen" href="${standard_css_url}" />
		<script src="${jquery_url}" type="text/javascript "><jsp:text/></script>
		<script src="${bootstrap_url}" type="text/javascript"><jsp:text/></script>
		<script src="${angular_url}" type="text/javascript"><jsp:text/></script>
		<script src="${angular_ui_router_url}" type="text/javascript"><jsp:text/></script>
				
		
		<script src="${category_list_module_url}" type="text/javascript"><jsp:text/></script>
		<script src="${category_list_component_url}" type="text/javascript"><jsp:text/></script>
		<script src="${brand_list_module_url}" type="text/javascript"><jsp:text/></script>
		<script src="${brand_list_component_url}" type="text/javascript"><jsp:text/></script>
		<script src="${app_url}" type="text/javascript"><jsp:text/></script>	
        <script src="${app_config_url}" type="text/javascript"><jsp:text/></script>	
		
		<spring:theme code="styleSheet" var="app_css" />
		<spring:url value="/${app_css}" var="app_css_url" />
		<link rel="stylesheet"  href="${app_css_url}" />
		
		
		<spring:url value="/resources/images" var="images" />
		
	</head>
	
	<body>
		<div ui-view="category"></div>
		<div ui-view="brand"></div>
	 
<!-- 	   <div class="navbar navbar-inverse navbar-fixed-top" role="navigation"> -->
<!-- 	      <div class="container"> -->
<!-- 	        <div class="navbar-header"> -->
<%-- 	            <a class="navbar-brand" href="#"><spring:message code="label.items_category" /></a> --%>
<!-- 	        </div> -->
<%-- 	      	<c:if test="${!empty itemsCategory}"> --%>
<!-- 	          	<div class="collapse navbar-collapse"> -->
<!-- 	         		 <ul class="nav navbar-nav" id="categoryContainer"> -->
<%-- 						<c:forEach items="${itemsCategory}" var="item"> --%>
<%--                             <li class="${item.id == category ? 'active' : ''}"><a data-ref="${pageContext.request.contextPath}/category/${item.id}" href="#" >${item.name}</a></li> --%>
<%-- 						</c:forEach> --%>
<!-- 					</ul> -->
<!-- 	       		</div> -->
<%-- 			</c:if> --%>
			
<!-- 	      </div> -->
<!-- 	    </div> -->
<!-- 	    <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation"> -->
<!-- 	          <div class="list-group" id="brandContainer"> -->
<!-- 	          </div> -->
<!--         </div> -->
	    <div class="container">
	    	<div class="row row-offcanvas row-offcanvas-left">
				<div class="col-xs-12 col-sm-9" >
					<div id="brandDescription"></div>
				    <c:if test="${brand.description != null}">
				    	<div class="jumbotron">
				            <p>${brand.description}</p>
				        </div>
			        </c:if>
		    		<div class="row" id="itemRow">
   				  </div>
				</div>
			</div>
	  </div>
	  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
		      </div>
		      <div class="modal-body">
		      	<img class="center-block itemSmallImage" id="myModalImage"  alt="...">
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary">Save changes</button>
		      </div>
		     </div>
		   </div>
		</div>
	</div>
	</body>
	<script src="${jscripts_url}" type="text/javascript"><jsp:text/></script>
	<script type="text/javascript">
			 var requestContextPath = '${pageContext.request.contextPath}';
			 var imagesPath = requestContextPath + "/resources/images";
	</script> 
</html>
