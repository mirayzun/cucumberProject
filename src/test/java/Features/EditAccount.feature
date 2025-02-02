Feature: Edit Account İşlemi
  Bu feature, kullanıcı giriş senaryosunu geçtikten sonra Edit Account işlemini test eder.

  Scenario: Edit Account İşlemi
    Given "https://catchylabs-webclient.testinium.com/signIn" adresine gidilir
    When Kullanıcı "mryyavuz" ve "test1234" bilgileriyle giriş yapar
    Then Sayfanın yüklendiği görülür
    Given Open Money Transfer butonuna tıklayın
    Given Edit account butonuna tıklanır
    Given Account name alanına "miray" degeri girilir
    Then Update butonu aktif mi
    Given Update butonu tıkla