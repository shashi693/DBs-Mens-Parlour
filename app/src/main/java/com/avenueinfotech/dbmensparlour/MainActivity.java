package com.avenueinfotech.dbmensparlour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


      public ImageButton our_services;
    ImageView start;
    ImageView book;
    ImageView address;
    ImageView contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (ImageView)findViewById(R.id.imageView);
        book = (ImageView)findViewById(R.id.book);
        address = (ImageView)findViewById(R.id.address);
        contact = (ImageView)findViewById(R.id.contact);
        itco();
        itib();
        itim();
        itad();


    }

    private void itco() {
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ourcont = new Intent(MainActivity.this,ContactActivity.class);
                startActivity(ourcont);
            }
        });
    }


    private void itad() {
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ouraddress = new Intent(MainActivity.this,AddressActivity.class);
                startActivity(ouraddress);
            }
        });
    }



    public void itim(){
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent girl =new Intent(MainActivity.this, ServicesActivity.class);
                startActivity(girl);
            }
        });
    }

    public void itib(){
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent booknow = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(booknow);
            }
        });
    }




}
