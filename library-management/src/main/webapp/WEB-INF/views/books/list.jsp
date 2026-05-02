<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 20px; }
        h1 { color: #8e44ad; }
        table { width: 100%; border-collapse: collapse; background: white; border-radius: 8px; overflow: hidden; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
        th { background: #8e44ad; color: white; padding: 12px; }
        td { padding: 10px 12px; border-bottom: 1px solid #eee; }
        tr:hover { background: #f9f4ff; }
        a.btn { background: #8e44ad; color: white; padding: 8px 14px; border-radius: 5px; text-decoration: none; }
        a.btn-green { background: #27ae60; }
        a.btn-red { background: #e74c3c; }
        .msg-success { background: #d4edda; color: #155724; padding: 10px; border-radius: 5px; margin-bottom: 15px; }
        .msg-error { background: #f8d7da; color: #721c24; padding: 10px; border-radius: 5px; margin-bottom: 15px; }
        nav { margin-bottom: 20px; }
        nav a { margin-right: 15px; color: #8e44ad; text-decoration: none; font-weight: bold; }
    </style>
</head>
<body>
    <nav>
        <a href="/authors">Authors</a>
        <a href="/books">Books</a>
    </nav>
    <h1>Books</h1>
    <c:if test="${not empty success}"><div class="msg-success">${success}</div></c:if>
    <c:if test="${not empty error}"><div class="msg-error">${error}</div></c:if>
    <a href="/books/add" class="btn btn-green">+ Add Book</a><br><br>
    <table>
        <tr><th>ID</th><th>Title</th><th>Genre</th><th>Year</th><th>Author</th><th>Action</th></tr>
        <c:forEach var="b" items="${books}">
            <tr>
                <td>${b.id}</td>
                <td>${b.title}</td>
                <td>${b.genre}</td>
                <td>${b.publishedYear}</td>
                <td>${b.author.name}</td>
                <td>
                    <a href="/books/edit/${b.id}" class="btn">Edit</a>
                    <a href="/books/delete/${b.id}" class="btn btn-red" onclick="return confirm('Are you sure you want to delete this book?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>