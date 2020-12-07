package com.example.tubesku;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Epesan, Elevel;
    private String Snama, Spesan, Slevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Epesan = (EditText) findViewById(R.id.create_pesan);
        Elevel = (EditText) findViewById(R.id.create_level);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Spesan = String.valueOf(Epesan.getText());
                Slevel = String.valueOf(Elevel.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Spesan.equals("")){
                    Epesan.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi pesanan",
                            Toast.LENGTH_SHORT).show();
                } else if (Slevel.equals("")){
                    Elevel.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi level",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Epesan.setText("");
                    Elevel.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateOrder(new Order(null, Snama, Spesan, Slevel));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
