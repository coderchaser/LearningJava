package porebook;

import javax.swing.*;
import java.awt.*;


/**
 * 注册界面
 * @author Bob Liao
 */
public class RegistrationPage {

    public RegistrationPage(){

        final User user = new User(null, null, null, null);
        JFrame jFrame = new JFrame("注册");
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setSize(new Dimension(220,150));
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPasswordField pwdField = new JPasswordField();
        JTextField accountNameField = new JTextField();
        JRadioButton maleSexButton = new JRadioButton("男");
        maleSexButton.addActionListener((event)->{
            user.setSex("M");
        });
        maleSexButton.setAlignmentX(60);
        JRadioButton femaleSexButton = new JRadioButton("女");
        femaleSexButton.addActionListener(e -> {
            user.setSex("F");
        });
        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(maleSexButton);
        sexGroup.add(femaleSexButton);
        JButton doneButton = new JButton("完成");
        JLabel accountNameLabel = new JLabel("账号",JLabel.RIGHT);
        JLabel pwdLabel = new JLabel("密码",JLabel.RIGHT);

        doneButton.addActionListener((event)->{
            if(accountNameField.getText().toString().equals("") | accountNameField.getText().toString().contains(" ")) {
                JOptionPane.showMessageDialog(jFrame, "请输入正确的用户名！");
                return;
            }
            String pwd = String.valueOf(pwdField.getPassword());
            if(pwd.equals("") | pwd.contains(" ")) {
                JOptionPane.showMessageDialog(jFrame, "密码必须为英文字母及数字组合！");
                return;
            }
            if (!femaleSexButton.isSelected() && !maleSexButton.isSelected()){
                JOptionPane.showMessageDialog(buttonPanel, "请选择性别！");
                return;
            }
            String accountName = accountNameField.getText().toString();
            user.setAccountName(accountName);
            user.setPwd(pwd);
            user.setGravatarPath(null);
            //TODO:写入数据库
            DaoToUserInfo daoToUserInfo = new DaoToUserInfo("porebook");
            if (daoToUserInfo.queryIsExisted(user)){
                JOptionPane.showMessageDialog(jFrame, "用户已存在！");
            }
            else {
                daoToUserInfo.insert(user);
                JOptionPane.showMessageDialog(jFrame, "注册成功！");
                jFrame.dispose();
            }
        });


        Container container = jFrame.getContentPane();

        jPanel.setLayout(new GridLayout(3,2,5,5));
        jPanel.add(accountNameLabel);
        jPanel.add(accountNameField);
        jPanel.add(pwdLabel);
        jPanel.add(pwdField);
        jPanel.add(maleSexButton);
        jPanel.add(femaleSexButton);

        buttonPanel.add(doneButton);

        container.add(jPanel,BorderLayout.NORTH);
        container.add(buttonPanel, BorderLayout.SOUTH);

        jFrame.setVisible(true);

    }

    public static void main(String[] args){
        new RegistrationPage();
    }
}
