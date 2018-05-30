package QuanLyKho;

import java.util.Scanner;

public class HoaDon {

	private String maHoaDon;
	private String maKho, maKhuVuc;
	private String tenHang;
	private int soLuongXuat;
	
	public void NhapHoaDon(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap ma hoa don: ");
		maHoaDon = sc.nextLine();
		
		System.out.println("Nhap so Luong Xuat: ");
		soLuongXuat = sc.nextInt();
		sc.nextLine();
	}
	
	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public String XuatHoaDon(){
		return String.format("%-10s|%-10s|%-10s|%-10s|%-10s", 
				maHoaDon,maKho,maKhuVuc,tenHang,soLuongXuat);
	}

	
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
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
	
	public int getSoLuongXuat() {
		return soLuongXuat;
	}
	public void setSoLuongXuat(int soLuongXuat) {
		this.soLuongXuat = soLuongXuat;
	}
	public HoaDon(String maHoaDon, String maKho, String maKhuVuc, String tenHang, int soLuongXuat) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKho = maKho;
		this.maKhuVuc = maKhuVuc;
		this.tenHang = tenHang;
		this.soLuongXuat = soLuongXuat;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
