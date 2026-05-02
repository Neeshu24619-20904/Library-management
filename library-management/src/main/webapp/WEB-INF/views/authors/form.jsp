<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Author Form</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; display: flex; justify-content: center; padding: 40px; }
        .card { background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); width: 400px; }
        h1 { color: #2c3e50; margin-top: 0; }
        input { width: 100%; padding: 10px; margin: 8px 0 16px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box; }
        button { background: #27ae60; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer; width: 100%; font-size: 15px; }
        button:hover { background: #219a52; }
        a { color: #3498db; }
        label { font-weight: bold; color: #555; }
    </style>
</head>
<body>
<div class="card">
    <h1>${author.id == null ? 'Add New Author' : 'Edit Author'}</h1>
    <c:set var="action" value="${author.id == null ? '/authors/add' : '/authors/edit/'.concat(author.id)}"/>
    <form action="${action}" method="post">
        <label>Name</label>
        <input type="text" name="name" value="${author.name}" required/>
        <label>Nationality</label>
        <input type="text" name="nationality" value="${author.nationality}" required/>
        <label>Email</label>
        <input type="email" name="email" value="${author.email}"/>
        <button type="submit">${author.id == null ? 'Add Author' : 'Update Author'}</button>
    </form>
    <br><a href="/authors">← back to list</a>
</div>
</body>
</html>