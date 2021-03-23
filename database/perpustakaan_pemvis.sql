-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 23, 2021 at 07:51 AM
-- Server version: 10.5.0-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan_pemvis`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` varchar(20) NOT NULL,
  `judul` varchar(50) DEFAULT NULL,
  `tahun_terbit` varchar(4) NOT NULL,
  `kategori` varchar(20) DEFAULT NULL,
  `penulis` varchar(20) DEFAULT NULL,
  `penerbit` varchar(20) DEFAULT NULL,
  `total_halaman` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `judul`, `tahun_terbit`, `kategori`, `penulis`, `penerbit`, `total_halaman`) VALUES
('B0D', 'Armies And Cats', '1940', 'CTG9D', 'AUT7D', 'PUB1D', 39),
('B100D', 'Flowers And Angels', '1941', 'CTG1D', 'AUT3D', 'PUB4D', 38),
('B101D', 'Chase Of Magic', '2016', 'CTG8D', 'AUT9D', 'PUB1D', 227),
('B102D', 'Romance Of My Childhood', '2016', 'CTG0D', 'AUT9D', 'PUB3D', 41),
('B103D', 'Symbols In The Hospital', '1980', 'CTG7D', 'AUT2D', 'PUB3D', 760),
('B104D', 'Neighbors And Children', '1933', 'CTG5D', 'AUT4D', 'PUB3D', 640),
('B105D', 'Boys In The Castle', '1902', 'CTG2D', 'AUT8D', 'PUB4D', 585),
('B106D', 'Disruption Of The River', '1935', 'CTG1D', 'AUT2D', 'PUB4D', 178),
('B107D', 'Romance Of My Childhood', '1969', 'CTG5D', 'AUT0D', 'PUB4D', 694),
('B108D', 'Force Of Hell', '1941', 'CTG5D', 'AUT5D', 'PUB3D', 179),
('B109D', 'Man Of Rainbows', '1900', 'CTG3D', 'AUT7D', 'PUB1D', 396),
('B10D', 'Goal Of Nightmares', '1939', 'CTG1D', 'AUT1D', 'PUB1D', 307),
('B110D', 'Swindler Of The Moon', '1972', 'CTG2D', 'AUT2D', 'PUB0D', 387),
('B111D', 'Birds And Rabbits', '1970', 'CTG4D', 'AUT8D', 'PUB3D', 570),
('B112D', 'Rain Of The Past', '1940', 'CTG7D', 'AUT4D', 'PUB2D', 406),
('B113D', 'Girl Kicked Me Out', '1957', 'CTG9D', 'AUT8D', 'PUB4D', 956),
('B114D', 'Boys In The Castle', '1909', 'CTG3D', 'AUT1D', 'PUB3D', 532),
('B115D', 'Bane Of Power', '1984', 'CTG2D', 'AUT9D', 'PUB2D', 541),
('B116D', 'Agents Who Smiles', '1987', 'CTG0D', 'AUT9D', 'PUB3D', 712),
('B117D', 'Buffoon And Lord', '1902', 'CTG5D', 'AUT3D', 'PUB0D', 846),
('B118D', 'Shrouded By Dreams', '1908', 'CTG8D', 'AUT9D', 'PUB2D', 847),
('B119D', 'Wife And Soldier', '1915', 'CTG2D', 'AUT5D', 'PUB3D', 15),
('B11D', 'Ambush Of Sunshine', '2012', 'CTG7D', 'AUT0D', 'PUB4D', 645),
('B120D', 'Resources Of Time', '2007', 'CTG6D', 'AUT8D', 'PUB3D', 980),
('B121D', 'Animals Without Hope', '2009', 'CTG1D', 'AUT0D', 'PUB4D', 320),
('B122D', 'Imp Following Me', '1987', 'CTG4D', 'AUT9D', 'PUB2D', 104),
('B123D', 'Resources Of Time', '1980', 'CTG7D', 'AUT7D', 'PUB4D', 751),
('B124D', 'Queen Of Reality', '1923', 'CTG9D', 'AUT2D', 'PUB0D', 586),
('B125D', 'Lord And Doctor', '1921', 'CTG0D', 'AUT9D', 'PUB0D', 949),
('B126D', 'Origin Of A Nuclear Winter', '1916', 'CTG9D', 'AUT6D', 'PUB1D', 356),
('B127D', 'Hidden In The Graveyard', '1917', 'CTG8D', 'AUT9D', 'PUB0D', 794),
('B128D', 'Rabbits And Bears', '2001', 'CTG1D', 'AUT9D', 'PUB4D', 190),
('B129D', 'Lovers Of My Imagination', '2014', 'CTG9D', 'AUT8D', 'PUB4D', 475),
('B12D', 'Crazy With My Pet Dragon', '1965', 'CTG9D', 'AUT3D', 'PUB3D', 845),
('B130D', 'Lord And Doctor', '1916', 'CTG3D', 'AUT2D', 'PUB1D', 509),
('B131D', 'Bringers And Inventors', '1954', 'CTG9D', 'AUT7D', 'PUB2D', 810),
('B132D', 'Hunters Of The River', '1973', 'CTG4D', 'AUT0D', 'PUB0D', 232),
('B133D', 'Snakes And Descendants', '1996', 'CTG3D', 'AUT8D', 'PUB2D', 106),
('B134D', 'Bane Of Power', '2002', 'CTG0D', 'AUT1D', 'PUB4D', 269),
('B135D', 'Memory Of Secrets', '1940', 'CTG2D', 'AUT9D', 'PUB1D', 691),
('B136D', 'Spider Of Greatness', '1956', 'CTG9D', 'AUT3D', 'PUB3D', 268),
('B137D', 'Lord Of The Frontline', '1929', 'CTG8D', 'AUT5D', 'PUB2D', 700),
('B138D', 'Girls And Dogs', '1958', 'CTG0D', 'AUT7D', 'PUB0D', 231),
('B139D', 'Swindler Of The Moon', '1903', 'CTG5D', 'AUT5D', 'PUB3D', 505),
('B13D', 'Passion Of Fond Memories', '1944', 'CTG9D', 'AUT0D', 'PUB1D', 645),
('B140D', 'Disruption Of The Sea', '1997', 'CTG4D', 'AUT1D', 'PUB3D', 570),
('B141D', 'Followers In The Wild', '1967', 'CTG9D', 'AUT2D', 'PUB0D', 556),
('B142D', 'God Without Honor', '1978', 'CTG8D', 'AUT8D', 'PUB2D', 138),
('B143D', 'Present Of My Niece', '1928', 'CTG1D', 'AUT6D', 'PUB1D', 128),
('B144D', 'Caring For My New Fish', '1918', 'CTG6D', 'AUT6D', 'PUB2D', 620),
('B145D', 'Origin Of A Nuclear Winter', '2014', 'CTG3D', 'AUT0D', 'PUB1D', 795),
('B146D', 'Fish And Rulers', '1992', 'CTG7D', 'AUT8D', 'PUB0D', 598),
('B147D', 'Thief Wish', '1923', 'CTG6D', 'AUT0D', 'PUB4D', 154),
('B148D', 'Defenders Of A Person', '2016', 'CTG8D', 'AUT3D', 'PUB3D', 415),
('B149D', 'Certainty Of Last Rites', '1931', 'CTG0D', 'AUT1D', 'PUB4D', 510),
('B14D', 'Girls And Dogs', '1955', 'CTG2D', 'AUT6D', 'PUB4D', 176),
('B150D', 'Hat Of Mystery', '2015', 'CTG0D', 'AUT0D', 'PUB2D', 764),
('B151D', 'Symbols Of The North', '1992', 'CTG5D', 'AUT0D', 'PUB1D', 929),
('B152D', 'Trees Per Country', '1958', 'CTG0D', 'AUT7D', 'PUB1D', 736),
('B153D', 'Game Of The Titans', '2008', 'CTG7D', 'AUT3D', 'PUB3D', 193),
('B154D', 'Disruption Of The Sea', '1967', 'CTG8D', 'AUT1D', 'PUB1D', 782),
('B155D', 'Lion Of Limbo', '1992', 'CTG7D', 'AUT9D', 'PUB4D', 782),
('B156D', 'Captains And Volunteers', '1943', 'CTG6D', 'AUT4D', 'PUB0D', 771),
('B157D', 'Rain Of The Past', '2018', 'CTG8D', 'AUT5D', 'PUB3D', 117),
('B158D', 'Monk With Honor', '1917', 'CTG3D', 'AUT2D', 'PUB3D', 12),
('B159D', 'Aliens And Gods', '2018', 'CTG4D', 'AUT3D', 'PUB1D', 803),
('B15D', 'Passion Of Fond Memories', '1972', 'CTG1D', 'AUT6D', 'PUB2D', 709),
('B160D', 'Hunters And Assassins', '1960', 'CTG2D', 'AUT3D', 'PUB4D', 755),
('B161D', 'Escaping The Forest', '1956', 'CTG0D', 'AUT6D', 'PUB3D', 658),
('B162D', 'Lion Of Limbo', '1993', 'CTG8D', 'AUT2D', 'PUB4D', 311),
('B163D', 'Expert In My Dreams', '1977', 'CTG7D', 'AUT4D', 'PUB3D', 765),
('B164D', 'Angels Of Lust', '2000', 'CTG0D', 'AUT4D', 'PUB2D', 527),
('B165D', 'Welcome To The Nation', '2003', 'CTG8D', 'AUT8D', 'PUB4D', 768),
('B166D', 'Question Of The Stars', '2007', 'CTG7D', 'AUT4D', 'PUB4D', 902),
('B167D', 'Excellence Of The Lands', '1932', 'CTG8D', 'AUT3D', 'PUB4D', 13),
('B168D', 'Stunning Painting', '1936', 'CTG1D', 'AUT0D', 'PUB0D', 158),
('B169D', 'Pig In The River', '1907', 'CTG9D', 'AUT1D', 'PUB2D', 61),
('B16D', 'Medic In The News', '1918', 'CTG2D', 'AUT6D', 'PUB4D', 301),
('B170D', 'Chase Of Magic', '1994', 'CTG4D', 'AUT3D', 'PUB2D', 605),
('B171D', 'King Exploit', '1911', 'CTG8D', 'AUT1D', 'PUB0D', 424),
('B172D', 'Nymphs And Beloved', '1976', 'CTG5D', 'AUT4D', 'PUB2D', 43),
('B173D', 'World Of Dawn', '1902', 'CTG2D', 'AUT7D', 'PUB0D', 227),
('B174D', 'Clown In The Museum', '2011', 'CTG8D', 'AUT4D', 'PUB2D', 462),
('B175D', 'Demand For Technology', '1976', 'CTG7D', 'AUT6D', 'PUB0D', 770),
('B176D', 'Anger Of The Project', '1996', 'CTG7D', 'AUT7D', 'PUB0D', 123),
('B177D', 'Searching For His Friends', '1962', 'CTG0D', 'AUT5D', 'PUB4D', 744),
('B178D', 'Lord Of The Frontline', '1950', 'CTG9D', 'AUT2D', 'PUB3D', 30),
('B179D', 'Monks In The River', '2015', 'CTG7D', 'AUT9D', 'PUB3D', 79),
('B17D', 'Dogs Of The Ancients', '1920', 'CTG2D', 'AUT9D', 'PUB0D', 21),
('B180D', 'Origin Of A Nuclear Winter', '2007', 'CTG6D', 'AUT3D', 'PUB0D', 129),
('B181D', 'Lord With A Hat', '1933', 'CTG7D', 'AUT3D', 'PUB0D', 96),
('B182D', 'Crazy With My Pet Dragon', '1932', 'CTG5D', 'AUT2D', 'PUB1D', 862),
('B183D', 'Crows And Crows', '1989', 'CTG7D', 'AUT3D', 'PUB4D', 825),
('B184D', 'Mausoleum Of Spring', '1900', 'CTG2D', 'AUT7D', 'PUB3D', 8),
('B185D', 'Force Of Hell', '2015', 'CTG3D', 'AUT1D', 'PUB4D', 962),
('B186D', 'Hat Of Mystery', '1947', 'CTG3D', 'AUT4D', 'PUB1D', 974),
('B187D', 'Nymphs And Neighbors', '1931', 'CTG0D', 'AUT6D', 'PUB4D', 56),
('B188D', 'Nymphs And Beloved', '1953', 'CTG4D', 'AUT7D', 'PUB0D', 924),
('B189D', 'Human In My Town', '1911', 'CTG9D', 'AUT9D', 'PUB2D', 107),
('B18D', 'Imp Following Me', '1918', 'CTG2D', 'AUT2D', 'PUB0D', 398),
('B190D', 'Necromancer Of Power', '1970', 'CTG3D', 'AUT7D', 'PUB0D', 302),
('B191D', 'Necromancer Of Power', '1998', 'CTG3D', 'AUT8D', 'PUB3D', 771),
('B192D', 'Pig In The River', '1920', 'CTG1D', 'AUT5D', 'PUB3D', 494),
('B193D', 'Music In My Street', '1977', 'CTG5D', 'AUT9D', 'PUB4D', 907),
('B194D', 'Demand For Technology', '1974', 'CTG6D', 'AUT1D', 'PUB3D', 441),
('B195D', 'Nymphs And Beloved', '1947', 'CTG5D', 'AUT4D', 'PUB1D', 162),
('B196D', 'Noises In The Crypts', '1946', 'CTG8D', 'AUT9D', 'PUB4D', 165),
('B197D', 'Vampires And Phantoms', '1914', 'CTG5D', 'AUT2D', 'PUB3D', 758),
('B198D', 'Blacksmiths And Swindlers', '1946', 'CTG3D', 'AUT1D', 'PUB2D', 186),
('B199D', 'Symbols Of The North', '1929', 'CTG7D', 'AUT6D', 'PUB2D', 549),
('B19D', 'Game Of The Titans', '1954', 'CTG6D', 'AUT8D', 'PUB4D', 668),
('B1D', 'Pests And Dinosaurs', '1977', 'CTG4D', 'AUT2D', 'PUB4D', 638),
('B20D', 'Wolves Of Shadows', '1990', 'CTG5D', 'AUT9D', 'PUB4D', 642),
('B21D', 'Hunter And Pig', '1977', 'CTG9D', 'AUT5D', 'PUB4D', 6),
('B22D', 'Clan Of A Woman', '1945', 'CTG1D', 'AUT9D', 'PUB2D', 745),
('B23D', 'Wife And Soldier', '1906', 'CTG4D', 'AUT6D', 'PUB0D', 720),
('B24D', 'Dogs Of The Ancients', '1907', 'CTG9D', 'AUT4D', 'PUB0D', 115),
('B25D', 'Blinded By The Night', '1980', 'CTG4D', 'AUT6D', 'PUB4D', 304),
('B26D', 'Rabbits And Bears', '1924', 'CTG9D', 'AUT5D', 'PUB2D', 302),
('B27D', 'Rabbits And Bears', '1968', 'CTG3D', 'AUT1D', 'PUB0D', 274),
('B28D', 'Boy In The Attic', '2013', 'CTG4D', 'AUT4D', 'PUB3D', 80),
('B29D', 'Children With Horns', '1928', 'CTG6D', 'AUT6D', 'PUB2D', 531),
('B2D', 'Herbs Of The West', '1993', 'CTG0D', 'AUT3D', 'PUB0D', 732),
('B30D', 'Abandoned By The Past', '1932', 'CTG5D', 'AUT1D', 'PUB4D', 238),
('B31D', 'Frozen By The Machines', '1986', 'CTG4D', 'AUT0D', 'PUB2D', 811),
('B32D', 'Flame Of Fire', '1926', 'CTG0D', 'AUT6D', 'PUB2D', 763),
('B33D', 'Lord With A Hat', '1913', 'CTG0D', 'AUT4D', 'PUB0D', 178),
('B34D', 'Farmers And Slaves', '1955', 'CTG2D', 'AUT9D', 'PUB1D', 768),
('B35D', 'Flowers And Herbs', '1926', 'CTG7D', 'AUT0D', 'PUB0D', 11),
('B36D', 'Mice Of Stone', '1939', 'CTG5D', 'AUT0D', 'PUB2D', 55),
('B37D', 'Spider Of Greatness', '1917', 'CTG3D', 'AUT8D', 'PUB0D', 859),
('B38D', 'Fiends And Animals', '1948', 'CTG3D', 'AUT6D', 'PUB1D', 824),
('B39D', 'Captains And Volunteers', '1993', 'CTG2D', 'AUT7D', 'PUB2D', 983),
('B3D', 'Monks In The River', '1976', 'CTG2D', 'AUT6D', 'PUB3D', 626),
('B40D', 'Man With A UFO', '1976', 'CTG7D', 'AUT3D', 'PUB4D', 502),
('B41D', 'Birds And Rabbits', '1990', 'CTG9D', 'AUT5D', 'PUB3D', 288),
('B42D', 'Monk With Honor', '1988', 'CTG1D', 'AUT4D', 'PUB4D', 218),
('B43D', 'Wife And Soldier', '2003', 'CTG4D', 'AUT9D', 'PUB2D', 677),
('B44D', 'Angels Of Lust', '1958', 'CTG4D', 'AUT5D', 'PUB4D', 888),
('B45D', 'Hunters And Assassins', '1958', 'CTG3D', 'AUT2D', 'PUB0D', 724),
('B46D', 'Demand For Technology', '1932', 'CTG6D', 'AUT6D', 'PUB4D', 311),
('B47D', 'Women Of The Depths', '1969', 'CTG6D', 'AUT9D', 'PUB0D', 835),
('B48D', 'Children And Doctors', '1903', 'CTG2D', 'AUT4D', 'PUB4D', 78),
('B49D', 'Hunters Of The Flight', '1986', 'CTG9D', 'AUT2D', 'PUB0D', 819),
('B4D', 'Fish And Pilots', '1915', 'CTG1D', 'AUT2D', 'PUB0D', 941),
('B50D', 'Trees Per Country', '1949', 'CTG0D', 'AUT7D', 'PUB4D', 490),
('B51D', 'Children With Horns', '1955', 'CTG7D', 'AUT4D', 'PUB4D', 59),
('B52D', 'Disruption Of The Sea', '1983', 'CTG7D', 'AUT7D', 'PUB2D', 993),
('B53D', 'Strangers Of Fire', '2002', 'CTG9D', 'AUT9D', 'PUB4D', 116),
('B54D', 'Anger Of The Project', '1970', 'CTG4D', 'AUT9D', 'PUB1D', 955),
('B55D', 'Force Of Hell', '1929', 'CTG4D', 'AUT8D', 'PUB0D', 840),
('B56D', 'Certainty Of Last Rites', '1991', 'CTG2D', 'AUT1D', 'PUB2D', 908),
('B57D', 'Justice In My Past', '1966', 'CTG1D', 'AUT9D', 'PUB2D', 629),
('B58D', 'Justice In My Past', '1960', 'CTG0D', 'AUT1D', 'PUB3D', 602),
('B59D', 'Lord With A Hat', '1968', 'CTG2D', 'AUT9D', 'PUB4D', 635),
('B5D', 'Angel Design', '1998', 'CTG6D', 'AUT9D', 'PUB4D', 92),
('B60D', 'Kittens Of The Stars', '1942', 'CTG4D', 'AUT8D', 'PUB0D', 439),
('B61D', 'Frozen In The Pits', '2010', 'CTG1D', 'AUT6D', 'PUB4D', 257),
('B62D', 'Politicians Of The Caves', '1945', 'CTG1D', 'AUT5D', 'PUB0D', 46),
('B63D', 'Strangers Of Fire', '1946', 'CTG9D', 'AUT3D', 'PUB4D', 338),
('B64D', 'Pests And Dinosaurs', '1995', 'CTG9D', 'AUT4D', 'PUB2D', 900),
('B65D', 'Cats Of Fire', '1981', 'CTG9D', 'AUT4D', 'PUB0D', 957),
('B66D', 'Wolves And Boys', '1978', 'CTG3D', 'AUT6D', 'PUB2D', 29),
('B67D', 'Sounds Of Dreams', '1956', 'CTG3D', 'AUT9D', 'PUB0D', 727),
('B68D', 'Hunters And Assassins', '1932', 'CTG3D', 'AUT2D', 'PUB2D', 911),
('B69D', 'Flowers And Angels', '1983', 'CTG8D', 'AUT3D', 'PUB0D', 924),
('B6D', 'Lion Of Limbo', '1921', 'CTG2D', 'AUT7D', 'PUB4D', 454),
('B70D', 'Memory Of Secrets', '1986', 'CTG2D', 'AUT6D', 'PUB1D', 766),
('B71D', 'Monks In The River', '1940', 'CTG8D', 'AUT1D', 'PUB4D', 731),
('B72D', 'Nymphs And Neighbors', '1913', 'CTG0D', 'AUT2D', 'PUB1D', 424),
('B73D', 'Gold With Style', '1950', 'CTG8D', 'AUT5D', 'PUB3D', 222),
('B74D', 'Neighbors Of Hell', '1968', 'CTG8D', 'AUT9D', 'PUB4D', 4),
('B75D', 'Gangsters And Robots', '1955', 'CTG0D', 'AUT2D', 'PUB0D', 611),
('B76D', 'Queen Of Reality', '1923', 'CTG2D', 'AUT9D', 'PUB2D', 561),
('B77D', 'Sins Of Orbit', '1910', 'CTG2D', 'AUT2D', 'PUB1D', 591),
('B78D', 'Guest Of Passion', '1979', 'CTG1D', 'AUT4D', 'PUB0D', 805),
('B79D', 'Expert In My Dreams', '1962', 'CTG0D', 'AUT4D', 'PUB3D', 383),
('B7D', 'World Of Dawn', '1946', 'CTG8D', 'AUT4D', 'PUB1D', 294),
('B80D', 'Guardian Of Rainbows', '1929', 'CTG5D', 'AUT7D', 'PUB2D', 920),
('B81D', 'Game Of The Titans', '2001', 'CTG9D', 'AUT8D', 'PUB1D', 393),
('B82D', 'World Of Dawn', '1928', 'CTG2D', 'AUT8D', 'PUB1D', 345),
('B83D', 'Buffoon And Lord', '1917', 'CTG4D', 'AUT3D', 'PUB0D', 88),
('B84D', 'Bewitched By Fantasy', '1914', 'CTG0D', 'AUT7D', 'PUB2D', 252),
('B85D', 'Frozen By The Machines', '1904', 'CTG9D', 'AUT0D', 'PUB1D', 911),
('B86D', 'Expert In My Dreams', '1992', 'CTG1D', 'AUT1D', 'PUB0D', 257),
('B87D', 'Wolves Of Shadows', '1946', 'CTG0D', 'AUT4D', 'PUB1D', 733),
('B88D', 'Thief Wish', '1928', 'CTG2D', 'AUT5D', 'PUB3D', 658),
('B89D', 'Excitement Of The Mayor', '1926', 'CTG3D', 'AUT0D', 'PUB0D', 457),
('B8D', 'Traps Can Cook', '1998', 'CTG2D', 'AUT4D', 'PUB3D', 520),
('B90D', 'Disruption Of The River', '1975', 'CTG0D', 'AUT4D', 'PUB3D', 285),
('B91D', 'Angels Of Lust', '2006', 'CTG5D', 'AUT3D', 'PUB3D', 9),
('B92D', 'Girls And Dogs', '2000', 'CTG4D', 'AUT6D', 'PUB1D', 707),
('B93D', 'Blinded By Darkness', '2016', 'CTG9D', 'AUT6D', 'PUB4D', 29),
('B94D', 'Force Of Hell', '1993', 'CTG2D', 'AUT9D', 'PUB1D', 283),
('B95D', 'Mice And Goats', '1948', 'CTG7D', 'AUT4D', 'PUB0D', 111),
('B96D', 'Hunters And Assassins', '1982', 'CTG8D', 'AUT2D', 'PUB1D', 139),
('B97D', 'Creators Of A Star', '1932', 'CTG9D', 'AUT6D', 'PUB4D', 450),
('B98D', 'Officers Of Exploration', '1935', 'CTG2D', 'AUT0D', 'PUB3D', 838),
('B99D', 'Memory Of Secrets', '1928', 'CTG0D', 'AUT0D', 'PUB4D', 259),
('B9D', 'Angel Design', '1914', 'CTG8D', 'AUT4D', 'PUB4D', 174);

