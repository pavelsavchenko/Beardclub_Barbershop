<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 07.07.17
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>   

<div style="padding-left: 50px; margin-top: -40px" class="bc-ground-site">
    <div style="width: 100%; height: 500px">
<img class="currentCommodity-image" src="/${currentCommodity.pathImage}"> 
<div class="title-currentCommodity">${currentCommodity.nameOfCommodity}</div> 
<div class="description-currentCommodity"> 
    <h3 style="color:white; margin: 0px">Description</h3> 
    <p style="margin-right: 100px">${currentCommodity.desription}</p> 
     </div>
    <div class="subcategory-currentCommodity"> 
        Subcategory: ${currentCommodity.subcategoty.nameOfSubcategory} 
    </div> 
    <div class="price-currentCommodity"> 
        Price: ${currentCommodity.price} UAH 
    </div> 
        <c:choose>
            <c:when test="${userWithCommodities.commodities.contains(currentCommodity)}">
                <h1 style="color: orange; margin-top: 10px">ALREADY IN BASKET</h1>
            </c:when>
            <c:otherwise>
                <button style="margin-bottom: 20px; margin-left: 20px;" class="btn btn-default">
                    <a class="basket" href="/addToBasket/${currentCommodity.id}">basket</a>
                </button>
            </c:otherwise>
        </c:choose>
    <%--<button style="margin-bottom: 20px; margin-left: 20px;" class="btn btn-default"><a class="basket" href="/addToBasket/${currentCommodity.id}">basket</a></button>--%>
    </div>
</div>