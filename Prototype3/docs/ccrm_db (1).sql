-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 19, 2015 at 02:23 PM
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
-- Table structure for table `campaignmarketingpattern`
--

CREATE TABLE IF NOT EXISTS `campaignmarketingpattern` (
`Cmpid` int(11) NOT NULL,
  `Product` int(10) DEFAULT NULL,
  `Market_segment` int(10) DEFAULT NULL,
  `MessageToCustomer` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `campaignreactionreport`
--

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

CREATE TABLE IF NOT EXISTS `customer` (
  `PermissionAttribute` int(11) DEFAULT NULL,
  `Cid` varchar(9) COLLATE utf8_unicode_ci NOT NULL DEFAULT '-1',
  `Cname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cbd` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CLocation` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CPhone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Discriminator` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PermissionPeid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`PermissionAttribute`, `Cid`, `Cname`, `Cbd`, `CLocation`, `CPhone`, `Discriminator`, `PermissionPeid`) VALUES
(NULL, '2', 'yosi', '12/12/85', 'haifa', '123465', NULL, NULL),
(NULL, '3', 'yosi', '12/12/85', 'haifa', '123465', NULL, NULL),
(NULL, '30', 'haha', '13/13/85', 'jopa666', '5432566', NULL, NULL),
(NULL, '3456', 'haim', '19/19/19', 'nazeret', '000', NULL, NULL),
(NULL, '6', 'yosi', '12/12/85', 'haifa', '123465', NULL, NULL),
(NULL, '7', 'yosi', '12/12/85', 'haifa', '123465', NULL, NULL),
(NULL, '8', 'yosi', '12/12/85', 'haifa', '123465', NULL, NULL),
(NULL, '9', 'yosi', '12/12/85', 'haifa', '123465', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customerpurchaseorrejection`
--

CREATE TABLE IF NOT EXISTS `customerpurchaseorrejection` (
  `Cid` int(10) NOT NULL,
  `Pid` int(10) NOT NULL,
  `PDate` date DEFAULT NULL,
  `RejectionMsg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `domain`
--

CREATE TABLE IF NOT EXISTS `domain` (
`DId` int(10) NOT NULL,
  `DName` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Dumping data for table `domain`
--

INSERT INTO `domain` (`DId`, `DName`) VALUES
(1, 'klei bait'),
(2, 'klei bait'),
(3, 'klei bait'),
(4, 'klei bait'),
(5, 'klei bait'),
(6, 'klei bait');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `Eid` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `Role` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE IF NOT EXISTS `location` (
`Lid` int(11) NOT NULL,
  `Location` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `marketingcampaign`
--

CREATE TABLE IF NOT EXISTS `marketingcampaign` (
  `Cmpid` int(11) NOT NULL,
  `Cdate` date DEFAULT NULL,
  `Cust` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `marketsegment`
--

CREATE TABLE IF NOT EXISTS `marketsegment` (
  `Msid` int(11) NOT NULL,
  `Age` int(11) NOT NULL,
  `Location` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `C_rate` int(11) NOT NULL,
  `Interest` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `marketsegment_permission`
--

CREATE TABLE IF NOT EXISTS `marketsegment_permission` (
  `Index` int(11) NOT NULL,
  `Permission` int(11) DEFAULT NULL,
  `Msid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `permission`
--

CREATE TABLE IF NOT EXISTS `permission` (
  `Peid` int(11) NOT NULL,
  `Cid` int(11) NOT NULL,
  `PeDomain` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `potentialcustomer`
--

CREATE TABLE IF NOT EXISTS `potentialcustomer` (
  `ID` int(11) NOT NULL,
  `Cid` int(11) NOT NULL,
  `Cfname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Clname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cbd` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CLocation` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cphone` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `TypeAttribute` int(11) NOT NULL,
  `DomainAttribute` int(11) NOT NULL,
  `PId` int(10) NOT NULL,
  `PName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PDesc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PPhoto` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PPrice` float NOT NULL,
  `DomainDId` int(10) NOT NULL,
  `TypeTId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `Attribute` int(11) NOT NULL,
  `DomainAttribute` int(11) NOT NULL,
  `TId` int(10) NOT NULL,
  `TName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DomainDId` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `Uid` int(11) NOT NULL,
  `Password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Addr` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LoggedIn` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Uid`, `Password`, `Name`, `Addr`, `Phone`, `LoggedIn`) VALUES
(306999999, '123', 'nastia', 'lolipop', '654321', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `campaignmarketingpattern`
--
ALTER TABLE `campaignmarketingpattern`
 ADD PRIMARY KEY (`Cmpid`);

--
-- Indexes for table `campaignreactionreport`
--
ALTER TABLE `campaignreactionreport`
 ADD PRIMARY KEY (`Mid`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
 ADD PRIMARY KEY (`Cid`), ADD UNIQUE KEY `Cid` (`Cid`), ADD KEY `FKCustomer575078` (`PermissionAttribute`,`PermissionPeid`), ADD KEY `Cid_2` (`Cid`);

--
-- Indexes for table `customerpurchaseorrejection`
--
ALTER TABLE `customerpurchaseorrejection`
 ADD PRIMARY KEY (`Cid`,`Pid`);

--
-- Indexes for table `domain`
--
ALTER TABLE `domain`
 ADD PRIMARY KEY (`DId`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
 ADD PRIMARY KEY (`Eid`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
 ADD PRIMARY KEY (`Lid`);

--
-- Indexes for table `marketingcampaign`
--
ALTER TABLE `marketingcampaign`
 ADD PRIMARY KEY (`Cmpid`);

--
-- Indexes for table `marketsegment`
--
ALTER TABLE `marketsegment`
 ADD PRIMARY KEY (`Msid`);

--
-- Indexes for table `marketsegment_permission`
--
ALTER TABLE `marketsegment_permission`
 ADD PRIMARY KEY (`Msid`), ADD KEY `FKMarketSegm403038` (`Msid`);

--
-- Indexes for table `permission`
--
ALTER TABLE `permission`
 ADD PRIMARY KEY (`Peid`);

--
-- Indexes for table `potentialcustomer`
--
ALTER TABLE `potentialcustomer`
 ADD PRIMARY KEY (`Cid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
 ADD PRIMARY KEY (`PId`), ADD KEY `FKProduct523349` (`DomainAttribute`,`DomainDId`), ADD KEY `FKProduct418308` (`TypeAttribute`,`TypeTId`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
 ADD PRIMARY KEY (`TId`), ADD KEY `FKType889971` (`DomainAttribute`,`DomainDId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`Uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `campaignmarketingpattern`
--
ALTER TABLE `campaignmarketingpattern`
MODIFY `Cmpid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `campaignreactionreport`
--
ALTER TABLE `campaignreactionreport`
MODIFY `Mid` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `domain`
--
ALTER TABLE `domain`
MODIFY `DId` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
MODIFY `Lid` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
