<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.isAdmin()
    isAuth = user.isAuthenticated()
    userId = user.id
    >
<#else>
    <#assign
    name = ""
    isAdmin = false
    isAuth = false
    userId = "unknown"
    >
</#if>

