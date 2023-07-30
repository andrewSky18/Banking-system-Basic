package crud.crud.service;

import crud.crud.domain.JwtAuthenticationResponse;
import crud.crud.domain.SignInRequest;
import crud.crud.domain.SignUpRequest;

public interface IAuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signIn(SignInRequest request);
}