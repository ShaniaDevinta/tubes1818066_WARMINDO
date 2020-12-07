package com.example.tubesku;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Spesan, Slevel;
    private EditText Enama, Epesan, Elevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Spesan = i.getStringExtra("Ipesan");
        Slevel = i.getStringExtra("Ilevel");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Epesan = (EditText) findViewById(R.id.updel_pesan);
        Elevel = (EditText) findViewById(R.id.updel_level);
        Enama.setText(Snama);
        Epesan.setText(Spesan);
        Elevel.setText(Slevel);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Spesan = String.valueOf(Epesan.getText());
                Slevel = String.valueOf(Elevel.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Spesan.equals("")){
                    Epesan.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi pesanan",
                            Toast.LENGTH_SHORT).show();
                } else if (Slevel.equals("")){
                    Elevel.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi level",
                            Toast.LENGTH_SHORT).show();
                }else {
                    db.UpdateOrder(new Order(Sid, Snama, Spesan, Slevel));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteOrder(new Order(Sid, Snama, Spesan, Slevel));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

