-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Giu 15, 2017 alle 15:12
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
(1, 'Novizio', 'Raggiunto il livello 2', 1),
(2, 'Principiante', 'Hai raggiunto il livello 4', 1),
(3, 'Esperto', 'Hai raggiunto il livello 6', 1),
(4, 'Maestro', 'Hai raggiunto il livello 8', 1),
(5, 'Professionista', 'Hai guadagnato 1000 esperienza in una sola sessione', 1),
(6, 'Flipper', 'Hai guadagnato 500 esperienza nell ultima sessione', 1);

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
(1, 5, 1),
(2, 5, 2),
(3, 5, 3),
(4, 5, 6),
(5, 5, 5),
(6, 6, 1),
(7, 6, 2),
(8, 6, 6),
(9, 6, 3),
(10, 6, 4),
(11, 6, 5),
(12, 6, 2),
(13, 6, 3),
(14, 6, 4),
(15, 6, 6),
(16, 8, 1),
(17, 8, 2),
(18, 8, 3),
(19, 8, 6),
(20, 8, 5),
(21, 8, 4),
(22, 2, 1),
(23, 2, 2),
(24, 2, 3),
(25, 2, 6);

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
(1, 1, 1, 0),
(2, 1, 1, 0),
(3, 2, 9, 2850),
(4, 3, 1, 0),
(5, 4, 1, 0),
(6, 5, 7, 1530),
(7, 6, 8, 2010),
(8, 7, 1, 0),
(9, 8, 9, 2945),
(10, 1, 1, 0),
(11, 2, 9, 2850),
(12, 3, 1, 0),
(13, 4, 1, 0),
(14, 5, 1, 0),
(15, 6, 1, 0),
(16, 7, 1, 0),
(17, 8, 1, 0),
(18, 9, 1, 0),
(19, 10, 1, 0),
(20, 11, 1, 0);

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
(1, 'tossTheCoin'),
(2, 'Gioco2'),
(3, 'Gioco3'),
(4, 'Gioco4'),
(5, 'ShitOnCoin');

-- --------------------------------------------------------

--
-- Struttura della tabella `recensione`
--

CREATE TABLE `recensione` (
  `recensione_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `testo_recensione` varchar(250) NOT NULL,
  `voto` double DEFAULT NULL,
  `gioco_id` int(11) NOT NULL,
  `approvata` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `recensione`
--

INSERT INTO `recensione` (`recensione_id`, `user_id`, `testo_recensione`, `voto`, `gioco_id`, `approvata`) VALUES
(2, 1, 'merda', 2, 5, 0),
(3, 2, '  Le bestemmie', 1, 3, 0),
(6, 3, '  porca ma', 0, 1, 0),
(8, 1, 'porcaccia', 2, 1, 0),
(9, 1, 'Ma vafammocc', 1, 1, 0),
(10, 1, 'Ti sfascio il letto', 3, 0, 0);

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
(1, 1, 1, '1111-11-11', 0),
(2, 2, 5, '2017-06-14', 1680),
(3, 3, 1, '1111-11-11', 0),
(4, 4, 1, '1111-11-11', 0),
(5, 5, 1, '1111-11-11', 0),
(6, 6, 1, '1111-11-11', 0),
(7, 7, 1, '1111-11-11', 0),
(8, 8, 1, '1111-11-11', 0),
(9, 9, 1, '1111-11-11', 0),
(10, 10, 1, '1111-11-11', 0),
(11, 11, 1, '1111-11-11', 0);

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
  `immagine_profilo` mediumblob NOT NULL,
  `tipo` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`user_id`, `username`, `password`, `nome`, `cognome`, `data_di_nascita`, `email`, `immagine_profilo`, `tipo`) VALUES
(1, 'a', '$2a$12$nAx9VaUuV8w2OhoI5qGLmuZtzrIdD0fsWs9HU5HqMIEJR3mSIeiRC', 'a', 'a', '1111-11-11', 'a@email.it', 0x30, 'user'),
(2, 'b', '$2a$12$9exGhnJ5ih803NRBzMPQ4uMGNcdoOGVeYeWtIuckGV0cA7Uyyyyyy', 'b', 'b', '1111-11-11', 'b@hotmail.it', 0x30, 'administrator'),
(3, 'merda', '$2a$12$fGMlnLLZLhhNLN7J.nztzeEqcNFmR3O8hHuBfKp.rZCzVKbjGkj7u', 'cacarella', 'cacca', '1111-11-11', 'c@hotmail.it', 0x30, 'user'),
(4, 'd', '$2a$12$c5b/A4BU.AshPZMmGT1pvOhNhQIDJYjxIp37xNkH7jJgzt3GWQZdK', 'd', 'd', '1111-11-11', 'd@hotmail.it', 0x30, 'moderator'),
(5, 'e', '$2a$12$OocLU/5qUviV0moTXbKUYe.4k8QWLOUKyVQKCNqzDn7MhCg1z02pG', 'e', 'e', '1111-11-11', 'e@d.it', 0x30, 'user'),
(6, 'f', '$2a$12$MJcmyonO0T6GWXXm9/erUuQ7SnWYntKsFNUepAPo1NnFNeEUg3JtS', 'f', 'f', '1111-11-11', 'f@k.it', 0x30, 'user'),
(7, 'ambaraba', '$2a$12$DTl/lVCshLUH2gKqu6N3ZuYLROJ02OzPM.RU48/heGMlLOa3dU/ZO', 'ambaraba', 'a', '1111-11-11', 'a@j.it', 0x30, 'user'),
(8, 'TonyCacone', '$2a$12$zeHi/eI1QhYO25S3MlEkj.wv9StajpHRFxTSaOQp8ebu266xy9Nwq', 'd', 's', '1111-11-11', 't@hotmail.it', 0x30, 'user'),
(9, 'SandrOPertini', '$2a$12$6PVfnHy5i/vFgkLJ7iVPXOr.EJ6UvLPNsAQC2ZAH.96SXBGKTYzoG', 'sandro', 's', '1111-11-11', 'kk@hotmail.it', 0x30, 'user'),
(10, 'ddssss', '$2a$12$t4r468HCAo2chZtfkiOoaOaytFSupUy8ajWzsViZFMLKG.0komCSC', 'dd', 'dd', '1111-11-11', 'd@i.it', 0x30, 'user'),
(11, 'giovanniPatti', '$2a$12$nyx.WXnWo.k4Ks3UY8bOv.YaWLrDOG2yMyGMPfvLeypixRMhIFBVy', 'g', '11', '1111-11-11', '1@hotmail.it', 0x30, 'user');

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
  ADD KEY `achievement_id` (`achievement_id`),
  ADD KEY `user_id` (`user_id`);

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
  MODIFY `achievement_ottenuti_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT per la tabella `game_profile`
--
ALTER TABLE `game_profile`
  MODIFY `game_profile_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT per la tabella `gioco`
--
ALTER TABLE `gioco`
  MODIFY `gioco_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `recensione`
--
ALTER TABLE `recensione`
  MODIFY `recensione_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT per la tabella `timeline`
--
ALTER TABLE `timeline`
  MODIFY `timeline_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `achievement`
--
ALTER TABLE `achievement`
  ADD CONSTRAINT `achievement_ibfk_1` FOREIGN KEY (`gioco_id`) REFERENCES `gioco` (`gioco_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
