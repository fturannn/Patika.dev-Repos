# Kütüphane Yönetim Sistemi

![img.png](img.png)
Bir kütüphane yönetim sistemi tasarlanmıştır. Bu kütüphane sisteminde aşağıdaki entity’ler bulunmaktadır.

Kitap : Kitapların özelliklerini içeren entity/tablo.

Yazar : Yazarların özelliklerini içeren entity/tablo.

Kategori : Kitap kategorilerini içeren entity/tablo.

Yayın Evi : Yayınevlerinin özelliklerini içeren entity/tablo.

Kitap Ödünç Alınması : Kitap ödünç alma işlemlerini izleyen entity/tablo. Bu tablo, ödünç alınan kitabın kim tarafından alındığını, alınma tarihini ve teslim tarihini içerir.

Oluşturulan tabloların görüntüleri aşağıda verilmiştir:

### books:

![img_1.png](img_1.png)

### authors:

![img_2.png](img_2.png)

### publishers:

![img_3.png](img_3.png)

### categories:

![img_4.png](img_4.png)

### books2categories

![img_5.png](img_5.png)

### bookborrowings

![img_6.png](img_6.png)

Bu entityler arasında şu ilişkiler tanımlanmıştır :

Bir kitabın bir yazarı olabilir, bir yazarın birden fazla kitabı olabilir. (One-to-Many ilişkisi).

Bir kategori birden fazla kitaba sahip olabilirken, bir kitap birden fazla kategoriye ait olabilir. (Many-to-Many ilişkisi).

Bir kitabın bir yayınevi olabilir, bir yayınevinin birden fazla kitabı olabilir. (One-to-Many ilişkisi).

Bir kitap birden fazla ödünç alma işlemine sahip olabilir, ancak her ödünç alma işlemi yalnızca bir kitaba ait olabilir. (One-to-Many ilişkisi).