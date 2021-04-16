package regex;

import java.util.*;

public class email {
    static Scanner input = new Scanner(System.in);

    public static String Input() {
        String str = "";
        boolean check = false;
        while (!check) {
            input = new Scanner(System.in);
            System.out.print("Nhập địa chỉ email: ");
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
        String email = Input();

        boolean check = email.matches("^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
        if(check) {
            System.out.println("Email hợp lệ");
        }
        else {
            System.out.println("Email không hợp lệ");
        }
    }
}
