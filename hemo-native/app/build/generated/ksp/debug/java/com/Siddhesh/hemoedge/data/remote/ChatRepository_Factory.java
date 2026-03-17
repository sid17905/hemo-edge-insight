package com.Siddhesh.hemoedge.data.remote;

import android.content.Context;
import com.Siddhesh.hemoedge.data.local.ChatDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class ChatRepository_Factory implements Factory<ChatRepository> {
  private final Provider<ChatDao> chatDaoProvider;

  private final Provider<LLMRepository> llmRepositoryProvider;

  private final Provider<Context> contextProvider;

  private ChatRepository_Factory(Provider<ChatDao> chatDaoProvider,
      Provider<LLMRepository> llmRepositoryProvider, Provider<Context> contextProvider) {
    this.chatDaoProvider = chatDaoProvider;
    this.llmRepositoryProvider = llmRepositoryProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public ChatRepository get() {
    return newInstance(chatDaoProvider.get(), llmRepositoryProvider.get(), contextProvider.get());
  }

  public static ChatRepository_Factory create(Provider<ChatDao> chatDaoProvider,
      Provider<LLMRepository> llmRepositoryProvider, Provider<Context> contextProvider) {
    return new ChatRepository_Factory(chatDaoProvider, llmRepositoryProvider, contextProvider);
  }

  public static ChatRepository newInstance(ChatDao chatDao, LLMRepository llmRepository,
      Context context) {
    return new ChatRepository(chatDao, llmRepository, context);
  }
}
