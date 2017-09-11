<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 25.06.17
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/css/animate.css" type="text/css">
<link rel="stylesheet" href="/css/style.css" type="text/css">
<%--<div id="hellopreloader">--%>
    <%--<div id="hellopreloader_preload"></div>--%>
<%--</div>--%>

<div class="bc-ground-site">
<div  class="form-adddata  wow bounceInUp" data-wow-duration="1s">

    <form:form modelAttribute="service" action="/updateServices/${currentService.id}" method="post">
        <div class="title-form">UPDATE SERVICE</div>
        <h6 class="placeholders"><spring:message code="label.name_of_service"/></h6>
        <span class="exception-message">${serviceException}</span>
        <input name="nameOfBarberService" class="input-style" value="${currentService.nameOfBarberService}"/>

        <h6 class="placeholders"><spring:message code="label.price_of_service"/></h6>
        <span class="exception-message">${priceServiceException}</span>
        <input name="price" class="input-style" value="${currentService.price}"/>
        <br>
        <br>
        <button type="submit" class="btn btn-success button-style">UPDATE SERVICE</button>
    </form:form>

</div>
    <div class="glyphicon glyphicon-menu-left back"><a style="color: #2222" href="/service_barber" >BACK</a></div>
</div>
<script type="text/javascript" src="/js/js.js"></script>
<script src="/js/wow.min.js" type="text/javascript"></script>
<script>
    new WOW().init();
</script>