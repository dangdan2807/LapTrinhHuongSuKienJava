package TTNhanVien;

import java.io.Serializable;
import java.util.ArrayList;

public class NhanVien_Collection implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ArrayList<NhanVien> ds;

    public NhanVien_Collection() {
        ds = new ArrayList<NhanVien>();
    }

    public boolean themNhanVien(NhanVien nv) {
        if (ds.contains(nv)) {
            return false;
        }
        ds.add(nv);
        return true;
    }

    public boolean xoaNhanVien(String maNV) {
        NhanVien nv = new NhanVien(maNV);
        if (ds.contains(nv)) {
            ds.remove(nv);
            return true;
        }
        return false;
    }

    public NhanVien timKiem(String maNV) {
        NhanVien nv = new NhanVien(maNV);
        if (ds.contains(nv)) {
            return ds.get(ds.indexOf(nv));
        }
        return null;
    }

    public ArrayList<NhanVien> getDsNV() {
        return ds;
    }

    public void setDsNV(ArrayList<NhanVien> ds) {
        this.ds = ds;
    }

    public NhanVien getElement(int index) {
        if(index < 0 || index >= ds.size())
            return null;
        return ds.get(index);
    }

    public int getSize() {
        return ds.size();
    }
}
