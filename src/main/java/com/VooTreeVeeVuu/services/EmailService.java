package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.dto.EmailReceiptDTO;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendOTP(String email, String otp) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            message.setFrom("dhuyclone2001@gmail.com");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("OTP VERIFICATION CODE");
            message.setText("Your OTP code: " + otp);
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmailReceipt(EmailReceiptDTO dto) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
//            message.setFrom("dhuyclone2001@gmail.com");
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(dto.getCusEmail()));
//            message.setSubject("[VooTreeVeeVuu] BOOKING INFORMATION");
//            String emailContent = "Booking Information: \n" +
//                    "Hotel Name: " + dto.getHotelName() + "\n" +
//                    "Room Type: " + dto.getRoomType() + "\n" +
//                    "Check In Time: " + dto.getCheckInTime() + "\n" +
//                    "Check Out Time: " + dto.getCheckOutTime() + "\n";
//            message.setText(emailContent);
//            mailSender.send(message);
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom("dhuyclone2001@gmail.com");
            helper.setTo(dto.getCusEmail());
            helper.setSubject("[VooTreeVeeVuu] BOOKING INFORMATION");

//            String emailContent = "<h1>Booking Information</h1>" +
//                    "<p style=\"color:blue \"><strong>Hotel Name:</strong>" + dto.getHotelName() + "</p>" +
//                    "<p><strong>Room Type:</strong> " + dto.getRoomType() + "</p>" +
//                    "<p><strong>Check-In:</strong> " + dto.getCheckInTime() + "</p>" +
//                    "<p><strong>Check-Out:</strong> " + dto.getCheckOutTime() + "</p>";
            String emailContent =
                    " <div style=\" height: 50px; background-color: blue; justify-content: center; align-items: center; display: flex; color: white;\" >" +
                            "<h1>Booking Information</h1></div>" +
                            "<div style=\"display: flex; padding: 5px\">" +
                            " <div style=\"width: 30%\">" +
                            "<p><strong>Hotel Name:</strong></p>" +
                            "<p><strong>Room Type:</strong></p>" +
                            "<p><strong>Check In Time:</strong></p>" +
                            "<p><strong>Check Out Time:</strong></p>" +
                            "<p><strong>Guest(s)/Room(s):</strong></p>" +
                            "<p><strong>Hotel Phone:</strong></p>" +
                            " <p><strong>Hotel Address:</strong></p>" +
                            "<p><strong>From - To:</strong></p>" +
                            "</div>" +
                            "<div style=\"width: 60%;font-weight:bold\">" +
                            "<p>" + dto.getHotelName() + "</p>" +
                            "<p>" + dto.getRoomType() + "</p>" +
                            "<p>" + dto.getCheckInTime() + "</p>" +
                            "<p>" + dto.getCheckOutTime() + "</p>" +
                            "<p>" + dto.getNum_of_guests() + " Guest(s)/" + dto.getNum_of_rooms() + " Room(s)" + "</p>" +
                            "<p>" + dto.getHotelPhoneNum() + "</p>" +
                            "<p>" + dto.getAddress() + "</p>" +
                            "<p style=\"font-weight: bold; color: red\">" + dto.getCheckInDate() + " - " + dto.getCheckOutDate() + "</p>" +
                            "</div>" +
                            "</div>";
            helper.setText(emailContent, true);
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
