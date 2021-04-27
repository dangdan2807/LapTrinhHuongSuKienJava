package QuanLySach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LuuTru_Character {
//    public static final String WORKING_DIR = System.getProperty("user.dir") + "/src/QuanLySach/data";
//    public static final String FILENAME = WORKING_DIR + "/DanhMucSach.txt";
    public static final String FILENAME = "data/DanhMucSach.txt";

    public void LuuFile(ArrayList<Sach> dsSach) {
        BufferedWriter bw;
        // tạo thư mục lưu
//        File f = new File(WORKING_DIR);
//        if (!f.exists()) {
//            f.mkdirs();
//        }

        try {
            bw = new BufferedWriter(new FileWriter(FILENAME));
            bw.write("");
            for (Sach sach : dsSach) {
                bw.write(sach.toString() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Sach> DocFile() throws IOException {
        ArrayList<Sach> ds = new ArrayList<Sach>();
        BufferedReader br = null;
//        File f = new File(WORKING_DIR);
//        if (!f.exists()) {
//            f.mkdirs();
//        }
        if (new File(FILENAME).exists()) {
            br = new BufferedReader(new FileReader(FILENAME));
            while (br.ready()) {
                String line = br.readLine();
                String[] s = line.split(";");
                int namSX = Integer.parseInt(s[3]);
                int soTrang = Integer.parseInt(s[5]);
                double donGia = Double.parseDouble(s[6]);
                Sach sach = new Sach(s[0], s[1], s[2], namSX, s[4], soTrang, donGia, s[7]);
                ds.add(sach);
            }
            br.close();
        }
        return ds;
    }
}
