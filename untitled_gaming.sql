-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Mag 23, 2017 alle 18:55
-- Versione del server: 5.7.18
-- Versione PHP: 7.0.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `untitled_gaming`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `achievement`
--

CREATE TABLE `achievement` (
  `id_achievement` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `descrizione` varchar(300) NOT NULL,
  `username` varchar(30) NOT NULL,
  `id_gioco` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `gioco`
--

CREATE TABLE `gioco` (
  `id_gioco` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `profilo di gioco`
--

CREATE TABLE `profilo di gioco` (
  `username` varchar(20) NOT NULL,
  `livello` int(3) NOT NULL,
  `punti esperienza` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `recensioni`
--

CREATE TABLE `recensioni` (
  `username` varchar(20) NOT NULL,
  `testo_recensione` varchar(250) NOT NULL,
  `voto` float DEFAULT NULL,
  `approvata` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `timeline`
--

CREATE TABLE `timeline` (
  `username` varchar(10) NOT NULL,
  `livello` int(11) NOT NULL,
  `data_acquisizione` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `username` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `email` varchar(25) NOT NULL,
  `tipo` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`username`, `password`, `nome`, `cognome`, `email`, `tipo`) VALUES
('asd', 'asd', 'asd', 'asd', 'asd', 'asd'),
('mikesh', 'asd', 'ss', 'ss', 'ss', 'ss'),
('prova', 'prova', 'provs', 'prva', 'prov', 'prva'),
('test1', 'test2', 'test3', 'test4', 'test5', 'test6'),
('test10', 'test2', 'test3', 'test4', 'test5', 'test6'),
('test100', 'test2', 'test3', 'test4', 'test5', 'test6'),
('test1000', 'test2', 'test3', 'test4', 'test5', 'test6'),
('user2', 'PASSWORD', 'nome', 'cognome', 'email', 'usr'),
('utente1', 'dd', 'dd', 'dd', 'dd', 'd');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`id_achievement`),
  ADD KEY `username` (`username`);

--
-- Indici per le tabelle `gioco`
--
ALTER TABLE `gioco`
  ADD PRIMARY KEY (`id_gioco`);

--
-- Indici per le tabelle `profilo di gioco`
--
ALTER TABLE `profilo di gioco`
  ADD PRIMARY KEY (`username`);

--
-- Indici per le tabelle `recensioni`
--
ALTER TABLE `recensioni`
  ADD PRIMARY KEY (`username`);

--
-- Indici per le tabelle `timeline`
--
ALTER TABLE `timeline`
  ADD PRIMARY KEY (`username`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `achievement`
--
ALTER TABLE `achievement`
  MODIFY `id_achievement` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `gioco`
--
ALTER TABLE `gioco`
  MODIFY `id_gioco` int(11) NOT NULL AUTO_INCREMENT;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `achievement`
--
ALTER TABLE `achievement`
  ADD CONSTRAINT `achievement_ibfk_1` FOREIGN KEY (`username`) REFERENCES `utente` (`username`);

--
-- Limiti per la tabella `gioco`
--
ALTER TABLE `gioco`
  ADD CONSTRAINT `gioco_ibfk_1` FOREIGN KEY (`id_gioco`) REFERENCES `achievement` (`id_achievement`);

--
-- Limiti per la tabella `profilo di gioco`
--
ALTER TABLE `profilo di gioco`
  ADD CONSTRAINT `profilo di gioco_ibfk_1` FOREIGN KEY (`username`) REFERENCES `utente` (`username`);

--
-- Limiti per la tabella `recensioni`
--
ALTER TABLE `recensioni`
  ADD CONSTRAINT `recensioni_ibfk_1` FOREIGN KEY (`username`) REFERENCES `utente` (`username`);

--
-- Limiti per la tabella `timeline`
--
ALTER TABLE `timeline`
  ADD CONSTRAINT `timeline_ibfk_1` FOREIGN KEY (`username`) REFERENCES `utente` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
