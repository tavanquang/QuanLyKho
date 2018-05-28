package QuanLyKho;

import java.util.Scanner;

public class HangHoa {

	protected String maHang;
	protected String tenHang;
	protected double giaTien;
	private int soLuong;
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	private String maKhuVuc;
	
	public String getMaKhuVuc() {
		return maKhuVuc;
	}
	public void setMaKhuVuc(String maKhuVuc) {
		this.maKhuVuc = maKhuVuc;
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
	
	public HangHoa(String maKhuVuc) {
		this.maKhuVuc = maKhuVuc;
	}
	
	public void NhapThongTinHangHoa(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap ma hang: ");
		maHang = sc.nextLine();
		
		System.out.println("Nhap ten hang: ");
		tenHang = sc.nextLine();
		
		System.out.println("Nhap gia tien: ");
		giaTien = sc.nextDouble();
		
		System.out.println("Nhap so Luong: ");
		soLuong = sc.nextInt();
	}
	
	public String XuatThongTinHangHoa(){
		
		return String.format("%-10s|%-20s|%-15s|", maHang,tenHang,giaTien);
		
	}
	
}
