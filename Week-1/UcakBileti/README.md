# Uçak Bileti Fiyat Hesaplama

## Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programdır.

- Kullanıcıdan Mesafe (KM), yaş ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgileri alınır.
- Mesafe başı ücret 0,10 TL/km'dir.
- Aşağıdaki koşullara göre bilet fiyatına indirimler uygulanır:
  - Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır. Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilir.
  - Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
  - Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
  - Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
  - Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
