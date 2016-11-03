package com.example.newproject;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button menulist, button1, button2, button3;
	Fragment1 fragment1;
	Fragment2 fragment2;
	Fragment3 fragment3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		android.app.FragmentManager fragmentmanager = getFragmentManager();

		android.app.FragmentTransaction fragtrans = fragmentmanager
				.beginTransaction();

		fragment1 = new Fragment1();

		fragtrans.add(R.id.fragment, fragment1, "fragment1");

		fragtrans.commit();
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				android.app.FragmentManager fragmentmanager = getFragmentManager();

				android.app.FragmentTransaction fragtrans = fragmentmanager
						.beginTransaction();

				fragment1 = new Fragment1();

				fragtrans.replace(R.id.fragment, fragment1, "fragment1");

				fragtrans.commit();
			}
		});
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				android.app.FragmentManager fragmentmanager = getFragmentManager();

				android.app.FragmentTransaction fragtrans = fragmentmanager
						.beginTransaction();

				fragment2 = new Fragment2();

				fragtrans.replace(R.id.fragment, fragment2, "fragment3");

				fragtrans.commit();
			}
		});
		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				android.app.FragmentManager fragmentmanager = getFragmentManager();

				android.app.FragmentTransaction fragtrans = fragmentmanager
						.beginTransaction();

				fragment3 = new Fragment3();

				fragtrans.replace(R.id.fragment, fragment3, "fragment3");

				fragtrans.commit();
			}
		});

		menulist = (Button) findViewById(R.id.settings);
		menulist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				showPopup(v);

			}
		});
	}

	public void showPopup(View v) {
		PopupMenu popup = new PopupMenu(this, v);
		MenuInflater inflater = popup.getMenuInflater();
		inflater.inflate(R.menu.popup, popup.getMenu());
		popup.show();

		popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem menulist) {

				switch (menulist.getItemId()) {
				case R.id.action1:
					Toast.makeText(getApplicationContext(), "Selected : 1",
							Toast.LENGTH_SHORT).show();
					return true;
				case R.id.action2:
					Toast.makeText(getApplicationContext(), "Selected : 2",
							Toast.LENGTH_SHORT).show();
					return true;
				case R.id.action3:
					Toast.makeText(getApplicationContext(), "Selected : 3",
							Toast.LENGTH_SHORT).show();
					return true;
				default:
					return false;
				}

			}
		});
	}

}
