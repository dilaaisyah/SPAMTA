
package Control;

import java.util.Date;

public class StopWatch {
private Date date;
private String detik, menit, jam;

public Time timeFormat(int s, int m, int h){
    Time tm;
    String nolS="", nolM="", nolH="";
        if (s <= 9) nolS = "0";
        if (m <= 9) nolM = "0";
        if (h <= 9) nolH = "0";
        tm = new Time(nolS+Integer.toString(s), nolM+Integer.toString(m), nolH+Integer.toString(h));

    return tm;
}

}
