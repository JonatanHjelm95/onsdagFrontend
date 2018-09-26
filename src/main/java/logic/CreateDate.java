/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Date;

/**
 *
 * @author jonab
 */
public class CreateDate {

    public String createDate() {
        Date date = new Date();
        String date_str = "";

        date_str += date.getDate();
        date_str += "-";
        date_str += createMonth(date.getMonth());
        date_str += "-";
        date_str += date.getYear()+1900;
        return date_str;
    }

    public String createMonth(int month) {
        String month_str = "";
        if (month >= 9) {
            month_str += month + 1;
        } else {
            month_str = "0";
            month_str += month + 1;

        }
        return month_str;
    }
}
