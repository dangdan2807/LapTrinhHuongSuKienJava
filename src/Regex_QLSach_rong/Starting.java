package Regex_QLSach_rong;

import javax.swing.SwingUtilities;

public class Starting {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				FrmDanhMucSach frm = new FrmDanhMucSach();
				frm.setVisible(true);
			}
		});
	}
}
