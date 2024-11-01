package com.example.btnjava.Utils;

//import com.example.btnjava.Model.Entity.MotelEntity;
//import com.example.btnjava.Model.Entity.UserEntity;
//import com.example.btnjava.Repository.MotelRepository;
//import com.example.btnjava.Repository.UserRepository;
//import com.github.javafaker.Faker;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//@Component
public class FakeData {
//    @Autowired
//    private MotelRepository motelRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostConstruct
//    public void Fake(){
//        Faker faker = new Faker(new Locale("vi"));
//        List<UserEntity> userEntities = new ArrayList<>();
//        for(int i = 0; i < 5; i++){
//            UserEntity user = new UserEntity();
//            user.setName(faker.name().fullName());
//            user.setPhoneNumber(faker.phoneNumber().cellPhone());
//            user.setIsAdmin(0);
//            userEntities.add(user);
//        }
//        userRepository.saveAll(userEntities);
//
//        for (int i = 0; i < 20; i++) {
//            MotelEntity motelEntity = new MotelEntity();
//            motelEntity.setTitle("nha dep vl");
//            motelEntity.setHouseNumber(faker.number().numberBetween(1, 500));
//            motelEntity.setStreet(faker.address().streetName());
//            motelEntity.setWard(faker.address().cityName());
//            motelEntity.setDistrict(faker.address().state());
//            motelEntity.setProvince(faker.address().state());
//            motelEntity.setArea(faker.number().numberBetween(20, 200));
//            motelEntity.setPrice(faker.number().numberBetween(500000, 5000000));
//            motelEntity.setInterior("full do");
//            motelEntity.setDetail(faker.lorem().paragraph(2));
//            motelEntity.setMaxPeople(faker.number().numberBetween(1, 6));
//            motelEntity.setStatus(0);
//            motelEntity.setUser(userEntities.get(i%5));
//            motelRepository.save(motelEntity);
//        }
//    }
}
