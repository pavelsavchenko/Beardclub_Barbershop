<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 07.07.17
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="bc-ground-site">
    <div class="form-adddata wow bounceInUp" data-wow-duration="1s">


    <form:form modelAttribute="commodity" action="/updateCommodity/${currentCommodity.id}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
    <div class="title-form">UPDATE COMMODITY</div>
    <br>
    <h6 class="placeholders"><spring:message code="label.choose_subcategory"/></h6>
    <select name="subcategoryId" class="select-style">
        <option value="${currentCommodity.subcategoty.id}">${currentCommodity.subcategoty.nameOfSubcategory}</option>
        <c:forEach var="subcategory" items="${subcategories}">
            <option value="${subcategory.id}">${subcategory.nameOfSubcategory}</option>
        </c:forEach>
    </select>
    <br>
    <br>
    <h6 class="placeholders"><spring:message code="label.add_image_commodity"/></h6>
        <input name="image" type="file"/>
    <br>
    <h6 class="placeholders"><spring:message code="label.name_commodity"/></h6>
    <span class="exception-message">${commodityNameException}</span>
    <input name="nameOfCommodity" class="input-style" value="${currentCommodity.nameOfCommodity}"/>

    <h6 class="placeholders"><spring:message code="label.price_of_commodity"/></h6>
    <span class="exception-message">${priceException}</span>
    <input name="price" class="input-style" value="${currentCommodity.price}"/>


    <br>
    <br>

    <button type="submit" class="btn btn-success button-style">UPDATE COMMODITY</button>
    </form:form>

    </div>
</div>
<div class="glyphicon glyphicon-menu-left back"><a style="color: #2222" href="/commodity" >BACK</a></div>
</div>
</div>
