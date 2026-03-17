package com.Siddhesh.hemoedge.ui.viewmodel;

import com.Siddhesh.hemoedge.data.local.PreferencesManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<PreferencesManager> prefsProvider;

  private SettingsViewModel_Factory(Provider<PreferencesManager> prefsProvider) {
    this.prefsProvider = prefsProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(prefsProvider.get());
  }

  public static SettingsViewModel_Factory create(Provider<PreferencesManager> prefsProvider) {
    return new SettingsViewModel_Factory(prefsProvider);
  }

  public static SettingsViewModel newInstance(PreferencesManager prefs) {
    return new SettingsViewModel(prefs);
  }
}
