<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User</title>
    </head>

    <body>

        <h1>Hello </h1>
                <p>
                <table border=1px>
                <tr><td>Emp ID</td><td>First Name</td><td>Last Name</td><td>Location</td></tr>
                <#list users as user>
                <tr>
                 <td>${user.empId} </td><td>${user.firstName}</td><td>${user.lastName}</td> <td>${user.location}</td>
                 </tr>
                </#list>
                </table>
                </p>

        <p>This is the user page!</p>
    </body>
</html>
