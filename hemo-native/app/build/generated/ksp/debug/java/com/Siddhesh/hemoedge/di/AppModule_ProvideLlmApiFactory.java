package com.Siddhesh.hemoedge.di;

import com.Siddhesh.hemoedge.data.remote.LlmApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideLlmApiFactory implements Factory<LlmApi> {
  private final Provider<Retrofit> retrofitProvider;

  private AppModule_ProvideLlmApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public LlmApi get() {
    return provideLlmApi(retrofitProvider.get());
  }

  public static AppModule_ProvideLlmApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideLlmApiFactory(retrofitProvider);
  }

  public static LlmApi provideLlmApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideLlmApi(retrofit));
  }
}
