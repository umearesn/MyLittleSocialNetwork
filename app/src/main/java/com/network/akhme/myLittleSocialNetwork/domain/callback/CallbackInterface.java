package com.network.akhme.myLittleSocialNetwork.domain.callback;

import java.util.ArrayList;
import java.util.List;

public interface CallbackInterface<T> {
    void onSuccess(ArrayList<T> list);
    void onSuccess(T temp);
}
