package week3.JTableEditIO;

import java.io.Serializable;
import java.util.ArrayList;

public class QuanLySach implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ArrayList<Sach> dsSach;

    public QuanLySach() {
        dsSach = new ArrayList<Sach>();
    }

    public Boolean themSach(Sach s) {
        if (dsSach.contains(s))
            return false;
        dsSach.add(s);
        return true;
    }

    public Boolean xoaSach(int index) {
        if (index < 0 || index > dsSach.size())
            return false;
        else {
            dsSach.remove(index);
            return true;
        }
    }

    public Sach getElement(int index) {
        if (index < 0 || index > dsSach.size())
            return null;
        return dsSach.get(index);
    }

    public int getSize() {
        return dsSach.size();
    }
}
