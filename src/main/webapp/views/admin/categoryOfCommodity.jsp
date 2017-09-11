<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<link rel="stylesheet" href="/css/style.css" type="text/css">
<link rel="stylesheet" href="/css/animate.css" type="text/css">


<%--<div id="hellopreloader">--%>
	<%--<div id="hellopreloader_preload"></div>--%>
<%--</div>--%>
<div class="bc-ground-site">
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12">


			<div  class="form-adddata wow bounceInUp" data-wow-duration="1s">
				<form:form modelAttribute="category" method="post" action="/addCategoryOfCommodity">
					<div class="title-form"><spring:message code="label.add_category"/></div>

					<h6 class="placeholders"><spring:message code="label.name_category_of_commodity"/></h6>

				<span class="exception-message">${categoryException}</span>
				<input  name="nameOfCategory" class="input-style"/>
				<br>
				<br>
				<button  id="addCategory" type="submit" class="btn btn-success button-style"><spring:message code="label.add_category"/></button>
				</form:form>
			</div>


		</div>



		<div  style="display: flex; flex-wrap: wrap; padding-left: 85px">
			<c:forEach var="c" items="${categories.content}">
				<div class="current-barber-service">

					<h4 style="color: orange"><spring:message code="label.category_of_commodity"/></h4>
					<h1 style="color: #222222">${c.nameOfCategory}</h1>

					<a class="delete glyphicon glyphicon-remove" href="/deleteCategory/${c.id}"></a>
					<a class="update-data glyphicon glyphicon-pencil" href="/updateCategory/${c.id}"></a>

				</div>
			</c:forEach>
		</div>

<div style="display: flex; justify-content: center;text-align: center">

	<div class="col-md-12 col-xs-12">
		<div class="row">
			<div class="col-md-2 col-xs-6">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span
							class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="nameOfCategory"/>
						<custom:sort innerHtml="Name desc" paramValue="nameOfCategory,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-8 col-xs-12 text-center">
				<custom:pageable page="${categories}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
			</div>
			<div class="col-md-2 col-xs-6">
				<custom:size posibleSizes="1,2,5,10" size="${categories.size}"/>
			</div>
		</div>
	</div>
</div>

<%--<input type="hidden" name="csrf_name"--%>
	   <%--value="${_csrf.parameterName}" />--%>
<%--<input type="hidden" name="csrf_value"--%>
	   <%--value="${_csrf.token}" />--%>

	<div class="glyphicon glyphicon-menu-left back"><a href="/" >BACK</a></div>
	</div>
	<script type="text/javascript" src="/js/js.js"></script>
	<%--&lt;%&ndash;<script type="text/javascript" src="/js/category.js">&ndash;%&gt;--%>
	<%--</script>--%>
<script src="/js/wow.min.js" type="text/javascript"></script>
<script>
    new WOW().init();
</script>