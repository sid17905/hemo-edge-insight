package com.Siddhesh.hemoedge.data.remote;

import com.google.firebase.auth.FirebaseAuth;
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
public final class UserRepository_Factory implements Factory<UserRepository> {
  private final Provider<FirebaseAuth> authProvider;

  private UserRepository_Factory(Provider<FirebaseAuth> authProvider) {
    this.authProvider = authProvider;
  }

  @Override
  public UserRepository get() {
    return newInstance(authProvider.get());
  }

  public static UserRepository_Factory create(Provider<FirebaseAuth> authProvider) {
    return new UserRepository_Factory(authProvider);
  }

  public static UserRepository newInstance(FirebaseAuth auth) {
    return new UserRepository(auth);
  }
}
