<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>${task.id == null ? 'Add Task' : 'Edit Task'}</title>
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
        <h1>${task.id == null ? 'Add New Task' : 'Edit Task'}</h1>

        <c:if test="${param.error == 'integrity_violation'}">
            <div class="alert alert-danger">
                Error: Data integrity violation occurred.
            </div>
        </c:if>

        <div class="card">
            <form action="${pageContext.request.contextPath}/tasks/${task.id == null ? 'save' : 'update/'.concat(task.id)}" method="post">
                <div class="form-group">
                    <label for="title">Task Title</label>
                    <input type="text" id="title" name="title" class="form-control" value="${task.title}" required>
                </div>
                <div class="form-group">
                    <label for="status">Status</label>
                    <select id="status" name="status" class="form-control">
                        <option value="PENDING" ${task.status == 'PENDING' ? 'selected' : ''}>PENDING</option>
                        <option value="IN_PROGRESS" ${task.status == 'IN_PROGRESS' ? 'selected' : ''}>IN PROGRESS</option>
                        <option value="COMPLETED" ${task.status == 'COMPLETED' ? 'selected' : ''}>COMPLETED</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="project">Project</label>
                    <select id="project" name="project.id" class="form-control" required>
                        <option value="">Select Project</option>
                        <c:forEach var="proj" items="${projects}">
                            <option value="${proj.id}" ${task.project.id == proj.id ? 'selected' : ''}>${proj.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div style="margin-top: 2rem;">
                    <button type="submit" class="btn btn-primary">Save Task</button>
                    <a href="${pageContext.request.contextPath}/tasks" class="btn" style="color: var(--text-muted);">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
