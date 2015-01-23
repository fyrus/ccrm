-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2015 at 06:19 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ccrm_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `campaignreactionreport`
--

DROP TABLE IF EXISTS `campaignreactionreport`;
CREATE TABLE IF NOT EXISTS `campaignreactionreport` (
`Mid` int(11) NOT NULL,
  `NumOfPotentialClients` int(11) NOT NULL,
  `TimeSpentOnCalls` float NOT NULL,
  `NumOfSellEvents` int(11) NOT NULL,
  `NonPurchaseComments` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `Cid` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `Cname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cbd` date DEFAULT '1900-01-01',
  `CLocation` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cphone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Cid`, `Cname`, `Cbd`, `CLocation`, `Cphone`) VALUES
('123', 'kaka', '2015-01-08', 'sham', '33333'),
('56876345', 'aa bb', '2015-01-04', '', '123'),
('678', '', '1970-01-11', '', ''),
('6788', '', '1970-01-01', '', ''),
('6788889', '', '2015-01-23', '', ''),
('67889', '', '1970-01-01', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `domain`
--

DROP TABLE IF EXISTS `domain`;
CREATE TABLE IF NOT EXISTS `domain` (
`Did` int(10) NOT NULL,
  `Dname` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=10 ;

--
-- Dumping data for table `domain`
--

INSERT INTO `domain` (`Did`, `Dname`) VALUES
(1, 'klei bait'),
(2, 'klei bait'),
(3, 'klei bait'),
(4, 'klei bait'),
(5, 'klei bait'),
(6, 'klei bait'),
(7, 'ss'),
(8, 'ssq'),
(9, 'qq');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
`Lid` int(11) NOT NULL,
  `Location` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`Lid`, `Location`) VALUES
(3, 'nazeret'),
(4, '123'),
(5, '234');

-- --------------------------------------------------------

--
-- Table structure for table `marketing_campaign`
--

DROP TABLE IF EXISTS `marketing_campaign`;
CREATE TABLE IF NOT EXISTS `marketing_campaign` (
`Cid` int(11) NOT NULL,
  `Startdate` date DEFAULT '1900-01-01',
  `Enddate` date DEFAULT '1900-01-01'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `marketing_campaign`
--

INSERT INTO `marketing_campaign` (`Cid`, `Startdate`, `Enddate`) VALUES
(1, '2015-01-06', '2015-01-31'),
(2, '2015-01-13', '2015-01-31');

-- --------------------------------------------------------

--
-- Table structure for table `marketing_customers`
--

DROP TABLE IF EXISTS `marketing_customers`;
CREATE TABLE IF NOT EXISTS `marketing_customers` (
  `Customerid` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `Campaignid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `marketing_customers`
--

INSERT INTO `marketing_customers` (`Customerid`, `Campaignid`) VALUES
('123', 1),
('678', 1),
('123', 2),
('678', 2);

-- --------------------------------------------------------

--
-- Table structure for table `marketing_patern`
--

DROP TABLE IF EXISTS `marketing_patern`;
CREATE TABLE IF NOT EXISTS `marketing_patern` (
`Patterid` int(11) NOT NULL,
  `Productid` int(11) DEFAULT NULL,
  `Segmentid` int(11) DEFAULT NULL,
  `Message` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `market_segment`
--

DROP TABLE IF EXISTS `market_segment`;
CREATE TABLE IF NOT EXISTS `market_segment` (
`Segmentid` int(11) NOT NULL,
  `Age` int(11) DEFAULT NULL,
  `Locationid` int(11) DEFAULT NULL,
  `Importance` int(11) DEFAULT NULL,
  `Interest` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
CREATE TABLE IF NOT EXISTS `permission` (
`Pid` int(11) NOT NULL,
  `Cid` int(11) DEFAULT NULL,
  `Did` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `permission`
--

INSERT INTO `permission` (`Pid`, `Cid`, `Did`) VALUES
(1, 12, 13);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
`Pid` int(11) NOT NULL,
  `Pname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Pdesc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Pphoto` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Pprice` float DEFAULT NULL,
  `Tid` int(11) DEFAULT '0'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Pid`, `Pname`, `Pdesc`, `Pphoto`, `Pprice`, `Tid`) VALUES
(2, 'cola', 'very yummy', 'c:\\cola.jpg', 12.5, 0),
(3, 'aaa', 'fff', 'cccc', 10, 0),
(4, 'aaa', 'fff', 'cccc', 10, 0),
(5, 'aaa', 'fff', 'cccc', 10, 0),
(6, 'aaa', 'fff', 'cccc', 10, 0),
(7, 'aaa', 'fff', 'cccc', 10, 0);

-- --------------------------------------------------------

--
-- Table structure for table `registeredcustomer`
--

DROP TABLE IF EXISTS `registeredcustomer`;
CREATE TABLE IF NOT EXISTS `registeredcustomer` (
  `Cid` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `Cname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cbd` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Clocation` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cphone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Pid` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `registeredcustomer`
--

INSERT INTO `registeredcustomer` (`Cid`, `Cname`, `Cbd`, `Clocation`, `Cphone`, `Pid`) VALUES
('2', 'yosi', '12/12/85', 'haifa', '123465', 0),
('3', 'yosi', '12/12/85', 'haifa', '123465', 0),
('30', 'haha', '13/13/85', 'jopa666', '5432566', 0),
('3456', 'haim', '19/19/19', 'nazeret', '000', 0),
('6', 'yosi', '12/12/85', 'haifa', '123465', 0),
('7', 'yosi', '12/12/85', 'haifa', '123465', 0),
('8', 'yosi', '12/12/85', 'haifa', '123465', 0),
('9', 'yosi', '12/12/85', 'haifa', '123465', 0);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE IF NOT EXISTS `sales` (
  `Customerid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Itemid` int(11) DEFAULT NULL,
  `SaleDate` date DEFAULT '1900-01-01',
  `Buy` tinyint(1) DEFAULT '0',
  `Comments` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=REDUNDANT;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`Customerid`, `Itemid`, `SaleDate`, `Buy`, `Comments`) VALUES
('123', 11, '1900-01-01', 0, 'dsafsdafsaff');

-- --------------------------------------------------------

--
-- Table structure for table `segment_permission`
--

DROP TABLE IF EXISTS `segment_permission`;
CREATE TABLE IF NOT EXISTS `segment_permission` (
  `Segmentid` int(11) DEFAULT NULL,
  `Permissionid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE IF NOT EXISTS `type` (
`TId` int(11) NOT NULL,
  `Tname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DId` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`TId`, `Tname`, `DId`) VALUES
(1, 'fork', 12),
(2, 'blah', 11);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
`Uid` int(11) NOT NULL,
  `Password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Addr` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LoggedIn` tinyint(1) NOT NULL,
  `Role` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Uid`, `Password`, `Name`, `Addr`, `Phone`, `LoggedIn`, `Role`) VALUES
(1, 'admin', 'admin', 'braude', '123', 0, 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `campaignreactionreport`
--
ALTER TABLE `campaignreactionreport`
 ADD PRIMARY KEY (`Mid`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
 ADD PRIMARY KEY (`Cid`);

--
-- Indexes for table `domain`
--
ALTER TABLE `domain`
 ADD PRIMARY KEY (`Did`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
 ADD PRIMARY KEY (`Lid`);

--
-- Indexes for table `marketing_campaign`
--
ALTER TABLE `marketing_campaign`
 ADD PRIMARY KEY (`Cid`);

--
-- Indexes for table `marketing_patern`
--
ALTER TABLE `marketing_patern`
 ADD PRIMARY KEY (`Patterid`);

--
-- Indexes for table `market_segment`
--
ALTER TABLE `market_segment`
 ADD PRIMARY KEY (`Segmentid`);

--
-- Indexes for table `permission`
--
ALTER TABLE `permission`
 ADD PRIMARY KEY (`Pid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
 ADD PRIMARY KEY (`Pid`), ADD KEY `FKProduct418308` (`Tid`);

--
-- Indexes for table `registeredcustomer`
--
ALTER TABLE `registeredcustomer`
 ADD PRIMARY KEY (`Cid`), ADD UNIQUE KEY `Cid` (`Cid`), ADD KEY `FKCustomer575078` (`Pid`), ADD KEY `Cid_2` (`Cid`), ADD FULLTEXT KEY `CPhone` (`Cphone`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
 ADD PRIMARY KEY (`TId`), ADD KEY `FKType889971` (`DId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`Uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `campaignreactionreport`
--
ALTER TABLE `campaignreactionreport`
MODIFY `Mid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `domain`
--
ALTER TABLE `domain`
MODIFY `Did` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
MODIFY `Lid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `marketing_campaign`
--
ALTER TABLE `marketing_campaign`
MODIFY `Cid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `marketing_patern`
--
ALTER TABLE `marketing_patern`
MODIFY `Patterid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `market_segment`
--
ALTER TABLE `market_segment`
MODIFY `Segmentid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `permission`
--
ALTER TABLE `permission`
MODIFY `Pid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
MODIFY `Pid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
MODIFY `TId` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `Uid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
