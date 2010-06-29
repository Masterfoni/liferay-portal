alter table AssetEntry add classUuid VARCHAR(75) null;

alter table DLFileEntry add extension VARCHAR(75) null;

alter table MBMessage add rootMessageId LONG;

COMMIT_TRANSACTION;

update MBMessage m set m.rootMessageId = (select rootMessageId from MBThread where m.threadId);

alter table Layout add uuid_ VARCHAR(75) null;

alter table PasswordPolicy add minSymbols INTEGER;

alter table User_ add facebookId LONG;

alter table WikiPageResource add uuid_ VARCHAR(75) null;