
package regex;

import java.util.Scanner;

public class bienSoXeMay {
    static Scanner input = new Scanner(System.in);

    public static String Input() {
        String str = "";
        boolean check = false;
        while (!check) {
            input = new Scanner(System.in);
            System.out.print("Nhập địa chỉ biển số: ");
            str = input.nextLine();
            if (str.equals("") || str.length() == 0) {
                System.out.println("Khong duoc rong !!!");
                check = false;
            } else
                check = true;
        }
        return str;
    }

    public static void main(String[] args) {
        String bienSo = Input();

        boolean check = bienSo.matches("^");
        if (check) {
            System.out.println("biển số hợp lệ");
        } else {
            System.out.println("biển số không hợp lệ");
        }
    }
}
