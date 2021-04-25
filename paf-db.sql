-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 24, 2021 at 08:15 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf-db`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `CID` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `details` varchar(100) DEFAULT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CID`, `name`, `details`, `date`) VALUES
('C_001', 'Gihan', 'Gihan C_001 ', '2021-04-24 22:53:27'),
('C_002', 'Nipuni', 'Nipuni C_002 ', '2021-04-24 22:53:27'),
('C_003', 'SevinduW', 'SevinduW C_003', '2021-04-24 22:53:27'),
('C_004', 'Shervin', 'Shervin C_004', '2021-04-24 22:53:27'),
('C_006', 'Eranga', 'Eranga C_006', '2021-04-25 01:26:13');

-- --------------------------------------------------------

--
-- Table structure for table `funder`
--

DROP TABLE IF EXISTS `funder`;
CREATE TABLE IF NOT EXISTS `funder` (
  `FID` varchar(100) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `amount` double DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funder`
--

INSERT INTO `funder` (`FID`, `name`, `amount`, `phone`, `email`, `date`) VALUES
('F001', 'Shervin', 75000, '0785554854', 'Shervin@yahoo.com', '2021-04-25 00:53:18'),
('F003', 'Yohan', 7800, '0112222587', 'Yohan@mail.com', '2021-04-24 22:55:14'),
('F004', 'Bandara', 7500, '0775558452', 'Bandara@gmail.com', '2021-04-24 22:55:14');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE IF NOT EXISTS `project` (
  `PID` varchar(100) DEFAULT NULL,
  `type` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `details` varchar(100) DEFAULT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`PID`, `type`, `name`, `details`, `date`) VALUES
('P001', 'Business', 'Banking automation', 'Banking automation-Business-P001', '2021-04-24 23:00:42'),
('P002', 'Banking', 'Banking Automator', 'Banking Automator-Banking-P002', '2021-04-24 23:00:42'),
('P003', 'Traveling', 'Transport', 'Transport-Traveling-P003', '2021-04-24 23:00:42'),
('P004', 'Health', 'Health care application', 'Health care application-Health-004', '2021-04-24 23:00:42'),
('F005', 'Science', 'Artificial robot', 'Artificial robot-Science-F001', '2021-04-25 01:04:18');

-- --------------------------------------------------------

--
-- Table structure for table `researcher`
--

DROP TABLE IF EXISTS `researcher`;
CREATE TABLE IF NOT EXISTS `researcher` (
  `RID` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `researcher`
--

INSERT INTO `researcher` (`RID`, `name`, `address`, `phone`, `email`, `date`) VALUES
('R002', 'Nadeeshani', 'Kandy', '0714444758', 'Nadeeshani@gmail.com', '2021-04-24 23:04:29'),
('R003', 'Jayasinghe', 'Galle', '0712222548', 'Jayasinghe@gmail.com', '2021-04-24 23:04:29'),
('R004', 'Bandara', 'Badulla', '0774417358', 'Bandara2@gmail.com', '2021-04-24 23:04:29'),
('R004', 'Gihan', 'Kaduwela', '0785554854', 'gihan@yahoo.com', '2021-04-25 00:00:33');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
