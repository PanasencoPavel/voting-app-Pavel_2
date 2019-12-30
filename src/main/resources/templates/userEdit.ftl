<#import "parts/common.ftl" as c>

<@c.page>

    User editor

    <form action="/user" method="post">
        <input type="text" name="firstName" value="${user.firstName}">
        <input type="text" name="lastName" value="${user.lastName}">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-success">Save</button>
    </form>
</@c.page>