package adhd.sirikan.pimpicha.adhdform;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.jibble.simpleftp.SimpleFTP;

import java.io.File;
import java.util.jar.Attributes;

public class AddChildActivity extends AppCompatActivity implements View.OnClickListener {
    // Explecit
    private ImageView imageView;
    private EditText nameEditText, ageEditText;
    private RadioGroup radioGroup;
    private  RadioButton    maleRadioButton, femaleRadioButton;
    private Button button;
    private Uri uri; // got only picture
    private String tag = "31MarchV1";
    private  String pathImageString ,nameImageString,nameChildString,ageString,loginString[] ;
    private boolean aBoolean =true;
    private  String gender;
    private int ageInt;
    ImageView backView;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);
        loginString = getIntent().getStringArrayExtra("Login");

        //initial View
        initialView();
        
        //controller
        controller();


    }//main method

    private void controller() {
        imageView.setOnClickListener(AddChildActivity.this);
        button.setOnClickListener(AddChildActivity.this);
        backView.setOnClickListener(AddChildActivity.this);
    }

    private void initialView() {
        imageView = (ImageView) findViewById(R.id.imvRegister);
        nameEditText = (EditText) findViewById(R.id.edtName);
        ageEditText = (EditText) findViewById(R.id.edtAge);
        radioGroup = (RadioGroup) findViewById(R.id.ragGender);
        maleRadioButton = (RadioButton) findViewById(R.id.radMale);
        femaleRadioButton = (RadioButton) findViewById(R.id.radFemale);
        button = (Button) findViewById(R.id.btnSave);
        backView = (ImageView) findViewById(R.id.backfromAddchild);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data); // work after choose

        if (resultCode==RESULT_OK) {
            uri = data.getData();
            //show Image choose on ImageView
            showImageChoose();

            // find Path Image
            findPathImage();

            //find name img
            findNameImage();
            aBoolean = false;

        }// true when select pic
    } // onactivity

    private void findNameImage() {
        nameImageString = pathImageString.substring(pathImageString.lastIndexOf("/")); // only last of path after /
        Log.d(tag,"nameImage ==>" + nameImageString);

    }

    private void findPathImage() {
        String[] strings = new String[]{MediaStore.Images.Media.DATA}; // choose path
        Cursor cursor =  getContentResolver().query(uri, strings,null,null,null);
        if (cursor != null) {
            cursor.moveToFirst();
            int i = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            pathImageString = cursor.getString(i);
        } else {
            pathImageString = uri.getPath();
        }
        Log.d(tag,"path Image ==>" + pathImageString); // know image path

    }

    private void showImageChoose() {
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri)); // bitmap find and show picture in imv
            imageView.setImageBitmap(bitmap);

        }catch (Exception e){
            Log.d(tag,"e showImage ==> "+ e.toString());
        }
    }

    @Override
    public void onClick(View v) {
        //for image
        if (v.equals(imageView)) {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent,"Please choose App?"),1);   // 1 mean  1 photo

        }


        // for button
        if (v==button) {
            buttonController();
        }
        if (v==backView){
            Intent intent = new Intent(AddChildActivity.this,ServiceActivity.class);
            intent.putExtra("Login", loginString);
            startActivity(intent);
        }


    }//onclick

    private void buttonController() {
        myAlert objMyAlert = new myAlert(AddChildActivity.this);
        MyConstant myConstant = new MyConstant();
        nameChildString = nameEditText.getText().toString().trim();
        ageString = ageEditText.getText().toString().trim();
        ageInt = Integer.parseInt(ageString);

        //check  choose
        if (aBoolean) {
            //non choose
            objMyAlert.myDialog("ไม่พบรูปภาพ",
                    "กรุณาเลือกรูปภาพของเด็ก");

        } else if (nameChildString.equals("")||ageString.equals("")) {
            //have space
            objMyAlert.myDialog("พบช่องว่าง",
                    "กรุณากรอกข้อมูลให้ครบ");
        } else if (!(maleRadioButton.isChecked()||femaleRadioButton.isChecked())){
            // radio check gender false
            objMyAlert.myDialog("ไม่พบเพศ",
                    "กรุณาเลือกเพศของเด็ก");

        }else  if(ageInt>18||ageInt<6){
            objMyAlert.myDialog("อายุเไม่ได้อยู่ในช่วงที่กำหนอ",
                    "แอปพลิเคชันนี้ประเมินเด็กอายุ 6 - 18 ปี");

        } else{
            //Rad
            if(maleRadioButton.isChecked()){
                gender = "0";
            }else if(femaleRadioButton.isChecked()){
                gender = "1";
            }
            uploadDataToserver();


        }



    }//butn controller

    private void uploadDataToserver() {
        try {
        // Change policy ให้ใช้ FTP protocal
            StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy
                    .Builder().permitAll().build(); // ใช้ ปลดล็อก FTP protocal
            StrictMode.setThreadPolicy(threadPolicy);

            //set up value
            MyConstant myConstant = new MyConstant();
            String[] loginStrings = getIntent().getStringArrayExtra("Login");
            nameImageString = "http://adhdpj.com/app/Image" + nameImageString;

            //Upload
            SimpleFTP simpleFTP = new SimpleFTP();
            simpleFTP.connect(myConstant.getHostString(), myConstant.getPortAnInt(),
                    myConstant.getUserString(), myConstant.getPasswordString());
            simpleFTP.bin(); //เปลี่ยนภาพเแป็นอักษร
            simpleFTP.cwd("Image"); // folder
            simpleFTP.stor(new File(pathImageString));
            simpleFTP.disconnect();

            //Upload value to mySql

            PostChild postChild = new PostChild(AddChildActivity.this);
            postChild.execute(loginStrings[0], nameChildString,ageString,
                    nameImageString,gender,myConstant.getUrlAddChild());  // เรียก method ใน myconstance



            String strResult = postChild.get();
            Log.d(tag, "strResult ==>" + strResult);

            if (Boolean.parseBoolean(strResult)) {
                finish();
            } else {
                Toast.makeText(AddChildActivity.this, "Cannot save Data" ,Toast.LENGTH_SHORT).show();

            }


        } catch (Exception e) {
            Log.d(tag,"e upload ==>" + e.toString());
        }

    }// upload
}
