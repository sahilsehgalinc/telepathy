/**
 * compass. 
 * Copyright � 2015 compass. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF compass. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF compass.
 */
package com.compass.email;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.compass.dao.DaoEmailLogging;
import com.compass.dao.DaoLoginLog;
import com.compass.entities.EmailLogging;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


/**
 * <code>EmailManager</code> is used to send the emails to the compass user's EMAIL ID
 * @author RK
 * @timestamp
 */
@Component(value = "emailManager")
public class EmailManager {

	@Value("${smtp.host}")
	String smtpHost;

	@Value("${smtp.username}")
	String smtpUsername;

	@Value("${smtp.password}")
	String smtpPassword;

	@Value("${smtp.port}")
	int smtpPort;

	@Value("${smtp.fromName}")
	String smtpFromName;

	@Value("${smtp.fromEmail}")
	String smtpFromEmail;
	
	
	@Value("${smtpbulk.host}")
	String smtpBulkHost;

	@Value("${smtpbulk.username}")
	String smtpBulkUsername;

	@Value("${smtpbulk.password}")
	String smtpBulkPassword;

	@Value("${smtpbulk.port}")
	int smtpBulkPort;

	@Value("${smtpbulk.fromName}")
	String smtpBulkFromName;

	@Value("${smtpbulk.fromEmail}")
	String smtpBulkFromEmail;
	
	@Autowired
	DaoEmailLogging daoEmailLogging;
	
	private String subject;
	private String recipientEmail;
	private String message;

	public EmailManager() {
	}

	/**
	 * @param subject
	 * @param recipientEmail
	 * @param message
	 */
	public EmailManager(String subject, String recipientEmail, String message) {
		this.subject = subject;
		this.recipientEmail = recipientEmail;
		this.message = message;
	}

	/**
	 * @return
	 */
	private JavaMailSenderImpl getMailSender() {

		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(smtpHost);
		javaMailSenderImpl.setUsername(smtpUsername);
		javaMailSenderImpl.setPassword(smtpPassword);
		javaMailSenderImpl.setPort(smtpPort);
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		javaMailSenderImpl.setJavaMailProperties(properties);
		return javaMailSenderImpl;

	}

	/**
	 * @return
	 * @throws MessagingException
	 */
	@Async
	public boolean sendMessage() throws MessagingException {

		try {
			JavaMailSenderImpl javaMailSenderImpl=getMailSender();

			MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

			MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
			msg.setFrom(new InternetAddress(smtpFromEmail, smtpFromName));
			msg.setTo(recipientEmail);
			msg.setSubject(subject);
			msg.setText(message, true);
			javaMailSenderImpl.send(mimeMessage);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new MailSendException(
					"Unable to connect with SMTP server.Please try after some time.");
		}
	}

	/**
	 * @param subject
	 * @param recipientEmail
	 * @param message
	 * @throws MessagingException
	 */
	@Async
	public void sendMessage(String subject, String recipientEmail,
			String message) throws MessagingException {
		try {
			
			EmailLogging emailLogging = new EmailLogging();
			
			emailLogging.setPurpose(subject);
			emailLogging.setDiscription(message);
			emailLogging.setRecieverEmail(recipientEmail);
			
			daoEmailLogging.save(emailLogging);
			
			JavaMailSenderImpl javaMailSenderImpl=getMailSender();
			MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
			MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
			/*msg.setFrom(smtpUsername);*/
			msg.setFrom(new InternetAddress(smtpFromEmail, smtpFromName));
			msg.setTo(recipientEmail);
			msg.setSubject(subject);
			msg.setText(message, true);
			javaMailSenderImpl.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MailSendException(
					"Unable to connect with SMTP server.Please try after some time.");
		}
	}

