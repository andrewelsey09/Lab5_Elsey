package com.example.lab4_elsey;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] androidName, androidVersion, androidAPI, androidDate;
    ListView list;
    int[] androidLogo = {R.drawable.android1,R.drawable.android2, R.drawable.android3,
            R.drawable.android4,R.drawable.android5,R.drawable.android6,
            R.drawable.android7,R.drawable.android8,R.drawable.android9,
            R.drawable.android10,R.drawable.android11,R.drawable.android12,
            R.drawable.android13,R.drawable.android14, R.drawable.android15};
    ArrayList<Android> androidList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidName = getResources().getStringArray(R.array.androidTitle);
        androidVersion = getResources().getStringArray(R.array.androidVersion);
        androidAPI = getResources().getStringArray(R.array.APILevel);
        androidDate = getResources().getStringArray(R.array.releaseDate);
        list = findViewById(R.id.lvVersions);
        for (int i = 0; i<androidName.length;i++){
            androidList.add(new Android(androidLogo[i],androidName[i],androidVersion[i],androidAPI[i],androidDate[i]));
        }
        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.activity_android_list_display,androidList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(androidList.get(i).getName());
        dialog.setIcon(androidList.get(i).getLogo());
        dialog.setMessage("Android " + androidList.get(i).getName() + " is a codename of\n" +
                "the Android mobile operating. system...");
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.create().show();
    }
}
