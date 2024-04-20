/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sms_voice_db;

/**
 *
 * @author 20121
 */
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
 
import java.net.URI;
import java.math.BigDecimal;
import java.util.Scanner;
 
/**
*
* @author W10 21H2 IOT
*/
public class Sendsms {

  public Message sendmessage(String ACCOUNT_SID,String AUTH_TOKEN,String sendTo,String Twilio__number )
  {
     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
      new com.twilio.type.PhoneNumber(sendTo),
      new com.twilio.type.PhoneNumber(Twilio__number),
      "HI heba how are you").create();
    return  message;
  }
  public String getTonumber()
  {
       Scanner scanner = new Scanner(System.in);
 
        System.out.println("TO: ");
 
        String phone = scanner.nextLine();
        scanner.close();
        return phone;
    }
}
