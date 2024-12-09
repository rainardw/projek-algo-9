import java.util.LinkedList;

public class Kardus {
    public int kapasitasMaks;
    public int kapasitasSaatIni;
    public LinkedList<Buku> bukuDalamKardus;

    public Kardus(int kapasitasMaks) {
        this.kapasitasMaks = kapasitasMaks;
        this.kapasitasSaatIni = 0;
        bukuDalamKardus = new LinkedList<>();
    }

    public boolean tambahBuku(Buku buku) {
        if (kapasitasSaatIni + buku.getKetebalan() <= kapasitasMaks) {
            bukuDalamKardus.add(buku);
            kapasitasSaatIni += buku.getKetebalan();
            return true;
        }
        return false;
    }

    public void tampilkanIsiKardus() {
        System.out.println("Isi kardus:");
        for (Buku buku : bukuDalamKardus) {
            System.out.println(buku);
        }
        System.out.println("Kapasitas saat ini: " + kapasitasSaatIni + "/" + kapasitasMaks);
    }
}