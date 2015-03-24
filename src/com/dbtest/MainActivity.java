package com.dbtest;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

	Button btnAdd;
	Button btnFind;
	TextView txtAddName;
	TextView txtAddPhone;
	TextView txtFind;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnFind = (Button) findViewById(R.id.btnFind);
        
        txtAddName = (TextView) findViewById(R.id.txtAdd1);
        txtAddPhone = (TextView) findViewById(R.id.txtAdd2);
        txtFind = (TextView) findViewById(R.id.txtFind);
        
        
        final DatabaseHandler db = new DatabaseHandler(this);
        
        btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			        // Inserting Contacts
			        Log.d("Insert: ", "Inserting .."+txtAddName.getText()+" -- "+txtAddName.getText()); 
			        db.addContact(new Contact(txtAddName.getText().toString(), txtAddPhone.getText().toString()));        

			        // Reading all contacts
			        Log.d("Reading: ", "Reading all contacts.."); 
			        List<Contact> contacts = db.getAllContacts();       
			         
			        for (Contact cn : contacts) {
			            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
			                // Writing Contacts to log
			            Log.d("Name: ", log);
				
			        }
			        
			        //Contact mycontacto = db.getContact(5);
			        //String msg = "Id: "+mycontacto.getID()+" ,Name: " + mycontacto.getName() + " ,Phone: " + mycontacto.getPhoneNumber();
			        //Log.d("getContact", msg);
			        	    
			}
		});
        
        
        btnFind.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				String count = db.getCount(txtFind.getText().toString());
			        
		        int count2 = Integer.parseInt(count);
		        
		        if(count2 > 0){
		        	Log.d("Msg", "Usuario encontrado --> " + txtFind.getText().toString());
		        	Log.d("Coincidencias", "Se encontraron "+count2+" coinicidencias");
		        }else{
		        	Log.d("Msg", "NO existen coincidencias");
		        };
			}
        	
        });
        
    }

    
}
