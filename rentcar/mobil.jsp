<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.rentcar.model.Mobil" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    List<Mobil> listMobil = (List<Mobil>) request.getAttribute("listMobil");
%>

<jsp:include page="layout/header.jsp" />
<jsp:include page="layout/sidebar.jsp" />

<div class="container-fluid p-0">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h4 class="fw-bold text-dark m-0">Daftar Armada Mobil</h4>
        <button type="button" class="btn btn-primary" onclick="openAddModal()">
            <i class="bi bi-plus-lg"></i> Tambah Mobil
        </button>
    </div>

    <div class="card card-custom p-4">
        <div class="table-responsive">
            <table class="table table-hover align-middle m-0">
                <thead class="table-light">
                    <tr>
                        <th>No</th>
                        <th>Plat Nomor</th>
                        <th>Merk / Model</th>
                        <th>Tahun</th>
                        <th>Harga / Hari</th>
                        <th>Status</th>
                        <th class="text-center">Aksi</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        if (listMobil != null && !listMobil.isEmpty()) {
                            int no = 1;
                            for (Mobil m : listMobil) {
                                String badgeClass = m.getStatus().equals("Tersedia") ? "bg-success" : 
                                                    m.getStatus().equals("Disewa") ? "bg-warning text-dark" : "bg-danger";
                    %>
                    <tr>
                        <td><%= no++ %></td>
                        <td><span class="badge bg-secondary p-2"><%= m.getPlatNomor() %></span></td>
                        <td><strong><%= m.getMerk() %></strong> - <%= m.getModel() %></td>
                        <td><%= m.getTahun() %></td>
                        <td>Rp <%= String.format("%,.0f", m.getHargaPerHari()) %></td>
                        <td><span class="badge <%= badgeClass %>"><%= m.getStatus() %></span></td>
                        <td class="text-center">
                            <button class="btn btn-sm btn-outline-primary me-1" 
                                    onclick="openEditModal('<%= m.getIdMobil() %>', '<%= m.getPlatNomor() %>', '<%= m.getMerk() %>', '<%= m.getModel() %>', '<%= m.getTahun() %>', '<%= m.getHargaPerHari() %>', '<%= m.getStatus() %>')">
                                <i class="bi bi-pencil-square"></i>
                            </button>
                            <a href="${pageContext.request.contextPath}/mobil?action=delete&id=<%= m.getIdMobil() %>" 
                               class="btn btn-sm btn-outline-danger" 
                               onclick="return confirm('Yakin ingin menghapus mobil ini?')">
                                <i class="bi bi-trash-fill"></i>
                            </a>
                        </td>
                    </tr>
                    <% 
                            }
                        } else { 
                    %>
                    <tr>
                        <td colspan="7" class="text-center text-muted py-4">Belum ada data mobil.</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="modal fade" id="mobilModal" data-bs-backdrop="static" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="border-radius: 12px;">
            <div class="modal-header">
                <h5 class="modal-title fw-bold" id="modalTitle">Tambah Data Mobil</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/mobil" method="POST">
                <div class="modal-body">
                    <input type="hidden" id="id_mobil" name="id_mobil">
                    
                    <div class="mb-3">
                        <label class="form-label">Plat Nomor</label>
                        <input type="text" class="form-control" id="plat_nomor" name="plat_nomor" placeholder="Contoh: B 1234 ABC" required>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Merk</label>
                            <input type="text" class="form-control" id="merk" name="merk" placeholder="Toyota, Honda, dll" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Model</label>
                            <input type="text" class="form-control" id="model" name="model" placeholder="Avanza, Civic, dll" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Tahun</label>
                            <input type="number" class="form-control" id="tahun" name="tahun" placeholder="2022" required>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Harga Sewa / Hari</label>
                            <input type="number" class="form-control" id="harga_per_hari" name="harga_per_hari" placeholder="350000" required>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Status</label>
                        <select class="form-select" id="status" name="status">
                            <option value="Tersedia">Tersedia</option>
                            <option value="Disewa">Disewa</option>
                            <option value="Perawatan">Perawatan</option>
                        </select>
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
    var myModal = new bootstrap.Modal(document.getElementById('mobilModal'));

    function openAddModal() {
        document.getElementById('modalTitle').innerText = "Tambah Data Mobil";
        document.getElementById('id_mobil').value = "";
        document.getElementById('plat_nomor').value = "";
        document.getElementById('merk').value = "";
        document.getElementById('model').value = "";
        document.getElementById('tahun').value = "";
        document.getElementById('harga_per_hari').value = "";
        document.getElementById('status').value = "Tersedia";
        myModal.show();
    }

    function openEditModal(id, plat, merk, model, tahun, harga, status) {
        document.getElementById('modalTitle').innerText = "Edit Data Mobil";
        document.getElementById('id_mobil').value = id;
        document.getElementById('plat_nomor').value = plat;
        document.getElementById('merk').value = merk;
        document.getElementById('model').value = model;
        document.getElementById('tahun').value = tahun;
        document.getElementById('harga_per_hari').value = Math.round(harga);
        document.getElementById('status').value = status;
        myModal.show();
    }
</script>

<jsp:include page="layout/footer.jsp" />