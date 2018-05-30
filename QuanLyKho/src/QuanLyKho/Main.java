package QuanLyKho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<KhoHang> listKhoHang = new ArrayList<KhoHang>();
	// private static List<KhuVuc> listKhuVuc = new ArrayList<KhuVuc>();

	/*
	 * private static List<CPU> listCPU = new ArrayList<CPU>(); private static
	 * List<BanPhim> listBanPhim = new ArrayList<BanPhim>(); private static
	 * List<Chuot> listChuot = new ArrayList<Chuot>(); private static
	 * List<ManHinh> listManHinh = new ArrayList<ManHinh>();
	 */

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int luaChon = 0;

		boolean flag = true;
		do {
			System.out.println("--------- MENU --------");
			System.out.println("1. Them kho hang");
			System.out.println("2. Hien thi danh sach kho hang");
			System.out.println("3. Them khu vuc");
			System.out.println("4. Hien thi danh sach khu vuc");
			System.out.println("5. Them hang");
			System.out.println("6. Xuat Hang");
			System.out.println("7. So luong hang trong kho con bao nhieu ! ");
			System.out.println("8. Thoat chuong trinh ! ");
			System.out.println("--> Moi ban lua chon ? ");
			try {

				luaChon = sc.nextInt();
				switch (luaChon) {
				case 1:
					NhapThongTinKhoHang();
					break;
				case 2:
					HienThiDanhSachKhoHang();
					break;
				case 3:
					ThemKhuVuc();
					break;
				case 4:
					HienThiDSKhuVuc();
					break;
				case 5:
					ThemHangHoa();
					break;
				case 6:XuatHang();
					break;
				case 7:	QuanLyTonKho();
					break;
				
				case 8:
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
		listKhoHang.add(khoHang);
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

	public static void ThemKhuVuc() {
		HienThiDanhSachKhoHang();

		System.out.println("--> Chon kho hang de them: ");
		sc.nextLine();
		String maKho = sc.nextLine();
		List<KhuVuc> listKhuVuc = new ArrayList<>();
		for (KhoHang kh : listKhoHang) {
			if (kh.getMaKho().equalsIgnoreCase(maKho)) {
				int soKhu = kh.getSoKhuVuc();
				if (soKhu == kh.getKhuVucs().size()) {
					System.out.println("Kho nay da nhap khu vuc roi: ");
				} else {
					for (int i = 0; i < soKhu; i++) {

						KhuVuc kv = new KhuVuc();
						System.out.println("Nhap thong tin khu vuc " + (i + 1) + ": ");
						kv.NhapThongTinhKhuVuc();
						kv.setDienTich(kh.getDienTich() / soKhu);
						listKhuVuc.add(kv);

					}
					kh.setKhuVucs(listKhuVuc);
					listKhoHang.set(listKhoHang.indexOf(kh), kh);
				}
			}
		}
	}

	public static void HienThiDSKhuVuc() {
		HienThiDanhSachKhoHang();
		System.out.println("--> Chon kho hang de hien thi: ");
		sc.nextLine();
		String maKho = sc.nextLine();
		boolean flag = false;
		for (KhoHang kh : listKhoHang) {
			if (kh.getMaKho().equalsIgnoreCase(maKho)) {
				for (KhuVuc khuvuc : kh.getKhuVucs()) {
					flag = true;
				}
				if (flag) {
					System.out.println(
							"\n\n======================= THONG TIN KHO HANG " + maKho + " =========================");
					System.out.printf("%-10s|%-20s|%-10s|%-20s|%-10s", "Ma Khu Vuc", "Ten Khu Vuc", "Dien Tich",
							"Mat Hang", "So Luong Hien Co");
					System.out.println(
							"\n-----------------------------------------------------------------------------------");

					for (KhuVuc khuvuc : kh.getKhuVucs()) {
						System.out.println(khuvuc.XuatThongTinKhuVuc());
						flag = true;
					}
					System.out.println(
							"-----------------------------------------------------------------------------------");
				} else {
					System.out.println("Kho " + maKho + " chua tao khu vuc !");
					flag = true;
					break;
				}
			}
		}
		if (!flag) {
			System.out.println("Ma kho " + maKho + "khong ton tai !");
		}
	}

	public static void ThemHangHoa(){
		HienThiDanhSachKhoHang();
		System.out.println("--> Chon kho hang de hien thi: ");
		sc.nextLine();
		String maKho = sc.nextLine();
		
		System.out.println(" --- DANH SACH HANG HOA ---");
		System.out.println("1. MAN HINH");
		System.out.println("2. BAN PHIM");
		System.out.println("3. CPU");
		System.out.println("4. CHUOT");
		System.out.println("--> Nhap ten mat hang can them vao kho:");
		String tenMH = "";
		int luaChon = sc.nextInt();
		
		if(luaChon == 1){
			tenMH = "MAN HINH";
		}else if(luaChon == 2){
			tenMH = "BAN PHIM";
		}else if(luaChon == 3){
			tenMH = "CPU";
		}else if(luaChon == 4){
			tenMH = "CHUOT";
		}
		
		boolean flag = false;
		for(KhoHang khohang : listKhoHang){
			if(khohang.getMaKho().endsWith(maKho)){
				for(KhuVuc khuvuc : khohang.getKhuVucs()){
					if(khuvuc.getMatHangLuuTru().equalsIgnoreCase(tenMH)){
						flag = true;
						List<HangHoa> listHangHoa = new ArrayList<>();
						if(tenMH.equalsIgnoreCase("MAN HINH")){
							ManHinh ManHinh = new ManHinh();
							ManHinh.NhapThongTinHangHoa();
							ManHinh.setDienTich(0.3);
							ManHinh.setTenHang(tenMH);
	
							double dientTichConTrongDeLuuHang = khuvuc.getDienTich()
									- (khuvuc.getSoLuong() * ManHinh.getDienTich());
							if (ManHinh.getTongDienTichHangNhapVao() > dientTichConTrongDeLuuHang) {
								System.out.println("So Luong hang qua lon, khong the luu vao kho !");
							} else {
								listHangHoa.add(ManHinh);
								khuvuc.setSoLuong(khuvuc.getSoLuong() + ManHinh.getSoLuong());
								khuvuc.setHangHoas(listHangHoa);
								khuvuc.setDienTich(dientTichConTrongDeLuuHang - ManHinh.getTongDienTichHangNhapVao());
								
								listKhoHang.set(listKhoHang.indexOf(khohang), khohang);
								System.out.println("Nhap hang vao kho thanh cong !");
							}
						} else if(tenMH.equalsIgnoreCase("BAN PHIM")){
							BanPhim BanPhim = new BanPhim();
							BanPhim.NhapThongTinHangHoa();
							BanPhim.setDienTich(0.2);
							BanPhim.setTenHang(tenMH);
	
							double dientTichConTrongDeLuuHang = khuvuc.getDienTich()
									- (khuvuc.getSoLuong() * BanPhim.getDienTich());
							if (BanPhim.getTongDienTichHangNhapVao() > dientTichConTrongDeLuuHang) {
								System.out.println("So Luong hang qua lon, khong the luu vao kho !");
							} else {
								listHangHoa.add(BanPhim);
								khuvuc.setSoLuong(khuvuc.getSoLuong() + BanPhim.getSoLuong());
								khuvuc.setHangHoas(listHangHoa);
								khuvuc.setDienTich(dientTichConTrongDeLuuHang - BanPhim.getTongDienTichHangNhapVao());
								
								listKhoHang.set(listKhoHang.indexOf(khohang), khohang);
								System.out.println("Nhap hang vao kho thanh cong !");
							}
							
						}else if(tenMH.equalsIgnoreCase("CPU")){
							CPU CPU = new CPU();
							CPU.NhapThongTinHangHoa();
							CPU.setDienTich(0.5);
							CPU.setTenHang(tenMH);
	
							double dientTichConTrongDeLuuHang = khuvuc.getDienTich()
									- (khuvuc.getSoLuong() * CPU.getDienTich());
							if (CPU.getTongDienTichHangNhapVao() > dientTichConTrongDeLuuHang) {
								System.out.println("So Luong hang qua lon, khong the luu vao kho !");
							} else {
								listHangHoa.add(CPU);
								khuvuc.setSoLuong(khuvuc.getSoLuong() + CPU.getSoLuong());
								khuvuc.setHangHoas(listHangHoa);
								khuvuc.setDienTich(dientTichConTrongDeLuuHang - CPU.getTongDienTichHangNhapVao());
								
								listKhoHang.set(listKhoHang.indexOf(khohang), khohang);
								System.out.println("Nhap hang vao kho thanh cong !");
							}
							
						}else if(tenMH.equalsIgnoreCase("CHUOT")){
							Chuot Chuot = new Chuot();
							Chuot.NhapThongTinHangHoa();
							Chuot.setDienTich(0.2);
							Chuot.setTenHang(tenMH);
	
							double dientTichConTrongDeLuuHang = khuvuc.getDienTich()
									- (khuvuc.getSoLuong() * Chuot.getDienTich());
							if (Chuot.getTongDienTichHangNhapVao() > dientTichConTrongDeLuuHang) {
								System.out.println("So Luong hang qua lon, khong the luu vao kho !");
							} else {
								listHangHoa.add(Chuot);
								khuvuc.setSoLuong(khuvuc.getSoLuong() + Chuot.getSoLuong());
								khuvuc.setHangHoas(listHangHoa);
								khuvuc.setDienTich(dientTichConTrongDeLuuHang - Chuot.getTongDienTichHangNhapVao());
								
								listKhoHang.set(listKhoHang.indexOf(khohang), khohang);
								System.out.println("Nhap hang vao kho thanh cong !");
							}
							
						}
					}
				}
				if(!flag){
					System.out.println("Mat hang ban chon khong co trong kho !");
				}
			}
		}
		
	}
	
	
	public static void XuatHang() {
		
		HienThiDanhSachKhoHang();

		System.out.println("--> Chon kho hang de them: ");
		sc.nextLine();
		String maKho = sc.nextLine();
		int dem = 0;
		boolean flag = false;
		List<HoaDon> listHoaDon = new ArrayList<>();
		for (KhoHang kh : listKhoHang) {
			if (kh.getMaKho().equalsIgnoreCase(maKho)) {
				flag = true;
				if (kh.getKhuVucs().size() != 0) {
					System.out.println("-- DANH SACH MAT HANG --");

					for (KhuVuc khuvuc : kh.getKhuVucs()) {
						dem++;
						System.out.println(dem + " - " + khuvuc.getMatHangLuuTru());
					}

					System.out.println("--> Chon mat hang can xuat: ");

					int luaChon = sc.nextInt();
					int index = 0;
					if (luaChon == 1) {
						XuatHangTrongKhoTheoTruongHop(0,maKho,kh,listHoaDon);
					} else if (luaChon == 2) {
						XuatHangTrongKhoTheoTruongHop(1,maKho,kh,listHoaDon);
					} else if (luaChon == 3) {
						XuatHangTrongKhoTheoTruongHop(2,maKho,kh,listHoaDon);
					} else if (luaChon == 4) {
						XuatHangTrongKhoTheoTruongHop(3,maKho,kh,listHoaDon);
					}
				} else {
					System.out.println("Trong kho " + maKho + " chua co mat hang nao !");
				}

			}
		}
		
		if(!flag){
			System.out.println("Ma kho " + maKho + " khong tin thay !");
		}
	}
	
	public static void XuatHangTrongKhoTheoTruongHop(int index,String maKho, KhoHang kh, List<HoaDon> listHoaDon){
		if (kh.getKhuVucs().get(index).getMatHangLuuTru().equalsIgnoreCase("BAN PHIM")) {
			HoaDon hoaDon = new HoaDon();
			hoaDon.NhapHoaDon();
			hoaDon.setMaKho(maKho);
			hoaDon.setMaKhuVuc(kh.getKhuVucs().get(index).getMaKhuVuc());
			hoaDon.setTenHang(kh.getKhuVucs().get(index).getMatHangLuuTru());
			
			int soLuongHangSauKhiXuat = kh.getKhuVucs().get(index).getSoLuong() - hoaDon.getSoLuongXuat();
			
			if(soLuongHangSauKhiXuat < 0){
				System.out.println("- So luong hang trong khong du");
				System.out.println("- So luong hang trong kho con: " + kh.getKhuVucs().get(index).getSoLuong());
			}else if(soLuongHangSauKhiXuat > 0){
				System.out.println("- Xuat hang thanh cong");
				System.out.println("- So luong hang trong kho con lai sau khi xuat: " + soLuongHangSauKhiXuat);
				listHoaDon.add(hoaDon);
				kh.setHoaDons(listHoaDon);
				kh.getKhuVucs().get(index).setSoLuong(soLuongHangSauKhiXuat);
				listKhoHang.set(listKhoHang.indexOf(kh), kh);
			}else {
				System.out.println("- Xuat hang thanh cong");
				System.out.println("- So luong hang trong kho con lai sau khi xuat: 0 ");
				listHoaDon.add(hoaDon);
				kh.setHoaDons(listHoaDon);
				kh.getKhuVucs().get(index).setSoLuong(0);
				listKhoHang.set(listKhoHang.indexOf(kh), kh);
			}
				
		}else if (kh.getKhuVucs().get(index).getMatHangLuuTru().equalsIgnoreCase("CHUOT")) {
			HoaDon hoaDon = new HoaDon();
			hoaDon.NhapHoaDon();
			hoaDon.setMaKho(maKho);
			hoaDon.setMaKhuVuc(kh.getKhuVucs().get(index).getMaKhuVuc());
			hoaDon.setTenHang(kh.getKhuVucs().get(index).getMatHangLuuTru());
			
			int soLuongHangSauKhiXuat = kh.getKhuVucs().get(index).getSoLuong() - hoaDon.getSoLuongXuat();
			
			if(soLuongHangSauKhiXuat < 0){
				System.out.println("- So luong hang trong khong du");
				System.out.println("- So luong hang trong kho con: " + kh.getKhuVucs().get(index).getSoLuong());
			}else if(soLuongHangSauKhiXuat > 0){
				System.out.println("- Xuat hang thanh cong");
				System.out.println("- So luong hang trong kho con lai sau khi xuat: " + soLuongHangSauKhiXuat);
				listHoaDon.add(hoaDon);
				kh.setHoaDons(listHoaDon);
				kh.getKhuVucs().get(index).setSoLuong(soLuongHangSauKhiXuat);
				listKhoHang.set(listKhoHang.indexOf(kh), kh);
			}else {
				System.out.println("- Xuat hang thanh cong");
				System.out.println("- So luong hang trong kho con lai sau khi xuat: 0 ");
				listHoaDon.add(hoaDon);
				kh.setHoaDons(listHoaDon);
				kh.getKhuVucs().get(index).setSoLuong(0);
				listKhoHang.set(listKhoHang.indexOf(kh), kh);
			}
		}else if (kh.getKhuVucs().get(index).getMatHangLuuTru().equalsIgnoreCase("MAN HINH")) {
			HoaDon hoaDon = new HoaDon();
			hoaDon.NhapHoaDon();
			hoaDon.setMaKho(maKho);
			hoaDon.setMaKhuVuc(kh.getKhuVucs().get(index).getMaKhuVuc());
			hoaDon.setTenHang(kh.getKhuVucs().get(index).getMatHangLuuTru());
			
			int soLuongHangSauKhiXuat = kh.getKhuVucs().get(index).getSoLuong() - hoaDon.getSoLuongXuat();
			
			if(soLuongHangSauKhiXuat < 0){
				System.out.println("- So luong hang trong khong du");
				System.out.println("- So luong hang trong kho con: " + kh.getKhuVucs().get(index).getSoLuong());
			}else if(soLuongHangSauKhiXuat > 0){
				System.out.println("- Xuat hang thanh cong");
				System.out.println("- So luong hang trong kho con lai sau khi xuat: " + soLuongHangSauKhiXuat);
				listHoaDon.add(hoaDon);
				kh.setHoaDons(listHoaDon);
				kh.getKhuVucs().get(index).setSoLuong(soLuongHangSauKhiXuat);
				listKhoHang.set(listKhoHang.indexOf(kh), kh);
			}else {
				System.out.println("- Xuat hang thanh cong");
				System.out.println("- So luong hang trong kho con lai sau khi xuat: 0 ");
				listHoaDon.add(hoaDon);
				kh.setHoaDons(listHoaDon);
				kh.getKhuVucs().get(index).setSoLuong(0);
				listKhoHang.set(listKhoHang.indexOf(kh), kh);
			}
		}else if (kh.getKhuVucs().get(index).getMatHangLuuTru().equalsIgnoreCase("CPU")) {
				HoaDon hoaDon = new HoaDon();
				hoaDon.NhapHoaDon();
				hoaDon.setMaKho(maKho);
				hoaDon.setMaKhuVuc(kh.getKhuVucs().get(index).getMaKhuVuc());
				hoaDon.setTenHang(kh.getKhuVucs().get(index).getMatHangLuuTru());
				
				int soLuongHangSauKhiXuat = kh.getKhuVucs().get(index).getSoLuong() - hoaDon.getSoLuongXuat();
				
				if(soLuongHangSauKhiXuat < 0){
					System.out.println("- So luong hang trong khong du");
					System.out.println("- So luong hang trong kho con: " + kh.getKhuVucs().get(index).getSoLuong());
				}else if(soLuongHangSauKhiXuat > 0){
					System.out.println("- Xuat hang thanh cong");
					System.out.println("- So luong hang trong kho con lai sau khi xuat: " + soLuongHangSauKhiXuat);
					listHoaDon.add(hoaDon);
					kh.setHoaDons(listHoaDon);
					kh.getKhuVucs().get(index).setSoLuong(soLuongHangSauKhiXuat);
					listKhoHang.set(listKhoHang.indexOf(kh), kh);
				}else {
					System.out.println("- Xuat hang thanh cong");
					System.out.println("- So luong hang trong kho con lai sau khi xuat: 0 ");
					listHoaDon.add(hoaDon);
					kh.setHoaDons(listHoaDon);
					kh.getKhuVucs().get(index).setSoLuong(0);
					listKhoHang.set(listKhoHang.indexOf(kh), kh);
				}
		}
	}

	public static void QuanLyTonKho() {
		HienThiDanhSachKhoHang();

		System.out.println("\nNhap ma kho de xem thong tin: ");
		sc.nextLine();
		String maKho = sc.nextLine();

		System.out.println("=========== Hoa Don Xuat Hang TRONG KHO: " + maKho + " ============");
		System.out.printf("%-10s|%-10s|%-10s|%-10s|%-10s", "maHoaDon", "maKho", "maKhuVuc", "TenHang",
				"soLuongXuat");
		System.out.println();
		
		for (KhoHang kh : listKhoHang) {
			if (kh.getMaKho().equalsIgnoreCase(maKho)) {
				for(HoaDon hoadon : kh.getHoaDons()){
					System.out.println(hoadon.XuatHoaDon());
				}
			}
		}
		System.out.println("----------------------------------------------------------------");

		System.out.println(
				"\n\n======================= SO LUONG HANG CON TRONG KHO: " + maKho + " =========================");
		System.out.printf("%-10s|%-20s|%-10s|%-20s|%-10s", "Ma Khu Vuc", "Ten Khu Vuc", "Dien Tich", "Mat Hang",
				"So Luong Hien Co");
		System.out.println("\n-----------------------------------------------------------------------------------");

		for (KhoHang kh : listKhoHang) {
			if (kh.getMaKho().equalsIgnoreCase(maKho)) {
				for(KhuVuc khuvuc : kh.getKhuVucs()){
					System.out.println(khuvuc.XuatThongTinKhuVuc());
				}
			}
		}
		System.out.println("-----------------------------------------------------------------------------------");
		
	}

}
