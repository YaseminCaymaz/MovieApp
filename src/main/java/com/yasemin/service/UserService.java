package com.yasemin.service;

import com.yasemin.dto.request.LoginRequestDto;
import com.yasemin.dto.request.RegisterRequestDto;
import com.yasemin.dto.response.LoginResponseDto;
import com.yasemin.dto.response.RegisterResponseDto;
import com.yasemin.entity.User;
import com.yasemin.mapper.UserMapper;
import com.yasemin.repository.UserRepository;
import com.yasemin.utility.EStatus;
import com.yasemin.utility.EUserType;
import com.yasemin.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserService implements ICrudService<User,Long> {
    private final UserRepository userRepository;
    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> t) {
        return null;
    }

    @Override
    public Optional<User> findById(Long aLong) {
       Optional<User> user = userRepository.findById(aLong); //Optional<User// >
        if (user.isPresent())
            return user;
        else
            throw new NullPointerException("User not found");
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty())
            throw new NullPointerException("Users not found");
        return users;
    }

    @Override
    public User delete(User entity) {
       return null;
    }

    @Override
    public User deleteById(Long aLong) {
        Optional<User> user=userRepository.findById(aLong);
        if (user.isPresent()){
            user.get().setStatus(EStatus.INACTIVE);
            return userRepository.save(user.get());
        }else
            throw new NullPointerException("User not found");
    }
    public User register(String name,String surname,String email,String password, String repassword) {
        if(!password.equals(repassword) || password.isBlank())
            throw  new RuntimeException("Passwords do not match");
        User user=User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .password(password)
                    .repassword(repassword)
                    .build();
        return userRepository.save(user);

    }

    public User login(String email, String password) {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password); //Optional<User>
        if (user.isEmpty())
            throw new RuntimeException("User not found");
        return user.get();
    }

    public RegisterResponseDto registerDto(RegisterRequestDto dto) {
        User user =User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .repassword(dto.getRePassword())
                .build();
        if (user.getPassword().equals(user.getRepassword()) || user.getPassword().isBlank())
           throw new RuntimeException("Passwords do not match");
        userRepository.save(user);
        //RequestDto->user->ResponseDto
        //User ın içini Rquestdto ile,Responsen ın içini user ile döndürür.
        return  RegisterResponseDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .status(user.getStatus())
                .build();
    }

    public LoginResponseDto loginDto(LoginRequestDto dto) {
      Optional<User> user = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
      if (user.isEmpty())
          throw new RuntimeException("Email or password is wrong");
      return LoginResponseDto.builder()
              .email(user.get().getEmail())
              .build();
    }

    public LoginResponseDto loginMapper(LoginRequestDto dto) {
        Optional<User> user = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (user.isEmpty())
            throw new RuntimeException("Email or password is wrong");
        return UserMapper.INSTANCE.fromUserToLoginResponseDto(user.get());
    }

    public RegisterResponseDto registerMapper(RegisterRequestDto dto) {
        User user =UserMapper.INSTANCE.fromRegisterRequestDtoToUser(dto);
        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new RuntimeException("Email already exists");
        if (user.getPassword().equals(user.getRepassword()) || user.getPassword().isBlank())
            throw new RuntimeException("Passwords do not match");
        if (user.getEmail().equals("ba.admin@email.com")){
            user.setStatus(EStatus.ACTIVE);
            user.setUserType(EUserType.ADMIN);
        }
        userRepository.save(user);
        return UserMapper.INSTANCE.fromUserToRegisterResponseDto(user);
    }

    public List<User> findAllAndSortByName() {
        List<User> users = userRepository.findAllAndSortByName();
        if (users.isEmpty())
            throw new NullPointerException("Users not found");
        return users;

    }

    public User findByName(String name) {
        Optional<User> user = userRepository.findByName(name);
        if (user.isEmpty())
            throw new NullPointerException("User not found");
        return user.get();
    }

    public List<User> findByNameContains(String name) {
        List<User> users = userRepository.findByNameContains(name);
        if (users.isEmpty())
            throw new NullPointerException("Users not found");
        return users;
    }

    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty())
            throw new NullPointerException("User not found");
        return user.get();
    }
}
