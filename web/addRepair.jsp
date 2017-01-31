<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add your device</title>
    </head>

    <body>
    <form action="addRepair" method="get">
        Name of device:<br>
        <input type="text" name="nameOfDevice"><br>
        <select name="typeOfRepair">
            <option value="Replace">Replace</option>
            <option value="Installation">Installation</option>
            <option value="Building">Building</option>
            <option value="Cleaning">Cleaning</option>
            <option value="Repairing">Repairing</option>
        </select>

        <input type="submit" value="Submit">
    </form>

    <div>
        <a href="overview.jsp">finalize -></a>
    </div>
    </body>
</html>
