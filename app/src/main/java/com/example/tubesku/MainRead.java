package com.example.tubesku;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Order> ListOrder = new ArrayList<Order>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListOrder );
        mListView = (ListView) findViewById(R.id.list_order);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListOrder.clear();
        List<Order> contacts = db.ReadOrder();
        for (Order cn : contacts) {
            Order judulModel = new Order();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_pesan(cn.get_pesan());
            judulModel.set_level(cn.get_level());
            ListOrder.add(judulModel);
            if ((ListOrder.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Order obj_itemDetails = (Order) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Spesan = obj_itemDetails.get_pesan();
        String Slevel = obj_itemDetails.get_level();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ipesan", Spesan);
        goUpdel.putExtra("Ilevel", Slevel);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListOrder.clear();
        mListView.setAdapter(adapter_off);
        List<Order> contacts = db.ReadOrder();
        for (Order cn : contacts) {
            Order judulModel = new Order();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_pesan(cn.get_pesan());
            judulModel.set_level(cn.get_level());
            ListOrder.add(judulModel);
            if ((ListOrder.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

