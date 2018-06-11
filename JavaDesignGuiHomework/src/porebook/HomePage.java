package porebook;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 登陆成功后的个人主页
 * @author Bob Liao
 */
public class HomePage {

    private User user;
    private JFrame mainFrame;
    private JPanel gravatarPanel;
    private JLabel name;
    private JLabel selfIntroduction;

    public HomePage(User user){
        this.user = user;

        mainFrame = new JFrame("主页");
        mainFrame.setSize(400,500);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
//        GridBagLayout gridBagLayout = new GridBagLayout();
        mainFrame.setLayout(new BorderLayout());
//        mainFrame.setLayout(new BorderLayout());
        //TODO:解决使用gridbaglayout布局时图片不显示的问题
        gravatarPanel = new JPanel(){
            private Image gravatar;

            /**
             * 重写paint方法来绘制图片
             * @param g
             */
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                gravatar = HomePage.this.getGravatar();
                //缩放
                gravatar = gravatar.getScaledInstance(200 , 200, Image.SCALE_DEFAULT);
                g.drawImage(gravatar,0,0,null);
            }
        };

        name = new JLabel();
        name.setFont(new Font("楷体", Font.BOLD, 40));
        name.setText(user.getAccountName());

        selfIntroduction = new JLabel();
        selfIntroduction.setText(new DaoToUserInfo("porebook").getSelfIntroduction(user));

//        mainFrame.add(gravatarPanel,new GBC(0, 0)
//                .setAnchor(GridBagConstraints.CENTER)
//        .setWeight(100, 100));
        mainFrame.add(gravatarPanel);
        mainFrame.add(name, BorderLayout.EAST);
        mainFrame.add(selfIntroduction, BorderLayout.SOUTH);
        mainFrame.setVisible(true);

    }



    private Image getGravatar(){
        DaoToUserInfo daoToUserInfo = new DaoToUserInfo("porebook");
        Image gravatar = null;
        String gravatarPath = daoToUserInfo.getGravatarPath(user) != null ? daoToUserInfo.getGravatarPath(user) : "./gravatar/default.png";
        try {
            gravatar = ImageIO.read(new File(gravatarPath));
        }catch (IOException e){
            e.printStackTrace();
        }
        return gravatar;
    }

    public static void main(String[] args){
        HomePage homePage = new HomePage(new User("foo", "ss", null, null));
//        System.out.println(homePage.getGravatar());
    }
}
