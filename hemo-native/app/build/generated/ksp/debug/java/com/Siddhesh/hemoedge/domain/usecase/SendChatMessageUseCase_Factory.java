package com.Siddhesh.hemoedge.domain.usecase;

import com.Siddhesh.hemoedge.domain.repository.IChatRepository;
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
public final class SendChatMessageUseCase_Factory implements Factory<SendChatMessageUseCase> {
  private final Provider<IChatRepository> chatRepositoryProvider;

  private SendChatMessageUseCase_Factory(Provider<IChatRepository> chatRepositoryProvider) {
    this.chatRepositoryProvider = chatRepositoryProvider;
  }

  @Override
  public SendChatMessageUseCase get() {
    return newInstance(chatRepositoryProvider.get());
  }

  public static SendChatMessageUseCase_Factory create(
      Provider<IChatRepository> chatRepositoryProvider) {
    return new SendChatMessageUseCase_Factory(chatRepositoryProvider);
  }

  public static SendChatMessageUseCase newInstance(IChatRepository chatRepository) {
    return new SendChatMessageUseCase(chatRepository);
  }
}
