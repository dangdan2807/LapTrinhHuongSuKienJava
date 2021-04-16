package regex;

import java.util.Scanner;

public class ipv4 {
    static Scanner input = new Scanner(System.in);

    public static String Input() {
        String str = "";
        boolean check = false;
        while (!check) {
            input = new Scanner(System.in);
            System.out.print("Nhập địa chỉ ip: ");
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
        String ip = Input();

        boolean check = ip.matches("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        if(check) {
            System.out.println("IP hợp lệ");
        }
        else {
            System.out.println("IP không hợp lệ");
        }
    }
}
