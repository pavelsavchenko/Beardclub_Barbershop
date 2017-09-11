<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 19.06.17
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">



<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/style.css" type="text/css">

<%--<div id="hellopreloader">--%>
    <%--<div id="hellopreloader_preload"></div>--%>
<%--</div>--%>
<div class="bc-ground-site">
<div class="container-fluid">
    <div class="row">

        <div class="col-xs-12 col-sm-12 col-md-12">
            <h1 style="color: orange; text-align: center"><spring:message code="label.shop"/></h1>
            <div class="commodity-shop">

                <c:forEach var="c" items="${commodities.content}">
                    <div class="current-commodity-shop">
                        <img class="commodity-shop-image" src="${c.pathImage}" >

                        <div class="title-commodity-shop">
                                ${c.nameOfCommodity}
                        </div>
                        <div class="description-commodity-shop">
                            <h5 style="color:lightgrey;">Description</h5>
                            <p>${c.desription}</p>
                        </div>
                        <div class="subcategory-commodity-shop">
                            Subcategory: ${c.subcategoty.nameOfSubcategory}
                        </div>
                        <div class="price-commodity-shop">
                            Price: ${c.price} UAH
                        </div>


                                <c:choose>
                                    <c:when test="${userWithCommodities.commodities.contains(c)}">
                                        <h3 style="color: orange; text-align: center; margin-top: -6px">ALREADY IN BASKET</h3>
                                    </c:when>
                                    <c:otherwise>
                                <button class="btn btn-default">
                                <a class="basket" href="/addToBasket/${c.id}">basket</a>
                                </button>
                                    </c:otherwise>
                                </c:choose>

                        <h5 style="text-align: center"><a href="/currentCommodity/${c.id}">детальніше</a></h5>
                    </div>
                </c:forEach>


            </div>

        </div>
    </div>
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
                        <custom:sort innerHtml="Name asc" paramValue="nameOfCommodity"/>
                        <custom:sort innerHtml="Name desc" paramValue="nameOfCommodity,desc"/>
                        <custom:sort innerHtml="Price asc" paramValue="price"/>
                        <custom:sort innerHtml="Price desc" paramValue="price,desc"/>
                    </ul>
                </div>
            </div>
            <div class="col-md-8 col-xs-12 text-center">
                <custom:pageable page="${commodities}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
            </div>
            <div class="col-md-2 col-xs-6">
                <custom:size posibleSizes="3,6,10" size="${commodities.size}"/>
            </div>
        </div>
    </div>
</div>
</div>

<div  class="glyphicon glyphicon-menu-left back"><a href="/" >BACK</a></div>
<script type="text/javascript" src="/js/js.js"></script>



