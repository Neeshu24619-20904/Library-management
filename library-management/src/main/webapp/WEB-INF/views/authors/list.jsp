<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authors</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 20px; }
        h1 { color: #2c3e50; }
        table { width: 100%; border-collapse: collapse; background: white; border-radius: 8px; overflow: hidden; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
        th { background: #2c3e50; color: white; padding: 12px; }
        td { padding: 10px 12px; border-bottom: 1px solid #eee; }
        tr:hover { background: #f0f4f8; }
        a.btn { background: #3498db; color: white; padding: 8px 14px; border-radius: 5px; text-decoration: none; }
        a.btn-green { background: #27ae60; }
        .msg-success { background: #d4edda; color: #155724; padding: 10px; border-radius: 5px; margin-bottom: 15px; }
        .msg-error { background: #f8d7da; color: #721c24; padding: 10px; border-radius: 5px; margin-bottom: 15px; }
        nav { margin-bottom: 20px; }
        nav a { margin-right: 15px; color: #3498db; text-decoration: none; font-weight: bold; }
    </style>
</head>
<body>
    <nav>
        <a href="/authors">Authors</a>
        <a href="/books">Books</a>
    </nav>
    <h1>Authors</h1>
    <c:if test="${not empty success}"><div class="msg-success">${success}</div></c:if>
    <c:if test="${not empty error}"><div class="msg-error">${error}</div></c:if>
    <a href="/authors/add" class="btn btn-green">+ Add Author</a><br><br>
    <table>
        <tr><th>ID</th><th>Name</th><th>Nationality</th><th>Email</th><th>Action</th></tr>
        <c:forEach var="a" items="${authors}">
            <tr>
                <td>${a.id}</td>
                <td>${a.name}</td>
                <td>${a.nationality}</td>
                <td>${a.email}</td>
                <td><a href="/authors/edit/${a.id}" class="btn">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>