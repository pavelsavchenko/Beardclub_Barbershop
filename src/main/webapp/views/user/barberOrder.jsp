<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 08.07.17
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div  class="bc-ground-site">
    <h1 style="text-align: center; color: orange; margin-bottom: 50px">
            <spring:message code="label.choose_barber"/>
    </h1>
    <div style="margin-left: 120px;" class="commodity-content">

        <c:forEach var="c" items="${barbers}">
        <div style="margin-top: -40px; width: 465px;box-shadow: 0 0 1px rgba(0, 0, 0, 0.3);" class="current-commodity">
            <img style="width: 226px; padding-bottom: 0; margin: 0px 25px 14px 0;" class="commodity-image" src="${c.pathImage}" >

            <div style="margin-left: 250px;width: 213px;" class="title-barber">
                <h3 style="color: lightgrey"><spring:message code="label.card_first_name"/></h3>
                    ${c.firstName}
            </div>
            <div  style="padding-top: 0px; margin-left: 250px;width: 213px;" class="title-barber">
                <h3 style="padding-top: 13px; color: lightgrey"><spring:message code="label.card_last_name"/></h3>
                    ${c.lastName}
            </div>
            <div class="description-commodity">
                <h4 style="color: lightgrey; font-weight: 500"><spring:message code="label.job"/></h4>
                <p style="font-size: 20px">${c.position}</p>
            </div>
            <br>
            <button class="btn btn-default"><a href="/chooseBarber/${c.id}">ВИБРАТИ БАРБЕРА</a></button>
        </div>
        </c:forEach>

</div>
