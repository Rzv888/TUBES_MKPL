function logOut() {
    alert("Anda telah logout");
    window.location.href = "/auth/logout";
}

$(document).ready(function() {
    // Ambil referensi elemen select
    var departmentSelect = $('#departmentSelect');
  
    // Tangkap perubahan pada select
    departmentSelect.on('change', function() {
      var selectedDepartment = departmentSelect.val();
  
      // Saring data berdasarkan departemen yang dipilih
      if (selectedDepartment === 'all') {
        $('tbody tr').show();
      } else {
        $('tbody tr').hide();
        $('tbody tr[data-department="' + selectedDepartment + '"]').show();
      }
    });
  });
  