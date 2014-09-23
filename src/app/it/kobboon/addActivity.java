package app.it.kobboon;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class addActivity extends Activity implements OnClickListener{
	
	private Button btnsave; 
	private EditText Name,tel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		
		Name=(EditText) findViewById(R.id.ed_name);
		tel=(EditText) findViewById(R.id.ed_tel);
		btnsave=(Button) findViewById(R.id.btnsave);
		btnsave.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		if (v == btnsave) {
			Save();
		}
	}
	public boolean Save() {
		final AlertDialog.Builder adb = new AlertDialog.Builder(this);
		AlertDialog ad = adb.create();
		
		
		
		if (Name.getText().length() == 0) {
			ad.setMessage("Please input Name");
			Name.requestFocus();
			return false;
		}
		if (tel.getText().length() == 0) {
			ad.setMessage("Please input Tel");
			tel.requestFocus();
			return false;
		}
		
		
		
		MyBDClass dbClass = new MyBDClass(this);
		long savedata = dbClass.InsertData(Name.getText().toString(), tel.getText().toString());
		
		
		
		if (savedata <= 0) {
			ad.setMessage("Error !!!!");
			ad.show();
			return false;
		}
		
		
		Toast.makeText(getApplicationContext(), "Add Data Successfully",Toast.LENGTH_SHORT).show();
		return true;
	}
	
}
