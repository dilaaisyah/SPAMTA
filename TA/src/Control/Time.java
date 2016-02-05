
package Control;

public class Time {
private String detik;
private String menit;
private String jam;

    
public Time(){

}
public Time(String detik, String menit, String jam){
    this.detik = detik;
    this.menit = menit;
    this.jam = jam;

}
    public String getDetik() {
        return detik;
    }

    public void setDetik(String detik) {
        this.detik = detik;
    }

    public String getMenit() {
        return menit;
    }

    public void setMenit(String menit) {
        this.menit = menit;
    }
 
    public String getJam() {
        return jam;
    }
    public void setJam(String jam) {
        this.jam = jam;
    }
}
