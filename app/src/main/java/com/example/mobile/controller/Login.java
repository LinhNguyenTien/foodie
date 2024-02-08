package com.example.mobile.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mobile.R;
import com.example.mobile.api.ApiService;
import com.example.mobile.currentUser;
import com.example.mobile.model.customer;
import com.google.android.material.textfield.TextInputEditText;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private TextInputEditText edtPhoneLogin;
    private TextInputEditText edtPasswordLogin;
    private Button btnLogin;
    private TextView tvForgotPass;
    private TextView tvRegister;
    private List<customer> listCustomer;
    private RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Call initView function to init all views
        initView();

        //Init user list
        listCustomer = new ArrayList<>();

        //Call API customers to ready for check login
        getListUser();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtPhoneLogin.getText().toString().trim();
                String password = edtPasswordLogin.getText().toString().trim();

                //Check if there is no customer, do nothing
                if(listCustomer.isEmpty() || listCustomer == null) {
                    return;
                }

                //This means there is one or more customer in system
                boolean isCustomer = false;

                //Check phone number and password
                for (customer customer : listCustomer) {
                    if (phone.equals(customer.getPhone()) && cryptoPassword(password).equals(customer.getPassword())) {
                        isCustomer = true;
                        //This is correct customer account
                        currentUser.currentCustomer = customer;
                        break;
                    }
                }
                //Check if there is an account, send this customer to HomePage Activity
                if (isCustomer) {
                    Intent intent = new Intent(Login.this, HomePage.class);
                    startActivity(intent);
                    //Clear everything
                    finish();
                }
                else {
                    createPopupWindow();
                }
            }
        });
    }

    public String cryptoPassword(String pass) {
        try {
            // Create a MessageDigest instance with MD5 algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Update the digest with the byte array of the string
            md.update(pass.getBytes());
            // Convert the byte array to a BigInteger
            BigInteger bi = new BigInteger(1, md.digest());
            // Convert the BigInteger to a hexadecimal string
            String hex = bi.toString(16);
            // Return the hash
            return hex;
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception
            e.printStackTrace();
            return null;
        }
    }

    private void createPopupWindow() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popup = inflater.inflate(R.layout.popup_login, null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popup, width, height, focusable);
        layout.post(new Runnable() {
            @Override
            public void run() {
                popupWindow.showAtLocation(layout, Gravity.CENTER,0, 0);
            }
        });
        ImageView igSkip = popup.findViewById(R.id.igSkip);
        igSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        popup.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    public void initView() {
        layout = findViewById(R.id.layout);
        edtPhoneLogin = findViewById(R.id.edtPhoneLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgotPass = findViewById(R.id.tvForgotPass);
        tvForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ForgetPassword.class));
            }
        });
        tvRegister = findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }

    public void getListUser() {
        ApiService.apiService.getListUser()
                .enqueue(new Callback<List<customer>>() {
                    @Override
                    public void onResponse(Call<List<customer>> call, Response<List<customer>> response) {
                        listCustomer = response.body();
                        Toast.makeText(Login.this, "list user size: " + listCustomer.size(), Toast.LENGTH_SHORT).show();
                        System.out.println("list user size: " + listCustomer.size());
                    }

                    @Override
                    public void onFailure(Call<List<customer>> call, Throwable t) {
                        Toast.makeText(Login.this, "Call API Failed", Toast.LENGTH_SHORT).show();
                        Log.e("MainActivity", t.getMessage());
                    }
                });
    }
}