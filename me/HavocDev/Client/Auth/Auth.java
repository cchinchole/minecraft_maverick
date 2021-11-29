package me.HavocDev.Client.Auth;

import java.io.*;
import java.net.URL;

/**
 * Created by christian on 11/2/2016.
 * A sample authenticator that could be used to acquire a key from the c drive then check it against an outside source.
 */
public class Auth {

    String RPTrGSqGOSYUrJIMhmif = "https://localhost/checkvalid.php";
    String phERnsxGjGosVJSSJYRj = "asoifeafsSLkjfewfih(ES23hkls.zkw";
    String JkICJrUlIENmbpngQfUA = "@1213jlk;)1=3=0xlkL3ix0jf2;'3oSo";

    public Auth(String url, String ExpectedResponse)
    {
        this.RPTrGSqGOSYUrJIMhmif = url;
        this.phERnsxGjGosVJSSJYRj = ExpectedResponse;

        try(BufferedReader eSIdwlkEkQiCeORBIdhB = new BufferedReader(new FileReader("c:\\key.txt"))) {
            StringBuilder wHWOutEPIviuUhGVBvZb = new StringBuilder();
            String OBXhQIKQscReNtmcsQMZ = eSIdwlkEkQiCeORBIdhB.readLine();

            while (OBXhQIKQscReNtmcsQMZ != null) {
            	wHWOutEPIviuUhGVBvZb.append(OBXhQIKQscReNtmcsQMZ);
            	wHWOutEPIviuUhGVBvZb.append(System.lineSeparator());
            	OBXhQIKQscReNtmcsQMZ = eSIdwlkEkQiCeORBIdhB.readLine();
            }
            String yvMnkyrOhowkNHwMPATC = wHWOutEPIviuUhGVBvZb.toString();
            JkICJrUlIENmbpngQfUA = yvMnkyrOhowkNHwMPATC;
        }
        catch(Exception fsadfs){}

    }

    public boolean CheckAuth() throws IOException
    {
        URL OYhSmTYmeMDezKogsCji = new URL(this.RPTrGSqGOSYUrJIMhmif+JkICJrUlIENmbpngQfUA);
        BufferedReader xKmYwEFrtmRZXiDayBKY = new BufferedReader(new InputStreamReader( OYhSmTYmeMDezKogsCji.openStream()) );
        String zxFnHqevTylwUoNfsfQq = "";
        String JDMtLBsUQJDXYzKcukep = "";
        while((JDMtLBsUQJDXYzKcukep = xKmYwEFrtmRZXiDayBKY.readLine()) != null)
        	zxFnHqevTylwUoNfsfQq += JDMtLBsUQJDXYzKcukep;
        if(zxFnHqevTylwUoNfsfQq.startsWith(phERnsxGjGosVJSSJYRj))
            return true;
        else
          return false;
          
    }



}
