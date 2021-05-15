package TTNhanVienSQL.entity;

public class PhongBan {
    private String maPB;
    private String tenPB;

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public PhongBan(String maPB, String tenPB) {
        this.maPB = maPB;
        this.tenPB = tenPB;
    }

    public PhongBan(String maPB) {
        this.maPB = maPB;
        this.tenPB = "Chưa cập nhật";
    }

    public PhongBan() {
        this("000", "Chưa cập nhật");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maPB == null) ? 0 : maPB.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhongBan other = (PhongBan) obj;
        if (maPB == null) {
            if (other.maPB != null)
                return false;
        } else if (!maPB.equals(other.maPB))
            return false;
        return true;
    }

    
}
