<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 25.06.17
  Time: 19:19
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
<div  class="form-adddata  wow bounceInUp" data-wow-duration="1s" style="margin-left:33%; margin-top: 20px; margin-bottom: 40px">
    <div class="title-form">UPDATE PROFILE</div>

    <form:form modelAttribute="user" action="/updateUsers/${currentUser.id}" method="post">
        <h6 class="placeholders"><spring:message code="label.username"/></h6>
        <span class="exception-message">${userException}</span>
        <input name="name" class="input-style" value="${currentUser.name}"/>

        <h6 class="placeholders"><spring:message code="label.phone_number"/></h6>
        <span class="exception-message">${phoneException}</span>
        <input name="phoneNumber" class="input-style" value="${currentUser.phoneNumber}"/>

        <br>
        <br>
        <button type="submit" class="btn btn-info button-style">UPDATE PROFILE</button>

    </form:form>

</div>
    <div class="glyphicon glyphicon-menu-left back"><a style="color: #2222" href="/profileUser" >BACK</a></div>
</div>

<script type="text/javascript" src="/js/js.js"></script>
<script src="/js/wow.min.js" type="text/javascript"></script>
<script>
    new WOW().init();
</script>