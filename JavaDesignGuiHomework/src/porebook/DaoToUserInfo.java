package porebook;

import java.sql.*;
import java.util.TreeMap;

/**
 * 访问用户信息数据库
 * @author Bob Liao
 */
public class DaoToUserInfo {

    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private String dbUrl;

	/**
	 * 构造器
	 * @param dn 数据库名称，porebook
	 */
	public DaoToUserInfo(String dn){
        dbUrl = String.format("jdbc:mysql://localhost/%s?"+
                "user=bob&password=Bobliao312&useSSL=true",dn);
	}


	/**
	 * 注册新用户向数据库里插入记录
	 * @param user 需要插入数据库的用户
	 */
    protected void insert(User user){
	    Connection conn = null;
        try {
            conn=DriverManager.getConnection(this.dbUrl);
        } catch (SQLException e){
            e.printStackTrace();
        }
	    String sql = "INSERT IGNORE INTO user (name, pwd, sex, gravatar) VALUES(?, ?, ?, ?)";
	    PreparedStatement preparedStatement;
	    try {
	        preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
	        preparedStatement.setString(1, user.getAccountName());
	        preparedStatement.setString(2, user.getPwd());
	        preparedStatement.setString(3, user.getSex());
	        preparedStatement.setString(4, user.getGravatarPath());
	        preparedStatement.executeUpdate();
	        preparedStatement.close();
	        conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

	/**
	 * 判断用户密码是否正确
	 * @param user 用户
	 * @return boolean whether the pwd passed in is right or not.
	 */
	protected boolean queryUser(User user){
	    String querry ="SELECT * FROM user WHERE name = ?";
	    PreparedStatement preparedStatement;
	    try {
	        Connection conn = DriverManager.getConnection(this.dbUrl);
	        preparedStatement = conn.prepareStatement(querry);
	        preparedStatement.setString(1, user.getAccountName());
//	        preparedStatement.setString(2, user.getSex());
	        ResultSet rs = preparedStatement.executeQuery();
	        if (!rs.next()){
	            return false;
            }
	        String pwd = rs.getString("pwd");
	        return pwd.equals(user.getPwd());
        }catch (SQLException e){
	        e.printStackTrace();
        }
	    return false;
    }

	/**
	 * Get the gravatar path of the passed in user.
	 * @param user
	 * @return Absolute path of the picture.
	 */
	protected String getGravatarPath(User user){
		String stm = "SELECT gravatar FROM user WHERE name = ?";
		PreparedStatement preparedStatement;
		String gravatarPath = null;
		try {
			Connection conn = DriverManager.getConnection(this.dbUrl);
			preparedStatement = conn.prepareStatement(stm);
			preparedStatement.setString(1, user.getAccountName());
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			gravatarPath = rs.getString("gravatar");
		}catch (SQLException e){
			e.printStackTrace();
		}
		return gravatarPath;
	}

	/**
	 * Get the self-introduction of the passed in user.
	 * @param user
	 * @return Self-introduction.
	 */
	protected String getSelfIntroduction(User user){
		String stm = "SELECT selfintroduction FROM user WHERE (name = ? AND pwd = ?)";
		PreparedStatement preparedStatement;
		String selfIntroduction = null;
		try{
			Connection connection = DriverManager.getConnection(this.dbUrl);
			preparedStatement = connection.prepareStatement(stm);
			preparedStatement.setString(1, user.getAccountName());
			preparedStatement.setString(2, user.getPwd());
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			selfIntroduction = rs.getString("selfintroduction");
		}catch (SQLException e){
			e.printStackTrace();
		}
		if (selfIntroduction == null) selfIntroduction = String.format("Hello, I am %s!", user.getAccountName());
		if (selfIntroduction != null && selfIntroduction.equals("")) selfIntroduction = String.format("Hello, I am %s!", user.getAccountName());
		return selfIntroduction;
	}

	/**
	 * Query that whether the user's name passed in exists in the database.
	 * @param user
	 * @return boolean
	 */
	protected Boolean queryIsExisted(User user){
	    String stm = "SELECT COUNT(*) FROM user WHERE name = ?";
	    int count = 0;
	    PreparedStatement preparedStatement;
	    try {
	        Connection connection = DriverManager.getConnection(this.dbUrl);
	        preparedStatement = connection.prepareStatement(stm);
	        preparedStatement.setString(1, user.getAccountName());
	        ResultSet rs = preparedStatement.executeQuery();
	        rs.next();
	        count = rs.getInt("COUNT(*)");
        }catch (SQLException e){
	        e.printStackTrace();
        }
	    return count != 0;
    }
	public static void main(String[] args) {
	    DaoToUserInfo dao = new DaoToUserInfo("porebook");
	    //测试注册功能
        System.out.println(dao.queryUser(new User("foo", "ss", null, "F")));
	}
}