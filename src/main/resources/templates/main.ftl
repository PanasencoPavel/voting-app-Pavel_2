<#import "parts/common.ftl" as c>
<@c.page>
    <#list coffeeShop as shop>
        <div class="jumbotron my-3 " id="mainList" method="get"
             style="background-image: url(/images/${shop.getFilename()});">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="container">
                <h1 class="display-4">${shop.getName()}
                    <#list 1..(shop.getAvg())?round as i>
                        <div class="stars-outer" style="font-size: .30em; ">
                        </div>
                    </#list>
                    <button class="btn btn-sm btn-warning">#{shop.getAvg(); M2} / 5.0</button>
                </h1>
                <br/>
                <h6 class="lead">${shop.getDescription()}</h6><br/><br>
                <form action="/shop/${shop.getId()}" method="GET">
                    <input type="submit" class="btn btn-warning" value="Overview"/>
                </form>
            </div>
        </div>
    </#list>
</@c.page>