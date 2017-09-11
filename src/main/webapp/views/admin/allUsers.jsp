<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 16.06.17
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<link rel="stylesheet" href="/css/style.css" type="text/css">
<div class="bc-ground-site">
<h1 style="text-align: center; color: orange"><spring:message code="label.list_all_users"/></h1>
<div class="table-responsive">
    <table class="table table-bordered table-striped">
        <thead>
        <tr class="active">
            <th><spring:message code="label.table_login"/></th>
            <th><spring:message code="label.table_phone_number"/></th>
            <th><spring:message code="label.table_email"/></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="user" items="${users.content}">
            <tr>
                <td>${user.name}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.email}<br></td>

                <td><a class="delete glyphicon glyphicon-remove" href="/deleteUser/${user.id}"></a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
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
                        <custom:sort innerHtml="Name asc" paramValue="name"/>
                        <custom:sort innerHtml="Name desc" paramValue="name,desc"/>
                    </ul>
                </div>
            </div>
            <div class="col-md-8 col-xs-12 text-center">
                <custom:pageable page="${users}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
            </div>
            <div class="col-md-2 col-xs-6">
                <custom:size posibleSizes="1,2,4,10" size="${users.size}"/>
            </div>
        </div>
    </div>
</div>

<div  class="glyphicon glyphicon-menu-left back"><a href="/" >BACK</a></div>
</div>