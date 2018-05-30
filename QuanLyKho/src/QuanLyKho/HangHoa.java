package QuanLyKho;

import java.util.Scanner;

public class HangHoa {

	protected String maHang;
	protected String tenHang;
	protected double giaTien;
	protected int soLuong;
	protected double dienTich;
	
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	public HangHoa(String maHang, String tenHang, double giaTien) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.giaTien = giaTien;
	}
	public HangHoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void NhapThongTinHangHoa(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap ma hang: ");
		maHang = sc.nextLine();
		
		System.out.println("Nhap gia tien: ");
		giaTien = sc.nextDouble();
		
		System.out.println("Nhap so Luong: ");
		soLuong = sc.nextInt();
		
	}
	
	public double getTongDienTichHangNhapVao(){
		return dienTich * soLuong;
	}
	
	public String XuatThongTinHangHoa(){
		
		return String.format("%-10s|%-20s|%-15s|", maHang,tenHang,giaTien);
		
	}
	
}
