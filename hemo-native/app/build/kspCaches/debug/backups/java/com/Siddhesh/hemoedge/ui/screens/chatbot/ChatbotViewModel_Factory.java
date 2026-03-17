package com.Siddhesh.hemoedge.ui.screens.chatbot;

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
public final class ChatbotViewModel_Factory implements Factory<ChatbotViewModel> {
  private final Provider<IChatRepository> chatRepositoryProvider;

  private ChatbotViewModel_Factory(Provider<IChatRepository> chatRepositoryProvider) {
    this.chatRepositoryProvider = chatRepositoryProvider;
  }

  @Override
  public ChatbotViewModel get() {
    return newInstance(chatRepositoryProvider.get());
  }

  public static ChatbotViewModel_Factory create(Provider<IChatRepository> chatRepositoryProvider) {
    return new ChatbotViewModel_Factory(chatRepositoryProvider);
  }

  public static ChatbotViewModel newInstance(IChatRepository chatRepository) {
    return new ChatbotViewModel(chatRepository);
  }
}
