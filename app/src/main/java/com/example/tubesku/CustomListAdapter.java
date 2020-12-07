package com.example.tubesku;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Order> movieItems;

    public CustomListAdapter(Activity activity, List<Order> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView pesan = (TextView) convertView.findViewById(R.id.text_pesan);
        TextView level = (TextView) convertView.findViewById(R.id.text_level);
        Order m = movieItems.get(position);
        nama.setText("Nama : "+ m.get_nama());
        pesan.setText("Pesan : "+ m.get_pesan());
        level.setText("Level : "+ m.get_level());
        return convertView;
    }
}
