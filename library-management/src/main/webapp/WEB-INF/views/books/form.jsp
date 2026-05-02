<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Form</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; display: flex; justify-content: center; padding: 40px; }
        .card { background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); width: 420px; }
        h1 { color: #8e44ad; margin-top: 0; }
        input, select { width: 100%; padding: 10px; margin: 8px 0 16px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box; }
        button { background: #8e44ad; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer; width: 100%; font-size: 15px; }
        button:hover { background: #7d3c98; }
        a { color: #8e44ad; }
        label { font-weight: bold; color: #555; }
    </style>
</head>
<body>
<div class="card">
    <h1>${book.id == null ? 'Add New Book' : 'Edit Book'}</h1>
    <c:set var="action" value="${book.id == null ? '/books/add' : '/books/edit/'.concat(book.id)}"/>
    <form action="${action}" method="post">
        <label>Title</label>
        <input type="text" name="title" value="${book.title}" required/>
        <label>Genre</label>
        <input type="text" name="genre" value="${book.genre}" required/>
        <label>Published Year</label>
        <input type="number" name="publishedYear" value="${book.publishedYear}" required/>
        <label>Author</label>
        <select name="authorId" required>
            <option value="">-- select author --</option>
            <c:forEach var="a" items="${authors}">
                <option value="${a.id}" ${book.author != null && book.author.id == a.id ? 'selected' : ''}>${a.name}</option>
            </c:forEach>
        </select>
        <button type="submit">${book.id == null ? 'Add Book' : 'Update Book'}</button>
    </form>
    <br><a href="/books">← back to list</a>
</div>
</body>
</html>