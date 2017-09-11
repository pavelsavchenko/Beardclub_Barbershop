<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 14.06.17
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<div  class="bc-ground-site">
<div class="container-fluid">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">

            <div class="form-basket">


               <h2 style="color: orange; text-align: center;margin-bottom: 40px"><spring:message code="label.profile"/></h2></span>

                 <h5 style="color: orange"><spring:message code="label.table_login"/></h5>
                        <h3 style="padding-bottom: 8px; color: #222222">${userProfile.name}</h3>
                        <h5 style="color: orange"><spring:message code="label.table_phone_number"/></h5>
                        <h3 style="color: #222222"">${userProfile.phoneNumber}</h3>
                        <h5 style="color: orange"><spring:message code="label.email"/></h5>
                        <h3 style="color: #222222"">${userProfile.email}</h3>
                <button class="btn btn-info"><a style="color: white" href="/updateUsers/${userProfile.id}"><spring:message code="label.update_profile"/></a></button>

                        <c:if test="${userProfile.commodities.size()==0}">

                        </c:if>
                        <c:if test="${userProfile.commodities.size()!=0}">

                            <h2 style="color: orange; text-align: center;margin-bottom: 40px; margin-top: 45px"><spring:message code="label.viewed_commodities"/></h2>
                            <div class="commodity-shop">
                                <c:forEach var="com" items="${userProfile.commodities}">

                                    <div class="current-commodity-shop">
                                        <img class="commodity-shop-image" src="${com.pathImage}" >

                                        <div class="title-commodity-shop">
                                                ${com.nameOfCommodity}
                                        </div>
                                        <div class="description-commodity-shop">
                                            <h5 style="color:lightgrey;">Description</h5>
                                            <p>${com.desription}</p>
                                        </div>
                                        <div class="subcategory-commodity-shop">
                                            <spring:message code="label.subcategory"/> ${com.subcategoty.nameOfSubcategory}
                                        </div>
                                        <div class="price-commodity-shop">
                                            <spring:message code="label.price"/> ${com.price} <spring:message code="label.uah"/>
                                        </div>

                                    </div>

                                </c:forEach>
                            </div>

                        </c:if>
                <c:if test="${userHistoryOrders.ordersShops.size()==0}">

                </c:if>
                <c:if test="${userHistoryOrders.ordersShops.size()!=0}">
                    <h2 style="color: orange; text-align: center;margin-bottom: 35px; margin-top: 45px"><spring:message code="label.history_orders"/></h2>
                    <div class="commodity-history">

                        <c:forEach var="order" items="${userHistoryOrders.ordersShops}">
                            <div style=" color:#222222; display: inline-block; width: 100%; height: 50px; font-size: 20px; margin-bottom: 20px">
                                    ${order.dateTime.getDayOfWeek()},
                                        ${order.dateTime.getDayOfMonth()}
                                        ${order.dateTime.getMonth()}
                                        ${order.dateTime.getYear()}
                                    ${order.dateTime.getHour()} :
                                    ${order.dateTime.getMinute()}
                                        <h3 style="display: inline-block; float:right; margin-top: 1px"><spring:message code="label.total_price"/> <span style="color: orange">${order.resultPrice} <spring:message code="label.uah"/></span></h3>

                            </div>


                            <div class="current-commodity-history">

                                <c:forEach items="${order.commodities}" var="commodity">
                                <img class="commodity-history-image" src="${commodity.pathImage}" >

                                <div class="title-commodity-history">
                                        ${commodity.nameOfCommodity}
                                </div>
                                <div class="subcategory-commodity-history">
                                    <spring:message code="label.subcategory"/> ${commodity.subcategoty.nameOfSubcategory}
                                </div>
                                <div class="price-commodity-history">
                                    <spring:message code="label.price"/> ${commodity.price} <spring:message code="label.uah"/>
                                </div>

                                </c:forEach>
                            </div>
                        </c:forEach>


                    </div>
                </c:if>
                <c:if test="${userHistoryBarberOrders.barberOrders.size()==0}">

                </c:if>
                <c:if test="${userHistoryBarberOrders.barberOrders.size()!=0}">
                    <h2 style="color: orange; text-align: center;margin-bottom: 35px; margin-top: 45px">ЗАПИСИ ДО БАРБЕРА</h2>

                    <c:forEach var="barberOrder" items="${userHistoryBarberOrders.barberOrders}">
                <div style=" color:#222222; display: inline-block; width: 100%; height: 50px; font-size: 20px; margin-bottom: 20px">
                        ${barberOrder.dateTime.getDayOfWeek()},
                        ${barberOrder.dateTime.getDayOfMonth()}
                        ${barberOrder.dateTime.getMonth()}
                        ${barberOrder.dateTime.getYear()}
                        ${barberOrder.dateTime.getHour()} :
                        ${barberOrder.dateTime.getMinute()}

                            <h4 style="display: inline-block; float:right; margin-top: 1px">
                                Ви записани до барбера на
                                <span style="color: orange"> ${barberOrder.dateOrder.getDayOfWeek()},</span>
                                <span style="color: orange">${barberOrder.dateOrder.getDayOfMonth()}</span>
                                <span style="color: orange">${barberOrder.dateOrder.getMonth()}</span>
                                <span style="color: orange">${barberOrder.dateOrder.getYear()}</span>
                            </h4>
                </div>

                        <c:forEach var="service" items="${barberOrder.barberService}">
                            <div style="margin-left: 0px;" class="current-barber-service">

                                        <img style="margin-top: -8px;margin-left: 45%;" src="https://cdn1.iconfinder.com/data/icons/barbershop-1/154/barbershop-barber-scissors-instrument-hair-style-512.png" width="50">
                                        <h4 style="color: orange"><spring:message code="label.table_service"/></h4>
                                        <h1 style="color: #222222">${service.nameOfBarberService}</h1>
                                        <div class="price-current-service">
                                            <spring:message code="label.price"/>
                                                ${service.price}
                                            <spring:message code="label.uah"/>
                                        </div>
                                        <br>
                            </div>
                        </c:forEach>




                    </c:forEach>
                </c:if>

            </div>
        </div>
    </div>
</div>
</div>

<script src="/js/js.js"></script>


