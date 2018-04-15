package com.example.android.inventoryapp_stage1.data;

/**
 * Created by Coline on 11/04/2018.
 */

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * API Contract for the Books app.
 */
public final class BookContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private BookContract() {}

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.inventoryapp_stage1";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.pets/pets/ is a valid path for
     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_BOOKS = "books";

    /**
     * Inner class that defines constant values for the books database table.
     * Each entry in the table represents a single book.
     */
    public static final class BookEntry implements BaseColumns {

        /** The content URI to access the book data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BOOKS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of books.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single book.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;


        /** Name of database table for books */
        public final static String TABLE_NAME = "books";

        /**
         * Unique ID number for the book (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the book.
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_NAME ="name";

        /**
         * Price of the book.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_PRICE = "price";

        /**
         * Quantity of the book.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_QUANTITY = "quantity";

        /**
         * Supplier name for the book.
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_SUPPLIER_NAME = "supplierName";

        /**
         * Supplier phone number for the book.
         *
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_SUPPLIER_PHONE = "supplierPhone";

        /**
         * Possible values for quantity of the book.
         */
        public static final int NULL_QUANTITY = 0;
        public static final int QUANTITY_1 = 1;
        public static final int QUANTITY_2 = 2;
        public static final int QUANTITY_3 = 3;
        public static final int QUANTITY_4 = 4;
        public static final int QUANTITY_5 = 5;
        public static final int QUANTITY_6 = 6;
        public static final int QUANTITY_7 = 7;
        public static final int QUANTITY_8 = 8;
        public static final int QUANTITY_9 = 9;
        public static final int QUANTITY_10 = 10;

        /**
         * Returns whether or not the given gender is {@link #QUANTITY_1}, {@link #QUANTITY_2},
         * {@link #QUANTITY_3}, {@link #QUANTITY_4}, {@link #QUANTITY_5}, {@link #QUANTITY_6},
         * {@link #QUANTITY_7}, {@link #QUANTITY_8}, {@link #QUANTITY_9} or {@link #QUANTITY_10}.
         */
        public static boolean isValidQuantity(int quantity) {
            if (quantity == QUANTITY_1 || quantity == QUANTITY_2 || quantity == QUANTITY_3
                    || quantity == QUANTITY_4 || quantity == QUANTITY_5 || quantity == QUANTITY_6
                    || quantity == QUANTITY_7 || quantity == QUANTITY_8 || quantity == QUANTITY_9
                    || quantity == QUANTITY_10) {
                return true;
            }
            return false;
        }
    }

}
