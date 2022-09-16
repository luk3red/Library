-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Set 16, 2022 alle 16:42
-- Versione del server: 10.4.11-MariaDB
-- Versione PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `accessi`
--

CREATE TABLE `accessi` (
  `ID` int(11) NOT NULL,
  `ID_utente` int(11) NOT NULL,
  `ID_owner` int(11) NOT NULL,
  `ID_libreria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `accessi`
--

INSERT INTO `accessi` (`ID`, `ID_utente`, `ID_owner`, `ID_libreria`) VALUES
(1, 3, 1, 1),
(3, 3, 1, 6),
(4, 1, 3, 7),
(5, 3, 1, 10);

-- --------------------------------------------------------

--
-- Struttura della tabella `amministratore`
--

CREATE TABLE `amministratore` (
  `SID` int(11) NOT NULL,
  `Username` text NOT NULL,
  `Password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `amministratore`
--

INSERT INTO `amministratore` (`SID`, `Username`, `Password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struttura della tabella `anagrafica`
--

CREATE TABLE `anagrafica` (
  `CF` text NOT NULL,
  `Nome` text NOT NULL,
  `Cognome` text NOT NULL,
  `Email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `anagrafica`
--

INSERT INTO `anagrafica` (`CF`, `Nome`, `Cognome`, `Email`) VALUES
('brrlcu98p16f839b', 'luca', 'Barr', 'lbar@live.it'),
('DSRMLSNUM1ONECIA', 'MARIALUISA', 'DI SIERO', 'marialuisads@gmail.co'),
('PRLGNN98M08E094C', 'Giovanni', 'Perillo', 'g.perillo@studenti.unina.it');

-- --------------------------------------------------------

--
-- Struttura della tabella `libreria`
--

CREATE TABLE `libreria` (
  `ID` int(11) NOT NULL,
  `ID_AMM` int(11) NOT NULL,
  `ID_USER` int(11) NOT NULL,
  `PRIVACY` tinyint(11) NOT NULL,
  `Nome` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `libreria`
--

INSERT INTO `libreria` (`ID`, `ID_AMM`, `ID_USER`, `PRIVACY`, `Nome`) VALUES
(1, 1, 1, 1, 'lib1'),
(2, 1, 2, 1, 'Pub1'),
(3, 1, 1, 1, 'Libp1'),
(4, 1, 2, 0, 'Lib2'),
(5, 1, 2, 0, 'Lib2'),
(6, 1, 1, 1, 'bella'),
(7, 1, 3, 1, 'porvagus'),
(8, 1, 1, 1, 'test'),
(10, 1, 1, 1, 'libreria pubblica test');

-- --------------------------------------------------------

--
-- Struttura della tabella `libreriacond`
--

CREATE TABLE `libreriacond` (
  `ID` int(11) NOT NULL,
  `ID_AMM` int(11) NOT NULL,
  `ID_USER` int(11) NOT NULL,
  `PRIVACY` int(11) NOT NULL,
  `Nome` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `libreriacond`
--

INSERT INTO `libreriacond` (`ID`, `ID_AMM`, `ID_USER`, `PRIVACY`, `Nome`) VALUES
(1, 1, 1, 0, 'cond1'),
(2, 1, 2, 0, 'STORIA'),
(3, 1, 1, 0, 'Lib2'),
(4, 1, 1, 0, 'prova lib pub'),
(5, 1, 1, 0, 'gsdfgsdfgsdfg'),
(6, 1, 3, 0, 'kkkk'),
(7, 1, 1, 0, 'libreriapubblicatutti');

-- --------------------------------------------------------

--
-- Struttura della tabella `media`
--

CREATE TABLE `media` (
  `ID` int(11) NOT NULL,
  `COD_LIB` int(11) NOT NULL,
  `OID` int(11) NOT NULL,
  `Nome` text NOT NULL,
  `Formato` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `media`
--

INSERT INTO `media` (`ID`, `COD_LIB`, `OID`, `Nome`, `Formato`) VALUES
(1, 1, 1, 'LOTR', 'DVD'),
(2, 1, 1, 'chimica', 'txt'),
(3, 1, 1, 'Velociraptor', 'CD'),
(5, 3, 1, 'Video', 'mp4'),
(6, 7, 3, 'la divina commedia', 'jpg'),
(8, 6, 1, 'ddddd', 'txt'),
(9, 3, 1, 'promessisposi', 'exe'),
(11, 10, 1, 'nuovarisorsaSAD', 'pdf');

-- --------------------------------------------------------

--
-- Struttura della tabella `mediac`
--

CREATE TABLE `mediac` (
  `ID` int(11) NOT NULL,
  `COD_LIBC` int(11) NOT NULL,
  `OID` int(11) NOT NULL,
  `Nome` text NOT NULL,
  `Formato` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `mediac`
--

INSERT INTO `mediac` (`ID`, `COD_LIBC`, `OID`, `Nome`, `Formato`) VALUES
(1, 2, 2, 'LALALA', 'DVD'),
(3, 1, 1, 'Medc1', 'txt'),
(4, 1, 1, 'testoprova', 'txt'),
(5, 3, 1, 'dfsdfdf', 'svg'),
(6, 1, 1, 'Boccaccio', 'DVD');

-- --------------------------------------------------------

--
-- Struttura della tabella `prestiti`
--

CREATE TABLE `prestiti` (
  `ID` int(11) NOT NULL,
  `IDM` int(11) NOT NULL,
  `UID` int(11) NOT NULL,
  `IDB` int(11) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `exdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `prestiti`
--

INSERT INTO `prestiti` (`ID`, `IDM`, `UID`, `IDB`, `date`, `exdate`) VALUES
(1, 3, 1, 2, '2021-01-26', '2020-10-10');

-- --------------------------------------------------------

--
-- Struttura della tabella `richieste`
--

CREATE TABLE `richieste` (
  `ID` int(11) NOT NULL,
  `ID_richiedente` int(11) NOT NULL,
  `ID_libreria` int(11) NOT NULL,
  `ID_owner` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `richieste`
--

INSERT INTO `richieste` (`ID`, `ID_richiedente`, `ID_libreria`, `ID_owner`) VALUES
(1, 3, 5, 2),
(2, 3, 2, 2),
(3, 3, 2, 2),
(4, 3, 2, 2),
(8, 1, 3, 1),
(15, 1, 2, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `UID` int(11) NOT NULL,
  `COD_FISC` text NOT NULL,
  `Username` text NOT NULL,
  `Password` text NOT NULL,
  `Permessi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`UID`, `COD_FISC`, `Username`, `Password`, `Permessi`) VALUES
(1, 'PRLGNN98M08E094C', 'Gionni', 'mary', 0),
(2, 'DSRMLSNUM1ONECIA', 'MLUISA', 'PASSWORD', 0),
(3, '1234567891234567', 'guser', 'guser', 0),
(4, 'brrlcu98p16f839b', 'luk', 'reddo', 0),
(5, 'cribrr98p16f839e', 'darioddd', 'ciaociao', 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `utenticond`
--

CREATE TABLE `utenticond` (
  `ID_USER` int(11) NOT NULL,
  `IDC` int(11) NOT NULL,
  `Permesso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `utenticond`
--

INSERT INTO `utenticond` (`ID_USER`, `IDC`, `Permesso`) VALUES
(1, 2, 0),
(1, 1, 1),
(2, 2, 1),
(1, 3, 1),
(3, 1, 1),
(2, 1, 0),
(1, 4, 1),
(1, 5, 1),
(3, 6, 1),
(1, 7, 1),
(4, 7, 0),
(4, 5, 0),
(4, 1, 0),
(3, 7, 0);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `accessi`
--
ALTER TABLE `accessi`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_utente` (`ID_utente`),
  ADD KEY `ID_owner` (`ID_owner`),
  ADD KEY `ID_libreria` (`ID_libreria`);

--
-- Indici per le tabelle `amministratore`
--
ALTER TABLE `amministratore`
  ADD PRIMARY KEY (`SID`);

--
-- Indici per le tabelle `anagrafica`
--
ALTER TABLE `anagrafica`
  ADD PRIMARY KEY (`CF`(16)),
  ADD UNIQUE KEY `Email` (`Email`) USING HASH;

--
-- Indici per le tabelle `libreria`
--
ALTER TABLE `libreria`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_USER` (`ID_USER`);

--
-- Indici per le tabelle `libreriacond`
--
ALTER TABLE `libreriacond`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_USER` (`ID_USER`);

--
-- Indici per le tabelle `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `COD_LIB` (`COD_LIB`);

--
-- Indici per le tabelle `mediac`
--
ALTER TABLE `mediac`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `COD_LIBC` (`COD_LIBC`);

--
-- Indici per le tabelle `prestiti`
--
ALTER TABLE `prestiti`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `IDM` (`IDM`),
  ADD KEY `UID` (`UID`);

--
-- Indici per le tabelle `richieste`
--
ALTER TABLE `richieste`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_owner` (`ID_owner`),
  ADD KEY `ID_richiedente_2` (`ID_richiedente`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`UID`),
  ADD UNIQUE KEY `Username` (`Username`) USING HASH,
  ADD UNIQUE KEY `COD_FISC` (`COD_FISC`) USING HASH;

--
-- Indici per le tabelle `utenticond`
--
ALTER TABLE `utenticond`
  ADD KEY `iduser` (`ID_USER`),
  ADD KEY `IDC` (`IDC`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `accessi`
--
ALTER TABLE `accessi`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `amministratore`
--
ALTER TABLE `amministratore`
  MODIFY `SID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `libreria`
--
ALTER TABLE `libreria`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `libreriacond`
--
ALTER TABLE `libreriacond`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT per la tabella `media`
--
ALTER TABLE `media`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT per la tabella `mediac`
--
ALTER TABLE `mediac`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT per la tabella `prestiti`
--
ALTER TABLE `prestiti`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `richieste`
--
ALTER TABLE `richieste`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `UID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `accessi`
--
ALTER TABLE `accessi`
  ADD CONSTRAINT `accessi_ibfk_2` FOREIGN KEY (`ID_libreria`) REFERENCES `libreria` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `accessi_ibfk_3` FOREIGN KEY (`ID_utente`) REFERENCES `utente` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `libreria`
--
ALTER TABLE `libreria`
  ADD CONSTRAINT `libreria_ibfk_1` FOREIGN KEY (`ID_USER`) REFERENCES `utente` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `libreriacond`
--
ALTER TABLE `libreriacond`
  ADD CONSTRAINT `libreriacond_ibfk_1` FOREIGN KEY (`ID_USER`) REFERENCES `utente` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `media`
--
ALTER TABLE `media`
  ADD CONSTRAINT `media_ibfk_1` FOREIGN KEY (`COD_LIB`) REFERENCES `libreria` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `mediac`
--
ALTER TABLE `mediac`
  ADD CONSTRAINT `mediac_ibfk_1` FOREIGN KEY (`COD_LIBC`) REFERENCES `libreriacond` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `prestiti`
--
ALTER TABLE `prestiti`
  ADD CONSTRAINT `prestiti_ibfk_2` FOREIGN KEY (`IDM`) REFERENCES `mediac` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `richieste`
--
ALTER TABLE `richieste`
  ADD CONSTRAINT `richieste_ibfk_1` FOREIGN KEY (`ID_richiedente`) REFERENCES `utente` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `richieste_ibfk_2` FOREIGN KEY (`ID_owner`) REFERENCES `utente` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `utenticond`
--
ALTER TABLE `utenticond`
  ADD CONSTRAINT `utenticond_ibfk_1` FOREIGN KEY (`ID_USER`) REFERENCES `utente` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `utenticond_ibfk_2` FOREIGN KEY (`IDC`) REFERENCES `libreriacond` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
