<#import "login.ftl" as l>
<#include "security.ftl">


<#macro page>
    <!DOCTYPE html>
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>RateTheCup</title>
        <link rel="stylesheet" href="/css/styles.css">
        <link rel="icon" type="image/ico" href="/images/logo2.jpg">

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
              crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

    </head>
    <body>
    <div class="container" id="mainContainer">
        <div class="header">
            <a>
                <img src="/images/logo2.jpg" width="80" height="80" class="d-inline-block align-top" alt="">
            </a>

            <#if isAuth>
                <form action="/logout" method="post" class="float-right my-3">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button class="btn btn-warning" type="submit">Logout</button>
                </form>
            <#else>
                <a href="/login">
                    <input type="submit" class="btn btn-warning float-right my-3" value="Login"/>
                </a>
            </#if>
        </div>
        <#include "navbar.ftl">
        <#nested >
    </div>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    </body>
<footer class="container">
    <p>©RateTheCup Endava School 2019-2020</p>
</footer>
    </html>
</#macro>