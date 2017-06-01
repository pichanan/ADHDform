package adhd.sirikan.pimpicha.adhdform;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PDF3Activity extends AppCompatActivity {

    private static final String TAG = "PdfCreatorActivity";
    private EditText mContentEditText;
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
    String genderString,ageString, nameString,loginString[],allrisk;
    String gen, type,doname;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf3);

        getValueFromIntent();
        Log.d("PdfCreatorActivity", "intebt ==>" + sspn );

        mCreateButton = (Button) findViewById(R.id.button_createSdq);
        nobtn = (Button) findViewById(R.id.button_notcreateSdq);
        back = (ImageView) findViewById(R.id.backfromPDF3);

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
                Intent intent = new Intent(PDF3Activity.this, ServiceActivity.class);
                intent.putExtra("Login", loginString);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PDF3Activity.this, ServiceActivity.class);
                intent.putExtra("Login", loginString);
                startActivity(intent);
            }
        });
    }
    public List<List<String>> getData() {
        List<List<String>> data = new ArrayList<List<String>>();
        String[] tableTitleList = {"คำถาม", "ไม่จริง","จริงบางครั้ง","จริง"};
        data.add(Arrays.asList(tableTitleList));


        List<String> dataLine = new ArrayList<String>();
        for (int j = 0; j < 25; j++) {
            dataLine.add(question[j]);
            if(arrAns[j].equals("0")){
                dataLine.add("      /");
                dataLine.add(" ");
                dataLine.add(" ");

            }else if(arrAns[j].equals("1")){
                dataLine.add(" ");
                dataLine.add("      /");
                dataLine.add(" ");

            }else if(arrAns[j].equals("2")){
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
        risk1Int = extras.getInt("risk");
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
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        nameString = getIntent().getStringExtra("name");
        date = getIntent().getStringExtra("date");
        allrisk = getIntent().getStringExtra("allrisk");
        loginString = getIntent().getStringArrayExtra("Login");
        arrAns = new String[25];
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

        question = new String[25];
        question[0] = "1.ห่วงใยความรู้สึกคนอื่น";
        question[1] = "2.อยู่ไม่นิ่ง นั่งนานๆไม่ได้";
        question[2]="3.มักจะบ่นว่าปวดศีรษะ ปวดท้อง ไม่สบาย";
        question[3]="4.เต็มใจแบ่งปันสิ่งของให้เพื่อน(ขนม ของเล่น ดินสอ เป็นต้น)";
        question[4]="5.มักจะอาละวาดหรือโมโหร้าย";
        question[5]="6.ค่อนข้างแยกตัว ชอบเล่นคนเดียว";
        question[6]="7.เชื่อฟัง มักจะทำตามที่ผู้ใหญ่ต้องการ";
        question[7]="8.กังวลใจหลายเรื่อง ดูวิตกกังวลเสมอ";
        question[8]="9.เป็นที่พึ่งได้เวลาคนอื่นเสียใจ";
        question[9]="10.อยู่ไม่สุข วุ่นวายอย่างมาก";
        question[10]="11.มีเพื่อนสนิท";
        question[11]="12.มักมีเรื่องทะเลาะวิวาทกับเด็กคนอื่นหรือรังแกเด็กคนอื่น";
        question[12]="13.ดูไม่มีความสุข ท้อแท้ ร้องไห้บ่อย";
        question[13]="14.เป็นที่ชื่นชอบของเพื่อน";
        question[14]="15.วอกแวกง่าย สมาธิสั้น";
        question[15]="16.เครียด ไม่ยอมห่างเวลาอยู่ในสถานการณ์ที่ไม่คุ้น";
        question[16]="18.ชอบโกหกหรือขี้โกง";
        question[17]="18. ชอบสอดแทรกผู้อื่น(เช่นพูดแทรกขณะผู้ใหญ่กำลังสนทนากัน )";
        question[18]="19.ถูกเด้กคนอื่นล้อเลียนหรือรังแก";
        question[19]="20.ชอบอาสาช่วยเหลือคนอื่น(พ่อ แม่ ครู เด็กคนอื่น)";
        question[20]="21.คิดก่อนทำ";
        question[21]="22.ขโทยของ ของที่บ้าน ที่โรงเรียนหรือที่อื่น";
        question[22]="23.เข้ากับผู้ใหญ่ได้ดีกว่าเด็กวัยเดียวกัน";
        question[23]="24.ขี้กลัว รู้สึกหวาดกลัวง่าย";
        question[24]="25.ทำงานได้จนเสร็จ มีความตั้งใจในการทำงาน";



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

            PdfPTable table = new PdfPTable(4);
            table.setWidths(new int[]{5, 1,1,1});
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
            document.add(new Paragraph("คะแนนที่ได้ของอาการสมาธิสั้น : "+String.valueOf(risk1Int), font));
            document.add(new Paragraph("ผลการประเมินเบื้องติน : " + allrisk, font));


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
