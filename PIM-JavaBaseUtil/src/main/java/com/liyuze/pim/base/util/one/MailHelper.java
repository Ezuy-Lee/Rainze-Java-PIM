package com.liyuze.pim.base.util.one;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

/**   
* @Title: MailHelper.java 
* @Package com.jarvis.base.util 
* @Description:mail工具类
* @author Jack  
* @date 2017年9月2日 下午3:39:46 
* @version V1.0   
*/ 
public class MailHelper
{
    /**
     * 简单的发邮件方式    邮件内容只有标题和邮件内容  支持单个个用户发送
     *
     * @param host             邮件服务器地址
     * @param username         连接邮件服务器的用户名称
     * @param password         连接邮件服务器的用户密码
     * @param subject          邮件的主题
     * @param contents         邮件的内容
     * @param toEmailAddress   收件人的邮件地址
     * @param fromEmailAddress 发件人的邮件地址
     * @throws EmailException
     */
    public static void sendSimpleEmail(String host, String username, String password, String subject, String contents,
                                       String toEmailAddress, String fromEmailAddress) throws EmailException
    {
        SimpleEmail email = new SimpleEmail();
        email.setHostName(host);
        email.setAuthentication(username, password);
        email.addTo(toEmailAddress);
        email.setFrom(fromEmailAddress, fromEmailAddress);
        email.setSubject(subject);
        email.setContent((Object)contents, "text/plain;charset=GBK");
        email.send();
    }

    /**
     * 简单的发邮件方式    邮件内容只有标题和邮件内容  支持多个用户批量发送
     *
     * @param host             邮件服务器地址
     * @param username         连接邮件服务器的用户名称
     * @param password         连接邮件服务器的用户密码
     * @param subject          邮件的主题
     * @param contents         邮件的内容
     * @param toEmailAddress   收件人的邮件地址
     * @param fromEmailAddress 发件人的邮件地址
     * @throws EmailException
     */
    public static void sendSimpleEmail(String host, String username, String password, String subject, String contents, String [] toEmailAddress, String fromEmailAddress) throws EmailException
    {
        SimpleEmail email = new SimpleEmail();
        email.setHostName(host);
        email.setAuthentication(username, password);
        //发送给多个人
        for (int i = 0; i < toEmailAddress.length; i++)
        {
            email.addTo(toEmailAddress[i], toEmailAddress[i]);
        }
        email.setFrom(fromEmailAddress, fromEmailAddress);
        email.setSubject(subject);
        email.setContent((Object)contents, "text/plain;charset=GBK");
        email.send();
    }

    /**
     * 发送带附件的邮件方式  邮件内容有标题和邮件内容和附件，附件可以是本地机器上的文本，也可以是web上的一个URL 文件，
     * 当为web上的一个URL文件时，此方法可以将WEB中的URL文件先下载到本地，再发送给收入用户
     *
     * @param host             邮件服务器地址
     * @param username         连接邮件服务器的用户名称
     * @param password         连接邮件服务器的用户密码
     * @param subject          邮件的主题
     * @param contents         邮件的内容
     * @param toEmailAddress   收件人的邮件地址
     * @param fromEmailAddress 发件人的邮件地址
     * @param multiPaths       附件文件数组
     * @throws EmailException
     */

    public static void sendMultiPartEmail(String host, String username, String password, String subject,
                                          String contents, String toEmailAddress, String fromEmailAddress,
                                          String []multiPaths) throws MalformedURLException, EmailException
    {
        List<EmailAttachment> attachmentList = new ArrayList<EmailAttachment>();
        if (multiPaths != null)
        {
            for (int i = 0; i < multiPaths.length; i++)
            {
                EmailAttachment attachment = new EmailAttachment();
                if (multiPaths[i].indexOf("http") == -1)   //判断当前这个文件路径是否在本地  如果是：setPath  否则  setURL;
                {
                    attachment.setPath(multiPaths[i]);
                }
                else
                {
                    attachment.setURL(new URL(multiPaths[i]));
                }
                attachment.setDisposition(EmailAttachment.ATTACHMENT);
                attachment.setDescription("");
                attachmentList.add(attachment);
            }
        }

        //发送邮件信息
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(host);
        email.setAuthentication(username, password);
        email.addTo(toEmailAddress);
        email.setFrom(fromEmailAddress, fromEmailAddress);
        email.setSubject(subject);
        email.setMsg(contents);   //注意这个不要使用setContent这个方法  setMsg不会出现乱码
        for (int i = 0; i < attachmentList.size(); i++)   //添加多个附件
        {
            email.attach((EmailAttachment) attachmentList.get(i));
        }
        email.send();
    }

