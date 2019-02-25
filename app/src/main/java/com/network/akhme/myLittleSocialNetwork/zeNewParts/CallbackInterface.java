package com.network.akhme.myLittleSocialNetwork.zeNewParts;

import java.util.List;

public interface CallbackInterface<T> {
    void onSuccess(List<T> list);
    void onSuccess(T temp);
    void onError(String message);
}