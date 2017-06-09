-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Giu 09, 2017 alle 13:51
-- Versione del server: 5.7.18
-- Versione PHP: 7.0.19

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
  `achievement_id` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `descrizione` varchar(300) NOT NULL,
  `gioco_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `achievement`
--

INSERT INTO `achievement` (`achievement_id`, `nome`, `descrizione`, `gioco_id`) VALUES
(1, '100 esp!', 'bla', 1),
(2, '200 esp!', 'blabla', 1),
(3, '100 esp!', 'bla nn', 2),
(4, 'evvia!', 'hai vinto', 4);

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
(1, 1, 4),
(2, 1, 2),
(3, 2, 1),
(4, 5, 2),
(7, 5, 3),
(8, 5, 4),
(9, 5, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `game_profile`
--

CREATE TABLE `game_profile` (
  `game_profile_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `livello` int(3) NOT NULL,
  `punti_esperienza` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dump dei dati per la tabella `game_profile`
--

INSERT INTO `game_profile` (`game_profile_id`, `user_id`, `livello`, `punti_esperienza`) VALUES
(1, 1, 3, 61600),
(2, 2, 2, 150),
(3, 1, 1, 0),
(4, 2, 1, 0),
(5, 3, 1, 0),
(6, 4, 1, 0),
(7, 5, 4, 450);

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
(1, 'pac man'),
(2, 'gioco1'),
(3, 'Space Invaders'),
(4, 'Snake 2017 ');

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
(1, 1, 'Bene ma non benissimo', 3.5, 1);

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
(1, 1, 1, '2017-06-06', 200),
(2, 2, 1, '2017-06-28', 777),
(3, 5, 1, '2017-06-09', 0);

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
  `email` varchar(25) NOT NULL,
  `data_di_nascita` date NOT NULL,
  `tipo` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`user_id`, `username`, `password`, `nome`, `cognome`, `email`, `data_di_nascita`, `tipo`) VALUES
(1, 'paoluccio545', '$2a$12$waMDxRWSmpRoSZbajEPM0.zMtUPJPEVOc1XOWLNJh2JO3bc0jE0wO', 'asdasd', 'paoluccio656', 'asdasd', '1111-11-11', 'user'),
(2, 'kep', '$2a$12$m72XncBhpsS5vs0s1WPQNe.pUaE3SMdzZIGzXJnrStfqLw/XqSTae', 'a', 'kep12345', 'd', '1111-11-11', 'user'),
(3, 'axx', '$2a$12$ZBkP7K9Fhs/eUD9DNqf2KO4t1SLUi6gx9CRdc2XR6sMdOOwz1yrc2', 'a', 'ax', 'ax', '1111-11-11', 'user'),
(4, 'mikeshx', '$2a$12$PuaaDPncq9G6RlOO4MT6uO7M.wWpo5bBO8GWqA0eNpFTmnzDNIknq', 'Stefano', 'asd', 'ad', '1111-11-11', 'user'),
(5, 'a', '$2a$12$o.CGIK80kucnV/qEtsJb0.n.IrSgmUozp/vIOc9T76gi5hGezyKdW', 'a', 'a', 'a', '1111-11-11', 'user');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `achievement`
--
ALTER TABLE `achievement`
  ADD PRIMARY KEY (`achievement_id`),
  ADD KEY `id_gioco` (`gioco_id`);

--
-- Indici per le tabelle `achievement_ottenuti`
--
ALTER TABLE `achievement_ottenuti`
  ADD PRIMARY KEY (`achievement_ottenuti_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `id_achievement` (`achievement_id`);

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
  MODIFY `achievement_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT per la tabella `achievement_ottenuti`
--
ALTER TABLE `achievement_ottenuti`
  MODIFY `achievement_ottenuti_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT per la tabella `game_profile`
--
ALTER TABLE `game_profile`
  MODIFY `game_profile_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT per la tabella `gioco`
--
ALTER TABLE `gioco`
  MODIFY `gioco_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT per la tabella `recensione`
--
ALTER TABLE `recensione`
  MODIFY `recensione_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT per la tabella `timeline`
--
ALTER TABLE `timeline`
  MODIFY `timeline_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
