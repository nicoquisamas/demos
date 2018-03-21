package pmi.com.demos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String TEST_FLAG = "test";

    private int test = 0;
    private String usuario;
    private String password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState!=null) {
            test = savedInstanceState.getInt(TEST_FLAG, 1);
        }

        Log.d(MainActivity.class.toString(), "Entro al onCreate(), test = " + test);

        Button btn_submit = findViewById(R.id.btn_login);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String token= FirebaseInstanceId.getInstance().getToken();
                Log.d("TOKEN",token);

                //MyFirebaseInstanceIdService s = new MyFirebaseInstanceIdService();

               // s.onTokenRefresh();

                String n = ((EditText)findViewById(R.id.edit_txt_name)).getText().toString();

                String user = ((EditText)findViewById(R.id.edit_txt_name)).getText().toString();
                String password= ((EditText)findViewById(R.id.edit_txt_password)).getText().toString();

                if ( user.equals("nicolas")&& password.equals("123")){

                    Intent index_activity = new Intent(MainActivity.this, IndexActivity.class);
                    startActivity(index_activity);

                }else{

                    Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        test += 1;
        Log.d(MainActivity.class.toString(), "Entro al onStart(), test = " + test);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MainActivity.class.toString(), "Entro al onStop(), test = " + test);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.class.toString(), "Entro al onDestroy(), test = " + test);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(TEST_FLAG, test);
        super.onSaveInstanceState(outState);
    }
}
