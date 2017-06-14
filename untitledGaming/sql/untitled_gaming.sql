-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Giu 13, 2017 alle 19:46
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
(15, 6, 6);

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
(6, 5, 7, 1530),
(7, 6, 8, 2010),
(8, 7, 1, 0);

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
(5, 'The Witcher 3');

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
(6, 5, 1, '2017-06-12', 1530),
(7, 6, 1, '2017-06-13', 1290),
(8, 7, 1, '2001-01-01', 0);

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
(7, 'l', '$2a$12$W5kJzWlAVX0VzQqdt9fDuexUCesOapl7k6OYk0VHnPT2DiB5TpWlO', 'l', 'l', '2001-01-01', 'l@l.com', 0x89504e470d0a1a0a0000000d494844520000003f0000003c0806000001a6cc52e7000000097048597300000ec400000ec401952b0e1b000000206348524d00007a25000080830000f9ff000080e9000075300000ea6000003a980000176f925fc546000007754944415478da6c8e410a80400cc432d5bb5f723fae7d98502fbb5046033da4045a6526c600ee25c197ab8b079bd7019c40cd79e67e79059080f847fd8447f21fcac20360b7205a54805e000000ffff62c4120e0cf8bcb98590026f24b730c0dcf01f8bc930b1cf4c50076dc716060c0c0c7c302bbcd0241fe172c352282d87ec060606060661a4008a61606050852900000000ffff420b076c51f2ff0b0303030f91e1f41f1dff676060e0666060502236a091410b12fb2e2e452c58c216d313ffff33303232a2cbc73030302c65c112001c0c0c0cdf512284111e366f181818440979c10b8fb744880983b5505a01ea2a183e0b15bf83ac18000000ffff22949ced1918180e9290dc19d130c35e060280403a606066606058444a864306ee503a965c0316301001f0192081c45e86cf809fd832019aba481c6a4c99181818d81918189c1948078c0c0c0ca799904a6c462235ce4656cb82c5d4dd0c0c0c2e3834f33030307c251488bc786cff4a4c2c98e331209d9001dc687c5668f50303330819b0044a7f8186c71f689dc9456c420a606060b0c5120edfa106fe62606028449600000000ffffc496314b03411085bf950431a96cec5269a36d0a8ba43456013b11c11f903a6d0a7f40fa80ad5884a40a28a44eaa400a8b94767260637b271236cd242cb8ecdeed421c583876ef66de2d33ef3daf3a796205bc03f7a1090e228a5f0317d2e5a7ff01c094eae5be01cca4c330ec487f5f00ce81a665bfeb126097aebe01494e2ed140cb713e150dcacb4bc72591d1b200b9ca4d854aa1f51f2f7026cb172f620c7664f86bfcd921f0ed1afeaddb28189fe29a3f7c3df02394a6801b604d5c5c4aae9acd63f99a7022b7f41050b8238517b15350059e03000c6c562c0480cb59a52e572a541d05a001d42dfb6db9de8ae450c0ada55f4e80c7180073e37928fda08057cbbb23e3dc14ee1e70140260057c1946f5aec0443c6dbfcbb274acb54e500adbda106706af1044711cffcca624d1ee7509375b528a8375c14971544e2245b2a528c54114ed99036e8efe00270737076e6a4f3872d9724114456f1ce6b7d9b6b76f66deccac57d3ccbc796f3e33efcdfbfd7edfdf4475c7f740ee3f3c21406f94ce2973bc69dc2ae26d2e01b86bdc1cc75d90865b8d1ef6b4eb9295e35c4d2c90387cb9667e661b09dff40bcc9382f70099108a2156f8509dfae946c0d7ead41f260d6f01f275ae756834976fa079067c056cdf6c78600738e12fe9e8fbe24dc09b4423719430d6ee2205144420869baf5424b730064c56ee702ecaf429686fa5940db404b457a2a5eac7ff00ba817d922945600078377ded3b6248ca31415d314adb4197da2390056e22824bc278b559e723a2df6dcaa20c7324237309bc84047f02a77158b83e8d23096209c7e3802f590e7b210ef8bc257c222abc1f481bae9be2ee36e96f0d5f31acdd5199d79cc1991c4481cf68ea6ef1fe3c5cc9f9830490d79ab6a3a6548a099ec1fb1f448dfe1ac4cb44ea04e6aec6650fdbc0a734e153d167a4f6c4323e57d5addbc08f657f276f10343958063a81a32a691d0ade2aae6f032f351a3667f30dac2aa5ba94fa71709cbc4ea5fe926ffea04d846118ff7dc925a94da11a8d1ac56650eb122d42c14e966eed205a751284aa2842ad8a8ae25ad14111113791eae2ec6846a9b3288a38382888108ab622182cb55787f7058f70392f97dce54f5fc872975cbee7bbfbdeef799ff7b97aabd47ae238d2ddb9ef414a438d5893806f07ee38b68fec6a01df1b8b99bbc026473abaa2e9aba3c1c781d3b6bd32ea389600ce7825864e01bf5bb942aa52f5d0759fef54f0dd0ab050e5fc1070d66562da1ebc059cc0bb951847ba7d23f8efeeb405f81c30c1ff45bc3c7055a58f8e009f528a35e8f3fb23c0141e1a7e3b811f0e50104d12ccb551f35a4c0336de3da5c07b3a7001c8d4f8bb3430ae654a39847119d4b1f7cda574590d518a21adca98d662cb61ffa331c669798b3ae690fe410ec8c51c65f9b42e833ee0111eaec07ac2ab7d1fd2c42c2346a48c52ea8740a95ac2fb82c8453b34593dc3bf781e78028c31d8b6cdd2d252107f839bc6f20a510c2dd562166acdf6b3c06195344e02efc27a1ed53e8a655941effe1fc4027354710d225a6ddd5bdd6fe031b04733f1017d425a213e20da521618e59fa935947dbe8c78bffa10b7d30d5cec8521c73c3003ec55a5e7265594f83049ce27a49fd183086ea59041ff40d4ff8dc029e04d2b30bc0d5ab86c0e19fc5a607fa3c6dd28f04710735814714c93af6905f03b11b7632222f016704ed77a53c1a781eb38deec88280acad4d63413fc04c16c46bf944865f4119e0d708d295dff4d013fa4fb6bbc86ede9a952cc1ea5d00bca1f86956f4f23afb8f88d19a03f6af009c4e9dceb8357bfd03bb41e7144cd55abb2b4b8caeaf5eff918c7169db0ee28c1ef03ce7bacb9af7ade5265e66500aa7a49337a012852bd077a10d1fee251805f8738fab6551c7f8bd8cfb6228dba070d4a6eef813120a94fcec70ae1a54bd77f3e0af0977530003f815b4a730780db884f3f94da477346bf92aa31e035b0628c19002e624cbc9a75d6ed6305d862c681cf88b7eb09f0bd09c5cc3c50b46dbbb8b858de65dbf6b554b2eb5022997c8efb3b9caef1770031616a1d0617c9e00000000049454e44ae426082, 'user');

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
  MODIFY `achievement_ottenuti_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT per la tabella `game_profile`
--
ALTER TABLE `game_profile`
  MODIFY `game_profile_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT per la tabella `gioco`
--
ALTER TABLE `gioco`
  MODIFY `gioco_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `recensione`
--
ALTER TABLE `recensione`
  MODIFY `recensione_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT per la tabella `timeline`
--
ALTER TABLE `timeline`
  MODIFY `timeline_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
