package onThi.src.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import onThi.src.entity.LopHoc;

public class LopHocDAO {
    private static LopHocDAO instance;

    public static LopHocDAO getInstance() {
        if (instance == null)
            instance = new LopHocDAO();
        return instance;
    }

    public ArrayList<LopHoc> getLopHocList() {
        ArrayList<LopHoc> dataList = new ArrayList<LopHoc>();
        String query = "select l.maLop, l.tenLop, l.SiSo, g.maGiaoVien, g.tenGiaoVien from dbo.LopHoc l, dbo.GiaoVien g Where l.maGiaoVien = g.maGiaoVien";
        ResultSet rs = DataProvider.getInstance().ExecuteQuery(query, null);
        try {
            while (rs.next()) {
                dataList.add(new LopHoc(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public ArrayList<LopHoc> getLopHocListByGiaoVienID(String maGiaoVien) {
        ArrayList<LopHoc> dataList = new ArrayList<LopHoc>();
        String query = "select l.maLop, l.tenLop, l.SiSo, g.maGiaoVien, g.tenGiaoVien from dbo.LopHoc l, dbo.GiaoVien g Where l.maGiaoVien = g.maGiaoVien AND g.maGiaoVien = ?";
        Object[] params = new Object[] { maGiaoVien };
        ResultSet rs = DataProvider.getInstance().ExecuteQuery(query, params);
        try {
            while (rs.next()) {
                dataList.add(new LopHoc(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public ArrayList<LopHoc> getLopHocListByID(String maLop) {
        ArrayList<LopHoc> dataList = new ArrayList<LopHoc>();
        String query = "select l.maLop, l.tenLop, l.SiSo, g.maGiaoVien, g.tenGiaoVien from dbo.LopHoc l, dbo.GiaoVien g Where l.maGiaoVien = g.maGiaoVien AND l.maLop like ?";
        Object[] params = new Object[] { "%" + maLop + "%" };
        ResultSet rs = DataProvider.getInstance().ExecuteQuery(query, params);
        try {
            while (rs.next()) {
                dataList.add(new LopHoc(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public boolean insert(LopHoc lp) {
        String query = "INSERT INTO dbo.LopHoc VALUES( ? , ? , ? , ?)";
        Object[] params = new Object[] { lp.getMaLop(), lp.getTenLop(), lp.getGiaoVien().getMaGiaoVien(),
                lp.getSiSo() };
        int result = DataProvider.getInstance().ExecuteNonQuery(query, params);
        return result > 0;
    }

    public boolean delete(String id) {
        String query = "DELETE dbo.LopHoc Where maLop = ?";
        Object[] params = new Object[] { id };
        int result = DataProvider.getInstance().ExecuteNonQuery(query, params);
        return result > 0;
    }

    public boolean update(LopHoc lp) {
        String query = "update dbo.LopHoc SET tenLop = ?, maGiaoVien = ? , siSo = ? Where maLop = ?";
        Object[] params = new Object[] { lp.getTenLop(), lp.getGiaoVien().getMaGiaoVien(), lp.getSiSo(),
                lp.getMaLop() };

        int result = DataProvider.getInstance().ExecuteNonQuery(query, params);
        return result > 0;
    }
}
