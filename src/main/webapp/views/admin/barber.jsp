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

			<form:form modelAttribute="barber" action="/addBarber?${_csrf.parameterName}=${_csrf.token}" method="post"
				enctype="multipart/form-data">
				<div class="title-form"><spring:message code="label.add_barber"/></div>
				<br>
				<input name="image" type="file" required="required"/>
				<br>
				<h6 class="placeholders"><spring:message code="label.first_name"/></h6>
				<span class="exception-message">${barberFirstNameException}</span>
				<form:input path="firstName" cssClass="input-style"/>

				<h6 class="placeholders"><spring:message code="label.last_name"/></h6>
				<span class="exception-message">${barberLastNameException}</span>
				<form:input path="lastName" cssClass="input-style"/>

				<h6 class="placeholders"><spring:message code="label.job"/></h6>
				<span class="exception-message">${barberJobException}</span>
				<form:input path="position" cssClass="input-style"/>

				<h6 class="placeholders"><spring:message code="label.choose_services"/></h6>
				<form:select path="barberServices" items="${services}" itemLabel="nameOfBarberService" itemValue="id" cssClass="select-style" />
				<br>
				<br>
				<button type="submit" class="btn btn-success button-style"><spring:message code="label.add_barber"/></button>

			</form:form>
			
		</div>

<div class="commodity-content">

	<c:forEach var="c" items="${barbers.content}">
		<div class="current-commodity">
			<h2 style="color: #222222;text-align: center; color: orange"><spring:message code="label.barber_card"/></h2>
			<img class="commodity-image" src="${c.pathImage}" >

			<div class="title-barber">
				<h3 style="color: lightgrey"><spring:message code="label.card_first_name"/></h3>
					 ${c.firstName}
			</div>
			<div  style="padding-top: 0px" class="title-barber">
				<h3 style="padding-top: 13px; color: lightgrey"><spring:message code="label.card_last_name"/></h3>
				 ${c.lastName}
			</div>
			<div class="description-commodity">
				<h4 style="color: lightgrey; font-weight: 500"><spring:message code="label.job"/></h4>
				<p style="font-size: 20px">${c.position}</p>
			</div>
			<div class="service-barber">
				<h4 style="color: lightgrey; font-weight: 500; margin-bottom: 20px"><spring:message code="label.card_services"/></h4>

				<c:forEach var="s" items="${c.barberServices}">
					<h4 style="margin:0;margin-top: -10px;">${s.nameOfBarberService}</h4>
						<br>
					<h5 style="margin: 0; border-bottom: 1px solid rgba(211,211,211, .4); padding-bottom: 5px"><spring:message code="label.price"/> ${s.price} <spring:message code="label.uah"/></h5>
						<br>
				</c:forEach>
			</div>
			<div class="setting">
				<a class="delete glyphicon glyphicon-remove" href="/deleteBarber/${c.id}"></a>
				<a class="update-data glyphicon glyphicon-pencil" href="/updateBarber/${c.id}"></a>
			</div>

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
						<custom:sort innerHtml="Name asc" paramValue="lastName"/>
						<custom:sort innerHtml="Name desc" paramValue="lastName,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-8 col-xs-12 text-center">
				<custom:pageable page="${barbers}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
			</div>
			<div class="col-md-2 col-xs-6">
				<custom:size posibleSizes="1,2,4,10" size="${barbers.size}"/>
			</div>
		</div>
	</div>
</div>
	<div  class="glyphicon glyphicon-menu-left back"><a href="/" >BACK</a></div>
</div>
	<script type="text/javascript" src="/js/js.js"></script>
<script src="/js/wow.min.js" type="text/javascript"></script>
<script>
    new WOW().init();
</script>
