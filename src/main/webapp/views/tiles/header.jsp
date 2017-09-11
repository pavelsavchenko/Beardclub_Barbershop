<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 15.06.17
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<link href="https://fonts.googleapis.com/css?family=Grand+Hotel" rel="stylesheet">


<link rel="stylesheet" href="/css/style.css" type="text/css">
<link rel="stylesheet" href="/css/animate.css" type="text/css">


<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/normalize/2.0.1/normalize.css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Grand+Hotel" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Sigmar+One" rel="stylesheet">

<div class="header">
    <div class="top-header">
        <nav class="navbar navbar-inverse animated fadeInRightBig">
            <div class="container-fluid">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#first-header" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>


                <div class="collapse navbar-collapse" id="first-header">
                    <ul class="nav navbar-nav">
                        <li style="color: orange; margin-top: 14px"><sec:authentication property="name"/> | </li>


                        <li><a href="/"><spring:message code="label.home"/></a></li>
                        <sec:authorize access="!isAuthenticated()">
                            <li><a href="/signIn"><spring:message code="label.sign_in"/> </a></li>
                        </sec:authorize>
                        <sec:authorize access="!hasRole('ROLE_ADMIN')">
                        <sec:authorize access="isAuthenticated()">
                        <li><a href="/profileUser"><spring:message code="label.profile"/></a></li>
                        </sec:authorize>
                            <li><a href="/contacts"><spring:message code="label.contacts"/></a> </li>
                            <li><a href="/shipping_and_payment"><spring:message code="label.ship_pay"/></a> </li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <li ><a href="/barber"><spring:message code="label.barbers"/></a></li>
                            <li><a href="/allUsers"><spring:message code="label.users"/></a></li>
                            <li ><a href="/service_barber"><spring:message code="label.barber_services"/></a></li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <sec:authorize access="isAuthenticated()">
                        <li style="color: orange; margin-top: 10px" class="glyphicon glyphicon-shopping-cart"><a style="margin-top: -31px; margin-left: 10px; font-size: 15px" href="/basket"><spring:message code="label.basket"/></a></li>
                            </sec:authorize>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <li>
                                <form:form action="/logout" method="post">
                                    <button  class="btn btn-info button-logout"><spring:message code="label.logout"/></button>
                                </form:form>
                            </li>
                        </sec:authorize>
                        <li><a href="?lang=ua">ua</a></li>
                        <li><a href="?lang=ru">ru</a></li>
                        <li><a href="?lang=en">en</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-md-8 left-header">
                <div class="title-site animated zoomIn">Beard club</div>
                <div class="barbershop animated zoomIn">Barbershop</div>

            </div>
            <div class="col-xs-12 col-md-4 right-header">
                <img  src="http://loyaltybarber.com/files/resized/55313/500;429;1c4b5a01845c86ee56b0a3aeeb79f2a95c310ab9.png" width="80%">
            </div>

        </div>
    </div>
    <nav class="navbar navbar-default animated fadeInLeftBig">
        <div class="container-fluid">

            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <li><a href="/shop"><spring:message  code="label.shop"/></a></li>
                        <li><a href="/orderBarber"><spring:message  code="label.entry_barber"/></a></li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li><a href="/category_of_commodity"><spring:message code="label.category_of_commodity"/></a></li>

                        <li ><a href="/subcategory_of_commodity"><spring:message code="label.subcategory_of_commodity"/></a></li>

                        <li ><a href="/commodity"><spring:message code="label.commodity"/></a></li>
                    </sec:authorize>

                </ul>

            </div>
        </div>
    </nav>
</div>
<script src="/js/wow.min.js" type="text/javascript"></script>
<script>
    new WOW().init();
</script>
