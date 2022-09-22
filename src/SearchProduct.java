import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchProduct {
    public static String[] products = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        testViewShowProductList();
    }

    /**
     * method logic untuk menampilkan seluruh data produk
     */
    public static void showAllProduct() {
        for (var product : products) {
            if (product != null) {
                System.out.println(" - " + product + " pcs ");
            }
        }
    }

    public static void testShowAllProduct() {
        products[0] = "Minyak Goreng";
        products[1] = "Kopi Hitam";

        showAllProduct();
    }

    public static void addProduct(String product, Integer stok) {
        var isFull = true;

        for (var i = 0; i < products.length; i++) {
            if (products[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            var temp = products;
            products = new String[products.length * 2];

            for (var i = 0; i < temp.length; i++) {
                products[i] = temp[i];
            }
        }

        for (var i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product + " - " + stok ;
                break;
            }
        }
    }

//    public static void testAddProduct() {
//        addProduct("Kopi White Coffee");
//        addProduct("Kopi Starbucks");
//        showAllProduct();
//    }

    public static void searchProduct(String search, int flag) {
        // Cek data untuk mencari data yang cocok
        System.out.println("====== Found Data Product ======");

        for (var i = 0; i < products.length; i++) {
            if (products[i] != null) {
                Pattern pattern = Pattern.compile(search, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(products[i]);
                boolean matchFound = matcher.find();

                if (matchFound) {
                    String item;
                    if(flag == 1) {
                        var data = products[i].split("-");
                        item = data[0];
                    }else {
                        item = products[i] + " pcs ";
                    }

                    System.out.println(" - " + item);
                }
            }
        }
        System.out.println("====== ************** ======");
    }

//    public static void testSearchProduct() {
//        addProduct("Kopi White Coffee");
//        addProduct("Kopi Starbucks");
//        addProduct("Tubruk Kopi");
//        addProduct("Java");
//        searchProduct("Tubruk");
//    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var input = input("Masukkan data");
        System.out.println("data ini adalah " + input);
    }
    /**
     * method untuk menampilkan tampilan awal
     */
    public static void viewShowProductList() {
        while (true) {
            System.out.println("PRODUCT");

            showAllProduct();

            System.out.println("Menu :");
            System.out.println("1. Tambah Product");
            System.out.println("2. Cari Product");
            System.out.println("3. Cari Stok (nama produk)");
            System.out.println("x. Keluar");

            var input = input("Masukkan pilihan");

            if (input.equals("1")) {
                viewAddProduct();
            } else if (input.equals("2") || input.equals("3")) {
                var flag = input.equals("2") ? 1 : 0;
                viewSearchProduct(flag);
            }else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowProductList() {
        viewShowProductList();
    }

    /**
     * method untuk view tambah product
     */
    public static void viewAddProduct() {
        System.out.println("====== TAMBAH PRODUK ======");
        var product = input("Nama Product: ");
        var stok = input("Stok: ");
        addProduct(product, Integer.valueOf(stok));
        System.out.println("====== ************** ======");
    }

    public static void testViewAddProduct() {
        viewAddProduct();
    }

    /**
     * method untuk view search product
     */
    public static void viewSearchProduct(int flag) {
        // flag 1: search product, 0: search product + stok
        System.out.println("====== CARI PRODUK ======");

        var search = input("Masukkan kata pencarian: ");
        searchProduct(search, flag);
    }

//    public static void testViewSearchProduct() {
//        addProduct("Kopi Starbucks Mocha");
//        addProduct("Minyak Goreng");
//        addProduct("Indomie Goreng Ayam Geprek");
//        showAllProduct();
//        viewSearchProduct();
//    }


}
