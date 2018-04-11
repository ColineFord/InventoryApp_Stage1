package com.example.android.inventoryapp_stage1;

/**
 * Created by Coline on 11/04/2018.
 */

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.inventoryapp_stage1.data.BookContract.BookEntry;
import com.example.android.inventoryapp_stage1.data.BookDbHelper;

/**
 * Allows user to create a new book or edit an existing one.
 */
public class EditorActivity extends AppCompatActivity {

    /** EditText field to enter the book's name */
    private EditText mNameEditText;

    /** EditText field to enter the book's price */
    private EditText mPriceEditText;

    /** Spinner to enter the book's quantity */
    private Spinner mQuantitySpinner;

    /** EditText field to enter the book's supplier name */
    private EditText mSupplierNameEditText;

    /** EditText field to enter the book's supplier phone number */
    private EditText mSupplierPhoneEditText;

    /**
     * Quantity of books. The possible valid values are in the BookContract.java file:
     * {@link BookEntry#QUANTITY_1}, {@link BookEntry#QUANTITY_2}, {@link BookEntry#QUANTITY_3},
     * {@link BookEntry#QUANTITY_4}, {@link BookEntry#QUANTITY_5}, {@link BookEntry#QUANTITY_6},
     * {@link BookEntry#QUANTITY_7}, {@link BookEntry#QUANTITY_8}, {@link BookEntry#QUANTITY_9},or
     * {@link BookEntry#QUANTITY_10}.
     */
    private int mQuantity = BookEntry.QUANTITY_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find all relevant views that we will need to read user input from
        mNameEditText = findViewById(R.id.edit_book_name);
        mPriceEditText = findViewById(R.id.edit_book_price);
        mQuantitySpinner = findViewById(R.id.spinner_quantity);
        mSupplierNameEditText = findViewById(R.id.edit_supplier_name);
        mSupplierPhoneEditText = findViewById(R.id.edit_supplier_phone);

        setupSpinner();
    }

    /**
     * Setup the dropdown spinner that allows the user to select the quantity of the book.
     */
    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter quantitySpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_quantity_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        quantitySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mQuantitySpinner.setAdapter(quantitySpinnerAdapter);

        // Set the integer mSelected to the constant values
        mQuantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.quantity2))) {
                        mQuantity = BookEntry.QUANTITY_2;
                    } else if (selection.equals(getString(R.string.quantity3))) {
                        mQuantity = BookEntry.QUANTITY_3;
                    } else if (selection.equals(getString(R.string.quantity4))) {
                        mQuantity = BookEntry.QUANTITY_4;
                    } else if (selection.equals(getString(R.string.quantity5))) {
                        mQuantity = BookEntry.QUANTITY_5;
                    } else if (selection.equals(getString(R.string.quantity6))) {
                        mQuantity = BookEntry.QUANTITY_6;
                    } else if (selection.equals(getString(R.string.quantity7))) {
                        mQuantity = BookEntry.QUANTITY_7;
                    } else if (selection.equals(getString(R.string.quantity8))) {
                        mQuantity = BookEntry.QUANTITY_8;
                    } else if (selection.equals(getString(R.string.quantity9))) {
                        mQuantity = BookEntry.QUANTITY_9;
                    } else if (selection.equals(getString(R.string.quantity10))) {
                        mQuantity = BookEntry.QUANTITY_10;
                    } else {
                        mQuantity = BookEntry.QUANTITY_1;
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mQuantity = BookEntry.QUANTITY_1;
            }
        });
    }

    /**
     * Get user input from editor and save new pet into database.
     */
    private void insertBook() {
        // Read from input fields
        // Use trim to eliminate leading or trailing white space
        String nameString = mNameEditText.getText().toString().trim();
        String priceString = mPriceEditText.getText().toString().trim();
        String supplierNameString = mSupplierNameEditText.getText().toString().trim();
        String supplierPhoneString = mSupplierPhoneEditText.getText().toString().trim();

        // Create database helper
        BookDbHelper mDbHelper = new BookDbHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(BookEntry.COLUMN_BOOK_NAME, nameString);
        values.put(BookEntry.COLUMN_BOOK_PRICE, priceString);
        values.put(BookEntry.COLUMN_BOOK_QUANTITY, mQuantity);
        values.put(BookEntry.COLUMN_BOOK_SUPPLIER_NAME, supplierNameString);
        values.put(BookEntry.COLUMN_BOOK_SUPPLIER_PHONE, supplierPhoneString);

        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(BookEntry.TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving book", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Book saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Save book to database
                insertBook();
                // Exit activity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
