package porebook;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * 登陆界面
 * @author Bob Liao
 */
public class LoginPage implements ActionListener {
	private JFrame loginJframe;
	private JPanel loginJpanel;
	private JLabel userLabel;
	private JLabel pwdLabel;
	private JTextField userNameTxt;
	private JPasswordField pwdTxt;
	private JButton loginJBtn;
	private JButton exitJBtn;
	private JButton registerJBtn;
	private JLabel registrationJLbl;
	
	public LoginPage(){
		/*
		 * JFrame初始化
		 */
		loginJframe=new JFrame("PoreBook");
		loginJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginJframe.setSize(300, 150);
		loginJframe.setLocationRelativeTo(null);//使JFrame居中显示
		loginJframe.setLayout(new BorderLayout());
		loginJframe.setResizable(false);
		loginJpanel = new JPanel();
		loginJpanel.setLayout(new GridLayout(4, 2,2,2));
		
		Container con = loginJframe.getContentPane();

		userLabel=new JLabel("用户名：",JLabel.RIGHT);
		pwdLabel = new JLabel("密码：",JLabel.RIGHT);
		userNameTxt = new JTextField();
		pwdTxt = new JPasswordField();
		userNameTxt.setToolTipText("请输入用户名");
		pwdTxt.setToolTipText("请输入密码");
		loginJBtn = new JButton("登陆");
		loginJBtn.addActionListener(this);
		exitJBtn = new JButton("退出");
		exitJBtn.addActionListener(this::actionPerformed);
        registerJBtn = new JButton("注册");
        registerJBtn.addActionListener(this::actionPerformed);
        registrationJLbl = new JLabel("没有账号请请先注册");
		
		loginJpanel.add(userLabel);
		loginJpanel.add(userNameTxt);
		loginJpanel.add(pwdLabel);
		loginJpanel.add(pwdTxt);
		loginJpanel.add(loginJBtn);
		loginJpanel.add(exitJBtn);
		loginJpanel.add(registerJBtn);
		loginJpanel.add(registrationJLbl);
		
		con.add(loginJpanel,BorderLayout.CENTER);
		loginJframe.setVisible(true);
	}
	
	public static void main(String[] args) {
		new LoginPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton)e.getSource();

		if (button.equals(this.loginJBtn)){

            String account = userNameTxt.getText();
            String pwd = String.valueOf(pwdTxt.getPassword());

			if(account.equals("") | pwd.equals("")) {
				JOptionPane.showMessageDialog(this.loginJframe,"请输入正确的用户名及密码！");
				return;
			}
			User user = new User(account, pwd, null, null);
			Boolean[] result = {false};
			class CustomRunnable implements Runnable{
                @Override
                public void run() {
                    synchronized (result){
                        result[0] = new DaoToUserInfo("porebook").queryUser(user);
                    }
                }
            }
			/*
			这里查询数据库其实可以直接 Boolean result = new DaoToUserInfo("porebook").queryUser(user);
			为什么呢？因为另开一个线程去做这一件事，查询数据库需要时间，如果不像下面调用join阻塞主线程的话，result[0]的值
			并不会立刻改变，这样会造成判断失误。虽然我这里做了同步处理，加了synchronized关键字，但这个只能保证result[0]的
			值同一时刻只能被一个线程操作，并不能让主线程等待查询结果返回之后在进行判断。总之，这里查询数据库可以像这样调用join，
			更好的是像上面那样直接同一线程查询。
			 */
            Thread t = new Thread(new CustomRunnable());
			t.start();
			try {
			    t.join();
            }catch (InterruptedException interexception){

            }

			if (result[0]){
				new HomePage(user);
				this.loginJframe.dispose();//登陆成功销毁登陆窗口
			}
			else {
			    JOptionPane.showMessageDialog(this.loginJframe, "用户名或密码出错！");
            }

		}else if (button.equals(this.registerJBtn)){
			//跳转至注册窗口
			new RegistrationPage();
		}else {
			System.exit(0);
		}
	}
}