-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: digital_library
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text,
  `author` varchar(255) NOT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `publish_date` varchar(45) DEFAULT NULL,
  `isbn` varchar(45) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pdf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (43,1,'Her Yönüyle C# 6.0','Türkiye\'nin açık ara en çok satan C# kitabının başarısı, yazarın detaylı ve kapsamlı anlatımına, konuya hakim bir şekilde herkese hitap edebilmesine dayanıyor. Her Yönüyle C#, C# 6.0 için benzersiz bir başvuru kaynağı. Kitabın en önemli özelliği, sadece C# için değil, genelde programlama teknikleri ve yazılım geliştirme stratejileri için de güvenilir bir kılavuz olması. \r\n\r\n%100 Nesne Yönelimli Programlama Dili C# İçin Temel Kılavuz... \r\n\r\nNET platformu için sıfırdan geliştirilen bir dil olan C#, kendinden önce gelen gözde programlama dilleri C, C++ ve Java dillerinin en etkili özelliklerini bünyesinde barındırması yanında, bu dillerin hiç olmadıkları kadar da nesne yönelimli (object oriented) ve kolay öğrenilir bir dil. .NET platformu ile birlikte hızla tanınan ve yayılan C#, profesyonel yazılımcılar için ideal bir çözüm olarak karşımızda.\r\n\r\nC#\'ın uygulama desteği ise oldukça geniş; konsol uygulamalarından, Windows tabanlı uygulamalara, ASP .NET desteğinden Web servisleri desteğine, Mobil uygulamalardan DLL yazımına kadar birçok konuda C# dili kullanılabilirliği ile öne çıkıyor. Bütün bu konuların yanında Her Yönüyle C#, bellek yönetimi, exception handling, veritabanı yönetimi gibi ileri düzey programlama konularını da her yönüyle irdeliyor.\r\n\r\nSefer Algan\'ın kaleme aldığı Her Yönüyle C# ile, .NET\'in prensi olarak anılan C# dilini, hızla, kolayca öğrenebilirsiniz. Yalın bir dille yazılan bu kitap, hem programlamaya yeni başlayanlar hem de hangi dille bağlayacağına karar veremeyenler için eksiksiz bir kılavuz. Profesyonel yazılımcılar ise bu kitabı mutlaka kitaplıklarında bulundurmalılar...','Sefer Algan',NULL,NULL,NULL,'0000000137386-1.jpg','csharp_tutorial.pdf'),(42,1,'Ethical Hacking','Hacker\'lar temelde Siyah Şapkalı ve Beyaz Şapkalı olmak üzere ikiye ayrılır. Siyah şapkalılar öğrendikleri teknik ve yöntemleri kendi çıkarları ve diğer insanlara zarar vermek için kullanırlar. Beyaz şapkalılar ise siyah şapkalılar ile aynı teknik ve yöntemleri öğrenip; siyah şapkalılar kimseye zarar vermesin diye sistemleri korumaya çalışırlar. Bu kitap da hacking\'in temel konuları hem siyah şapka hem beyaz şapka açısından ele alınıyor. Bir tekniğin siyah şapkalı bir hacker bir sisteme zarar vermek için ne şekilde kullanıldığı (offensive) ve ardından bu güvenlik zafiyetinin beyaz şapkalı hacker tarafından nasıl korunacağı (defensive) anlatılıyor.\r\n\r\nKitap konu içeriği CEH, yani Certified Ethical Hacking ile paraleldir. CEH, siber güvenlik sektöründeki her firmanın en önem verdiği sertifikalardan biridir. Siber güvenlik sektöründe çalışmak isteyip, CEH sınavına hazırlananlar için kitap yardımcı mahiyette olacaktır.','Ömer Çıtak',NULL,NULL,NULL,'0000000690116-1.jpg','ethical_hacking_tutorial.pdf'),(44,3,'Olanaksızın Fiziği','Işınlama, zaman makineleri, kuvvet alanları, yıldızlararası uzay gemileri; bunlar yalnızca bilimkurgunun alanları mı yoksa geleceğin kullanılabilir teknolojileri mi? Star Trek, Star Wars, Back to the Future gibi filmlerin fantastik dünyaları ünlü fizikçi Michio Kaku tarafından ciddi, bilimsel ve şaşırtıcı bir bakış açısı ile yeniden ele alınıyor ve günümüzden bir bakışla evrenin fizik yasalarının yakın ve uzak bir gelecekte bize neler sunacağı tartışılıyor. Eğlendirici, bilgilendirici ve yaratıcı; Olanaksızın Fiziği bizi insan dehasının ve bilimsel olanın sınırlarına bir yolculuğa çıkarıyor. Bilim ve bilimkurgu arasındaki arayüzün şaşırtıcı bir keşfi; mükemmel bir araştırma; canlı, müthiş keyif verici bir anlatım Fritijof Capra, Tao\'nun Fiziği\" ve \"Leonardo\'nun Bilimi\" adlı kitapların yazarı Bu olanaklı olanaksızlıkları ancak birkaç güçlü fizikçi bu kadar iyi genişletebilir ve anlatabilirdi. Kaku bunu başardığı için tebrik edilmeyi hak ediyor… ','Michio Kaku',NULL,NULL,NULL,'0000000593373-1.jpg','Michio Kaku - Einsteinın Evreni.pdf'),(45,3,'Kuantum Sınırında Yaşam','Yaşam bilinen evrendeki en olağanüstü fenomen. Peki ama nasıl işliyor? İçinde bulunduğumuz klonlama ve sentetik biyoloji çağında dahi şu gerçekle yüz yüzeyiz: bugüne kadar hiç kimse tamamen cansız bir maddeden canlı yarata-bilmiş değil. Yaşamı oluşturmanın tek yolu hâlâ yaşamın yine kendisi. Öyleyse yaşamın mayasına dair hayati bir bileşeni gözden kaçırıyor olabilir miyiz?\r\n\r\nRichard Dawkins\'in, evrime bakışımızı tümden değiştiren kitabı Gen Bencildir gibi Kuantum Sınırında Yaşam da yaşam dinamiklerine dair anlayışımızı baştan şekillendiriyor. Jim Al-Khalili ve Johnjoe McFadden, birikimlerini benzersiz an-latım yeteneğiyle bir araya getirerek, gözden kaçırdığımız bileşenin, varlıkların aynı anda iki farklı yerde bulunabildiği, hayaletimsi bağlantılar kurabildiği ve geçilmez göru?nen engellerin içinden geçebildiği kuantum mekaniği du?nyasında gizli olduğunu ortaya koyuyor. Bizleri göz alıcı bir hızla gelişen ve uygulama-larıyla çığır açması beklenen kuantum biyolojisi ile tanıştırırken muammaların en büyüğü olan \"Yaşam nedir?\" sorusuna yepyeni bir bakış getiriyor: Yaşam kuantum sınırında yaşar.','Johnjoe McFadden,  Jim Al-Khalili Khalili',NULL,NULL,NULL,'0000000712855-1.jpg','quantum.pdf'),(46,18,'Kozmos - Evrenin ve Yaşamın Sırları','\"Carl Sagan zamanımızın en parlak bilim adamlarından biridir... İçinde varlığımızı sürdürdüğümüz akıllara durgunluk veren Kozmos\'un sonsuzluğunu dile getirirken bilimin geçmişine, şimdiki zamanına ve geleceğine ilişkin muhteşem bir eser yaratmış.\"Associated Press \r\n\r\n\"Alanında göz kamaştırıcı, önerilerinde kışkırtıcı. Bu kitabı okuyan herkesin, etkisi altında kalacağından hiç kuşkum yok.\" The Miami Herald \r\n\r\n\"Sagan edebi bir coşkuyla yazıyor. Harika bir eser. İnsan aklının tüm noktalarına değinen Kozmos gerçek olmayacak kadar gerçek.\"\r\nThe Cleveland Plain Dealer ','Carl Sagan',NULL,NULL,NULL,'0000000059256-1.jpg','cosmos.pdf'),(47,1,'A\'dan Z\'ye PHP','A\'dan Z\'ye PHP kitabı, PHP Programlama dilini öğrenmek isteyen okuyuculara, başlangıç, orta ve ileri düzeyde bilgiler vermeyi amaçlamaktadır. Kitap baştan sona teorik ve pratik bilgileri ekran görüntüleri ile birlikte bir arada vermektedir. \r\n\r\nKitabın ilk bölümleri başlangıç düzeyindeki okuyuculara temel ve öz bilgiler verecek şekilde ele alınmıştır. Başlangıç düzeyi konularının devamında orta ve ileri düzeydeki konularla PHP programlama dilinin birçok detayı okuyucuyu ileri seviye programlama bilgisi edinmeyi sağlayacak şekilde anlatılmıştır.\r\n\r\nKitapta ele alınan konuların özellikle orta ve ileri düzey bilgileri, özgün ve kapsamlı projelerin üretilmesinde, okuyucuya alt yapı kazandırılmasını ve edindiği bilgilerle günümüz modern web proje ve sunumlarını hazırlamasını sağlayacaktır.\r\n\r\nKitabın en önemli hedefi ise Türkçe kaynak sıkıntısı çekilen REGEX, CURL, mySQL, mySQLi, PDO, MongoDB, XML, SOAP, GD, OOP, IMAP, POP3, SQLITE, AJAX, MVC, CODEIGNITER 3, LARAVEL 5, REST konuları detaylı, örnekleyici ve öz ifadelerle anlatılırken aynı zamanda okuyucunun bu konuların kapsamı dâhilinde bulunan uygulama örnekleri ile tanışmalarını ve uygulama mantığını kavramalarını sağlamaktadır.','Rıza Çelik',NULL,NULL,NULL,'0000000414134-1.jpg','php_tutorial.pdf'),(48,1,'Scrum','Kitap, gördüğü yoğun ilgi sonucu bilişim kitapları arasında çok satan kitaplar arasında yerini almıştır. Simdi ise genişletilmiş ve gözden geçirilmiş 3. baskısı ile bu konuda kendini geliştirmek isteyen okuyucuların beğenisine sunulmuştur.\r\n\r\nGeciken projeler, kalite problemleri, hantal yapılar, değişime hızlı bir şekilde uyum sağlayamamak, yüksek proje maliyetleri, demotive çalışanlar.. Bunlar maalesef, halen birçok İT ekibinin yaşamakta olduğu sıkıntılardır. Çözüm ise Agile yaklaşımları uygulamaktan, yani bu sıkıntıları doğurmuş olan mevcut proje yönetim şekillerini unutarak yazılım projelerini ele alma yöntemimizi değiştirmekten geçiyor. Günümüzde dünyada en çok tercih edilen ve yaygın olarak kullanılan yazılım proje yönetimi ve geliştirme yaklaşımı olarak Agile yaklaşımlara ve Scrum\'a rastlıyor olmamız şüphesiz bu değişimin ne denli kaçınılmaz ve gerekli olduğunun bir ispatıdır.\r\n\r\nBu kitapta, hayali olan bir kurumsal şirketin Serum ile tanışması ve yaşadığı değişim süreci adım adım basit bir hikaye diliyle anlatılmaktadır. Hikaye boyunca günümüzde birçok şirketin de gündeminde olan \"Scrum\'ı nasıl uygulayabiliriz\" sorusuna cevap oluşturulmaya çalışılmaktadır. Bu doğrultuda, herhangi bir Serum uygulama sürecinde karşılaşılabilecek olası engeller, nedenleri ve olası çözümleriyle birlikte ortaya koyulmuştur. Bu kitap, Serum uygulamanızda ve dönüşüm sürecinizde size yol gösterecek, elinizin altında devamlı olarak başvurabileceğiniz bir kaynak kitap olacaktır.','Mehmet Yitmen',NULL,NULL,NULL,'0000000542633-1.jpg','Scrum-Guide-TR.pdf'),(49,1,'Yazılım Testi - İş Analizi - Kullanılabilirlik','Başarısız olan Bilgi Teknolojileri (BT) projelerinin katili kim? Aklınıza ilk gelen zanlı yazılımcı mı? Eğer bu şekilde düşünüyorsanız yanılıyorsunuz deriz. 10 yılı aşkın süredir Keytorc olarak, yurtiçi ve yurtdışında gerçekleştirdiğimiz danışmanlık ve dış kaynak kullanımı projelerinde edindiğimiz tecrübeler ışığında yukarıdaki soruya, bu kitapla daha geniş bir açıdan bakmanızı sağlıyor olacağız. Bu sayede BT projelerinde başarının veya başarısızlığın tek kaynağının kodlama ve kodu geliştiren yazılımcılar olmadığını; yazılım testi, iş analizi ve kullanılabilirliğe de çok fazla işler düştüğünü görüyor olacaksınız.\r\n\r\nİlk iki baskısının kısa sürede tükenmesi üzerine, güncellenmiş 3. baskısını yapan kitap; test mühendisi, iş analisti ve kullanılabilirlik uzmanı, BT projelerinde başarılı olmak isteyen ya da benzeri alanlardaki bilgilerini artırmak isteyen herkes için eşsiz bir kaynak oluşturmaktadır. Kitap ayrıca ISTQB® ve CBAP® sınavlarına yardımcı kaynak niteliğindedir.','Lütfü Koray Yitmen',NULL,NULL,NULL,'0000000618346-1.jpg','software_testing_tutorial.pdf'),(50,1,'UML ve Dizayn Paternleri','Nesne yönelimli programlama, günümüzde en sık kullanılan yazılım geliştirme tekniği ancak bu konu programlama dillerinin sözdizim özelliklerinden, sınıf, arayüz, türetme veya sanallık gibi temel alt başlıklarından ibaretmiş gibi algılanmaktadır. Oysa nesne yönelimli programlama denilince bilinmesi gereken konular; modelleme, dizayn prensipleri, paternler ve UML notasyonudur. Bu kitap sayılan konuları üç dilde ve örneklerle ele almaktadır.\r\n\r\nKitabın hedeflediği okuyucu kitlesi sadece bu dilleri öğrenmekte olan kişiler değil aksine halihazırda bu dilleri kullanarak uygulama geliştiren ancak kariyerinde yazılım mimarı, proje yöneticisi gibi unvanları hedefleyen yazılımcılardır. Özellikle üniversitelerdeki (yazılım mühendisliği, yazılım mimarisi, nesne yönelimli programlama vb) dersler için akademik kaynak niteliğindedir. Kitaptaki tüm konular örneklerle anlatılmakta ve bölüm sonlarında sorular yer almaktadır. Ayrıca kitabın bir bölümü yazar tarafından \"proje örnekleri\" diye nitelenen çeşitli teknolojilere ilişkin daha kapsamlı uygulamalara ayrılmıştır. Bu bölümde ön plana çıkan olgu; katmanlı mimariye göre uygulama geliştirmedir. Kitapta ek bir bölüm olarak giriş seviyesinde ve okuyucuya proje yönetimi hakkında genel kültür kazandırmak amacıyla XP, Scrum, MSF, RUP gibi metodolojiler ele alınmaktadır.','Aykut Taşdelen',NULL,NULL,NULL,'0000000617203-1.jpg','uml_tutorial.pdf'),(51,1,'Java Diliyle Kriptoloji Uygulamaları','Bu kitapta kriptoloji alanının tarihsel süreç içerisinde gelişimi anlatılmıştır. Binlerce yıl öncesinden günümüze kadar bu alanda kullanılan birçok yöntem incelenmiş, bu yöntemlerin algoritma yapılarına değinilmeye çalışılmıştır. Kriptolojiyi en basit haliyle kriptografi ve kriptanaliz olmak üzere iki alt alana ayırmak mümkündür. Kriptografi alanı bir bilgiyi anlaşılmayacak hale getiren tekniklerin tamamını içerirken, kriptanaliz alanı anlamsız bir metinden anlamlı bilgiyi elde etmeyi hedefleyen teknikleri içerir. \r\n\r\nKitap bu noktada, kriptanaliz alanıyla karşılaştırıldığında kriptografi alanına daha fazla ağırlık vermiştir. İçerisinde anlatılan yöntemlerin birçoğu kriptografi alanının bir parçasıdır. Kitap şifreleme alanına merak duyan, geçmişten günümüze farklı algoritmalarla şifreleme ve şifre çözme işlemlerinin nasıl yapıldığı hakkında bilgi sahibi olmak isteyenler içindir. Ayrıca veri güvenliği konusunda teorik bilginin yanı sıra pratik bilgi sahibi de olmak isteyen yazılım geliştiriciler için bir kaynak niteliğindedir. İçerisinde bulunan yöntemler mümkün olduğunca yalın bir dil kullanılarak anlatılmaya çalışılmıştır.','Hüseyin Bodur',NULL,NULL,NULL,'0000000680712-1.jpg','criptologia.pdf');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Bilgisayar'),(2,'Başvuru Kitapları'),(3,'Bilim-Mühendislik'),(4,'Dergi'),(5,'Ders Kitapları'),(6,'Edebiyat'),(7,'Eğitim'),(8,'Eğlence'),(9,'Ekonomi'),(10,'Felsefe'),(11,'Hobi'),(12,'Hukuk'),(13,'Kültür'),(14,'Müzik'),(15,'Psikoloji'),(16,'Resim'),(17,'Sanat'),(18,'Tarih');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (5,43,'Okuyun, uygulayın...','Piyasadaki Türkçe en iyi C# kitabı olduğunu düşünüyorum. Çeviri eğitim kitaplarının başarısı zaten ortada...'),(6,42,'Fena değil','Okunamakta fayda var...'),(7,48,'Mutlaka okunmalı','Sıkılmadan okunabilecek bir kitap.'),(8,47,'İşe yarar bir kitap','Yazarın PHP kitabı kesinlikle piyasadaki en iyi kitap okunamızını tavsiye ederim.');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','12345');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-04 18:20:30
