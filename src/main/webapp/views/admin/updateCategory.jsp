<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 06.06.17
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="/css/animate.css" type="text/css">
<link rel="stylesheet" href="/css/style.css.css" type="text/css">
<div class="bc-ground-site">
    <%--<div id="hellopreloader">--%>
        <%--<div id="hellopreloader_preload"></div>--%>
    <%--</div>--%>

        <div  class="form-adddata  wow bounceInUp" data-wow-duration="1s">

            <form:form modelAttribute="category" action="/updateCategory/${currentCategoryOfCommodity.id}" method="post">
                <div class="title-form">UPDATE CATEGORY OF COMMODITY</div>
                <h6 class="placeholders"><spring:message code="label.name_category_of_commodity"/></h6>
                <span class="exception-message">${categoryException}</span>
            <input name="nameOfCategory" class="input-style" value="${currentCategoryOfCommodity.nameOfCategory}"/>
            <br>
            <br>
            <button  type="submit" class="btn btn-success button-style">UPDATE CATEGORY</button>

        </form:form>
        </div>
        <div class="glyphicon glyphicon-menu-left back"><a style="color: #2222" href="/category_of_commodity" >BACK</a></div>
        </div>



    <script type="text/javascript" src="/js/js.js"></script>

<script src="/js/wow.min.js" type="text/javascript"></script>
<script>
    new WOW().init();
</script>
