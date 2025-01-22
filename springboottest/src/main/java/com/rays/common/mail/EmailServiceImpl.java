package com.rays.common.mail;

import java.io.File;
import java.util.Iterator;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.rays.common.UserContext;
import com.rays.common.attachment.AttachmentDTO;
import com.rays.common.attachment.AttachmentServiceInt;
import com.rays.common.message.MessageDTO;
import com.rays.common.message.MessageServiceInt;

/**
 * Provides email services.
 * Suraj Sahu
 */
@Component
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private MessageServiceInt messageService;

    @Autowired
    private AttachmentServiceInt attachmentService;

    /**
     * Sends an email.
     * 
     * @param dto the email data transfer object
     * @param ctx the user context
     */
    public void send(EmailDTO dto, UserContext ctx) {
        if (dto.getMessageCode() != null) {
            MessageDTO messageDTO = messageService.findByCode(dto.getMessageCode(), ctx);
            System.out.println("Fetched messageDTO: " + messageDTO);

            if (messageDTO == null || "Inactive".equals(messageDTO.getStatus())) {
                System.out.println("Message is inactive or not found. Aborting email send.");
                return;
            }

            dto.setSubject(messageDTO.getSubject(dto.getMessageParams()));
            dto.setBody(messageDTO.getBody(dto.getMessageParams()));
            dto.setIsHTML("Y".equals(messageDTO.getHtml()));
            System.out.println("Email subject and body set.");
        }

        MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            System.out.println("MimeMessageHelper created.");

            if (!dto.getTo().isEmpty()) {
                helper.setTo(dto.getTo().toArray(new String[0]));
                System.out.println("To addresses set: " + dto.getTo());
            }

            if (!dto.getCc().isEmpty()) {
                helper.setCc(dto.getCc().toArray(new String[0]));
                System.out.println("Cc addresses set: " + dto.getCc());
            }

            if (!dto.getBcc().isEmpty()) {
                helper.setBcc(dto.getBcc().toArray(new String[0]));
                System.out.println("Bcc addresses set: " + dto.getBcc());
            }

            helper.setSubject(dto.getSubject());
            helper.setText(dto.getBody(), dto.getIsHTML());
            System.out.println("Email subject and body set in helper.");

            for (String path : dto.getAttachedFilePath()) {
                FileSystemResource file = new FileSystemResource(new File(path));
                helper.addAttachment(file.getFilename(), file);
                System.out.println("Attached file from path: " + path);
            }

            for (Long id : dto.getAttachedFileId()) {
                AttachmentDTO fileDto = attachmentService.findById(id, ctx);
                if (fileDto != null) {
                    ByteArrayResource file = new ByteArrayResource(fileDto.getDoc());
                    helper.addAttachment(fileDto.getName(), file);
                    System.out.println("Attached file from database with ID: " + id);
                }
            }

        } catch (MessagingException e) {
            System.out.println("MessagingException occurred: " + e.getMessage());
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("Sending email...");
            emailSender.send(message);
            System.out.println("Email sent.");
        }).start();
    }

}
