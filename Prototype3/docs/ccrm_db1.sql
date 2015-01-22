-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2015 at 09:46 PM
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
  `Cid` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `Cname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cbd` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CLocation` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Cphone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Cid`, `Cname`, `Cbd`, `CLocation`, `Cphone`) VALUES
('123', 'kaka', '13', 'sham', '33333');

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

CREATE TABLE IF NOT EXISTS `location` (
`Lid` int(11) NOT NULL,
  `Location` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`Lid`, `Location`) VALUES
(1, 'haifa'),
(2, 'hahahaha'),
(3, 'nazeret');

-- --------------------------------------------------------

--
-- Table structure for table `marketingcampaign`
--

CREATE TABLE IF NOT EXISTS `marketingcampaign` (
`Cid` int(11) NOT NULL,
  `Startdate` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Enddate` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `marketingcampaign`
--

INSERT INTO `marketingcampaign` (`Cid`, `Startdate`, `Enddate`) VALUES
(1, '', ''),
(2, '123', '123');

-- --------------------------------------------------------

--
-- Table structure for table `marketing_customers`
--

CREATE TABLE IF NOT EXISTS `marketing_customers` (
  `Customerid` varchar(100) DEFAULT NULL,
  `Campaignid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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

CREATE TABLE IF NOT EXISTS `product` (
`Pid` int(11) NOT NULL,
  `Pname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Pdesc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Pphoto` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Pprice` float DEFAULT NULL,
  `TId` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`Pid`, `Pname`, `Pdesc`, `Pphoto`, `Pprice`, `TId`) VALUES
(2, 'cola', 'very yummy', 'c:\\cola.jpg', 12.5, NULL),
(3, 'aaa', 'fff', 'cccc', 10, NULL),
(4, 'aaa', 'fff', 'cccc', 10, NULL),
(5, 'aaa', 'fff', 'cccc', 10, NULL),
(6, 'aaa', 'fff', 'cccc', 10, NULL),
(7, 'aaa', 'fff', 'cccc', 10, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `registeredcustomer`
--

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
('11', '11', '11', '11', '11', 0),
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

CREATE TABLE IF NOT EXISTS `sales` (
  `Customerid` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Itemid` int(11) DEFAULT NULL,
  `SaleDate` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Buy` tinyint(1) DEFAULT '0',
  `Comments` varchar(300) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`Customerid`, `Itemid`, `SaleDate`, `Buy`, `Comments`) VALUES
('123', 13, '121212', 1, 'buy stuff good item this'),
('123', 13, '121212', 1, 'buy stuff good item this');

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

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
 ADD PRIMARY KEY (`Cid`);

--
-- Indexes for table `customerpurchaseorrejection`
--
ALTER TABLE `customerpurchaseorrejection`
 ADD PRIMARY KEY (`Cid`,`Pid`);

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
-- Indexes for table `marketingcampaign`
--
ALTER TABLE `marketingcampaign`
 ADD PRIMARY KEY (`Cid`);

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
 ADD PRIMARY KEY (`Pid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
 ADD PRIMARY KEY (`Pid`), ADD KEY `FKProduct418308` (`TId`);

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
MODIFY `Did` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
MODIFY `Lid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `marketingcampaign`
--
ALTER TABLE `marketingcampaign`
MODIFY `Cid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
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
