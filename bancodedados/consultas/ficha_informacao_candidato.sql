use sgdis;

-- Ficha de Informação do Candidato
SELECT pg.nome pgNome, pg.abreviatura pgAbrev, qq.nome qqNome,
cid.nome cidNatNome, est.nome estNatNome,
ec.nome ecNome,
comp.nome compNome,
alu.*,
taf.dataulttaf tafDataUlt, taf.mencao tafMencao,
u.tamcoturno coturno, u.tamgandola gandola, u.tamcalca calca, u.tamcamisacamuflada camcamuflada
FROM Aluno alu
INNER JOIN PostoGraduacao pg ON pg.id = alu.idPostoGraduacao
INNER JOIN QasQms qq ON qq.id = alu.idQasQms
INNER JOIN Cidade cid ON cid.id = alu.idNaturalidadeCidade
INNER JOIN Estado est ON est.id = cid.idEstado
INNER JOIN EstadoCivil ec ON ec.id = alu.idEstadoCivil
-- OM
INNER JOIN Comportamento comp ON comp.id = alu.idComportamento
INNER JOIN TAF taf ON taf.id = alu.idTAF
INNER JOIN Uniforme u ON u.id = alu.idUniforme
WHERE alu.identidade = '1277754444';