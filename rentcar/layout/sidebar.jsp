<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Deteksi URL aktif yang lebih aman untuk arsitektur Servlet
    String uri = request.getRequestURI();
    boolean isDashboard = uri.contains("dashboard.jsp");
    boolean isMobil = uri.contains("/mobil");
    boolean isCustomer = uri.contains("/customer");
    boolean isTransaksi = uri.contains("/transaksi");
%>
<nav id="sidebar">
    <div class="sidebar-header">
        <h4 class="m-0 fw-bold text-primary">YogaGanteng<span class="text-white">Car</span></h4>
    </div>

    <ul class="list-unstyled components mt-3">
        <li class="<%= isDashboard ? "active" : "" %>">
            <a href="dashboard.jsp"><i class="bi bi-speedometer2"></i> Dashboard</a>
        </li>
        
        <p>Master Data</p>
        <li class="<%= isMobil ? "active" : "" %>">
            <a href="${pageContext.request.contextPath}/mobil"><i class="bi bi-car-front-fill"></i> Data Mobil</a>
        </li>
        <li class="<%= isCustomer ? "active" : "" %>">
            <a href="${pageContext.request.contextPath}/customer"><i class="bi bi-people-fill"></i> Data Customer</a>
        </li>
        
        <p>Transaksi</p>
        <li class="<%= isTransaksi ? "active" : "" %>">
            <a href="${pageContext.request.contextPath}/transaksi"><i class="bi bi-wallet2"></i> Rental Mobil</a>
        </li>
        
        <li class="nav-item">
            <a class="nav-link" href="laporan.jsp">
                <i class="bi bi-file-earmark-text"></i> Laporan
            </a>
        </li>
        <p>Sistem</p>
        <li>
            <a href="${pageContext.request.contextPath}/logout" class="text-danger"><i class="bi bi-box-arrow-right"></i> Logout</a>
        </li>
    </ul>
</nav>

<div id="content">
    
    <div class="navbar-custom d-flex justify-content-between align-items-center">
        <h5 class="m-0 fw-semibold text-secondary">
            <% 
                if(isDashboard) out.print("Dashboard Overview");
                else if(isMobil) out.print("Manajemen Mobil");
                else if(isCustomer) out.print("Manajemen Customer");
                else if(isTransaksi) out.print("Transaksi Rental");
            %>
        </h5>
        <div class="user-profile d-flex align-items-center">
            <span class="me-2 text-muted">Halo, <strong>${sessionScope.user}</strong></span>
            <i class="bi bi-person-circle fs-4 text-primary"></i>
        </div>
    </div>