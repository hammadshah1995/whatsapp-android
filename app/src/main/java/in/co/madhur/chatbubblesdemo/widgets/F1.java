package in.co.madhur.chatbubblesdemo.widgets;


import android.Manifest;
import android.content.ContentResolver;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import in.co.madhur.chatbubblesdemo.MainActivity;
import in.co.madhur.chatbubblesdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class F1 extends Fragment  {

    ListView listView ;
    ArrayList<String> StoreContacts ;
    ArrayAdapter<String> arrayAdapter ;
    Cursor cursor ;
    String name, phonenumber ;

    Cursor phone;

    ArrayList<String> names;
    ArrayList<String> ph;
    ArrayAdapter<String> myAdapter;
    ListView list;

    public  static final int RequestPermissionCode  = 1 ;
    Button button;

    public F1() {
        // Required empty public constructor






    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        IntentFilter filter = new IntentFilter();
        filter.addAction(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
       // getActivity().registerReceiver(new r1(), filter);

        names = new ArrayList<String>();
        ph = new ArrayList<String>();

        phone = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");


        String name="";
        String phoneNumber="";
        phone.moveToFirst();
        while (phone.moveToNext()) {


            name = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)) ;

            names.add(name);


            phoneNumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            ph.add(phoneNumber);
        }

        myAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, names);
        list  = (ListView) listView.findViewById(R.id.listview);
        list.setAdapter(myAdapter);








        return inflater.inflate(R.layout.fragment_f1, container, false);







    }





public void GetContactsIntoArrayList(){
   // ContentResolver Resolver = getActivity().getContentResolver();
        cursor = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);

        while (cursor.moveToNext()) {

        name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

        phonenumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

        StoreContacts.add(name + " "  + ":" + " " + phonenumber);
        }

        cursor.close();

        }






}
