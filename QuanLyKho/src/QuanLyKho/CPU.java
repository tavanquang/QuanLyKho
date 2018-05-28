package QuanLyKho;

import java.util.Scanner;

public class CPU extends HangHoa {

	private String chip;
	private String ram;

	public void NhapThongTinHangHoa() {
		super.NhapThongTinHangHoa();

		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap chip: ");
		chip = sc.nextLine();

		System.out.println("Nhap ram: ");
		ram = sc.nextLine();

	}

	public String XuatThongTinHangHoa() {

		return super.XuatThongTinHangHoa() + String.format("%-10s|%-10s", chip, ram);

	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}
	
	

}
