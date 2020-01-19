<#import "parts/common.ftl" as c>

<@c.page>
    <div class="jumbotron jumbotron-fluid my-3 bg-dark" id="profile">
    <div class="container">
    <h5>User Account</h5>
    <h6 class="lead">Username: ${user.username}</h6>
    <h6 class="lead">Name: ${user.lastName} ${user.firstName}</h6>
    <h6 class="lead">Email: ${user.email}</h6>
    <form action="/user/${user.getId()}/edit" method="get">
        <button class="btn btn-outline-info" type="submit">edit</button>
    </form>
    </div>
    </div>
    <div>
        <h5>My Reviews</h5>
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
                <div class="card-footer" style="text-align: right">${rating.getCoffeeShop().getName()} </div>

            </div>
        </#list>
    </div>
</@c.page>