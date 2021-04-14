package Bai1_IO_QLSach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class Database {
	private static final String FILENAME = "data/DuLieu.txt";

	/**
	 * Ghi danh sach các cuốn sách xuống File (duLieu.txt)
	 * @param dsSach
	 */

	public static void ghiXuongFile(ArrayList<Sach> dsSach) {
		BufferedWriter bw ;
		try{
			bw = new BufferedWriter(new FileWriter(FILENAME));
			//Ghi dòng tiêu đề cột
			bw.write("MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN\n");
			//Ghi lần lượt từng cuốn sách cho đến khi hết
			for(Sach s : dsSach){
				bw.write(s.toString() + "\n");
			}
			bw.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/**
	 * Đọc danh sách các cuốn sách từ file (data/dulieu.txt) 
	 * Nếu file đã tồn tại
	 * @return ArrayList<Sach>
	 */
	public static ArrayList<Sach> docTuFile() {
		ArrayList<Sach> dsSach = new ArrayList<Sach>(10);
		BufferedReader br = null;
		try{
			if(new File(FILENAME).exists()){
				br  = new BufferedReader(new FileReader(FILENAME));
				//Bỏ qua dòng tiêu đề cột
				br.readLine();
				//Đọc từng line, xử lý chuỗi và chuyển thành cuốn sách
				while(br.ready()){
					String line = br.readLine();
					if(line != null && !line.trim().equals("")){
						String[] a = line.split(";");
						Sach s = new Sach(a[0], a[1], a[2],
								Integer.parseInt(a[3]), 
								a[4], Integer.parseInt(a[5]),
								Double.parseDouble(a[6]), a[7]);
						dsSach.add(s);
					}
				}
				br.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return dsSach;
	}
}
