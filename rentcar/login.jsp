<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - RentCar Pro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <style>
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: 'Segoe UI', sans-serif;
        }
        .login-card {
            border: none;
            border-radius: 20px;
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
            padding: 2.5rem !important;
        }
        .btn-primary {
            background: #764ba2;
            border: none;
            transition: 0.3s;
        }
        .btn-primary:hover {
            background: #667eea;
        }
        .input-group-text {
            background: #f8f9fa;
            border-right: none;
        }
        .form-control {
            border-left: none;
            padding: 0.75rem;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-5 col-lg-4">
            <div class="card login-card">
                <div class="text-center mb-4">
                    <div class="display-6 mb-2 text-primary"><i class="bi bi-car-front-fill"></i></div>
                    <h3 class="fw-bold">YogaGanteng<span class="text-primary">RentCar</span></h3>
                    <p class="text-muted small">Silakan login untuk melanjutkan</p>
                </div>
                
                <%-- Notifikasi error --%>
                <% if(request.getAttribute("error") != null) { %>
                    <div class="alert alert-danger border-0 shadow-sm p-2 text-center" role="alert">
                        <i class="bi bi-exclamation-circle-fill"></i> <%= request.getAttribute("error") %>
                    </div>
                <% } %>

                <form action="${pageContext.request.contextPath}/login" method="POST">
                    <div class="mb-3">
                        <label class="form-label text-muted small">Username</label>
                        <div class="input-group">
                            <span class="input-group-text"><i class="bi bi-person"></i></span>
                            <input type="text" class="form-control" name="username" placeholder="Username" required>
                        </div>
                    </div>
                    <div class="mb-4">
                        <label class="form-label text-muted small">Password</label>
                        <div class="input-group">
                            <span class="input-group-text"><i class="bi bi-lock"></i></span>
                            <input type="password" class="form-control" name="password" placeholder="Password" required>
                        </div>
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary py-2 fw-bold shadow-sm">
                            <i class="bi bi-box-arrow-in-right"></i> LOGIN
                        </button>
                    </div>
                </form>
            </div>
            <p class="text-white text-center mt-3 small opacity-75">
                &copy; 2026 I Gede Yoga Setiawan
            </p>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>