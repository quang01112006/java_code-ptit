package danhsachsinhvien1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ListSVFileNhiPhan {
    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SV.in"));
        ArrayList<SinhVien> list = (ArrayList<SinhVien>) ois.readObject();
        for (SinhVien sv : list) {
            System.out.println(sv);
        }
    }
}

class SinhVien implements Serializable {
    private String ma, ten, lop;
    private Date ngaysinh;
    private float gpa;

    public SinhVien(int id, String ten, String lop, String ngaysinhStr, float gpa) throws Exception {
        this.ma = String.format("B20DCCN%03d", id);
        this.ten = ten;
        this.lop = lop;
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        this.ngaysinh = sdf.parse(ngaysinhStr);
        this.gpa = gpa;

    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return ma + " " + ten + " " + lop + " " + sdf.format(ngaysinh) + " " + String.format("%.2f", gpa);
    }
}