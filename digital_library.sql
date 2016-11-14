-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 07 Kas 2016, 07:59:03
-- Sunucu sürümü: 5.6.17
-- PHP Sürümü: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Veritabanı: `digital_library`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` text,
  `author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Tablo döküm verisi `books`
--

INSERT INTO `books` (`id`, `category_id`, `title`, `description`, `author`) VALUES
(1, 1, 'JAVA Bilgisayar Programlamaya Giriş', 'Java, bilgisayar mimarisinden bağımsız olarak çalışabilen bir programlama dilidir. Ayrıca, bu dil üzerine yaratılmış olan yazılım ortamları Java teknolojileri olarak adlandırılmakta ve cep telefonlarında başlayarak birçok bilişim teknolojileri uygulamalarında kullanılmaktadır. Bu kitap Bilgisayar Programlamaya Giriş dersi verilen tüm üniversiteler, meslek okulları ve diğer eğitim kuruluşları için yazılmıştır.', 'A. Murat Özbayoğlu, Erdoğan Doğdu, Ali Yazıcı, Oğuz Ergin, Y. Murat Erten'),
(2, 1, 'JSP/Java Server Pages', 'JSP (Java Server Pages), güç, performans, çalışabildiği platform genişliği, öğrenilmesindeki kolaylık ve vaadettikleri bakımından günümüzün en güvenli sunucu-taraflı teknolojilerinden biridir. JSP''nin popüler oluşunun sebebi, taşınabilir oluşudur: Çünkü Java ve Java kökenli programlar hemen hemen tüm işletim sistemi ve platformlarda aynı şekilde çalışabilmektedir... İnternet’e bağlı bunca farklı kullanıcı ve sunucu bilgisayarı bunca farklı yazılım ve donanım kullandığı için Java teknolojileri günümüzde bu kadar ön plana çıkmıştır.\r\nJava teknolojisinin web programcılığına sunduğu en etkin ürünlerden biri olan, üstelik bedava sunulan JSP, ister Windows tabanlı olsun ister Unix ya da Linux tabanlı, bugün piyasadaki sunucuların çoğunda çalışabilmektedir. En az bunun kadar önemli olan bir diğer konu ise JSP’nin yüksek trafiğe sahip hassas web sitelerinde teknoloji olarak tercih edilmesidir. Buna sebep olarak Java’nın sahip olduğu yüksek güvenlik standartları gösterilebilir.\r\nWeb programcılığı alanında profesyonelseniz ya da profesyonel olmayı düşünüyorsanız, başta e-ticaret olmak üzere veritabanı veya XML orijinli içerik, ziyaretçi tarafından gönderilen bilgilerin elde edilmesi ve işlenmesi, otomatik mail gönderme, blog, portal gibi ihtiyaç duyduğunuz tüm alanlarda JSP''den yararlanabileceksiniz.', 'Numan Pekgöz');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Tablo döküm verisi `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Bilgisayar');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
