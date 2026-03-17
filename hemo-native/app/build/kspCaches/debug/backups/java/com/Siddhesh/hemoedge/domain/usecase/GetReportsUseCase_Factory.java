package com.Siddhesh.hemoedge.domain.usecase;

import com.Siddhesh.hemoedge.domain.repository.IReportRepository;
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
public final class GetReportsUseCase_Factory implements Factory<GetReportsUseCase> {
  private final Provider<IReportRepository> reportRepositoryProvider;

  private GetReportsUseCase_Factory(Provider<IReportRepository> reportRepositoryProvider) {
    this.reportRepositoryProvider = reportRepositoryProvider;
  }

  @Override
  public GetReportsUseCase get() {
    return newInstance(reportRepositoryProvider.get());
  }

  public static GetReportsUseCase_Factory create(
      Provider<IReportRepository> reportRepositoryProvider) {
    return new GetReportsUseCase_Factory(reportRepositoryProvider);
  }

  public static GetReportsUseCase newInstance(IReportRepository reportRepository) {
    return new GetReportsUseCase(reportRepository);
  }
}
