package com.sample.Authentication.service;
import com.sample.Authentication.Repository.UserRepository;
import com.sample.Authentication.cn.APIResponse;
import com.sample.Authentication.dto.LoginDto;
import com.sample.Authentication.dto.SignupDto;
import com.sample.Authentication.model.User;
import net.bytebuddy.description.ByteCodeElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    public APIResponse signup(SignupDto signupDto) {
        APIResponse apiResponse = new APIResponse();
        User userentity = new User();
        userentity.setName(signupDto.getName());
        userentity.setEmail(signupDto.getEmail());
        userentity.setPhoneNumber(signupDto.getPhoneNumber());
        userentity = userRepository.save(userentity);
        String token =generateToken(userentity);
        apiResponse.setData(data);
        return apiResponse;
    }
    public APIResponse login(LoginDto loginDto)
    {
        APIResponse apiResponse = new APIResponse();
        User user = userRepository.findAllByEmailId(loginDto.getEmail(), loginDto.getPassword());
        data.put("accessToken",token);
        apiResponse.setData(data);
        return apiResponse;
    }
}