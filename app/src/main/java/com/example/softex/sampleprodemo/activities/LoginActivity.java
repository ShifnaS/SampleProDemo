package com.example.softex.sampleprodemo.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.softex.sampleprodemo.R;
import com.example.softex.sampleprodemo.databinding.ActivityLoginBinding;
import com.example.softex.sampleprodemo.presenter.Presenter;
import com.example.softex.sampleprodemo.viewmodel.LoginViewModel;


public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = new LoginViewModel(this);
        activityMainBinding.setLoginview(loginViewModel);

        activityMainBinding.setPresenter(new Presenter() {
            @Override
            public void loginData() {

                final String name = activityMainBinding.user.getText().toString();
                final String pass = activityMainBinding.pass.getText().toString();
                loginViewModel.sendLoginRequest(name, pass);

            }
        });

    }


    void showToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

}
