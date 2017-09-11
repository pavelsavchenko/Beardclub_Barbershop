<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/css/animate.css" type="text/css">

<%--<div id="hellopreloader">--%>
	<%--<div id="hellopreloader_preload"></div>--%>
<%--</div>--%>
<div class="bc-ground-site">
<div class="container-fluid">
	<div class="row">
		<div style="margin: 0px" class="col-xs-12 col-md-6 registration">

			<div class="form-adddata wow bounceInUp" data-wow-duration="1s" style="margin-left:80px; margin-top: 20px; margin-bottom: 40px">
				<div class="title-form"><spring:message code="label.form_sign_up"/></div>

				<form:form modelAttribute="user" action="/addUser" method="post">
					<h6 class="placeholders"><spring:message code="label.username"/></h6>
					<span class="exception-message">${usernameException}</span>
					<form:input path="name" cssClass="input-style" />

					<h6 class="placeholders"><spring:message code="label.phone_number"/></h6>
					<span class="exception-message">${phoneNumberException}</span>
					<form:input path="phoneNumber" cssClass="input-style"/>

					<h6 class="placeholders"><spring:message code="label.email"/></h6>
					<span class="exception-message">${emailException}</span>
					<form:input path="email" cssClass="input-style"/>

					<h6 class="placeholders"><spring:message code="label.password"/></h6>
					<span class="exception-message">${passwordException}</span>
					<form:input path="password" cssClass="input-style" type="password"/>
					<br>
					<br>
					<br>
					<button type="submit" class="btn btn-info button-style"><spring:message code="label.sign_up"/></button>
					<br>

				</form:form>

			</div>
		</div>
		<div class="col-xs-12 col-md-6" style="padding-right: 40px">
			<img style="margin-left: 125px; margin-top: -22px" src="http://www.pngmart.com/files/1/Glasses-PNG-Transparent-Image.png" width="315">
			<h1 style="text-align: center; color: orange; margin-top: -10px">
				<spring:message code="label.already_have_account"/>
			</h1>
			<p style="color: #222222; text-align: center; font-size: 15px">
				Тоді ти крутий чувак і бігом за покупками, тому що борода сама себе не підстреже,
				та волосся не вкладеться!
			</p>
			<button class="btn btn-success button-style">
				<a class="sign-up-link" href="/signIn"><spring:message code="label.login"/></a>
			</button>
			<br>
			<br>
			<img style="margin-left: 150px" src="https://s-media-cache-ak0.pinimg.com/originals/12/90/c3/1290c3368d2cbb5fa9fe96635e8ad8c8.jpg" width="270">
		</div>
	</div>
</div>
</div>

	<script src="/js/js.js" type="text/javascript"></script>
	<script src="/js/wow.min.js" type="text/javascript"></script>
	<script>
		new WOW().init();
	</script>


