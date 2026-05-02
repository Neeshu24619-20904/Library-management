<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tasks List - Management System</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <nav class="navbar">
        <div class="logo"><strong>ProManage</strong></div>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/projects">Projects</a>
            <a href="${pageContext.request.contextPath}/tasks">Tasks</a>
        </div>
    </nav>

    <div class="container">
        <div class="header" style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 2rem;">
            <h1>Tasks (Joined Data)</h1>
            <a href="${pageContext.request.contextPath}/tasks/add" class="btn btn-primary">Add New Task</a>
        </div>

        <div class="card">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Task Title</th>
                        <th>Status</th>
                        <th>Project Name (Joined)</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="task" items="${tasks}">
                        <tr>
                            <td>${task.id}</td>
                            <td>${task.title}</td>
                            <td>
                                <span style="background: ${task.status == 'COMPLETED' ? 'rgba(16, 185, 129, 0.2)' : 'rgba(99, 102, 241, 0.2)'}; 
                                             color: ${task.status == 'COMPLETED' ? 'var(--accent)' : 'var(--primary)'}; 
                                             padding: 4px 8px; border-radius: 4px; font-size: 0.75rem; font-weight: bold;">
                                    ${task.status}
                                </span>
                            </td>
                            <td>${task.project.name}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/tasks/edit/${task.id}" class="btn btn-sm btn-primary">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
