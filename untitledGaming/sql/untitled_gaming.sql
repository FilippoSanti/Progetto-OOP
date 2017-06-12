-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Giu 12, 2017 alle 18:38
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
(5, 5, 5);

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
(3, 2, 1, 0),
(4, 3, 1, 0),
(5, 4, 1, 0),
(6, 5, 7, 1530);

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
(1, 1, 'Tutto molto bello', 4, 1),
(3, 2, '  Bello ma non bellissimo', 4, 1),
(4, 3, 'Fa schifo', 3, 1),
(5, 4, 'Bello, ma ingiocabile', 3.5, 1),
(6, 5, 'Non parlo italiano quindi non mi piace', 1, 1);

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
(2, 1, 1, '1111-11-11', 0),
(3, 2, 1, '1111-11-11', 0),
(4, 3, 1, '1111-11-11', 0),
(5, 4, 1, '1111-11-11', 0),
(6, 5, 1, '2017-06-12', 1530);

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
(1, 'prova', '$2a$12$RAuYWqucaqKZkZXMKCFeUujB.N3exT0.mbxfo.2WoulNjAfafqX62', 'prova', 'prova', '1111-11-11', 'prova@hotmail.it', 'moderator'),
(2, 'a', '$2a$12$MAKDkzO/BayxYXBacbDkP.O5iW/tn97hPBXlUtSrvYwwaiyNqJttm', 'utente1', 'a', '1111-11-11', 'a@hotmail.it', 'user'),
(3, 'b', '$2a$12$u.zqTefB928jJAHC7wCJSOnrpKmhywQAwPbqt2xMyFDj11qdWmtL2', 'b', 'b', '1111-11-11', 'b@hotmail.it', 'user'),
(4, 'c', '$2a$12$Nd3DK9ehPB9mYU6nftU6a.FSRmx6pUiBgPt7HEpgL9.TedJuwvEB.', 'c', 'c', '1111-11-11', 'c@hotmail.it', 'user'),
(5, 'h', '$2a$12$Q4RWoSRJSGFkiqT6VF2wmOydzH.7yNPUT4VIMi7FB/jM5llAzo9dC', 'h', 'h', '1955-11-11', 'h@hotmail.it', 'user');

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
  MODIFY `achievement_ottenuti_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `game_profile`
--
ALTER TABLE `game_profile`
  MODIFY `game_profile_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT per la tabella `gioco`
--
ALTER TABLE `gioco`
  MODIFY `gioco_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT per la tabella `recensione`
--
ALTER TABLE `recensione`
  MODIFY `recensione_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT per la tabella `timeline`
--
ALTER TABLE `timeline`
  MODIFY `timeline_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
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
  ADD CONSTRAINT `achievement_ottenuti_ibfk_1` FOREIGN KEY (`achievement_id`) REFERENCES `achievement` (`achievement_id`),
  ADD CONSTRAINT `achievement_ottenuti_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `utente` (`user_id`);

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
