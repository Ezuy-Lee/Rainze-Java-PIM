package com.email.send.param;

/**
 * 邮件发送类型
 */
public enum EmailType {

    EMAIL_TEXT_KEY("email_text_key","文本邮件"),
    EMAIL_IMAGE_KEY("email_image_key","图片邮件"),
    EMAIL_FILE_KEY("email_file_key","文件邮件");

    private String code ;
    private String value ;
    EmailType (String code,String value){
        this.code = code ;
        this.value = value ;
    }

    public static String getByCode (String code){
        EmailType[] values = EmailType.values() ;
        for (EmailType emailType : values) {
            if (emailType.code.equalsIgnoreCase(code)){
                return emailType.value ;
            }
        }
        return null ;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
