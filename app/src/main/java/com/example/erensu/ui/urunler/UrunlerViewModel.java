package com.example.erensu.ui.urunler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UrunlerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UrunlerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Urunler");
    }

    public LiveData<String> getText() {
        return mText;
    }
}