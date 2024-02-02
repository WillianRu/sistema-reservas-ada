package org.adaschool.sistemareservasada.application.service;

import org.adaschool.sistemareservasada.application.mapper.UserMapper;
import org.adaschool.sistemareservasada.domain.dto.MovieDTO;
import org.adaschool.sistemareservasada.domain.dto.UserAccountDTO;
import org.adaschool.sistemareservasada.domain.entity.Movie;
import org.adaschool.sistemareservasada.domain.entity.UserAccount;
import org.adaschool.sistemareservasada.domain.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record UserAccountService(
        UserAccountRepository userRepository,
        UserMapper mapper
) {
    public void createUser(UserAccountDTO userAccountDTO) {
        UserAccount user = mapper.toEntity(userAccountDTO);
        userRepository.save(user);
    }

    public List<UserAccountDTO> findAllUsers() {
        List<UserAccount> users =  userRepository.findAll();
        return mapper.toDtoList(users);
    }

    public UserAccountDTO findUserById(Integer id) throws Exception{
        UserAccount user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found"));
        return mapper.toDto(user);
    }

    public void updateUser(Integer id, UserAccountDTO userDTO) throws Exception {
        userRepository.findById(id).orElseThrow(()-> new Exception("DATA NOT FOUND"));
        UserAccount user = mapper.toEntity(userDTO);
        user.setId(id);
        userRepository.save(user);
    }

    public void deleteUser(Integer id) throws Exception{
        UserAccount user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("Movie not found"));
        userRepository.delete(user);
    }
}
