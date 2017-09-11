<%--
  Created by IntelliJ IDEA.
  User: pavelsavchenko
  Date: 17.06.17
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/animate.css" type="text/css">

<%--<div id="hellopreloader">--%>
    <%--<div id="hellopreloader_preload"></div>--%>
<%--</div>--%>
<div  class="bc-ground-site">
<div class="container-fluid form-contacts">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <h1 class="title-contact-form wow fadeInDown"><spring:message code="label.schedule"/></h1>
            <ul class="time-work">
                <li><h4 style="display: inline-block;padding-right: 230px; margin-left: -40px;" class="wow fadeInLeftBig"data-wow-delay ="0.5s"><spring:message code="label.monday-friday"/></h4><h2 style="display: inline-block" class="wow fadeInRightBig" data-wow-delay ="0.5s">10:00 - 21:00</h2></li>
                <li style="margin-top: 4px;"><h4 class="wow fadeInLeftBig" data-wow-delay="0.7s" style="display: inline-block;padding-right: 291px;margin-left: -38px;"><spring:message code="label.saturday"/></h4><h2 style="display: inline-block" class="wow fadeInRightBig"data-wow-delay ="0.7s">10:00 - 19:00</h2></li>
                <li style="margin-top: 4px"><h4 class="wow fadeInLeftBig" data-wow-delay="0.85s" style="display: inline-block;  padding-right: 311px; margin-left: -36px;"><spring:message code="label.sunday"/></h4><h2 style="display: inline-block" class="wow fadeInRightBig"data-wow-delay ="0.85s">10:00 - 19:00</h2></li>
            </ul>

            <h1 class="title-contact-form wow fadeInDown"data-wow-offset="200"><spring:message code="label.for_all_question"/></h1>
           <ul class="contacts-question">
               <li class="wow lightSpeedIn"data-wow-offset="200"><img class="icon" src="https://www.dealme.gr/wp-content/uploads/2014/04/dentist-rochester-ny-contemporary-dentistry-rochester-ny-24.png" width="50">(067) 720 49 12</li>
               <li class="wow zoomIn"data-wow-offset="200"><img class="icon" src="http://www.freeiconspng.com/uploads/gmail-logo-icon-7.png" width="50">pavelllsavchenko@gmail.com</li>
               <li class="wow bounceInUp"data-wow-offset="150"><img class="icon" src="https://seeklogo.com/images/T/telegram-logo-52EACC2D94-seeklogo.com.png" width="50">@pavelllsavchenko</li>
           </ul>

            <h1 class="title-contact-form wow fadeInDown"data-wow-offset="300"><spring:message code="label.our_locate"/></h1>

            <ul style="border: 0; padding-bottom: 50px" class="contacts-question">
                <li  class="wow flipInY"data-wow-offset="300">
                    <img class="wow flipInY"data-wow-offset="350" class="location" style="margin-top: -17px;" src="http://www.reklet.nl/wp-content/uploads/2014/10/pin-locatie.png" width="35px">
                    <a href="https://www.google.com.ua/maps/place/%D0%B2%D1%83%D0%BB%D0%B8%D1%86%D1%8F+%D0%86%D0%B2%D0%B0%D0%BD%D0%B0+%D0%A4%D1%80%D0%B0%D0%BD%D0%BA%D0%B0,+61,+%D0%9B%D1%8C%D0%B2%D1%96%D0%B2,+%D0%9B%D1%8C%D0%B2%D1%96%D0%B2%D1%81%D1%8C%D0%BA%D0%B0+%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C/@49.8311394,24.0310179,17z/data=!3m1!4b1!4m5!3m4!1s0x473add67a087981b:0x82084e3774e8423c!8m2!3d49.831136!4d24.0332066"><spring:message code="label.street"/></a>
                </li>
            </ul>

            <a class="wow fadeInUp"data-wow-offset="400" href="https://www.google.com.ua/maps/place/%D0%B2%D1%83%D0%BB%D0%B8%D1%86%D1%8F+%D0%86%D0%B2%D0%B0%D0%BD%D0%B0+%D0%A4%D1%80%D0%B0%D0%BD%D0%BA%D0%B0,+61,+%D0%9B%D1%8C%D0%B2%D1%96%D0%B2,+%D0%9B%D1%8C%D0%B2%D1%96%D0%B2%D1%81%D1%8C%D0%BA%D0%B0+%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C/@49.8311394,24.0310179,17z/data=!3m1!4b1!4m5!3m4!1s0x473add67a087981b:0x82084e3774e8423c!8m2!3d49.831136!4d24.0332066">
                <img style="padding-top: 15px; padding-bottom: 30px" src="http://chornobyl.in.ua/wp-content/uploads/radiacionniy-fon-lvov.jpg" width="650px" height="400px">
            </a>
        </div>
    </div>
</div>
</div>
<script src="/js/js.js" type="text/javascript"></script>
<script src="/js/wow.min.js" type="text/javascript"></script>
<script>
    new WOW().init();
</script>
