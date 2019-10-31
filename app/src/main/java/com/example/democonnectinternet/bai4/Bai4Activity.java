package com.example.democonnectinternet.bai4;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.democonnectinternet.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Bai4Activity extends AppCompatActivity {
    private ListView listView;
    private ConstraintLayout parentView;
    private ArrayList<Contact> contactList;
    private MyContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        setTitle("Bài 4 retrofit");
//        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        contactList = new ArrayList<>();
        parentView = findViewById(R.id.parentLayout);
        listView = (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(new  AdapterView.OnItemClickListener() {
                                                    @Override
                                                    public void onItemClick(AdapterView<?> parent, View view, int
                                                            position, long id) {
                                                        Snackbar.make(parentView,
                                                                contactList.get(position).getName() + " => " +
                                                                        contactList.get(position).getPhone().getHome(),
                                                                Snackbar.LENGTH_LONG).show();
                                                    }
                                                });
        Toast toast = Toast.makeText(getApplicationContext(),
                R.string.string_click_to_load, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if
                (InternetConnection.checkConnection(getApplicationContext())) {
                    final ProgressDialog dialog;
                    dialog = new ProgressDialog(Bai4Activity.this);

                    dialog.setTitle(getString(R.string.string_getting_json_title));

                    dialog.setMessage(getString(R.string.string_getting_json_message));
                    dialog.show();
                    //Creating an object of our api interface
                    ApiService api = RetroClient.getApiService();
                    // Calling JSON
                    Call<ContactList> call = api.getMyJSON();
                    // Enqueue Callback will be call when get response...
                    call.enqueue(new Callback<ContactList>() {
                        @Override
                        public void onResponse(Call<ContactList> call,
                                               Response<ContactList> response) {
                            //Dismiss Dialog
                            dialog.dismiss();
                            if(response.isSuccessful()) {
                                // Got Successfully
                                contactList = response.body().getContacts();
                                // Binding that List to Adapter
                                adapter = new
                                        MyContactAdapter(Bai4Activity.this, contactList);
                                listView.setAdapter(adapter);
                            } else {
                                Snackbar.make(parentView,
                                        R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<ContactList> call,
                                              Throwable t) {
                            dialog.dismiss();
                        }
                    });
                } else {
                    Snackbar.make(parentView,
                            R.string.string_internet_connection_not_available,
                            Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_control, menu);
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
////        if (id == R.id.bai2) {
////            return true;
////        }
//        return super.onOptionsItemSelected(item);
//    }


}
