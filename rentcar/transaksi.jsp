<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, com.rentcar.model.*" %>
<jsp:include page="layout/header.jsp" />
<jsp:include page="layout/sidebar.jsp" />

<div class="container-fluid mt-4">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h4 class="fw-bold">Data Transaksi Rental</h4>
        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalTransaksi">
            <i class="bi bi-plus-lg"></i> Transaksi Baru
        </button>
    </div>

    <div class="card p-4 shadow-sm">
        <table class="table table-hover align-middle">
            <thead class="table-light">
                <tr>
                    <th>Mobil</th><th>Customer</th><th>Pinjam</th><th>Kembali</th><th>Total</th><th>Status</th><th>Aksi</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Transaksi> list = (List<Transaksi>) request.getAttribute("listTransaksi");
                    if(list != null) {
                        for(Transaksi t : list) { 
                %>
                <tr>
                    <td><%= t.getNamaMobil() %></td>
                    <td><%= t.getNamaCustomer() %></td>
                    <td><%= t.getTglPinjam() %></td>
                    <td><%= t.getTglKembali() %></td>
                    <td>Rp <%= String.format("%,.0f", t.getTotalHarga()) %></td>
                    <td>
                        <% if(t.getStatus().equals("Dipinjam")) { %>
                            <span class="badge bg-warning text-dark">Dipinjam</span>
                        <% } else { %>
                            <span class="badge bg-success">Selesai</span>
                        <% } %>
                    </td>
                    <td>
                        <% if(t.getStatus().equals("Dipinjam")) { %>
                            <form action="pengembalian" method="POST">
                                <input type="hidden" name="id_transaksi" value="<%= t.getIdTransaksi() %>">
                                <input type="hidden" name="id_mobil" value="<%= t.getIdMobil() %>">
                                <button type="submit" class="btn btn-sm btn-success" 
                                        onclick="return confirm('Apakah mobil sudah kembali?')">
                                    <i class="bi bi-check-circle"></i> Kembalikan
                                </button>
                            </form>
                        <% } else { %>
                            <button class="btn btn-sm btn-secondary" disabled>Selesai</button>
                        <% } %>
                    </td>
                </tr>
                <% } } %>
            </tbody>
        </table>
    </div>
</div>

<div class="modal fade" id="modalTransaksi" tabindex="-1">
    <div class="modal-dialog">
        <form action="transaksi" method="POST" class="modal-content">
            <div class="modal-header"><h5 class="modal-title">Form Rental</h5></div>
            <div class="modal-body">
                <select name="id_mobil" class="form-select mb-3" required>
                    <option value="">-- Pilih Mobil --</option>
                    <% for(Mobil m : (List<Mobil>)request.getAttribute("listMobil")) { %>
                        <option value="<%= m.getIdMobil() %>"><%= m.getMerk() %> <%= m.getModel() %></option>
                    <% } %>
                </select>
                <select name="id_customer" class="form-select mb-3" required>
                    <option value="">-- Pilih Customer --</option>
                    <% for(Customer c : (List<Customer>)request.getAttribute("listCustomer")) { %>
                        <option value="<%= c.getIdCustomer() %>"><%= c.getNama() %></option>
                    <% } %>
                </select>
                <div class="row">
                    <div class="col-md-6 mb-3"><input type="date" name="tgl_pinjam" class="form-control" required></div>
                    <div class="col-md-6 mb-3"><input type="date" name="tgl_kembali" class="form-control" required></div>
                </div>
                <input type="number" name="total_harga" class="form-control" placeholder="Total Harga" required>
            </div>
            <div class="modal-footer"><button type="submit" class="btn btn-success">Simpan Transaksi</button></div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<jsp:include page="layout/footer.jsp" />