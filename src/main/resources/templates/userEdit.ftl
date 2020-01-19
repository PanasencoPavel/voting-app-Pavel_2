<#import "parts/common.ftl" as c>

    <@c.page>

  <h3> Change your accounts information</h3>

    <form action="/user/edit" method="post">
        <div class="form-group ">
            <label>Username <input type="text" name="userName" class="form-control" value="${user.username}" size="40"></label>
        </div>
        <div class="form-group ">
            <label>Firstname <input type="text" name="firstName" class="form-control" value="${user.firstName}" size="40"></label>
        </div>
        <div class="form-group ">
            <label>Lastname <input type="text" name="lastName" class="form-control" value="${user.lastName}" size="40"></label>
        </div>
        <div class="form-group ">
            <label>Password <input type="text" name="password" class="form-control" size="40"></label>
        </div>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-success">Save</button>
    </form>


</@c.page>