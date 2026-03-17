package com.Siddhesh.hemoedge.ui.screens.auth;

import com.Siddhesh.hemoedge.domain.repository.IUserRepository;
import com.google.firebase.firestore.FirebaseFirestore;
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
public final class RegisterViewModel_Factory implements Factory<RegisterViewModel> {
  private final Provider<IUserRepository> userRepositoryProvider;

  private final Provider<FirebaseFirestore> firestoreProvider;

  private RegisterViewModel_Factory(Provider<IUserRepository> userRepositoryProvider,
      Provider<FirebaseFirestore> firestoreProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.firestoreProvider = firestoreProvider;
  }

  @Override
  public RegisterViewModel get() {
    return newInstance(userRepositoryProvider.get(), firestoreProvider.get());
  }

  public static RegisterViewModel_Factory create(Provider<IUserRepository> userRepositoryProvider,
      Provider<FirebaseFirestore> firestoreProvider) {
    return new RegisterViewModel_Factory(userRepositoryProvider, firestoreProvider);
  }

  public static RegisterViewModel newInstance(IUserRepository userRepository,
      FirebaseFirestore firestore) {
    return new RegisterViewModel(userRepository, firestore);
  }
}
