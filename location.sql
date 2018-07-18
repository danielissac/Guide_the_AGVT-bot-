-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 18, 2018 at 09:15 AM
-- Server version: 5.7.10-log
-- PHP Version: 5.5.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ych`
--

-- --------------------------------------------------------

--
-- Table structure for table `location_info`
--

CREATE TABLE `location_info` (
  `bin_location` varchar(30) NOT NULL,
  `unique_rfid` varchar(30) NOT NULL,
  `reference` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `location_info`
--

INSERT INTO `location_info` (`bin_location`, `unique_rfid`, `reference`) VALUES
('02A01', '070054F48E29', 1),
('02B01', '070054F48E29', 1),
('02C01', '070054F48E29', 1),
('02D01', '070054F48E29', 1),
('02E01', '070054F48E29', 1),
('03A01', '070054F48E29', 1),
('03B01', '070054F48E29', 1),
('03C01', '070054F48E29', 1),
('03D01', '070054F48E29', 1),
('03E01', '070054F48E29', 1),
('02A02', '070054C7F460', 2),
('02B02', '070054C7F460', 2),
('02C02', '070054C7F460', 2),
('02D02', '070054C7F460', 2),
('02E02', '070054C7F460', 2),
('03A02', '070054C7F460', 2),
('03B02', '070054C7F460', 2),
('03C02', '070054C7F460', 2),
('03D02', '070054C7F460', 2),
('03E02', '070054C7F460', 2),
('02A03', '0700550A87DF', 3),
('02B03', '0700550A87DF', 3),
('02C03', '0700550A87DF', 3),
('02D03', '0700550A87DF', 3),
('02E03', '0700550A87DF', 3),
('03A03', '0700550A87DF', 3),
('03B03', '0700550A87DF', 3),
('03C03', '0700550A87DF', 3),
('03D03', '0700550A87DF', 3),
('03E03', '0700550A87DF', 3),
('04A01', '070054BD48A6', 8),
('04B01', '070054BD48A6', 8),
('04C01', '070054BD48A6', 8),
('04D01', '070054BD48A6', 8),
('04E01', '070054BD48A6', 8),
('05A01', '070054BD48A6', 8),
('05B01', '070054BD48A6', 8),
('05C01', '070054BD48A6', 8),
('05D01', '070054BD48A6', 8),
('05E01', '070054BD48A6', 8),
('04A02', '0700550B5009', 7),
('04B02', '0700550B5009', 7),
('04C02', '0700550B5009', 7),
('04D02', '0700550B5009', 7),
('04E02', '0700550B5009', 7),
('05A02', '0700550B5009', 7),
('05B02', '0700550B5009', 7),
('05C02', '0700550B5009', 7),
('05D02', '0700550B5009', 7),
('05E02', '0700550B5009', 7),
('04A03', '0700550A8AD2', 6),
('04B03', '0700550A8AD2', 6),
('04C03', '0700550A8AD2', 6),
('04D03', '0700550A8AD2', 6),
('04E03', '0700550A8AD2', 6),
('05A03', '0700550A8AD2', 6),
('05B03', '0700550A8AD2', 6),
('05C03', '0700550A8AD2', 6),
('05D03', '0700550A8AD2', 6),
('05E03', '0700550A8AD2', 6),
('', '07005E723B10', 0),
('', '070055526D6D', 5),
('', '070055522F27', 9),
('', '070055527272', 4);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;