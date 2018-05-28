package QuanLyKho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<KhoHang> listKhoHang = new ArrayList<KhoHang>();
	private static List<KhuVuc> listKhuVuc = new ArrayList<KhuVuc>();

	private static List<CPU> listCPU = new ArrayList<CPU>();
	private static List<BanPhim> listBanPhim = new ArrayList<BanPhim>();
	private static List<Chuot> listChuot = new ArrayList<Chuot>();
	private static List<ManHinh> listManHinh = new ArrayList<ManHinh>();

	private static List<HoaDon> listHoaDon = new ArrayList<HoaDon>();

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int luaChon = 0;
		
		boolean flag = true;
		do {
			System.out.println("--------- MENU --------");
			System.out.println("1. Them kho hang");
			System.out.println("2. Hien thi danh sach kho hang");
			System.out.println("3. Xem thong tin kho hang");
			System.out.println("4. Nhap hang");
			System.out.println("5. Xuat hang");
			System.out.println("6. Thong tin so luong hang trong kho");
			System.out.println("7. Thoat chuong trinh ! ");
			System.out.println("--> Moi ban lua chon ? ");
			try {

				luaChon = sc.nextInt();
				switch (luaChon) {
				case 1:
					NhapThongTinKhoHang();
					break;
				case 2:
					HienThiDanhSachKhoHang();
					XemMotKhoHang();
					break;
				case 3:
					HienThiDanhSachKhoHang();
					ThongTinKhuVucTrongMotKho();
					break;
				case 4:
					HienThiDanhSachKhoHang();
					XemMotKhoHang();
					NhapHang();
					break;
				case 5:
					XuatHang();
					break;
				case 6:
					ThongTinSoLuongHangTrongKho();
					break;
				case 7:
				default:
					flag = false;
					System.out.println("Dung chuong trinh !");
					break;
				}
			} catch (Exception e) {
				System.out.println("Error, Please Try Agian !");
				flag = true;
				sc.nextLine();
			}
		} while (flag == true);

	}
	
	public static void NhapThongTinKhoHang() {
		KhoHang khoHang = new KhoHang();
		khoHang.NhapThongTinKhoHang();
		if (listKhoHang.contains(khoHang)) {
			System.out.println("Ma kho dang ton tai, vui long nhap lai ");
		} else {
			listKhoHang.add(khoHang);

			for (int i = 0; i < khoHang.getSoKhuVuc(); i++) {
				System.out.println("Nhap thong tin khu vuc " + (i + 1) + ":");
				KhuVuc khuVuc = new KhuVuc();
				khuVuc.NhapThongTinhKhuVuc();
				listKhuVuc.add(khuVuc);
				khuVuc.setDienTich(khoHang.getDienTich() / khoHang.getSoKhuVuc());
				khuVuc.setMaKho(khoHang.getMaKho());
			}
		}

	}

	public static void HienThiDanhSachKhoHang() {
		System.out.println("================ DANH SACH KHO HANG ================");
		System.out.printf("%-10s|%-20s|%-10s|%-10s", "Ma Kho", "Ten Kho", "Dien Tich", "So Khu Vuc\n");
		System.out.println("------------------------------------------------------");
		for (KhoHang khoHang : listKhoHang) {
			System.out.println(khoHang.XuatThongTinKhoHang());
		}
		System.out.println("------------------------------------------------------");
	}

	public static void XemMotKhoHang() {
		boolean flag = false;
		System.out.println("\n============BAN CHON KHO HANG CAN XEM ===========");
		System.out.println("Nhap ma kho: ");
		sc.nextLine();
		String maKho = sc.nextLine();

		for (KhuVuc khuVuc : listKhuVuc) {
			if (khuVuc.getMaKho().equalsIgnoreCase(maKho)) {
				flag = true;
			}
		}

		if (flag) {
			System.out
					.println("\n\n======================= THONG TIN KHO HANG " + maKho + " =========================");
			System.out.printf("%-10s|%-20s|%-10s|%-20s|%-10s", "Ma Khu Vuc", "Ten Khu Vuc", "Dien Tich", "Mat Hang",
					"So Luong Hien Co");
			System.out.println("\n-----------------------------------------------------------------------------------");

			for (KhuVuc khuVuc : listKhuVuc) {
				if (khuVuc.getMaKho().equalsIgnoreCase(maKho)) {
					System.out.println(khuVuc.XuatThongTinKhuVuc());
					flag = true;
				}
			}
			System.out.println("-----------------------------------------------------------------------------------");
		}
		if (!flag) {
			System.out.println("Ma kho " + maKho + "khong ton tai !");
		}
	}

	public static void ThongTinKhuVucTrongMotKho() {

		System.out.println("\n============ THONG TIN KHO HANG ===========");
		System.out.println("Nhap ma kho: ");
		sc.nextLine();
		String maKho = sc.nextLine();
		
		int sokv = 0;
		int soKVtrong = 0;
		double dienTichConHienTai = 0;
		double dienTichBanDau = 0;
		for (KhoHang kho : listKhoHang) {
			if (kho.getMaKho().equalsIgnoreCase(maKho)) {
				dienTichBanDau = kho.getDienTich();
			}
		}
		double khVucCPU = 0;
		double khVucCHUOT = 0;
		double khVucBANPHIM = 0;
		double khVucMANHINH = 0;
		for (KhuVuc kh : listKhuVuc) {
			if (kh.getMaKho().equalsIgnoreCase(maKho)) {
				sokv++;
				if (kh.getSoLuong() == 0) {
					soKVtrong++;
				}

				String tenMatHang = kh.getMatHangLuuTru();

				if (tenMatHang.equalsIgnoreCase("CPU")) {
					khVucCPU += 1;
				} else if (tenMatHang.equalsIgnoreCase("CHUOT")) {
					khVucCHUOT += 0.1;
				} else if (tenMatHang.equalsIgnoreCase("BAN PHIM")) {
					khVucBANPHIM += 0.3;
				} else if (tenMatHang.equalsIgnoreCase("MAN HINH")) {
					khVucMANHINH += 0.5;
				}
				if(sokv == soKVtrong){
					dienTichConHienTai = dienTichBanDau;
				}else{
					dienTichConHienTai = dienTichBanDau - (khVucCPU + khVucCHUOT + khVucBANPHIM + khVucMANHINH);
					
				}
			}
		}

		System.out.println("-----------------------------------------------------");
		System.out.println("\n\n================= THONG TIN KHO HANG " + maKho + " =================");
		System.out.printf("%-25s|%-20s|%-20s", "Dien tich Con Hien Tai", "Khu Vuc Hien Co", "Khu Vuc Trong");
		System.out.println("\n-----------------------------------------------------------");
		System.out.printf("%-25s|%-20s|%-20s", dienTichConHienTai, sokv, soKVtrong);
		System.out.println("\n-------------------------------------------------------------");

	}

	public static void NhapHang() {
		System.out.println("Moi ban nhap ma khu vuc de luu tru ");
		boolean flag = true;
		String maKhuVuc = sc.nextLine();
		KhuVuc khuVuc = new KhuVuc(maKhuVuc);
		for (KhuVuc kv : listKhuVuc) {
			if (kv.getMaKhuVuc().equalsIgnoreCase(khuVuc.getMaKhuVuc())) {
				khuVuc.setTenKhuVuc(kv.getTenKhuVuc());
				khuVuc.setDienTich(kv.getDienTich());
				khuVuc.setMaKho(kv.getMaKho());
				khuVuc.setMatHangLuuTru(kv.getMatHangLuuTru());
				khuVuc.setSoLuong(kv.getSoLuong());
				flag = true;

				if (khuVuc.getMatHangLuuTru().equalsIgnoreCase("ban phim")) {
					BanPhim bp = new BanPhim();
					bp.NhapThongTinHangHoa();
					bp.setMaKhuVuc(maKhuVuc);
					khuVuc.setSoLuong(khuVuc.getSoLuong() + bp.getSoLuong());
					listBanPhim.add(bp);
					listKhuVuc.set(listKhuVuc.indexOf(kv), khuVuc);
				} else if (khuVuc.getMatHangLuuTru().equalsIgnoreCase("cpu")) {
					CPU cpu = new CPU();
					cpu.NhapThongTinHangHoa();
					cpu.setMaKhuVuc(maKhuVuc);
					listCPU.add(cpu);
					listKhuVuc.set(listKhuVuc.indexOf(kv), khuVuc);
					khuVuc.setSoLuong(khuVuc.getSoLuong() + cpu.getSoLuong());
				} else if (khuVuc.getMatHangLuuTru().equalsIgnoreCase("chuot")) {
					Chuot Chuot = new Chuot();
					Chuot.NhapThongTinHangHoa();
					Chuot.setMaKhuVuc(maKhuVuc);
					listChuot.add(Chuot);
					listKhuVuc.set(listKhuVuc.indexOf(kv), khuVuc);
					khuVuc.setSoLuong(khuVuc.getSoLuong() + Chuot.getSoLuong());
				} else if (khuVuc.getMatHangLuuTru().equalsIgnoreCase("man hinh")) {
					ManHinh manHinh = new ManHinh();
					manHinh.NhapThongTinHangHoa();
					manHinh.setMaKhuVuc(maKhuVuc);
					listManHinh.add(manHinh);
					khuVuc.setSoLuong(khuVuc.getSoLuong() + manHinh.getSoLuong());
					listKhuVuc.set(listKhuVuc.indexOf(kv), khuVuc);
				}

			}
		}

		if (!flag) {
			System.out.println("Ma khu vuc khong ton tai. ");
		}

	}

	public static void XuatHang() {
		
		System.out.println("================ DANH SACH KHO HANG ================");
		System.out.printf("%-10s|%-20s|%-10s|%-10s", "Ma Kho", "Ten Kho", "Dien Tich", "So Khu Vuc\n");
		System.out.println("------------------------------------------------------");
		for (KhoHang khoHang : listKhoHang) {
			System.out.println(khoHang.XuatThongTinKhoHang());
		}
		System.out.println("------------------------------------------------------");
	
		sc.nextLine();
		System.out.println("\n============ KHO HANG CAN XUAT ===========");
		System.out.println("Nhap ma kho: ");
		String maKho = sc.nextLine();
		
		System.out.println("\n\n======================= THONG TIN KHO HANG " + maKho + " =========================");
		System.out.printf("%-10s|%-20s|%-10s|%-20s|%-10s", "Ma Khu Vuc", "Ten Khu Vuc", "Dien Tich", "Mat Hang",
				"So Luong Hien Co");
		System.out.println("\n-----------------------------------------------------------------------------------");

		for (KhuVuc khuVuc : listKhuVuc) {
			if (khuVuc.getMaKho().equalsIgnoreCase(maKho)) {
				System.out.println(khuVuc.XuatThongTinKhuVuc());
			}
		}
		System.out.println("-----------------------------------------------------------------------------------");

		HoaDon hoadon = new HoaDon();
		hoadon.NhapHoaDon();
		hoadon.setMaKho(maKho);
		listHoaDon.add(hoadon);
		for (KhuVuc kh : listKhuVuc) {
			if (kh.getMaKhuVuc().equalsIgnoreCase(hoadon.getMaKhuVuc())) {
				kh.setSoLuong(kh.getSoLuong() - hoadon.getSoLuongXuat());
				listKhuVuc.set(listKhuVuc.indexOf(kh), kh);
			}
		}

	}

	public static void ThongTinSoLuongHangTrongKho() {

		HienThiDanhSachKhoHang();
		sc.nextLine();
		System.out.println("\nNhap ma kho de xem thong tin: ");
		String maKho = sc.nextLine();

		System.out.println("=========== Hoa Don Xuat Hang TRONG KHO: " + maKho + " ============");
		System.out.printf("%-10s|%-10s|%-10s|%-10s|%-10s", "maHoaDon", "maKho", "maKhuVuc", "ngayXuat",
				"soLuongXuat");
		System.out.println();
		for (HoaDon h : listHoaDon) {
			if (h.getMaKho().equalsIgnoreCase(maKho)) {
				System.out.println(h.XuatHoaDon());
			}
		}
		System.out.println("----------------------------------------------------------------");

		System.out.println(
				"\n\n======================= SO LUONG HANG CON TRONG KHO: " + maKho + " =========================");
		System.out.printf("%-10s|%-20s|%-10s|%-20s|%-10s", "Ma Khu Vuc", "Ten Khu Vuc", "Dien Tich", "Mat Hang",
				"So Luong Hien Co");
		System.out.println("\n-----------------------------------------------------------------------------------");

		for (KhuVuc khuVuc : listKhuVuc) {
			if (khuVuc.getMaKho().equalsIgnoreCase(maKho)) {
				System.out.println(khuVuc.XuatThongTinKhuVuc());
			}
		}
		System.out.println("-----------------------------------------------------------------------------------");

	}


	
}
