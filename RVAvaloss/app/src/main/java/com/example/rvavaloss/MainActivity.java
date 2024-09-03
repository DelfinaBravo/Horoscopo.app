package com.example.rvavaloss;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Model> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new Model(R.drawable.delfina,"Delfina","blablabla"));
        arrayList.add(new Model(R.drawable.delfina,"Delfina","blablabla"));
        arrayList.add(new Model(R.drawable.delfina,"Delfina","blablabla"));
        arrayList.add(new Model(R.drawable.delfina,"Delfina","blablabla"));



        ModelRecyclerView modelRecyclerView = new ModelRecyclerView(this,arrayList);
        recyclerView.setAdapter(modelRecyclerView);
    }


}