-- --------------------------------------------------------

--
-- Stand-in structure for view `buku_peminjaman_member`
-- (See below for the actual view)
--
CREATE TABLE `buku_peminjaman_member` (
`id` varchar(20)
,`member` varchar(20)
,`buku` varchar(20)
,`tanggal_pinjam` date
,`tanggal_kembali` date
,`deadline` int(11)
,`judul_buku` varchar(50)
,`nama_member` varchar(30)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `buku_simple`
-- (See below for the actual view)
--
CREATE TABLE `buku_simple` (
`id` varchar(20)
,`judul` varchar(50)
,`tahun_terbit` varchar(4)
,`kategori` varchar(20)
,`penulis` varchar(20)
,`penerbit` varchar(20)
,`total_halaman` int(11)
,`nama_penulis` varchar(50)
,`nama_penerbit` varchar(50)
,`nama_kategori` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id` varchar(20) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `label` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id`, `nama`, `label`) VALUES
('CTG0D', 'Thriller', 'magenta'),
('CTG1D', 'Health', 'violet'),
('CTG2D', 'Cooking', 'lime green'),
('CTG3D', 'Mystery', 'silver'),
('CTG4D', 'Humor', 'silver'),
('CTG5D', 'Historical fiction', 'beige'),
('CTG6D', 'Development', 'chocolate brown'),
('CTG7D', 'Dystopian', 'burgundy'),
('CTG8D', 'Historical fiction', 'silver'),
('CTG9D', 'Motivational', 'bleached yellow');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` varchar(20) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `no_telpon` varchar(20) DEFAULT NULL,
  `jenis_kelamin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `nama`, `alamat`, `no_telpon`, `jenis_kelamin`) VALUES
