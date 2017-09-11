<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 17.06.17
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/css/animate.css" type="text/css">
    <title>SING IN</title>
<%--<div id="hellopreloader">--%>
    <%--<div id="hellopreloader_preload"></div>--%>
<%--</div>--%>
<div class="bc-ground-site">
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12 col-md-6">
            <span style="text-align: center; font-size: 20px" class="exception-message">${userLoginException}</span>
            <sec:authorize access="!isAuthenticated()">
                <div class="form-login wow bounceInUp" data-wow-duration="1s">

                    <form:form action="/login" method="post">
                        <h2 class="login-title"><spring:message code="label.form_sign_in"/></h2>
                        <br>

                        <h6 class="placeholders"><spring:message code="label.username"/></h6>
                        <input name="username" class="input-style"/>
                        <br>
                        <h6 class="placeholders"><spring:message  code="label.password"/></h6>
                        <input name="password" type="password" class="input-style"/>
                        <br>
                        <br>
                        <br>
                        <button type="submit" class="btn btn-success login-button-style"><spring:message code="label.sign_in"/></button>
                        <br>

                    </form:form>

                </div>
            </sec:authorize>
        </div>
        <div class="col-xs-12 col-md-6">
            <h1 style="text-align: center; color: orange"><spring:message code="label.haven't_account"/></h1>
            <p style="color: #d50000; text-align: center; font-size: 15px">Для отримання повного функціоналу сайта треба бути авторизованним</p>
            <p style="font-size: 15px; text-align: center; color: #222222">Пройдіть нескладну реєстрацію, та вам стане доступний</p>
            <ul style="color: #222222;margin-left: 47px;margin-right: 20px;">
                <li>ОНЛАЙН-МАГАЗИН - де ти можешь замовити все для догляду за своєю бородою та волоссям;</li>
                <li>ОНЛАЙН ЗАПИС ДО БАРБЕРА - довір своє волосся найкращим барберам міста;</li>
                <li>ДОСТУП ДО ОСОБИСТОГО ПРОФІЛЯ - слідкую за своїми діями і замовленнями.</li>
            </ul>
            <br>
            <br>
            <button class="btn btn-primary login-button-style"><a class="sign-up-link" href="/registration"><spring:message code="label.sign_up"/></a></button>
        </div>
    </div>
</div>
</div>
<script type="text/javascript" src="/js/js.js"></script>
<script src="/js/wow.min.js" type="text/javascript"></script>
<script>
    new WOW().init();
</script>

