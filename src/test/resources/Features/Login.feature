Feature: Kullanıcı Girişi
  Bu feature, kullanıcı giriş senaryosunu test etmek amacıyla oluşturulmuştur.

  Scenario: Geçerli bilgilerle giriş yapma
    Given "https://catchylabs-webclient.testinium.com/signIn" adresine gidilir
    When Kullanıcı "mryyavuz" ve "test1234" bilgileriyle giriş yapar
    Then Sayfanın yüklendiği görülür
