
package Model;


import java.sql.Date;

public class pelanggaran_siswa {
    public Date tanggal;
    public int poin;
    public String keterangan;
    public String status;

    public pelanggaran_siswa(Date tanggal,int poin,String keterangan,String status) {
        this.tanggal = tanggal;
        this.poin = poin;
        this.keterangan = keterangan;
        this.status = status;
}

}
