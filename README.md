# CucumberProject

Bu proje, [Cucumber](https://cucumber.io/) ve [Allure](https://docs.qameta.io/allure/) kullanarak test otomasyonu gerçekleştirmeyi amaçlamaktadır. Cucumber, Behavior-Driven Development (BDD) yaklaşımını destekleyerek test senaryolarının doğal dilde yazılmasını sağlar. Allure ise test raporlarının daha okunabilir ve görselleştirilmiş bir şekilde sunulmasını mümkün kılar.

## Başlarken

### Gereksinimler

- Java Development Kit (JDK) 8 veya üzeri
- [Maven](https://maven.apache.org/)
- [Allure Commandline](https://docs.qameta.io/allure/#_installing_a_commandline) (Raporları görüntülemek için)

### Kurulum

1. Repository'yi klonlayın:

   ```bash
   git clone https://github.com/mirayzun/cucumberProject.git
   cd cucumberProject
   ```

2. Gerekli bağımlılıkları indirin:

   ```bash
   mvn clean install
   ```

## Proje Yapısı

- `src/test/java`: Test senaryolarının Java dosyaları.
  - `stepDefinitions/`: Adım tanımlamalarını içerir.
  - `runner/`: Test çalıştırıcı sınıflar bulunur.
- `src/test/resources`: Feature dosyaları ve diğer test kaynakları.
  - `features/`: Cucumber test senaryolarını içerir.
- `target/`: Test sonuçlarının ve raporların oluşturulduğu dizindir.
- `pom.xml`: Proje bağımlılıkları ve yapılandırma dosyası.

## Testleri Çalıştırma

Aşağıdaki komutla testleri çalıştırabilirsiniz:

```bash
mvn test
```


## Allure Raporlarını Görüntüleme

Test çalıştırmalarından sonra Allure raporlarını oluşturmak ve görüntülemek için:

1. Allure raporlarını oluşturun:

   ```bash
   mvn allure:report
   ```

2. Allure rapor sunucusunu başlatın:

   ```bash
   mvn allure:serve
   ```

Alternatif olarak, raporları HTML formatında görmek için:

```bash
allure generate target/allure-results -o target/allure-report --clean
allure open target/allure-report
```
