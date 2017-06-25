package adhd.sirikan.pimpicha.adhdform;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PDFActivity extends AppCompatActivity {
    private static final String TAG = "PdfCreatorActivity";
    private EditText  mContentEditText;
    private Button mCreateButton,nobtn;
    private File pdfFile;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;
    public static File fontFile = new File("fonts/thaisanslite_r1.ttf");
    public static final String IMG = "resources/images/checkmark.png";
    String sspn, sspn2, sspn3, sspn4, sspn5, sspn6, sspn7, sspn8, sspn9, sspn10, sspn11, sspn12, sspn13,
            sspn14, sspn15, sspn16, sspn17, sspn18, sspn19, sspn20, sspn21, sspn22, sspn23, sspn24, sspn25, sspn26,date;
    int risk1Int,risk2Int,risk3Int ;
    String[] arrAns;
    String[] question;
    String genderString,ageString, nameString,loginString[];
    String r1="",r2="",r3="";
    String gen, type,doname;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);


        getValueFromIntent();
        Log.d("PdfCreatorActivity", "intebt ==>" + sspn );

        mCreateButton = (Button) findViewById(R.id.button_create);
        nobtn = (Button) findViewById(R.id.button_notcreate);
        back = (ImageView) findViewById(R.id.backfromPDF);
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    createPdfWrapper();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            }
        });
        nobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PDFActivity.this, ServiceActivity.class);
                intent.putExtra("Login", loginString);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PDFActivity.this, ServiceActivity.class);
                intent.putExtra("Login", loginString);
                startActivity(intent);
            }
        });


    }



    public List<List<String>> getData() {
        List<List<String>> data = new ArrayList<List<String>>();
        String[] tableTitleList = {"คำถาม", "ไม่เลย","เล็กน้อย","ค่อนข้างมาก","มาก"};
        data.add(Arrays.asList(tableTitleList));


            List<String> dataLine = new ArrayList<String>();
            for (int j = 0; j < 26; j++) {
                dataLine.add(question[j]);
                if(arrAns[j].equals("ไม่เลย")){
                    dataLine.add("      /");
                    dataLine.add(" ");
                    dataLine.add(" ");
                    dataLine.add(" ");
                }else if(arrAns[j].equals("เล็กน้อย")){
                    dataLine.add(" ");
                    dataLine.add("      /");
                    dataLine.add(" ");
                    dataLine.add(" ");
                }else if(arrAns[j].equals("ค่อนข้างมาก")){
                    dataLine.add(" ");
                    dataLine.add(" ");
                    dataLine.add("      /");
                    dataLine.add(" ");
                }else if(arrAns[j].equals("มาก")){
                    dataLine.add(" ");
                    dataLine.add(" ");
                    dataLine.add(" ");
                    dataLine.add("      /");
                }

            }

            data.add(dataLine);
            Log.d("PdfCreatorActivity", "dataLine ==>" + tableTitleList.length );

        return data;
    }


    private void getValueFromIntent() {
       Bundle extras = getIntent().getExtras();
        risk1Int = extras.getInt("risk1");
        risk2Int = extras.getInt("risk2");
        risk3Int = extras.getInt("risk3");
        sspn = getIntent().getStringExtra("sspn");
        sspn2 = getIntent().getStringExtra("sspn2");
        sspn3 = getIntent().getStringExtra("sspn3");
        sspn4 = getIntent().getStringExtra("sspn4");
        sspn5 = getIntent().getStringExtra("sspn5");
        sspn6 = getIntent().getStringExtra("sspn6");
        sspn7 = getIntent().getStringExtra("sspn7");
        sspn8 = getIntent().getStringExtra("sspn8");
        sspn9 = getIntent().getStringExtra("sspn9");
        sspn10 = getIntent().getStringExtra("sspn10");
        sspn11 = getIntent().getStringExtra("sspn11");
        sspn12 = getIntent().getStringExtra("sspn12");
        sspn13 = getIntent().getStringExtra("sspn13");
        sspn14 = getIntent().getStringExtra("sspn14");
        sspn15 = getIntent().getStringExtra("sspn15");
        sspn16 = getIntent().getStringExtra("sspn16");
        sspn17 = getIntent().getStringExtra("sspn17");
        sspn18 = getIntent().getStringExtra("sspn18");
        sspn19 = getIntent().getStringExtra("sspn19");
        sspn20 = getIntent().getStringExtra("sspn20");
        sspn21 = getIntent().getStringExtra("sspn21");
        sspn22 = getIntent().getStringExtra("sspn22");
        sspn23 = getIntent().getStringExtra("sspn23");
        sspn24 = getIntent().getStringExtra("sspn24");
        sspn25 = getIntent().getStringExtra("sspn25");
        sspn26 = getIntent().getStringExtra("sspn26");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        nameString = getIntent().getStringExtra("name");
        date = getIntent().getStringExtra("date");
        loginString = getIntent().getStringArrayExtra("Login");
        Log.d("23_5_60", "GENDER PDF==>" + genderString + ageString);
        arrAns = new String[26];
        arrAns[0] = sspn;
        arrAns[1] = sspn2;
        arrAns[2] = sspn3;
        arrAns[3] = sspn4;
        arrAns[4] = sspn5;
        arrAns[5] = sspn6;
        arrAns[6] = sspn7;
        arrAns[7] = sspn8;
        arrAns[8] = sspn9;
        arrAns[9] = sspn10;
        arrAns[10] = sspn11;
        arrAns[11] = sspn12;
        arrAns[12] = sspn13;
        arrAns[13] = sspn14;
        arrAns[14] = sspn15;
        arrAns[15] = sspn16;
        arrAns[16] = sspn17;
        arrAns[17] = sspn18;
        arrAns[18] = sspn19;
        arrAns[19] = sspn20;
        arrAns[20] = sspn21;
        arrAns[21] = sspn22;
        arrAns[22] = sspn23;
        arrAns[23] = sspn24;
        arrAns[24] = sspn25;
        arrAns[25] = sspn26;
        question = new String[26];

        question[0] = "1. มักไม่ละเอียดรอบคอบหรือสะเพร่าในการทำงานต่าง ๆ เช่น การบ้าน";
        question[1] = "2. ทำอะไรนาน ๆ ไม่ได้";
        question[2]="3. ดูเหมือนไม่ค่อยฟังเวลามีคนพูดด้วย";
        question[3]="4. มักทำการบ้านไม่เสร็จ หรือทำงานที่ได้รับมอบหมายไม่สำเร็จ";
        question[4]="5. จัดระเบียบงานและกิจกรรมต่าง ๆ ไม่เป็น";
        question[5]="6. มักหลีกเลี่ยงกิจกรรรมที่ต้องใช้ความอดทนในการทำให้สำเร็จ";
        question[6]="7. ทำของหายบ่อย ๆ (เช่นของเล่น, สมุดจดงาน, เครื่องเขียน ฯลฯ";
        question[7]="8. วอกแวกง่าย";
        question[8]="9. ขี้ลืม";
        question[9]="10. มือเท้ายุกยิก นั่งบิดไปบิดมา";
        question[10]="11. นั่งไม่ติดที่ ชอบลุกจากที่นั่งในชั้นเรียนหรือจากที่ที่ควรจะนั่งเรียบร้อย";
        question[11]="12. วิ่งหรือปีนป่ายมากเกินควรอย่างไม่รู้กาละเทศะ";
        question[12]="13. เล่นหรือทำกิจกรรมเงียบ ๆ ไม่เป็น";
        question[13]="14. พร้อมจะเคลื่อนไหวอยู่เสมอ เหมือน“ติดเครื่อง”อยู่ตลอดเวลา";
        question[14]="15. พูดมาก";
        question[15]="16. มักโพล่งคำตอบออกมาก่อนจะฟังคำถามจบ";
        question[16]="17. ไม่ชอบรอคิว";
        question[17]="18. ชอบสอดแทรกผู้อื่น(เช่นพูดแทรกขณะผู้ใหญ่กำลังสนทนากัน )";
        question[18]="19. อารมณ์เสียง่าย";
        question[19]="20. ชอบโต้เถียงกับผู้ใหญ";
        question[20]="21. ไม่ยอมทำตามสิ่งที่ผู้ใหญ่สั่งหรือวางกฎเกณฑ์ไว้";
        question[21]="22. จงใจก่อกวนผู้อื่น";
        question[22]="23. มักตำหนิผู้อื่นในสิ่งที่ตนเองทำผิด";
        question[23]="24. ขี้รำคาญ";
        question[24]="25. โกรธขึ้งบึ้งตึงเป็นประจำ";
        question[25]="26. เจ้าคิดเจ้าแค้น";



    }

    private void createPdfWrapper() throws FileNotFoundException,DocumentException{

        int hasWriteStoragePermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_CONTACTS)) {
                    showMessageOKCancel("You need to allow access to Storage",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                                REQUEST_CODE_ASK_PERMISSIONS);
                                    }
                                }
                            });
                    return;
                }

                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
            }
            return;
        }else {
            createPdf();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    try {
                        createPdfWrapper();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Permission Denied
                    Toast.makeText(this, "WRITE_EXTERNAL Permission Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private void createPdf() throws FileNotFoundException, DocumentException {

        File docsFolder = new File(Environment.getExternalStorageDirectory() + "/Documents");
        if (!docsFolder.exists()) {
            docsFolder.mkdir();
            Log.i(TAG, "Created a new directory for PDF");
        }
        try {
            pdfFile = new File(docsFolder.getAbsolutePath(), nameString+"_"+date+".pdf");
            OutputStream output = new FileOutputStream(pdfFile);
            Document document = new Document();
            PdfWriter.getInstance(document, output);

            document.open();

            BaseFont bf = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf, 15);
            if(genderString.equals("0")){
                gen = "ผู้ชาย";

            }else if(genderString.equals("1")){
                gen = "ผู้หญิง";

            }
            if(loginString[3].equals("0")){
                type = "ครู";

            }else if(loginString[3].equals("1")){
                type = "ผู้ปกครอง";

            }

            document.add(new Paragraph("ชื่อเด็ก:     "+nameString+"     อายุ: "+ageString+ " ปี"+"     เพศ: "+gen+"\nวันที่ทำแบบประเมิน: "+date+"     ผู้ทำแบบประเมินชื่อ: "+loginString[1]+"     ผู้ทำแบบประเมินชเกี่ยวข้องเป็น: "+type, font));
            document.add(new Paragraph(" ", font));
            PdfPTable table = new PdfPTable(5);
            table.setWidths(new int[]{5,1 ,1,1,1});
            table.setWidthPercentage(100);


            List<List<String>> dataset = getData();
            for (List<String> record : dataset) {
                for (String field : record) {
                    try {




                       table.addCell(new Phrase(field, font));








                    } catch (Exception e) {

                    }
                    //table.addCell(new Phrase(field, FontFactory.getFont(FontFactory.HELVETICA, 8)));
                    //table.addCell(cell);
                   // table.addCell(field);
               }
            }
            document.add(table);

            document.add(new Paragraph("คะแนนด้านอาการขาดสมาธิ : "+String.valueOf(risk1Int), font));
            document.add(new Paragraph("คะแนนด้านอาการอยู่ไม่นิ่ง/หุ่นหันพลันแล่น : "+String.valueOf(risk2Int), font));
            document.add(new Paragraph("คะแนนด้านอาการดื้อต่อต้าน : "+String.valueOf(risk3Int), font));
            if(loginString[3].equals("1")){//ผปค


                    if(risk1Int>16){
                        r1 = "มีความเสี่ยงด้านสมาธิ";
                    }
                    if (risk2Int>13){
                        r2="มีความเสี่ยงด้านซน อยู่ไม่นิ่ง/หุนหันพลันแล่น";
                    }
                    if(risk3Int>15){
                        r3 = "มีความเสี่ยงด้านดื้อ ต่อต้าน";
                    }

                    if (r1 == "" && r2 == "" && r3 == "") {
                    document.add(new Paragraph("ไม่มีความเสี่ยง", font));
                    }else {

                    document.add(new Paragraph(r1+" "+r2+" " +r3, font));
                    }


                // ครู
            }else {
                    if(risk1Int>23){
                        r1 = "*มีความเสี่ยงด้านสมาธิ";
                    }
                    if (risk2Int>16){
                        r2="*มีความเสี่ยงด้านซน อยู่ไม่นิ่ง/หุนหันพลันแล่น";
                    }
                    if(risk3Int>11){
                        r3 = "*มีความเสี่ยงด้านดื้อ ต่อต้าน";
                    }

                if (r1 == "" && r2 == "" && r3 == "") {
                    document.add(new Paragraph("ไม่มีความเสี่ยง", font));
                }else {

                    document.add(new Paragraph(r1+" "+r2+" " +r3, font));
                }


            }
            document.add(new Paragraph("-------------------------------------------------------------------", font));

            if(loginString[3].equals("1")) {//ผปค
                document.add(new Paragraph("คะแนนมาตรฐานด้านสมาธิ:16\nด้านซนอยู่ไม่นิ่ง/หุนหันพลันแล่น:13\nด้านดื้อ ต่อต้าน:25" + "\nหากคะแนนที่ได้ด้านใดมากกว่าคะแนนมาตรฐาน ให้สงสัยว่าเด็กมีความเสี่ยงในด้านนั้นๆ", font));
            }else if(loginString[3].equals("0")){
                document.add(new Paragraph("คะแนนมาตรฐานด้านสมาธิ:23\nด้านซนอยู่ไม่นิ่ง/หุนหันพลันแล่น:16\nด้านดื้อ ต่อต้าน:11" + "\nหากคะแนนที่ได้ด้านใดมากกว่าคะแนนมาตรฐาน ให้สงสัยว่าเด็กมีความเสี่ยงในด้านนั้นๆ", font));

            }




            document.close();
            previewPdf();
        } catch (Exception e) {
        }



    }



    private void previewPdf() {

        PackageManager packageManager = getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType("application/pdf");
        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() > 0) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(pdfFile);
            intent.setDataAndType(uri, "application/pdf");

            startActivity(intent);
        }else{
            Toast.makeText(this,"Download a PDF Viewer to see the generated PDF",Toast.LENGTH_SHORT).show();
        }
    }



}