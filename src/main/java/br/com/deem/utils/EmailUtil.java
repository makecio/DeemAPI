package br.com.deem.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String SERVIDOR_SMTP="smtp.gmail.com";
	public static final int PORTA_SERVIDOR_SMTP=465;
	public static final String CONTA_PADRAO="amakecio@gmail.com";
	private static final String SENHA_CONTA_PADRAO="0800101520";
	
	private String de;
	private String para;
	private String destnormais;
	private String destoculto;
	private String assunto;
	private String mensagem;
	
	public void enviarAutenticado(){
		//FacesContext context = FacesContext.getCurrentInstance();
		
		  Properties config = new Properties();
		  config.put("mail.smtp.auth", "true");
		  config.put("mail.smtp.host",SERVIDOR_SMTP);
		  config.put("mail.smtp.port", PORTA_SERVIDOR_SMTP);
		  config.put("mail.smtp.starttls.enable", "true");    
		  config.put("mail.smtp.socketFactory.port", "465");    
		  config.put("mail.smtp.socketFactory.fallback", "false");    
		  config.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		  config.put("mail.smtp.ssl.trust", "*");
		  config.put("mail.smtp.connectiontimeout", "10000");
		
		Session sessao = Session.getDefaultInstance(config, new AutenticaUsuario(EmailUtil.CONTA_PADRAO,EmailUtil.SENHA_CONTA_PADRAO));
		
		try {
			
			MimeMessage email = new MimeMessage(sessao);
			email.setFrom(new InternetAddress(this.de));
			email.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para));
			
			InternetAddress[]normais = this.monstarDestinatarios(this.destnormais);
			if(normais !=null){
				email.setRecipients(Message.RecipientType.CC,normais);
			}
			InternetAddress[]ocultos = this.monstarDestinatarios(this.destoculto);
			if(ocultos !=null){
				email.setRecipients(Message.RecipientType.BCC,ocultos);
			}
			
			email.setSubject(this.assunto);
			email.setSentDate(new Date());
			email.setContent(this.mensagem, "text/html; charset=utf-8"); 
			//email.setText(this.mensagem);
			Transport.send(email);
			
			//context.addMessage(null, new FacesMessage("Solicita��o/Altera��o enviada com sucesso!"));
			
		} catch (AddressException e) {
		//	FacesMessage msg = new FacesMessage("Erro ao montar mensagem de e-mail erro: " + e.getMessage());
			//context.addMessage(null, msg);
			e.printStackTrace();	
			return;
		}catch (MessagingException e) {
			//FacesMessage msg = new FacesMessage("Erro ao enviar e-mail erro: " + e.getMessage());
			//context.addMessage(null, msg);
			e.printStackTrace();
			return;
		}
	}
	
	public void enviarSimples(){
		//FacesContext context = FacesContext.getCurrentInstance();
		
		Properties config = new Properties();
		config.put("mail.smtp.host",EmailUtil.SERVIDOR_SMTP);
		config.put("mail.smtp.port", EmailUtil.PORTA_SERVIDOR_SMTP);
		//config.put("mail.smtp.starttls.enable", "true");    
       // config.put("mail.smtp.socketFactory.port", "587");    
       // config.put("mail.smtp.socketFactory.fallback", "false");    
       // config.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session sessao = Session.getInstance(config);
		
		try {
			
			MimeMessage email = new MimeMessage(sessao);
			email.setFrom(new InternetAddress(this.de));
			email.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para));
			
			InternetAddress[]normais = this.monstarDestinatarios(this.destnormais);
			if(normais !=null){
				email.setRecipients(Message.RecipientType.CC,normais);
			}
			InternetAddress[]ocultos = this.monstarDestinatarios(this.destoculto);
			if(ocultos !=null){
				email.setRecipients(Message.RecipientType.BCC,ocultos);
			}
			
			email.setSubject(this.assunto);
			//email.setSentDate(new Date());
			email.setText(this.mensagem,"text/html; charset=utf-8");
			Transport.send(email);
			
		//	context.addMessage(null, new FacesMessage("Solicita��o/Altera��o enviada com sucesso!"));
			
		} catch (AddressException e) {
		//	FacesMessage msg = new FacesMessage("Erro ao montar mensagem de e-mail erro: " + e.getMessage());
			//context.addMessage(null, msg);
			return;
		}catch (MessagingException e) {
			//FacesMessage msg = new FacesMessage("Erro ao enviar e-mail erro: " + e.getMessage());
			//context.addMessage(null, msg);
			return;
		}
	}
	
	private InternetAddress[]monstarDestinatarios(String destinatarios) throws AddressException{
		
		InternetAddress[]emails =null;
		if(destinatarios != null && destinatarios.trim().length() > 0){
			String[] lista = destinatarios.split(";");
			emails  = new InternetAddress[lista.length];
			for(int i =0; i < lista.length; i++){
				emails[i] = new InternetAddress(lista[i]);
			}
		}
		return emails;
	}

	
	//Getters and Setters
	
	
	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getdestnormais() {
		return destnormais;
	}

	public void setdestnormais(String destnormais) {
		this.destnormais = destnormais;
	}

	public String getdestoculto() {
		return destoculto;
	}

	public void setdestoculto(String destoculto) {
		this.destoculto = destoculto;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void enviarEmailAlerta(String emailDestino) {
		// TODO Auto-generated method stub
		
		EmailUtil email = new EmailUtil();
		email.setDe("amakecio@gmail.com");
		
		email.setPara(emailDestino);
		
		email.setAssunto("Conta criada! DeemSolver");
		
		String mensagem = 
		"<!DOCTYPE html>"+
		"<html lang='en' xmlns='http://www.w3.org/1999/xhtml' xmlns:v='urn:schemas-microsoft-com:vml' xmlns:o='urn:schemas-microsoft-com:office:office'>"+
		"<head>"+
		"<meta charset='utf-8'> <!-- utf-8 works for most cases -->"+
		"<meta name='viewport' content='width=device-width'> <!-- Forcing initial-scale shouldn't be necessary -->"+
		"<meta http-equiv='X-UA-Compatible' content='IE=edge'> <!-- Use the latest (edge) version of IE rendering engine -->"+
		"<meta name='x-apple-disable-message-reformatting'>  <!-- Disable auto-scale in iOS 10 Mail entirely -->"+
		"<title></title> <!-- The title tag shows in email notifications, like Android 4.4. -->"+
		""+
		"<!-- Web Font / @font-face : BEGIN -->"+
		"<!-- NOTE: If web fonts are not required, lines 10 - 27 can be safely removed. -->"+
		""+
		"<!-- Desktop Outlook chokes on web font references and defaults to Times New Roman, so we force a safe fallback font. -->"+
		"<!--[if mso]>"+
		"<style>"+
		"* {"+
		"	font-family: sans-serif !important;"+
		"}"+
		"</style>"+
		"<![endif]-->"+
		""+
			"<!-- All other clients get the webfont reference; some will render the font and others will silently fail to the fallbacks. More on that here: http://stylecampaign.com/blog/2015/02/webfont-support-in-email/ -->"+
			"<!--[if !mso]><!-->"+
			"<!-- insert web font reference, eg: <link href='https://fonts.googleapis.com/css?family=Roboto:400,700' rel='stylesheet' type='text/css'> -->"+
			"<!--<![endif]-->"+
			""+
			"<!-- Web Font / @font-face : END -->"+
			""+
			"<!-- CSS Reset -->"+
			"<style>"+
			""+
			"/* What it does: Remove spaces around the email design added by some email clients. */"+
			"/* Beware: It can remove the padding / margin and add a background color to the compose a reply window. */"+
			"html,"+
			"body {"+
			"	margin: 0 auto !important;"+
			"padding: 0 !important;"+
			"height: 100% !important;"+
			"width: 100% !important;"+
			"}"+
			""+
			"/* What it does: Stops email clients resizing small text. */"+
			"* {"+
			"	-ms-text-size-adjust: 100%;"+
			"-webkit-text-size-adjust: 100%;"+
			"}"+
			""+
			"/* What it does: Centers email on Android 4.4 */"+
			"div[style*='margin: 16px 0'] {"+
			"	margin:0 !important;"+
			"}"+
			""+
			"/* What it does: Stops Outlook from adding extra spacing to tables. */"+
			"table,"+
			"td {"+
			"	mso-table-lspace: 0pt !important;"+
			"mso-table-rspace: 0pt !important;"+
			"}"+
			""+
			"/* What it does: Fixes webkit padding issue. Fix for Yahoo mail table alignment bug. Applies table-layout to the first 2 tables then removes for anything nested deeper. */"+
			"table {"+
			"	border-spacing: 0 !important;"+
			"border-collapse: collapse !important;"+
			"table-layout: fixed !important;"+
			"margin: 0 auto !important;"+
			"}"+
			"table table table {"+
			"	table-layout: auto;"+
			"}"+
			""+
			"/* What it does: Uses a better rendering method when resizing images in IE. */"+
			"img {"+
			"	-ms-interpolation-mode:bicubic;"+
			"}"+
			""+
			"/* What it does: A work-around for iOS meddling in triggered links. */"+
			"*[x-apple-data-detectors] {"+
			"	color: inherit !important;"+
			"text-decoration: none !important;"+
			"}"+
			""+
			"/* What it does: A work-around for Gmail meddling in triggered links. */"+
			".x-gmail-data-detectors,"+
			".x-gmail-data-detectors *,"+
			".aBn {"+
			"	border-bottom: 0 !important;"+
			"cursor: default !important;"+
			"}"+
			""+
			"/* What it does: Prevents Gmail from displaying an download button on large, non-linked images. */"+
			".a6S {"+
			"	display: none !important;"+
			"opacity: 0.01 !important;"+
			"}"+
			"/* If the above doesn't work, add a .g-img class to any image in question. */"+
			"img.g-img + div {"+
			"	display:none !important;"+
			"}"+
			""+
			"/* What it does: Prevents underlining the button text in Windows 10 */"+
			".button-link {"+
			"	text-decoration: none !important;"+
			"}"+
			""+
			"/* What it does: Removes right gutter in Gmail iOS app: https://github.com/TedGoas/Cerberus/issues/89  */"+
			"/* Create one of these media queries for each additional viewport size you'd like to fix */"+
			"/* Thanks to Eric Lepetit (@ericlepetitsf) for help troubleshooting */"+
			"@media only screen and (min-device-width: 375px) and (max-device-width: 413px) { /* iPhone 6 and 6+ */"+
			"	.email-container {"+
			"		min-width: 375px !important;"+
			"	}"+
			"}"+
			""+
			"</style>"+
			""+
			"<!-- Progressive Enhancements -->"+
			"<style>"+
			""+
			"/* What it does: Hover styles for buttons */"+
			".button-td,"+
			".button-a {"+
			"	transition: all 100ms ease-in;"+
			"}"+
			".button-td:hover,"+
			".button-a:hover {"+
			"	background: #555555 !important;"+
			"border-color: #555555 !important;"+
			"}"+
			""+
			"/* Media Queries */"+
			"@media screen and (max-width: 600px) {"+
				""+
				".email-container {"+
				"	width: 100% !important;"+
				"margin: auto !important;"+
				"}"+
				""+
				"/* What it does: Forces elements to resize to the full width of their container. Useful for resizing images beyond their max-width. */"+
				".fluid {"+
				"	max-width: 100% !important;"+
				"height: auto !important;"+
				"margin-left: auto !important;"+
				"margin-right: auto !important;"+
				"}"+
				""+
				"/* What it does: Forces table cells into full-width rows. */"+
				".stack-column,"+
				".stack-column-center {"+
				"	display: block !important;"+
				"width: 100% !important;"+
				"max-width: 100% !important;"+
				"direction: ltr !important;"+
				"}"+
				"/* And center justify these ones. */"+
				".stack-column-center {"+
				"	text-align: center !important;"+
				"}"+
				""+
				"/* What it does: Generic utility class for centering. Useful for images, buttons, and nested tables. */"+
				".center-on-narrow {"+
				"	text-align: center !important;"+
				"display: block !important;"+
				"margin-left: auto !important;"+
				"margin-right: auto !important;"+
				"float: none !important;"+
				"}"+
				"table.center-on-narrow {"+
				"	display: inline-block !important;"+
				"}"+
				""+
				"/* What it does: Adjust typography on small screens to improve readability */"+
				".email-container p {"+
				"	font-size: 17px !important;"+
				"line-height: 22px !important;"+
				"}"+
				""+
			"}"+
			""+
			"</style>"+
			""+
			"<!-- What it does: Makes background images in 72ppi Outlook render at correct size. -->"+ 
			"<!--[if gte mso 9]>"+
			"<xml>"+
			"<o:OfficeDocumentSettings>"+
			"<o:AllowPNG/>"+
			"<o:PixelsPerInch>96</o:PixelsPerInch>"+
			"</o:OfficeDocumentSettings>"+
			"</xml>"+
			"<![endif]-->"+
			""+
			"</head>"+
			"<body width='100%' bgcolor='#093152' style='margin: 0; mso-line-height-rule: exactly;'>"+
			"<center style='width: 100%; background: #093152; text-align: left;'>"+
			""+
			"<!-- Visually Hidden Preheader Text : BEGIN -->"+
			"<div style='display:none;font-size:1px;line-height:1px;max-height:0px;max-width:0px;opacity:0;overflow:hidden;mso-hide:all;font-family: sans-serif;'>"+
			"(Optional) This text will appear in the inbox preview, but not the email body."+
			"</div>"+
			"<!-- Visually Hidden Preheader Text : END -->"+
			""+
			"<!-- Email Body : BEGIN -->"+
			"<table role='presentation' aria-hidden='true' cellspacing='0' cellpadding='0' border='0' align='center' width='600' style='margin: auto;' class='email-container'>"+
			""+
			"<!-- Hero Image, Flush : BEGIN -->"+
			"<tr>"+
			"<td bgcolor='#ffffff'>"+
			"<img src='http://68.media.tumblr.com/77c5be427e5af5395797974d991d576f/tumblr_inline_n6zucia6to1sw8d7s.jpg' aria-hidden='true' width='600' height='' alt='alt_text' border='0' align='center' style='width: 100%; max-width: 600px; height: auto; background: #dddddd; font-family: sans-serif; font-size: 15px; line-height: 20px; color: #555555;' class='g-img'>"+
			"</td>"+
			"</tr>"+
			"<!-- Hero Image, Flush : END -->"+
			""+
			"<!-- 1 Column Text + Button : BEGIN -->"+
			"<tr>"+
			"<td bgcolor='#ffffff' style='padding: 40px 40px 20px; text-align: left;'>"+
			"<h1 style='margin: 0; font-family: sans-serif; font-size: 24px; line-height'+: 27px; color: #333333; font-weight: normal;'>Parabens!<br><br> Sua conta foi criada com sucesso!</h1> <hr>"+
			"</td>"+
			"</tr>"+
			"<tr>"+
			"<td bgcolor='#ffffff' style='padding: 0 40px 40px; font-family: sans-serif; font-size: 15px; line-height: 20px; color: #555555; text-align: left;'>"+
			"<p style='margin: 0;'>Este é um e-mail automático de confirmação. <br>"+
			"Atenção. Matenha seu login e senha em segredo.</p>"+
			"</td>"+
			"</tr>"+
			"<tr>"+
			"<td bgcolor='#ffffff' style='padding: 0 40px 40px; font-family: sans-serif; font-size: 15px; line-height: 20px; color: #555555;'>"+
			"<table role='presentation' aria-hidden='true' cellspacing='0' cellpadding='0' border='0' align='center' style='margin: auto'>"+
			"<tr>"+
			"<td style='border-radius: 3px; background: #222222; text-align: center;' class='button-td'>"+
			"<a href='http://www.deemsolver.com.br' style='background: #222222; border: 15px solid #222222; font-family: sans-serif; font-size: 13px; line-height: 1.1; text-align: center; text-decoration: none; display: block; border-radius: 3px; font-weight: bold;' class='button-a'>"+
			"&nbsp;&nbsp;&nbsp;&nbsp;<span style='color:#ffffff;'>Visitar DeemSolver</span>&nbsp;&nbsp;&nbsp;&nbsp;"+
			"</a>"+
			"</td>"+
			"</tr>"+
			"</table>"+
			"<!-- Button : END -->"+
			"</td>"+
			"</tr>"+
			"<!-- 1 Column Text + Button : END -->"+
			""+
			"</table>"+
			"<!-- Email Body : END -->"+
			""+
			"<!-- Email Footer : BEGIN -->"+
			"<table role='presentation' aria-hidden='true' cellspacing='0' cellpadding='0' border='0' align='center' width='600' style='margin: auto;' class='email-container'>"+
			"<tr>"+
			"<td style='padding: 40px 10px;width: 100%;font-size: 12px; font-family: sans-serif; line-height:18px; text-align: center; color: #888888;' class='x-gmail-data-detectors'>"+
			"<webversion style='color:#cccccc; text-decoration:underline; font-weight: bold;'>Deemsolver.com.br</webversion>"+
			"<br><br>"+
			"DeemSolver<br>Jundiai, São Paulo - Brasil<br>"+
			"<br><br>"+
			"</td>"+
			"</tr>"+
			"</table>"+
			"<!-- Email Footer : END -->"+
			""+
			"</center>"+
			"</body>"+
			"</html>";
		
		
		email.setMensagem(mensagem);
			
		if(!email.getDe().equals("") && !email.getPara().trim().equals("")){
			email.enviarAutenticado();
		}
		
	}
	
}


