package com.Siddhesh.hemoedge.di;

import android.content.Context;
import com.Siddhesh.hemoedge.data.local.PreferencesManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class AppModule_ProvidePreferencesFactory implements Factory<PreferencesManager> {
  private final Provider<Context> contextProvider;

  private AppModule_ProvidePreferencesFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public PreferencesManager get() {
    return providePreferences(contextProvider.get());
  }

  public static AppModule_ProvidePreferencesFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvidePreferencesFactory(contextProvider);
  }

  public static PreferencesManager providePreferences(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providePreferences(context));
  }
}
