package ru.melandra.react.DI.Dagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    public void inject(DaggerActivity activity);
    public void inject(Red red);
    public void inject(White white);
}
