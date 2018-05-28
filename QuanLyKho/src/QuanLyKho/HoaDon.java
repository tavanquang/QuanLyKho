package QuanLyKho;

import java.util.Scanner;

public class HoaDon {

	private String maHoaDon;
	private String maKho, maKhuVuc;
	private String ngayXuat;
	private int soLuongXuat;
	
	
	public void NhapHoaDon(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap ma hoa don: ");
		maHoaDon = sc.nextLine();
		
		System.out.println("Nhap ma Khu Vuc: ");
		maKhuVuc = sc.nextLine();
		
		System.out.println("Nhap so Luong Xuat: ");
		soLuongXuat = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhap ngay Xuat: ");
		ngayXuat =  sc.nextLine();
		
	}
	
	public String XuatHoaDon(){
		return String.format("%-10s|%-10s|%-10s|%-10s|%-10s", 
				maHoaDon,maKho,maKhuVuc,ngayXuat,soLuongXuat);
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
	public String getNgayXuat() {
		return ngayXuat;
	}
	public void setNgayXuat(String ngayXuat) {
		this.ngayXuat = ngayXuat;
	}
	public int getSoLuongXuat() {
		return soLuongXuat;
	}
	public void setSoLuongXuat(int soLuongXuat) {
		this.soLuongXuat = soLuongXuat;
	}
	public HoaDon(String maHoaDon, String maKho, String maKhuVuc, String ngayXuat, int soLuongXuat) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKho = maKho;
		this.maKhuVuc = maKhuVuc;
		this.ngayXuat = ngayXuat;
		this.soLuongXuat = soLuongXuat;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
