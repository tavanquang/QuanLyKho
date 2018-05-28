package QuanLyKho;

import java.util.Scanner;

public class ManHinh extends HangHoa{

	private String kichThuoc;
	private String doPhanGiai;
	
	public void NhapThongTinHangHoa() {
		super.NhapThongTinHangHoa();

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap kich Thuoc: ");
		kichThuoc = sc.nextLine();

		System.out.println("Nhap do Phan Giai: ");
		doPhanGiai = sc.nextLine();

	}

	public String XuatThongTinHangHoa() {

		return super.XuatThongTinHangHoa() + String.format("%-10s|%-10s", kichThuoc, doPhanGiai);

	}
	
	public String getKichThuoc() {
		return kichThuoc;
	}
	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}
	public String getDoPhanGiai() {
		return doPhanGiai;
	}
	public void setDoPhanGiai(String doPhanGiai) {
		this.doPhanGiai = doPhanGiai;
	}
	
	
	
}
