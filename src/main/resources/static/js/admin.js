function kelolaPilihan() {
  window.location.href = "/kelolaJadwalPilihan";
}

function tambahJadwal() {
  window.location.href = "/tambahJadwal";
}

function hapusJadwal(button) {
  var jadwalId = button.parentNode.parentNode.querySelector("input[type=hidden]").value;
    $.ajax({
      url: "/hapus/" + jadwalId,
      type: "GET",
      success: function () {
        // Berhasil menghapus jadwal, lakukan tindakan yang diperlukan (misalnya, perbarui tampilan tabel)
        // Contoh: hapus baris tabel terkait dengan tombol "Hapus" yang diklik
        var row = button.parentNode.parentNode;
        row.parentNode.removeChild(row);
      },
      error: function () {
        // Gagal menghapus jadwal, tangani kesalahan jika diperlukan
        console.log("Gagal menghapus jadwal.");
      },
    });
}