package TTNhanVien;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LuuTru {
    public Object DocFile(String path) throws Exception {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
        Object o = input.readObject();
        input.close();
        return o;
    }

    public Boolean LuuFile(Object obj, String path) throws Exception {
        ObjectOutputStream output = null;
        output = new ObjectOutputStream(new FileOutputStream(path));
        // xoá trắng file
        // tạo file mới khi không có file
        output.writeBytes("");
        // ghi file
        output.writeObject(obj);

        output.flush();
        output.close();
        return true;
    }
}