('M0D', 'Brooks Bolton', '928-2289 Eu, Av.', '492422502', 'Female'),
('M10D', 'Dickson Mcclure', 'P.O. Box 853, 1517 Sem, Street', '517285442', 'Male'),
('M11D', 'Ballard Lancaster', '938-7716 Sem Street', '866788876', 'Female'),
('M12D', 'Sears Ruiz', '180-1341 Urna. Rd.', '307458664', 'Female'),
('M13D', 'Willis Munoz', '2772 Natoque Avenue', '861924942', 'Female'),
('M14D', 'Mejia Ingram', '7498 Turpis Road', '609214820', 'Male'),
('M15D', 'Ingram Odom', '2772 Natoque Avenue', '227016984', 'Male'),
('M16D', 'Russo Beach', '153-1844 Libero St.', '834832200', 'Female'),
('M17D', 'Donovan Robles', '5897 Metus. Road', '580653809', 'Female'),
('M18D', 'Simmons Eaton', '549 Sit Rd.', '372573503', 'Female'),
('M19D', 'Bradley Leblanc', '5897 Metus. Road', '269949401', 'Male'),
('M1D', 'Scott Bradley', '1809 Vel, St.', '227876525', 'Male'),
('M20D', 'Lara Randolph', '472-1555 Eu Avenue', '19369523', 'Female'),
('M21D', 'Perry Melton', '928-2289 Eu, Av.', '869596827', 'Female'),
('M22D', 'Rowe Levy', '3748 Pede Av.', '301307356', 'Male'),
('M23D', 'Clayton Hodge', 'P.O. Box 665, 3764 Lorem, St.', '251180253', 'Male'),
('M24D', 'Riggs Levy', '337-9499 Ac Avenue', '864629875', 'Male'),
('M2D', 'Pearson Solomon', 'Ap #513-1037 Libero. St.', '890967366', 'Female'),
('M3D', 'Murray Melton', 'P.O. Box 853, 1517 Sem, Street', '296593743', 'Female'),
('M4D', 'Mckee Martinez', 'Ap #152-627 Vitae, St.', '367868975', 'Male'),
('M5D', 'Charles Duffy', '606-2846 Eleifend St.', '575618673', 'Male'),
('M6D', 'Crane Harvey', '472-1555 Eu Avenue', '916943069', 'Female'),
('M7D', 'Quinn Baird', 'P.O. Box 149, 5098 Sollicitudin St.', '252955399', 'Female'),
('M8D', 'Sears Tran', 'Ap #190-4137 Felis. Avenue', '863011337', 'Female'),
('M9D', 'Castro Miller', '7563 Penatibus St.', '925713142', 'Female');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id` varchar(20) NOT NULL,
  `member` varchar(20) NOT NULL,
  `buku` varchar(20) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_kembali` date NOT NULL,
  `deadline` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id`, `member`, `buku`, `tanggal_pinjam`, `tanggal_kembali`, `deadline`) VALUES
('BOR0D', 'M9D', 'B182D', '1939-04-03', '1993-01-24', 961),
('BOR100D', 'M13D', 'B167D', '2000-03-03', '2018-11-13', 327),
('BOR101D', 'M19D', 'B100D', '1945-08-16', '2012-03-26', 55),
('BOR102D', 'M6D', 'B192D', '1946-07-07', '2016-09-03', 269),
('BOR103D', 'M12D', 'B180D', '1945-02-06', '2015-10-13', 334),
('BOR104D', 'M7D', 'B30D', '1920-11-04', '1984-03-15', 125),
('BOR105D', 'M21D', 'B155D', '2005-01-05', '1982-03-01', 967),
('BOR106D', 'M2D', 'B53D', '1906-11-19', '1936-08-07', 99),
('BOR107D', 'M21D', 'B156D', '1996-07-03', '2017-02-05', 726),
('BOR108D', 'M0D', 'B76D', '1987-07-21', '1932-07-28', 309),
('BOR109D', 'M23D', 'B131D', '1986-10-09', '1947-04-08', 188),
('BOR10D', 'M13D', 'B191D', '1935-06-16', '1914-06-16', 233),
('BOR110D', 'M24D', 'B55D', '1906-10-12', '1983-04-24', 129),
('BOR111D', 'M12D', 'B163D', '1945-04-08', '1987-07-12', 472),
('BOR112D', 'M21D', 'B13D', '1923-02-17', '1920-04-11', 267),
('BOR113D', 'M14D', 'B61D', '1928-09-01', '1928-06-28', 442),
('BOR114D', 'M5D', 'B121D', '1925-03-28', '1915-01-25', 67),
('BOR115D', 'M2D', 'B124D', '2015-07-05', '2006-10-07', 930),
('BOR116D', 'M23D', 'B33D', '1992-11-04', '1993-04-05', 325),
('BOR117D', 'M9D', 'B155D', '1946-06-02', '1989-10-23', 52),
('BOR118D', 'M18D', 'B166D', '1980-01-23', '1950-07-23', 19),
('BOR119D', 'M4D', 'B71D', '2009-05-21', '1937-03-04', 919),
('BOR11D', 'M24D', 'B142D', '1984-01-22', '2008-06-26', 95),
('BOR120D', 'M3D', 'B139D', '1932-07-07', '2017-01-15', 674),
('BOR121D', 'M3D', 'B142D', '2007-10-04', '1918-11-22', 69),
('BOR122D', 'M4D', 'B59D', '1950-02-23', '1933-09-10', 65),
('BOR123D', 'M16D', 'B24D', '1935-06-01', '1925-08-25', 720),
('BOR124D', 'M1D', 'B142D', '1990-11-07', '2005-01-12', 96),
('BOR125D', 'M14D', 'B3D', '1996-09-26', '1929-02-07', 357),
('BOR126D', 'M4D', 'B145D', '1954-02-17', '1929-03-28', 388),
('BOR127D', 'M10D', 'B47D', '1965-07-21', '1967-10-12', 512),
('BOR128D', 'M6D', 'B131D', '1924-08-06', '1951-07-15', 368),
('BOR129D', 'M21D', 'B128D', '1925-07-19', '1995-11-28', 370),
('BOR12D', 'M21D', 'B195D', '1940-01-07', '1999-11-04', 70),
('BOR130D', 'M3D', 'B9D', '1906-05-23', '1947-06-18', 38),
('BOR131D', 'M9D', 'B63D', '1940-02-08', '1936-04-15', 868),
('BOR132D', 'M11D', 'B12D', '1943-08-09', '1973-09-16', 517),
('BOR133D', 'M9D', 'B6D', '1990-05-21', '1980-08-15', 305),
('BOR134D', 'M20D', 'B73D', '1947-10-10', '2003-09-24', 548),
('BOR135D', 'M2D', 'B10D', '1927-08-16', '1967-09-08', 337),
('BOR136D', 'M20D', 'B103D', '1967-04-12', '1906-07-13', 361),
('BOR137D', 'M16D', 'B79D', '1993-03-03', '1981-09-22', 493),
('BOR138D', 'M4D', 'B33D', '1918-11-05', '1953-01-22', 329),
('BOR139D', 'M6D', 'B113D', '1922-06-22', '1970-01-22', 388),
('BOR13D', 'M17D', 'B87D', '1962-11-15', '1924-03-18', 196),
('BOR140D', 'M20D', 'B198D', '1939-04-22', '1901-06-10', 74),
('BOR141D', 'M12D', 'B49D', '1950-03-19', '1989-06-20', 358),
('BOR142D', 'M22D', 'B166D', '1967-02-16', '1946-10-01', 931),
('BOR143D', 'M18D', 'B139D', '1957-07-14', '1941-09-22', 946),
('BOR144D', 'M16D', 'B172D', '2018-02-04', '1999-04-20', 893),
('BOR145D', 'M15D', 'B40D', '1919-06-13', '1963-07-27', 58),
('BOR146D', 'M1D', 'B10D', '1911-08-13', '1927-03-13', 14),
('BOR147D', 'M5D', 'B93D', '1951-05-26', '1970-09-21', 556),
('BOR148D', 'M19D', 'B64D', '2004-10-02', '1943-08-11', 416),
('BOR149D', 'M14D', 'B142D', '2017-08-20', '1939-05-22', 945),
('BOR14D', 'M7D', 'B181D', '1939-11-22', '1936-05-21', 292),
('BOR150D', 'M17D', 'B119D', '1951-09-25', '2012-07-19', 154),
('BOR151D', 'M7D', 'B104D', '1956-03-06', '1952-07-28', 748),
('BOR152D', 'M24D', 'B142D', '2001-10-02', '1962-02-27', 389),
('BOR153D', 'M19D', 'B192D', '1912-03-18', '2015-09-08', 306),
('BOR154D', 'M9D', 'B31D', '1963-03-26', '2006-07-15', 374),
('BOR155D', 'M14D', 'B134D', '1973-04-07', '1961-04-13', 527),
('BOR156D', 'M20D', 'B163D', '1973-02-26', '1946-01-15', 279),
('BOR157D', 'M24D', 'B67D', '1962-02-02', '1995-03-10', 444),
('BOR158D', 'M3D', 'B91D', '2008-04-02', '1924-04-02', 638),
('BOR159D', 'M23D', 'B160D', '2000-08-24', '1994-08-14', 0),
('BOR15D', 'M6D', 'B39D', '1958-11-19', '1909-10-06', 236),
('BOR160D', 'M21D', 'B175D', '1944-09-21', '1921-08-22', 449),
('BOR161D', 'M3D', 'B95D', '1919-02-11', '1907-08-01', 60),
('BOR162D', 'M7D', 'B179D', '1955-05-11', '1991-04-05', 413),
('BOR163D', 'M19D', 'B154D', '1921-11-21', '1959-04-02', 108),
('BOR164D', 'M3D', 'B129D', '1906-03-17', '1954-05-23', 188),
('BOR165D', 'M18D', 'B150D', '2002-08-15', '1934-01-07', 37),
('BOR166D', 'M8D', 'B107D', '2001-11-14', '1905-07-19', 784),
('BOR167D', 'M19D', 'B6D', '1931-02-01', '1975-01-28', 40),
('BOR168D', 'M1D', 'B86D', '1984-05-01', '1931-05-28', 445),
('BOR169D', 'M11D', 'B60D', '1991-10-01', '1976-09-13', 194),
('BOR16D', 'M17D', 'B31D', '1921-02-16', '1995-10-08', 417),
('BOR170D', 'M8D', 'B64D', '1925-04-17', '1984-05-15', 519),
('BOR171D', 'M16D', 'B131D', '2006-11-11', '1996-06-07', 440),
('BOR172D', 'M17D', 'B49D', '1933-08-22', '1960-07-18', 641),
('BOR173D', 'M16D', 'B73D', '2001-01-16', '1968-05-10', 293),
('BOR174D', 'M21D', 'B120D', '1919-05-20', '2001-08-09', 975),
('BOR175D', 'M12D', 'B16D', '1999-03-02', '1953-03-17', 690),
('BOR176D', 'M21D', 'B54D', '1946-02-03', '2014-03-19', 528),
('BOR177D', 'M11D', 'B105D', '2011-11-26', '1942-05-22', 598),
('BOR178D', 'M23D', 'B80D', '1982-03-09', '2002-08-18', 668),
('BOR179D', 'M8D', 'B88D', '1918-07-20', '1967-07-12', 652),
('BOR17D', 'M4D', 'B138D', '1911-07-03', '1926-05-08', 713),
('BOR180D', 'M7D', 'B83D', '1961-01-06', '1921-08-21', 718),
('BOR181D', 'M23D', 'B152D', '1933-03-08', '1999-06-22', 569),
('BOR182D', 'M8D', 'B132D', '1990-07-16', '1943-06-25', 890),
('BOR183D', 'M9D', 'B37D', '2012-09-26', '2001-09-28', 977),
('BOR184D', 'M0D', 'B185D', '1931-06-27', '1952-09-11', 127),
('BOR185D', 'M12D', 'B106D', '1936-07-03', '1983-02-09', 853),
('BOR186D', 'M16D', 'B168D', '1929-06-10', '1964-08-02', 790),
('BOR187D', 'M7D', 'B71D', '1992-11-24', '1994-06-04', 756),
('BOR188D', 'M7D', 'B48D', '1971-05-22', '1932-08-13', 294),
('BOR189D', 'M5D', 'B167D', '1907-01-06', '1972-05-22', 577),
('BOR18D', 'M17D', 'B66D', '1985-06-08', '1985-11-01', 985),
('BOR190D', 'M17D', 'B171D', '2018-02-07', '2014-06-15', 892),
('BOR191D', 'M21D', 'B22D', '1925-05-16', '1944-11-15', 584),
('BOR192D', 'M4D', 'B159D', '1999-09-25', '1940-03-13', 243),
('BOR193D', 'M12D', 'B163D', '1905-01-05', '1962-02-06', 92),
('BOR194D', 'M0D', 'B119D', '1997-03-28', '1967-05-25', 184),
('BOR195D', 'M15D', 'B146D', '1910-08-10', '2006-11-17', 321),
('BOR196D', 'M15D', 'B54D', '1976-04-21', '1992-10-01', 306),
('BOR197D', 'M11D', 'B154D', '1993-11-22', '1965-08-03', 723),
('BOR198D', 'M12D', 'B160D', '1934-03-13', '1997-08-23', 494),
('BOR199D', 'M15D', 'B94D', '1958-03-05', '1923-05-07', 701),
('BOR19D', 'M2D', 'B107D', '2018-09-10', '2009-07-19', 770),
('BOR1D', 'M15D', 'B165D', '1960-07-05', '1977-05-01', 631),
('BOR200D', 'M6D', 'B110D', '1963-06-27', '1972-01-23', 115),
('BOR201D', 'M10D', 'B186D', '2017-02-16', '1999-10-15', 778),
('BOR202D', 'M13D', 'B110D', '1945-03-03', '1932-04-02', 99),
('BOR203D', 'M12D', 'B41D', '1953-10-09', '1999-05-09', 719),
('BOR204D', 'M12D', 'B10D', '1933-05-09', '1990-04-23', 772),
('BOR205D', 'M18D', 'B51D', '1973-11-21', '2016-06-25', 58),
('BOR206D', 'M17D', 'B110D', '1920-07-12', '1936-06-26', 160),
('BOR207D', 'M23D', 'B18D', '1927-10-18', '1948-01-08', 164),
('BOR208D', 'M19D', 'B112D', '1960-04-11', '1956-01-18', 69),
('BOR209D', 'M20D', 'B135D', '2014-06-09', '1995-09-18', 348),
('BOR20D', 'M18D', 'B64D', '1943-02-15', '1937-06-26', 301),
('BOR210D', 'M20D', 'B136D', '2003-09-13', '1907-11-10', 872),
('BOR211D', 'M8D', 'B183D', '1962-09-24', '1975-01-25', 966),
('BOR212D', 'M9D', 'B53D', '1951-11-14', '1910-04-07', 485),
('BOR213D', 'M12D', 'B173D', '1906-05-20', '1923-09-27', 934),
('BOR214D', 'M17D', 'B35D', '2009-10-12', '1963-04-20', 931),
('BOR215D', 'M18D', 'B192D', '1968-01-02', '1953-08-05', 77),
('BOR216D', 'M23D', 'B183D', '1989-10-24', '1938-09-28', 612),
('BOR217D', 'M9D', 'B32D', '1910-08-04', '1933-06-22', 978),
('BOR218D', 'M24D', 'B79D', '2007-06-25', '1930-06-07', 246),
('BOR219D', 'M12D', 'B67D', '2008-05-04', '2011-02-09', 451),
('BOR21D', 'M9D', 'B22D', '1985-02-08', '1949-07-03', 334),
('BOR220D', 'M14D', 'B143D', '1947-09-19', '1985-11-26', 588),
('BOR221D', 'M4D', 'B54D', '1917-05-13', '1907-10-08', 731),
('BOR222D', 'M6D', 'B103D', '1947-10-14', '1913-02-15', 654),
('BOR223D', 'M2D', 'B45D', '2016-08-26', '1968-01-18', 283),
('BOR224D', 'M22D', 'B117D', '1998-09-20', '1966-02-13', 96),
('BOR225D', 'M7D', 'B173D', '1981-10-13', '1938-02-18', 909),
('BOR226D', 'M2D', 'B98D', '1928-03-27', '1950-01-18', 743),
('BOR227D', 'M12D', 'B114D', '2015-03-04', '1993-08-13', 91),
('BOR228D', 'M17D', 'B173D', '1984-04-09', '2016-05-13', 472),
('BOR229D', 'M18D', 'B59D', '1914-01-15', '1951-07-05', 231),
('BOR22D', 'M16D', 'B62D', '1961-08-19', '1940-01-20', 968),
('BOR230D', 'M21D', 'B17D', '2014-07-28', '1924-06-08', 790),
('BOR231D', 'M2D', 'B190D', '1937-06-21', '1988-09-19', 390),
('BOR232D', 'M17D', 'B5D', '1945-04-20', '1999-02-18', 521),
('BOR233D', 'M18D', 'B28D', '2005-05-23', '1959-05-07', 87),
('BOR234D', 'M21D', 'B96D', '1973-09-25', '1984-03-12', 234),
('BOR235D', 'M21D', 'B171D', '1902-09-04', '2000-09-10', 684),
('BOR236D', 'M20D', 'B45D', '1909-03-17', '1919-06-26', 678),
('BOR237D', 'M3D', 'B140D', '1966-07-22', '1935-02-02', 497),
('BOR238D', 'M7D', 'B60D', '1951-04-05', '1983-11-10', 77),
('BOR239D', 'M8D', 'B41D', '1976-02-23', '1915-08-06', 222),
('BOR23D', 'M19D', 'B167D', '1914-09-28', '1922-03-07', 9),
('BOR240D', 'M18D', 'B115D', '1933-10-26', '1928-03-03', 274),
('BOR241D', 'M0D', 'B147D', '1931-03-18', '2013-06-26', 62),
('BOR242D', 'M8D', 'B177D', '1951-06-18', '1979-11-23', 66),
('BOR243D', 'M18D', 'B14D', '1907-08-15', '1984-09-06', 513),
('BOR244D', 'M17D', 'B111D', '1942-09-19', '1929-02-08', 752),
('BOR245D', 'M1D', 'B73D', '1966-08-10', '1998-11-07', 365),
('BOR246D', 'M8D', 'B18D', '1953-07-12', '1900-05-05', 544),
('BOR247D', 'M11D', 'B25D', '1921-08-18', '1913-10-26', 886),
('BOR248D', 'M15D', 'B25D', '1911-01-18', '1931-08-05', 894),
('BOR249D', 'M22D', 'B46D', '2008-11-03', '1951-09-06', 393),
('BOR24D', 'M2D', 'B197D', '1940-04-17', '1989-03-10', 28),
('BOR250D', 'M24D', 'B74D', '1957-08-16', '1974-09-07', 398),
('BOR251D', 'M12D', 'B5D', '2008-06-08', '1911-09-06', 470),
('BOR252D', 'M17D', 'B188D', '1944-08-08', '1980-03-12', 241),
('BOR253D', 'M0D', 'B101D', '1962-04-09', '1971-10-20', 867),
('BOR254D', 'M23D', 'B10D', '2008-01-09', '1989-05-18', 622),
('BOR255D', 'M3D', 'B85D', '1918-06-08', '1982-01-18', 844),
('BOR256D', 'M18D', 'B162D', '1914-02-18', '1984-02-15', 167),
('BOR257D', 'M24D', 'B89D', '2004-09-03', '2011-10-10', 11),
('BOR258D', 'M1D', 'B6D', '1979-02-27', '1984-04-11', 598),
('BOR259D', 'M4D', 'B125D', '1933-11-15', '2007-04-06', 244),
('BOR25D', 'M18D', 'B43D', '1997-11-26', '2002-11-15', 773),
('BOR260D', 'M10D', 'B104D', '2016-05-18', '1951-11-09', 279),
('BOR261D', 'M24D', 'B159D', '1949-10-23', '1987-06-12', 222),
('BOR262D', 'M22D', 'B112D', '1906-09-25', '1953-03-13', 374),
('BOR263D', 'M19D', 'B114D', '1962-11-11', '1944-08-26', 661),
('BOR264D', 'M3D', 'B103D', '1941-09-05', '1997-08-08', 118),
('BOR265D', 'M22D', 'B73D', '2007-03-08', '1966-04-06', 278),
('BOR266D', 'M16D', 'B39D', '1944-03-19', '2003-07-12', 857),
('BOR267D', 'M18D', 'B131D', '1920-03-18', '1974-04-26', 358),
('BOR268D', 'M5D', 'B110D', '1994-03-23', '2002-08-27', 442),
('BOR269D', 'M8D', 'B7D', '1999-08-20', '1992-01-27', 206),
('BOR26D', 'M1D', 'B160D', '1958-02-07', '1902-02-22', 941),
('BOR270D', 'M20D', 'B180D', '1961-09-25', '2002-10-09', 78),
('BOR271D', 'M15D', 'B177D', '1992-07-16', '1912-08-09', 341),
('BOR272D', 'M21D', 'B9D', '2010-01-10', '1925-05-21', 717),
('BOR273D', 'M0D', 'B101D', '1995-05-05', '1976-05-20', 705),
('BOR274D', 'M10D', 'B146D', '2010-10-20', '1981-09-09', 378),
('BOR275D', 'M12D', 'B54D', '1986-02-06', '1960-06-20', 89),
('BOR276D', 'M22D', 'B0D', '1951-07-09', '1901-02-10', 822),
('BOR277D', 'M18D', 'B133D', '1910-03-20', '1950-11-18', 23),
('BOR278D', 'M5D', 'B162D', '1961-07-12', '1982-11-19', 682),
('BOR279D', 'M1D', 'B91D', '1937-09-05', '2011-06-25', 400),
('BOR27D', 'M15D', 'B19D', '1939-09-18', '1968-07-22', 32),
('BOR280D', 'M7D', 'B13D', '1908-04-24', '1970-04-14', 369),
('BOR281D', 'M15D', 'B151D', '2015-08-23', '1959-02-06', 559),
('BOR282D', 'M10D', 'B72D', '1952-01-03', '1993-03-10', 778),
('BOR283D', 'M3D', 'B126D', '1934-06-11', '1944-01-16', 550),
('BOR284D', 'M1D', 'B196D', '1908-04-08', '1949-07-09', 508),
('BOR285D', 'M18D', 'B97D', '1910-06-06', '1964-05-09', 13),
('BOR286D', 'M4D', 'B4D', '1994-04-25', '1992-03-04', 877),
('BOR287D', 'M13D', 'B14D', '1911-01-20', '1933-06-22', 92),
('BOR288D', 'M24D', 'B71D', '1959-03-08', '1923-11-23', 501),
('BOR289D', 'M18D', 'B197D', '2006-07-23', '1909-02-26', 826),
('BOR28D', 'M14D', 'B58D', '1975-04-04', '1987-05-26', 980),
('BOR290D', 'M19D', 'B39D', '1994-08-19', '1904-04-27', 585),
('BOR291D', 'M2D', 'B139D', '1947-01-22', '1916-11-17', 482),
('BOR292D', 'M3D', 'B167D', '2007-09-07', '1963-04-14', 923),
('BOR293D', 'M12D', 'B196D', '2008-01-23', '1907-08-26', 803),
('BOR294D', 'M14D', 'B47D', '1911-10-20', '2004-01-23', 796),
('BOR295D', 'M11D', 'B0D', '1962-10-15', '1900-07-02', 460),
('BOR296D', 'M22D', 'B48D', '1999-10-11', '1941-09-10', 810),
('BOR297D', 'M7D', 'B126D', '1962-11-19', '1962-11-01', 253),
('BOR298D', 'M9D', 'B78D', '1975-05-27', '2015-04-03', 953),
('BOR299D', 'M19D', 'B181D', '2009-02-25', '1943-09-13', 525),
('BOR29D', 'M6D', 'B149D', '2018-10-23', '1914-04-19', 548),
('BOR2D', 'M23D', 'B34D', '1922-05-12', '2012-04-20', 188),
('BOR300D', 'M1D', 'B95D', '1969-08-10', '1948-02-05', 691),
('BOR301D', 'M23D', 'B118D', '1924-07-16', '1970-03-26', 734),
('BOR302D', 'M23D', 'B135D', '1935-03-11', '2003-03-07', 585),
('BOR303D', 'M14D', 'B37D', '2004-05-14', '1997-06-01', 99),
('BOR304D', 'M19D', 'B169D', '1962-11-28', '2001-06-08', 998),
('BOR305D', 'M18D', 'B131D', '1905-07-03', '1958-03-17', 446),
('BOR306D', 'M6D', 'B146D', '1985-06-06', '1903-05-13', 970),
('BOR307D', 'M5D', 'B191D', '1963-01-14', '1945-10-22', 24),
('BOR308D', 'M15D', 'B40D', '2001-08-14', '1915-11-20', 999),
('BOR309D', 'M23D', 'B20D', '1996-04-02', '2018-03-12', 683),
('BOR30D', 'M4D', 'B94D', '1914-03-23', '1987-02-21', 615),
('BOR310D', 'M23D', 'B159D', '1955-11-20', '2001-02-26', 365),
('BOR311D', 'M10D', 'B84D', '1974-09-20', '1971-07-18', 808),
('BOR312D', 'M2D', 'B133D', '1923-03-22', '2001-11-22', 47),
('BOR313D', 'M19D', 'B154D', '1942-01-18', '1958-02-09', 241),
('BOR314D', 'M6D', 'B171D', '1998-06-09', '1972-03-22', 204),
('BOR315D', 'M21D', 'B67D', '1944-10-22', '1997-04-17', 634),
('BOR316D', 'M19D', 'B146D', '2015-04-28', '1925-02-06', 620),
('BOR317D', 'M17D', 'B190D', '1940-09-07', '1924-04-23', 607),
('BOR318D', 'M13D', 'B49D', '1952-11-16', '1943-01-11', 325),
('BOR319D', 'M12D', 'B79D', '1951-05-15', '1976-04-24', 538),
('BOR31D', 'M16D', 'B79D', '1962-09-02', '1997-07-19', 947),
('BOR320D', 'M24D', 'B18D', '1970-05-13', '1951-11-13', 361),
('BOR321D', 'M18D', 'B86D', '1914-09-16', '1996-04-11', 828),
('BOR322D', 'M0D', 'B20D', '1921-02-08', '1906-08-06', 344),
('BOR323D', 'M9D', 'B146D', '1951-11-27', '1972-03-16', 267),
('BOR324D', 'M21D', 'B83D', '1953-01-11', '2017-11-12', 63),
('BOR325D', 'M20D', 'B143D', '1962-04-09', '2006-09-08', 421),
('BOR326D', 'M12D', 'B3D', '1982-05-06', '2014-01-22', 951),
('BOR327D', 'M21D', 'B179D', '2000-04-12', '2018-02-25', 294),
('BOR328D', 'M5D', 'B142D', '1954-08-15', '1929-10-20', 338),
('BOR329D', 'M2D', 'B109D', '1962-03-28', '1988-09-08', 344),
('BOR32D', 'M13D', 'B83D', '1940-08-26', '1912-01-13', 393),
('BOR330D', 'M13D', 'B161D', '1912-06-01', '2010-02-13', 88),
('BOR331D', 'M3D', 'B108D', '2017-06-16', '1990-10-15', 176),
('BOR332D', 'M11D', 'B94D', '1958-10-14', '1970-09-20', 522),
('BOR333D', 'M15D', 'B22D', '1968-02-11', '1901-10-09', 51),
('BOR334D', 'M8D', 'B50D', '1978-10-02', '1983-10-16', 656),
('BOR335D', 'M21D', 'B101D', '1992-02-16', '1939-03-07', 900),
('BOR336D', 'M24D', 'B153D', '2017-06-27', '1990-04-01', 189),
('BOR337D', 'M5D', 'B77D', '1998-02-01', '1914-05-16', 905),
('BOR338D', 'M1D', 'B55D', '1925-07-06', '1941-11-09', 638),
('BOR339D', 'M9D', 'B157D', '1945-11-27', '1959-05-05', 196),
('BOR33D', 'M4D', 'B17D', '1956-01-01', '2009-10-24', 582),
('BOR340D', 'M18D', 'B120D', '2006-11-09', '1920-10-14', 576),
('BOR341D', 'M3D', 'B132D', '2011-03-16', '1917-01-19', 755),
('BOR342D', 'M2D', 'B147D', '1978-03-24', '1929-09-27', 303),
('BOR343D', 'M8D', 'B173D', '1954-04-03', '1906-01-06', 788),
('BOR344D', 'M4D', 'B175D', '1980-03-14', '2014-04-12', 61),
('BOR345D', 'M1D', 'B118D', '1948-09-19', '1950-03-05', 315),
('BOR346D', 'M11D', 'B197D', '1975-07-09', '1926-02-10', 436),
('BOR347D', 'M19D', 'B109D', '1979-10-18', '1971-08-09', 436),
('BOR348D', 'M10D', 'B58D', '1956-01-28', '1948-06-17', 830),
('BOR349D', 'M20D', 'B105D', '1903-02-10', '1925-01-08', 79),
('BOR34D', 'M17D', 'B144D', '1909-10-15', '1985-03-10', 391),
('BOR350D', 'M20D', 'B91D', '1930-05-26', '1987-11-11', 380),
('BOR351D', 'M9D', 'B162D', '1933-04-04', '1966-08-10', 227),
('BOR352D', 'M17D', 'B30D', '2002-08-12', '1978-02-13', 806),
('BOR353D', 'M5D', 'B199D', '1908-09-16', '2012-01-10', 904),
('BOR354D', 'M20D', 'B37D', '1991-05-12', '1959-01-15', 32),
('BOR355D', 'M18D', 'B165D', '1910-11-03', '2004-07-12', 956),
('BOR356D', 'M4D', 'B60D', '1924-09-24', '1947-08-08', 933),
('BOR357D', 'M11D', 'B136D', '1905-11-07', '1910-06-06', 20),
('BOR358D', 'M22D', 'B16D', '1960-05-14', '1975-03-02', 831),
('BOR359D', 'M0D', 'B96D', '2002-10-18', '2005-11-02', 646),
('BOR35D', 'M21D', 'B56D', '2003-10-09', '1906-07-07', 482),
('BOR360D', 'M8D', 'B155D', '1910-03-16', '1980-07-22', 925),
('BOR361D', 'M22D', 'B173D', '1958-11-03', '1993-04-19', 234),
('BOR362D', 'M6D', 'B152D', '1986-01-19', '2018-04-15', 192),
('BOR363D', 'M14D', 'B139D', '1939-01-26', '1936-03-04', 206),
('BOR364D', 'M15D', 'B81D', '1969-06-12', '1968-02-05', 669),
('BOR365D', 'M17D', 'B96D', '1991-05-08', '2011-08-04', 258),
('BOR366D', 'M2D', 'B127D', '1966-04-03', '1910-05-17', 798),
('BOR367D', 'M9D', 'B191D', '1924-03-06', '1917-07-26', 955),
('BOR368D', 'M19D', 'B3D', '1919-09-17', '1967-10-27', 543),
('BOR369D', 'M13D', 'B15D', '1940-04-28', '1979-10-13', 640),
('BOR36D', 'M23D', 'B184D', '1949-06-17', '1912-03-02', 271),
('BOR370D', 'M12D', 'B97D', '1960-03-10', '1934-07-01', 646),
('BOR371D', 'M12D', 'B130D', '1915-04-15', '1926-01-06', 285),
('BOR372D', 'M9D', 'B179D', '1901-10-01', '1924-02-03', 68),
('BOR373D', 'M14D', 'B113D', '2018-01-08', '1970-02-02', 562),
('BOR374D', 'M14D', 'B111D', '1968-07-22', '1973-04-13', 770),
('BOR375D', 'M15D', 'B32D', '1985-06-15', '1954-01-07', 43),
('BOR376D', 'M18D', 'B81D', '1977-01-16', '1987-06-02', 445),
('BOR377D', 'M2D', 'B146D', '1945-10-10', '2002-04-20', 821),
('BOR378D', 'M19D', 'B179D', '1952-11-09', '1983-09-23', 84),
('BOR379D', 'M16D', 'B41D', '1963-02-15', '1954-01-24', 269),
('BOR37D', 'M22D', 'B179D', '1986-03-06', '2007-07-24', 435),
('BOR380D', 'M11D', 'B120D', '1919-02-06', '1969-09-22', 714),
('BOR381D', 'M20D', 'B181D', '1909-08-17', '1915-09-25', 693),
('BOR382D', 'M20D', 'B192D', '1995-01-22', '1922-05-22', 906),
('BOR383D', 'M19D', 'B190D', '1975-04-05', '1933-03-02', 842),
('BOR384D', 'M3D', 'B169D', '2009-02-16', '2014-10-27', 522),
('BOR385D', 'M10D', 'B177D', '1959-10-09', '1976-08-12', 970),
('BOR386D', 'M9D', 'B163D', '1956-08-16', '1957-03-16', 299),
('BOR387D', 'M23D', 'B101D', '2014-10-10', '1959-05-13', 182),
('BOR388D', 'M3D', 'B124D', '1977-09-02', '1903-08-16', 701),
('BOR389D', 'M18D', 'B96D', '1979-11-12', '1952-07-17', 431),
('BOR38D', 'M22D', 'B125D', '1975-05-21', '1956-07-15', 226),
('BOR390D', 'M10D', 'B90D', '1947-11-04', '2003-03-28', 527),
('BOR391D', 'M7D', 'B172D', '1997-10-17', '1957-03-27', 637),
('BOR392D', 'M18D', 'B95D', '1925-10-16', '1988-03-07', 165),
('BOR393D', 'M18D', 'B146D', '1966-08-05', '1917-08-15', 149),
('BOR394D', 'M24D', 'B159D', '1948-02-21', '1969-09-13', 594),
('BOR395D', 'M23D', 'B91D', '2011-08-10', '2009-10-08', 363),
('BOR396D', 'M14D', 'B58D', '1941-11-05', '1929-03-21', 934),
('BOR397D', 'M4D', 'B84D', '1970-09-02', '1965-08-28', 552),
('BOR398D', 'M8D', 'B117D', '1932-02-19', '1979-02-19', 30),
('BOR399D', 'M21D', 'B151D', '1940-09-06', '1939-09-17', 508),
('BOR39D', 'M5D', 'B161D', '2003-05-23', '1930-03-23', 235),
('BOR3D', 'M9D', 'B50D', '1905-09-05', '1916-02-19', 969),
('BOR400D', 'M20D', 'B78D', '1936-10-07', '1912-02-05', 447),
('BOR401D', 'M15D', 'B80D', '1965-02-22', '1962-01-09', 897),
('BOR402D', 'M11D', 'B180D', '1912-06-04', '1998-10-18', 833),
('BOR403D', 'M18D', 'B38D', '2013-09-24', '1986-06-17', 287),
('BOR404D', 'M14D', 'B132D', '1940-05-02', '1985-01-19', 699),
('BOR405D', 'M13D', 'B118D', '1957-05-01', '2016-01-26', 861),
('BOR406D', 'M8D', 'B180D', '1912-10-03', '1944-10-11', 734),
('BOR407D', 'M6D', 'B87D', '1905-03-05', '1939-11-22', 93),
('BOR408D', 'M19D', 'B6D', '1975-04-17', '1966-03-09', 139),
('BOR409D', 'M21D', 'B22D', '1937-01-05', '1984-09-24', 275),
('BOR40D', 'M17D', 'B27D', '1959-08-14', '1944-05-13', 725),
('BOR410D', 'M21D', 'B167D', '1927-04-07', '1910-08-26', 764),
('BOR411D', 'M13D', 'B186D', '1906-10-22', '1950-05-09', 112),
('BOR412D', 'M0D', 'B14D', '1937-06-05', '1911-10-27', 713),
('BOR413D', 'M5D', 'B123D', '1987-11-18', '1933-05-28', 628),
('BOR414D', 'M5D', 'B84D', '1923-07-20', '1938-05-01', 406),
('BOR415D', 'M5D', 'B162D', '1906-10-18', '1992-01-20', 57),
('BOR416D', 'M1D', 'B29D', '1906-01-02', '1961-05-14', 897),
('BOR417D', 'M19D', 'B145D', '2008-06-26', '1933-09-23', 846),
('BOR418D', 'M16D', 'B87D', '1918-06-05', '1902-04-28', 505),
('BOR419D', 'M7D', 'B19D', '2013-02-21', '1993-08-21', 492),
('BOR41D', 'M2D', 'B169D', '1930-01-18', '1920-08-20', 945),
('BOR420D', 'M6D', 'B29D', '1985-07-11', '2007-02-17', 80),
('BOR421D', 'M13D', 'B102D', '1979-07-28', '1979-02-17', 31),
('BOR422D', 'M0D', 'B78D', '2010-08-21', '1958-10-10', 478),
('BOR423D', 'M1D', 'B41D', '1906-10-17', '1917-11-02', 945),
('BOR424D', 'M10D', 'B93D', '1966-04-20', '1943-10-07', 165),
('BOR425D', 'M20D', 'B100D', '1952-06-22', '1923-10-14', 280),
('BOR426D', 'M5D', 'B183D', '1900-07-10', '1947-04-06', 300),
('BOR427D', 'M20D', 'B190D', '1994-01-22', '1988-05-23', 437),
('BOR428D', 'M14D', 'B64D', '1932-06-04', '2005-03-14', 851),
('BOR429D', 'M24D', 'B116D', '1910-11-21', '1940-11-09', 432),
('BOR42D', 'M19D', 'B114D', '1945-02-28', '1945-07-09', 37),
('BOR430D', 'M21D', 'B110D', '2009-04-12', '1946-03-04', 198),
('BOR431D', 'M6D', 'B55D', '1974-05-15', '2000-01-06', 312),
('BOR432D', 'M12D', 'B38D', '1979-03-27', '1994-09-07', 626),
('BOR433D', 'M22D', 'B132D', '1980-07-07', '1943-10-05', 595),
('BOR434D', 'M11D', 'B23D', '2018-01-14', '2014-05-02', 947),
('BOR435D', 'M5D', 'B21D', '2008-01-02', '2013-09-09', 269),
('BOR436D', 'M18D', 'B102D', '1942-06-19', '1999-06-01', 135),
('BOR437D', 'M6D', 'B130D', '1985-02-19', '2003-01-17', 618),
('BOR438D', 'M6D', 'B5D', '1918-06-22', '1963-03-22', 231),
('BOR439D', 'M14D', 'B94D', '1912-10-11', '2018-09-06', 313),
('BOR43D', 'M5D', 'B135D', '1927-01-09', '1920-08-04', 380),
('BOR440D', 'M15D', 'B118D', '1928-01-10', '1941-05-01', 266),
('BOR441D', 'M12D', 'B170D', '1916-01-20', '1940-07-06', 217),
('BOR442D', 'M11D', 'B87D', '1962-02-06', '1967-07-11', 507),
('BOR443D', 'M1D', 'B7D', '1927-07-16', '1992-11-17', 932),
('BOR444D', 'M16D', 'B159D', '1972-09-17', '1998-01-16', 939),
('BOR445D', 'M17D', 'B142D', '1900-05-15', '2001-01-15', 321),
('BOR446D', 'M4D', 'B197D', '1989-03-19', '1965-11-18', 458),
('BOR447D', 'M24D', 'B145D', '1974-11-19', '1921-02-01', 137),
('BOR448D', 'M17D', 'B4D', '2016-06-01', '1917-06-26', 357),
('BOR449D', 'M20D', 'B4D', '1929-02-21', '1974-08-08', 366),
('BOR44D', 'M6D', 'B16D', '1941-04-02', '1970-10-03', 598),
('BOR450D', 'M8D', 'B133D', '1991-11-16', '2001-01-24', 189),
('BOR451D', 'M8D', 'B88D', '1900-11-01', '1995-07-05', 225),
('BOR452D', 'M7D', 'B11D', '1979-08-22', '1909-05-17', 187),
('BOR453D', 'M7D', 'B115D', '1948-11-13', '1962-01-03', 634),
('BOR454D', 'M23D', 'B135D', '1907-11-18', '1930-05-08', 972),
('BOR455D', 'M10D', 'B142D', '1958-10-22', '1937-06-12', 966),
('BOR456D', 'M11D', 'B139D', '2006-08-10', '1934-02-11', 937),
('BOR457D', 'M24D', 'B65D', '1978-06-25', '1942-06-16', 469),
('BOR458D', 'M0D', 'B180D', '1966-03-24', '1989-03-02', 529),
('BOR459D', 'M6D', 'B13D', '1926-03-27', '1927-06-18', 714),
('BOR45D', 'M5D', 'B113D', '1914-07-09', '1922-01-16', 789),
('BOR460D', 'M2D', 'B67D', '1990-05-19', '2013-01-22', 617),
('BOR461D', 'M5D', 'B59D', '1916-11-14', '1933-03-26', 166),
('BOR462D', 'M10D', 'B103D', '1925-05-08', '1912-07-04', 534),
('BOR463D', 'M4D', 'B75D', '1998-02-20', '1923-02-09', 360),
('BOR464D', 'M8D', 'B136D', '1953-04-25', '1935-08-01', 597),
('BOR465D', 'M3D', 'B2D', '1910-06-04', '1943-09-08', 577),
('BOR466D', 'M20D', 'B27D', '2013-11-17', '1978-06-16', 249),
('BOR467D', 'M6D', 'B56D', '1996-05-21', '1982-11-18', 377),
('BOR468D', 'M18D', 'B2D', '1998-02-12', '1983-10-18', 473),
('BOR469D', 'M4D', 'B60D', '2008-02-16', '1908-06-25', 37),
('BOR46D', 'M5D', 'B156D', '1959-06-24', '1945-05-02', 505),
('BOR470D', 'M18D', 'B150D', '1954-07-28', '2009-03-26', 992),
('BOR471D', 'M4D', 'B113D', '1929-11-22', '1929-08-14', 228),
('BOR472D', 'M1D', 'B84D', '1920-08-27', '1993-08-14', 639),
('BOR473D', 'M8D', 'B118D', '1914-10-27', '2000-08-10', 20),
('BOR474D', 'M7D', 'B177D', '1990-09-15', '2018-01-15', 415),
('BOR475D', 'M15D', 'B85D', '1937-03-12', '1927-08-23', 255),
('BOR476D', 'M8D', 'B89D', '1923-02-27', '1915-10-01', 214),
('BOR477D', 'M22D', 'B152D', '1935-06-27', '1927-08-18', 49),
('BOR478D', 'M1D', 'B171D', '2001-02-24', '2006-11-01', 406),
('BOR479D', 'M20D', 'B176D', '1913-04-08', '1966-02-26', 795),
('BOR47D', 'M19D', 'B171D', '2018-05-13', '2016-02-07', 862),
('BOR480D', 'M24D', 'B102D', '2007-07-20', '1910-03-27', 937),
('BOR481D', 'M15D', 'B125D', '1997-10-04', '1918-07-04', 753),
('BOR482D', 'M0D', 'B199D', '1993-08-24', '1951-11-25', 790),
('BOR483D', 'M3D', 'B46D', '1903-08-19', '1978-06-17', 652),
('BOR484D', 'M24D', 'B75D', '1908-08-15', '1927-03-24', 656),
('BOR485D', 'M19D', 'B73D', '1964-10-15', '1928-09-09', 646),
('BOR486D', 'M10D', 'B46D', '1910-11-21', '1921-06-12', 899),
('BOR487D', 'M16D', 'B18D', '1946-09-18', '1942-08-22', 235),
('BOR488D', 'M12D', 'B46D', '1917-06-13', '1957-10-09', 43),
('BOR489D', 'M24D', 'B143D', '1912-10-09', '1965-05-02', 135),
('BOR48D', 'M8D', 'B187D', '1948-07-10', '1916-09-13', 809),
('BOR490D', 'M24D', 'B164D', '1991-05-21', '1922-10-25', 493),
('BOR491D', 'M20D', 'B22D', '1944-10-08', '1956-02-24', 669),
('BOR492D', 'M6D', 'B58D', '1928-03-03', '1932-03-27', 258),
('BOR493D', 'M20D', 'B180D', '1919-08-27', '1938-01-22', 501),
('BOR494D', 'M9D', 'B148D', '1959-09-16', '1956-04-08', 476),
('BOR495D', 'M19D', 'B50D', '1937-06-25', '1932-02-11', 860),
('BOR496D', 'M6D', 'B195D', '2012-08-17', '1950-03-24', 373),
('BOR497D', 'M4D', 'B117D', '1940-03-28', '1988-01-01', 99),
('BOR498D', 'M24D', 'B3D', '1910-05-01', '2015-09-02', 348),
('BOR499D', 'M11D', 'B148D', '1928-03-04', '2016-09-21', 102),
('BOR49D', 'M20D', 'B39D', '1930-09-18', '1931-11-13', 477),
('BOR4D', 'M24D', 'B124D', '2009-02-05', '1942-09-03', 890),
('BOR50D', 'M9D', 'B171D', '2002-07-13', '1966-11-02', 84),
('BOR51D', 'M7D', 'B143D', '1971-03-26', '1981-03-03', 150),
('BOR52D', 'M22D', 'B112D', '1910-05-17', '1944-07-19', 502),
('BOR53D', 'M1D', 'B169D', '1947-05-06', '1929-02-20', 583),
('BOR54D', 'M6D', 'B126D', '1900-04-23', '1977-11-25', 541),
('BOR55D', 'M0D', 'B111D', '1988-04-16', '1910-04-27', 411),
('BOR56D', 'M13D', 'B174D', '1932-06-04', '1999-07-07', 720),
('BOR57D', 'M11D', 'B25D', '2009-11-25', '1952-06-10', 588),
('BOR58D', 'M15D', 'B64D', '1937-04-03', '1976-06-16', 439),
('BOR59D', 'M0D', 'B155D', '1987-06-19', '2005-05-25', 562),
('BOR5D', 'M5D', 'B90D', '2003-11-26', '1975-05-13', 1),
('BOR60D', 'M12D', 'B92D', '1991-10-21', '1923-08-10', 37),
('BOR61D', 'M19D', 'B40D', '1988-05-07', '1929-02-27', 567),
('BOR62D', 'M12D', 'B199D', '1964-02-12', '1925-09-02', 489),
('BOR63D', 'M24D', 'B22D', '2002-08-03', '1970-06-25', 21),
('BOR64D', 'M10D', 'B134D', '1996-03-09', '2010-05-16', 271),
('BOR65D', 'M13D', 'B180D', '2012-05-17', '1979-03-11', 83),
('BOR66D', 'M10D', 'B188D', '2001-02-23', '1949-06-05', 881),
('BOR67D', 'M1D', 'B103D', '1979-05-08', '1964-11-09', 134),
('BOR68D', 'M6D', 'B185D', '1962-08-02', '2012-09-28', 173),
('BOR69D', 'M7D', 'B123D', '2006-10-21', '1915-08-18', 58),
('BOR6D', 'M0D', 'B194D', '1903-09-25', '2015-06-03', 884),
('BOR70D', 'M17D', 'B88D', '1905-05-07', '1948-04-26', 273),
('BOR71D', 'M10D', 'B125D', '1939-07-08', '1968-07-26', 174),
('BOR72D', 'M17D', 'B50D', '2004-10-18', '1917-06-09', 774),
('BOR73D', 'M10D', 'B117D', '1980-02-02', '2016-08-11', 111),
('BOR74D', 'M1D', 'B189D', '1907-05-04', '2009-05-24', 354),
('BOR75D', 'M15D', 'B192D', '1941-08-14', '1957-01-23', 537),
('BOR76D', 'M21D', 'B81D', '1980-04-28', '1967-09-26', 861),
('BOR77D', 'M10D', 'B123D', '1981-05-16', '1918-08-27', 792),
('BOR78D', 'M21D', 'B73D', '1989-02-26', '1949-05-03', 553),
('BOR79D', 'M12D', 'B119D', '1969-01-27', '2000-08-20', 228),
('BOR7D', 'M11D', 'B154D', '1981-04-19', '1992-03-10', 214),
('BOR80D', 'M17D', 'B79D', '1966-04-08', '1912-02-10', 916),
('BOR81D', 'M7D', 'B107D', '1937-08-24', '2009-01-18', 441),
('BOR82D', 'M5D', 'B142D', '1970-11-21', '1916-01-27', 736),
('BOR83D', 'M16D', 'B136D', '1948-10-24', '1949-02-14', 40),
('BOR84D', 'M8D', 'B174D', '1927-01-10', '1918-02-06', 736),
('BOR85D', 'M18D', 'B122D', '1991-03-28', '1917-02-25', 917),
('BOR86D', 'M2D', 'B179D', '1950-03-09', '1922-05-19', 467),
('BOR87D', 'M16D', 'B78D', '1995-01-14', '1978-04-14', 844),
('BOR88D', 'M10D', 'B56D', '1971-01-01', '1937-09-19', 823),
('BOR89D', 'M16D', 'B132D', '1941-02-02', '1967-08-28', 263),
('BOR8D', 'M2D', 'B169D', '1986-06-18', '1974-05-03', 634),
('BOR90D', 'M0D', 'B125D', '1969-08-10', '1957-08-26', 741),
('BOR91D', 'M12D', 'B81D', '1993-04-01', '1998-01-09', 278),
('BOR92D', 'M8D', 'B155D', '1989-01-16', '1920-04-07', 627),
('BOR93D', 'M9D', 'B167D', '1933-08-18', '1901-06-01', 488),
('BOR94D', 'M13D', 'B35D', '2006-03-13', '1902-06-23', 898),
('BOR95D', 'M21D', 'B22D', '1927-04-16', '1956-02-15', 726),
('BOR96D', 'M7D', 'B154D', '1934-08-28', '1981-11-15', 631),
('BOR97D', 'M20D', 'B37D', '1922-10-26', '1942-02-15', 20),
('BOR98D', 'M18D', 'B160D', '1972-06-06', '1927-04-16', 804),
('BOR99D', 'M16D', 'B106D', '2010-04-24', '2008-10-17', 876),
('BOR9D', 'M24D', 'B140D', '1923-03-27', '1944-07-25', 579);

-- --------------------------------------------------------

--
-- Stand-in structure for view `peminjaman_simple`
-- (See below for the actual view)
--
CREATE TABLE `peminjaman_simple` (
`id` varchar(20)
,`member` varchar(20)
,`buku` varchar(20)
,`tanggal_pinjam` date
,`tanggal_kembali` date
,`deadline` int(11)
,`judul_buku` varchar(50)
,`nama_member` varchar(30)
);

-- --------------------------------------------------------

--
-- Table structure for table `penerbit`
--

CREATE TABLE `penerbit` (
  `id` varchar(20) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `alamat` text NOT NULL,
  `no_telpon` varchar(20) NOT NULL,
  `negara` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penerbit`
