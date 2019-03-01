package com.network.akhme.myLittleSocialNetwork.domain.callback;

import java.util.List;

public interface CallbackInterface<T> {
    void onSuccess(List<T> list);
    void onSuccess(T temp);
}
