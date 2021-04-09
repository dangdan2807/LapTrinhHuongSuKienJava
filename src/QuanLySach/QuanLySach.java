package QuanLySach;

import java.io.IOException;
import java.util.ArrayList;

public class QuanLySach {
    ArrayList<Sach> ds;

    public QuanLySach() {
        ds = new ArrayList<Sach>();
    }

    public ArrayList<Sach> getDS() {
        return ds;
    }

    public void docDuLieuTuFile() throws IOException {
        ds = LuuTru_Character.DocFile();
    }

    public boolean themSach(Sach s) {
        if (ds.contains(s)) {
            return false;
        }
        ds.add(s);
        return true;
    }

    public boolean xoaSach(int index) {
        if (index < 0 || index >= ds.size()) {
            return false;
        }
        ds.remove(index);
        return true;
    }

    public Sach getElement(int index) {
        if (index < 0 || index >= ds.size()) {
            return null;
        }
        return ds.get(index);
    }

    public int getSize() {
        return ds.size();
    }
}
