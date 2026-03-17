package com.Siddhesh.hemoedge.data.remote;

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
public final class LLMRepository_Factory implements Factory<LLMRepository> {
  private final Provider<LlmApi> apiProvider;

  private LLMRepository_Factory(Provider<LlmApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public LLMRepository get() {
    return newInstance(apiProvider.get());
  }

  public static LLMRepository_Factory create(Provider<LlmApi> apiProvider) {
    return new LLMRepository_Factory(apiProvider);
  }

  public static LLMRepository newInstance(LlmApi api) {
    return new LLMRepository(api);
  }
}
