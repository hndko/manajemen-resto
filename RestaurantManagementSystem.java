import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

abstract class MenuItem {
    protected String nama;
    protected double harga;
    protected String kategori;

    public MenuItem(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    public abstract void tampilMenu();

    public double getHarga() {
        return harga;
    }
}

class Makanan extends MenuItem {
    private String jenisMakanan;

    public Makanan(String nama, double harga, String jenisMakanan) {
        super(nama, harga, "Makanan");
        this.jenisMakanan = jenisMakanan;
    }

    public void tampilMenu() {
        System.out.println("Makanan: " + nama + "\t | Harga: " + harga + "\t | Jenis: " + jenisMakanan);
    }
}

class Minuman extends MenuItem {
    private String jenisMinuman;

    public Minuman(String nama, double harga, String jenisMinuman) {
        super(nama, harga, "Minuman");
        this.jenisMinuman = jenisMinuman;
    }

    public void tampilMenu() {
        System.out.println("Minuman: " + nama + "\t | Harga: " + harga + "\t | Jenis: " + jenisMinuman);
    }
}

class Diskon extends MenuItem {
    private double diskon;

    public Diskon(String nama, double harga, double diskon) {
        super(nama, harga, "Diskon");
        this.diskon = diskon;
    }

    public void tampilMenu() {
        System.out.println("Diskon: " + nama + "\t | Harga: " + harga + "\t | Diskon: " + diskon + "%");
    }
}

class Menu {
    private ArrayList<MenuItem> daftarMenu = new ArrayList<>();

    public void tambahMenu(MenuItem itemMenu) {
        daftarMenu.add(itemMenu);
    }

    public void tampilMenuRestoran() {
        System.out.println("== Menu Restoran ==");
        for (int i = 0; i < daftarMenu.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarMenu.get(i).tampilMenu();
        }
    }

    public MenuItem getItemMenu(int index) {
        return daftarMenu.get(index);
    }
}

class Pesanan {
    private ArrayList<MenuItem> pesananPelanggan = new ArrayList<>();

    public void tambahPesanan(MenuItem itemPesanan) {
        pesananPelanggan.add(itemPesanan);
    }

    public ArrayList<MenuItem> getPesananPelanggan() {
        return pesananPelanggan;
    }

    public void tampilStrukPesanan() {
        double totalBiaya = 0;
        System.out.println("== Struk Pesanan ==");
        for (MenuItem item : pesananPelanggan) {
            item.tampilMenu();
            totalBiaya += item.getHarga();
        }
        System.out.println("Total Biaya: " + totalBiaya);
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Menu menuRestoran = new Menu();
        Pesanan pesananPelanggan = new Pesanan();
        Scanner scanner = new Scanner(System.in);

        // Contoh penambahan item menu
        menuRestoran.tambahMenu(new Makanan("Nasi Goreng", 15000, "Biasa"));
        menuRestoran.tambahMenu(new Minuman("Es Teh", 5000, "Manis"));
        menuRestoran.tambahMenu(new Diskon("Diskon Hari Ini", 0, 10));

        int pilihan;
        do {
            System.out.println("\n== Menu Utama ==");
            System.out.println("1. Tambah Item Menu");
            System.out.println("2. Tampilkan Menu Restoran");
            System.out.println("3. Pesan Menu");
            System.out.println("4. Hitung Total Biaya Pesanan");
            System.out.println("5. Tampilkan Struk Pesanan");
            System.out.println("6. Keluar");

            System.out.print("Pilih menu (1-6): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    // Pilihan untuk menambah item baru ke menu
                    System.out.print("Masukkan nama item: ");
                    String namaItem = scanner.nextLine();
                    System.out.print("Masukkan harga item: ");
                    double hargaItem = scanner.nextDouble();
                    System.out.print("Masukkan kategori item (Makanan/Minuman/Diskon): ");
                    String kategoriItem = scanner.next();

                    MenuItem newItem;
                    if (kategoriItem.equalsIgnoreCase("Makanan")) {
                        System.out.print("Masukkan jenis makanan: ");
                        String jenisMakanan = scanner.next();
                        newItem = new Makanan(namaItem, hargaItem, jenisMakanan);
                    } else if (kategoriItem.equalsIgnoreCase("Minuman")) {
                        System.out.print("Masukkan jenis minuman: ");
                        String jenisMinuman = scanner.next();
                        newItem = new Minuman(namaItem, hargaItem, jenisMinuman);
                    } else if (kategoriItem.equalsIgnoreCase("Diskon")) {
                        System.out.print("Masukkan besaran diskon (%): ");
                        double diskon = scanner.nextDouble();
                        newItem = new Diskon(namaItem, 0, diskon);
                    } else {
                        System.out.println("Kategori item tidak valid.");
                        continue;
                    }

                    menuRestoran.tambahMenu(newItem);
                    System.out.println("Item berhasil ditambahkan ke menu.");
                    break;

                case 2:
                    // Pilihan untuk menampilkan menu restoran
                    menuRestoran.tampilMenuRestoran();
                    break;

                case 3:
                    // Pilihan untuk menerima pesanan dari pelanggan
                    System.out.print("Masukkan nomor item yang dipesan: ");
                    int nomorItem = scanner.nextInt();
                    try {
                        MenuItem itemPesanan = menuRestoran.getItemMenu(nomorItem - 1);
                        pesananPelanggan.tambahPesanan(itemPesanan);
                        System.out.println("Pesanan berhasil ditambahkan.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Nomor item tidak valid.");
                    }
                    break;

                case 4:
                    // Pilihan untuk menghitung total biaya pesanan
                    double totalBiaya = 0;
                    for (MenuItem item : pesananPelanggan.getPesananPelanggan()) {
                        totalBiaya += item.getHarga();
                    }
                    System.out.println("Total Biaya Pesanan: " + totalBiaya);
                    break;

                case 5:
                    // Pilihan untuk menampilkan struk pesanan
                    pesananPelanggan.tampilStrukPesanan();
                    break;

                case 6:
                    // Pilihan untuk keluar dari program
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    break;
            }

        } while (pilihan != 6);
        
        // Contoh penggunaan operasi I/O dan operasi file untuk menyimpan dan memuat daftar menu
        // Pindahkan operasi I/O ke luar dari loop utama
        try {
            saveMenuToFile(menuRestoran, "menu.txt");
            Menu loadedMenu = loadMenuFromFile("menu.txt");
            if (loadedMenu != null) {
                loadedMenu.tampilMenuRestoran();
            } else {
                System.out.println("Gagal memuat menu. Menu kosong.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found - " + e.getMessage());
        }

    }

    // Implementasi operasi I/O dan operasi file untuk menyimpan dan memuat daftar menu
    private static void saveMenuToFile(Menu menu, String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject(menu);
        objectOutputStream.close();
    }

    private static Menu loadMenuFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Menu) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return null;
    }
}
