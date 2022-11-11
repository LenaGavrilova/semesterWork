package entities;

public class CartItem {
    private int pid;
    private String pname;
    private String pimage;
    private int pprice;
    private int pamount;
    private String ptitle;
    private String pdescription;
    private int pcate;

    public CartItem() {
    }

    public CartItem(int pid, String pname, String pimage, int pprice, int pamount, String ptitle, String pdescription, int pcate) {
        this.pid = pid;
        this.pname = pname;
        this.pimage = pimage;
        this.pprice = pprice * pamount;
        this.pamount = pamount;
        this.ptitle = ptitle;
        this.pdescription = pdescription;
        this.pcate = pcate;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice * pamount;
    }

    public int getPamount() {
        return pamount;
    }

    public void setPamount(int pamount) {
        this.pamount = pamount;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPdescription() {
        return pdescription;
    }

    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    public int getPcate() {
        return pcate;
    }

    public void setPcate(int pcate) {
        this.pcate = pcate;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pimage='" + pimage + '\'' +
                ", pprice=" + pprice +
                ", pamount=" + pamount +
                ", ptitle='" + ptitle + '\'' +
                ", pdescription='" + pdescription + '\'' +
                ", pcate=" + pcate +
                '}';
    }
}
