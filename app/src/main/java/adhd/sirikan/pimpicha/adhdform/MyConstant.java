package adhd.sirikan.pimpicha.adhdform;

/**
 * Created by TheUser on 30/3/2560.
 */

public class MyConstant {
    //Explicit
    private String urlAddUser = "http://adhdpj.com/app/addUserPim.php";
    private String urlGetUser = "http://adhdpj.com/app/getUser.php";
    private String[] columnUser = new String[]{"id", "User", "Password", "Type"};

    private String hostString = "ftp.adhdpj.com";
    private String userString = "adhd@adhdpj.com";
    private String passwordString = "Pimpluempj402";
    private int portAnInt = 21;

    public String[] getColumnUser() {
        return columnUser;
    }

    public String getUrlGetUser() {
        return urlGetUser;
    }

    public String getUrlAddUser() {
        return urlAddUser;
    }
}//main class
