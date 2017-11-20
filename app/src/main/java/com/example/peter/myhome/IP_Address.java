package com.example.peter.myhome;

/**
 * Created by Nam on 2017-11-14.
 */

public class IP_Address {

    /*
        How to get the current wifi address
        - Open Command prompt
        - Type ipconfig (for windows) or ifconfig (for Mac)
        - Look for "Wireless LAN adapter Wi-Fi", you will see the IP address in the "IPv4 Address" part
        - Then change the adress under this line
     */

    // NAM wifi web address
    //public static String adress = "192.168.0.10";

    //University secure wifi web address
    public static String adress = "10.227.139.155";

    public static String getIPAdress () {

        return adress;
    }
}
