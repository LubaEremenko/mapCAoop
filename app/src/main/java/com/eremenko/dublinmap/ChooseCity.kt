package com.eremenko.dublinmap

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_choose_city.*

 class ChooseCity : AppCompatActivity() {
/*private Button1 btn_Dublin;
    private Button2 btn_Paris;*/

/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_city)

        val actionBar = supportActionBar
        actionBar!!.title = "Choose city"


        // made btn listener
        btn_Dublin = findViewById(R.id.btnDublin)
        btn_Dublin.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:53.350140, -6.266155"));
                Intent chooser = Intent.createChooser(intent, "Launch Dublin map");
                startActivity(chooser);

            }

        });


        btn_Paris = findViewById(R.id.btnParis)
        btn_Paris.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:48.864716, 2.349014));
                Intent chooser = Intent.createChooser(intent, "Launch Paris map");
                startActivity(chooser);


            }


        });*/

    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_city)

        val actionBar = supportActionBar
        actionBar!!.title = "Choose city"

        btnParis.setOnClickListener {
            val intent = Intent(this, MapsActivityParis::class.java).also {
                startActivity(intent)
            }

        }

        btnDublin.setOnClickListener {
            val intent = Intent(this, MapsActivityDublin::class.java).also {
                startActivity(intent)
            }

        }



    }
}