package Sambit;

import java.util.Date;

public class newDate {

    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Date :" + date + "";
    }

}