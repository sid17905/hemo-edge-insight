package com.Siddhesh.hemoedge.domain.usecase;

import com.Siddhesh.hemoedge.data.local.ScanDao;
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
public final class SaveScanUseCase_Factory implements Factory<SaveScanUseCase> {
  private final Provider<ScanDao> scanDaoProvider;

  private final Provider<IReportRepository> reportRepositoryProvider;

  private SaveScanUseCase_Factory(Provider<ScanDao> scanDaoProvider,
      Provider<IReportRepository> reportRepositoryProvider) {
    this.scanDaoProvider = scanDaoProvider;
    this.reportRepositoryProvider = reportRepositoryProvider;
  }

  @Override
  public SaveScanUseCase get() {
    return newInstance(scanDaoProvider.get(), reportRepositoryProvider.get());
  }

  public static SaveScanUseCase_Factory create(Provider<ScanDao> scanDaoProvider,
      Provider<IReportRepository> reportRepositoryProvider) {
    return new SaveScanUseCase_Factory(scanDaoProvider, reportRepositoryProvider);
  }

  public static SaveScanUseCase newInstance(ScanDao scanDao, IReportRepository reportRepository) {
    return new SaveScanUseCase(scanDao, reportRepository);
  }
}
