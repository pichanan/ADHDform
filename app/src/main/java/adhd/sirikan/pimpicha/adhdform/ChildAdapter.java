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
    private String[] iconStrings , childStrings,cnt;
    private TextView textView;
    private ImageView imageView;

    public ChildAdapter(Context context, String[] iconStrings, String[] childStrings,String[] cnt) {
        this.context = context;
        this.iconStrings = iconStrings;
        this.childStrings = childStrings;
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

        textView.setText(childStrings[position]);
        Picasso.with(context).load(iconStrings[position]).into(imageView);

        return view1;
    }
}//main class
