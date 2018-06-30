package com.demo.weatherreport.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.demo.weatherreport.model.pojo.ResWeatherReport;

import java.util.ArrayList;
import java.util.List;

public class WeatherReportDB extends SQLiteOpenHelper {


    public static final String WEATHER_REPORT_TABLE = "weather_reports";
    public static final String STAT_TYPE_COLUMN = "stat_type";
    public static final String REGION_COLUMN = "region";
    public static final String YEAR_COLUMN = "year";
    public static final String APR_COLUMN = "apr";
    public static final String MAR_COLUMN = "mar";
    public static final String FEB_COLUMN = "feb";
    public static final String JAN_COLUMN = "jan";
    public static final String MAY_COLUMN = "may";
    public static final String JUNE_COLUMN = "jun";
    public static final String JULY_COLUMN = "jul";
    public static final String AUGUST_COLUMN = "aug";
    public static final String SEPT_COLUMN = "sept";
    public static final String OCT_COLUMN = "oct";
    public static final String NOV_COLUMN = "nov";
    public static final String DEC_COLUMN = "dec";
    public static final String WIN_COLUMN = "win";
    public static final String SPR_COLUMN = "spr";
    public static final String SUM_COLUMN = "sum";
    public static final String AUT_COLUMN = "aut";
    public static final String ANN_COLUMN = "ann";

    public static final String CREATE_TABLE_WEATHER =
            "CREATE TABLE " + WEATHER_REPORT_TABLE + "("
                    + REGION_COLUMN + " TEXT,"
                    + STAT_TYPE_COLUMN + " TEXT,"
                    + YEAR_COLUMN + " TEXT,"
                    + JAN_COLUMN + " TEXT,"
                    + FEB_COLUMN + " TEXT,"
                    + MAR_COLUMN + " TEXT,"
                    + APR_COLUMN + " TEXT,"
                    + MAY_COLUMN + " TEXT,"
                    + JUNE_COLUMN + " TEXT,"
                    + JULY_COLUMN + " TEXT,"
                    + AUGUST_COLUMN + " TEXT,"
                    + SEPT_COLUMN + " TEXT,"
                    + OCT_COLUMN + " TEXT,"
                    + NOV_COLUMN + " TEXT,"
                    + DEC_COLUMN + " TEXT,"
                    + WIN_COLUMN + " TEXT,"
                    + SPR_COLUMN + " TEXT,"
                    + SUM_COLUMN + " TEXT,"
                    + AUT_COLUMN + " TEXT,"
                    + ANN_COLUMN + " TEXT"
                    + ")";

    public WeatherReportDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_WEATHER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WEATHER_REPORT_TABLE);
        onCreate(sqLiteDatabase);
    }

    /**
     * Method to insert weather data to database table
     * @param resWeatherReport
     * @return
     */
    public boolean insertWeatherData(ResWeatherReport resWeatherReport) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(REGION_COLUMN, resWeatherReport.getData()[0]);
        contentValues.put(STAT_TYPE_COLUMN, resWeatherReport.getData()[1]);
        contentValues.put(YEAR_COLUMN, resWeatherReport.getData()[2]);
        contentValues.put(JAN_COLUMN, resWeatherReport.getData()[3]);
        contentValues.put(FEB_COLUMN, resWeatherReport.getData()[4]);
        contentValues.put(MAR_COLUMN, resWeatherReport.getData()[5]);
        contentValues.put(APR_COLUMN, resWeatherReport.getData()[6]);
        contentValues.put(MAY_COLUMN, resWeatherReport.getData()[7]);
        contentValues.put(JUNE_COLUMN, resWeatherReport.getData()[8]);
        contentValues.put(JULY_COLUMN, resWeatherReport.getData()[9]);
        contentValues.put(AUGUST_COLUMN, resWeatherReport.getData()[10]);
        contentValues.put(SEPT_COLUMN, resWeatherReport.getData()[11]);
        contentValues.put(OCT_COLUMN, resWeatherReport.getData()[12]);
        contentValues.put(NOV_COLUMN, resWeatherReport.getData()[13]);
        contentValues.put(DEC_COLUMN, resWeatherReport.getData()[14]);
        contentValues.put(WIN_COLUMN, resWeatherReport.getData()[15]);
        contentValues.put(SPR_COLUMN, resWeatherReport.getData()[16]);
        contentValues.put(SUM_COLUMN, resWeatherReport.getData()[17]);
        contentValues.put(AUT_COLUMN, resWeatherReport.getData()[18]);
        contentValues.put(ANN_COLUMN, resWeatherReport.getData()[19]);
        db.insert(WEATHER_REPORT_TABLE, null, contentValues);

        return true;
    }


    /**
     *  Method to get weather data from database table
     * @param region
     * @param statType
     * @return
     */
    public List<ResWeatherReport> getWeatherReportData(String region, String statType) {
        List<ResWeatherReport> resWeatherReportList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from " + WEATHER_REPORT_TABLE + " where " + REGION_COLUMN + " = '" + region + "'" + " and " + STAT_TYPE_COLUMN + " = '" + statType + "'", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    ResWeatherReport resWeatherReport = new ResWeatherReport();
                    String[] data = new String[20];

                    data[0] = cursor.getString(cursor.getColumnIndex(REGION_COLUMN));
                    data[1] = cursor.getString(cursor.getColumnIndex(STAT_TYPE_COLUMN));
                    data[2] = cursor.getString(cursor.getColumnIndex(YEAR_COLUMN));
                    data[3] = cursor.getString(cursor.getColumnIndex(JAN_COLUMN));
                    data[4] = cursor.getString(cursor.getColumnIndex(FEB_COLUMN));
                    data[5] = cursor.getString(cursor.getColumnIndex(MAR_COLUMN));
                    data[6] = cursor.getString(cursor.getColumnIndex(APR_COLUMN));
                    data[7] = cursor.getString(cursor.getColumnIndex(MAY_COLUMN));
                    data[8] = cursor.getString(cursor.getColumnIndex(JUNE_COLUMN));
                    data[9] = cursor.getString(cursor.getColumnIndex(JULY_COLUMN));
                    data[10] = cursor.getString(cursor.getColumnIndex(AUGUST_COLUMN));
                    data[11] = cursor.getString(cursor.getColumnIndex(SEPT_COLUMN));
                    data[12] = cursor.getString(cursor.getColumnIndex(OCT_COLUMN));
                    data[13] = cursor.getString(cursor.getColumnIndex(NOV_COLUMN));
                    data[14] = cursor.getString(cursor.getColumnIndex(DEC_COLUMN));
                    data[15] = cursor.getString(cursor.getColumnIndex(WIN_COLUMN));
                    data[16] = cursor.getString(cursor.getColumnIndex(SPR_COLUMN));
                    data[17] = cursor.getString(cursor.getColumnIndex(SUM_COLUMN));
                    data[18] = cursor.getString(cursor.getColumnIndex(AUT_COLUMN));
                    data[19] = cursor.getString(cursor.getColumnIndex(ANN_COLUMN));
                    resWeatherReport.setData(data);
                    resWeatherReportList.add(resWeatherReport);

                } while (cursor.moveToNext());
            }
        }


        return resWeatherReportList;
    }
}
