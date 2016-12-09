package com.msys.letslanguagetest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Ravikumar on 12/9/2016.
 */

public class LanguageActivity extends AppCompatActivity {
    ArrayList<String> languageList;
    ArrayList<String> languageCodes;
    private ListView listView;
    private Context mContext;
//    public static final String MyPREFERENCES = "MyPrefs";
//    public static final String langKey = "langKey";
//    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanugage);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(getResources().getText(R.string.languageTitle));
        }
        mContext = this;
        //sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Gujarathi");
        languageList.add("Hindi");
        languageList.add("Kannada");
        languageList.add("Malayalam");
        languageList.add("Marathi");
        languageList.add("Punjabi");
        languageList.add("Tamil");
        languageList.add("Telugu");

        languageCodes = new ArrayList<>();
        languageCodes.add("en_IN");
        languageCodes.add("gu_IN");
        languageCodes.add("hi_IN");
        languageCodes.add("kn_IN");
        languageCodes.add("ml_IN");
        languageCodes.add("mr_IN");
        languageCodes.add("pa_IN");
        languageCodes.add("ta_IN");
        languageCodes.add("te_IN");

        listView = (ListView) findViewById(R.id.languageListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, languageList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Locale locale = new Locale(languageCodes.get(position));
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                mContext.getApplicationContext().getResources().updateConfiguration(config, null);

                Intent in = new Intent(mContext, LoginActivity.class);
                startActivity(in);
                finish();
                //changeLanguage(mContext, languageCodes.get(position));
                /*SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(langKey, languageCodes.get(position));
                editor.commit();*/
            }
        });
    }

    /*public static void changeLanguage(Context context, String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getApplicationContext().getResources().updateConfiguration(config, null);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
