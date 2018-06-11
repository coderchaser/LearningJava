package porebook;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 用户属性类
 * @author Bob Liao
 */
public class User {

    private String accountName;
    private String pwd;
    private String gravatarPath;
    private String sex;

    public User(String accountName,String pwd,String gravatarPath, String sex){
        this.accountName = accountName;
        this.gravatarPath = gravatarPath;
        this.sex = sex;
        this.pwd = hashPwd(pwd);
    }

    /**
     * 对传入的用户密码进行哈希加密
     * @param pwd
     * @return 加密之后的pwd
     */
    protected static String hashPwd(String pwd) {
        if (pwd == null) return null;
        if (pwd.equals("")) return "";
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(pwd.getBytes());
            StringBuffer buffer = new StringBuffer();
            for (byte b : result){
                int tmp = b & 0xFF;
                String tmpStr = Integer.toHexString(tmp);
                if (tmpStr.length() == 1){
                    buffer.append("0");
                }
                buffer.append(tmpStr);
            }

            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getAccountName(){
        return this.accountName;
    }
    public String getPwd(){
        return this.pwd;
    }
    public String getGravatarPath(){
        return this.gravatarPath;
    }
    public String getSex(){
        return this.sex;
    }

    public void setAccountName(String accountName){
        this.accountName = accountName;
    }

    public void setGravatarPath(String gravatarPath) {
        this.gravatarPath = gravatarPath;
    }

    public void setPwd(String pwd) {
        this.pwd = hashPwd(pwd);
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof User)){
            return false;
        }
        User toUser = (User) obj;

        return  this.getAccountName().equals(toUser.getAccountName())
                && this.getPwd().equals(toUser.getPwd())
                && this.getSex().equals(toUser.getSex());
    }
}
