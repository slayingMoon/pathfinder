package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.dto.UserRegistrationDto;
import bg.softuni.pathfinder.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AuthService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void register(UserRegistrationDto registrationDto) {
        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            throw new RuntimeException("passwords don't match");
        }

        Optional<User> userByEmail = this.userRepository.findByEmail(registrationDto.getEmail());

        if (userByEmail.isPresent()) {
            throw new RuntimeException("Email is used");
        }

        User user = modelMapper.map(registrationDto, User.class);

        this.userRepository.save(user);

    }
}
