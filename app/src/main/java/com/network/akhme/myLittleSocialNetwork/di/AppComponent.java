package com.network.akhme.myLittleSocialNetwork.di;

import android.content.Context;

import com.network.akhme.myLittleSocialNetwork.data.api.NewNetworkService;
import com.network.akhme.myLittleSocialNetwork.presentation.addPostActivity.NewAddPostActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {NewNetworkService.class})
public interface AppComponent {

    void inject(NewAddPostActivity newAddPostActivity);

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder context(Context context);
    }

}
