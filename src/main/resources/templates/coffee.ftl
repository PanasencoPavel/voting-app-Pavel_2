<#import "parts/common.ftl" as c>

<@c.page>
    <div class="jumbotron my-3 " id="coffeeList" method="get"
         style="background-image: url(/images/${coffeeShop.filename}); ">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="container">
            <h1 class="display-4">${coffeeShop.name}</h1>
            <h6 class="lead">${coffeeShop.getDescription()}</h6>
            <h6 class="lead">${coffeeShop.getAddress()}</h6><br>
            <h5> Average Raiting: ${coffeeShop.avg} </h5>
            <div>
                <#list 1..(coffeeShop.avgCoffee)?round as i>
                    <div class="stars-outer">
                    </div>
                </#list> <a>${coffeeShop.avgCoffee} Coffee</a>
            </div>
            <div><#list 1..(coffeeShop.avgFood)?round as i>
                <div class="stars-outer">
                </div>
                </#list><a>${coffeeShop.avgFood} Food</a></div>
            <div> <#list 1..(coffeeShop.avgAtmosphere)?round as i>
                <div class="stars-outer">
                </div>
                </#list><a>${coffeeShop.avgAtmosphere} Atmosphere</a></div>
            <div>
                <#list 1..(coffeeShop.avgService)?round as i>
                <div class="stars-outer">
                </div>
                </#list><a>${coffeeShop.avgService} Service</a>
            </div>
            <br>
            <form action="/shop/ ${coffeeShop.getId()} /addrating" method="GET">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div><input type="submit" class="btn btn-warning " value="Rate this shop"/></div>
            </form>
        </div>
    </div>
    <div>
        <h5>Last Reviews</h5>
    </div>
    <div class="card-columns">
    <#list ratings as rating>
    <div class="card text-white bg-dark my-3" style="width: 18rem;">
        <#if rating.filename??>
        <img class="card-img-top" src="/img/${rating.filename}" alt="Card image cap">
        </#if>
        <div class="card-body">
            <h5 class="card-title">${rating.getFeedback().getHeadingText()}</h5>
            <p class="card-text">${rating.getFeedback().getFeedbackText()}</p>
            <a class="badge badge-warning"> Coffee: ${rating.getCoffeeNote().showNote()}</a>
            <a class="badge badge-warning"> Food: ${rating.getFoodNote().showNote()}</a>
            <a class="badge badge-warning"> Atmosphere: ${rating.getAtmosphereNote().showNote()}</a>
            <a class="badge badge-warning"> Service: ${rating.getServiceNote().showNote()}</a>
        </div>
        <div class="card-footer" style="text-align: right">${rating.getUser().getLastName()} ${rating.getUser().getFirstName()}</div>
    </div>
    </#list>
    </div>
</@c.page>