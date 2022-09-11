package com.example.erensu.ui.anasayfa;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnasayfaViewModel extends ViewModel {


    private MutableLiveData<String> mText;

    public AnasayfaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("ErenSU");
    }


    public LiveData<String> getText() {
        return mText;
    }


}