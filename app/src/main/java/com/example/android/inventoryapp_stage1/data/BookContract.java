package com.example.android.inventoryapp_stage1.data;

/**
 * Created by Coline on 11/04/2018.
 */

import android.provider.BaseColumns;

/**
 * API Contract for the Books app.
 */
public final class BookContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private BookContract() {}

    /**
     * Inner class that defines constant values for the books database table.
     * Each entry in the table represents a single book.
     */
    public static final class BookEntry implements BaseColumns {

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
    }

}
