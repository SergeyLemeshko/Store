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
			
		<spring:url	value="/resources/scripts/angular.min.js" var="angular_url" />
		<spring:url	value="/resources/scripts/angular-ui-router.js" var="angular_ui_router_url" />
		
		<spring:url	value="/resources/scripts/app/app.module.js" var="app_url" />
        <spring:url	value="/resources/scripts/app/app.config.js" var="app_config_url" /> 
		<spring:url	value="/resources/scripts/app/category-list/category-list.component.js" var="category_list_component_url" />
		<spring:url	value="/resources/scripts/app/category-list/category-list.module.js" var="category_list_module_url" />
		<spring:url	value="/resources/scripts/app/brand-list/brand-list.component.js" var="brand_list_component_url" />
		<spring:url	value="/resources/scripts/app/brand-list/brand-list.module.js" var="brand_list_module_url" />
		<spring:url	value="/resources/scripts/app/item-list/item-list.component.js" var="item_list_component_url" />
		<spring:url	value="/resources/scripts/app/item-list/item-list.module.js" var="item_list_module_url" />
		
		
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
		<script src="${item_list_module_url}" type="text/javascript"><jsp:text/></script>
		<script src="${item_list_component_url}" type="text/javascript"><jsp:text/></script>
		<script src="${app_url}" type="text/javascript"><jsp:text/></script>	
        <script src="${app_config_url}" type="text/javascript"><jsp:text/></script>	
		
		<spring:theme code="styleSheet" var="app_css" />
		<spring:url value="/${app_css}" var="app_css_url" />
		<link rel="stylesheet"  href="${app_css_url}" />
			
	</head>
	
	<body>
		<div ui-view="category"></div>
		<div ui-view="brand"></div>
		<div ui-view="item"></div>
	</body>
</html>
