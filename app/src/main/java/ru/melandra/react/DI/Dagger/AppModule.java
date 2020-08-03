package ru.melandra.react.DI.Dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    Green provideGreen() {
        return new Green();
    }
}
