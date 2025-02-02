Feature: Transfer Money İslemi
  Bu feature, kullanıcı giriş senaryosunu geçtikten sonra Transfer Money işlemini test eder.

  Scenario: Transfer Money İşlemi
    Given "https://catchylabs-webclient.testinium.com/signIn" adresine gidilir
    When Kullanıcı "mryyavuz" ve "test1234" bilgileriyle giriş yapar
    Then Sayfanın yüklendiği görülür
    Given Open Money Transfer butonuna tıklayın
    Then My Account sayfasının yüklendiği görülür
    Given Transfer Money butonuna tıklayın
    When Sender account alanın dolu oldugu kontrol edilir
    When Receiver account alanın dolu olugu kontrol edilir
    Given Transfer money amount alanına 50 degeri gir
    When Transfer money send butonu tıklanabilir mi
    Given Transfer Send butonu aktif ise tıkla
    Then My Account sayfasının yüklendiği görülür
