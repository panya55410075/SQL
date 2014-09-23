package app.it.kobboon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener  {
	
	private Button btn_insert,btn_show ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.mainlayout);
    	
    	
    	MyBDClass mydbclass = new MyBDClass(this);
    	mydbclass.getWritableDatabase();
    	
    	btn_insert =(Button) findViewById(R.id.btninsert);
    	btn_show=(Button) findViewById(R.id.btnshow);
    	btn_insert.setOnClickListener(this);
    	btn_show.setOnClickListener(this);
    	
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btninsert:
			Intent s =new Intent(MainActivity.this,addActivity.class);
			startActivity(s);
			break;
		case R.id.btnshow:
			Intent k =new Intent(MainActivity.this,showActivity.class);
			startActivity(k);
			break; 
			
		default:
			break;
		}
		
	}
}
