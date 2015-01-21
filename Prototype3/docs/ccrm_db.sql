-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 08, 2015 at 12:46 PM
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
  `PermissionAttribute` int(11) NOT NULL,
  `Cid` int(11) NOT NULL,
  `Cname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cbd` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CLocation` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CPhone` int(10) DEFAULT NULL,
  `Discriminator` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PermissionPeid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  `Attribute` int(11) NOT NULL,
  `DId` int(10) NOT NULL,
  `DName` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE IF NOT EXISTS `location` (
  `Lid` int(11) NOT NULL,
  `Location` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  `Password` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `Name` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `Addr` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `Phone` int(10) DEFAULT NULL,
  `LoggedIn` tinyint(1) NOT NULL,
  `Eid` int(10) NOT NULL,
  `Role` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `Discriminator` varchar(255) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
 ADD PRIMARY KEY (`Cid`), ADD KEY `FKCustomer575078` (`PermissionAttribute`,`PermissionPeid`);

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
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
