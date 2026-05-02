<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>${project.id == null ? 'Add Project' : 'Edit Project'}</title>
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
        <h1>${project.id == null ? 'Add New Project' : 'Edit Project'}</h1>

        <c:if test="${param.error == 'integrity_violation'}">
            <div class="alert alert-danger">
                Error: A project with this name already exists or data is invalid.
            </div>
        </c:if>

        <div class="card">
            <form action="${pageContext.request.contextPath}/projects/${project.id == null ? 'save' : 'update/'.concat(project.id)}" method="post">
                <div class="form-group">
                    <label for="name">Project Name</label>
                    <input type="text" id="name" name="name" class="form-control" value="${project.name}" required>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <textarea id="description" name="description" class="form-control" rows="4">${project.description}</textarea>
                </div>
                <div style="margin-top: 2rem;">
                    <button type="submit" class="btn btn-primary">Save Project</button>
                    <a href="${pageContext.request.contextPath}/projects" class="btn" style="color: var(--text-muted);">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
