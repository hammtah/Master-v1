--creation des vues qui vont nous servir à ajouter des clés primaires à nos tables sans les touchés

--ETUDIANT
CREATE VIEW etudiant_v As select nom, prenom, D_Naiss, sexe, tele, email, password_, nationalite, cin, massar from etudiant;

CREATE SEQUENCE etudiant_seq;

CREATE OR REPLACE TRIGGER etud_v_t INSTEAD OF INSERT ON etudiant_v
FOR EACH ROW
BEGIN 
  INSERT INTO etudiant VALUES(etudiant_seq.NEXTVAL, :NEW.nom, :NEW.prenom, :NEW.D_Naiss, :NEW.sexe, :NEW.tele, :NEW.email, :NEW.password_, :NEW.nationalite, :NEW.cin, :NEW.massar);
END;
/
INSERT INTO etudiant_v VALUES ('OMAR', 'ALADIN',to_date('1995-05-15', 'YYYY-MM-DD'), 'M', '123456789', 'omar.aladin@example.com', 'password1', 'Moroccan', 'DO123', 'M12345');

--INFO-ACCADEMIQUE

CREATE VIEW info_accademique_v As select d_graduation, d_bac, fil_bac, moy_licence, moy_bac, n_s1, n_s2, n_s3, n_s4,n_s5, n_s6, document, photo,id_fil_licence, id_etudiant, id_faculte from info_accademique;

CREATE SEQUENCE info_accademique_seq;

CREATE OR REPLACE TRIGGER info_accademique_v_t INSTEAD OF INSERT ON info_accademique_v
FOR EACH ROW
BEGIN 
  INSERT INTO info_accademique  VALUES (info_accademique_seq.NEXTVAL, :NEW.d_graduation, :NEW.d_bac, :NEW.fil_bac, :NEW.moy_licence, :NEW.moy_bac, :NEW.n_s1, :NEW.n_s2, :NEW.n_s3, :NEW.n_s4, :NEW.n_s5, :NEW.n_s6, :NEW.document, :NEW.photo, :NEW.id_fil_licence, :NEW.id_etudiant, :NEW.id_faculte);
END;
/
