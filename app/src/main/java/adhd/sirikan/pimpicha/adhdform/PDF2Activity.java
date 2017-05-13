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
    private Button mCreateButton;
    private File pdfFile;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;
    public static File fontFile = new File("fonts/thaisanslite_r1.ttf");
    public static final String IMG = "resources/images/checkmark.png";
    String sspn, sspn2, sspn3, sspn4, sspn5, sspn6, sspn7, sspn8, sspn9, sspn10, sspn11, sspn12, sspn13,
            sspn14, sspn15, sspn16, sspn17, sspn18, sspn19, sspn20, sspn21, sspn22, sspn23, sspn24, sspn25, sspn26,sspn27,sspn28
            ,sspn29,sspn30,date;
    int risk1Int,risk2Int,risk3Int ;
    String[] arrAns;
    String[] question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);

        getValueFromIntent();
        mCreateButton = (Button) findViewById(R.id.button_createThass);

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
    }
    public List<List<String>> getData() {
        List<List<String>> data = new ArrayList<List<String>>();
        String[] tableTitleList = {"คำถาม", "3","2","1","0"};
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
       /* Bundle extras = getIntent().getExtras();
        risk1Int = extras.getInt("risk1");
        risk2Int = extras.getInt("risk2");
        risk3Int = extras.getInt("risk3");*/
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
        //date = getIntent().getStringExtra("date");
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
        question[0] = "1. เดินไปเดินมาในเวลาเรียนโดยไม่ได้รับอนุญาติ";
        question[1] = "2. พูดโพล่ง ขัดจังหวะในเวลาครูสอน";
        question[2]="3. แหย่ ล้อเลียน แกล้งเด็กคนอื่น";
        question[3]="4. อยู่ไม่นิ่ง มักหาอะไรทำหรือเล่นตลอดเวลา";
        question[4]="5. ใจร้อน วู่วาม";
        question[5]="6. มักมีเรื่องทะเลาะวิวาทกับเด็กอื่น";
        question[6]="7. เล่นเสียงดัง";
        question[7]="8. พูดมากจนน่ารำคาญ";
        question[8]="9. อารมณ์เสีย หงุดหงิดง่าย";
        question[9]="10. ทำอะไรโดยไม่คิดถึงผลที่จะตามมา";
        question[10]="11. เล่นรุนแรง เล่นแผลงๆ หรือเสี่ยงอันตราย";
        question[11]="12. ซน";
        question[12]="13. รบกวนเพื่อนหรือครูในห้องเรียน";
        question[13]="14. ไม่รู้จักการรอคอย";
        question[14]="15. ส่งเสียงดังในห้องเรียน";
        question[15]="16. ขาดความรับผิดชอบ";
        question[16]="17. ไม่ตั้งใจเรียน";
        question[17]="18. ทำงานช้า ทำงานไม่เสร็จในเวลาที่กำหนด";
        question[18]="19. เหม่อ ใจลอย";
        question[19]="20. ฟังอะไรประเดี๋ยวเดียวก็หมดความสนใจ";
        question[20]="21. โอ้เอ้ใช้เวลานานกว่าจะเริ่มงานได้";
        question[21]="22. ต้องเรียก หรือกระตุ้นเพื่อให้งานเสร็จ";
        question[22]="23. วอกแวกง่าย";
        question[23]="24. นำของที่จำเป็นต้องการเรียนมาไม่ครบ";
        question[24]="25. ทำหนังสือ อุนกรณ์การเรียน หรือของใช้ส่วนตัวหาย";
        question[25]="26. ทำงานไม่เรียบร้อย สะเพร่า ไม่รอบคอบ";
        question[26]="27. ไม่จดจ่อกับงานที่กำลังทำ (ยกเว้นกำลังทำสิ่งที่ชอบ)";
        question[27]="28. สมาธิสั้น(ยกเว้นเวลาดูทีวี เล่นเกมส์ หรือทำสิ่งที่ชอบ)";
        question[28]="29. หลีกเลี่ยงการทำงานที่ต้องใช้ความคิด";
        question[29]="30. ลืมส่งการบ้าน";




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
            pdfFile = new File(docsFolder.getAbsolutePath(), sspn+".pdf");
            OutputStream output = new FileOutputStream(pdfFile);
            Document document = new Document();
            PdfWriter.getInstance(document, output);

            document.open();



            PdfPTable table = new PdfPTable(5);
            table.setWidths(new int[]{3, 1,1,1,1});
            table.setWidthPercentage(100);


            List<List<String>> dataset = getData();
            for (List<String> record : dataset) {
                for (String field : record) {
                    try {
                        BaseFont bf = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                        Font font = new Font(bf, 15);

                        table.addCell(new Phrase(field, font));





                    } catch (Exception e) {

                    }
                    //table.addCell(new Phrase(field, FontFactory.getFont(FontFactory.HELVETICA, 8)));
                    //table.addCell(cell);
                    // table.addCell(field);
                }
            }
            document.add(table);
            BaseFont bf = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf, 15);
            document.add(new Paragraph(sspn, font));

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
