package app.it.kobboon;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class showActivity extends Activity {
	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show);
		listview = (ListView) findViewById(R.id.listView1);

		MyBDClass myBdClass = new MyBDClass(this);
		ArrayList<HashMap<String,String>> arrayList = myBdClass
				.SelectAllData();
		SimpleAdapter adapter;
		adapter = new SimpleAdapter(showActivity.this, arrayList,
				R.layout.show_item1,
				new String[] { "MemberID", "Name", "Tel" }, new int[] {
						R.id.col_Member, R.id.col_Name, R.id.col_Tel });
		listview.setAdapter(adapter);

	}
}
