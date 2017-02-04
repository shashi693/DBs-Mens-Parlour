package com.avenueinfotech.dbmensparlour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contact = (ImageView)findViewById(R.id.contact);
        itco();


    }

    private void itco() {
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ourcont = new Intent(MainActivity.this,About_us.class);
                startActivity(ourcont);
            }
        });
    }

}
