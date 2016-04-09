package appewtc.masterung.ungrestautant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 4/9/16 AD.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public static final String user_table = "userTABLE";
    public static final String column_id = "_id";
    public static final String column_user = "User";
    public static final String column_pass = "Password";
    public static final String column_name = "Name";

    public static final String food_table = "foodTABLE";
    public static final String column_food = "Food";
    public static final String column_price = "Price";
    public static final String column_source = "Source";

    public MyManage(Context context) {

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    }   // Constructor

    public long addValueToSQLite(int intTABLE,
                                 String strFirst,
                                 String strSecond,
                                 String strThird) {

        ContentValues contentValues = new ContentValues();
        long myLong = 0;
        switch (intTABLE) {

            case 0:
                // for userTABLE
                contentValues.put(column_user, strFirst);
                contentValues.put(column_pass, strSecond);
                contentValues.put(column_name, strThird);

                myLong = sqLiteDatabase.insert(user_table, null, contentValues);
                break;
            case 1:
                // for foodTABLE
                contentValues.put(column_food, strFirst);
                contentValues.put(column_price, strSecond);
                contentValues.put(column_source, strThird);

                myLong = sqLiteDatabase.insert(food_table, null, contentValues);
                break;
        }   // switch

        return myLong;
    }

}   // Main Class
