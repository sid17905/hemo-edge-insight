package com.Siddhesh.hemoedge.ui.screens.auth;

import com.Siddhesh.hemoedge.data.local.PreferencesManager;
import com.Siddhesh.hemoedge.domain.repository.IUserRepository;
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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<IUserRepository> userRepositoryProvider;

  private final Provider<PreferencesManager> prefsProvider;

  private LoginViewModel_Factory(Provider<IUserRepository> userRepositoryProvider,
      Provider<PreferencesManager> prefsProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.prefsProvider = prefsProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(userRepositoryProvider.get(), prefsProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<IUserRepository> userRepositoryProvider,
      Provider<PreferencesManager> prefsProvider) {
    return new LoginViewModel_Factory(userRepositoryProvider, prefsProvider);
  }

  public static LoginViewModel newInstance(IUserRepository userRepository,
      PreferencesManager prefs) {
    return new LoginViewModel(userRepository, prefs);
  }
}
