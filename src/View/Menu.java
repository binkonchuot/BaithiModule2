package View;

import java.util.Scanner;

public class Menu {
    public String menuChinh() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----CHUONG TRINH QUAN LY DANH BA----");
        System.out.println("Chon chuc nang theo so(De tiep tuc)");
        System.out.println("1.Xem danh sach ");
        System.out.println("2.Them moi");
        System.out.println("3.Cap nhat");
        System.out.println("4.Xoa");
        System.out.println("5.Sap xep");
        System.out.println("6.Doc tu file");
        System.out.println("7.Ghi vao file");
        System.out.println("8.Thoat");
        System.out.println("Chon chuc nang:");
        return scanner.nextLine();
    }
}
