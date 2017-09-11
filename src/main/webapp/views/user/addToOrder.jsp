<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 08.07.17
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/style.css" type="text/css">
<link rel="stylesheet" href="/css/datepicker.css" type="text/css">

<div class="bc-ground-site">
    <table>
        <thead style="color: orange">
            <tr>
                <th><spring:message code="label.table_login"/></th>
                <th><spring:message code="label.phone_number"/></th>
                <th><spring:message code="label.email"/></th>
            </tr>
        </thead>
        <tbody style="font-size: 25px">
            <tr>
                <td style="background: transparent; height: 55px">${userWithServices.name}</td>
                <td style="background: transparent;">${userWithServices.phoneNumber}</td>
                <td style="background: transparent;">${userWithServices.email}</td>
            </tr>

        </tbody>
    </table>
    <div class="row">
        <div class="col-xs-12 col-md-6">
            <h2 style="color: orange; margin-left: 103px">ОБРАНИЙ БАРБЕР</h2>
            <c:forEach var="barber" items="${userWithServices.servicesOfBarbers}">
                <c:forEach var="currentBarber" items="${barber.barbers}">
                    <div style=" margin-left: 105px; width: 520px;box-shadow: 0 0 1px rgba(0, 0, 0, 0.3);" class="current-commodity">
                        <img style="width: 177px; padding-bottom: 0; margin: 0px 25px 14px 0;" class="commodity-image" src="/${currentBarber.pathImage}" >

                        <div style=" margin-left: 203px;width: 156px;" class="title-barber">
                            <h3 style="color: lightgrey"><spring:message code="label.card_first_name"/></h3>
                                ${currentBarber.firstName}
                        </div>
                        <div  style="padding-top: 0px;margin-left: 203px; width: 156px;" class="title-barber">
                            <h3 style="padding-top: 13px; color: lightgrey"><spring:message code="label.card_last_name"/></h3>
                                ${currentBarber.lastName}
                        </div>
                        <div class="description-commodity">
                            <h4 style="color: lightgrey; font-weight: 500"><spring:message code="label.job"/></h4>
                            <p style="font-size: 20px">${currentBarber.position}</p>
                        </div>
                    </div>
                </c:forEach>
            </c:forEach>
        </div>

    </div>





    <div  style="display: flex; flex-wrap: wrap; padding-left: 85px;width: 100%;height: auto">

    <c:forEach var="service" items="${userWithServices.servicesOfBarbers}">
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
            <button class="btn btn-danger button-style">
                <a style="color: white" href="/deleteFromBarberOrder/${userWithServices.id}/${service.id}">ВИДАЛИТИ СЕРВІС</a>
            </button>
        </div>
    </c:forEach>


    </div>

    <br>
    <br>


    <form:form action="/entryToBarber/${userWithServices.id}" method="post">
        <div class="col-xs-12 col-md-6">
            <div style="width: 70%; margin-left: 104px; margin-top: 22px; margin-bottom: 20px">
                <h2 style="color: orange; margin-top: -4px">ОБЕРІТЬ ДАТУ</h2>
                <input style="color: #222222" class="input-style" type="date" name="data" required = required>
            </div>
        </div>
        <button class="btn btn-primary button-style"><spring:message code="label.entry_barber"/></button>
    </form:form>
    <br>
    <br>
    <button style="padding-top: 0px; border-radius: 20px" class="btn btn-default glyphicon glyphicon-chevron-left">
        <a style="color: #222222; font-size: 15px" href="/orderBarber">ВИБРАТИ ЩЕ СЕРВІСИ БАРЕРІВ</a>
    </button>
</div>

</div>
<script src="/js/bootstrap-datepicker.js"></script>
<%--<script type="text/javascript">--%>
    <%--$(document).ready(function(){--%>
        <%--$("#datepicker").datepicker();--%>
    <%--});--%>
<%--</script>--%>
<script>
    $(function () {
        $('.datepicker').datepicker();
    });
</script>