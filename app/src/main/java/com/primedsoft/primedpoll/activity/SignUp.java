package com.primedsoft.primedpoll.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.primedsoft.primedpoll.Activities.SignIn2Activity;
import com.primedsoft.primedpoll.Data;
import com.primedsoft.primedpoll.R;
import com.primedsoft.primedpoll.api.ApiInterface;
import com.primedsoft.primedpoll.api.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {

    private EditText signup_email, signup_password, signup_cnfPassword;
    private Button signup_btn;
    private TextView signin_txt;
    private CheckBox tac;
    private ProgressBar signup_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup_email = (EditText) findViewById(R.id.input_email);
        signup_password = (EditText) findViewById(R.id.input_password);
        signup_cnfPassword = (EditText) findViewById(R.id.input_confirm_password);
        signup_btn = (Button) findViewById(R.id.btn_signup);
        tac = (CheckBox) findViewById(R.id.tac_signup);
        signup_progress = (ProgressBar) findViewById(R.id.signup_progressbar);
        signin_txt = findViewById(R.id.sign_in_text);

        signin_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, SignIn2Activity.class));
            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tac.isChecked()){
                    userSignUp();
                } else {
                    tac.setError("Accept our terms and conditions then proceed");
                    tac.requestFocus();
                }
            }
        });
    }

    public void userSignUp(){

        String email = signup_email.getText().toString().trim();
        String password = signup_password.getText().toString().trim();
        String cnf_password = signup_cnfPassword.getText().toString().trim();

        //Validation for email
        if (email.isEmpty()){
            signup_email.setError("Email is required");
            signup_email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            signup_email.setError("Incorrect Email");
            signup_email.requestFocus();
            return;
        }

        //Validation for Password
        if (password.isEmpty()){
            signup_password.setError("Password is required");
            signup_password.requestFocus();
            return;
        }

        //Validation for confirm password
        if (cnf_password.isEmpty()){
            signup_cnfPassword.setError("Password is required");
            signup_cnfPassword.requestFocus();
            return;
        }

        if (!cnf_password.equals(password)){
            signup_cnfPassword.setError("Password does not match");
            signup_cnfPassword.requestFocus();
            return;
        }

        signup_progress.setVisibility(View.VISIBLE);

        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Data data = new Data(email, password, cnf_password);
        apiInterface.register(data.getEmail(),
                data.getPassword(),
                data.getConfirmPassword()).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.code() == 200) {
                    Toast.makeText(SignUp.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();

                    signup_progress.setVisibility(View.INVISIBLE);

                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(SignUp.this);
                    alertDialog.setTitle("You need to verify your account in other to login? Click Ok to proceed.");
                    alertDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_APP_EMAIL);
                            startActivity(intent);
                            startActivity(Intent.createChooser(intent, "Send FeedBack"));
                            SignUp.this.finish();
                        }
                    });
                    AlertDialog alertDialogCreate = alertDialog.create();

                    // show it
                    alertDialogCreate.show();
                } else {
                    Toast.makeText(SignUp.this, "Email Already Taken", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                t.getMessage();
                Toast.makeText(SignUp.this, "Connection Error! Restart Network", Toast.LENGTH_LONG).show();
            }
        });
    }
}
