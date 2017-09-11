<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 17.06.17
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/animate.css" type="text/css">

    <title>SHIPPING AND PAYMENT</title>
<%--<div id="hellopreloader">--%>
    <%--<div id="hellopreloader_preload"></div>--%>
<%--</div>--%>
<div class="bc-ground-site">
<div class="container-fluid form-contacts">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <h1 class="title-contact-form wow fadeInDown"><spring:message code="label.delivery"/></h1>
            <img class="wow bounceInLeft" data-wow-delay ="0.5s" style="margin: -5px 20px 15px 20px; float: left;" src="http://stuff-shop.com.opt-images.1c-bitrix-cdn.ru/upload/medialibrary/e35/e355d1b818c88a11a502bd3cecc3aa91.png?148732942238954" width="180">
            <h4 style="font-weight: 800; display:inline-block;" class="wow fadeInRightBig"><spring:message code="label.delivery_service_Nova_Poshta"/></h4>
            <ul class="wow slideInUp" data-wow-offset="120">
                <li class="shipping"><spring:message code="label.delivery_time"/></li>
                <li class="shipping"><spring:message code="label.declaration_number"/></li>
                <li class="shipping"><spring:message code="label.delivery_only_ukraine"/></li>
                <li class="shipping"><spring:message code="label.order_is_canceled"/></li>
            </ul>
            <p style="text-align: center; font-size: 25px;" class="wow zoomIn" data-wow-offset="100"><spring:message code="label.delivery_free"/><span style="color: red"><spring:message code="label.free"/></span></p>
            <h1 style="margin-top: 50px" class="title-contact-form wow fadeInDown" data-wow-offset="150"><spring:message code="label.self-lifting"/></h1>
            <img class="wow bounceInRight" data-wow-offset="150" style="float: right;margin: 0 20px 15px 20px" src="http://stuff-shop.com.opt-images.1c-bitrix-cdn.ru/upload/medialibrary/fab/fab11a21814ae14357a5d932ba24a328.png?148732946043543" width="180">

                <p class="self-lifting wow fadeInUpBig" data-wow-offset="150"><spring:message code="label.pick-up_order"/></p>
                <p class="self-lifting wow fadeInUpBig" data-wow-offset="150"><spring:message code="label.self-lifting_adress"/></p>

            <div style="width: 665px;border: 1px solid white; margin-top: 103px;margin-left: 12%;"></div>
            <h1 class="title-contact-form wow fadeInDown" data-wow-offset="150"><spring:message code="label.payment"/></h1>
            <h4 style="margin-left: -400px;margin-bottom: 30px;" class="wow fadeInLeftBig" data-wow-offset="150"><spring:message code="label.payment_on_receipt"/></h4>
            <img style="float: left; margin: 0px 20px 15px 20px" class="wow bounceInLeft" data-wow-offset="200" src="http://stuff-shop.com.opt-images.1c-bitrix-cdn.ru/upload/medialibrary/0ee/0ee6c62b5f4313d9f39bb1258336bd7c.png?148732944544012" width="180">

                <p style="font-size: 20px" class="shipping wow fadeIn" data-wow-offset="200"><spring:message code="label.cash_nova_poshta"/></p>
                <p class="shipping wow fadeIn" data-wow-offset="200"><spring:message code="label.nova_poshta_ttn"/></p>

            <h4 style="margin-left: -400px;margin-bottom: 30px; margin-top: 100px" class="wow fadeInLeftBig" data-wow-offset="150"><spring:message code="label.prepayment"/></h4>
            <img style="float: left; margin: 0px 20px 15px 20px" class="wow bounceInLeft" data-wow-offset="200" src="http://stuff-shop.com.opt-images.1c-bitrix-cdn.ru/upload/medialibrary/8f3/8f37640a91e21e876d1eea495dd48ec8.png?148732943431827" width="180">
            <p style="font-size: 20px" class="shipping wow fadeIn" data-wow-offset="200"><spring:message code="label.receipt_bank"/></p>
            <p style="margin-bottom: 20px" class="shipping wow fadeIn" data-wow-offset="200"><spring:message code="label.prepayment_electronic_form"/></p>

            <img style="float: left; margin: 40px 20px 15px -198px" class="wow bounceInLeft" data-wow-offset="200" src="http://stuff-shop.com.opt-images.1c-bitrix-cdn.ru/upload/medialibrary/faa/faa6340a96c4c24c72fba8bdf0ec243f.png?148732947428618" width="180">
            <p style="font-size: 20px; margin-top: 55px" class="shipping wow fadeIn" data-wow-offset="200"><spring:message code="label.payment_terminal"/></p>
            <p class="shipping wow fadeIn" data-wow-offset="200"><spring:message code="label.print-terminal"/></p>
            
            <img style="float: left; margin: 40px 20px 30px -198px" class="wow bounceInLeft" data-wow-offset="200" src="http://stuff-shop.com.opt-images.1c-bitrix-cdn.ru/upload/medialibrary/8c6/8c68c1eb3e4f7cc57f37b1b6d5dd79bc.png?148732941030432" width="180">
            <p style="font-size: 20px; margin-top: 55px" class="shipping wow fadeIn" data-wow-offset="200"><spring:message code="label.privat24"/></p>
            <p class="shipping wow fadeIn" data-wow-offset="200"><spring:message code="label.payment_in_privat24"/></p>
        </div>
    </div>
</div>
</div>
<script src="/js/js.js" type="text/javascript"></script>
<script src="/js/wow.min.js" type="text/javascript"></script>
<script>
    new WOW().init();
</script>
