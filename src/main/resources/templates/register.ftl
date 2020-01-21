<#import "parts/common_nobar.ftl" as c>
<@c.page>
    <div class="jumbotron text-center my-3">
        <div class="header">
            <a>
                <img src="/images/logo2.jpg" width="80" height="80" class="d-inline-block align-top" alt="" >
            </a>
            <h3>Sign up and start your journey!</h3>
        </div>


        <form method="POST" action="/register">
                <div class="form-group ">
                <label for="userName"><input type="text" name="username" class="form-control" placeholder="Username"
                                             size="40" required="required"/></label>
            </div>
            <div class="form-group ">
                <label for="lastName"><input type="text" name="lastName" class="form-control" placeholder="Lastname"
                                             size="40" required="required"/></label>
            </div>
            <div class="form-group">
                <label for="firstName"> <input type="text" name="firstName" class="form-control" placeholder="Firstname"
                                               size="40" required="required"/></label>
            </div>
            <#if message??>
                ${message}
            </#if>
            <div class="form-group">
                <label for="email"> <input type="email" name="email" class="form-control" placeholder="Email" size="40"
                                           required="required"/></label>
            </div>
            <div class="form-group">
                <label for="password"> <input type="password" name="password" class="form-control"
                                              placeholder="Password" size="40" required="required" minlength="8"/></label>
            </div>
            <div class="form-group">
                <label for="confirm"><input type="password" name="confirm" placeholder="Confirm Password"
                                            class="form-control" minlength="8"
                                            size="40" required="required"/></label>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group">
                <input type="submit" value="Register" class="btn btn-success"/>
            </div>
        </form>
    </div>
</@c.page>