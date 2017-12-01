package com.example.peter.myhome;

/**
 * Created by Nam on 2017-11-27.
 */

public class Current_User {

    public static int UserID = 1;
    public static String FName = "Ian";
    public static String LName = "More";


    public static int getUserID () {
        return UserID;
    }

    public static String getFName () {

        return FName;
    }

    public static String getLName () {

        return LName;
    }

    public static void setUserID () {

        UserID = 1;
    }

    public static void setFName () {

        FName = "Ian";
    }

    public static void setLName () {

        LName = "More";
    }
}
