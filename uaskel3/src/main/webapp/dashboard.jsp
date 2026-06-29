<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - ServletMVCLogin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f2f5;
        }
        .navbar {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        }
        .welcome-card {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            border-radius: 16px;
            color: white;
        }
        .info-card {
            border-radius: 12px;
            border: none;
            box-shadow: 0 2px 12px rgba(0, 0, 0, 0.08);
            transition: transform 0.2s;
        }
        .info-card:hover {
            transform: translateY(-4px);
        }
        .info-icon {
            width: 50px;
            height: 50px;
            border-radius: 12px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 24px;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand fw-bold" href="${pageContext.request.contextPath}/dashboard">
                <i class="bi bi-grid-fill me-2"></i>ServletMVCLogin
            </a>
            <div class="d-flex align-items-center">
                <span class="text-white me-3">
                    <i class="bi bi-person-circle me-1"></i>${sessionScope.fullname}
                </span>
                <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-light btn-sm">
                    <i class="bi bi-box-arrow-right me-1"></i>Logout
                </a>
            </div>
        </div>
    </nav>

    <!-- Content -->
    <div class="container mt-4">

        <!-- Welcome Card -->
        <div class="welcome-card p-4 mb-4">
            <div class="row align-items-center">
                <div class="col">
                    <h2 class="fw-bold mb-1">Selamat Datang, ${sessionScope.fullname}!</h2>
                    <p class="mb-0 opacity-75">Anda berhasil login ke sistem ServletMVCLogin</p>
                </div>
                <div class="col-auto d-none d-md-block">
                    <i class="bi bi-emoji-smile" style="font-size: 48px; opacity: 0.8;"></i>
                </div>
            </div>
        </div>

        <!-- Info Cards -->
        <div class="row g-4">
            <div class="col-md-4">
                <div class="card info-card p-4">
                    <div class="d-flex align-items-center">
                        <div class="info-icon bg-primary bg-opacity-10 text-primary me-3">
                            <i class="bi bi-person-badge"></i>
                        </div>
                        <div>
                            <small class="text-muted">Username</small>
                            <h5 class="mb-0 fw-bold">${sessionScope.username}</h5>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card info-card p-4">
                    <div class="d-flex align-items-center">
                        <div class="info-icon bg-success bg-opacity-10 text-success me-3">
                            <i class="bi bi-person-fill"></i>
                        </div>
                        <div>
                            <small class="text-muted">Nama Lengkap</small>
                            <h5 class="mb-0 fw-bold">${sessionScope.fullname}</h5>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card info-card p-4">
                    <div class="d-flex align-items-center">
                        <div class="info-icon bg-warning bg-opacity-10 text-warning me-3">
                            <i class="bi bi-shield-check"></i>
                        </div>
                        <div>
                            <small class="text-muted">Role</small>
                            <h5 class="mb-0 fw-bold">${sessionScope.role}</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Anggota Kelompok -->
        <div class="card info-card mt-4 p-4">
            <h5 class="fw-bold mb-3"><i class="bi bi-people-fill me-2"></i>Anggota Kelompok</h5>
            <div class="row g-3">
                <div class="col-md-4">
                    <div class="d-flex align-items-center p-3 rounded-3 bg-light">
                        <div class="info-icon bg-primary bg-opacity-10 text-primary me-3">
                            <i class="bi bi-person"></i>
                        </div>
                        <div>
                            <h6 class="mb-0 fw-bold">Yoga</h6>
                            <small class="text-muted">Anggota 1</small>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="d-flex align-items-center p-3 rounded-3 bg-light">
                        <div class="info-icon bg-success bg-opacity-10 text-success me-3">
                            <i class="bi bi-person"></i>
                        </div>
                        <div>
                            <h6 class="mb-0 fw-bold">Gloria</h6>
                            <small class="text-muted">Anggota 2</small>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="d-flex align-items-center p-3 rounded-3 bg-light">
                        <div class="info-icon bg-warning bg-opacity-10 text-warning me-3">
                            <i class="bi bi-person"></i>
                        </div>
                        <div>
                            <h6 class="mb-0 fw-bold">Haidar</h6>
                            <small class="text-muted">Anggota 3</small>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="d-flex align-items-center p-3 rounded-3 bg-light">
                        <div class="info-icon bg-danger bg-opacity-10 text-danger me-3">
                            <i class="bi bi-person"></i>
                        </div>
                        <div>
                            <h6 class="mb-0 fw-bold">Hamzah</h6>
                            <small class="text-muted">Anggota 4</small>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="d-flex align-items-center p-3 rounded-3 bg-light">
                        <div class="info-icon bg-info bg-opacity-10 text-info me-3">
                            <i class="bi bi-person"></i>
                        </div>
                        <div>
                            <h6 class="mb-0 fw-bold">Nofal</h6>
                            <small class="text-muted">Anggota 5</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Session Info Table -->
        <div class="card info-card mt-4 p-4">
            <h5 class="fw-bold mb-3"><i class="bi bi-info-circle me-2"></i>Informasi Session</h5>
            <div class="table-responsive">
                <table class="table table-bordered mb-0">
                    <thead class="table-light">
                        <tr>
                            <th>Attribute</th>
                            <th>Value</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Session ID</td>
                            <td><code>${pageContext.session.id}</code></td>
                        </tr>
                        <tr>
                            <td>Username</td>
                            <td>${sessionScope.username}</td>
                        </tr>
                        <tr>
                            <td>Fullname</td>
                            <td>${sessionScope.fullname}</td>
                        </tr>
                        <tr>
                            <td>Role</td>
                            <td>${sessionScope.role}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
