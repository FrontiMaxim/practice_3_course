package com.example.demo.services;

import com.example.demo.mappers.*;
import com.example.demo.models.*;
import com.example.demo.repository.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.*;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.json.XML;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Service
public class FileService {

    private final Ed807Repository ed807Repository;
    private final BicDirectoryEntryRepository bicDirectoryEntryRepository;
    private final ParticipantInfoRepository participantInfoRepository;
    private final RstrListRepository rstrListRepository;
    private final AccountRepository accountRepository;
    private final AccRstrListRepository accRstrListRepository;

    public FileService(Ed807Repository ed807Repository, BicDirectoryEntryRepository bicDirectoryEntryRepository, ParticipantInfoRepository participantInfoRepository, RstrListRepository rstrListRepository, AccountRepository accountRepository, AccRstrListRepository accRstrListRepository) {
        this.ed807Repository = ed807Repository;
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
        this.participantInfoRepository = participantInfoRepository;
        this.rstrListRepository = rstrListRepository;
        this.accountRepository = accountRepository;
        this.accRstrListRepository = accRstrListRepository;
    }

    public JSONObject parsingStringtoJSON(String data) {
        byte[] dataBytes = data.getBytes();
        return XML.toJSONObject(new String(dataBytes, Charset.forName("cp1251")), true);
    }

    public Ed807Mapper deserializationJson(JSONObject data) {

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
                .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Ed807Mapper parseED807 = new Ed807Mapper();

        try {
            parseED807 = objectMapper.readValue(data.toString(), Ed807Mapper.class);
            System.out.println("Xml file parsing completed!");
        }
        catch (JsonMappingException error) {
            error.printStackTrace();
        }
        catch (JsonGenerationException error) {
            error.printStackTrace();
        }
        catch (IOException error) {
            error.printStackTrace();
        }
        finally {
            return parseED807;
        }
    }

    public void saveDatabase(Ed807Mapper data) {

        boolean isSave = false;

        if(data != null) {

            System.out.println("Start saving in the database!");

            Ed807 ed807 = new Ed807();

            ed807.setXmlns(data.getXmlns());
            ed807.setEdNo(data.getEdNo());
            ed807.setEdDate(data.getEdDate());
            ed807.setEdAuthor(data.getEdAuthor());
            ed807.setCreationReason(data.getCreationReason());
            ed807.setCreationDateTime(data.getCreationDateTime());
            ed807.setInfoTypeCode(data.getInfoTypeCode());
            ed807.setBusinessDay(data.getBusinessDay());
            ed807.setDirectoryVersion(data.getDirectoryVersion());

            ed807Repository.save(ed807);

            List<BicDirectoryEntryMapper> listDirectoryEntryMapper = data.getListBicDirectoryEntry();
            for(BicDirectoryEntryMapper i1 : listDirectoryEntryMapper) {
                BicDirectoryEntry bicDirectoryEntry = new BicDirectoryEntry();

                bicDirectoryEntry.setBic(i1.getBic());
                bicDirectoryEntry.setEd807(ed807);
                bicDirectoryEntryRepository.save(bicDirectoryEntry);

                List<ParticipantInfoMapper> listParticipantInfoMapper = i1.getListParticipantInfo();

                if(listParticipantInfoMapper != null) {
                    for(ParticipantInfoMapper i2 : listParticipantInfoMapper) {
                        ParticipantInfo participantInfo = new ParticipantInfo();

                        participantInfo.setNameP(i2.getNameP());
                        participantInfo.setCntrCd(i2.getCntrCd());
                        participantInfo.setRgn(i2.getRgn());
                        participantInfo.setInd(i2.getInd());
                        participantInfo.setTnp(i2.getTnp());
                        participantInfo.setAdr(i2.getAdr());
                        participantInfo.setDateIn(i2.getDateIn());
                        participantInfo.setPtType(i2.getPtType());
                        participantInfo.setSrvcs(i2.getSrvcs());
                        participantInfo.setXchType(i2.getXchType());
                        participantInfo.setUid(i2.getUid());
                        participantInfo.setBicDirectoryEntry(bicDirectoryEntry);

                        participantInfoRepository.save(participantInfo);

                        List<RstrListMapper> listRstrListMapper = i2.getListRstrList();

                        if(listRstrListMapper != null) {
                            for(RstrListMapper i3 : listRstrListMapper) {
                                RstrList rstrList = new RstrList();

                                rstrList.setRstr(i3.getRstr());
                                rstrList.setRstrDate(i3.getRstrDate());
                                rstrList.setParticipantInfo(participantInfo);

                                rstrListRepository.save(rstrList);
                            }
                        }
                    }
                }


                List<AccountMapper> listAccountMapper = i1.getListAccount();
                if(listAccountMapper != null) {
                    for(AccountMapper i2 : listAccountMapper) {
                        Account account = new Account();

                        account.setAccount(i2.getAccount());
                        account.setRegulationAccountType(i2.getRegulationAccountType());
                        account.setAccountCbrbic(i2.getAccountCbrbic());
                        account.setDateIn(i2.getDateIn());
                        account.setAccountStatus(i2.getAccountStatus());
                        account.setCk(i2.getCk());
                        account.setBicDirectoryEntry(bicDirectoryEntry);

                        accountRepository.save(account);

                        List<AccRstrListMapper> listAccRstrListMapper = i2.getListAccRstrList();

                        if(listAccRstrListMapper != null) {
                            for (AccRstrListMapper i3 : listAccRstrListMapper) {
                                AccRstrList accRstrList = new AccRstrList();

                                accRstrList.setAccRstr(i3.getAccRstr());
                                accRstrList.setAccRstrDate(i3.getAccRstrDate());
                                accRstrList.setAccount(account);

                                accRstrListRepository.save(accRstrList);
                            }
                        }
                    }
                }
            }

            System.out.println("Xml file saved to database!");
        }
    }
}
