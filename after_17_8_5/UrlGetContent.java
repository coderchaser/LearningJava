package courseraJavaDesign;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class UrlGetContent {
	//private String baseUrl;
	//�����ѷ���URL��ַ
	private List<String> urlList=new ArrayList<String>();
	private String url="";
	JFrame baseFrame =new JFrame("UrlDownloader");
	//����ط����ò��ֲ�֪��Ϊʲôû���ã��Ժ���ȥ�ٶ�һ�¡�
	JPanel firstPanel=new JPanel(new GridLayout(4,4,5,5));
	JPanel secondPanel=new JPanel(new GridLayout());
	
	JTextArea baseArea=new JTextArea();
	JTextField baseText=new JTextField(20);
	
	JButton getUrlButton=new JButton("Get this page!");
	//showEncodingButton�İ��¼�ΪgetCharCode(),��ʱûд -^-
	JButton showEncodingButton=new JButton("Encoding");
	JButton seeIfDuplicateButton=new JButton("DuplicationCheck");
	
	public UrlGetContent() {
		getUrlButton.setToolTipText("Get the content of the input Url.");
		showEncodingButton.setToolTipText("Get the encoding of this page.");
		seeIfDuplicateButton.setToolTipText("Duplication Check.");
		
		//��ÿ����ť���¼�
		getUrlButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(()->{
					SwingUtilities.invokeLater(()->
					{
						baseArea.append(getUrlContent());
					});
				}).start(); 
			}
		});
		showEncodingButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		seeIfDuplicateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				checkDuplication();
			}
		});
		
		//�趨baseText��ʾ��Ϣ
		baseText.addFocusListener(new FocusAdapter() {
				String info="Enter your URL here";
			   @Override
	            public void focusGained(FocusEvent e)
	            {
				   if(baseText.getText().equals(info)){
					   baseText.setText("");
				   }
	            }
	            @Override
	            public void focusLost(FocusEvent e)
	            {
	            	if(baseText.getText().equals("")){
	            		 baseText.setText("Enter your URL here");
	            	}
	            }
		});
		//�趨baseArea�Զ����У����Ǹо���û���ã���֪����ôŪ
		baseArea.setLineWrap(true);
		
		firstPanel.add(baseText);
		firstPanel.add(seeIfDuplicateButton);
		firstPanel.add(getUrlButton);
		firstPanel.add(showEncodingButton);
		firstPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//		baseAreaScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		baseAreaScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JScrollPane baseAreaScroller=new JScrollPane(baseArea);
		secondPanel.add(baseAreaScroller, BorderLayout.CENTER);
		
		baseFrame.getContentPane().setLayout(new BorderLayout());
		baseFrame.getContentPane().add(firstPanel, BorderLayout.NORTH);
		baseFrame.getContentPane().add(secondPanel, BorderLayout.SOUTH);
		baseFrame.setLocation(500, 400);
		baseFrame.setResizable(true);
		baseFrame.pack();
		baseFrame.setVisible(true);
	}
	
	public String getUrlContent() {
		try {
				url=baseText.getText();
				if (!url.startsWith("http://")) {
					url="http://"+url;
				}
				this.urlList.add(url);
				URL firstUrl=new URL(url);
				InputStream urlstream=firstUrl.openStream();
				String content=readall(urlstream,"utf-8");
				return content;
		} catch (MalformedURLException e) {
				//��ʾ������ȷURL
				JOptionPane.showMessageDialog(baseFrame, "Please Input "
					+ "the correct URL",JOptionPane.INITIAL_VALUE_PROPERTY, 0);
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("IO Exception.");
		}
		return "";
	}
		
	private String readall(InputStream urlstream, String charcode) throws IOException {
		BufferedReader streamreader=new BufferedReader(new InputStreamReader(urlstream,charcode));
		StringBuilder sb=new StringBuilder();
		String line;
		while ((line=streamreader.readLine())!=null) {
			sb.append(line+"\n");
		}
		return sb.toString();
	}
	
	//�����ַ�Ƿ��ظ�
	private void checkDuplication() {
		if(urlList.contains(url)){
			//����"This URL has been crawled!"����ʾ
			JOptionPane.showMessageDialog(baseFrame, "This URL has been crawled!");
		}
	}
	
	//�պ���˵
	@SuppressWarnings("unused")
	private String getCharCode() {
		//TODO Add the GetCharCode function.
		return "";
	}
	public static void main(String[] args) {
		new UrlGetContent();
	}

}
