package com.example.tutor2.service;

import com.example.tutor2.model.NhanVien;
import com.example.tutor2.repository.NhanVienRepository;

import java.util.List;

public class NhanVienService {
    NhanVienRepository nhanVienRepository = new NhanVienRepository();
    public List<NhanVien> getList(){
        return nhanVienRepository.getAll();
    }
    public Boolean delete(String nhanVien){
        return nhanVienRepository.remove(nhanVien);
    }

    public void add(NhanVien nhanVien){
        nhanVienRepository.add(nhanVien);
    }

    NhanVien detail(String id){
        return nhanVienRepository.getOne(id);
    }

}
