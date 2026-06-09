<%@ page import="java.util.*" %>
<jsp:include page="layout/header.jsp" />
<jsp:include page="layout/sidebar.jsp" />

<div class="container-fluid mt-4">
    <div class="card p-4 shadow-sm mb-4">
        <form action="laporan" method="GET" class="row g-3">
            <div class="col-md-4">
                <input type="date" name="tgl_mulai" class="form-control" value="${tglMulai}" required>
            </div>
            <div class="col-md-4">
                <input type="date" name="tgl_akhir" class="form-control" value="${tglAkhir}" required>
            </div>
            <div class="col-md-4">
                <button type="submit" class="btn btn-primary">Tampilkan</button>
                <a href="laporan?action=download&tgl_mulai=${tglMulai}&tgl_akhir=${tglAkhir}" class="btn btn-danger">Download PDF</a>
            </div>
        </form>
    </div>

    <div class="card p-4 shadow-sm">
        <table class="table table-bordered">
            <thead>
                <tr><th>Mobil</th><th>Customer</th><th>Tgl Pinjam</th><th>Tgl Kembali</th><th>Status</th></tr>
            </thead>
            <tbody>
                <% List<Object[]> list = (List<Object[]>) request.getAttribute("dataList");
                   if(list != null && !list.isEmpty()) { 
                       for(Object[] row : list) { %>
                <tr><td><%=row[0]%></td><td><%=row[1]%></td><td><%=row[2]%></td><td><%=row[3]%></td><td><%=row[4]%></td></tr>
                <% }} else { %>
                <tr><td colspan="5" class="text-center">Data tidak ditemukan atau belum difilter</td></tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="layout/footer.jsp" />