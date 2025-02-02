Feature: Add Money İslemi
  Bu feature, kullanıcı giriş senaryosunu geçtikten sonra Add Money işlemini test eder.

  Scenario: Add Money İşlemi
    Given "https://catchylabs-webclient.testinium.com/signIn" adresine gidilir
    When Kullanıcı "mryyavuz" ve "test1234" bilgileriyle giriş yapar
    Then Sayfanın yüklendiği görülür
    Given Open Money Transfer butonuna tıklayın
    Then My Account sayfasının yüklendiği görülür
    Given Add money butonuna tıkla
    Given Card number alanına "12312312312311" degeri girilir
    Given Card holder alanına "Miray" degeri girilir
    Given Expiry date alanı ay "10" degeri girilir
    Given Expiry date alanın yıl "25" degeri girilir
    Given CVV alanına "111" degeri girilir
    Given Add money amonunt alanına 100 degerini gir
    When Add butonu aktif mi
    Given Add butonu tıkla
