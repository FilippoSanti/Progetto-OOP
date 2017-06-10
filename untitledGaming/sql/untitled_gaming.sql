-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Giu 10, 2017 alle 08:41
-- Versione del server: 10.1.22-MariaDB
-- Versione PHP: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
  `achievement_id` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `descrizione` varchar(300) NOT NULL,
  `gioco_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `achievement`
--

INSERT INTO `achievement` (`achievement_id`, `nome`, `descrizione`, `gioco_id`) VALUES
(1, 'Scarso', 'Raggiungi il livello 5', 1),
(2, 'Merda', 'livello 2', 1),
(3, 'STRONZO', 'livello4', 1),
(4, 'Evvai!', 'livello7', 1),
(5, 'Cacatura', 'Hai fatto schifo', 1),
(6, 'Vafammocc', 'Sei un pirla', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `achievement_ottenuti`
--

CREATE TABLE `achievement_ottenuti` (
  `achievement_ottenuti_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `achievement_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `achievement_ottenuti`
--

INSERT INTO `achievement_ottenuti` (`achievement_ottenuti_id`, `user_id`, `achievement_id`) VALUES
(1, 33, 2),
(2, 33, 3),
(3, 33, 4),
(4, 33, 6),
(5, 33, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `game_profile`
--

CREATE TABLE `game_profile` (
  `game_profile_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `livello` int(3) NOT NULL,
  `punti_esperienza` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dump dei dati per la tabella `game_profile`
--

INSERT INTO `game_profile` (`game_profile_id`, `user_id`, `livello`, `punti_esperienza`) VALUES
(1, 33, 2, 135),
(2, 34, 1, 0),
(3, 35, 1, 0),
(4, 36, 1, 0),
(5, 37, 1, 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `gioco`
--

CREATE TABLE `gioco` (
  `gioco_id` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `gioco`
--

INSERT INTO `gioco` (`gioco_id`, `nome`) VALUES
(1, 'Toss The Coin'),
(2, 'Gioco2'),
(3, 'Gioco3'),
(4, 'Gioco4');

-- --------------------------------------------------------

--
-- Struttura della tabella `recensione`
--

CREATE TABLE `recensione` (
  `recensione_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `testo_recensione` varchar(250) NOT NULL,
  `voto` double DEFAULT NULL,
  `approvata` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `recensione`
--

INSERT INTO `recensione` (`recensione_id`, `user_id`, `testo_recensione`, `voto`, `approvata`) VALUES
(1, 33, 'tutto molto bello', 3, 1),
(2, 34, 'molto interessante', 4, 1),
(3, 35, 'na merda', 4, 1),
(4, 36, 'belo bela', 1, 0),
(5, 37, 'merda pe te', 2, 1),
(6, 35, 'sasasasa', 1, 1),
(7, 35, 'aaaqqqqwwww', 4, 0),
(8, 36, '1112334', 4, 1),
(9, 35, 'aaaaaa', 4, 1),
(10, 37, '12313123', 4, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `timeline`
--

CREATE TABLE `timeline` (
  `timeline_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `gioco_id` int(11) NOT NULL,
  `data_ultima_sessione` date NOT NULL,
  `esperienza_guadagnata` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `timeline`
--

INSERT INTO `timeline` (`timeline_id`, `user_id`, `gioco_id`, `data_ultima_sessione`, `esperienza_guadagnata`) VALUES
(1, 33, 1, '2017-06-09', 0),
(2, 34, 1, '2017-06-09', 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `user_id` int(11) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `data_di_nascita` date NOT NULL,
  `email` varchar(25) NOT NULL,
  `tipo` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`user_id`, `username`, `password`, `nome`, `cognome`, `data_di_nascita`, `email`, `tipo`) VALUES
(33, 'a', '$2a$12$ZCCzckOE3E9JjNdFVZj9TOALo0kYq.kmtbv45SDamMQ784D1SDKly', 'a', 'a', '1995-10-11', 'a', 'user'),
(34, 'b', '$2a$12$zIUDU95lSJCRYr6NH1VIdued0g7I5RenfyEqraIKsGf68CuRcbn8K', 'b', 'b', '1888-11-11', 'b', 'user'),
(35, 'c', '$2a$12$mLDFI2zdjPTABeZyDoB1OefGmfCDskRbYnA2cHFWJ.eMiTZn2DDd.', 'c', 'c', '1111-11-11', 'c', 'user'),
(36, 'd', '$2a$12$2RlHSOsRwNNtzLAdTKWi6.y2tG.Ja0gxLEucZxGOT.NFlAFoA2mJq', 'd', 'd', '1111-11-11', 'd', 'user'),
(37, 'e', '$2a$12$ygcTvhJjWjSMOILjIkJRYeBbF85Y/tRTF0V88ooFOX65twEOa3f4m', 'e', 'e', '1111-11-11', 'e', 'user');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`achievement_id`),
  ADD KEY `gioco_id` (`gioco_id`);

--
-- Indici per le tabelle `achievement_ottenuti`
--
ALTER TABLE `achievement_ottenuti`
  ADD PRIMARY KEY (`achievement_ottenuti_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `achievement_id` (`achievement_id`);

--
-- Indici per le tabelle `game_profile`
--
ALTER TABLE `game_profile`
  ADD PRIMARY KEY (`game_profile_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indici per le tabelle `gioco`
--
ALTER TABLE `gioco`
  ADD PRIMARY KEY (`gioco_id`);

--
-- Indici per le tabelle `recensione`
--
ALTER TABLE `recensione`
  ADD PRIMARY KEY (`recensione_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indici per le tabelle `timeline`
--
ALTER TABLE `timeline`
  ADD PRIMARY KEY (`timeline_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `gioco_id` (`gioco_id`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `achievement`
--
ALTER TABLE `achievement`
  MODIFY `achievement_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT per la tabella `achievement_ottenuti`
--
ALTER TABLE `achievement_ottenuti`
  MODIFY `achievement_ottenuti_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `game_profile`
--
ALTER TABLE `game_profile`
  MODIFY `game_profile_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `gioco`
--
ALTER TABLE `gioco`
  MODIFY `gioco_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT per la tabella `recensione`
--
ALTER TABLE `recensione`
  MODIFY `recensione_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT per la tabella `timeline`
--
ALTER TABLE `timeline`
  MODIFY `timeline_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `achievement`
--
ALTER TABLE `achievement`
  ADD CONSTRAINT `achievement_ibfk_1` FOREIGN KEY (`gioco_id`) REFERENCES `gioco` (`gioco_id`);

--
-- Limiti per la tabella `achievement_ottenuti`
--
ALTER TABLE `achievement_ottenuti`
  ADD CONSTRAINT `achievement_ottenuti_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `utente` (`user_id`),
  ADD CONSTRAINT `achievement_ottenuti_ibfk_2` FOREIGN KEY (`achievement_id`) REFERENCES `achievement` (`achievement_id`);

--
-- Limiti per la tabella `game_profile`
--
ALTER TABLE `game_profile`
  ADD CONSTRAINT `game_profile_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `utente` (`user_id`);

--
-- Limiti per la tabella `recensione`
--
ALTER TABLE `recensione`
  ADD CONSTRAINT `recensione_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `utente` (`user_id`);

--
-- Limiti per la tabella `timeline`
--
ALTER TABLE `timeline`
  ADD CONSTRAINT `timeline_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `utente` (`user_id`),
  ADD CONSTRAINT `timeline_ibfk_2` FOREIGN KEY (`gioco_id`) REFERENCES `gioco` (`gioco_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
