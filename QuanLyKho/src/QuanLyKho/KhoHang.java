package QuanLyKho;

import java.util.Scanner;

public class KhoHang {
	private String maKho;
	private String tenKho;
	private int chieuDai;
	private int chieuRong;
	private int soKhuVuc;
	private double dienTich;

	public String getMaKho() {
		return maKho;
	}

	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}

	public String getTenKho() {
		return tenKho;
	}

	public void setTenKho(String tenKho) {
		this.tenKho = tenKho;
	}

	public int getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(int chieuDai) {
		if (chieuDai >= 0) {
			this.chieuDai = chieuDai;
		} else {
			System.out.println("Nhap lai chieu dai phai > 0: ");
		}

	}

	public int getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(int chieuRong) {
		if (chieuRong >= 0) {
			this.chieuRong = chieuRong;
		} else {
			System.out.println("Nhap lai chieu Rong phai > 0: ");
		}
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	public KhoHang() {
	}

	
	public KhoHang(String maKho, String tenKho, int chieuDai, int chieuRong, int soKhuVuc, double dienTich) {
		super();
		this.maKho = maKho;
		this.tenKho = tenKho;
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
		this.soKhuVuc = soKhuVuc;
		this.dienTich = dienTich;
	}

	public void NhapThongTinKhoHang() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhap ma Kho: ");
		maKho = sc.nextLine();
		
		System.out.println("Nhap ten Kho: ");
		tenKho = sc.nextLine();
		
		System.out.println("Nhap chieu Dai: ");
		chieuDai = sc.nextInt();
		
		System.out.println("Nhap chieu Rong: ");
		chieuRong = sc.nextInt();
		
		System.out.println("Nhap so Khu Vuc: ");
		soKhuVuc = sc.nextInt();
		
		dienTich = chieuDai * chieuRong;
	}
	
	public String XuatThongTinKhoHang() {

		return String.format("%-10s|%-20s|%-10s|%-10s", maKho,tenKho,dienTich,soKhuVuc);
	}

	public int getSoKhuVuc() {
		return soKhuVuc;
	}

	public void setSoKhuVuc(int soKhuVuc) {
		if(soKhuVuc > 0){
			this.soKhuVuc = soKhuVuc;
		}else{
			System.out.println("So khu vuc phai lon hon 0");
		}
		
	}
	

}
