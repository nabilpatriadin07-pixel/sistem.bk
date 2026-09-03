
package Model;

public class pelanggaran_siswa {
    public date tanggal;
    public int poin;
    public String keterangan;
    public String status;

    public pelanggaran_siswa(date tanggal,int poin,String keterangan,String status) {
        this.tanggal = tanggal;
        this.poin = poin;
        this.keterangan = keterangan;
        this.status = status;
}

}
