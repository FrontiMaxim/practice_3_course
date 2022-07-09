package com.example.demo.services;

import com.example.demo.mappers.*;
import com.example.demo.maskes.MaskInfoFile;
import com.example.demo.models.*;
import com.example.demo.repository.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.*;
import com.zaxxer.hikari.util.FastList;
import org.json.JSONObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.json.XML;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    private final Ed807Repository ed807Repository;
    private final BicDirectoryEntryRepository bicDirectoryEntryRepository;
    private final ParticipantInfoRepository participantInfoRepository;
    private final RstrListRepository rstrListRepository;
    private final AccountRepository accountRepository;
    private final AccRstrListRepository accRstrListRepository;
    private final SwbicRepository swbicRepository;
    private final FileRepository fileRepository;

    public FileService(Ed807Repository ed807Repository, BicDirectoryEntryRepository bicDirectoryEntryRepository, ParticipantInfoRepository participantInfoRepository, RstrListRepository rstrListRepository, AccountRepository accountRepository, AccRstrListRepository accRstrListRepository, SwbicRepository swbicRepository, DirectoryRepository directoryRepository, FileRepository fileRepository) {
        this.ed807Repository = ed807Repository;
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
        this.participantInfoRepository = participantInfoRepository;
        this.rstrListRepository = rstrListRepository;
        this.accountRepository = accountRepository;
        this.accRstrListRepository = accRstrListRepository;
        this.swbicRepository = swbicRepository;
        this.fileRepository = fileRepository;
    }

    public JSONObject parsingStringtoJSON(String data) {
        byte[] dataBytes = data.getBytes();
        return XML.toJSONObject(new String(dataBytes, Charset.forName("cp1251")), true);
    }

    public FileMapper deserializationJson(JSONObject data) {

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
                .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        FileMapper parseFileMapper = new FileMapper();

        try {
            parseFileMapper = objectMapper.readValue(data.toString(), FileMapper.class);
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
            return parseFileMapper;
        }
    }

    public void saveDatabase(FileMapper data) {

        if(data != null) {
            System.out.println("Start saving in the database!");

            File file = new File();

            file.setIdFile(data.getIdFile());
            file.setNameFile(data.getNameFile());

            fileRepository.save(file);

            Ed807Mapper ed807Mapper = data.getEd807Mapper();

            if(ed807Mapper != null) {

                Ed807 ed807 = new Ed807();

                ed807.setXmlns(ed807Mapper.getXmlns());
                ed807.setEdNo(ed807Mapper.getEdNo());
                ed807.setEdDate(ed807Mapper.getEdDate());
                ed807.setEdAuthor(ed807Mapper.getEdAuthor());
                ed807.setCreationReason(ed807Mapper.getCreationReason());
                ed807.setCreationDateTime(ed807Mapper.getCreationDateTime());
                ed807.setInfoTypeCode(ed807Mapper.getInfoTypeCode());
                ed807.setBusinessDay(ed807Mapper.getBusinessDay());
                ed807.setDirectoryVersion(ed807Mapper.getDirectoryVersion());
                ed807.setFile(file);

                ed807Repository.save(ed807);

                List<BicDirectoryEntryMapper> listDirectoryEntryMapper = ed807Mapper.getListBicDirectoryEntry();
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
                            participantInfo.setNnp(i2.getNnp());
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

                    List<SwbicMapper> listSwbicMapper = i1.getListSwbic();
                    if(listSwbicMapper != null) {
                        for(SwbicMapper i2 : listSwbicMapper) {
                            Swbic swbic = new Swbic();

                            swbic.setSwbic(i2.getSwbic());
                            swbic.setDefaultSwbic(i2.getDefaultSwbic());
                            swbic.setBicDirectoryEntry(bicDirectoryEntry);

                            swbicRepository.save(swbic);
                        }
                    }
                }
            }

            System.out.println("Xml file saved to database!");
        }
    }

    public File getFile(Long id) {

        Optional<File> data = fileRepository.findById(id);
        File file = new File();

        if(data.isPresent()) {
            file = data.get();
        }

        return file;
    }

    public ArrayList<MaskInfoFile> getFiles() {

        String[] arrayString = fileRepository.findAllFiles();
        ArrayList<MaskInfoFile> list = new ArrayList<>();

        for(String i : arrayString) {
            String[] items = i.split(",");
            MaskInfoFile infoFile = new MaskInfoFile();
            infoFile.setIdFile(items[0]);
            infoFile.setNameFile(items[1]);
            list.add(infoFile);
        }

        return list;
    }
}
