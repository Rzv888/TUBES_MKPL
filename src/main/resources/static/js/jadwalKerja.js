// $(document).ready(function () {
//   // Mengisi input email jika ada di session storage
//   var email = sessionStorage.getItem("email");
//   if (email) {
//     $("#emailInput").val(email);
//   }

//   $("#submitButton").click(function () {
//     var email = $("#emailInput").val();

//     var selectedRow = $("input[name='pilihanPasien']:checked").closest("tr");
//     var department = selectedRow.attr("data-department");
//     var tanggalKerja = selectedRow.find("td:nth-child(2)").text();
//     var namaDokter = selectedRow.find("td:nth-child(3)").text();
//     var jamKerja = selectedRow.find("td:nth-child(4) span").text();

//     var jadwalPilihanPasien = {
//       emailPasien: email,
//       department: department,
//       tanggalKerja: tanggalKerja,
//       namaDokter: namaDokter,
//       jamKerja: jamKerja,
//     };

//     var jadwalPasienId = $('input[name="pilihanPasien"]:checked').attr(
//       "data-id"
//     );

//     if (confirm("Yakin dengan pilihan Anda?")) {
//       $.ajax({
//         type: "POST",
//         url: "/jadwal-pilihan-pasien",
//         data: JSON.stringify(jadwalPilihanPasien, jadwalPasienId),
//         contentType: "application/json",
//         success: function (response) {
//           console.log("Data pilihan pasien berhasil disimpan");
//         },
//         error: function (xhr, status, error) {
//           console.log(
//             "Terjadi kesalahan saat menyimpan data pilihan pasien: " + error
//           );
//         },
//       });
//     }
//   });
// });