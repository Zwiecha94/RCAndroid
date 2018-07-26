package gui;

import com.example.rca.R;
import com.example.rca.R.id;
import com.example.rca.R.layout;
import com.example.rca.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import test.Test;

public class TestActivity extends Activity {
	Test test = new Test();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		final EditText editText1 = (EditText) findViewById(R.id.editText1);
		final EditText editText2 = (EditText) findViewById(R.id.editText2);

		TextWatcher textWatcher1 = new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void afterTextChanged(Editable editable) {

				if (editText1.getText().toString().length() == 0) {
					test.setValue1(0.0);
				} else {
					test.setValue1(Double.parseDouble(editText1.getText().toString()));
				}
				System.out.println("Liczba1= " + test.getValue1());
			}
		};

		TextWatcher textWatcher2 = new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

			}

			@Override
			public void afterTextChanged(Editable editable) {

				if (editText2.getText().toString().length() == 0) {
					test.setValue2(0.0);
				} else {
					test.setValue2(Double.parseDouble(editText2.getText().toString()));
				}
				System.out.println("Liczba2= " + test.getValue2());
			}
		};

		editText1.addTextChangedListener(textWatcher1);
		editText2.addTextChangedListener(textWatcher2);
		
		addCountButtonListener();
	}

	private void addCountButtonListener() {
		Button countButton = (Button) findViewById(R.id.countButtonTest);
		final TextView textView4 = (TextView) findViewById(R.id.textView4);

		

		countButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				test.countVal1PlusVal2();
				textView4.setText(String.valueOf(test.getResult()));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
