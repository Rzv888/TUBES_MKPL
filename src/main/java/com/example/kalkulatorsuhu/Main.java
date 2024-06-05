package com.example.kalkulatorsuhu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String suhu;
        boolean run = true;
        
        while (run) {
            System.out.println("SATUAN SUHU:");
            System.out.println("1. Celcius");
            System.out.println("2. Kelvin");
            System.out.println("3. Fahrenheit");
            System.out.println("4. Keluar");
            System.out.print("Masukkan satuan suhu awal: ");
            int pilihanSuhu = scanner.nextInt();
            if (pilihanSuhu == 1) {
                suhu = "Celcius";
            } else if (pilihanSuhu == 2) {
                suhu = "Kelvin";
            } else if (pilihanSuhu == 3) {
                suhu = "Fahrenheit";
            } else if (pilihanSuhu == 4) {
                break;
            } else {
                System.out.println("Pilihan suhu tidak valid, silahkan pilih lagi!");
                continue;
            }

            System.out.print("Masukkan tinggi suhu: ");
            int tinggiSuhu = scanner.nextInt();
            KalkulatorSuhu kalkulator = new KalkulatorSuhu(tinggiSuhu, suhu);

            while (run) {
                System.out.println("Pilihan Menu:");
                System.out.println("1. Lihat suhu sekarang");
                System.out.println("2. Ganti suhu sekarang");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");
                int menu = scanner.nextInt();

                switch (menu) {
                    case 1:
                        System.out.println("// Lihat suhu sekarang");
                        break;
                    case 2:
                        System.out.println("// Ganti suhu sekarang");
                        break;
                    case 3:
                        run = false;
                        break;
                    default:
                        System.out.println("Pilihan menu salah, silahkan masukkan ulang!");
                        break;
                }
            }
        }

        scanner.close();




    }
}