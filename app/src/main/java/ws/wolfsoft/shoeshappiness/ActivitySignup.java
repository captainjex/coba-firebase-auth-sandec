package ws.wolfsoft.shoeshappiness;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import customfonts.MyEditText;
import customfonts.MyTextView;

public class ActivitySignup extends BaseActivity {

    ImageView back;

    MyEditText edtEmail;
    MyEditText edtPassword;

    String email;
    String password;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        mAuth = FirebaseAuth.getInstance();

        back = (ImageView)findViewById(R.id.back);
        edtEmail = (MyEditText) findViewById(R.id.edt_signup_email);
        edtPassword = (MyEditText) findViewById(R.id.edt_signup_password);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ActivitySignup.this, MainActivity.class);
                startActivity(it);
            }
        });

    }

    public void signup(View v){

        showProgressBar();

        email = edtEmail.getText().toString().trim();
        password = edtPassword.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                hideProgressBar();
                if(task.isSuccessful()){
                    task.getResult().getUser();
                    Intent i = new Intent(ActivitySignup.this, HalamanUtamaActivity.class);
                    startActivity(i);
                    finish();
                }else{

                    Toast.makeText(ActivitySignup.this, "error ndaftare", Toast.LENGTH_LONG).show();
                }
            }
        });
//        Toast.makeText(ActivitySignup.this, "email: "+ email+" pass: "+password,Toast.LENGTH_SHORT).show();

    }


}