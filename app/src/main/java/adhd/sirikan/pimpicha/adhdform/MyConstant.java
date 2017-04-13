package adhd.sirikan.pimpicha.adhdform;

/**
 * Created by TheUser on 30/3/2560.
 */

public class MyConstant {

    //Explicit
    private String urlAddUser = "http://adhdpj.com/app/addUserPim.php";
    private String urlGetUser = "http://adhdpj.com/app/getUser.php";
    private String[] columnUser = new String[]{"id", "User", "Password", "Type"};
    private String urlAddChild = "http://adhdpj.com/app/addChildPim.php";
    private  String urlGetChild = "http://adhdpj.com/app/getChild.php";
    private  String urlAddSnap = "http://adhdpj.com/app/addSnapPim.php";
    private  String urlAddTest = "http://adhdpj.com/app/addTest.php";
    private  String urlAddTass = "http://adhdpj.com/app/addThass.php";
    //ถ้าใส่ตารางเพิ่มเข้อมูลเด็กต้องมาใส่ตรงนี้ด้วย
    private String[] columnChild = new String[]{"id","id_Login","Name","Age","Image"};
    private  String[] columnSnap = new String[]{"ch1","ch2","ch3","ch4","ch5","ch6","ch7","ch8"
            ,"ch9","ch10","ch11","ch12","ch13","ch14","ch15","ch16","ch17","ch18","ch19","ch20","ch21","ch22"
            ,"ch23","ch24","ch25","ch26","childID","id","risk1","risk2","risk3"};

        //for FTP
    private String hostString = "ftp.adhdpj.com";
    private String userString = "adhd@adhdpj.com";
    private String passwordString = "Pimpluempj402";
    private int portAnInt = 21;

    public String[] getColumnChild() {
        return columnChild;
    }

    public String getUrlGetChild() {
        return urlGetChild;
    }

    public String getUrlAddChild() {
        return urlAddChild;
    }

    public String getHostString() {
        return hostString;
    }

    public String getUserString() {
        return userString;
    }

    public String getPasswordString() {
        return passwordString;
    }

    public int getPortAnInt() {
        return portAnInt;
    }

    public String[] getColumnUser() {
        return columnUser;
    }

    public String getUrlGetUser() {
        return urlGetUser;
    }

    public String getUrlAddUser() {
        return urlAddUser;
    }
    public  String[]  getColumnSnap(){
        return  columnSnap;
    }
    public  String getUrlAddSnap(){
        return  urlAddSnap;
    }

    public  String getUrlAddTest(){
        return urlAddTest;
    }
    public  String getUrlAddTass(){
        return urlAddTass;
    }
}//main class
