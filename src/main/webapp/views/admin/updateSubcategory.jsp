<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 05.07.17
  Time: 17:36
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
    <div class="title-form">UPDATE SUBCATEGORY</div>

    <form:form modelAttribute="subcategory" action="/updateSubcategory/${currentSubcategory.id}" method="post">
        <select name="categoryId" class="select-style">
            <option value="${currentSubcategory.categoryOfCommodity.id}">${currentSubcategory.categoryOfCommodity.nameOfCategory}</option>
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.nameOfCategory}</option>
            </c:forEach>
        </select>
        <h6 class="placeholders">SUBCATEGORY NAME</h6>
        <span class="exception-message">${subcategoryNameException}</span>
        <input name="nameOfSubcategory" class="input-style" value="${currentSubcategory.nameOfSubcategory}"/>

        <br>
        <br>

        <button type="submit" class="btn btn-info button-style">UPDATE SUBCATEGORY</button>

    </form:form>

</div>
    <div class="glyphicon glyphicon-menu-left back"><a style="color: #2222" href="/subcategory_of_commodity" >BACK</a></div>
</div>


<script type="text/javascript" src="/js/js.js"></script>
<script src="/js/wow.min.js" type="text/javascript"></script>
<script>
    new WOW().init();
</script>