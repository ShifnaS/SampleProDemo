package com.example.softex.sampleprodemo.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.widget.Toast;

import com.example.softex.sampleprodemo.api.APIService;
import com.example.softex.sampleprodemo.model.Results;
import com.example.softex.sampleprodemo.api.ApiModule;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lenovo on 3/31/2018.
 */

public class LoginViewModel extends Observable {

    private Context context;
    public final ObservableField<String > username = new ObservableField<>("");
    public final ObservableField<String > userpass = new ObservableField<>("");

    public LoginViewModel(Context context)
    {
        this.context = context;
    }


    public void sendLoginRequest(String name , String pass)
    {

        APIService apiService = ApiModule.getAPIService();
        Call<Results> loginresponse = apiService.userlogincall(name,pass);
        loginresponse.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {

                showToast(""+response.body().getMessage());
            }
            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                showToast(""+t.getMessage());
            }
        });

    }

    void showToast(String msg)
    {

        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();

    }

}
