package com.example.rvavaloss;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity2 extends AppCompatActivity {
    ImageView img;
    TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        img = findViewById(R.id.img);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("nombre");
        String descripcion = intent.getExtras().getString("descripcion");
        int image = intent.getExtras().getInt("imagen");

        tv1.setText(name);
        tv2.setText(descripcion);
        img.setImageResource(image);

    }
}
