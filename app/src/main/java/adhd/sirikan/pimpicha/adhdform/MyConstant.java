package adhd.sirikan.pimpicha.adhdform;

/**
 * Created by TheUser on 30/3/2560.
 */

public class MyConstant {

    //Explicit
    private String urlAddUser = "http://adhdpj.com/app/addUserPim.php";
    private String urlGetUser = "http://adhdpj.com/app/getUser.php";

    private String urlAddChild = "http://adhdpj.com/app/addChildPim.php";
    private String urlGetChild = "http://adhdpj.com/app/getChild.php";
    private String urlAddSnap = "http://adhdpj.com/app/addSnapPim.php";
    private String urlAddTest = "http://adhdpj.com/app/addTest.php";
    private String urlAddTass = "http://adhdpj.com/app/addThass.php";
    private String urlAddSdq = "http://adhdpj.com/app/addSdq.php";
    private String urlGetUrlThestWhere = "http://adhdpj.com/app/getTestWhere.php";
    private String urlGetUrlThestWhere2 = "http://adhdpj.com/app/getTestWhere2.php";

    private String urlEditSpecial = "http://adhdpj.com/app/editSpecial.php";
    private String urlEditSpecial2 = "http://adhdpj.com/app/editSpecial2.php";
    private String urlEditSpecial3 = "http://adhdpj.com/app/editSpecial3.php";

    private String urlGetChildWhereID = "http://adhdpj.com/app/getChildWhereID.php";
    private String urlGetChildWhereID2 = "http://adhdpj.com/app/getChildWhereID2.php";
    private String urlGetChildWhereID3 = "http://adhdpj.com/app/getChildWhereID3.php";

    private String urlGetTestWhereID = "http://adhdpj.com/app/getTestWhereID.php";
    private String urlGetTestWhereID2 = "http://adhdpj.com/app/getTestWhereID2.php";
    private String urlGetTestWhereID3 = "http://adhdpj.com/app/getTestWhereID3.php";

    private String urlGetDeleteChild = "http://adhdpj.com/app/deleteChild.php";


    //ถ้าใส่ตารางเพิ่มเข้อมูลเด็กต้องมาใส่ตรงนี้ด้วย
    private String[] columnUser = new String[]{"id", "User", "Password", "Type"};
    private String[] columnChild = new String[]{"id", "id_Login", "Name", "Age", "Image","gender"};
    private String[] columnTest = new String[]{"id", "ch1", "ch2", "ch3", "ch4", "ch5", "ch6", "ch7", "ch8"
            , "ch9", "ch10", "ch11", "ch12", "ch13", "ch14", "ch15", "ch16", "ch17", "ch18", "ch19", "ch20", "ch21", "ch22"
            , "ch23", "ch24", "ch25", "ch26", "userID", "childID", "risk1", "risk2", "risk3", "doType", "Special", "CurrentDate"};
    private String[] columnTest2 = new String[]{"id", "t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8"
            , "t9", "t10", "t11", "t12", "t13", "t14", "t15", "t16", "t17", "t18", "t19", "t20", "t21", "t22"
            , "t23", "t24", "t25", "t26" , "t27", "t28","t29","t30", "tuserID", "tchildID", "risk1", "risk2", "risk3", "doType", "Special", "CurrentDate"};
    private String[] columnTest3 = new String[]{"id", "ch1", "ch2", "ch3", "ch4", "ch5", "ch6", "ch7", "ch8"
            , "ch9", "ch10", "ch11", "ch12", "ch13", "ch14", "ch15", "ch16", "ch17", "ch18", "ch19", "ch20", "ch21", "ch22"
            , "ch23", "ch24", "ch25", "userID", "childID", "risk1", "doType", "Special", "CurrentDate"};

    //for FTP
    private String hostString = "ftp.adhdpj.com";
    private String userString = "adhd@adhdpj.com";
    private String passwordString = "Pimpluempj402";
    private int portAnInt = 21;


    public String getUrlGetDeleteChild() {
        return urlGetDeleteChild;
    }

    public String getUrlGetTestWhereID() {
        return urlGetTestWhereID;
    }

    public String getUrlGetTestWhereID2() {
        return urlGetTestWhereID2;
    }

    public String getUrlGetTestWhereID3() {
        return urlGetTestWhereID3;
    }

    public String[] getColumnTest() {
        return columnTest;
    }
    public String[] getColumnTest2() {
        return columnTest2;
    }
    public String[] getColumnTest3() {
        return columnTest3;
    }

    public String getUrlGetChildWhereID() {
        return urlGetChildWhereID;
    }

    public String getUrlEditSpecial() {
        return urlEditSpecial;
    }

    public String getUrlGetUrlThestWhere() {
        return urlGetUrlThestWhere;
    }
    public String getUrlGetUrlThestWhere2() {
        return urlGetUrlThestWhere2;
    }

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

    public String[] getColumnSnap() {
        return columnTest;
    }

    public String getUrlAddSnap() {
        return urlAddSnap;
    }

    public String getUrlAddTest() {
        return urlAddTest;
    }

    public String getUrlAddTass() {
        return urlAddTass;
    }

    public String getUrlEditSpecial2() {
        return urlEditSpecial2;
    }

    public String getUrlEditSpecial3() {
        return urlEditSpecial3;
    }

    public String getUrlAddSdq() {
        return urlAddSdq;
    }

    public String getUrlGetChildWhereID2() {
        return urlGetChildWhereID2;
    }

    public String getUrlGetChildWhereID3() {
        return urlGetChildWhereID3;
    }
}//main class
