use sgdis;

-- Ficha de Informação do Candidato
SELECT pg.nome pgNome, pg.abreviatura pgAbrev, qq.nome qqNome,
cid.nome cidNatNome, est.nome estNatNome, est.sigla estSigla,
ec.nome ecNome,
comp.nome compNome,
f.nome fNome,
alu.cpf aluCpf, IFNULL(alu.cp, "-") aluCP, IFNULL(alu.preccp, "-") aluPreccp, 
alu.nome aluNome, alu.sobrenome aluSobrenome, alu.nomeguerra aluNGuerra, alu.identidade aluIdt, alu.datanascimento aluDtNasc,
alu.email aluEmail, fone.numero aluFone, IF(alu.fumante=0, "NÃO", IF(alu.fumante=1, "SIM", "-"))  aluFumante,
alu.ts aluTS, alu.ftrh aluFtrh, IF(alu.pai="", "-", IF(alu.pai=NULL, "-", alu.pai)) aluPai, IF(alu.mae="", "-", IF(alu.mae=NULL, "-", alu.mae))aluMae,
alu.ultfuncao1 aluUltFun1, alu.ultfuncao2 aluUltFun2, alu.ultfuncao3 aluUltFun3, alu.ultdatapraca aluPraca,
IF(alu.eas=0, "NÃO", IF(alu.eas=1, "SIM", "")) aluEas,
te.registro teRegistro, te.zona teZona, te.secao teSecao, cidTe.nome teCid, ufTe.sigla teUf,
taf.dataulttaf tafDataUlt, taf.mencao tafMencao,
u.tamcoturno coturno, u.tamgandola gandola, u.tamcalca calca, u.tamcamisacamuflada camcamuflada,
om.nome omNome, om.abreviatura omAreviatura, om.numendereco omNum,
endOM.cep endOMCep, endOM.descricao endOMDesc, endOM.bairro endOMBairro, 
IF(endOM.complemento="", "", IF(endOM.complemento IS NULL, "", concat(endOM.complemento, ", "))) endOMComp,
IF(endOM.pontoreferencia="", "", IF(endOM.pontoreferencia IS NULL, "", concat(endOM.pontoreferencia, ", "))) endOMPtRef, 
cidOM.nome endOMCid, estOM.nome endOMEst, fOM.numero foneOM,
pgCmt.abreviatura cmtPg, cmt.nome cmtNome, cmt.sobrenome cmtSobrenome,
prep.prepfisica prepFisica, 
IF(prep.apoiofamilia=0, "NÃO", IF(prep.apoiofamilia=1, "SIM", "-")) prepApoioFamilia, 
IF(prep.apoioom=0, "NÃO", IF(prep.apoioom=1, "SIM", "-")) prepApoioOM, 
IF(prep.cursopreparacaocos=0, "NÃO", IF(prep.cursopreparacaocos=1, "SIM", "-")) prepCursoPrepCos, 
IF(prep.problemarendimento=0, "NÃO", IF(prep.problemarendimento=1, "SIM", "-")) prepProbRend, 
IF(prep.tempoprep=0, "NÃO", IF(prep.tempoprep=1, "SIM", "-")) prepTempo, 
IF(prep.dedicacaodoutrinaops=0, "NÃO", IF(prep.dedicacaodoutrinaops=1, "SIM", "-")) prepDedicDout, 
IF(prep.consultasite=0, "NÃO", IF(prep.consultasite=1, "SIM", "-")) prepSite, 
IF(prep.fatormotivador=0, "NÃO", IF(prep.fatormotivador=1, "SIM", "-")) prepFator, 
IF(prep.csltambvirtualal=0, "NÃO", IF(prep.csltambvirtualal=1, "SIM", "-")) prepAmbVirtual,
prom.dataultpromocao promData, prom.qapromocao promQa, 
IF(prom.dataqapromocao="", "", IF(prom.dataqapromocao IS NULL, "", concat("(", prom.dataqapromocao, ")"))) promQaData
 
FROM Aluno alu
INNER JOIN PostoGraduacao pg ON pg.id = alu.idPostoGraduacao
INNER JOIN Forca f ON f.id = pg.idForca
INNER JOIN QasQms qq ON qq.id = alu.idQasQms
INNER JOIN Cidade cid ON cid.id = alu.idNaturalidadeCidade
INNER JOIN Estado est ON est.id = cid.idEstado
INNER JOIN EstadoCivil ec ON ec.id = alu.idEstadoCivil
INNER JOIN TituloEleitor te ON te.idtAluno = alu.identidade
INNER JOIN Cidade cidTe ON cidTe.id = te.idCidade
INNER JOIN Estado ufTe ON ufTe.id = cidTe.idEstado
INNER JOIN Fone fone ON fone.idtAluno = alu.identidade
INNER JOIN Comportamento comp ON comp.id = alu.idComportamento
INNER JOIN TAF taf ON taf.id = alu.idTAF
INNER JOIN Uniforme u ON u.id = alu.idUniforme
INNER JOIN OM om ON om.id = alu.idOM
INNER JOIN Endereco endOM ON endOM.id = om.idEndereco
INNER JOIN Cidade cidOM ON cidOM.id = endOM.idCidade
INNER JOIN Estado estOM ON estOM.id = cidOM.idEstado
INNER JOIN Fone fOM ON fOM.idOM = alu.idOM
INNER JOIN Comandante cmt ON cmt.id = alu.idComandante
INNER JOIN PostoGraduacao pgCmt ON pgCmt.id = cmt.idPostoGraduacao
INNER JOIN Preparacao prep ON prep.id = alu.idPreparacao
INNER JOIN Promocao prom ON prom.id = alu.idPromocao
WHERE alu.identidade = '1212454512';

SELECT al.nome alNome
FROM Aluno_has_Alergia al_alergia
INNER JOIN Alergia al ON al.id = al_alergia.idAlergia
INNER JOIN Aluno alu ON alu.identidade = al_alergia.idtAluno
WHERE alu.identidade = '1277754444';