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

public class PDF2Activity extends AppCompatActivity {

    private static final String TAG = "PdfCreatorActivity";
    private EditText mContentEditText;
    private Button mCreateButton,nobtn;
    private File pdfFile;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;
    public static File fontFile = new File("fonts/thaisanslite_r1.ttf");
    public static final String IMG = "resources/images/checkmark.png";
    String sspn, sspn2, sspn3, sspn4, sspn5, sspn6, sspn7, sspn8, sspn9, sspn10, sspn11, sspn12, sspn13,
            sspn14, sspn15, sspn16, sspn17, sspn18, sspn19, sspn20, sspn21, sspn22, sspn23, sspn24, sspn25, sspn26,sspn27,sspn28
            ,sspn29,sspn30,date;
    String strq1, strq2, strq3, strq4, strq5, strq6, strq7, strq8, strq9, strq10, strq11, strq12, strq13,
            strq14, strq15, strq16, strq17, strq18, strq19, strq20, strq21, strq22, strq23, strq24, strq25,
            strq26, strq27, strq28, strq29, strq30;
    int risk1Int,risk2Int,risk3Int ;
    String[] arrAns;
    String[] question;
    String genderString,ageString, nameString,loginString[],allrisk;
    String gen, type,doname;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);

        getValueFromIntent();
        mCreateButton = (Button) findViewById(R.id.button_createThass);

        mCreateButton = (Button) findViewById(R.id.button_createThass);
        nobtn = (Button) findViewById(R.id.button_notcreateThass);
        back = (ImageView) findViewById(R.id.backfromPDF2);
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
                Intent intent = new Intent(PDF2Activity.this, ServiceActivity.class);
                intent.putExtra("Login", loginString);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PDF2Activity.this, ServiceActivity.class);
                intent.putExtra("Login", loginString);
                startActivity(intent);
            }
        });
    }
    public List<List<String>> getData() {
        List<List<String>> data = new ArrayList<List<String>>();
        String[] tableTitleList = {"คำถาม", "ทำบ่อยมาก","ทำค่อนข้างบ่อย","นานๆทำที","ไม่เคยทำ"};
        data.add(Arrays.asList(tableTitleList));


        List<String> dataLine = new ArrayList<String>();
        for (int j = 0; j < 30; j++) {
            dataLine.add(question[j]);
            if(arrAns[j].equals("0")){
                dataLine.add(" ");
                dataLine.add(" ");
                dataLine.add(" ");
                dataLine.add("      /");
            }else if(arrAns[j].equals("1")){
                dataLine.add(" ");
                dataLine.add(" ");
                dataLine.add("      /");
                dataLine.add(" ");
            }else if(arrAns[j].equals("2")){
                dataLine.add(" ");
                dataLine.add("      /");
                dataLine.add(" ");
                dataLine.add(" ");
            }else if(arrAns[j].equals("3")){
                dataLine.add("      /");
                dataLine.add(" ");
                dataLine.add(" ");
                dataLine.add(" ");

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
        sspn27 = getIntent().getStringExtra("sspn27");
        sspn28 = getIntent().getStringExtra("sspn28");
        sspn29 = getIntent().getStringExtra("sspn29");
        sspn30 = getIntent().getStringExtra("sspn30");
        strq1 = getIntent().getStringExtra("strq1");
        strq2 = getIntent().getStringExtra("strq2");
        strq3 = getIntent().getStringExtra("strq3");
        strq4 = getIntent().getStringExtra("strq4");
        strq5 = getIntent().getStringExtra("strq5");
        strq6 = getIntent().getStringExtra("strq6");
        strq7 = getIntent().getStringExtra("strq7");
        strq8 = getIntent().getStringExtra("strq8");
        strq9 = getIntent().getStringExtra("strq9");
        strq10 = getIntent().getStringExtra("strq10");
        strq11 = getIntent().getStringExtra("strq11");
        strq12 = getIntent().getStringExtra("strq12");
        strq13 = getIntent().getStringExtra("strq13");
        strq14 = getIntent().getStringExtra("strq14");
        strq15 = getIntent().getStringExtra("strq15");
        strq16 = getIntent().getStringExtra("strq16");
        strq17 = getIntent().getStringExtra("strq17");
        strq18 = getIntent().getStringExtra("strq18");
        strq19 = getIntent().getStringExtra("strq19");
        strq20 = getIntent().getStringExtra("strq20");
        strq21 = getIntent().getStringExtra("strq21");
        strq22 = getIntent().getStringExtra("strq22");
        strq23 = getIntent().getStringExtra("strq23");
        strq24 = getIntent().getStringExtra("strq24");
        strq25 = getIntent().getStringExtra("strq25");
        strq26 = getIntent().getStringExtra("strq26");
        strq27 = getIntent().getStringExtra("strq27");
        strq28 = getIntent().getStringExtra("strq28");
        strq29 = getIntent().getStringExtra("strq29");
        strq30 = getIntent().getStringExtra("strq30");
        genderString = getIntent().getStringExtra("gender");
        ageString = getIntent().getStringExtra("age");
        nameString = getIntent().getStringExtra("name");
        date = getIntent().getStringExtra("date");
        allrisk = getIntent().getStringExtra("allrisk");
        loginString = getIntent().getStringArrayExtra("Login");
        arrAns = new String[30];
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
        arrAns[26] = sspn27;
        arrAns[27] = sspn28;
        arrAns[28] = sspn29;
        arrAns[29] = sspn30;
        question = new String[30];
        question[0] = strq1;
        question[1] = strq2;
        question[2]=strq3;
        question[3]=strq4;
        question[4]=strq5;
        question[5]=strq6;
        question[6]=strq7;
        question[7]=strq8;
        question[8]=strq9;
        question[9]=strq10;
        question[10]=strq11;
        question[11]=strq12;
        question[12]=strq13;
        question[13]=strq14;
        question[14]=strq15;
        question[15]=strq16;
        question[16]=strq17;
        question[17]=strq18;
        question[18]=strq19;
        question[19]=strq20;
        question[20]=strq21;
        question[21]=strq22;
        question[22]=strq23;
        question[23]=strq24;
        question[24]=strq25;
        question[25]=strq26;
        question[26]=strq27;
        question[27]=strq28;
        question[28]=strq29;
        question[29]=strq30;




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


            PdfPTable table = new PdfPTable(5);
            table.setWidths(new int[]{5, 1,1,1,1});
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
            document.add(new Paragraph("คะแนนด้านอาการ ซน /วู่วาม : "+String.valueOf(risk1Int), font));
            document.add(new Paragraph("คะแนนด้านอาการขาดสมาธิ : "+String.valueOf(risk2Int), font));
            document.add(new Paragraph("คะแนนรวม : "+String.valueOf(risk3Int), font));
            if(allrisk.equals("")){
                document.add(new Paragraph("อยู่ในเกณฑ์ปกติ", font));
            }else{
                document.add(new Paragraph(allrisk, font));
            }
            document.add(new Paragraph("-------------------------------------------------------------------", font));
            document.add(new Paragraph("คะแนน\t<=50 อยู่ในเกณฑ์ปกติ\n\n"+
                    "คะแนนอยู่ระหว่าง 51 - 60 อาจมีความเสี่ยง คำแนะนำคือ: เฝ้าระวัง ติดตาม หรือทำแบบคัดกรองซ้ำ.\n\n" +
                    "คะแนนอยู่ระหว่าง 61 - 70 เริ่มมีความเสี่ยง คำแนะนำคือ: เควรให้การช่วยเหลือเบื้องต้น และติดตามผลฝ้าระวัง ติดตาม หรือทำแบบคัดกรองซ้ำ.\n\n"+"คะแนนอยู่ระหว่าง >=70 มีความเสี่ยงสูง คำแนะนำคือ: ควรนำเด็กไปพบแพทย์ทันทีเพื่อเข้าสู่กระบวนการวินิจฉัยและยืนยันผลอย่างถูกต้อง\n", font));

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
