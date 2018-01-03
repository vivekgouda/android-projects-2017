package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import model.Contact;
import utils.Utils;

/**
 * Created by vivek on 5/9/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Utils.DATABASE_NAME, null, Utils.DATABASE_VERSION);
    }

    //create table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //SQL
        String CREATE_CONTACT_TABLE = " CREATE TABLE " + Utils.TABLE_NAME + " ( "
                + Utils.KEY_ID + " INTEGER PRIMARY KEY, " + Utils.KEY_NAME +
                " TEXT, " + Utils.KEY_PHONE_NUMBER + " TEXT " + " ) ";

        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXITS "+Utils.TABLE_NAME);

        //create table again

        onCreate(sqLiteDatabase);

    }

//    CRUD opertions

    //Add Contact
    public void addContact(Contact contact){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utils.KEY_NAME,contact.getName());
        values.put(Utils.KEY_PHONE_NUMBER,contact.getPhoneNumber());

        //insert inti table row
        db.insert(Utils.TABLE_NAME,null,values);
        db.close();
    }

    //Get a Contact

    public Contact getContact(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        String stringID[] = {String.valueOf(id)};

        Cursor cursor = db.query(Utils.TABLE_NAME , new String[] {Utils.KEY_ID,
                Utils.KEY_NAME,Utils.KEY_PHONE_NUMBER} , Utils.KEY_ID + "=?"+
                new String[] {String.valueOf(id)} ,null,null,null,null);

        if (cursor!=null) {
            cursor.moveToFirst();
        }

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2));

        return contact;
    }

    //Get All contacts

    public List<Contact> getAllContacts() {

        SQLiteDatabase db = this.getReadableDatabase();

        List<Contact> contactList = new ArrayList<>();

        //select all contacts

        String selectAll = "SELECT * FROM "+ Utils.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll,null);

        //loop through contacts

        if (cursor.moveToFirst()) {

            do {

                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));

                //add contact obj to contact list

                contactList.add(contact);

            }while (cursor.moveToNext());
        }
        return contactList;
    }

    //Update contacts

    public int updateContacts(Contact contact){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Utils.KEY_NAME,contact.getName());
        contentValues.put(Utils.KEY_PHONE_NUMBER,contact.getPhoneNumber());

        //update row

        return db.update(Utils.TABLE_NAME,contentValues,Utils.KEY_ID + "=?",
                new String[]{String.valueOf(contact.getId())});

    }

    //delete single contact

    public void deleteContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Utils.TABLE_NAME,Utils.KEY_ID+"=?",
                new String[]{String.valueOf(contact.getId())});
        db.close();
    }

    //Get contact count

    public int getContactCounts(){
        String countQuery = "SELECT * FROM "+Utils.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);

        return cursor.getCount();
    }
}
