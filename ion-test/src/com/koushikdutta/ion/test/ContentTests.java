package com.koushikdutta.ion.test;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.test.AndroidTestCase;
import com.koushikdutta.ion.Ion;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by koush on 5/22/13.
 */
public class ContentTests extends AndroidTestCase {
    public void testContact() throws Exception {
        Cursor c = getContext().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        String id = null;
        while (c.moveToNext()) {
            id = c.getString(c.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));
            if (id != null)
                break;
        }
        Ion.with(getContext())
        .load(id)
        .write(getContext().openFileOutput("test.png", Context.MODE_PRIVATE)).get();
        assertNotNull(id);
        assertNotNull(c);
    }

    public void testContactToFile() throws Exception {
        Cursor c = getContext().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        String id = null;
        while (c.moveToNext()) {
            id = c.getString(c.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));
            if (id != null)
                break;
        }
        Ion.with(getContext())
        .load(id)
        .write(getContext().openFileOutput("test2.png", Context.MODE_PRIVATE)).get();
        assertNotNull(id);
        assertNotNull(c);
    }

    public void testContactBitmap() throws Exception {
        Cursor c = getContext().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        String id = null;
        while (c.moveToNext()) {
            id = c.getString(c.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));
            if (id != null)
                break;
        }
        Bitmap b =
        Ion.with(getContext())
        .load(id)
        .asBitmap()
        .get();
        assertNotNull(b);
        assertNotNull(id);
        assertNotNull(c);
    }
}
