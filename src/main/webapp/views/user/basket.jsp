<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 23.06.17
  Time: 10:58
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
<div class="form-basket">
<c:if test="${userBasket.commodities.size()==0}">

    <h2 style="text-align: center; color:orange;"><spring:message code="label.basket_is_empty"/></h2>

</c:if>
<c:if test="${userBasket.commodities.size()!=0}">
    <h2 style="text-align: center;color: orange"><spring:message code="label.basket"/></h2>
    <div>
        <c:forEach var="com" items="${userBasket.commodities}">

            <div class="current-basket-commodity">
                <img class="commodity-basket-image" src="${com.pathImage}" >

                <div class="title-commodity-basket">
                        ${com.nameOfCommodity}
                </div>
                <div class="subcategory-basket-shop">
                    Subcategory: ${com.subcategoty.nameOfSubcategory}
                </div>
                <div class="price-basket-shop">
                    Price: ${com.price} UAH
                </div>
                <button style="margin-right: 10px;float: right;margin-top: 14px;" class="btn btn-default"><a class="delete glyphicon glyphicon-remove" href="/deleteFromBasket/${userBasket.id}/${com.id}"></a></button>
            </div>
        </c:forEach>
    </div>
    <form:form action="/buy/${userBasket.id}" method="post">
        <button style="font-size: 20px;width: 100%" class="btn btn-info"><spring:message code="label.buy"/></button>
    </form:form>

</c:if>
</div>
</div>
