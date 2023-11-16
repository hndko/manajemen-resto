# manajemen-resto
Tugas Praktik Pemrograman Berbasis Objek - Studi Kasus: Manajemen Restoran
Sekarang, anda diminta untuk membuat program Java yang akan digunakan untuk manajemen restoran. Program ini akan mencakup berbagai konsep pemrograman berbasis objek yang telah dipelajari.
<b>Petunjuk Pengerjaan Tugas dan Poin untuk Penjelasan di Rekaman Video:</b> <br>
<ol>
   <li>Buatlah sebuah kelas abstrak MenuItem yang akan menjadi kelas dasar untuk semua menu item dalam restoran. Kelas ini harus memiliki atribut nama (String), harga (double), dan kategori (String). Definisikan metode abstrak tampilMenu() yang akan digunakan untuk menampilkan informasi tentang item menu</li>
   <li>
      Buatlah tiga kelas turunan dari MenuItem: Makanan, Minuman, dan Diskon.
      <ul>
         <li>Kelas Makanan dan Minuman adalah subkelas dari MenuItem dan harus memiliki atribut tambahan yang sesuai dengan jenisnya (misalnya, jenisMakanan dan jenisMinuman). Implementasikan metode tampilMenu() untuk menampilkan informasi khusus tentang makanan dan minuman.</li>
         <li>Kelas Diskon adalah subkelas dari MenuItem yang akan digunakan untuk menerapkan diskon khusus pada menu. Kelas ini harus memiliki atribut diskon (double) dan mengimplementasikan metode tampilMenu() untuk menampilkan informasi tentang diskon yang ditawarkan.</li>
      </ul>      
   </li>
   <li>Buatlah sebuah kelas Menu yang akan digunakan untuk mengelola semua item menu dalam restoran. Kelas ini harus memiliki atribut berupa sebuah ArrayList untuk menyimpan semua item menu.</li>
   <li>Buatlah kelas Pesanan yang akan digunakan untuk mencatat pesanan pelanggan. Kelas ini harus memiliki atribut berupa ArrayList untuk menyimpan item-item yang dipesan oleh pelanggan.</li>
   <li>Implementasikan konsep inheritance dengan benar antara kelas-kelas ini.</li>
   <li>Implementasikan konsep encapsulation dengan membatasi akses ke atribut-atribut kelas.</li>
   <li>Pergunaan pengecualian (exception) yang mungkin terjadi, seperti ketika mencoba mengakses item yang tidak ada dalam menu.</li>
   <li>
      Program harus memiliki menu utama yang memungkinkan pengguna untuk:
      <ul>
         <li>Menambahkan item baru ke menu (makanan, minuman, atau diskon).</li>
         <li>Menampilkan menu restoran.</li>
         <li>Menerima pesanan dari pelanggan dan mencatatnya.</li>
         <li>Menghitung total biaya pesanan dengan mempertimbangkan diskon yang mungkin diterapkan.</li>
         <li>Menampilkan struk pesanan pelanggan.</li>
         <li>Keluar dari program.</li>
      </ul>
   </li>
   <li>Implementasikan operasi I/O dan operasi file untuk menyimpan dan memuat daftar menu dari sebuah file teks, dan juga menyimpan struk pesananan pelanggan dan memuat dari file teks.</li>
   <li>Gunakan struktur keputusan dan pengulangan sesuai dengan kebutuhan, seperti saat menampilkan menu dan memproses pesanan.</li>
   <li>Durasi video penjelasan maksimal 15 menit</li>
</ol>
<p>
   <b>Petunjuk Tambahan:</b> <br>
      <ol>
         <li>Anda dapat menggunakan antarmuka atau abstract class jika diperlukan untuk mengimplementasikan abstraksi, seperti antarmuka untuk makanan, minuman, dan diskon.</li>
         <li>Gunakan polymorphism untuk mengimplementasikan metode tampilMenu() pada masing-masing kelas turunan.</li>
         <li>Pastikan untuk menjaga struktur yang rapi dan dokumentasi yang baik dalam kode Anda.</li>
      </ol>
   Dengan tugas praktik 3 ini, diharapkan rekan-rekana mahasiswa dapat mempraktikkan berbagai konsep pemrograman berbasis objek, penggunaan I/O dan exception handling, serta operasi File dalam sebuah aplikasi manajemen restoran yang lebih kompleks.
</p>
