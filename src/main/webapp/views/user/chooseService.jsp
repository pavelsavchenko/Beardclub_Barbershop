<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 08.07.17
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="bc-ground-site">
    <h1 style="text-align: center; color: orange; margin-bottom: 40px;">
        <spring:message code="label.choose_a_services"/>
    </h1>

<div  style="display: flex; flex-wrap: wrap; padding-left: 85px;width: 100%;height: auto">

    <c:forEach var="service" items="${currentBarber.barberServices}">
        <div class="current-barber-service">
            <img style="margin-top: -8px;margin-left: 45%;" src="https://cdn1.iconfinder.com/data/icons/barbershop-1/154/barbershop-barber-scissors-instrument-hair-style-512.png" width="50">
            <h4 style="color: orange"><spring:message code="label.table_service"/></h4>
            <h1 style="color: #222222">${service.nameOfBarberService}</h1>
            <div class="price-current-service">
           <spring:message code="label.price"/>
           ${service.price}
                <spring:message code="label.uah"/>
            </div>
            <br>
            <br>
            <c:choose>
                <c:when test="${userWithServices.servicesOfBarbers.contains(service)}">
                    <h1 style="color: orange; margin-top: 10px">ALREADY CHOOSEN</h1>
                </c:when>
                <c:otherwise>
                    <button class="btn btn-primary button-style">
                        <a style="color: white" href="/addToOrder/${service.id}">ОБРАТИ СЕРВІС</a>
                    </button>
                </c:otherwise>
            </c:choose>

        </div>
    </c:forEach>
</div>
<button style="padding-top: 0px; border-radius: 20px" class="btn btn-default glyphicon glyphicon-chevron-left">
    <a style="color: #222222; font-size: 15px" href="/orderBarber">ПОВЕРНУТИСЬ ДО ВИБОРУ БАРЕРА</a>
</button>

</div>