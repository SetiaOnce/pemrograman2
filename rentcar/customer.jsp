<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.rentcar.model.Customer" %>
<%
    // Pengecekan sesi (Sama seperti di mobil.jsp)
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    List<Customer> listCustomer = (List<Customer>) request.getAttribute("listCustomer");
%>

<jsp:include page="layout/header.jsp" />
<jsp:include page="layout/sidebar.jsp" />

<div class="container-fluid p-0">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h4 class="fw-bold text-dark m-0">Daftar Customer</h4>
        <button type="button" class="btn btn-primary" onclick="openAddModal()">
            <i class="bi bi-plus-lg"></i> Tambah Customer
        </button>
    </div>

    <div class="card card-custom p-4">
        <div class="table-responsive">
            <table class="table table-hover align-middle m-0">
                <thead class="table-light">
                    <tr>
                        <th>No</th>
                        <th>NIK</th>
                        <th>Nama Customer</th>
                        <th>No. Telp</th>
                        <th>Alamat</th>
                        <th class="text-center">Aksi</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        if (listCustomer != null && !listCustomer.isEmpty()) {
                            int no = 1;
                            for (Customer c : listCustomer) {
                    %>
                    <tr>
                        <td><%= no++ %></td>
                        <td><%= c.getNik() %></td>
                        <td><strong><%= c.getNama() %></strong></td>
                        <td><%= c.getNoTelp() %></td>
                        <td><%= c.getAlamat() %></td>
                        <td class="text-center">
                            <button class="btn btn-sm btn-outline-primary me-1" 
                                    onclick="openEditModal('<%= c.getIdCustomer() %>', '<%= c.getNik() %>', '<%= c.getNama() %>', '<%= c.getNoTelp() %>', '<%= c.getAlamat() %>')">
                                <i class="bi bi-pencil-square"></i>
                            </button>
                            <a href="${pageContext.request.contextPath}/customer?action=delete&id=<%= c.getIdCustomer() %>" 
                               class="btn btn-sm btn-outline-danger" 
                               onclick="return confirm('Yakin ingin menghapus customer ini?')">
                                <i class="bi bi-trash-fill"></i>
                            </a>
                        </td>
                    </tr>
                    <% 
                            }
                        } else { 
                    %>
                    <tr>
                        <td colspan="6" class="text-center text-muted py-4">Belum ada data customer.</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="modal fade" id="customerModal" data-bs-backdrop="static" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="border-radius: 12px;">
            <div class="modal-header">
                <h5 class="modal-title fw-bold" id="modalTitle">Tambah Data Customer</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/customer" method="POST">
                <div class="modal-body">
                    <input type="hidden" id="id_customer" name="id_customer">
                    
                    <div class="mb-3">
                        <label class="form-label">NIK</label>
                        <input type="text" class="form-control" id="nik" name="nik" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Nama Customer</label>
                        <input type="text" class="form-control" id="nama" name="nama" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">No. Telp</label>
                        <input type="text" class="form-control" id="no_telp" name="no_telp" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Alamat</label>
                        <textarea class="form-control" id="alamat" name="alamat" rows="3" required></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Batal</button>
                    <button type="submit" class="btn btn-primary">Simpan Data</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    var myModal = new bootstrap.Modal(document.getElementById('customerModal'));

    function openAddModal() {
        document.getElementById('modalTitle').innerText = "Tambah Data Customer";
        document.getElementById('id_customer').value = "";
        document.getElementById('nik').value = "";
        document.getElementById('nama').value = "";
        document.getElementById('no_telp').value = "";
        document.getElementById('alamat').value = "";
        myModal.show();
    }

    function openEditModal(id, nik, nama, tlp, alamat) {
        document.getElementById('modalTitle').innerText = "Edit Data Customer";
        document.getElementById('id_customer').value = id;
        document.getElementById('nik').value = nik;
        document.getElementById('nama').value = nama;
        document.getElementById('no_telp').value = tlp;
        document.getElementById('alamat').value = alamat;
        myModal.show();
    }
</script>

<jsp:include page="layout/footer.jsp" />