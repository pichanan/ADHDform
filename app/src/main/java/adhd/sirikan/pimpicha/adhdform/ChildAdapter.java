package adhd.sirikan.pimpicha.adhdform;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by TheUser on 31/3/2560.
 */

public class ChildAdapter extends BaseAdapter {// for Listview / bestadap วนวาง
    private Context context;
    private String[] iconStrings , childStrings,cnt,genderStrings,ageStrings;
    private TextView textView,textView2,textView3;
    private ImageView imageView;

    public ChildAdapter(Context context, String[] iconStrings, String[] childStrings, String[] genderStrings, String[] ageStrings,String[] cnt) {
        this.context = context;
        this.iconStrings = iconStrings;
        this.childStrings = childStrings;
        this.ageStrings = ageStrings;
        this.genderStrings = genderStrings;
        this.cnt=cnt;
    }

    @Override
    public int getCount() {// count of listview ,how many
        return cnt.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // สร้าง layout เสมือน    คลาสนึงสร้างแล้วมาลงอีกคลาส
        View view1 = layoutInflater.inflate(R.layout.child_listview, parent, false);
        //Initial view
        imageView = (ImageView) view1.findViewById(R.id.imvIcon);
        textView = (TextView) view1.findViewById(R.id.txtChild);
        textView2 = (TextView) view1.findViewById(R.id.txtgenChild);
        textView3 = (TextView) view1.findViewById(R.id.txtageChild);
        textView.setText(childStrings[position]);
        if(genderStrings[position].equals("0")){
            textView2.setText("เพศ ชาย");
        }else if(genderStrings[position].equals("1")){
            textView2.setText("เพศ หญิง");
        }

        textView3.setText("อายุ " + ageStrings[position]+" ปี");
        Picasso.with(context).load(iconStrings[position]).into(imageView);

        return view1;
    }
}//main class