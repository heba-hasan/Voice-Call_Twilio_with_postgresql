/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sms_voice_db;

import com.twilio.rest.api.v2010.account.Message;
import java.sql.SQLException;

/**
 *
 * @author 20121
 */
//SMS_VOICE_DB

 
 
 
public class SMS_VOICE_DB {
 
   
  public static void main(String[] args) throws SQLException {
PostgreSql DB=new PostgreSql();
String [] data=DB.SelectfromPostgresql();
      Sendsms sms=new Sendsms();
      String tophone=sms.getTonumber();
      Message message= sms.sendmessage(data[1], data[0],tophone,data[2]);
          System.out.println("MID: " +message.getSid()+"Body: "+message.getBody()+message);
 DB.insertToDB(message.getSid(), message.getFrom().toString(), message.getTo(), message.getBody(), message.getDateUpdated().toString(), message.getStatus().toString());
 
  }
 
}