<#import "parts/common.ftl" as c>
<@c.page>
    List of users

    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.getLastName()} ${user.getFirstName()}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.getId()}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>