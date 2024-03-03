package entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.print.attribute.standard.MediaSize;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NhanVien {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private String id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @Column(name = "DiaChi")
    private String diaChi;

}
