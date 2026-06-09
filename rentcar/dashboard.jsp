<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Proteksi Halaman: Jika session user tidak ada, tendang kembali ke login
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<jsp:include page="layout/header.jsp" />
<jsp:include page="layout/sidebar.jsp" />

<div class="container-fluid p-0">
    <div class="row g-4 mb-4">
        <div class="col-10 col-md-4">
            <div class="card card-custom p-4 border-start border-primary border-4">
                <div class="d-flex justify-content-between align-items-center">
                    <div>
                        <h6 class="text-muted text-uppercase fs-7 font-weight-bold">Total Mobil</h6>
                        <h3 class="fw-bold mb-0 text-dark">12</h3>
                    </div>
                    <div class="bg-primary bg-opacity-10 p-3 rounded">
                        <i class="bi bi-car-front-fill text-primary fs-3"></i>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-10 col-md-4">
            <div class="card card-custom p-4 border-start border-success border-4">
                <div class="d-flex justify-content-between align-items-center">
                    <div>
                        <h6 class="text-muted text-uppercase fs-7">Total Customer</h6>
                        <h3 class="fw-bold mb-0 text-dark">48</h3>
                    </div>
                    <div class="bg-success bg-opacity-10 p-3 rounded">
                        <i class="bi bi-people-fill text-success fs-3"></i>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-10 col-md-4">
            <div class="card card-custom p-4 border-start border-warning border-4">
                <div class="d-flex justify-content-between align-items-center">
                    <div>
                        <h6 class="text-muted text-uppercase fs-7">Rental Aktif</h6>
                        <h3 class="fw-bold mb-0 text-dark">5</h3>
                    </div>
                    <div class="bg-warning bg-opacity-10 p-3 rounded">
                        <i class="bi bi-arrow-repeat text-warning fs-3"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="card card-custom p-4 mb-4">
        <h4 class="fw-bold text-dark">Selamat Datang di RentCar Pro System</h4>
        <p class="text-muted mb-0">Gunakan menu di sebelah kiri untuk mengelola data armada mobil, data pelanggan, serta menginput transaksi penyewaan baru secara *real-time*.</p>
    </div>
</div>

<jsp:include page="layout/footer.jsp" />