	/**
	 * @param subject
	 * @param recipientEmails
	 * @param message
	 * @throws MessagingException
	 */
	@Async
	public void sendMessage(String subject, List<String> recipientEmails,
			String message) throws MessagingException {

		try{
			JavaMailSenderImpl javaMailSenderImpl=getMailSender();


			for (int i = 0; i < recipientEmails.size(); i++) {
				
			/*	EmailLogging emailLogging = new EmailLogging();
				
				emailLogging.setPurpose(subject);
				emailLogging.setDiscription(message);
				emailLogging.setRecieverEmail(recipientEmails.get(i));
				
				daoEmailLogging.save(emailLogging);
				*/
				MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
				MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
				/*msg.setFrom(smtpUsername);*/
				msg.setFrom(new InternetAddress(smtpFromEmail, smtpFromName));
				msg.setTo(recipientEmails.get(i));
				msg.setSubject(subject);
				msg.setText(message, true);
				javaMailSenderImpl.send(mimeMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new MailSendException(
					"Unable to connect with SMTP server.Please try after some time.");
		}

	}

	/**
	 * @param filePath
	 * @return
	 * @throws MessagingException
	 */
	@Async
	public boolean sendMessageWithAttachment(String filePath)
			throws MessagingException {
		JavaMailSenderImpl javaMailSenderImpl=getMailSender();
		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

		try {
			MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
			msg.setFrom(new InternetAddress(smtpFromEmail, smtpFromName));
			msg.setTo(recipientEmail);
			msg.setSubject(subject);
			msg.setText(message, true);

			FileSystemResource file = new FileSystemResource(filePath);
			msg.addAttachment(file.getFilename(), file);
			javaMailSenderImpl.send(mimeMessage);
			return true;
		}

		catch (Exception ex) {
			System.err.println(ex.getMessage());
			return false;
		}
	}

	/**
	 * @param filePath1
	 * @param filePath2
	 * @return
	 * @throws MessagingException
	 */
	@Async
	public boolean sendMessageWithAttachment(String filePath1, String filePath2)
			throws MessagingException {
		JavaMailSenderImpl javaMailSenderImpl=getMailSender();
		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

		try {
			MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
			msg.setFrom(new InternetAddress(smtpFromEmail, smtpFromName));
			msg.setTo(recipientEmail);
			msg.setSubject(subject);
			msg.setText(message, true);
			FileSystemResource file1 = new FileSystemResource(filePath1);
			msg.addAttachment(file1.getFilename(), file1);

			FileSystemResource file2 = new FileSystemResource(filePath2);
			msg.addAttachment(file2.getFilename(), file2);
			javaMailSenderImpl.send(mimeMessage);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			System.err.println(ex.getMessage());
			return false;
		}
	}
	
	public boolean sendMessageWithAttachment(String subject, String recipientEmail, ByteArrayOutputStream out,
            String message, String fileName) {

     JavaMailSenderImpl javaMailSenderImpl=getMailSender();
     MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

     
     try {
            MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
            msg.setFrom(new InternetAddress(smtpFromEmail, smtpFromName));
            msg.setTo(recipientEmail);
            msg.setSubject(subject);
            msg.setText(message, true);
            DataSource source = new ByteArrayDataSource(out.toByteArray(), "application/pdf");
            msg.addAttachment(fileName,source);
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            messageBodyPart.setDataHandler(new DataHandler(source));
		    messageBodyPart.setFileName(fileName);
		    
		    
		    MimeBodyPart messageBodyPartText = new MimeBodyPart();
		    //messageBodyPartText.setText(message,"utf-8");
		    messageBodyPartText.setContent(message, "text/html; charset=utf-8");
		    multipart.addBodyPart(messageBodyPartText);
		    multipart.addBodyPart(messageBodyPart);
		    mimeMessage.setContent(multipart);
            javaMailSenderImpl.send(mimeMessage);
            return true;
     }

     catch (Exception ex) {
            ex.printStackTrace();
            
            return false;
     }
	}
	
	
	private JavaMailSenderImpl getMailSenderCustomer() {

		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(smtpBulkHost);
		javaMailSenderImpl.setUsername(smtpBulkUsername);
		javaMailSenderImpl.setPassword(smtpBulkPassword);
		javaMailSenderImpl.setPort(smtpBulkPort);
		javaMailSenderImpl.setProtocol("smtps");
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		javaMailSenderImpl.setJavaMailProperties(properties);
		return javaMailSenderImpl;

	}
	
	
	@Async
	public void sendMessageCustomer(String subject, String recipientEmail,
			String message) throws MessagingException {
		try {
			/*
			EmailLogging emailLogging = new EmailLogging();
			
			emailLogging.setPurpose(subject);
			emailLogging.setDiscription(message);
			emailLogging.setRecieverEmail(recipientEmail);
			
			daoEmailLogging.save(emailLogging);
			*/
			JavaMailSenderImpl javaMailSenderImpl=getMailSenderCustomer();
			MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
			MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
			/*msg.setFrom(smtpUsername);*/
			msg.setFrom(new InternetAddress(smtpBulkFromEmail, smtpBulkFromName));
			msg.setTo(recipientEmail);
			msg.setSubject(subject);
			msg.setText(message, true);
			javaMailSenderImpl.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MailSendException(
					"Unable to connect with SMTP server.Please try after some time.");
		}
	}
	
	public ByteArrayOutputStream getCustomizeReceiptPdf(String path, String donorName, String amount) throws DocumentException 
	{
		Font black12 = FontFactory.getFont("Arial", 12, Font.NORMAL);
		//Font black8 = FontFactory.getFont("Arial", 8, Font.NORMAL);
		
		Document document = new Document();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
		SimpleDateFormat formatter= new SimpleDateFormat("dd MMM, yyyy");
			
		String todayDate=formatter.format(new Date());
		
		try
		{
		    document.open();
		  //  Image image2 = Image.getInstance(path + "NewStyles/images/thanku-card.jpg");
		    Image image1 = Image.getInstance(path + "NewStyles/images/ie-logo-with-tagline.PNG");
		    //Image image2 = Image.getInstance(path + "NewStyles/images/thanku-card.jpg");
		    image1.scaleAbsolute(200f, 70f);
		    PdfPTable imageTable = new PdfPTable(1);
		    //imageTable.setWidthPercentage(150);
		    PdfPCell imageCell;
		    imageCell = new PdfPCell(image1);
		    imageCell.setBorder(Rectangle.NO_BORDER);
		    imageCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    imageTable.addCell(imageCell);
		    imageTable.completeRow();
		    document.add(imageTable);
		    document.add(new Paragraph(Chunk.NEWLINE));
		    document.add(new Paragraph(Chunk.NEWLINE));
		    document.add(new Paragraph(Chunk.NEWLINE));
		    Chunk chunk = new Chunk(todayDate);
		    document.add(chunk);
		    document.add(new Paragraph(Chunk.NEWLINE));
		    document.add(new Paragraph(Chunk.NEWLINE));
		    
		    String text = "Thank you for your gift of $"+amount +". Your generous contribution will help us greatly in "
		    		+ "meeting our goal of providing mindful awareness programs for all children in grades k12 in our "
		    		+ "public schools. These practices will allow them to develop towards their highest potential by "
		    		+ "bolstering academic performance, creativity, social & emotional aptitude and wellbeing. ";
		    
		  
		    
		    Paragraph paragraph = new Paragraph("Dear " + donorName + "," + Chunk.NEWLINE + Chunk.NEWLINE + text + Chunk.NEWLINE +Chunk.NEWLINE+Chunk.NEWLINE,black12);

		    paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
		    paragraph.add(Chunk.NEWLINE);
		    paragraph.add(Chunk.NEWLINE);
		    paragraph.add("Sincerely,");
		    paragraph.add(Chunk.NEWLINE);
		    paragraph.add(Chunk.NEWLINE);
		    paragraph.add("Janice Houlihan & Laura Bakosh");
		    paragraph.add(Chunk.NEWLINE);
		    paragraph.add("Co-Founders");
		    paragraph.add(Chunk.NEWLINE);
		    paragraph.add("Inner Explorer, Inc. ");
		    paragraph.add(Chunk.NEWLINE);
		    paragraph.add(Chunk.NEWLINE);
		    paragraph.add(Chunk.NEWLINE);
		    paragraph.add(Chunk.NEWLINE);
		    paragraph.add(Chunk.NEWLINE);
		    
		    Paragraph paragraph2 = new Paragraph();
		    paragraph2.add("Please note that you must retain a copy of this gift receipt for federal income tax "
		    		+ "purposes  and that no goods or services were furnished in consideration of your gift. Inner Explorer is a non-profit organization under"
		    		+ "Section 501(c)3 of the Internal Revenue Code.");
		    paragraph2.setAlignment(Element.ALIGN_CENTER);
		    document.add(new Paragraph(Chunk.NEWLINE));
		    document.add(new Paragraph(Chunk.NEWLINE));
		    document.add(paragraph);
			document.add(new Paragraph(Chunk.NEWLINE));
		    document.add(new Paragraph(Chunk.NEWLINE));
		    document.add(paragraph2);
		    document.add(new Paragraph(Chunk.NEWLINE));
		    
		   /* PdfPTable footer = new PdfPTable(3);
		    footer.setWidthPercentage(100);*/
		    /*PdfPCell cell;
		    cell = new PdfPCell(new Paragraph("www.InnerExplorer.org",black12));
		    cell.setBorder(Rectangle.NO_BORDER);
		    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    footer.addCell(cell);
		    cell = new PdfPCell(new Paragraph("430 Franklin Village Drive #325 Franklin, MA 02038",black8));
		    cell.setBorder(Rectangle.NO_BORDER);
		    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    footer.addCell(cell);
		    cell = new PdfPCell(new Paragraph("p. 888-466-9732",black8));
		    cell.setBorder(Rectangle.NO_BORDER);
		    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		    footer.addCell(cell);*/
		   /* document.add(footer);*/
		    document.close();
		} catch (Exception e){
		    e.printStackTrace();
		}
		return baos;
	}

	/*Added By Taman*/
	@Async
	public void sendMessageWithSenderEmail(String subject, String recipientEmail,String senderEmail,
			String message) throws MessagingException {
		try {
			/*
			EmailLogging emailLogging = new EmailLogging();
			
			emailLogging.setPurpose(subject);
			emailLogging.setDiscription(message);
			emailLogging.setRecieverEmail(recipientEmail);
			emailLogging.setSenderEmail(senderEmail);
			daoEmailLogging.save(emailLogging);
			*/
			JavaMailSenderImpl javaMailSenderImpl=getMailSender();
			MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
			MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
			/*msg.setFrom(smtpUsername);*/
			msg.setFrom(new InternetAddress(smtpFromEmail, smtpFromName));
			msg.setTo(recipientEmail);
			msg.setSubject(subject);
			msg.setText(message, true);
			javaMailSenderImpl.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MailSendException(
					"Unable to connect with SMTP server.Please try after some time.");
		}
	}

	public boolean sendMessageWithTwoAttachments(String subject, String recipientEmail, ByteArrayOutputStream out,
            String message, String fileName,String imageFileName,String imageFilePath) {
		JavaMailSenderImpl javaMailSenderImpl=getMailSender();
	     MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

	     
	     try {
	            MimeMessageHelper msg = new MimeMessageHelper(mimeMessage, true);
	            msg.setFrom(new InternetAddress(smtpFromEmail, smtpFromName));
	            msg.setTo(recipientEmail);
	            msg.setSubject(subject);
	            msg.setText(message, true);
	            DataSource source = new ByteArrayDataSource(out.toByteArray(), "application/pdf");
	            DataSource sourceImage = new FileDataSource(imageFilePath);
	            msg.addAttachment(fileName,source);
	            msg.addAttachment(imageFileName,sourceImage);
	            MimeBodyPart messageBodyPart = new MimeBodyPart();
	            MimeBodyPart messageBodyPartImage = new MimeBodyPart();
	            Multipart multipart = new MimeMultipart();
	            messageBodyPart.setDataHandler(new DataHandler(source));
			    messageBodyPart.setFileName(fileName);
			    messageBodyPartImage.setDataHandler(new DataHandler(sourceImage));
			    messageBodyPartImage.setFileName(imageFileName);
			    
			    MimeBodyPart messageBodyPartText = new MimeBodyPart();
			    //messageBodyPartText.setText(message,"utf-8");
			    messageBodyPartText.setContent(message, "text/html; charset=utf-8");
			    multipart.addBodyPart(messageBodyPartText);
			    multipart.addBodyPart(messageBodyPart);
			    multipart.addBodyPart(messageBodyPartImage);
			    mimeMessage.setContent(multipart);
	            javaMailSenderImpl.send(mimeMessage);
	            return true;
	     }

	     catch (Exception ex) {
	            ex.printStackTrace();
	            
	            return false;
	     }
		
	}


}