    /**
     * 发送带附件的邮件方式  邮件内容有标题和邮件内容和附件，附件可以是本地机器上的文本，也可以是web上的一个URL 文件，
     * 当为web上的一个URL文件时，此方法可以将WEB中的URL文件先下载到本地，再发送给收入用户
     *
     * @param host             邮件服务器地址
     * @param username         连接邮件服务器的用户名称
     * @param password         连接邮件服务器的用户密码
     * @param subject          邮件的主题
     * @param contents         邮件的内容
     * @param toEmailAddress   收件人的邮件地址数组
     * @param fromEmailAddress 发件人的邮件地址
     * @param multiPaths       附件文件数组
     * @throws EmailException
     */

    public static void sendMultiPartEmail(String host, String username, String password, String subject,
                                          String contents, String[] toEmailAddress, String fromEmailAddress,
                                          String []multiPaths) throws MalformedURLException, EmailException
    {
        List<EmailAttachment> attachmentList = new ArrayList<EmailAttachment>();
        if (multiPaths != null)
        {
            for (int i = 0; i < multiPaths.length; i++)
            {
                EmailAttachment attachment = new EmailAttachment();
                if (multiPaths[i].indexOf("http") == -1)   //判断当前这个文件路径是否在本地  如果是：setPath  否则  setURL;
                {
                    attachment.setPath(multiPaths[i]);
                }
                else
                {
                    attachment.setURL(new URL(multiPaths[i]));
                }
                attachment.setDisposition(EmailAttachment.ATTACHMENT);
                attachment.setDescription("");
                attachmentList.add(attachment);
            }
        }

        //发送邮件信息
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(host);
        email.setAuthentication(username, password);
        //发送给多个人
        for (int i = 0; i < toEmailAddress.length; i++)
        {
            email.addTo(toEmailAddress[i], toEmailAddress[i]);
        }
        email.setFrom(fromEmailAddress, fromEmailAddress);
        email.setSubject(subject);
        email.setMsg(contents);   //注意这个不要使用setContent这个方法  setMsg不会出现乱码
        for (int i = 0; i < attachmentList.size(); i++)   //添加多个附件
        {
            email.attach((EmailAttachment) attachmentList.get(i));
        }
        email.send();
    }


    /**
     * 发送Html格式的邮件
     *
     * @param host             邮件服务器地址
     * @param username         连接邮件服务器的用户名称
     * @param password         连接邮件服务器的用户密码
     * @param subject          邮件的主题
     * @param contents         邮件的内容
     * @param toEmailAddress   收件人的邮件地址
     * @param fromEmailAddress 发件人邮件地址
     * @throws EmailException
     */
    public static void sendHtmlEmail(String host, String username, String password, String subject, String contents, String toEmailAddress, String fromEmailAddress) throws EmailException
    {
        HtmlEmail email = new HtmlEmail();
        //email.setDebug(true);
        email.setHostName(host);
        email.setAuthentication(username, password);
        email.addTo(toEmailAddress);
        email.setFrom(fromEmailAddress, fromEmailAddress);
        email.setSubject(subject);
        email.setHtmlMsg(CharHelper.GBKto8859(contents));
        email.send();
    }

    /**
     * 发送Html格式的邮件
     *
     * @param host             邮件服务器地址
     * @param username         连接邮件服务器的用户名称
     * @param password         连接邮件服务器的用户密码
     * @param subject          邮件的主题
     * @param contents         邮件的内容
     * @param toEmailAddress   收件人的邮件地址数组
     * @param fromEmailAddress 发件人邮件地址
     * @throws EmailException
     */
    public static void sendHtmlEmail(String host, String username, String password, String subject, String contents, String[] toEmailAddress, String fromEmailAddress) throws EmailException
    {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(host);
        email.setAuthentication(username, password);
        //发送给多个人
        for (int i = 0; i < toEmailAddress.length; i++)
        {
            email.addTo(toEmailAddress[i], toEmailAddress[i]);
        }
        email.setFrom(fromEmailAddress, fromEmailAddress);
        email.setSubject(subject);
        email.setHtmlMsg(CharHelper.GBKto8859(contents));
        email.send();
    }
}
