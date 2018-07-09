package com.example.datepickertest;

import java.util.Calendar;

import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	private Button showDatePicker = null;
	private Button showTimePicker = null;
	private static Context mContext = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mContext = (Context)this;
		setContentView(R.layout.activity_main);
		
		showDatePicker = (Button)findViewById(R.id.showdate);
		showTimePicker = (Button)findViewById(R.id.showtime);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	public void showDatePickerDialog(View v) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getFragmentManager(), "datePicker");
	}
	
	public void showTimePickerDialog(View v) {
		DialogFragment newFragment = new TimePickerFragment();
		newFragment.show(getFragmentManager(), "timePicker");
	}
	
	public static class DatePickerFragment extends DialogFragment 
	implements DatePickerDialog.OnDateSetListener {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			System.out.println("" + year + "/" + monthOfYear + "/" + dayOfMonth);
		}

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			//return super.onCreateDialog(savedInstanceState);
			//use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			
			//create a new instance of DatePickerDialog and return it 
			return new DatePickerDialog(mContext, this, year, month, day);
		}
		
	}
	
	public static class TimePickerFragment extends DialogFragment 
	implements TimePickerDialog.OnTimeSetListener {

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			System.out.println("" + hourOfDay + ":" + minute);
		}

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			//return super.onCreateDialog(savedInstanceState);
			//use the current date as the default date in the picker
			final Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			//create a new instance of DatePickerDialog and return it 
			return new TimePickerDialog(mContext, this, hour, minute, true);
		}
		
	}

}
