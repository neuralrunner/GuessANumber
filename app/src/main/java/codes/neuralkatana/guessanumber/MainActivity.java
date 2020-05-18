package codes.neuralkatana.guessanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int generatedNumber = 0;

    public void showCorrectToast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.correct_toast_layout, (ViewGroup)findViewById(R.id.toast_correct_linearlayout));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,150);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public void showLowerToast(){
        //TextView tv = findViewById(R.id.textViewResponse);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.lower_toast_layout, (ViewGroup)findViewById(R.id.toast_lower_linearlayout));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,150);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public void showHigherToast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.higher_toast_layout, (ViewGroup)findViewById(R.id.toast_higher_linearlayout));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,150);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public int getNumber(EditText edt){
        return Integer.valueOf(edt.getText().toString());
    }

    public int generateNumber(){
        return new Random().nextInt(100)+1;
    }

    public void result(int generatedNumber, int guessedNumber){
        if(guessedNumber==generatedNumber){
            this.showCorrectToast();
            Toast.makeText(MainActivity.this,"Another 1-100 Number Has Been Generated!!",Toast.LENGTH_SHORT).show();
            this.generatedNumber = this.generateNumber();
        }else if(guessedNumber>generatedNumber){
            this.showLowerToast();
        }else{
            this.showHigherToast();
        }
    }


    public void guessValidation(View view){
        EditText edtNumber = findViewById(R.id.editTextNumber);
        int guessedNumber = this.getNumber(edtNumber);
        this.result(generatedNumber,guessedNumber);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generatedNumber = this.generateNumber();
        //hack to see the number
        //Toast.makeText(MainActivity.this,""+generatedNumber,Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,"Numbers are Between 1 to 100.",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
