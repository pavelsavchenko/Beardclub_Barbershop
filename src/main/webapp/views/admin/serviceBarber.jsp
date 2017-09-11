<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<link rel="stylesheet" href="/css/style.css" type="text/css">
<link rel="stylesheet" href="/css/animate.css" type="text/css">


<%--<div id="hellopreloader">--%>
	<%--<div id="hellopreloader_preload"></div>--%>
<%--</div>--%>

<div class="bc-ground-site">
		<div  class="form-adddata wow bounceInUp" data-wow-duration="1s">

			<form:form modelAttribute="service" action="/service_barber" method="post">
				<div class="title-form"><spring:message code="label.add_service"/></div>
				<h6 class="placeholders"><spring:message code="label.name_of_service"/></h6>
				<span class="exception-message">${serviceNameException}</span>
				<form:input path="nameOfBarberService" class="input-style"/>

				<h6 class="placeholders"><spring:message code="label.price_of_service"/></h6>
				<span class="exception-message">${priceException}</span>
				<form:input path="price" class="input-style"/>
				<br>
				<br>
				<button type="submit" class="btn btn-success button-style"><spring:message code="label.add_service"/></button>
			</form:form>
			
		</div>

<div  style="display: flex; flex-wrap: wrap; padding-left: 85px">
	<c:forEach var="service" items="${services.content}">
		<div class="current-barber-service">
			<img style="margin-top: -8px;margin-left: 43%;" src="https://cdn1.iconfinder.com/data/icons/barbershop-1/154/barbershop-barber-scissors-instrument-hair-style-512.png" width="50">
			<h4 style="color: orange"><spring:message code="label.table_service"/></h4>
			<h1 style="color: #222222">${service.nameOfBarberService}</h1>
			<div class="price-current-service">
				<spring:message code="label.price"/>
					${service.price}
				<spring:message code="label.uah"/>
			</div>
			<a class="delete glyphicon glyphicon-remove" href="/deleteService/${service.id}"></a>
			<a class="update-data glyphicon glyphicon-pencil" href="/updateServices/${service.id}"></a>
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
						<custom:sort innerHtml="Name asc" paramValue="nameOfCommodity"/>
						<custom:sort innerHtml="Name desc" paramValue="nameOfCommodity,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-8 col-xs-12 text-center">
				<custom:pageable page="${services}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
			</div>
			<div class="col-md-2 col-xs-6">
				<custom:size posibleSizes="2,4,10" size="${services.size}"/>
			</div>
		</div>
	</div>
</div>
</div>

<div  class="glyphicon glyphicon-menu-left back"><a href="/" >BACK</a></div>
	<script type="text/javascript" src="/js/js.js"></script>
<script src="/js/wow.min.js" type="text/javascript"></script>
<script>
    new WOW().init();
</script>