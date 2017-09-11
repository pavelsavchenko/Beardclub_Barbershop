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
		<div style="display: flex" class="form-adddata wow bounceInUp" data-wow-duration="1s">


			<form:form modelAttribute="commodity" action="/addCommodity?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
				<div class="title-form"><spring:message code="label.add_commodity"/></div>
				<br>
				<h6 class="placeholders"><spring:message code="label.choose_subcategory"/></h6>
				<form:select path="subcategoty" items="${subcategories}" itemLabel="nameOfSubcategory" itemValue="id" cssClass="select-style"/>
				<br>
				<br>
				<h6 class="placeholders"><spring:message code="label.add_image_commodity"/></h6>
					<input name="image" type="file" required = required/>
					<br>
				<h6 class="placeholders"><spring:message code="label.name_commodity"/></h6>
					<span class="exception-message">${commodityNameException}</span>
				<form:input path="nameOfCommodity" cssClass="input-style"/>

				<h6 class="placeholders"><spring:message code="label.price_of_commodity"/></h6>
				<span class="exception-message">${priceException}</span>
				<form:input path="price" cssClass="input-style"/>

				<h6 class="placeholders"><spring:message code="label.description_of_commodity"/></h6>
				<span class="exception-message">${descriptionException}</span>
				<form:textarea path="desription" cssClass="description-style" rows="8" cols="39"/>

				<br>
				<br>

				<button type="submit" class="btn btn-success button-style"><spring:message code="label.add_commodity"/></button>
			</form:form>

		</div>
	<div class="commodity-content">

			<c:forEach var="c" items="${commodities.content}">
				<div class="current-commodity">
					<img class="commodity-image" src="${c.pathImage}" >

				<div class="title-commodity">
					${c.nameOfCommodity}
				</div>
				<div class="price-commodity">
					<h3 style="margin-top: 35px;"><spring:message code="label.price"/>${c.price} <spring:message code="label.uah"/></h3>
				</div>
				<div class="description-commodity">
					<h4>Description</h4>
					<p>${c.desription}</p>
				</div>
					<div class="subcategory-commodity">
						Subcategory: ${c.subcategoty.nameOfSubcategory}
					</div>
					<div class="setting">
						<a class="delete glyphicon glyphicon-remove" href="/deleteCommodity/${c.id}"></a>
						<a class="update-data glyphicon glyphicon-pencil" href="/updateCommodity/${c.id}"></a>
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
						<custom:sort innerHtml="Name asc" paramValue="nameOfCommodity"/>
						<custom:sort innerHtml="Name desc" paramValue="nameOfCommodity,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-8 col-xs-12 text-center">
				<custom:pageable page="${commodities}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
			</div>
			<div class="col-md-2 col-xs-6">
				<custom:size posibleSizes="2,4,10" size="${commodities.size}"/>
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