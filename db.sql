CREATE DATABASE  IF NOT EXISTS `digital_library` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `digital_library`;
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
  `title` varchar(255) DEFAULT NULL,
  `description` text,
  `author` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pdf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (40,1,'Ethical Hacking','Hacker\'lar temelde Siyah Şapkalı ve Beyaz Şapkalı olmak üzere ikiye ayrılır. Siyah şapkalılar öğrendikleri teknik ve yöntemleri kendi çıkarları ve diğer insanlara zarar vermek için kullanırlar. Beyaz şapkalılar ise siyah şapkalılar ile aynı teknik ve yöntemleri öğrenip; siyah şapkalılar kimseye zarar vermesin diye sistemleri korumaya çalışırlar. Bu kitap da hacking\'in temel konuları hem siyah şapka hem beyaz şapka açısından ele alınıyor. Bir tekniğin siyah şapkalı bir hacker bir sisteme zarar vermek için ne şekilde kullanıldığı (offensive) ve ardından bu güvenlik zafiyetinin beyaz şapkalı hacker tarafından nasıl korunacağı (defensive) anlatılıyor.  Kitap konu içeriği CEH, yani Certified Ethical Hacking ile paraleldir. CEH, siber güvenlik sektöründeki her firmanın en önem verdiği sertifikalardan biridir. Siber güvenlik sektöründe çalışmak isteyip, CEH sınavına hazırlananlar için kitap yardımcı mahiyette olacaktır.','Ömer Çıtak','0000000690116-1.jpg','Mastering JavaServer Faces 2.2 - Anghel Leonard.pdf'),(41,1,'Android Programlama Eğitimi','Bu kitap 2011 yılından beridir, üniversitede Android üzerine açılmış ilk lisans derslerini okutan deneyimli eğitimci Aykut TAşdelen tarafından kaleme alındı. Bu nedenle kitap, konuları pedagojik bir sistematiğe göre ayrıştırıp, akademik bir ciddiyet içerisinde ele alıyor. Konunun arka planını anlatmayı hedefleyen Taşdelen, ekran görüntüleri ile doldurulmuş yüzeysel içerikli bir kitap yerine, bazı noktalarda Android kütüphanesinin kendi kaynak kodlarından alıntılar yaparak -sadece bir şeyin nasıl yapıldığını değil aynı zamanda o görevi yerine getiren sınıfların nasıl yazıldıklarını anlatıyor- ayrıca UML ile modellemeler yaparak, kütüphanenin tasarım detaylarını da inceliyor. Teori ve pratiğin ayrılmaz bir bütün olduğu gerçeğinden yola çıkılarak, kitap Android üzerine uygulama geliştirme isteyen kişiler için bolca örnek kod içeriyor ve kaliteli kodlama için çeşitli teknikler öğretiyor. ','Aykut Taşdelen','0000000652730-1.jpg','Apress.Beginning.JSP.JSF.And.Tomcat.2nd.Edition.Sep.2012.ISBN.1430246235.pdf');
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
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,'test','test content'),(3,40,'qwe','qwe'),(4,40,'asd','asd');
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

-- Dump completed on 2016-12-01 21:04:59
