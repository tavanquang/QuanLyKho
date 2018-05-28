package QuanLyKho;

import java.util.Scanner;

public class KhuVuc {

	private String maKhuVuc;
	private String tenKhuVuc;
	private double dienTich;
	private String matHangLuuTru;
	private int soLuong = 0;
	private String maKho;
	
	
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	
	public String getMaKho() {
		return maKho;
	}
	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}
	public String getMaKhuVuc() {
		return maKhuVuc;
	}
	public void setMaKhuVuc(String maKhuVuc) {
		this.maKhuVuc = maKhuVuc;
	}
	public String getTenKhuVuc() {
		return tenKhuVuc;
	}
	public void setTenKhuVuc(String tenKhuVuc) {
		this.tenKhuVuc = tenKhuVuc;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	
	public KhuVuc(String maKhuVuc, String tenKhuVuc, double dienTich) {
		super();
		this.maKhuVuc = maKhuVuc;
		this.tenKhuVuc = tenKhuVuc;
		this.dienTich = dienTich;
	}
	
	public KhuVuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KhuVuc(String maKhuVuc) {
		this.maKhuVuc = maKhuVuc;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKhuVuc == null) ? 0 : maKhuVuc.hashCode());
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
		KhuVuc other = (KhuVuc) obj;
		if (maKhuVuc == null) {
			if (other.maKhuVuc != null)
				return false;
		} else if (!maKhuVuc.equals(other.maKhuVuc))
			return false;
		return true;
	}
	public void NhapThongTinhKhuVuc() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhap ma Khu Vuc: ");
		maKhuVuc = sc.nextLine();
		
		System.out.println("Nhap ten Khu Vuc: ");
		tenKhuVuc = sc.nextLine();
		
		System.out.println("Nhap mat Hang Luu Tru: ");
		matHangLuuTru = sc.nextLine();
		
	}
	
	public String getMatHangLuuTru() {
		return matHangLuuTru;
	}
	public void setMatHangLuuTru(String matHangLuuTru) {
		this.matHangLuuTru = matHangLuuTru;
	}
	public String XuatThongTinKhuVuc() {

		return String.format("%-10s|%-20s|%-10s|%-20s|%-10s", maKhuVuc,tenKhuVuc,dienTich,matHangLuuTru,soLuong);
	}
	
	
}
