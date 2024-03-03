package com.example.tutorjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    private Integer id;

    private String maNV;

    private String tenNV;

    private Integer namSinh;

    private String gioiTinh;

    private String chucVu;
}
