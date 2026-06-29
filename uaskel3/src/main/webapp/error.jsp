<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error - ServletMVCLogin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #ff6b6b 0%, #ee5a24 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .error-card {
            width: 100%;
            max-width: 500px;
            border-radius: 16px;
            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="error-card card border-0 mx-auto text-center">
            <div class="card-body p-5">
                <i class="bi bi-exclamation-triangle text-danger" style="font-size: 64px;"></i>
                <h2 class="fw-bold mt-3">Oops! Terjadi Kesalahan</h2>
                <p class="text-muted mb-4">Halaman yang Anda cari tidak ditemukan atau terjadi error pada server.</p>
                <a href="${pageContext.request.contextPath}/login" class="btn btn-primary px-4 py-2">
                    <i class="bi bi-arrow-left me-2"></i>Kembali ke Login
                </a>
            </div>
        </div>
    </div>
</body>
</html>
