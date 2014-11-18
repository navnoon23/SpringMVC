<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head> 
<title>My TO-DO List</title>
</head>

<body>
  <h1>My TO-DO List: ${curtime}</h1>
  <hr/>

  <form action="add.do" method="POST">
    Add To-Do item: 
    <input type="text" name="item" id="item" maxlength="50" size="50"/>
    <input type="submit" name="add" id="add" value="Add"/>
  </form>  
  <hr/>
  
  <ul>
    <c:forEach var="item" items="${list}">
      <li><form action="delete.do" method="POST">
          <input type="hidden" name="item" id="item" value="${item}"/>
          <input type="text" disabled="disabled" value="${item}" size="50"/> <input type="submit" name="delete" id="delete" value="Delete"/>
        </form>  
      </li>
    </c:forEach>
  </ul>
  <hr/>
</body>
</html>