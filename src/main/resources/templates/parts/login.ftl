<#macro login>
    <form action="/login" method="post" class="text-center my-3" >
        <div class="form-group"><label> Email address :<input class="form-control" type="text" name="email"/></label></div>
        <div class="form-group"><label> Password:<input class="form-control" type="password" name="password"/></label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group"><input class="btn btn-success" type="submit" value="Sign In"/> or
        <a href="/register" class="btn btn-outline-warning">Sign up</a></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post" >
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Sign Out</button>
    </form>
</#macro>

