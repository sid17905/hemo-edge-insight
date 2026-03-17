package com.Siddhesh.hemoedge.domain.usecase;

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
public final class LoginUseCase_Factory implements Factory<LoginUseCase> {
  private final Provider<IUserRepository> userRepositoryProvider;

  private LoginUseCase_Factory(Provider<IUserRepository> userRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
  }

  @Override
  public LoginUseCase get() {
    return newInstance(userRepositoryProvider.get());
  }

  public static LoginUseCase_Factory create(Provider<IUserRepository> userRepositoryProvider) {
    return new LoginUseCase_Factory(userRepositoryProvider);
  }

  public static LoginUseCase newInstance(IUserRepository userRepository) {
    return new LoginUseCase(userRepository);
  }
}
