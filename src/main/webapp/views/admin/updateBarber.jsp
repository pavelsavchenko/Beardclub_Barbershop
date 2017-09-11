<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 31.05.17
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/animate.css" type="text/css">
<link rel="stylesheet" href="/css/style.css" type="text/css">

<div class="bc-ground-site">
    <div class="form-adddata  wow bounceInUp" data-wow-duration="1s">
        <div class="title-form">UPDATE BARBER</div>
        <form:form  action="/updateBarber/${updateBarber.id}?${_csrf.parameterName}=${_csrf.token}" modelAttribute="updateBarber" method="post" enctype="multipart/form-data">
            <h6 class="placeholders"><spring:message code="label.add_image_commodity"/></h6>
            <input name="image" type="file"/>
            <br>
        <input name="firstName" value="${updateBarber.firstName}" class="input-style" ></input>
        <br>
        <br>
        <input name="lastName" value="${updateBarber.lastName}" class="input-style" ></input>
        <br>
        <br>
        <input name="position" value="${updateBarber.position}" class="input-style" ></input>
        <br>

        <h3>Services</h3>

        <c:forEach items="${updateBarber.barberServices}" var="services">
            <span class="barber-service-font-size">${services.nameOfBarberService}</span><a class="delete" href="/updateBarber/${updateBarber.id}/${services.id}">delete</a>
        </c:forEach>
        <br>
        <br>
            <br>
        <button type="submit" class="btn btn-success button-style">UPDATE BARBER</button>
    </form:form>

    </div>
</div>
<div class="glyphicon glyphicon-menu-left back"><a style="color: #2222" href="/barber" >BACK</a></div>
</div>
</div>
<script src="/js/wow.min.js" type="text/javascript"></script>
<script>
    new WOW().init();
</script>