--

INSERT INTO `penerbit` (`id`, `nama`, `alamat`, `no_telpon`, `negara`) VALUES
('PUB0D', 'Amet Ornare Lectus Associates', 'Ap #245-6234 Nullam Ave', '100590041', 'Pakistan'),
('PUB1D', 'Mauris Nulla Integer LLP', 'P.O. Box 705, 3621 Suspendisse Av.', '848207404', 'American Samoa'),
('PUB2D', 'Sit Amet Risus Associates', '8719 Ut Rd.', '933397061', 'American Samoa'),
('PUB3D', 'Ut Semper Institute', 'Ap #559-7222 Aliquam St.', '657565938', 'Tunisia'),
('PUB4D', 'Fringilla Est Mauris Associates', 'Ap #898-3713 Quis Rd.', '175107722', 'Argentina');

-- --------------------------------------------------------

--
-- Table structure for table `penulis`
--

CREATE TABLE `penulis` (
  `id` varchar(20) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `negara` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penulis`
--

INSERT INTO `penulis` (`id`, `nama`, `jenis_kelamin`, `negara`) VALUES
('AUT0D', 'Medina Castro', 'Male', 'Qatar'),
('AUT1D', 'Castro Cline', 'Female', 'Samoa'),
('AUT2D', 'West Jennings', 'Male', 'Saint Vincent and The Grenadines'),
('AUT3D', 'Tyler Roberts', 'Female', 'Guyana'),
('AUT4D', 'Webster Larson', 'Female', 'Switzerland'),
('AUT5D', 'Huber Witt', 'Female', 'Cambodia'),
('AUT6D', 'Harrell Castillo', 'Female', 'Malaysia'),
('AUT7D', 'Stone Melton', 'Male', 'Switzerland'),
('AUT8D', 'Dorsey Bean', 'Male', 'South Georgia and The South Sandwich Islands'),
('AUT9D', 'Stone Lyons', 'Male', 'Jamaica');

-- --------------------------------------------------------

--
-- Stand-in structure for view `total_buku_kategori`
-- (See below for the actual view)
--
CREATE TABLE `total_buku_kategori` (
`id` varchar(20)
,`total_buku` bigint(21)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `total_buku_member`
-- (See below for the actual view)
--
CREATE TABLE `total_buku_member` (
`id` varchar(20)
,`total_buku` bigint(21)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `total_buku_peminjaman`
-- (See below for the actual view)
--
CREATE TABLE `total_buku_peminjaman` (
`id` varchar(20)
,`total_peminjaman` bigint(21)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `total_buku_penerbit`
-- (See below for the actual view)
--
CREATE TABLE `total_buku_penerbit` (
`id` varchar(20)
,`total_buku` bigint(21)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `total_buku_penulis`
-- (See below for the actual view)
--
CREATE TABLE `total_buku_penulis` (
`id` varchar(20)
,`total_buku` bigint(21)
);

-- --------------------------------------------------------

--
-- Structure for view `buku_peminjaman_member`
--
DROP TABLE IF EXISTS `buku_peminjaman_member`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `buku_peminjaman_member`  AS  select `peminjaman`.`id` AS `id`,`peminjaman`.`member` AS `member`,`peminjaman`.`buku` AS `buku`,`peminjaman`.`tanggal_pinjam` AS `tanggal_pinjam`,`peminjaman`.`tanggal_kembali` AS `tanggal_kembali`,`peminjaman`.`deadline` AS `deadline`,`buku`.`judul` AS `judul_buku`,`member`.`nama` AS `nama_member` from ((`member` join `peminjaman` on(`peminjaman`.`member` = `member`.`id`)) join `buku` on(`buku`.`id` = `peminjaman`.`buku`)) ;

-- --------------------------------------------------------

--
-- Structure for view `buku_simple`
--
DROP TABLE IF EXISTS `buku_simple`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `buku_simple`  AS  select `buku`.`id` AS `id`,`buku`.`judul` AS `judul`,`buku`.`tahun_terbit` AS `tahun_terbit`,`buku`.`kategori` AS `kategori`,`buku`.`penulis` AS `penulis`,`buku`.`penerbit` AS `penerbit`,`buku`.`total_halaman` AS `total_halaman`,`penulis`.`nama` AS `nama_penulis`,`penerbit`.`nama` AS `nama_penerbit`,`kategori`.`nama` AS `nama_kategori` from (((`buku` join `penulis` on(`penulis`.`id` = `buku`.`penulis`)) join `penerbit` on(`penerbit`.`id` = `buku`.`penerbit`)) join `kategori` on(`kategori`.`id` = `buku`.`kategori`)) ;

-- --------------------------------------------------------

--
-- Structure for view `peminjaman_simple`
--
DROP TABLE IF EXISTS `peminjaman_simple`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `peminjaman_simple`  AS  select `peminjaman`.`id` AS `id`,`peminjaman`.`member` AS `member`,`peminjaman`.`buku` AS `buku`,`peminjaman`.`tanggal_pinjam` AS `tanggal_pinjam`,`peminjaman`.`tanggal_kembali` AS `tanggal_kembali`,`peminjaman`.`deadline` AS `deadline`,`buku`.`judul` AS `judul_buku`,`member`.`nama` AS `nama_member` from ((`peminjaman` join `buku` on(`buku`.`id` = `peminjaman`.`buku`)) join `member` on(`member`.`id` = `peminjaman`.`member`)) ;

-- --------------------------------------------------------

--
-- Structure for view `total_buku_kategori`
--
DROP TABLE IF EXISTS `total_buku_kategori`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `total_buku_kategori`  AS  select `kategori`.`id` AS `id`,count(`buku`.`id`) AS `total_buku` from (`kategori` join `buku` on(`buku`.`kategori` = `kategori`.`id`)) group by `kategori`.`id` ;

-- --------------------------------------------------------

--
-- Structure for view `total_buku_member`
--
DROP TABLE IF EXISTS `total_buku_member`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `total_buku_member`  AS  select `member`.`id` AS `id`,count(`buku`.`id`) AS `total_buku` from ((`member` join `peminjaman` on(`peminjaman`.`member` = `member`.`id`)) join `buku` on(`buku`.`id` = `peminjaman`.`buku`)) group by `member`.`id` ;

-- --------------------------------------------------------

--
-- Structure for view `total_buku_peminjaman`
--
DROP TABLE IF EXISTS `total_buku_peminjaman`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `total_buku_peminjaman`  AS  select `buku`.`id` AS `id`,count(`peminjaman`.`id`) AS `total_peminjaman` from (`buku` join `peminjaman` on(`peminjaman`.`buku` = `buku`.`id`)) group by `buku`.`id` ;

-- --------------------------------------------------------

--
-- Structure for view `total_buku_penerbit`
--
DROP TABLE IF EXISTS `total_buku_penerbit`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `total_buku_penerbit`  AS  select `penerbit`.`id` AS `id`,count(`buku`.`id`) AS `total_buku` from (`penerbit` join `buku` on(`penerbit`.`id` = `buku`.`penerbit`)) group by `penerbit`.`id` ;

-- --------------------------------------------------------

--
-- Structure for view `total_buku_penulis`
--
DROP TABLE IF EXISTS `total_buku_penulis`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `total_buku_penulis`  AS  select `penulis`.`id` AS `id`,count(`buku`.`id`) AS `total_buku` from (`penulis` join `buku` on(`buku`.`penulis` = `penulis`.`id`)) group by `penulis`.`id` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_bk` (`kategori`),
  ADD KEY `fk_bau` (`penulis`),
  ADD KEY `fk_bpub` (`penerbit`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_peminjaman_buku` (`buku`),
  ADD KEY `fk_peminjaman_member` (`member`);

--
-- Indexes for table `penerbit`
--
ALTER TABLE `penerbit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `penulis`
--
ALTER TABLE `penulis`
  ADD PRIMARY KEY (`id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buku`
--
ALTER TABLE `buku`
  ADD CONSTRAINT `fk_bau` FOREIGN KEY (`penulis`) REFERENCES `penulis` (`id`),
  ADD CONSTRAINT `fk_bk` FOREIGN KEY (`kategori`) REFERENCES `kategori` (`id`),
  ADD CONSTRAINT `fk_bpub` FOREIGN KEY (`penerbit`) REFERENCES `penerbit` (`id`);

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `fk_peminjaman_buku` FOREIGN KEY (`buku`) REFERENCES `buku` (`id`),
  ADD CONSTRAINT `fk_peminjaman_member` FOREIGN KEY (`member`) REFERENCES `member` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
