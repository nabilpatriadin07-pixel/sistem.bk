
package Model;


import java.sql.Date;

public class presatsi_siswa {
    public Date tanggal;
    public int poin;
    public String keterangan;

    public presatsi_siswa(Date tanggal,int poin,String keterangan) {
        this.tanggal = tanggal;
        this.poin = poin;
        this.keterangan = keterangan;
}
}